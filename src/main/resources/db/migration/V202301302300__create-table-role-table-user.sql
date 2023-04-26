create table role(

    id bigint not null auto_increment,
    role varchar(255) not null,

    primary key(id)

);

create table user(

    id bigint not null auto_increment,
    login varchar(100) not null,
    password varchar(255) not null,
    id_role bigint not null,

    primary key(id),
    FOREIGN KEY (id_role) REFERENCES role(id)

);

insert role(id, role) values (1, 'ROLE_ADMIN');
insert role(id, role) values (2, 'ROLE_USER');

insert user(id, login, password, id_role) values (1, 'cleiton.aguiar', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 1);
insert user(id, login, password, id_role) values (2, 'jonas.araujo', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 2);
insert user(id, login, password, id_role) values (3, 'tulio.albuquerque', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 2);