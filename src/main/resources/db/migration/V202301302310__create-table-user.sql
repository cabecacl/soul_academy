create table user(

    id bigint not null auto_increment,
    login varchar(100) not null,
    password varchar(255) not null,
    id_role bigint not null,

    primary key(id),
    FOREIGN KEY (id_role) REFERENCES role(id)

)
