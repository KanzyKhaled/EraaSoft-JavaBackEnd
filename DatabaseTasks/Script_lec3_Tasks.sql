-- Lecture 3 Tasks
-----------------------------------
-- Task 1:

SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID  BETWEEN 100 AND 105

------------------------------------
SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID IN (151,152,153,154,155)

---OR 

SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID BETWEEN 151 AND 155

------------------------------------

SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE 'P%' OR FIRST_NAME LIKE 'p%'

------------------------------------

SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE '%A' OR FIRST_NAME LIKE '%a'

------------------------------------

SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE '%A%' OR FIRST_NAME LIKE '%a%'

------------------------------------

SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE '__E%' OR FIRST_NAME LIKE '__e%'

------------------------------------

SELECT * FROM EMPLOYEES WHERE MANAGER_ID IS NULL 
------------------------------------

SELECT * FROM EMPLOYEES WHERE MANAGER_ID IS NOT NULL 
------------------------------------

INSERT INTO EMPLOYEES (EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID)
VALUES (207,'Alex','Fay','ALEXFAY','515.124.3589',sysdate,'IT_PROG')

------------------------------------

SELECT * FROM EMPLOYEES WHERE JOB_ID = 'AD_VP' OR JOB_ID ='IT_PROG'
----OR
SELECT * FROM EMPLOYEES WHERE JOB_ID IN ('AD_VP', 'IT_PROG')


------------------------------------

SELECT * FROM EMPLOYEES ORDER BY LAST_NAME ASC

------------------------------------

SELECT * FROM EMPLOYEES ORDER BY HIRE_DATE  DESC

-------------------------------------

SELECT * FROM EMPLOYEES  ORDER BY DEPARTMENT_ID  ASC,SALARY  DESC

-------------------------------------

SELECT E.* , LOWER(LAST_NAME) AS LAST_NAME FROM EMPLOYEES E

---OR

SELECT EMPLOYEE_ID , FIRST_NAME, LOWER(LAST_NAME)  FROM EMPLOYEES E

-------------------------------------

SELECT E.* , UPPER(FIRST_NAME) AS FIRST_NAME FROM EMPLOYEES E

---OR

SELECT EMPLOYEE_ID , UPPER(FIRST_NAME), LAST_NAME  FROM EMPLOYEES E

-------------------------------------

SELECT E.* , INITCAP(FIRST_NAME) , INITCAP(LAST_NAME) AS FIRST_NAME FROM EMPLOYEES E

---OR

SELECT EMPLOYEE_ID , INITCAP(FIRST_NAME), INITCAP(LAST_NAME)  FROM EMPLOYEES E


-------------------------------------

SELECT *  FROM EMPLOYEES WHERE LOWER(LAST_NAME) = 'smith';

---OR

SELECT *  FROM EMPLOYEES WHERE UPPER(LAST_NAME) = 'SMITH';

-------------------------------------
-----------Interview Question------------
-----The Difference Between DISTINCT and UNIQUE-----

SELECT DISTINCT  COMMISSION_PCT FROM EMPLOYEES;
SELECT UNIQUE    COMMISSION_PCT FROM EMPLOYEES;

/* 1) DISTINCT KEYWORD:
 *                    - It is used in the SELECT statement to remove duplicate rows from the result set.
 * 					  - Works at the result set level by filtering out duplicate combinations of the selected columns.
 * 2) UNIQUE KEYWORD:
 * 				      - It is a constraint used to ensure that a column has unique values in the database table itself.
 *                    - It prevents duplicate values from being entered into the specified column(s).
 * 					  - Operates at the data integrity level, maintaining uniqueness at the time of data insertion or update.
 * 
 */

