CREATE DATABASE `tutorial_crud_javaee` ;
USE `tutorial_crud_javaee` ;

CREATE TABLE `categoria_funcionario` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(45) DEFAULT NULL,
  `salario_categoria` double DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `colocacao` (
  `id_colocacao` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` int(11) NOT NULL,
  `id_projecto` int(11) NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  PRIMARY KEY (`id_colocacao`),
  KEY `fk_colocacao_projecto1_idx` (`id_projecto`),
  KEY `fk_colocacao_funcionario1_idx` (`id_funcionario`),
  CONSTRAINT `fk_colocacao_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_colocacao_projecto1` FOREIGN KEY (`id_projecto`) REFERENCES `projecto` (`id_projecto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome_departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `funcionario` (
  `id_funcionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_funcionario` varchar(45) DEFAULT NULL,
  `sobrenome_funcionario` varchar(45) DEFAULT NULL,
  `data_nascimento_funcionario` date DEFAULT NULL,
  `sexo_funcionario` char(20) DEFAULT NULL,
  `casa_funcionario` varchar(45) DEFAULT NULL,
  `rua_funcionario` varchar(45) DEFAULT NULL,
  `bairrro_funcionario` varchar(45) DEFAULT NULL,
  `distrito_funcionario` varchar(100) DEFAULT NULL,
  `telefone_unitel` varchar(45) DEFAULT NULL,
  `telefone_movicel` varchar(45) DEFAULT NULL,
  `telefone_fixo` varchar(45) DEFAULT NULL,
  `email_principal` varchar(45) DEFAULT NULL,
  `email_alternativo` varchar(45) DEFAULT NULL,
  `id_departamento` int(11) DEFAULT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `id_municipio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`),
  KEY `fk_funcionario_categoria_funcionario1_idx` (`id_categoria`),
  KEY `fk_funcionario_municipio1_idx` (`id_municipio`),
  KEY `fk_funcionario_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_funcionario_categoria_funcionario1` FOREIGN KEY (`id_categoria`) REFERENCES `categoria_funcionario` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id_departamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_municipio1` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `municipio` (
  `id_municipio` int(11) NOT NULL AUTO_INCREMENT,
  `nome_municipio` varchar(45) DEFAULT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_municipio`),
  KEY `fk_municipio_provincia_idx` (`id_provincia`),
  CONSTRAINT `fk_municipio_provincia` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `projecto` (
  `id_projecto` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_projecto` char(45) NOT NULL,
  `nome_projecto` varchar(100) DEFAULT NULL,
  `descricao_projecto` varchar(250) DEFAULT NULL,
  `custo_projecto` double DEFAULT NULL,
  `entidade_financiadora` varchar(100) DEFAULT NULL,
  `id_tipo_projecto` int(11) NOT NULL,
  PRIMARY KEY (`id_projecto`),
  UNIQUE KEY `codigo_projecto_UNIQUE` (`codigo_projecto`),
  KEY `fk_projecto_tipo_projecto1_idx` (`id_tipo_projecto`),
  CONSTRAINT `fk_projecto_tipo_projecto1` FOREIGN KEY (`id_tipo_projecto`) REFERENCES `tipo_projecto` (`id_tipo_projecto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `nome_provincia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

CREATE TABLE `tipo_projecto` (
  `id_tipo_projecto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_tipo_projecto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_projecto`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
