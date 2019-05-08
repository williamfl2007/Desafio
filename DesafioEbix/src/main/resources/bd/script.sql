create table Pessoa
(
   id integer not null auto_increment,
   nome varchar(255) not null,
   idade integer not null,
   primary key(id)
);

insert into Pessoa (id, nome, idade) values (1, 'Ana Ragozone', 21);
insert into Pessoa (id, nome, idade) values (2, 'Carlos', 45);