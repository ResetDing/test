create table customer(
	id int not null auto_increment,
	name varchar(32) not null,
	account varchar(32) not null,
	password VARCHAR(32) not null,
	balance double null,
	PRIMARY key (id)
);