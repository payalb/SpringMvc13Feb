drop table if exists account;
create table account(
accountNumber serial primary key,
bank varchar(100) not null,
balance decimal(100,2) not null,
version integer
);
drop table if exists user_details;
CREATE TABLE user_details
(
	username varchar(30) primary key,
	password varchar(150) not null
);
"Password for payal is payal123"
insert into user_details (username, password) values ('payal','$2a$11$iHdNkl0OI6tWiBBvyTefgOpp3kixcwsTGVKA5bpGe/jWawN/o6d3G');
insert into user_details (username, password) values ('admin','$2a$11$KK6vx/nTnuf614g0OW4DPek///j3VOVRhKv/5Z6u2DXcP89hS0BmS');
commit;


create table user_roles 
(
	username varchar(30) references user_details(username),
	authority varchar(30)
);

insert into user_roles values ('payal', 'ROLE_CUSTOMER');
insert into user_roles values ('admin', 'ROLE_ADMIN');
insert into user_roles values ('payal', 'ROLE_ADMIN');