----------------------------------------------------------------------------------------------------
----- Lecture 7 ------
--------- Task 4 ---------
--------------------------

SELECT FIRST_NAME 
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

----------------------------

SELECT customer_id, customer_name
FROM customers
WHERE customer_id IN (
    SELECT customer_id 
    FROM orders 
    GROUP BY customer_id 
    HAVING COUNT(order_id) = (
        SELECT MAX(order_count) 
        FROM (
            SELECT customer_id, COUNT(order_id) AS order_count
            FROM orders 
            GROUP BY customer_id
        ) order_summary
    )
);

-------------------------------

SELECT product_id, product_name, price
FROM products
WHERE price > ANY (
    SELECT price 
    FROM products 
    WHERE CATEGORY_ID  = 1
);

---------------------------------

SELECT employee_id, FIRST_NAME , department_id
FROM employees
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE FIRST_NAME  = 'Kanzy'
);

----------------------------------

SELECT order_id, order_date, customer_id
FROM orders
WHERE customer_id IN (
    SELECT customer_id
    FROM customers
    WHERE city = 'New York'
);

-----------------------------------

SELECT department_id, department_name
FROM departments d
WHERE NOT EXISTS (
    SELECT 1 
    FROM employees e 
    WHERE e.department_id = d.department_id
);

------------------------------------

SELECT student_id, name
FROM students
WHERE student_id NOT IN (
    SELECT student_id 
    FROM COURSES 
);

-------------------------------------

SELECT student_id, name
FROM students s
WHERE NOT EXISTS (
    SELECT 1 
    FROM COURSES  e 
    WHERE e.student_id = s.student_id
);

-------------------------------------

SELECT MAX(salary) AS second_highest_salary
FROM employees
WHERE salary < (
    SELECT MAX(salary) 
    FROM employees
);

-------------------------------------

SELECT product_id, product_name, price
FROM products
WHERE price > (
    SELECT AVG(price) FROM products
);

-------------------------------------
ALTER TABLE orders ADD product_id INT;
ALTER TABLE orders ADD FOREIGN KEY (product_id) REFERENCES PRODUCTS(product_id);

UPDATE orders SET product_id = 101 WHERE product_id = 101;
UPDATE orders SET product_id = 102 WHERE product_id = 102;



SELECT c.customer_id, c.customer_name
FROM customers c
WHERE NOT EXISTS (
    SELECT p.product_id
    FROM products p
    WHERE p.category_id = 1
    AND p.product_id NOT IN (
        SELECT o.product_id
        FROM orders o
        WHERE o.customer_id = c.customer_id
    )
);

