-- Lecture 1 Task
-----------------------------------
CREATE TABLE Manager(
id INT,
name VARCHAR(50),
age INT,
birth_date DATE ,
address VARCHAR(250)
);
-----------------------------------
ALTER TABLE Manager DROP COLUMN address;
-----------------------------------
ALTER TABLE Manager
ADD city_address VARCHAR2(255);
ALTER TABLE Manager
ADD street VARCHAR2(255);
-----------------------------------
ALTER TABLE Manager
RENAME COLUMN name TO full_name;
-----------------------------------
GRANT SELECT ON Manager TO PUBLIC;
-----------------------------------
CREATE TABLE Owner AS
SELECT id, full_name, birth_date
FROM Manager
WHERE 1=2;
-----------------------------------
RENAME Manager TO Master;

-----------------------------------
