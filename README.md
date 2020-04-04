# customerManagement


create database customer_db;

use customer_db;

create table customer(
						id int (7) primary key auto_increment,
                        first_name varchar(45) default null,
                        last_name varchar(45) default null,
                        dob date ,
                        gender varchar(20) default null,
                        email varchar(50) default null,
                        phn varchar(14) );
                        
                        
                        
  create table manager(id int(6) primary key not null,
					pwd varchar(20) not null);
                    
                    insert into manager values(666,"a10");
