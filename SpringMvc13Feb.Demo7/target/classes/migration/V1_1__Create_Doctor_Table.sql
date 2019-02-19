drop table if exists doctor;

create table doctor(
id SERIAL primary key,
name varchar(30) not null,
street varchar(200) not null,
	city varchar(30) not null,
	specialization varchar(50) not null,
	age integer not null,
	yearsOfExp integer not null,
	pincode integer not null)