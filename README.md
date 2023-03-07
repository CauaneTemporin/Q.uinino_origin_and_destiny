# Q.uinino_origin_and_destiny
Website for customers to choose the codes of the cities of origin and destination, the call time in minutes and choose the FaleMais plan.

Passo a passo:

Clonar o repositório quinino /                                                                                                                                         
Configurar o projeto para rodar no java 17 ou superior /                                                                                                               
Adicionar o projeto ao tomcat 9 /                                                                                                                                       
Necessário ter o banco de dados mysql /                                                                                                                                 
Rodar o script sql disponibilizado abaixo /                                                                                                                             
Subir o serviço e acessar o projeto pela url : http://localhost:8080/quinino                                                                                           

Projeto pronto para uso

Script Sql

create database BD_QUININO;

use BD_QUININO;

create table tb_ddd( 
ID integer not null primary key auto_increment,
ORIGEM varchar(3) not null,
DESTINO varchar(3) not null,
PRECO_MINUTO float not null
 ); 

insert into tb_ddd
 (ORIGEM, DESTINO, PRECO_MINUTO) 
Values 
('011', '016', '1.90'),
('016', '011', '2.90'), 
('011', '017', '1.70'), 
('017', '011', '2.70'),
('011', '018', '0.90'),
('018', '011', '1.90');

 select * from tb_ddd;
