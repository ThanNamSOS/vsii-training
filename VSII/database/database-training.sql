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
insert into user(name,phone,gender) values ('Than Nam','+84971265513',true);

drop table Claim ;
create table Claim (
	id int primary key not null auto_increment,
	applicationNumber nvarchar(1028) not null,
    policyNumber nvarchar(1028),
    isDeleted bit,
    createdDate  date
);
select * from Claim;
SELECT * From Claim c where c.applicationNumber = 'dsadsadas';
insert into Claim(applicationNumber,policyNumber,isDeleted,createdDate) values ('dsadsadas','cccccc8',true, '2001-01-01 01:00:00.0000000')