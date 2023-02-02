ALTER TABLE user
    ADD COLUMN id_people bigint not null  COMMENT 'Id da tabela People';
ALTER TABLE user
    ADD CONSTRAINT fk_user_people FOREIGN KEY (id_people) REFERENCES people(id_people);
