-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.17-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para dbweb2
DROP DATABASE IF EXISTS `dbweb2`;
CREATE DATABASE IF NOT EXISTS `dbweb2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbweb2`;

-- Copiando estrutura para tabela dbweb2.assento
DROP TABLE IF EXISTS `assento`;
CREATE TABLE IF NOT EXISTS `assento` (
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

-- Copiando dados para a tabela dbweb2.assento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `assento` DISABLE KEYS */;
/*!40000 ALTER TABLE `assento` ENABLE KEYS */;

-- Copiando estrutura para tabela dbweb2.assentoscompradosporvoo
DROP TABLE IF EXISTS `assentoscompradosporvoo`;
CREATE TABLE IF NOT EXISTS `assentoscompradosporvoo` (
  `assenNumero` int(11) NOT NULL,
  `vooId` int(11) DEFAULT NULL,
  `vooIdVolta` int(11) DEFAULT NULL,
  `compravoo_idcompraVoo` int(11) NOT NULL,
  KEY `fk_assentoSCompradosPorVoo_compravoo1_idx` (`compravoo_idcompraVoo`),
  CONSTRAINT `fk_assentoSCompradosPorVoo_compravoo1` FOREIGN KEY (`compravoo_idcompraVoo`) REFERENCES `compravoo` (`idcompraVoo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela dbweb2.assentoscompradosporvoo: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `assentoscompradosporvoo` DISABLE KEYS */;
/*!40000 ALTER TABLE `assentoscompradosporvoo` ENABLE KEYS */;

-- Copiando estrutura para tabela dbweb2.cartaodecredito
DROP TABLE IF EXISTS `cartaodecredito`;
CREATE TABLE IF NOT EXISTS `cartaodecredito` (
  `NUMEROCARTAO` varchar(19) NOT NULL,
  `DATAVENCIMENTO` varchar(12) NOT NULL,
  `USUARIO_IDUSUARIO` int(11) NOT NULL,
  `exclusaoLogica` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`NUMEROCARTAO`),
  KEY `USUARIO_IDUSUARIO` (`USUARIO_IDUSUARIO`),
  CONSTRAINT `` FOREIGN KEY (`USUARIO_IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela dbweb2.cartaodecredito: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cartaodecredito` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartaodecredito` ENABLE KEYS */;

-- Copiando estrutura para tabela dbweb2.compravoo
DROP TABLE IF EXISTS `compravoo`;
CREATE TABLE IF NOT EXISTS `compravoo` (
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

-- Copiando dados para a tabela dbweb2.compravoo: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `compravoo` DISABLE KEYS */;
/*!40000 ALTER TABLE `compravoo` ENABLE KEYS */;

-- Copiando estrutura para tabela dbweb2.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela dbweb2.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`IDUSUARIO`, `NOME`, `SOBRENOME`, `ENDERECO`, `SENHA`, `LOGIN`, `DATANASCIMENTO`, `isadm`, `exclusaoLogica`) VALUES
	(0, 'padraoAssento', '', '', '', '', '15-04-1988', 1, 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Copiando estrutura para tabela dbweb2.voo
DROP TABLE IF EXISTS `voo`;
CREATE TABLE IF NOT EXISTS `voo` (
  `idvoo` int(11) NOT NULL AUTO_INCREMENT,
  `ida` datetime NOT NULL,
  `origem` varchar(100) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `confirmacao` tinyint(1) NOT NULL DEFAULT '0',
  `valorVoo` int(11) NOT NULL DEFAULT '0',
  `exclusaoLogica` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`idvoo`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela dbweb2.voo: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `voo` DISABLE KEYS */;
/*!40000 ALTER TABLE `voo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
