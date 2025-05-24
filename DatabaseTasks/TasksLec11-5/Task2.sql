----------------------------------------------------------------------------------------------------
----- Lecture 7 ------
--------- Task 2 ---------
--------------------------

SELECT FIRST_NAME, DEPARTMENT_NAME  FROM EMPLOYEES  JOIN DEPARTMENTS  USING (DEPARTMENT_ID)


---------------------------------

SELECT * FROM ORDERS JOIN CUSTOMERS USING (CUSTOMER_ID)

---------------------------------

ALTER TABLE Products ADD FOREIGN KEY (supplier_id) REFERENCES Suppliers(supplier_id);

SELECT product_name, supplier_name FROM Products  JOIN Suppliers  USING (supplier_id)

---------------------------------

SELECT student_name, course_name
FROM STUDENTS
JOIN COURSES USING (student_id);

---------------------------------
ALTER TABLE Invoices ADD product_id INT;
ALTER TABLE Invoices ADD FOREIGN KEY (product_id) REFERENCES Products(product_id);

UPDATE Invoices SET PRODUCT_ID = 101 WHERE INVOICE_ID = 1;
UPDATE Invoices SET PRODUCT_ID = 102 WHERE INVOICE_ID = 2;
UPDATE Invoices SET PRODUCT_ID = 103 WHERE INVOICE_ID = 3;
UPDATE Invoices SET PRODUCT_ID = 104 WHERE INVOICE_ID = 4;


SELECT I.invoice_id, P.product_name
FROM Invoices I
JOIN Products P USING (product_id);

---------------------------------

ALTER TABLE Employees_1 ADD project_id INT;
ALTER TABLE Employees_1 ADD FOREIGN KEY (project_id) REFERENCES Projects(project_id);

SELECT * FROM PROJECTS;

UPDATE Employees_1 SET project_id = 101 WHERE EMPLOYEE_ID  = 1;
UPDATE Employees_1 SET project_id = 102 WHERE EMPLOYEE_ID = 2;
UPDATE Employees_1 SET project_id = 103 WHERE EMPLOYEE_ID = 3;
UPDATE Employees_1 SET project_id = 104 WHERE EMPLOYEE_ID = 4;

SELECT project_name, employee_name
FROM Employees_1
JOIN Projects USING (project_id)

---------------------------------

SELECT author_name, book_title
FROM Authors
JOIN Books USING (author_id);

---------------------------------
CREATE TABLE SalesOrders (
    order_id INT PRIMARY KEY,
    order_date DATE NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    employee_id INT,
    customer_id INT,
    FOREIGN KEY (employee_id) REFERENCES Employees_1(EMPLOYEE_ID),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(CUSTOMER_ID)
);

INSERT INTO SalesOrders (order_id, order_date, total_amount, employee_id)
VALUES (101, TO_DATE('2025-06-03', 'YYYY-MM-DD'), 1500.00, 1);

INSERT INTO SalesOrders (order_id, order_date, total_amount, employee_id)
VALUES (102, TO_DATE('2025-06-04', 'YYYY-MM-DD'), 2750.50, 2);

INSERT INTO SalesOrders (order_id, order_date, total_amount, employee_id)
VALUES (103, TO_DATE('2025-06-05', 'YYYY-MM-DD'), 1899.99, 3);

INSERT INTO SalesOrders (order_id, order_date, total_amount, employee_id)
VALUES (104, TO_DATE('2025-06-06', 'YYYY-MM-DD'), 3200.00, 4);



SELECT order_id, order_date, total_amount, employee_name
FROM SalesOrders
JOIN Employees_1 USING (employee_id);



---------------------------------

SELECT class_name, TO_CHAR(schedule_time, 'HH24:MI:SS') AS class_time, instructor_name
FROM ClassSchedules
JOIN Instructors USING (instructor_id);

---------------------------------
CREATE TABLE accounts (
    account_id INT PRIMARY KEY,
    account_holder_name VARCHAR(100)
);

INSERT INTO accounts (account_id, account_holder_name) VALUES (1, 'Kanzy Ahmed');
INSERT INTO accounts (account_id, account_holder_name) VALUES (2, 'Omar Khalid');
INSERT INTO accounts (account_id, account_holder_name) VALUES (3, 'Nada Hassan');
INSERT INTO accounts (account_id, account_holder_name) VALUES (4, 'Ali Samir');



CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY,
    transaction_date DATE,
    transaction_amount DECIMAL(10,2),
    account_id INT REFERENCES accounts(account_id)
);


INSERT INTO transactions (transaction_id, transaction_date, transaction_amount, account_id) 
VALUES (101, TO_DATE('2025-05-01', 'YYYY-MM-DD'), 500.00, 1);

INSERT INTO transactions (transaction_id, transaction_date, transaction_amount, account_id) 
VALUES (102, TO_DATE('2025-05-02', 'YYYY-MM-DD'), 1200.50, 2);

INSERT INTO transactions (transaction_id, transaction_date, transaction_amount, account_id) 
VALUES (103, TO_DATE('2025-05-03', 'YYYY-MM-DD'), 750.75, 3);

INSERT INTO transactions (transaction_id, transaction_date, transaction_amount, account_id) 
VALUES (104, TO_DATE('2025-05-04', 'YYYY-MM-DD'), 2250.00, 4);



SELECT transactions.transaction_id, transactions.transaction_date, transactions.transaction_amount, accounts.account_holder_name
FROM transactions
JOIN accounts USING (account_id);
