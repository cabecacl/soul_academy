CREATE TABLE state (
  id bigint NOT NULL AUTO_INCREMENT COMMENT 'Id da tabela',
  name varchar(50) NOT NULL COMMENT 'Nome do Estado',
  federative_unit char(2) NOT NULL COMMENT 'UF',
  PRIMARY KEY (id)
  );