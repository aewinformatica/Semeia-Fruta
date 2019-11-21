CREATE TABLE banco_especie (
  codigo bigint(20) NOT NULL AUTO_INCREMENT,
  descricao bigint(20) DEFAULT NULL,
  proprietario tinyblob,
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
  codigo bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(255) DEFAULT NULL,
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE grupo (
  codigo bigint(20) NOT NULL AUTO_INCREMENT,
  nome varchar(255) DEFAULT NULL,
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE grupo_permissao (
  codigo_grupo bigint(20) NOT NULL,
  codigo_permissao bigint(20) NOT NULL,
  KEY FKfp14wb9mt832y4jlw2rx3pf6p (codigo_permissao),
  KEY FKh1lvrl72de4u5xhr1u3jvo0rq (codigo_grupo),
  CONSTRAINT FKfp14wb9mt832y4jlw2rx3pf6p FOREIGN KEY (codigo_permissao) REFERENCES permissao (codigo),
  CONSTRAINT FKh1lvrl72de4u5xhr1u3jvo0rq FOREIGN KEY (codigo_grupo) REFERENCES grupo (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE produto (
  codigo bigint(20) NOT NULL AUTO_INCREMENT,
  content_type varchar(255) DEFAULT NULL,
  descricao varchar(255) DEFAULT NULL,
  foto varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  preco decimal(19,2) DEFAULT NULL,
  quantidade_estoque int(11) NOT NULL,
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE produtor (
  codigo bigint(20) NOT NULL AUTO_INCREMENT,
  ativo bit(1) DEFAULT NULL,
  email varchar(255) NOT NULL,
  nome varchar(255) NOT NULL,
  senha varchar(255) DEFAULT NULL,
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario (
  codigo bigint(20) NOT NULL AUTO_INCREMENT,
  ativo bit(1) DEFAULT NULL,
  data_nascimento tinyblob,
  email varchar(255) NOT NULL,
  nome varchar(255) NOT NULL,
  senha varchar(255) DEFAULT NULL,
  PRIMARY KEY (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_grupo (
  codigo_usuario bigint(20) NOT NULL,
  codigo_grupo bigint(20) NOT NULL,
  PRIMARY KEY (codigo_grupo,codigo_usuario),
  KEY FKcx5f61jsftmpnlu4ec8fyndg3 (codigo_usuario),
  CONSTRAINT FK4yweq9u2sokki6o060mejfw8r FOREIGN KEY (codigo_grupo) REFERENCES grupo (codigo),
  CONSTRAINT FKcx5f61jsftmpnlu4ec8fyndg3 FOREIGN KEY (codigo_usuario) REFERENCES usuario (codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
