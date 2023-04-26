insert role(id, role) values (1, 'ROLE_ADMIN');
insert role(id, role) values (2, 'ROLE_USER');

insert user(id, login, password, id_role) values (1, 'cleiton.aguiar', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 1);
insert user(id, login, password, id_role) values (2, 'jonas.araujo', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.', 2);