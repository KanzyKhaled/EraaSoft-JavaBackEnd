
-- Lecture 2 Tasks
-----------------------------------
-- Task 1:
----------

CREATE TABLE Doctor(
id int,
name varchar(50),
salary int,
address varchar(250));

-----------------------------------

INSERT INTO Doctor (id, name, salary, address)
VALUES (10, 'Dr. Heba Khalil', 4700, 'Suez');

-----------------------------------
UPDATE Doctor SET salary = 20000 WHERE id = 3;
-----------------------------------
DELETE FROM Doctor WHERE id = 9;

-----------------------------------
SELECT name || ' - ' || salary AS name_with_salary
FROM Doctor;

------------------------------------

SELECT salary * 2 FROM Doctor;

------------------------------------
SELECT * FROM Doctor WHERE salary IN (1000, 2000, 3000);
------------------------------------
RENAME Doctor TO PRD_Doctor;
------------------------------------

-- Task 2:
----------
CREATE TABLE Employees_2(
 EmployeeID int, 
 FirstName varchar(50), 
 LastName varchar(50), 
 Department varchar(50), 
 Salary int
);

-----------------------------------
INSERT INTO Employees_2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (101, 'John1', 'Doe1', 'HR', 20000);

INSERT INTO Employees_2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (102, 'John2', 'Doe2', 'IT', 50000);

INSERT INTO Employees_2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (103, 'John3', 'Doe3', 'CS', 40000);

INSERT INTO Employees_2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (104, 'John4', 'Doe4', 'IT', 10000);

INSERT INTO Employees_2 (EmployeeID, FirstName, LastName, Department, Salary)
VALUES (105, 'John5', 'Doe5', 'ZX', 30000);

------------------------------------
UPDATE EMPLOYEES_2 e SET salary = 600000 WHERE EmployeeID=101;

------------------------------------
DELETE FROM EMPLOYEES_2  WHERE EmployeeID = 101;

------------------------------------
SELECT * FROM EMPLOYEES_2 e WHERE DEPARTMENT = 'IT';

------------------------------------
SELECT EmployeeID, 
       FirstName || ' ' || LastName AS FullName, 
       Department, 
       Salary
FROM Employees;
