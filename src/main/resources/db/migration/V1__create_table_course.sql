CREATE TABLE IF NOT EXISTS course(
    id bigint not null auto_increment,
    name varchar(50) not null,
    category varchar(50) not null,
    primary key(id)
);

INSERT INTO course(id,name,category) values (1,'Kotlin','Programacao');