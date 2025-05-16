<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Registration</title>
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            background-color: #eef2f3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }
        input[type="text"], input[type="password"], select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }
        .radio-group {
            display: flex;
            justify-content: space-between;
            margin-top: 5px;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #007BFF;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 15px;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Student Registration Form</h2>
        <form action="display.jsp" method="post">
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="age">Age:</label>
            <input type="text" id="age" name="age" required>

            <label>Address (Radio Selection):</label>
            <div class="radio-group">
                <label><input type="radio" name="addressRadio" value="Cairo"> Cairo</label>
                <label><input type="radio" name="addressRadio" value="Alex"> Alex</label>
                <label><input type="radio" name="addressRadio" value="Menofia"> Menofia</label>
            </div>

            <label for="addressSelect">Select Address:</label>
            <select id="addressSelect" name="addressSelect">
                <option value="Cairo">Cairo</option>
                <option value="Alex">Alex</option>
                <option value="Menofia">Menofia</option>
            </select>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>