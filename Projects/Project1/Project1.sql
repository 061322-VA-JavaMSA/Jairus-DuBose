--Child Table
drop table if exists users; 
create table if not exists users(
	user_id serial primary key,
	username varchar(50),
	first_name varchar(50),
	last_name varchar(50),
	user_password varchar(50),
	email varchar(50),
	user_role_id integer,
	foreign key (user_role_id) references user_roles(user_role_id) 
);

--Parent Table
create table if not exists user_roles(
	user_role_id serial primary key, 
	user_role varchar(20)
);

--Child Table
drop table if exists reimbursements; 
create table if not exists reimbursements(
	reimb_amount decimal,
	reimb_submitted timestamp, 
	reimb_resolved timestamp,
	reimb_description varchar(250),
	reimb_receipt bytea,
	reimb_author_id integer,
	reimb_resolver integer, 
	reimb_status_id integer,
	reimb_type_id integer, 
	foreign key (reimb_author_id) references users(user_id),
	foreign key (reimb_resolver) references users(user_id),
	foreign key (reimb_status_id) references reimbursement_status(reimb_status_id),
	foreign key (reimb_type_id) references reimbursement_type(reimb_type_id)
);

--Parent Table
create table if not exists reimbursement_status(
	reimb_status_id serial primary key,
	reimb_status varchar(10)
);
--Parent Table
create table if not exists reimbursement_type(
	reimb_type_id serial primary key,
	reimb_type varchar(10)
);

insert into user_roles (user_role) values ('manager');
insert into user_roles (user_role) values ('employee');

insert into users (username, first_name, last_name, user_password, email, user_role_id) values (
	'JaiDuB75', 'Jairus', 'DuBose', 'ApassWord', 'anemail@email.com', 2);

insert into users (username, first_name, last_name, user_password, email, user_role_id) values (
	'BobUser', 'Bob', 'Smith', 'BobPass', 'bob@email.com', 2);

insert into users (username, first_name, last_name, user_password, email, user_role_id) values (
	'ManageJane', 'Jane', 'Doe', 'JanePass', 'jane@email.com', 1);

insert into users (username, first_name, last_name, user_password, email, user_role_id) values (
	'ManageJohn', 'John', 'Johnson', 'JohnPass', 'john@email.com', 1);

insert into reimbursement_status  (reimb_status) values ('pending');
insert into reimbursement_status  (reimb_status) values ('approved');
insert into reimbursement_status  (reimb_status) values ('denied');

delete from reimbursement_type where reimb_type = 'denied';

insert into reimbursement_type (reimb_type) values ('lodging');
insert into reimbursement_type (reimb_type) values ('travel');
insert into reimbursement_type (reimb_type) values ('food');
insert into reimbursement_type (reimb_type) values ('other');

update reimbursement_type set reimb_type_id = 1 where reimb_type = 'lodging';
update reimbursement_type set reimb_type_id = 2 where reimb_type = 'travel';
update reimbursement_type set reimb_type_id = 3 where reimb_type = 'food';
update reimbursement_type set reimb_type_id = 4 where reimb_type = 'other';

insert into reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description,
reimb_author_id, reimb_resolver, reimb_status_id, reimb_type_id) values (
50, '2022-06-11 12:00:05', '2022-06-18 13:30:05','Hotel Stay', 2,3,2,1); 

insert into reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description,
reimb_author_id, reimb_resolver, reimb_status_id, reimb_type_id) values (
25, '2022-07-06 15:45:15', '2022-07-07 10:30:05','Gas', 1,3,3,4); 

insert into reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description,
reimb_author_id, reimb_resolver, reimb_status_id, reimb_type_id) values (
75, '2022-07-07 10:45:05', null ,'Business Dinner', 2,3,1,3);
