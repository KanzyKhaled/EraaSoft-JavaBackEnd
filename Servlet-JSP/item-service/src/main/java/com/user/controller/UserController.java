package com.user.controller;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.user.model.User;
import com.user.service.UserService;
import com.user.service.impl.UserServiceImpl;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Resource(name = "jdbc/Users")
    private DataSource dataSource;

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl(dataSource);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("signup".equals(action)) {
            handleSignup(request, response);
        } else if ("login".equals(action)) {
            handleLogin(request, response);
        }
    }

    private void handleSignup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate username length
        if (username.length() < 5) {
            request.setAttribute("errorMessage", "Username must be longer than 5 characters.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Validate password strength
        if (!isValidPassword(password)) {
            request.setAttribute("errorMessage", "Password must contain UPPER, LOWER, NUMBER, SPECIAL CHAR ($#@%&) and be at least 8 characters.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Check if username is available
        if (!userService.isUsernameAvailable(username)) {
            request.setAttribute("errorMessage", "Username already exists.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Create new user
        User newUser = new User(username, password);
        boolean success = userService.createUser(newUser);

        if (success) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("ItemController?action=load-items");
        } else {
            request.setAttribute("errorMessage", "Signup failed. Try again.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.getUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("ItemController?action=load-items");
        } else {
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&  // At least one uppercase
               password.matches(".*[a-z].*") &&  // At least one lowercase
               password.matches(".*\\d.*") &&    // At least one number
               password.matches(".*[$#@%&].*");  // At least one special character
    }
}
