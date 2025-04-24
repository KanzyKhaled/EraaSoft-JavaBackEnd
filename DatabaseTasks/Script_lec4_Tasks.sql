-- Lecture 4 Tasks
-----------------------------------
-- Task 1:

CREATE TABLE EMP_TEST (
    NAME VARCHAR(100)
);

------------------------------------

INSERT ALL
INTO EMP_TEST (NAME) VALUES ('   Mostafa Ahmed   ')
INTO EMP_TEST (NAME) VALUES ('   Ahmed Mohamed   ')
INTO EMP_TEST (NAME) VALUES ('Omar Khaled')
INTO EMP_TEST (NAME) VALUES ('   Amr Mohamed   ')
SELECT * FROM DUAL;

------------------------------------

SELECT TRIM(NAME) AS Trimmed_Name
FROM EMP_TEST;

------------------------------------

SELECT LTRIM(NAME) AS Leading_Trimmed_Name
FROM EMP_TEST;

------------------------------------
SELECT RTRIM(NAME) AS Trailing_Trimmed_Name
FROM EMP_TEST;

------------------------------------

SELECT TRIM(BOTH '*' FROM '*****Kanzy Khaled*******' ) AS Trimmed_String
FROM DUAL;

-------------------------------------
-- Task 2:

SELECT REPLACE('database', 'a', '@') FROM dual;

-------------------------------------

SELECT REPLACE ('Happy old year', 'old', 'new') FROM dual;

-------------------------------------

CREATE TABLE PRODUCT (
    product_name VARCHAR(100)
);

INSERT INTO PRODUCT (product_name) VALUES ('Laptop');
INSERT INTO PRODUCT (product_name) VALUES ('Smartphone');
INSERT INTO PRODUCT (product_name) VALUES ('Headphones');

--------------------------------------

SELECT product_name, LPAD(product_name,15,'*') PAD FROM PRODUCT;

--------------------------------------

SELECT product_name, RPAD(product_name,15,'*') PAD FROM PRODUCT;

-------------------------------------
-- Task 3:

SELECT sysdate, TO_CHAR(sysdate,'DD-MON-YYYY') Formated_Date FROM dual;

-------------------------------------

SELECT sysdate, TO_CHAR(sysdate,'Month YYYY') Formated_Date FROM dual;

-------------------------------------

SELECT TO_CHAR(12345.67, '99G999D99') AS Formatted_Number
FROM DUAL;

-------------------------------------

SELECT TO_CHAR(salary, '$9999999') AS Formatted_Salary
FROM EMPLOYEES;

-------------------------------------

-- Task 4:

CREATE TABLE STUDENTS (
    name VARCHAR(100),
    marks INTEGER );

-------------------------------------

INSERT INTO STUDENTS (name, marks) VALUES ('Alice', 85);
INSERT INTO STUDENTS (name, marks) VALUES ('Bob', 78);
INSERT INTO STUDENTS (name, marks) VALUES ('Charlie', 92);
INSERT INTO STUDENTS (name, marks) VALUES ('Diana', 88);
INSERT INTO STUDENTS (name, marks) VALUES ('Ethan', 73);


---------------------------------------
SELECT name,
       marks,
       CASE
           WHEN marks >= 90 THEN 'A'
           WHEN marks BETWEEN 80 AND 89 THEN 'B'
           WHEN marks BETWEEN 70 AND 79 THEN 'C'
           ELSE 'F'
       END AS grade
FROM STUDENTS;

-------------------------------------
-- Task 5:
--???
SELECT name,
       marks,
       DECODE(
           SIGN(marks - 90), 1, 'A',
           SIGN(marks - 80), 1, 'B',
           SIGN(marks - 70), 1, 'C',
           'F'
       ) AS grade
FROM STUDENTS;

--------------------------------------

CREATE TABLE ORDERS (
    status CHAR(1) CHECK (status IN ('P', 'S', 'D'))
);

--------------------------------------

INSERT INTO ORDERS (status) VALUES ('P'); 
INSERT INTO ORDERS (status) VALUES ('S'); 
INSERT INTO ORDERS (status) VALUES ('D');

SELECT status,
       DECODE(
           status,
           'P', 'Pending',
           'S', 'Shipped',
           'D', 'Delivered',
           'Unknown Status' 
       ) AS full_status
FROM ORDERS;


-------------------------------------
-- Task 7:

CREATE TABLE CUSTOMERS (
    full_name VARCHAR(100)
);

INSERT INTO CUSTOMERS (full_name) VALUES ('   Alice Johnson   '); 
INSERT INTO CUSTOMERS (full_name) VALUES ('   Bob Smith');        
INSERT INTO CUSTOMERS (full_name) VALUES ('Charlie Brown   ');   


--------------------------------------
SELECT TRIM(full_name) AS Trimmed_Name
FROM CUSTOMERS;

--------------------------------------
SELECT LTRIM(full_name) AS leading_trimmed_name
FROM CUSTOMERS;
--------------------------------------
SELECT RTRIM(full_name) AS trailing_trimmed_name
FROM CUSTOMERS;
--------------------------------------
SELECT TRIM(BOTH '#' FROM '#Charlie Brown#') AS trimmed_string
FROM DUAL;
--------------------------------------
SELECT REPLACE('promotion', 'o', '0') AS updated_word
FROM DUAL;
--------------------------------------
SELECT REPLACE('This is a basic course', 'basic', 'advanced') AS updated_sentence
FROM DUAL;
--------------------------------------
CREATE TABLE DEPARTMENTS (
    dept_name VARCHAR(100)
);
-------------
INSERT INTO DEPARTMENTS (dept_name) VALUES ('Human Resources');
INSERT INTO DEPARTMENTS (dept_name) VALUES ('Finance');
INSERT INTO DEPARTMENTS (dept_name) VALUES ('Marketing');
---------------------------------------
SELECT LPAD(dept_name, 15, '*') AS left_padded
FROM DEPARTMENTS;
----------------------------------------
SELECT RPAD(dept_name, 15, '-') AS right_padded
FROM DEPARTMENTS;

----------------------------------------
SELECT sysdate, TO_CHAR(sysdate,'Day, Month YYYY') Formated_Date FROM dual;
-------------------------------------
SELECT TO_CHAR(1234567.89, '9G999G999D99') AS Formatted_Number
FROM DUAL;
-------------------------------------
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS') AS formatted_date
FROM DUAL;
--------------------------------------
SELECT name,
       marks,
       CASE
           WHEN marks >= 90 THEN 'A'
           WHEN marks BETWEEN 80 AND 89 THEN 'B'
           WHEN marks BETWEEN 70 AND 79 THEN 'C'
           WHEN marks >= 60 THEN 'Pass'
           ELSE 'F'
       END AS grade
FROM STUDENTS;
--------------------------------------
SELECT name,
       marks,
       CASE
           WHEN marks >= 90 THEN 'Excellent'
           WHEN marks BETWEEN 80 AND 89 THEN 'Good'
           WHEN marks BETWEEN 70 AND 79 THEN 'Average'
           ELSE 'Needs Improvement'
       END AS performance_message
FROM STUDENTS;
--------------------------------------

SELECT 'Today is ' || 
       CASE TO_CHAR(SYSDATE, 'D')
           WHEN '1' THEN 'Sunday'
           WHEN '2' THEN 'Monday'
           WHEN '3' THEN 'Tuesday'
           WHEN '4' THEN 'Wednesday'
           WHEN '5' THEN 'Thursday'
           WHEN '6' THEN 'Friday'
           WHEN '7' THEN 'Saturday'
       END AS today_message
FROM DUAL;
---------------------------------------

CREATE TABLE STATUS_LOG (
    status_code CHAR(1) CHECK (status_code IN ('N', 'I', 'C')),
    quantity NUMBER(10),
    department VARCHAR(50)
);


INSERT INTO STATUS_LOG (status_code, quantity, department) VALUES ('N', 10, 'HR');
INSERT INTO STATUS_LOG (status_code, quantity, department) VALUES ('I', 5, 'IT');
INSERT INTO STATUS_LOG (status_code, quantity, department) VALUES ('C', 0, 'Sales');
INSERT INTO STATUS_LOG (status_code, quantity, department) VALUES ('N', 20, 'Finance');
INSERT INTO STATUS_LOG (status_code, quantity, department) VALUES ('I', 15, 'Marketing');
---------------------------------------
SELECT status_code,
       DECODE(status_code, 
              'N', 'New', 
              'I', 'In Progress', 
              'C', 'Completed', 
              'Unknown') AS status_description
FROM STATUS_LOG;
---------------------------------------

SELECT status_code, quantity,
       DECODE(quantity, 
              0, 'Out of Stock', 
              'Available') AS stock_status
FROM STATUS_LOG;

----------------------------------------
SELECT department,
       DECODE(department, 
              'HR', 500, 
              'IT', 1000, 
              'Sales', 1500, 
              300) AS bonus
FROM STATUS_LOG;