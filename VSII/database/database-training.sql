create database test_vsii;
use test_vsii;

drop table user;
create table user(
	id int primary key not null AUTO_INCREMENT,
	name nvarchar(255),
    phone nvarchar(15),
    gender bit
);
select * from user;
insert into user(name,phone,gender) values ('Than Nam','+84971265513',true)