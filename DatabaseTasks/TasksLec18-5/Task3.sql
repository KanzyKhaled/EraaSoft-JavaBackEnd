----------------------------------------------------------------------------------------------------
----- Lecture 7 ------
--------- Task 3 ---------
--------------------------

SELECT c.customer_id, c.customer_name, o.order_id, o.order_date
FROM customers c
FULL OUTER JOIN orders o ON c.customer_id = o.customer_id;

--------------------------

SELECT e.employee_id, e.first_name, p.project_id, p.project_name
FROM employees e
FULL OUTER JOIN projects p ON e.EMPLOYEE_ID  = p.EMPLOYEE_ID;

--------------------------

SELECT p.product_id, p.product_name, s.supplier_id, s.supplier_name
FROM products p
FULL OUTER JOIN suppliers s  ON p.supplier_id = s.supplier_id;

--------------------------

SELECT s.STUDENT_ID , s.NAME , c.course_id, c.course_name
FROM students s
FULL OUTER JOIN courses c ON s.STUDENT_ID = c.STUDENT_ID;

--------------------------

SELECT a.author_id, a.author_name, b.book_id, b.book_title
FROM authors a
FULL OUTER JOIN books b ON a.author_id = b.author_id;

--------------------------

SELECT e.employee_id, e.FIRST_NAME , d.department_id, d.department_name
FROM employees e
FULL OUTER JOIN departments d ON e.department_id = d.department_id;

--------------------------

SELECT t.transaction_id, t.transaction_amount, pm.payment_id
FROM transactions t
FULL OUTER JOIN payments pm ON t.payment_id = pm.payment_id;

--------------------------
CREATE TABLE customers_region1 (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100)
);

INSERT INTO customers_region1 (customer_id, customer_name) VALUES (1, 'Alice');
INSERT INTO customers_region1 (customer_id, customer_name) VALUES (2, 'Bob');
INSERT INTO customers_region1 (customer_id, customer_name) VALUES (3, 'Charlie');
INSERT INTO customers_region1 (customer_id, customer_name) VALUES (4, 'David');


CREATE TABLE customers_region2 (
    customer_id INT PRIMARY KEY,
    customer_name VARCHAR(100)
);

INSERT INTO customers_region2 (customer_id, customer_name) VALUES (3, 'Charlie'); 
INSERT INTO customers_region2 (customer_id, customer_name) VALUES (4, 'David');   
INSERT INTO customers_region2 (customer_id, customer_name) VALUES (5, 'Emma');
INSERT INTO customers_region2 (customer_id, customer_name) VALUES (6, 'Frank');

SELECT 
    COALESCE(c1.customer_id, c2.customer_id) AS customer_id, 
    COALESCE(c1.customer_name, c2.customer_name) AS customer_name,
    c1.customer_id AS region1_customer_id,
    c2.customer_id AS region2_customer_id
FROM customers_region1 c1
FULL OUTER JOIN customers_region2 c2 
    ON c1.customer_id = c2.customer_id;




