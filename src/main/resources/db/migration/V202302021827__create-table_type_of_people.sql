CREATE TABLE typeofpeople (
  id bigint NOT NULL AUTO_INCREMENT COMMENT 'Id da tabela e chave primária',
  type varchar(30) NOT NULL,
  inserted_at datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'Data de inserção',
  updated_at datetime DEFAULT NULL COMMENT 'Data de atualização',
  PRIMARY KEY (id)
  )