CREATE DATABASE training;

USE training;

CREATE TABLE employee (	
	id serial,
	name text,
	age int,
	designation text,
	department text,
	country text,
	PRIMARY KEY(id)
);


SELECT * FROM employee;

TRUNCATE employee;

INSERT INTO employee (name, age, designation, department, country) VALUES ('Anand', 25, 'Developer', 'IT', 'India'); 
UPDATE employee SET designation = 'IT' WHERE id = 1;
DELETE FROM employee WHERE id = 1;

DROP TABLE employee;
DROP DATABASE training;