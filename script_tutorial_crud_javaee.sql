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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `categoria_funcionario`
--

/*!40000 ALTER TABLE `categoria_funcionario` DISABLE KEYS */;
INSERT INTO `categoria_funcionario` (`id_categoria`,`nome_categoria`,`salario_categoria`) VALUES 
 (5,'Director Logistico',8000),
 (6,'Chefe de Cozinha',5000);
/*!40000 ALTER TABLE `categoria_funcionario` ENABLE KEYS */;


--
-- Definition of table `colocacao`
--

DROP TABLE IF EXISTS `colocacao`;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `colocacao`
--

/*!40000 ALTER TABLE `colocacao` DISABLE KEYS */;
INSERT INTO `colocacao` (`id_colocacao`,`id_funcionario`,`id_projecto`,`data_inicio`,`data_fim`) VALUES 
 (2,1,2,'2016-05-05','2016-05-05'),
 (3,1,2,'2014-10-12','2014-10-12');
/*!40000 ALTER TABLE `colocacao` ENABLE KEYS */;


--
-- Definition of table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nome_departamento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_departamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `departamento`
--

/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` (`id_departamento`,`nome_departamento`) VALUES 
 (1,'Contabilidade'),
 (3,'Higiene'),
 (4,'Tecnologias da Informacao');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`id_funcionario`,`nome_funcionario`,`sobrenome_funcionario`,`data_nascimento_funcionario`,`sexo_funcionario`,`casa_funcionario`,`rua_funcionario`,`bairrro_funcionario`,`distrito_funcionario`,`telefone_unitel`,`telefone_movicel`,`telefone_fixo`,`email_principal`,`email_alternativo`,`id_departamento`,`id_categoria`,`id_municipio`) VALUES 
 (1,NULL,NULL,NULL,'M',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,6,5),
 (2,'Joaquim','Hangalo','1974-05-15','F','12','12','Rangel','Rangle','22222','22222','2222','hangalo@hangalo.com','hangalo@hangalo.com',4,5,28);
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
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `municipio`
--

/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` (`id_municipio`,`nome_municipio`,`id_provincia`) VALUES 
 (4,'Dembos',1),
 (5,'Nambuangongo',1),
 (6,'Pango Aluquém',1),
 (7,'Balombo',2),
 (8,'Baia Farta',2),
 (9,'Benguela',2),
 (10,'Bocoio',2),
 (11,'Caimbambo',2),
 (12,'Catumbela',2),
 (13,'Chongoroi',2),
 (14,'Cubal',2),
 (15,'Ganda',2),
 (16,'Lobito',2),
 (17,'Andulo',3),
 (18,'Camacupa',3),
 (19,'Catabola',3),
 (20,'Chinguar',3),
 (21,'Chitembo',3),
 (22,'Cuemba',3),
 (23,'Cunhinga',3),
 (24,'Kuito',3),
 (25,'Nharea',3),
 (26,'Belize',4),
 (27,'Buco-Zau',4),
 (28,'Cabinda',4),
 (29,'Cacongo',4),
 (30,'Calai',5),
 (31,'Cuangar',5),
 (32,'Cuchi',5),
 (33,'Cuito Cuanavale',5),
 (34,'Dirico',5),
 (35,'Mavinga',5),
 (36,'Menongue',5),
 (37,'Nancova',5),
 (38,'Rivungo',5),
 (39,'Cahama',8),
 (40,'Cuanhama',8),
 (41,'Curoca',8),
 (42,'Cuvelai',8),
 (43,'Namacunde',8),
 (44,'Ombadja',8),
 (45,'Bailundo',9),
 (46,'Catchiungo',9),
 (47,'Caala',9),
 (48,'Ekuma',9),
 (49,'Huambo',9),
 (50,'Londuimbale',9),
 (51,'Longonjo',9),
 (52,'Mungo',9),
 (53,'Tchicala-Tchiloanga',9),
 (54,'Tchindjenje',9),
 (55,'Ucuma',9),
 (56,'Caconda',10),
 (57,'Cacula',10),
 (58,'Caluquembe',10),
 (59,'Gambos',10),
 (60,'Chibia',10),
 (61,'Chicomba',10),
 (62,'Chipindo',10),
 (63,'Cuvango',10),
 (64,'Humpata',10),
 (65,'Jamba',10),
 (66,'Lubango',10),
 (67,'Matala',10),
 (68,'Quilengues',10),
 (69,'Quipungo',10),
 (70,'Ambaca',6),
 (71,'Banga',6),
 (72,'Bolongongo',6),
 (73,'Cambambe',6),
 (74,'Cazengo',6),
 (75,'Golungo Alto',6),
 (76,'Gonguembo',6),
 (77,'Lucala',6),
 (78,'Quiculungo',6),
 (79,'Samba Caju',6),
 (80,'Cassongue',7),
 (81,'Conda',7),
 (82,'Ebo',7),
 (83,'Libolo',7),
 (84,'Mussende',7),
 (85,'Porto Amboin',7),
 (86,'Quibala',7),
 (87,'Quilenda',7),
 (88,'Seles',7),
 (89,'Sumbe',7),
 (90,'Waku Kungo',7),
 (91,'Belas',11),
 (92,'Cacuaco',11),
 (93,'Cazenga',11),
 (94,'Icolo e Bengo',11),
 (95,'Luanda',11),
 (96,'Quiçama',11),
 (97,'Viana',11),
 (98,'Cambulo',12),
 (99,'Capenda-Camulemba',12),
 (100,'Caungula',12),
 (101,'Chitato',12),
 (102,'Cuango',12),
 (103,'Cuilo',12),
 (104,'Lubalo',12),
 (105,'Lukapa',12),
 (106,'Xá-Muteba',12),
 (107,'Cacolo',13),
 (108,'Dala',13),
 (109,'Muconda',13),
 (110,'Saurimo',13),
 (111,'Cacuso',14),
 (112,'Calandula',14),
 (113,'Cambundi-Catembo',14),
 (114,'Cangandala',14),
 (115,'Caombo',14),
 (116,'Cuaba Nzogo',14),
 (117,'Cunda-Dia-Baze',14),
 (118,'Luquembo',14),
 (119,'Malange',14),
 (120,'Marimba',14),
 (121,'Massango',14),
 (122,'Mucari',14),
 (123,'Quela',14),
 (124,'Quirima',14),
 (125,'Alto Zambeze',15),
 (126,'Bundas',15),
 (127,'Camanongue',15),
 (128,'Léua',15),
 (129,'Luau',15),
 (130,'Luacano',15),
 (131,'Luchazes',15),
 (132,'Lumeje',15),
 (133,'Moxico',15),
 (134,'Bibala',16),
 (135,'Camucuio',16),
 (136,'Namibe',16),
 (137,'Tômbua',16),
 (138,'Virei',16),
 (139,'Alto Cauale',17),
 (140,'Ambuila',17),
 (141,'Bembe',17),
 (142,'Buengas',17),
 (143,'Bungo',17),
 (144,'Damba',17),
 (145,'Macocola',17),
 (146,'Mucaba',17),
 (147,'Negage',17),
 (148,'Puri',17),
 (149,'Quimbele',17),
 (150,'Quitexe',17),
 (151,'Sanza Pombo',17),
 (152,'Songo',17),
 (153,'Uige',17),
 (154,'Zombo',17),
 (155,'Cuimba',18),
 (156,'M\'Banza Kongo',18),
 (157,'Noqui',18),
 (158,'N\'Zeto',18),
 (159,'Soyo',18),
 (160,'Tomboco',18);
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;


--
-- Definition of table `projecto`
--

DROP TABLE IF EXISTS `projecto`;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `projecto`
--

/*!40000 ALTER TABLE `projecto` DISABLE KEYS */;
INSERT INTO `projecto` (`id_projecto`,`codigo_projecto`,`nome_projecto`,`descricao_projecto`,`custo_projecto`,`entidade_financiadora`,`id_tipo_projecto`) VALUES 
 (1,'1111','Sistema de planeamento','',40000,'Ministerio do Desenvolvimento',5),
 (2,'SIAP','Sistema de aprendizagem','',9000,'Ministerio da Educacao',4);
/*!40000 ALTER TABLE `projecto` ENABLE KEYS */;


--
-- Definition of table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id_provincia` int(11) NOT NULL AUTO_INCREMENT,
  `nome_provincia` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_provincia`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provincia`
--

/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` (`id_provincia`,`nome_provincia`) VALUES 
 (1,'Bengo'),
 (2,'Benguela'),
 (3,'Bié'),
 (4,'Cabinda'),
 (5,'Cuando Cubango'),
 (6,'Cuanza Norte'),
 (7,'Cuanza Sul'),
 (8,'Cunene'),
 (9,'Huambo'),
 (10,'Huila'),
 (11,'Luanda'),
 (12,'Lunda Norte'),
 (13,'Lunda Sul'),
 (14,'Malange'),
 (15,'Moxico'),
 (16,'Namibe'),
 (17,'Uige'),
 (18,'Zaire');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;


--
-- Definition of table `tipo_projecto`
--

DROP TABLE IF EXISTS `tipo_projecto`;
CREATE TABLE `tipo_projecto` (
  `id_tipo_projecto` int(11) NOT NULL AUTO_INCREMENT,
  `nome_tipo_projecto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_projecto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_projecto`
--

/*!40000 ALTER TABLE `tipo_projecto` DISABLE KEYS */;
INSERT INTO `tipo_projecto` (`id_tipo_projecto`,`nome_tipo_projecto`) VALUES 
 (4,'Software de Gestao Escolar'),
 (5,'Software de Gestao Empresarial');
/*!40000 ALTER TABLE `tipo_projecto` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
