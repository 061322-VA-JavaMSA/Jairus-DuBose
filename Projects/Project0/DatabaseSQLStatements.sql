drop table if exists users;
create table if not exists users(
	id serial primary key,
	username varchar(50) not null,
	password varchar(50) not null,
	usertype varchar(50) not null
);

drop table if exists weapons;
create table if not exists weapons(
	id serial primary key,
	weapon_name varchar(50) not null,
	weapon_price integer not null,
	weapon_quantity integer not null
	
);

drop table if exists armours;
create table if not exists armours(
	id serial primary key,
	armour_name varchar(50) not null,
	armour_price integer not null,
	armour_quantity integer not null

);

drop table if exists potions;
create table if not exists potions(
	id serial primary key,
	potion_name varchar(50) not null,
	potion_price integer not null,
	potion_quantity integer not null

);

drop table if exists transactions;
create table if not exists transactions(

	id serial primary key,
	item_purchased varchar(50) not null,
	customer_name varchar(50) not null,
	transaction_date Date not null,
	transaction_amount integer not null, 
	transaction_status varchar(50) not null

);

--Data I created
insert into users (username, password, usertype) values ('Jairus', 'password', 'manager');
insert into users (username, password, usertype) values ('Bob', 'password1', 'employee');

--Data generated from mockaroo
insert into users (username, password, usertype) values ('djaszczak0', 'npDDWJ5v', 'customer');
insert into users (username, password, usertype) values ('fraoul1', 'GijjEzTYQUa', 'customer');
insert into users (username, password, usertype) values ('doshevlan2', 'fCD4t8k3zts', 'customer');
insert into users (username, password, usertype) values ('iwilcox3', 'zkQxNtyyX', 'customer');
insert into users (username, password, usertype) values ('tkidds4', '6xr1dtb', 'customer');
insert into users (username, password, usertype) values ('winkster5', 'I6oQFA8r2ar7', 'customer');
insert into users (username, password, usertype) values ('fmeert6', 'ppVky07Zae', 'customer');
insert into users (username, password, usertype) values ('byapp7', 'qkxL5P8U', 'customer');

insert into users (username, password, usertype) values ('Barron', 'kgJgmPqNjz', 'customer');
insert into users (username, password, usertype) values ('Adolphus', 'xwtkiS', 'customer');
insert into users (username, password, usertype) values ('Sherilyn', 'ChIFYv2RvJCj', 'customer');
insert into users (username, password, usertype) values ('Zara', 'ZY9qXd4Do', 'customer');
insert into users (username, password, usertype) values ('Margaux', 'ePCaGgGkJPGx', 'customer');
insert into users (username, password, usertype) values ('Benedikta', 'gFBDsJ', 'customer');
insert into users (username, password, usertype) values ('Joshuah', 'IRIXqe', 'customer');
insert into users (username, password, usertype) values ('Caty', 'UI5Zqhrp6izt', 'customer');
insert into users (username, password, usertype) values ('Tawsha', 'opKOOkdIhD', 'customer');
insert into users (username, password, usertype) values ('Tootsie', '1xqa0PmSNC', 'customer');

insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Dagger', 'Barron', '2022-06-21 20:00:46', 2,'pending');
insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Hide', 'Barron', '2022-04-06 12:53:52', 10,'pending');
insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Healing', 'Caty', '2022-06-08 17:04:20', 150,'pending');
insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Breastplate', 'Caty', '2022-04-28 14:23:50', 400,'pending');
insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Shortbow', 'Joshuah', '2022-02-14 21:37:08', 25,'pending');
insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Shield', 'Joshuah', '2022-05-26 15:19:41', 10,'accecpted');
insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Studded Leather', 'Zara', '2022-03-11 20:51:00', 45,'accecpted');
insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Invisibility', 'Zara', '2022-06-07 18:04:30', 500,'accecpted');
insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Acid Resistance', 'Adolphus', '2022-05-15 05:56:41', 100,'accecpted');
insert into transactions (item_purchased, customer_name, transaction_date, transaction_amount, transaction_status) values ('Fire Resistance', 'Adolphus', '2022-05-31 19:16:03', 200,'accecpted');

--Data I created
insert into weapons (weapon_name, weapon_price, weapon_quantity) values ('Dagger', 2, 10);
insert into weapons (weapon_name, weapon_price, weapon_quantity) values ('Greatsword', 50, 10);
insert into weapons (weapon_name, weapon_price, weapon_quantity) values ('Longsword', 15, 10);
insert into weapons (weapon_name, weapon_price, weapon_quantity) values ('Shortsword', 10, 10);
insert into weapons (weapon_name, weapon_price, weapon_quantity) values ('Crossbow', 75, 10);
insert into weapons (weapon_name, weapon_price, weapon_quantity) values ('Longbow', 50, 10);
insert into weapons (weapon_name, weapon_price, weapon_quantity) values ('Blowgun', 10, 10);
insert into weapons (weapon_name, weapon_price, weapon_quantity) values ('Shortbow', 25, 10);

insert into armours (armour_name, armour_price, armour_quantity) values ('Leather', 10, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Hide', 10, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Breastplate', 400, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Plate', 1500, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Shield', 10, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Studded Leather', 45, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Scale Mail', 50, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Chain Mail', 75, 10);

insert into armours (armour_name, armour_price, armour_quantity) values ('Leather', 10, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Hide', 10, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Breastplate', 400, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Plate', 1500, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Shield', 10, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Studded Leather', 45, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Scale Mail', 50, 10);
insert into armours (armour_name, armour_price, armour_quantity) values ('Chain Mail', 75, 10);

insert into potions (potion_name, potion_price, potion_quantity) values ('Speed', 1000, 10);
insert into potions (potion_name, potion_price, potion_quantity) values ('Flying', 900, 10);
insert into potions (potion_name, potion_price, potion_quantity) values ('Growth', 400, 10);
insert into potions (potion_name, potion_price, potion_quantity) values ('Healing', 150, 10);
insert into potions (potion_name, potion_price, potion_quantity) values ('Invisibility', 500, 10);
insert into potions (potion_name, potion_price, potion_quantity) values ('Acid Resistance', 100, 10);
insert into potions (potion_name, potion_price, potion_quantity) values ('Fire Resistance', 150, 10);
insert into potions (potion_name, potion_price, potion_quantity) values ('Cold Resistance', 200, 10);

--Testing Select Statements

select users.username from users where users.usertype = 'manager'; 
select users.username from users where users.usertype = 'employee'; 

select users.username from users where users.usertype = 'customer'; 
select users.username from users where users.username = 'fraoul1'; 

select weapons.weapon_name from weapons where weapons.weapon_name = 'Dagger'; 
select weapons.weapon_name from weapons where weapons.weapon_name = 'Shortsword'; 
select weapons.weapon_name from weapons where weapons.weapon_name = 'Longsword'; 

select armours.armour_name from armours where armours.armour_name = 'Leather'; 
select armours.armour_name from armours where armours.armour_name = 'Plate'; 
select armours.armour_name from armours where armours.armour_name = 'Shield'; 

select potions.potion_name from potions where potions.potion_name = 'Healing'; 
select potions.potion_name from potions where potions.potion_name = 'Fire Resistance'; 
select potions.potion_name from potions where potions.potion_name = 'Cold Resistance'; 

select weapons.weapon_name, weapons.weapon_price from weapons where weapons.weapon_name = 'Dagger';  
select weapons.weapon_name, weapons.weapon_price from weapons where weapons.weapon_name = 'Shortsword';  
select weapons.weapon_name, weapons.weapon_price from weapons where weapons.weapon_name = 'Longsword';  

select armours.armour_name, armours.armour_price from armours where armours.armour_name = 'Leather';  
select armours.armour_name, armours.armour_price from armours where armours.armour_name = 'Plate';  
select armours.armour_name, armours.armour_price from armours where armours.armour_name = 'Shield';  

select potions.potion_name, potions.potion_price from potions where potions.potion_name = 'Healing';  
select potions.potion_name, potions.potion_price from potions where potions.potion_name = 'Fire Resistance';  
select potions.potion_name, potions.potion_price from potions where potions.potion_name = 'Cold Resistance';  

select * from users where users.id = 2; 
select * from users where users.username = 'Jairus';

update weapons set weapon_quantity = 5 where weapon_name = 'Dagger'; 

select weapons.weapon_price from weapons where weapon_name = 'Dagger'; 

insert into weapons (weapon_name, weapon_price ,weapon_quantity) values ('Dagger',2,10); 
delete from weapons where id = 11; 

update armours set armour_quantity = 15 where armour_name = 'Hide'; 

select * from weapons; 

select * from weapons where weapon_quantity  <= 10;

insert into users (username, password, usertype) values ('Test','TestPass','TestCustomer');

select * from users where users.username = 'Jairus' and users.password = 'password'; 

select * from transactions where transactions.transaction_status = 'pending';
select * from transactions where transactions.transaction_status = 'accecpted';
select * from transactions where transactions.customer_name  = 'Barron';

update transactions set transaction_status = 'accepted' where id = 15;
