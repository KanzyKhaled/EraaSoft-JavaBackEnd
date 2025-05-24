----------------------------------------------------------------------------------------------------
----- Lecture 7 ------
--------- Task 5 ---------
--------------------------

SELECT employee_id, FIRST_NAME , salary
FROM employees
WHERE salary = (
    SELECT MAX(salary) FROM employees
);

-----------------------------------

SELECT FIRST_NAME
FROM employees
WHERE department_id = (
    SELECT department_id 
    FROM employees 
    WHERE FIRST_NAME = 'Kanzy'
)
AND FIRST_NAME <> 'Kanzy';

-----------------------------------

SELECT product_id, product_name, price
FROM products
WHERE price = (
    SELECT MIN(price) FROM products
);

-----------------------------------

SELECT department_name
FROM departments
WHERE department_id = (
    SELECT department_id
    FROM employees
    WHERE salary = (
        SELECT MAX(salary) FROM employees
    )
);

------------------------------------

SELECT manager_id
FROM employees
WHERE employee_id = (
    SELECT manager_id
    FROM employees
    WHERE hire_date = (
        SELECT MAX(hire_date) FROM employees
    )
);

-------------------------------------

SELECT employee_id, FIRST_NAME , salary
FROM employees
WHERE salary = (
    SELECT AVG(salary) FROM employees
);

--------------------------------------

SELECT order_id, order_date, customer_id
FROM orders
WHERE order_date = (
    SELECT MIN(order_date) FROM orders
);

---------------------------------------

SELECT FIRST_NAME , salary
FROM employees
WHERE salary > (
    SELECT salary
    FROM employees
    WHERE employee_id = 101
);

---------------------------------------

SELECT student_id, name, gpa
FROM students
WHERE gpa = (
    SELECT gpa 
    FROM students 
    WHERE student_name = 'John Doe'
)
AND student_name <> 'John Doe';

----------------------------------------

SELECT book_id, book_title, price
FROM books
WHERE price = (
    SELECT MAX(price)
    FROM books
    WHERE category = 'Science'
);





