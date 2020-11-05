SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';


# Data Base Xavier Bouvet Johny LIN A4 ESILV JavaEE
drop database Identification;
CREATE DATABASE IF NOT EXISTS Identification ;
use Identification;

#Etape 1 Table Login
drop table register;

CREATE TABLE register (
  identifiant  VARCHAR(30) NOT NULL ,
  password VARCHAR(30),
  status int(1),
  CONSTRAINT pk_identifiant PRIMARY KEY (identifiant)
);

INSERT INTO register VALUES('Thai','1',1);
INSERT INTO register VALUES('Gossard','2',1);
INSERT INTO register VALUES('Nada','2',1);
INSERT INTO register VALUES('Johny','3',0);
INSERT INTO register VALUES('Xavier','3',0);



select status from register where identifiant="Gossard" and password="2";
select * from register;

#Etape 2 Table todo
drop table todo;
create table todo (
id int(10) primary key auto_increment,
descrip varchar (80)
);
#auto incrementation de l'id

insert into todo (descrip) value ('Faire le projet de JavaEE');
insert into todo (descrip) value ('Faire une convcall avec son binome');
insert into todo (descrip) value ('Preparer le prochain cours');
insert into todo (descrip) value ('Preparer le cours de Machine Learning');
insert into todo (descrip) value ('Profiter de vos vacances');

DELETE from todo where id ='5';

select * from todo

