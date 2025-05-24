----- Lecture 7 ------
--------- Task 1 ---------
--------------------------

SELECT FIRST_NAME, DEPARTMENT_ID FROM EMPLOYEES NATURAL JOIN DEPARTMENTS;

-----------------------------------------------
DROP TABLE CUSTOMERS
CREATE TABLE CUSTOMERS (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL
);
INSERT INTO Customers (customer_id, customer_name) VALUES (1, 'Mohammed');
INSERT INTO Customers (customer_id, customer_name) VALUES (2, 'Fatima');
INSERT INTO Customers (customer_id, customer_name) VALUES (3, 'Ali');
INSERT INTO Customers (customer_id, customer_name) VALUES (4, 'Noor');

DROP TABLE ORDERS
CREATE TABLE ORDERS(
    order_id INT PRIMARY KEY,
    order_date DATE NOT NULL,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)
);
INSERT INTO Orders (order_id, order_date, customer_id) 
VALUES (101, TO_DATE('2025-05-01', 'YYYY-MM-DD'), 1);

INSERT INTO Orders (order_id, order_date, customer_id) 
VALUES (102, TO_DATE('2025-05-02', 'YYYY-MM-DD'), 2);

INSERT INTO Orders (order_id, order_date, customer_id) 
VALUES (103, TO_DATE('2025-05-03', 'YYYY-MM-DD'), 3);

INSERT INTO Orders (order_id, order_date, customer_id) 
VALUES (104, TO_DATE('2025-05-04', 'YYYY-MM-DD'), 4);


SELECT order_id, order_date, customer_name
FROM CUSTOMERS
NATURAL JOIN ORDERS;


-----------------------------------------------


DROP TABLE STUDENTS;
CREATE TABLE STUDENTS (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(255) NOT NULL
);

INSERT INTO STUDENTS (student_id, student_name) VALUES (1, 'Ahmed');
INSERT INTO STUDENTS (student_id, student_name) VALUES (2, 'Mona');
INSERT INTO STUDENTS (student_id, student_name) VALUES (3, 'Omar');
INSERT INTO STUDENTS (student_id, student_name) VALUES (4, 'Sara');


CREATE TABLE COURSES (
    course_id INT PRIMARY KEY,
    student_id INT,
    course_name VARCHAR(255) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES STUDENTS(student_id)
);

INSERT INTO COURSES (course_id, student_id, course_name) VALUES (101, 1, 'Mathematics');
INSERT INTO COURSES (course_id, student_id, course_name) VALUES (102, 2, 'Physics');
INSERT INTO COURSES (course_id, student_id, course_name) VALUES (103, 3, 'Computer Science');
INSERT INTO COURSES (course_id, student_id, course_name) VALUES (104, 4, 'Biology');


SELECT student_name, course_name
FROM STUDENTS
NATURAL JOIN COURSES;


-----------------------------------------------

CREATE TABLE Employees_1 (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL
);

INSERT INTO Employees_1 (employee_id, employee_name) VALUES (1, 'Khaled');
INSERT INTO Employees_1 (employee_id, employee_name) VALUES (2, 'Layla');
INSERT INTO Employees_1 (employee_id, employee_name) VALUES (3, 'Omar');
INSERT INTO Employees_1 (employee_id, employee_name) VALUES (4, 'Aya');

CREATE TABLE Projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(255) NOT NULL,
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES Employees_1(employee_id)
);



INSERT INTO Projects (project_id, project_name, employee_id) VALUES (101, 'AI Development', 1);
INSERT INTO Projects (project_id, project_name, employee_id) VALUES (102, 'Data Analysis', 2);
INSERT INTO Projects (project_id, project_name, employee_id) VALUES (103, 'Web Application', 3);
INSERT INTO Projects (project_id, project_name, employee_id) VALUES (104, 'Cybersecurity', 4);


SELECT project_name, employee_name
FROM Employees_1
NATURAL JOIN Projects;

-----------------------------------------------

CREATE TABLE Invoices (
    invoice_id INT PRIMARY KEY,
    invoice_date DATE NOT NULL,
    customer_name VARCHAR(255) NOT NULL
);

INSERT INTO Invoices (invoice_id, invoice_date, customer_name) VALUES (1, TO_DATE('2025-05-10', 'YYYY-MM-DD'), 'Hassan');
INSERT INTO Invoices (invoice_id, invoice_date, customer_name) VALUES (2, TO_DATE('2025-05-11', 'YYYY-MM-DD'), 'Nadia');
INSERT INTO Invoices (invoice_id, invoice_date, customer_name) VALUES (3, TO_DATE('2025-05-12', 'YYYY-MM-DD'), 'Youssef');
INSERT INTO Invoices (invoice_id, invoice_date, customer_name) VALUES (4, TO_DATE('2025-05-13', 'YYYY-MM-DD'), 'Amina');

CREATE TABLE Products(
    product_id INT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    invoice_id INT,
    FOREIGN KEY (invoice_id) REFERENCES Invoices(invoice_id)
);

INSERT INTO Products (product_id, product_name, invoice_id) VALUES (101, 'Laptop', 1);
INSERT INTO Products (product_id, product_name, invoice_id) VALUES (102, 'Smartphone', 2);
INSERT INTO Products (product_id, product_name, invoice_id) VALUES (103, 'Headphones', 3);
INSERT INTO Products (product_id, product_name, invoice_id) VALUES (104, 'Tablet', 4);

SELECT invoice_id, invoice_date, customer_name, product_name
FROM Invoices
NATURAL JOIN Products;


-----------------------------------------------

CREATE TABLE Authors (
    author_id INT PRIMARY KEY,
    author_name VARCHAR(255) NOT NULL
);
INSERT INTO Authors (author_id, author_name) VALUES (1, 'Naguib Mahfouz');
INSERT INTO Authors (author_id, author_name) VALUES (2, 'Taha Hussein');
INSERT INTO Authors (author_id, author_name) VALUES (3, 'Sonallah Ibrahim');
INSERT INTO Authors (author_id, author_name) VALUES (4, 'Radwa Ashour');


CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    book_title VARCHAR(255) NOT NULL,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES Authors(author_id)
);


INSERT INTO Books (book_id, book_title, author_id) VALUES (101, 'Palace Walk', 1);
INSERT INTO Books (book_id, book_title, author_id) VALUES (102, 'The Days', 2);
INSERT INTO Books (book_id, book_title, author_id) VALUES (103, 'Zaat', 3);
INSERT INTO Books (book_id, book_title, author_id) VALUES (104, 'Granada', 4);

SELECT book_title, author_name
FROM Authors
NATURAL JOIN Books;

-----------------------------------------------

CREATE TABLE Instructors (
    instructor_id INT PRIMARY KEY,
    instructor_name VARCHAR(255) NOT NULL
);
INSERT INTO Instructors (instructor_id, instructor_name) VALUES (1, 'Hassan');
INSERT INTO Instructors (instructor_id, instructor_name) VALUES (2, 'Maha');
INSERT INTO Instructors (instructor_id, instructor_name) VALUES (3, 'Youssef');
INSERT INTO Instructors (instructor_id, instructor_name) VALUES (4, 'Nadia');


CREATE TABLE ClassSchedules (
    class_id INT PRIMARY KEY,
    class_name VARCHAR(255) NOT NULL,
    schedule_time DATE NOT NULL,
    instructor_id INT,
    FOREIGN KEY (instructor_id) REFERENCES Instructors(instructor_id)
);


INSERT INTO ClassSchedules (class_id, class_name, schedule_time, instructor_id) 
VALUES (201, 'Software Engineering', TO_DATE('2025-06-01 08:30:00', 'YYYY-MM-DD HH24:MI:SS'), 1);

INSERT INTO ClassSchedules (class_id, class_name, schedule_time, instructor_id) 
VALUES (202, 'Data Structures', TO_DATE('2025-06-02 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), 2);

INSERT INTO ClassSchedules (class_id, class_name, schedule_time, instructor_id) 
VALUES (203, 'Artificial Intelligence', TO_DATE('2025-06-03 12:15:00', 'YYYY-MM-DD HH24:MI:SS'), 3);

INSERT INTO ClassSchedules (class_id, class_name, schedule_time, instructor_id) 
VALUES (204, 'Cybersecurity', TO_DATE('2025-06-04 14:45:00', 'YYYY-MM-DD HH24:MI:SS'), 4);

SELECT class_name, TO_CHAR(schedule_time, 'HH24:MI:SS') AS class_time, instructor_name
FROM Instructors
NATURAL JOIN ClassSchedules;


-----------------------------------------------

CREATE TABLE Suppliers (
    supplier_id INT PRIMARY KEY,
    supplier_name VARCHAR(255) NOT NULL
);


INSERT INTO Suppliers (supplier_id, supplier_name) VALUES (1, 'Mahmoud');
INSERT INTO Suppliers (supplier_id, supplier_name) VALUES (2, 'Salma');
INSERT INTO Suppliers (supplier_id, supplier_name) VALUES (3, 'Tarek');
INSERT INTO Suppliers (supplier_id, supplier_name) VALUES (4, 'Rania');

ALTER TABLE Products ADD supplier_id INT;
ALTER TABLE Products ADD FOREIGN KEY (supplier_id) REFERENCES Suppliers(supplier_id);

UPDATE Products SET supplier_id = 1 WHERE product_id = 101;
UPDATE Products SET supplier_id = 2 WHERE product_id = 102;
UPDATE Products SET supplier_id = 3 WHERE product_id = 103;
UPDATE Products SET supplier_id = 4 WHERE product_id = 104;

SELECT supplier_name, product_name
FROM Suppliers
NATURAL JOIN Products;

SELECT * FROM Suppliers
-----------------------------------------------


CREATE TABLE ShippingDetails (
    order_id INT PRIMARY KEY,
    shipping_date DATE NOT NULL,
    shipping_address VARCHAR(255) NOT NULL
);

INSERT INTO ShippingDetails (order_id, shipping_date, shipping_address) 
VALUES (101, TO_DATE('2025-06-01', 'YYYY-MM-DD'), 'Cairo, Egypt');

INSERT INTO ShippingDetails (order_id, shipping_date, shipping_address) 
VALUES (102, TO_DATE('2025-06-02', 'YYYY-MM-DD'), 'Alexandria, Egypt');

INSERT INTO ShippingDetails (order_id, shipping_date, shipping_address) 
VALUES (103, TO_DATE('2025-06-03', 'YYYY-MM-DD'), 'Giza, Egypt');

INSERT INTO ShippingDetails (order_id, shipping_date, shipping_address) 
VALUES (104, TO_DATE('2025-06-04', 'YYYY-MM-DD'), 'Luxor, Egypt');


ALTER TABLE Orders ADD FOREIGN KEY (order_id) REFERENCES ShippingDetails(order_id);


SELECT customer_name, order_id, order_date, shipping_date, shipping_address
FROM Customers
NATURAL JOIN Orders
NATURAL JOIN ShippingDetails;



-----------------------------------------------
CREATE TABLE Employees_3 (
    employee_id INT PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL
);
INSERT INTO Employees_3 (employee_id, employee_name) VALUES (1, 'Karim');
INSERT INTO Employees_3 (employee_id, employee_name) VALUES (2, 'Yasmin');
INSERT INTO Employees_3 (employee_id, employee_name) VALUES (3, 'Omar');
INSERT INTO Employees_3 (employee_id, employee_name) VALUES (4, 'Leila');

CREATE TABLE JobTitles (
    job_id INT PRIMARY KEY,
    job_title VARCHAR(255) NOT NULL,
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES Employees_1(employee_id)
);


INSERT INTO JobTitles (job_id, job_title, employee_id) VALUES (201, 'Database Administrator', 1);
INSERT INTO JobTitles (job_id, job_title, employee_id) VALUES (202, 'Software Developer', 2);
INSERT INTO JobTitles (job_id, job_title, employee_id) VALUES (203, 'Network Engineer', 3);
INSERT INTO JobTitles (job_id, job_title, employee_id) VALUES (204, 'System Analyst', 4);


SELECT employee_name, job_title
FROM Employees_3
NATURAL JOIN JobTitles;



