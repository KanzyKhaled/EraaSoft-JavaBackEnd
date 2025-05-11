-- Lecture 5 Tasks
-----------------------------------
-------- Task 2 ---------
CREATE TABLE Doctor (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    salary NUMBER
);

 CREATE TABLE Patient (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER
);


CREATE TABLE Doctor_Patient (
    doctor_id NUMBER,
    patient_id NUMBER,
    PRIMARY KEY (doctor_id, patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
    FOREIGN KEY (patient_id) REFERENCES Patient(id)
);

-----------------------------------
-------- Task 3 ---------
CREATE TABLE Language (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL
);

CREATE TABLE Teacher (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    salary NUMBER,
    language_id NUMBER,
    FOREIGN KEY (language_id) REFERENCES Language(id)
);

-----------------------------------
-------- Task 4 ---------
CREATE TABLE Employee (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    age NUMBER NOT NULL
);

CREATE TABLE Phone (
    id NUMBER PRIMARY KEY,
    phoneNumber VARCHAR2(20) NOT NULL,
    employee_id NUMBER UNIQUE, -- Ensures one-to-one relationship
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
);

-----------------------------------
-------- Task 5 ---------
CREATE TABLE Doctor (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    salary NUMBER NOT NULL
);

CREATE TABLE Patient (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    age NUMBER NOT NULL
);

CREATE TABLE Doctor_Patient (
    doctor_id NUMBER,
    patient_id NUMBER,
    PRIMARY KEY (doctor_id, patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
    FOREIGN KEY (patient_id) REFERENCES Patient(id)
);


-----------------------------------
-------- Task 6 ---------
CREATE TABLE Language (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL
);


CREATE TABLE Teacher (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    salary NUMBER NOT NULL,
    language_id NUMBER,  -- Foreign Key to Language
    FOREIGN KEY (language_id) REFERENCES Language(id)
);

-----------------------------------
-------- Task 7 ---------
CREATE TABLE Employee (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    age NUMBER NOT NULL
);

CREATE TABLE Phone (
    id NUMBER PRIMARY KEY,
    phoneNumber VARCHAR2(20) NOT NULL,
    employee_id NUMBER UNIQUE, -- Ensures one-to-one relationship
    FOREIGN KEY (employee_id) REFERENCES Employee(id)
);

---------------------------------------------------------------------
-- Lecture 6 Tasks
-----------------------------------
-------- Task 1 ---------

CREATE TABLE Employees (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    age NUMBER CHECK (age >= 18)
);

-----------------------------------
CREATE TABLE Staff (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    salary NUMBER CHECK (salary BETWEEN 3000 AND 10000)
);

-----------------------------------
ALTER TABLE Products 
ADD CONSTRAINT chk_price_positive CHECK (price > 0);

-----------------------------------
CREATE TABLE Students (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    grade CHAR(1) CHECK (grade IN ('A', 'B', 'C', 'D', 'E', 'F'))
);

-----------------------------------
-------- Task 2 ---------
ALTER TABLE Customers 
MODIFY email VARCHAR2(255) NOT NULL;

-----------------------------------
ALTER TABLE Users 
ADD CONSTRAINT unique_username UNIQUE (username);

-----------------------------------
ALTER TABLE Orders 
ADD CONSTRAINT fk_customer FOREIGN KEY (customer_id) 
REFERENCES Customers(id);

-----------------------------------
ALTER TABLE Accounts 
ADD CONSTRAINT chk_balance_nonnegative CHECK (balance >= 0);

-----------------------------------
ALTER TABLE Departments 
ADD CONSTRAINT pk_dept PRIMARY KEY (dept_id);

-----------------------------------
-------- Task 3 ---------

ALTER TABLE Employees 
DROP CONSTRAINT chk_salary;

-----------------------------------
ALTER TABLE Users 
DROP CONSTRAINT unique_email;

-----------------------------------
ALTER TABLE Products 
DROP PRIMARY KEY;

-----------------------------------
ALTER TABLE Orders 
DROP CONSTRAINT fk_order_customer;

-----------------------------------
ALTER TABLE Contacts 
MODIFY phone NULL;

-----------------------------------
-------- Task 4 ---------
ALTER TABLE Students DROP CONSTRAINT chk_age;

ALTER TABLE Students ADD CONSTRAINT check_min_age CHECK (age >= 18);

-----------------------------------
ALTER TABLE Employees DROP CONSTRAINT fk_emp_dept;

ALTER TABLE Employees ADD CONSTRAINT fk_employee_department 
FOREIGN KEY (dept_id) REFERENCES Departments(id);

-----------------------------------
ALTER TABLE Users DROP PRIMARY KEY;

ALTER TABLE Users ADD CONSTRAINT pk_users_id PRIMARY KEY (id);

-----------------------------------
ALTER TABLE Users DROP CONSTRAINT unique_username;

ALTER TABLE Users ADD CONSTRAINT uk_user_name UNIQUE (username);

-----------------------------------
--SQL Server :

EXEC sp_rename 'Students.chk_age', 'check_min_age', 'OBJECT';
EXEC sp_rename 'Employees.fk_emp_dept', 'fk_employee_department', 'OBJECT';
EXEC sp_rename 'Users.pk_users', 'pk_users_id', 'OBJECT';
EXEC sp_rename 'Users.unique_username', 'uk_user_name', 'OBJECT';

--PostgreSQL :

ALTER TABLE Students RENAME CONSTRAINT chk_age TO check_min_age;
ALTER TABLE Employees RENAME CONSTRAINT fk_emp_dept TO fk_employee_department;
ALTER TABLE Users RENAME CONSTRAINT pk_users TO pk_users_id;
ALTER TABLE Users RENAME CONSTRAINT unique_username TO uk_user_name;


-----------------------------------
-------- Task 5 ---------

ALTER TABLE Orders 
DISABLE CONSTRAINT fk_customer_order;

-----------------------------------
ALTER TABLE Products 
DISABLE ALL CONSTRAINTS;

-----------------------------------
ALTER TABLE Accounts 
DISABLE CONSTRAINT chk_balance;


-----------------------------------
ALTER TABLE Departments 
DISABLE CONSTRAINT pk_dept;

-----------------------------------
ALTER TABLE my_table DISABLE ALL CONSTRAINTS;

-----------------------------------
-------- Task 6 ---------

ALTER TABLE Orders 
ENABLE CONSTRAINT fk_customer_order;

-----------------------------------
ALTER TABLE Products 
ENABLE ALL CONSTRAINTS;


-----------------------------------
ALTER TABLE Staff 
ENABLE CONSTRAINT chk_salary;


-----------------------------------
ALTER TABLE Departments 
ENABLE CONSTRAINT pk_dept;

-----------------------------------
ALTER TABLE Orders 
ENABLE CONSTRAINT fk_customer_order;

-----------------------------------
