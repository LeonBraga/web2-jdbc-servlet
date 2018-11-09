CREATE DATABASE  IF NOT EXISTS `dbweb2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbweb2`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dbweb2
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `compravoo`
--

DROP TABLE IF EXISTS `compravoo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compravoo` (
  `idcompraVoo` int(11) NOT NULL AUTO_INCREMENT,
  `USUARIO_IDUSUARIO` int(11) NOT NULL,
  `voo_idvoo` int(11) NOT NULL,
  `voo_idvooVolta` int(11) DEFAULT NULL,
  `assento` int(11) NOT NULL,
  `valorTotalCompra` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idcompraVoo`),
  KEY `fk_compraVoo_USUARIO1_idx` (`USUARIO_IDUSUARIO`),
  KEY `fk_compraVoo_voo1_idx` (`voo_idvoo`),
  CONSTRAINT `fk_compraVoo_USUARIO1` FOREIGN KEY (`USUARIO_IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_compraVoo_voo1` FOREIGN KEY (`voo_idvoo`) REFERENCES `voo` (`idvoo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compravoo`
--

LOCK TABLES `compravoo` WRITE;
/*!40000 ALTER TABLE `compravoo` DISABLE KEYS */;
/*!40000 ALTER TABLE `compravoo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-09  0:06:36
