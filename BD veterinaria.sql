create database veterinaria;
use veterinaria;

create table animal(
	id int primary key auto_increment,
    nombre varchar(150) not null,
    tipo varchar(150) not null,
    fecha_registro date not null,
    peso float not null
    
);



