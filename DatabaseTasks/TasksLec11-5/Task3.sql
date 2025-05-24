----------------------------------------------------------------------------------------------------
----- Lecture 7 ------
--------- Task 3 ---------
--------------------------

ALTER TABLE Employees_1 ADD manager_id INT;
ALTER TABLE Employees_1 ADD FOREIGN KEY (manager_id) REFERENCES MANAGER_TEST_1(manager_id);

UPDATE Employees_1 SET manager_id = 100 WHERE EMPLOYEE_ID  = 1;
UPDATE Employees_1 SET manager_id = 100 WHERE EMPLOYEE_ID = 2;
UPDATE Employees_1 SET manager_id = 101 WHERE EMPLOYEE_ID = 3;
UPDATE Employees_1 SET manager_id = 102 WHERE EMPLOYEE_ID = 4;


SELECT E.employee_name, M.manager_id  
FROM Employees_1 E  
JOIN MANAGER_TEST_1 M ON E.manager_id = M.manager_id; 

---------------------------------
CREATE TABLE customers_3 (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100),
    salesperson_id INT 
);
INSERT INTO customers_3 (customer_id, name, salesperson_id) VALUES (1, 'Alice Brown', 101);
INSERT INTO customers_3 (customer_id, name, salesperson_id) VALUES (2, 'Bob Smith', 102);
INSERT INTO customers_3 (customer_id, name, salesperson_id) VALUES (3, 'Charlie Green', 103);
INSERT INTO customers_3 (customer_id, name, salesperson_id) VALUES (4, 'Dana White', 101);


CREATE TABLE salesperson (
    employee_id INT PRIMARY KEY,
    name VARCHAR(100)
);
INSERT INTO salesperson (employee_id, name) VALUES (101, 'Emma Johnson');
INSERT INTO salesperson (employee_id, name) VALUES (102, 'Michael Lee');
INSERT INTO salesperson (employee_id, name) VALUES (103, 'Sophia Clark');
INSERT INTO salesperson (employee_id, name) VALUES (104, 'Daniel Martinez');


SELECT c.name AS Customer_Name, 
       s.name AS Salesperson_Name
FROM customers_3 c
JOIN salesperson s ON c.salesperson_id = s.employee_id;

---------------------------------

ALTER TABLE SALESORDERS ADD product_id INT;
ALTER TABLE SALESORDERS ADD FOREIGN KEY (product_id) REFERENCES products(product_id);


UPDATE SALESORDERS SET product_id = 101 WHERE ORDER_ID  = 101;
UPDATE SALESORDERS SET product_id = 102 WHERE ORDER_ID = 102;
UPDATE SALESORDERS SET product_id = 103 WHERE ORDER_ID = 103;
UPDATE SALESORDERS SET product_id = 104 WHERE ORDER_ID = 104;



SELECT O.ORDER_ID  , S.product_id 
FROM ORDERS o 
JOIN  SALESORDERS s  ON o.ORDER_ID  = s.ORDER_ID

---------------------------------

ALTER TABLE STUDENTS  RENAME COLUMN STUDENT_NAME TO NAME;

SELECT S.NAME AS StudentName, T.NAME AS TeacherName FROM STUDENTS S, TEACHER T;

---------------------------------

ALTER TABLE DEPARTMENTS ADD budget INT;

UPDATE DEPARTMENTS SET budget = 100000 WHERE DEPARTMENT_ID  = 10;
UPDATE DEPARTMENTS SET budget = 50000 WHERE DEPARTMENT_ID = 20;
UPDATE DEPARTMENTS SET budget = 20000 WHERE DEPARTMENT_ID = 30;
UPDATE DEPARTMENTS SET budget = 50000 WHERE DEPARTMENT_ID = 40;


SELECT e.FIRST_NAME , 
       e.salary AS Employee_Salary, 
       d.budget AS Department_Budget
FROM Employees e
JOIN DEPARTMENTS d ON e.department_id = d.department_id;

---------------------------------

CREATE TABLE projects_2 (
    project_id INT PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO projects_2 (project_id, name) VALUES (1, 'Website Redesign');
INSERT INTO projects_2 (project_id, name) VALUES (2, 'Mobile App Development');
INSERT INTO projects_2 (project_id, name) VALUES (3, 'Database Optimization');
INSERT INTO projects_2 (project_id, name) VALUES (4, 'AI Chatbot Enhancement');


CREATE TABLE tasks (
    task_id INT PRIMARY KEY,
    name VARCHAR(100),
    project_id INT,
    FOREIGN KEY (project_id) REFERENCES projects_2(project_id)
);

INSERT INTO tasks (task_id, name, project_id) VALUES (101, 'Create Wireframes', 1);
INSERT INTO tasks (task_id, name, project_id) VALUES (102, 'Develop Backend API', 2);
INSERT INTO tasks (task_id, name, project_id) VALUES (103, 'Optimize SQL Queries', 3);
INSERT INTO tasks (task_id, name, project_id) VALUES (104, 'Improve NLP Model', 4);

SELECT p.name AS Project_Name, 
       t.name AS Task_Name
FROM projects_2 p
JOIN tasks t ON p.project_id = t.project_id;

---------------------------------

SELECT * FROM COURSES

CREATE TABLE Exams(
	exam_id INT PRIMARY KEY,
	exam_title varchar(100),
	course_id INT,
	FOREIGN KEY (course_id) REFERENCES COURSES(COURSE_ID)
);

INSERT INTO Exams (exam_id, exam_title, course_id) VALUES (1, 'Database Fundamentals Midterm', 101);
INSERT INTO Exams (exam_id, exam_title, course_id) VALUES (2, 'Advanced SQL Final Exam', 102);
INSERT INTO Exams (exam_id, exam_title, course_id) VALUES (3, 'Web Development Project Assessment', 103);
INSERT INTO Exams (exam_id, exam_title, course_id) VALUES (4, 'Data Structures Quiz', 104);

SELECT * FROM COURSES C JOIN Exams E ON C.COURSE_ID = E.COURSE_ID 

---------------------------------
CREATE TABLE categories (
    category_id INT PRIMARY KEY,
    name VARCHAR(100)
);
INSERT INTO categories (category_id, name) VALUES (1, 'Electronics');
INSERT INTO categories (category_id, name) VALUES (2, 'Home Appliances');
INSERT INTO categories (category_id, name) VALUES (3, 'Furniture');

ALTER TABLE product  RENAME COLUMN PRODUCT_NAME TO NAME;


SELECT p.name AS Product_Name, 
       c.name AS Category_Name
FROM product p, categories c;

---------------------------------

SELECT b.book_title, a.author_name 
FROM BOOKS b 
JOIN AUTHORS a ON b.AUTHOR_ID = a.AUTHOR_ID

---------------------------------

SELECT e.first_name , d.department_name, d.location_id 
FROM EMPLOYEES e 
JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
