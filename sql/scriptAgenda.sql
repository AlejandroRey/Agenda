-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.12 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for agenda
DROP DATABASE IF EXISTS `agenda`;
-- CREATE DATABASE IF NOT EXISTS `agenda` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
CREATE DATABASE IF NOT EXISTS `agenda` DEFAULT CHARACTER SET utf8 ;
USE `agenda`;

-- Dumping structure for table agenda.domicilios
DROP TABLE IF EXISTS `domicilios`;
CREATE TABLE IF NOT EXISTS `domicilios` (
  `idDomicilio` bigint(20) NOT NULL AUTO_INCREMENT,
  `calle` varchar(200) DEFAULT NULL,
  `altura` int(11) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  `idLocalidad` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idDomicilio`),
  KEY `FK_domicilios_locadidades` (`idLocalidad`),
  CONSTRAINT `FK_domicilios_locadidades` FOREIGN KEY (`idLocalidad`) REFERENCES `locadidades` (`idlocalidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table agenda.locadidades
DROP TABLE IF EXISTS `locadidades`;
CREATE TABLE IF NOT EXISTS `locadidades` (
  `idLocalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `localidad` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idLocalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table agenda.personas
DROP TABLE IF EXISTS `personas`;
CREATE TABLE IF NOT EXISTS `personas` (
  `IdPersona` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL,
  `telefono` varchar(200) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  `idDomicilio` bigint(20) DEFAULT NULL,
  `idTipoDeContacto` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`IdPersona`),
  KEY `FK_personas_domicilios` (`idDomicilio`),
  KEY `FK_personas_tiposdecontactos` (`idTipoDeContacto`),
  CONSTRAINT `FK_personas_domicilios` FOREIGN KEY (`idDomicilio`) REFERENCES `domicilios` (`iddomicilio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_personas_tiposdecontactos` FOREIGN KEY (`idTipoDeContacto`) REFERENCES `tiposdecontactos` (`idtipodecontacto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table agenda.tiposdecontactos
DROP TABLE IF EXISTS `tiposdecontactos`;
CREATE TABLE IF NOT EXISTS `tiposdecontactos` (
  `idTipoDeContacto` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipoDeContacto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idTipoDeContacto`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;