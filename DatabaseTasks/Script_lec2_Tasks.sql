
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
VALUES (1, 'Dr. Ahmed Hassan', 3000.50, 'Cairo');

INSERT INTO Doctor (id, name, salary, address)
VALUES (2, 'Dr. Mona Adel', 4500.75, 'Alexandria');

INSERT INTO Doctor (id, name, salary, address)
VALUES (3, 'Dr. Khaled Youssef', 5200.00, 'Giza');

INSERT INTO Doctor (id, name, salary, address)
VALUES (4, 'Dr. Laila Ibrahim', 3100.25, 'Luxor');

INSERT INTO Doctor (id, name, salary, address)
VALUES (5, 'Dr. Omar Sherif', 4000.80, 'Aswan');

INSERT INTO Doctor (id, name, salary, address)
VALUES (6, 'Dr. Yasmine Nabil', 3500.60, 'Fayoum');

INSERT INTO Doctor (id, name, salary, address)
VALUES (7, 'Dr. Tarek Mahmoud', 3800.45, 'Tanta');

INSERT INTO Doctor (id, name, salary, address)
VALUES (8, 'Dr. Samia Ahmed', 4200.20, 'Ismailia');

INSERT INTO Doctor (id, name, salary, address)
VALUES (9, 'Dr. Nour Ali', 5000.90, 'Port Said');

INSERT INTO Doctor (id, name, salary, address)
VALUES (10, 'Dr. Heba Khalil', 4700, 'Suez');

-----------------------------------
/*
WHY THIS SYNTACX IS NOT ACCEPTABLE

INSERT INTO Doctor (id, name, salary, address)
VALUES (1, 'Dr. Ahmed Hassan', 3000.50, 'Cairo'),
       (2, 'Dr. Mona Adel', 4500.75, 'Alexandria'),
       (3, 'Dr. Khaled Youssef', 5200.00, 'Giza'),
       (4, 'Dr. Laila Ibrahim', 3100.25, 'Luxor'),
       (5, 'Dr. Omar Sherif', 4000.80, 'Aswan'),
       (6, 'Dr. Yasmine Nabil', 3500.60, 'Fayoum'),
       (7, 'Dr. Tarek Mahmoud', 3800.45, 'Tanta'),
       (8, 'Dr. Samia Ahmed', 4200.20, 'Ismailia'),
       (9, 'Dr. Nour Ali', 5000.90, 'Port Said'),
       (10, 'Dr. Heba Khalil', 4700.30, 'Suez');

*/
-----------------------------------

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
