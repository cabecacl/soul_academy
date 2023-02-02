CREATE TABLE city (
  id_city bigint NOT NULL AUTO_INCREMENT COMMENT 'Id da tabela',
  name varchar(50) NOT NULL COMMENT 'Nome da cidade',
  id_state bigint NOT NULL COMMENT 'Id da tabela State',
  PRIMARY KEY (id_city),
  FOREIGN KEY (id_state) REFERENCES state (id_state)
 )