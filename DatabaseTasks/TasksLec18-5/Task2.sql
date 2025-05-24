----------------------------------------------------------------------------------------------------
----- Lecture 7 ------
--------- Task 2 ---------
--------------------------

SELECT d.DEPARTMENT_ID, d.DEPARTMENT_NAME , e.first_name 
FROM EMPLOYEES e  
RIGHT OUTER JOIN DEPARTMENTS d ON d.DEPARTMENT_ID = e.DEPARTMENT_ID

---------------------------

SELECT * FROM ORDERS r 
RIGHT JOIN CUSTOMERS c ON r.CUSTOMER_ID = c.CUSTOMER_ID

---------------------------
SELECT * FROM STUDENTS s 
RIGHT JOIN COURSES c ON  s.STUDENT_ID = c.STUDENT_ID

---------------------------
SELECT e.first_name, p.project_name 
FROM EMPLOYEES e 
RIGHT  JOIN PROJECTS p ON e.EMPLOYEE_ID = p.EMPLOYEE_ID

---------------------------
SELECT * FROM payments;

ALTER TABLE transactions  ADD  payment_id INT;
ALTER TABLE transactions ADD FOREIGN KEY (payment_id) REFERENCES payments(payment_id);


SELECT 
    pm.payment_id, 
    pm.status, 
    t.transaction_id, 
    t.transaction_amount
FROM payments pm
RIGHT JOIN transactions t 
    ON pm.payment_id = t.payment_id;

----------------------------

SELECT * FROM AUTHORS a
RIGHT OUTER  JOIN  BOOKS b   ON a.AUTHOR_ID = b.AUTHOR_ID

----------------------------

SELECT p.product_name , c.name 
FROM PRODUCTS  p 
RIGHT  JOIN categories c ON p.category_id = c.category_id;

----------------------------

SELECT * FROM STUDENTS s 
RIGHT  JOIN COURSES c ON  s.STUDENT_ID = c.STUDENT_ID


