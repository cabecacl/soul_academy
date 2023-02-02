CREATE TABLE people (
  id_people bigint NOT NULL AUTO_INCREMENT COMMENT 'Id da tabela e chave primária',
  name varchar(100) NOT NULL COMMENT 'Nome do usuário',
  registration_number varchar(11) NOT NULL COMMENT 'CPF ou CNPJ',
  phone_number varchar(11) DEFAULT NULL COMMENT 'Telefone',
  email varchar(50) DEFAULT NULL COMMENT 'E-mail',
  address varchar(100) DEFAULT NULL COMMENT 'Endereço',
  zip_code varchar(10) DEFAULT NULL COMMENT 'CEP',
  id_city bigint NOT NULL COMMENT 'Id da tabela City',
  id_type_of_people bigint NOT NULL COMMENT 'Id da tabela TypeOfPeople',
  inserted_at datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Data de inserção',
  updated_at datetime DEFAULT NULL COMMENT 'Data de atualização',
  PRIMARY KEY (id_people),
  UNIQUE KEY registration_number_UNIQUE (registration_number),
  FOREIGN KEY (id_city) REFERENCES city (id_city),
  FOREIGN KEY (id_type_of_people) REFERENCES typeofpeople (id_type)
)