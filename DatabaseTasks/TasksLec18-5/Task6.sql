----------------------------------------------------------------------------------------------------
----- Lecture 7 ------
--------- Task 6 ---------
--------------------------

SELECT employee_id, FIRST_NAME , salary
FROM employees
WHERE salary > ANY (
    SELECT salary
    FROM employees
    WHERE department_id = 10
);

--------------------------------
SELECT employee_id, FIRST_NAME , salary
FROM employees
WHERE salary < ALL (
    SELECT salary
    FROM employees
    WHERE department_id = 20
);

---------------------------------

SELECT product_id, product_name, price
FROM products
WHERE price IN (
    SELECT price
    FROM products
    WHERE category = 'Electronics'
);

---------------------------------

SELECT customer_id, customer_name
FROM customers
WHERE customer_id IN (
    SELECT DISTINCT customer_id
    FROM orders
    WHERE product_id IN (
        SELECT product_id
        FROM products
        WHERE price > 1000
    )
);

-----------------------------------

SELECT employee_id, FIRST_NAME , JOB_ID
FROM employees
WHERE JOB_ID IN (
    SELECT JOB_ID
    FROM employees
    GROUP BY JOB_ID
    HAVING COUNT(*) > 1
);

-----------------------------------

SELECT department_id, department_name
FROM departments
WHERE department_id IN (
    SELECT department_id
    FROM employees
    GROUP BY department_id
    HAVING COUNT(*) > 1
);

------------------------------------

SELECT order_id, customer_id, order_date
FROM orders o
WHERE customer_id IN (
    SELECT DISTINCT c1.customer_id
    FROM customers c1
    WHERE c1.city IN (
        SELECT DISTINCT c2.city
        FROM customers c2
        JOIN orders o2 ON c2.customer_id = o2.customer_id
    )
);

--------------------------------------

SELECT book_id, book_title, author_id
FROM books
WHERE author_id IN (
    SELECT author_id
    FROM books
    GROUP BY author_id
    HAVING COUNT(book_id) > 1
);

-------------------------------------

SELECT student_id, name
FROM students
WHERE student_id IN (
    SELECT DISTINCT COURSES.student_id
    FROM COURSES  COURSES
    WHERE COURSES.course_id IN (
        SELECT course_id
        FROM courses
        WHERE professor = 'Dr. Smith'
    )
);

--------------------------------------

SELECT employee_id, FIRST_NAME , salary
FROM employees
WHERE salary IN (
    SELECT DISTINCT salary
    FROM employees
    WHERE department_id = 30
);






