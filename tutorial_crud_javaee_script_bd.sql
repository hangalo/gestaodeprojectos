-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.10-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema tutorial_crud_javaee
--

CREATE DATABASE IF NOT EXISTS tutorial_crud_javaee;
USE tutorial_crud_javaee;

--
-- Definition of table `categoria_funcionario`
--

DROP TABLE IF EXISTS `categoria_funcionario`;
CREATE TABLE `categoria_funcionario` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome_categoria` varchar(45) DEFAULT NULL,
  `salario_categoria` double DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoria_funcionario`
--

/*!40000 ALTER TABLE `categoria_funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria_funcionario` ENABLE KEYS */;


--
-- Definition of table `colocacao`
--

DROP TABLE IF EXISTS `colocacao`;
CREATE TABLE `colocacao` (
  `id_colocacao` int(11) NOT NULL AUTO_INCREMENT,
  `id_funcionario` int(11) NOT NULL,
  `id_projeto` int(11) NOT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  PRIMARY KEY (`id_colocacao`),
  KEY `fk_colocacao_projecto1_idx` (`id_projeto`),
  KEY `fk_colocacao_funcionario1_idx` (`id_funcionario`),
  CONSTRAINT `fk_colocacao_funcionario1` FOREIGN KEY (`id_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_colocacao_projecto1` FOREIGN KEY (`id_projeto`) REFERENCES `projeto` (`id_projeto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `colocacao`
--

/*!40000 ALTER TABLE `colocacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `colocacao` ENABLE KEYS */;


--
-- Definition of table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome_departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departamento`
--

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;


--
-- Definition of table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


--
-- Definition of table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
CREATE TABLE `municipio` (
  `id_municipio` int(11) NOT NULL AUTO_INCREMENT,
  `nome_municipio` varchar(45) DEFAULT NULL,
  `id_provincia` int(11) NOT NULL,
  PRIMARY KEY (`id_municipio`),
  KEY `fk_municipio_provincia_idx` (`id_provincia`),
  CONSTRAINT `fk_municipio_provincia` FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `municipio`
--

/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;


--
-- Definition of table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
CREATE TABLE `projeto` (
  `id_projeto` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_projeto` char(45) NOT NULL,
  `nome_projeto` varchar(100) DEFAULT NULL,
  `descricao_projeto` varchar(250) DEFAULT NULL,
  `custo_projeto` double DEFAULT NULL,
  `entidade_financiadora` varchar(100) DEFAULT NULL,
  `id_tipo_projeto` int(11) NOT NULL,
  PRIMARY KEY (`id_projeto`),
  UNIQUE KEY `codigo_projecto_UNIQUE` (`codigo_projeto`),
  KEY `fk_projecto_tipo_projecto1_idx` (`id_tipo_projeto`),
  CONSTRAINT `fk_projecto_tipo_projecto1` FOREIGN KEY (`id_tipo_projeto`) REFERENCES `tipo_projeto` (`id_tipo_projeto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `projeto`
--

/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;


--
-- Definition of table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `nome_provincia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provincia`
--

/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;


--
-- Definition of table `tipo_projeto`
--

DROP TABLE IF EXISTS `tipo_projeto`;
CREATE TABLE `tipo_projeto` (
  `id_tipo_projeto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_tipo_projeto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_projeto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_projeto`
--

/*!40000 ALTER TABLE `tipo_projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_projeto` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
