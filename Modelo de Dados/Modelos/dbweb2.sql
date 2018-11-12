-- MySQL dump 10.13  Distrib 5.6.35, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: dbweb2
-- ------------------------------------------------------
-- Server version	5.6.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `dbweb2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `dbweb2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dbweb2`;

--
-- Table structure for table `assento`
--

DROP TABLE IF EXISTS `assento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assento` (
  `idassento` int(11) NOT NULL,
  `ocupado` tinyint(1) NOT NULL DEFAULT '0',
  `voo_idvoo` int(11) NOT NULL,
  `USUARIO_IDUSUARIO` int(11) NOT NULL,
  `exclusaoLogica` tinyint(1) DEFAULT '1',
  `comfirmaPagamento` tinyint(1) DEFAULT '0',
  KEY `fk_assento_voo1_idx` (`voo_idvoo`),
  KEY `fk_assento_USUARIO1_idx` (`USUARIO_IDUSUARIO`),
  CONSTRAINT `fk_assento_USUARIO1` FOREIGN KEY (`USUARIO_IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_assento_voo1` FOREIGN KEY (`voo_idvoo`) REFERENCES `voo` (`idvoo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assento`
--

LOCK TABLES `assento` WRITE;
/*!40000 ALTER TABLE `assento` DISABLE KEYS */;
INSERT INTO `assento` VALUES (0,1,22,7,1,1),(1,0,22,7,1,0),(2,1,22,7,1,1),(3,1,22,7,1,1),(4,1,22,7,1,1),(5,0,22,7,1,0),(6,0,22,7,1,0),(7,0,22,7,1,0),(8,0,22,7,1,0),(9,0,22,7,1,0),(10,0,22,7,1,0),(11,0,22,7,1,0),(12,0,22,0,1,0),(13,0,22,0,1,0),(14,0,22,0,1,0),(15,0,22,0,1,0),(16,0,22,0,1,0),(17,0,22,0,1,0),(18,0,22,0,1,0),(19,0,22,0,1,0),(20,0,22,7,1,0),(21,0,22,0,1,0),(22,0,22,0,1,0),(23,0,22,0,1,0),(24,0,22,0,1,0),(25,0,22,0,1,0),(26,0,22,0,1,0),(27,0,22,0,1,0),(28,0,22,7,1,0),(29,0,22,0,1,0),(30,0,22,0,1,0),(31,0,22,0,1,0),(32,0,22,0,1,0),(33,0,22,0,1,0),(34,0,22,0,1,0),(35,0,22,0,1,0),(36,0,22,0,1,0),(37,0,22,0,1,0),(38,0,22,0,1,0),(39,0,22,0,1,0),(40,0,22,0,1,0),(41,0,22,0,1,0),(42,0,22,0,1,0),(43,0,22,0,1,0),(44,0,22,0,1,0),(45,0,22,0,1,0),(46,0,22,0,1,0),(47,0,22,0,1,0),(48,0,22,0,1,0),(49,0,22,0,1,0),(50,0,22,0,1,0),(51,0,22,0,1,0),(52,0,22,0,1,0),(53,0,22,0,1,0),(54,0,22,0,1,0),(55,0,22,0,1,0),(56,0,22,0,1,0),(57,0,22,0,1,0),(58,0,22,0,1,0),(59,0,22,0,1,0),(60,0,22,0,1,0),(61,0,22,0,1,0),(62,0,22,0,1,0),(63,0,22,0,1,0),(64,0,22,0,1,0),(65,0,22,0,1,0),(66,0,22,0,1,0),(67,0,22,0,1,0),(68,0,22,0,1,0),(69,0,22,0,1,0),(70,0,22,0,1,0),(71,0,22,0,1,0),(72,0,22,0,1,0),(73,0,22,0,1,0),(74,0,22,0,1,0),(75,0,22,0,1,0),(76,0,22,0,1,0),(77,0,22,0,1,0),(78,0,22,0,1,0),(79,0,22,0,1,0),(80,0,22,0,1,0),(81,0,22,7,1,1),(82,0,22,0,1,0),(83,0,22,0,1,0),(84,0,22,0,1,0),(85,0,22,0,1,0),(86,0,22,0,1,0),(87,0,22,0,1,0),(88,0,22,0,1,0),(89,0,22,0,1,0),(90,0,22,0,1,0),(91,0,22,0,1,0),(92,0,22,0,1,0),(93,0,22,0,1,0),(94,0,22,0,1,0),(95,1,22,7,1,1),(96,0,22,0,1,0),(97,1,22,7,1,1),(98,0,22,0,1,0),(99,1,22,7,1,1);
/*!40000 ALTER TABLE `assento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartaodecredito`
--

DROP TABLE IF EXISTS `cartaodecredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartaodecredito` (
  `NUMEROCARTAO` varchar(19) NOT NULL,
  `DATAVENCIMENTO` varchar(12) NOT NULL,
  `USUARIO_IDUSUARIO` int(11) NOT NULL,
  `exclusaoLogica` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`NUMEROCARTAO`),
  KEY `USUARIO_IDUSUARIO` (`USUARIO_IDUSUARIO`),
  CONSTRAINT `` FOREIGN KEY (`USUARIO_IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartaodecredito`
--

LOCK TABLES `cartaodecredito` WRITE;
/*!40000 ALTER TABLE `cartaodecredito` DISABLE KEYS */;
INSERT INTO `cartaodecredito` VALUES ('1111.1111.1111.1112','31/12/2500',7,1),('1111.1111.1111.1143','31/12/2500',7,1),('1111.1111.1111.1444','31/12/2500',1,1),('1111.1111.1111.5555','31/12/2050',10,1),('1111.2222.1111.2222','15/10/2020',7,1),('1111.2222.4444.2222','15/10/2020',1,1),('1111.5555.1111.2222','15/10/1050',2147483647,0);
/*!40000 ALTER TABLE `cartaodecredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compravoo`
--

DROP TABLE IF EXISTS `compravoo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compravoo` (
  `idcompraVoo` int(11) NOT NULL AUTO_INCREMENT,
  `voo_idvoo` int(11) NOT NULL,
  `voo_idvooVolta` int(11) DEFAULT NULL,
  `usuario_IDUSUARIO` int(11) NOT NULL,
  `cartaodecredito_NUMEROCARTAO` varchar(19) NOT NULL,
  `valorTotalCompra` int(11) NOT NULL DEFAULT '0',
  `horaDaCompra` datetime NOT NULL,
  `exclusaoLogica` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idcompraVoo`),
  KEY `fk_compravoo_voo1_idx` (`voo_idvoo`),
  KEY `fk_compravoo_usuario1_idx` (`usuario_IDUSUARIO`),
  KEY `fk_compravoo_cartaodecredito1_idx` (`cartaodecredito_NUMEROCARTAO`),
  KEY `fk_compravoo_voo2_idx` (`voo_idvooVolta`),
  CONSTRAINT `fk_compravoo_cartaodecredito1` FOREIGN KEY (`cartaodecredito_NUMEROCARTAO`) REFERENCES `cartaodecredito` (`NUMEROCARTAO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compravoo_usuario1` FOREIGN KEY (`usuario_IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compravoo_voo1` FOREIGN KEY (`voo_idvoo`) REFERENCES `voo` (`idvoo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compravoo_voo2` FOREIGN KEY (`voo_idvooVolta`) REFERENCES `voo` (`idvoo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compravoo`
--

LOCK TABLES `compravoo` WRITE;
/*!40000 ALTER TABLE `compravoo` DISABLE KEYS */;
INSERT INTO `compravoo` VALUES (6,22,22,7,'1111.1111.1111.1112',9000,'2018-11-12 15:14:17',1),(7,22,22,7,'1111.1111.1111.1112',21000,'2018-11-12 15:15:23',1);
/*!40000 ALTER TABLE `compravoo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `IDUSUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(25) NOT NULL,
  `SOBRENOME` varchar(50) NOT NULL,
  `ENDERECO` varchar(255) NOT NULL,
  `SENHA` varchar(12) NOT NULL,
  `LOGIN` varchar(20) NOT NULL,
  `DATANASCIMENTO` varchar(12) NOT NULL,
  `isadm` tinyint(1) DEFAULT NULL,
  `exclusaoLogica` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`IDUSUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=2147483647 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (0,'padraoAssento','','','','','',NULL,1),(1,'Anderson CLIENTE','Ferreira Canel','R. Severiano das Chagas','and','and','15/04/1988',0,1),(7,'Anderson ADM','Fereira Canel','Rua teste','adm','adm','15/04/1988',1,1),(8,'Alex','Canel','teste','alex','alex','21/01/1992',0,1),(10,'Maria','das Graças','Cap Masceno','maria','maria','11/12/1960',0,1),(2147483647,'a','a','a','a','a','01/01/1980',0,0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voo`
--

DROP TABLE IF EXISTS `voo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voo` (
  `idvoo` int(11) NOT NULL AUTO_INCREMENT,
  `ida` datetime NOT NULL,
  `origem` varchar(100) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `confirmacao` tinyint(1) NOT NULL DEFAULT '0',
  `valorVoo` int(11) NOT NULL DEFAULT '0',
  `exclusaoLogica` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idvoo`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voo`
--

LOCK TABLES `voo` WRITE;
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
INSERT INTO `voo` VALUES (22,'2020-10-15 00:00:00','MG','NY',1,3000,1);
/*!40000 ALTER TABLE `voo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12 15:18:19
