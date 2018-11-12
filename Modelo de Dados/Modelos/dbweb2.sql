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
INSERT INTO `assento` VALUES (0,0,16,0,1),(1,0,16,0,1),(2,0,16,0,1),(3,0,16,0,1),(4,0,16,0,1),(5,0,16,7,1),(6,0,16,0,1),(7,0,16,0,1),(8,0,16,0,1),(9,0,16,0,1),(10,0,16,0,1),(11,0,16,0,1),(12,0,16,0,1),(13,0,16,0,1),(14,0,16,0,1),(15,0,16,0,1),(16,0,16,0,1),(17,0,16,0,1),(18,0,16,0,1),(19,0,16,0,1),(20,0,16,0,1),(21,0,16,0,1),(22,0,16,0,1),(23,0,16,0,1),(24,0,16,0,1),(25,0,16,7,1),(26,0,16,0,1),(27,0,16,0,1),(28,0,16,0,1),(29,0,16,0,1),(30,0,16,0,1),(31,0,16,0,1),(32,0,16,0,1),(33,0,16,0,1),(34,0,16,0,1),(35,0,16,0,1),(36,0,16,0,1),(37,0,16,0,1),(38,0,16,0,1),(39,0,16,0,1),(40,0,16,0,1),(41,0,16,0,1),(42,0,16,0,1),(43,0,16,0,1),(44,0,16,0,1),(45,0,16,0,1),(46,0,16,0,1),(47,0,16,0,1),(48,0,16,0,1),(49,0,16,0,1),(50,0,16,0,1),(51,0,16,0,1),(52,0,16,0,1),(53,0,16,0,1),(54,0,16,0,1),(55,0,16,0,1),(56,0,16,0,1),(57,0,16,0,1),(58,0,16,0,1),(59,0,16,0,1),(60,0,16,0,1),(61,0,16,0,1),(62,0,16,0,1),(63,0,16,0,1),(64,0,16,0,1),(65,0,16,0,1),(66,0,16,0,1),(67,0,16,0,1),(68,0,16,0,1),(69,0,16,0,1),(70,0,16,0,1),(71,0,16,0,1),(72,0,16,0,1),(73,0,16,0,1),(74,0,16,0,1),(75,0,16,0,1),(76,0,16,0,1),(77,0,16,0,1),(78,0,16,0,1),(79,0,16,0,1),(80,0,16,0,1),(81,0,16,0,1),(82,0,16,0,1),(83,0,16,0,1),(84,0,16,0,1),(85,0,16,0,1),(86,0,16,0,1),(87,0,16,0,1),(88,0,16,0,1),(89,0,16,0,1),(90,0,16,0,1),(91,0,16,0,1),(92,0,16,0,1),(93,0,16,0,1),(94,0,16,0,1),(95,0,16,0,1),(96,0,16,0,1),(97,0,16,0,1),(98,0,16,0,1),(99,0,16,0,1),(0,0,17,0,1),(1,0,17,0,1),(2,0,17,0,1),(3,0,17,0,1),(4,0,17,0,1),(5,0,17,0,1),(6,0,17,0,1),(7,0,17,0,1),(8,0,17,0,1),(9,0,17,0,1),(10,0,17,0,1),(11,0,17,0,1),(12,0,17,0,1),(13,0,17,0,1),(14,0,17,0,1),(15,0,17,0,1),(16,0,17,0,1),(17,0,17,0,1),(18,0,17,0,1),(19,0,17,0,1),(20,0,17,0,1),(21,0,17,0,1),(22,0,17,0,1),(23,0,17,0,1),(24,0,17,0,1),(25,0,17,0,1),(26,0,17,0,1),(27,0,17,0,1),(28,0,17,0,1),(29,0,17,0,1),(30,0,17,0,1),(31,0,17,0,1),(32,0,17,0,1),(33,0,17,0,1),(34,0,17,0,1),(35,0,17,0,1),(36,0,17,0,1),(37,0,17,0,1),(38,0,17,0,1),(39,0,17,0,1),(40,0,17,0,1),(41,0,17,0,1),(42,0,17,0,1),(43,0,17,0,1),(44,0,17,0,1),(45,0,17,0,1),(46,0,17,0,1),(47,0,17,0,1),(48,0,17,0,1),(49,0,17,0,1),(50,0,17,0,1),(51,0,17,0,1),(52,0,17,0,1),(53,0,17,0,1),(54,0,17,0,1),(55,0,17,0,1),(56,0,17,0,1),(57,0,17,0,1),(58,0,17,0,1),(59,0,17,0,1),(60,0,17,0,1),(61,0,17,0,1),(62,0,17,0,1),(63,0,17,0,1),(64,0,17,0,1),(65,0,17,0,1),(66,0,17,0,1),(67,0,17,0,1),(68,0,17,0,1),(69,0,17,0,1),(70,0,17,0,1),(71,0,17,0,1),(72,0,17,0,1),(73,0,17,0,1),(74,0,17,0,1),(75,0,17,0,1),(76,0,17,0,1),(77,0,17,0,1),(78,0,17,0,1),(79,0,17,0,1),(80,0,17,0,1),(81,0,17,0,1),(82,0,17,0,1),(83,0,17,0,1),(84,0,17,0,1),(85,0,17,0,1),(86,0,17,0,1),(87,0,17,0,1),(88,0,17,0,1),(89,0,17,0,1),(90,0,17,0,1),(91,0,17,0,1),(92,0,17,0,1),(93,0,17,0,1),(94,0,17,0,1),(95,0,17,0,1),(96,0,17,0,1),(97,0,17,0,1),(98,0,17,0,1),(99,0,17,0,1);
/*!40000 ALTER TABLE `assento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `assentoscomprados`
--

DROP TABLE IF EXISTS `assentoscomprados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assentoscomprados` (
  `assentosComprados` int(11) NOT NULL,
  `voo_idvoo` int(11) NOT NULL,
  `exclusaoLogica` tinyint(1) DEFAULT '1',
  KEY `fk_assentosComprados_voo1_idx` (`voo_idvoo`),
  CONSTRAINT `fk_assentosComprados_voo1` FOREIGN KEY (`voo_idvoo`) REFERENCES `voo` (`idvoo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assentoscomprados`
--

LOCK TABLES `assentoscomprados` WRITE;
/*!40000 ALTER TABLE `assentoscomprados` DISABLE KEYS */;
/*!40000 ALTER TABLE `assentoscomprados` ENABLE KEYS */;
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
INSERT INTO `cartaodecredito` VALUES ('1111.1111.1111.1112','31/12/2500',7,1),('1111.1111.1111.1143','31/12/2500',7,1),('1111.1111.1111.1444','31/12/2500',1,1),('1111.1111.1111.5555','31/12/2050',10,1),('1111.2222.1111.2222','15/10/2020',7,1),('1111.2222.4444.2222','15/10/2020',1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compravoo`
--

LOCK TABLES `compravoo` WRITE;
/*!40000 ALTER TABLE `compravoo` DISABLE KEYS */;
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
INSERT INTO `usuario` VALUES (0,'padraoAssento','','','','','',NULL,1),(1,'Anderson CLIENTE','Ferreira Canel','R. Severiano das Chagas','and','and','15/04/1988',0,1),(7,'Anderson ADM','Fereira Canel','Rua teste','adm','adm','15/04/1988',1,1),(8,'Alex','Canel','teste','alex','alex','21/01/1990',1,1),(10,'Maria','das Graças','Cap Masceno','maria','maria','11/12/1960',0,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voo`
--

LOCK TABLES `voo` WRITE;
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
INSERT INTO `voo` VALUES (16,'2018-12-15 00:00:00','RJ','MG',0,500,1),(17,'2019-01-10 00:00:00','SP','AM',1,2000,1);
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

-- Dump completed on 2018-11-11 22:38:00
