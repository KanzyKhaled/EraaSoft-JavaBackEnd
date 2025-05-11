-- Lecture 6 Task 1
-----------------------------------

CREATE TABLE Player (
    id INT NOT NULL UNIQUE,
    name VARCHAR(255) UNIQUE
);

INSERT INTO Player VALUES (1, 'Alex');
INSERT INTO Player VALUES (1, 'Alex');
INSERT INTO Player VALUES (1, 'NULL');
INSERT INTO Player VALUES (9, 'NULL');
INSERT INTO Player VALUES(2, 'Jordan');
INSERT INTO Player VALUES(3, 'Taylor');
INSERT INTO Player VALUES(4, 'Morgan');
INSERT INTO Player VALUES(5, 'Chris');

------------------------------------

CREATE TABLE Manager_Task_1(
	id INT NOT NULL,
	name varchar(55),
	salary INT,
	UNIQUE (id, name)
);

INSERT INTO Manager_Task_1  VALUES (1, 'Alice Johnson', 75000);
INSERT INTO Manager_Task_1  VALUES (1, 'Johnson', 75000);
INSERT INTO Manager_Task_1  VALUES (2, 'Alice Johnson', 75000);
INSERT INTO Manager_Task_1  VALUES (1, 'Alice Johnson', 75000);


INSERT INTO Manager_Task_1  VALUES (2, 'Bob Smith', 82000);
INSERT INTO Manager_Task_1  VALUES (3, 'Charlie Brown', 91000);
INSERT INTO Manager_Task_1  VALUES (4, 'David White', 60000);
INSERT INTO Manager_Task_1  VALUES (5, 'Emma Davis', 73000);

-------------------------------------

CREATE TABLE Manager_Task_2 (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(255),
    age NUMBER
);

INSERT INTO Manager_Task_2  VALUES (1, 'Alice Johnson', 45);
INSERT INTO Manager_Task_2  VALUES (1, 'Alice Johnson', 45);

INSERT INTO Manager_Task_2  VALUES (2, 'Bob Smith', 50);
INSERT INTO Manager_Task_2  VALUES (3, 'Charlie Brown', 38);
INSERT INTO Manager_Task_2  VALUES (4, 'Charlie Brown', 38);


--------------------------------------
-----Difference between PrimaryKey and NOT NULL UNIQUE Constrain------

CREATE TABLE Diff_Task_1 (
    id_primary NUMBER PRIMARY KEY, -- This column is a Primary Key
    id_unique NUMBER NOT NULL UNIQUE -- This column has a NOT NULL and UNIQUE constraint
);


INSERT INTO Diff_Task_1 (id_primary, id_unique) VALUES (1, 100);
INSERT INTO Diff_Task_1 (id_primary, id_unique) VALUES (2, 200);
INSERT INTO Diff_Task_1 (id_primary, id_unique) VALUES (3, 300);
INSERT INTO Diff_Task_1 (id_primary, id_unique) VALUES (4, 400);
INSERT INTO Diff_Task_1 (id_primary, id_unique) VALUES (5, 500);

---- (1) Primary Key -----
/*--Can only be one Primary Key per table, but it may contain multiple columns if defined as a composite key
 *--A Primary Key automatically creates a unique index that optimizes retrieval speed.
 *--A Primary Key is commonly used for referencing in Foreign Keys in other tables.
 *--Serves as the main identifier of the row.
 
---- (2) UNIQUE NOT NULL  -----
*--A table can have multiple unique constraints (while it can have only one primary key).
*--Unlike a primary key, this column is not necessarily the main identifier of the row.

---- BOTH OF THEM -----
*--Prevents null values, ensuring every row has a value.
*--Ensures uniqueness, meaning no two rows can have the same value.
*--Can consist of multiple columns






 */
*/