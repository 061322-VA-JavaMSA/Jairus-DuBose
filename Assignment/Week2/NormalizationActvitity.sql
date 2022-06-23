--This is my single line commit

/*
 * This is a multi line commit
 */

--create database mydb; 

--create schema task_manager;
--drop schema task_manager; 
/*
create table users(
id serial primary key,
username varchar(30),
password varchar(30)
);*/

/*
 * EmployeeId
 * SalesPerson
 * SalesOffice
 * Age
 * DoB
 * Customer1
 * Customer2
 * Customer3
*/

--Seperated the employeees Into their own table
/*create empolyees if not exists(
	EmolyeeId serial primary key,
	SalesPersonFirstName Varchar(50),
	SalesPersonLastName Varchar(50),
	DoB Date
);

--Seperated the customers into their own table
create customers if not exists(
	CustomerID serial primary key,
	CustomerFirstName Varchar(50),
	CustomerLastName Varchar(50),
	DoB Date
);

--In this table I put the Sales Office location because both the 
--employee and customer can/probaby in the same building
create employee_customer if not exists(
	employee_customer_id serial primary, 
	SalesOfficeLocation INTEGER
);*/

insert into users (username, password) values('kev','pass');

