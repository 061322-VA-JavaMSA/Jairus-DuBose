create table if not exists employees(
	id serial primary key,
	username varchar(50),
	first_name varchar(50),
	last_name varchar(50),
	user_password varchar(50),
	email varchar(50)	
);

create table if not exists users(
	id serial primary key,
	username varchar(50),
	first_name varchar(50),
	last_name varchar(50),
	user_password varchar(50),
	email varchar(50)
);

create table if not exists reimbursements(
	reimb_amount integer,
	reimb_submitted date, 
	reimb_resolved date,
	reimb_description varchar(200),
	reimb_receipt varchar(200)
);

create table if not exists user_roles(
	foreign key (user_role_id) references users(id), 	
	user_role varchar(25)
);

create table if not exists reimbursement_status(
	reimb_status varchar(50);
);