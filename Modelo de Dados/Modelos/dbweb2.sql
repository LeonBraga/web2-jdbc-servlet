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
INSERT INTO `assento` VALUES (0,0,4,7),(1,0,4,7),(2,0,4,1),(3,1,4,1),(4,0,4,7),(5,0,4,1),(6,0,4,1),(7,0,4,1),(8,0,4,1),(9,0,4,1),(10,0,4,1),(11,0,4,1),(12,0,4,7),(13,0,4,7),(14,0,4,7),(15,0,4,1),(16,0,4,1),(17,0,4,1),(18,1,4,2),(19,1,4,1),(20,0,4,7),(21,0,4,1),(22,0,4,1),(23,0,4,1),(24,0,4,1),(25,0,4,1),(26,0,4,1),(27,0,4,1),(28,0,4,1),(29,0,4,1),(30,0,4,1),(31,1,4,2),(32,0,4,1),(33,0,4,1),(34,1,4,1),(35,0,4,7),(36,0,4,1),(37,0,4,1),(38,0,4,1),(39,0,4,1),(40,0,4,7),(41,0,4,1),(42,0,4,1),(43,0,4,1),(44,1,4,2),(45,0,4,1),(46,0,4,1),(47,0,4,1),(48,0,4,1),(49,0,4,1),(50,0,4,1),(51,0,4,1),(52,0,4,1),(53,0,4,1),(54,0,4,7),(55,0,4,1),(56,0,4,1),(57,0,4,1),(58,0,4,1),(59,0,4,1),(60,0,4,1),(61,0,4,1),(62,0,4,1),(63,0,4,1),(64,0,4,1),(65,0,4,1),(66,0,4,1),(67,0,4,7),(68,0,4,1),(69,0,4,1),(70,0,4,1),(71,0,4,1),(72,0,4,1),(73,0,4,1),(74,0,4,1),(75,0,4,1),(76,0,4,1),(77,0,4,7),(78,0,4,1),(79,0,4,1),(80,0,4,1),(81,1,4,7),(82,0,4,1),(83,0,4,1),(84,0,4,1),(85,0,4,1),(86,0,4,1),(87,0,4,1),(88,0,4,1),(89,0,4,1),(90,0,4,1),(91,0,4,1),(92,0,4,1),(93,0,4,1),(94,0,4,1),(95,1,4,7),(96,0,4,1),(97,0,4,7),(98,0,4,1),(99,0,4,1),(0,0,6,1),(1,0,6,1),(2,0,6,1),(3,1,6,7),(4,0,6,7),(5,0,6,7),(6,0,6,1),(7,0,6,1),(8,0,6,1),(9,0,6,1),(10,1,6,2),(11,0,6,1),(12,0,6,1),(13,0,6,1),(14,0,6,1),(15,0,6,1),(16,0,6,1),(17,0,6,1),(18,0,6,1),(19,1,6,7),(20,0,6,1),(21,0,6,1),(22,0,6,1),(23,0,6,1),(24,0,6,1),(25,0,6,1),(26,0,6,1),(27,0,6,7),(28,0,6,1),(29,0,6,1),(30,1,6,2),(31,0,6,1),(32,0,6,1),(33,0,6,1),(34,1,6,7),(35,0,6,1),(36,0,6,1),(37,0,6,1),(38,0,6,1),(39,0,6,7),(40,0,6,1),(41,0,6,1),(42,0,6,1),(43,0,6,1),(44,0,6,1),(45,0,6,1),(46,0,6,1),(47,0,6,1),(48,1,6,7),(49,0,6,1),(50,0,6,1),(51,0,6,1),(52,0,6,1),(53,0,6,7),(54,0,6,1),(55,0,6,1),(56,0,6,1),(57,0,6,1),(58,0,6,1),(59,0,6,1),(60,0,6,1),(61,0,6,1),(62,0,6,1),(63,0,6,1),(64,0,6,1),(65,0,6,1),(66,0,6,1),(67,1,6,7),(68,0,6,1),(69,0,6,1),(70,0,6,1),(71,0,6,1),(72,0,6,1),(73,0,6,1),(74,0,6,1),(75,0,6,1),(76,0,6,1),(77,0,6,1),(78,0,6,1),(79,0,6,1),(80,0,6,1),(81,0,6,7),(82,0,6,1),(83,0,6,1),(84,0,6,1),(85,0,6,1),(86,0,6,1),(87,0,6,1),(88,0,6,1),(89,0,6,1),(90,0,6,1),(91,0,6,1),(92,0,6,1),(93,0,6,1),(94,0,6,1),(95,1,6,7),(96,0,6,1),(97,0,6,1),(98,0,6,1),(99,0,6,1),(0,0,7,1),(1,0,7,1),(2,1,7,7),(3,0,7,1),(4,0,7,1),(5,0,7,1),(6,0,7,1),(7,1,7,7),(8,1,7,7),(9,0,7,1),(10,0,7,1),(11,0,7,1),(12,0,7,1),(13,0,7,1),(14,0,7,1),(15,0,7,1),(16,0,7,1),(17,0,7,1),(18,0,7,1),(19,0,7,1),(20,0,7,1),(21,0,7,1),(22,0,7,1),(23,0,7,1),(24,0,7,1),(25,0,7,1),(26,0,7,1),(27,0,7,1),(28,0,7,1),(29,0,7,1),(30,0,7,1),(31,0,7,1),(32,0,7,1),(33,0,7,1),(34,0,7,1),(35,0,7,1),(36,0,7,1),(37,0,7,1),(38,0,7,1),(39,0,7,1),(40,0,7,1),(41,0,7,1),(42,0,7,1),(43,0,7,1),(44,0,7,1),(45,0,7,1),(46,0,7,1),(47,0,7,1),(48,0,7,1),(49,0,7,1),(50,0,7,1),(51,0,7,1),(52,0,7,1),(53,0,7,1),(54,0,7,1),(55,0,7,1),(56,0,7,1),(57,0,7,1),(58,0,7,1),(59,0,7,1),(60,0,7,1),(61,0,7,1),(62,0,7,1),(63,0,7,1),(64,0,7,1),(65,0,7,1),(66,0,7,1),(67,0,7,1),(68,0,7,1),(69,0,7,1),(70,0,7,1),(71,0,7,1),(72,0,7,1),(73,0,7,1),(74,0,7,1),(75,0,7,1),(76,0,7,1),(77,0,7,1),(78,0,7,1),(79,0,7,1),(80,0,7,1),(81,0,7,1),(82,0,7,1),(83,0,7,1),(84,0,7,1),(85,0,7,1),(86,0,7,1),(87,0,7,1),(88,0,7,1),(89,0,7,1),(90,0,7,1),(91,0,7,1),(92,0,7,1),(93,0,7,1),(94,0,7,1),(95,0,7,1),(96,0,7,1),(97,0,7,1),(98,0,7,1),(99,0,7,1),(0,0,8,1),(1,0,8,1),(2,0,8,1),(3,1,8,7),(4,0,8,1),(5,0,8,1),(6,0,8,1),(7,0,8,1),(8,0,8,1),(9,0,8,1),(10,0,8,1),(11,0,8,1),(12,0,8,1),(13,0,8,1),(14,0,8,1),(15,0,8,1),(16,0,8,1),(17,0,8,1),(18,0,8,1),(19,0,8,1),(20,0,8,1),(21,0,8,1),(22,0,8,1),(23,0,8,1),(24,1,8,7),(25,0,8,1),(26,0,8,1),(27,0,8,1),(28,0,8,1),(29,0,8,1),(30,0,8,1),(31,0,8,1),(32,0,8,1),(33,0,8,1),(34,0,8,1),(35,0,8,1),(36,0,8,1),(37,0,8,1),(38,0,8,1),(39,0,8,1),(40,0,8,1),(41,0,8,1),(42,0,8,1),(43,0,8,1),(44,0,8,7),(45,1,8,7),(46,0,8,1),(47,0,8,1),(48,0,8,1),(49,0,8,1),(50,0,8,1),(51,0,8,1),(52,0,8,1),(53,0,8,1),(54,0,8,1),(55,0,8,1),(56,0,8,1),(57,0,8,1),(58,0,8,1),(59,0,8,1),(60,0,8,1),(61,0,8,1),(62,0,8,1),(63,0,8,1),(64,1,8,7),(65,0,8,1),(66,0,8,1),(67,0,8,1),(68,0,8,1),(69,0,8,1),(70,0,8,1),(71,0,8,1),(72,0,8,1),(73,0,8,1),(74,0,8,1),(75,0,8,1),(76,0,8,1),(77,0,8,1),(78,0,8,1),(79,0,8,1),(80,0,8,1),(81,0,8,1),(82,0,8,1),(83,0,8,1),(84,0,8,1),(85,0,8,1),(86,0,8,1),(87,0,8,1),(88,0,8,1),(89,0,8,1),(90,0,8,1),(91,0,8,1),(92,0,8,1),(93,0,8,1),(94,0,8,1),(95,0,8,1),(96,0,8,1),(97,0,8,1),(98,0,8,1),(99,0,8,1),(0,0,9,1),(1,0,9,1),(2,0,9,1),(3,0,9,1),(4,0,9,1),(5,0,9,1),(6,0,9,1),(7,0,9,1),(8,0,9,1),(9,0,9,1),(10,0,9,1),(11,0,9,1),(12,0,9,1),(13,0,9,1),(14,0,9,1),(15,0,9,1),(16,0,9,1),(17,0,9,1),(18,0,9,1),(19,0,9,1),(20,0,9,1),(21,0,9,1),(22,0,9,1),(23,0,9,1),(24,0,9,1),(25,0,9,1),(26,0,9,1),(27,0,9,1),(28,0,9,1),(29,0,9,1),(30,0,9,1),(31,0,9,1),(32,0,9,1),(33,0,9,1),(34,0,9,1),(35,0,9,1),(36,0,9,1),(37,0,9,1),(38,0,9,1),(39,0,9,1),(40,0,9,1),(41,0,9,1),(42,0,9,1),(43,0,9,1),(44,0,9,1),(45,0,9,1),(46,0,9,1),(47,0,9,1),(48,0,9,1),(49,1,9,7),(50,0,9,1),(51,0,9,1),(52,0,9,1),(53,0,9,1),(54,0,9,1),(55,0,9,1),(56,0,9,1),(57,0,9,1),(58,1,9,7),(59,0,9,1),(60,0,9,1),(61,0,9,1),(62,0,9,1),(63,0,9,1),(64,0,9,1),(65,0,9,1),(66,0,9,1),(67,0,9,1),(68,0,9,1),(69,0,9,1),(70,0,9,1),(71,0,9,7),(72,0,9,1),(73,0,9,1),(74,0,9,1),(75,0,9,1),(76,0,9,1),(77,0,9,1),(78,0,9,1),(79,0,9,1),(80,0,9,1),(81,0,9,1),(82,0,9,1),(83,0,9,1),(84,1,9,7),(85,0,9,1),(86,0,9,1),(87,0,9,1),(88,0,9,1),(89,0,9,1),(90,0,9,1),(91,0,9,1),(92,0,9,1),(93,0,9,1),(94,0,9,1),(95,0,9,1),(96,0,9,1),(97,0,9,1),(98,1,9,7),(99,0,9,1),(0,0,10,1),(1,0,10,1),(2,0,10,1),(3,0,10,1),(4,0,10,1),(5,0,10,1),(6,0,10,1),(7,0,10,1),(8,0,10,1),(9,0,10,1),(10,0,10,1),(11,0,10,1),(12,0,10,1),(13,0,10,1),(14,0,10,1),(15,0,10,1),(16,0,10,1),(17,0,10,1),(18,0,10,1),(19,0,10,1),(20,0,10,1),(21,0,10,1),(22,1,10,7),(23,0,10,1),(24,0,10,1),(25,0,10,1),(26,0,10,1),(27,0,10,1),(28,0,10,1),(29,0,10,1),(30,0,10,1),(31,0,10,1),(32,0,10,1),(33,0,10,1),(34,0,10,1),(35,0,10,1),(36,0,10,1),(37,0,10,1),(38,0,10,1),(39,0,10,1),(40,0,10,1),(41,0,10,1),(42,1,10,7),(43,0,10,1),(44,0,10,1),(45,0,10,1),(46,0,10,1),(47,0,10,1),(48,0,10,1),(49,0,10,1),(50,0,10,1),(51,0,10,1),(52,0,10,1),(53,0,10,1),(54,0,10,1),(55,0,10,1),(56,0,10,1),(57,0,10,1),(58,0,10,1),(59,0,10,1),(60,0,10,1),(61,0,10,1),(62,0,10,1),(63,0,10,1),(64,0,10,1),(65,0,10,1),(66,0,10,1),(67,0,10,1),(68,0,10,1),(69,0,10,1),(70,0,10,1),(71,0,10,1),(72,0,10,1),(73,0,10,1),(74,0,10,1),(75,0,10,1),(76,0,10,1),(77,0,10,1),(78,0,10,1),(79,0,10,1),(80,0,10,1),(81,0,10,1),(82,0,10,1),(83,0,10,1),(84,0,10,1),(85,0,10,1),(86,0,10,1),(87,0,10,1),(88,0,10,1),(89,0,10,1),(90,0,10,1),(91,0,10,1),(92,0,10,1),(93,0,10,1),(94,0,10,1),(95,0,10,1),(96,0,10,1),(97,0,10,1),(98,0,10,1),(99,0,10,1);
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
INSERT INTO `cartaodecredito` VALUES ('1111.1111.1111.1143','31/12/2050',3),('1111.1111.1111.5555','31/12/2050',10),('1111.2222.1111.2222','15/10/2020',7),('1111.2222.3333.2222','10/10/2010',9),('1111.2222.4444.2222','15/10/2020',1);
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
  PRIMARY KEY (`idcompraVoo`),
  KEY `fk_compravoo_voo1_idx` (`voo_idvoo`),
  KEY `fk_compravoo_usuario1_idx` (`usuario_IDUSUARIO`),
  KEY `fk_compravoo_cartaodecredito1_idx` (`cartaodecredito_NUMEROCARTAO`),
  KEY `fk_compravoo_voo2_idx` (`voo_idvooVolta`),
  CONSTRAINT `fk_compravoo_cartaodecredito1` FOREIGN KEY (`cartaodecredito_NUMEROCARTAO`) REFERENCES `cartaodecredito` (`NUMEROCARTAO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compravoo_usuario1` FOREIGN KEY (`usuario_IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compravoo_voo1` FOREIGN KEY (`voo_idvoo`) REFERENCES `voo` (`idvoo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compravoo_voo2` FOREIGN KEY (`voo_idvooVolta`) REFERENCES `voo` (`idvoo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`IDUSUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Anderson CLIENTE','Ferreira Canel','R. Severiano das Chagas','and','and','15/04/1988',0),(2,'admteste','admteste','enderecoTeste','admteste','admteste','10/10/1925',0),(3,'Priscila','mag','teste','PRY','PRY','22/06/1989',0),(4,'Heitor DATA','ferreira canel','TESTE','user','user','22/06/1989',0),(7,'Anderson ADM','Fereira Canel','Rua teste','adm','adm','15/04/1988',1),(8,'Alex','Canel','teste','alex','alex','21/01/1990',1),(9,'Anderson','ferreira canel','TESTE NOVO','adm','admMY','22/06/1989',0),(10,'Maria','das Graças','Cap Masceno','maria','maria','11/12/1960',0),(11,'PEDRO TESTE','TESTE','TESTE','TESTE','PEDRO TESTE','10/10/2010',0);
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
  PRIMARY KEY (`idvoo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voo`
--

LOCK TABLES `voo` WRITE;
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
INSERT INTO `voo` VALUES (4,'2018-12-15 00:00:00','RJ','MG',1,500),(6,'2018-12-15 00:00:00','RJ','MG',0,500),(7,'2019-01-10 00:00:00','SP','AM',0,2000),(8,'2018-12-20 00:00:00','Rio de Janeiro','Frankfurt',1,5000),(9,'2020-12-16 00:00:00','NY','BH',1,3000),(10,'2019-01-10 00:00:00','RJ','AM',1,2000);
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

-- Dump completed on 2018-11-11  0:42:40
