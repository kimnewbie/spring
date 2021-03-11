create table users(
	userid varchar2(50) primary key,
	userpw varchar2(100) not null,
	enabled char(1)
);

create table uauthorities(
	userid varchar2(50) primary key,
	auth varchar2(50) not null
);

desc users;
desc uauthorities;
