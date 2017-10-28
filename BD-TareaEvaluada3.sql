create database crudjsf;
use crudjsf;
create table cliente(
codigoCliente int auto_increment primary key,
nombre varchar(50) not null,
genero varchar(50) not null
);

create table departamento(
codigoDepartamento int auto_increment primary key,
nombre varchar(50) not null,
cantidadEmpleado int not null
);

create table empleado(
codigoEmpleado int auto_increment primary key,
nombre varchar(50) not null,
genero varchar(50) not null,
intereses varchar(50) not null,
edad int not null,
direccion varchar(50) not null,
cargo varchar(50) not null,
codigoDepartamento int not null,
foreign key(codigoDepartamento) references Departamento(codigoDepartamento)
);
