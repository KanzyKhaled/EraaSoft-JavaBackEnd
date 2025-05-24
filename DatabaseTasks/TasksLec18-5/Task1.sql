----------------------------------------------------------------------------------------------------
----- Lecture 7 ------
--------- Task 1 ---------
--------------------------

SELECT e.first_name, d.department_name 
FROM EMPLOYEES e 
LEFT JOIN DEPARTMENTS d ON d.DEPARTMENT_ID = e.DEPARTMENT_ID 

---------------------------
ALTER TABLE PRODUCTS ADD category_id INT;
ALTER TABLE PRODUCTS ADD FOREIGN KEY (category_id) REFERENCES categories(category_id);

UPDATE PRODUCTS SET category_id = null WHERE product_id = 101;
UPDATE PRODUCTS SET category_id = 1 WHERE product_id = 102;
UPDATE PRODUCTS SET category_id = 2 WHERE product_id = 103;
UPDATE PRODUCTS SET category_id = 3 WHERE product_id = 104;


SELECT p.product_name , c.name 
FROM PRODUCTS  p 
LEFT JOIN categories c ON p.category_id = c.category_id;

---------------------------

SELECT * FROM STUDENTS s 
LEFT OUTER JOIN COURSES c ON  s.STUDENT_ID = c.STUDENT_ID

---------------------------

SELECT * FROM ORDERS r 
LEFT JOIN CUSTOMERS c ON r.CUSTOMER_ID = c.CUSTOMER_ID

---------------------------

SELECT d.DEPARTMENT_ID, d.DEPARTMENT_NAME, mt.MANAGER_ID 
FROM DEPARTMENTS d 
LEFT OUTER JOIN MANAGER_TEST_1 mt ON d.MANAGER_ID = mt.MANAGER_ID 

---------------------------

SELECT * FROM BOOKS b 
LEFT JOIN AUTHORS a  ON a.AUTHOR_ID = b.AUTHOR_ID

---------------------------

ALTER TABLE INVOICES  ADD  payment_status INT;
ALTER TABLE PRODUCTS ADD FOREIGN KEY (payment_status) REFERENCES payments(payment_id);

CREATE TABLE payments (
    payment_id INT PRIMARY KEY,
    status VARCHAR(50)
);
INSERT INTO payments (payment_id, status) VALUES (1, 'Paid');
INSERT INTO payments (payment_id, status) VALUES (2, 'Pending');
INSERT INTO payments (payment_id, status) VALUES (3, 'Failed');
INSERT INTO payments (payment_id, status) VALUES (4, 'Not Initiated');

SELECT * FROM INVOICES;
UPDATE invoices SET payment_status = 1 WHERE invoice_id  = 1;
UPDATE invoices SET payment_status = 2 WHERE invoice_id = 2;



SELECT i.invoice_id, 
       p.status
FROM invoices i
LEFT JOIN payments p ON i.payment_status = p.payment_id;

---------------------------
SELECT e.first_name, p.project_name 
FROM EMPLOYEES e 
LEFT JOIN PROJECTS p ON e.EMPLOYEE_ID = p.EMPLOYEE_ID