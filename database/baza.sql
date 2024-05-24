/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 10.4.28-MariaDB : Database - studentske_prakse
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studentske_prakse` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;

USE `studentske_prakse`;

/*Table structure for table `kompanija` */

DROP TABLE IF EXISTS `kompanija`;

CREATE TABLE `kompanija` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `telefon` char(15) DEFAULT NULL,
  `ugovorID` int(10) unsigned DEFAULT NULL,
  `mestoID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ugovorID` (`ugovorID`),
  KEY `mestoID` (`mestoID`),
  CONSTRAINT `mestoID` FOREIGN KEY (`mestoID`) REFERENCES `mesto` (`PID`),
  CONSTRAINT `ugovorID` FOREIGN KEY (`ugovorID`) REFERENCES `ugovor` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `kompanija` */

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `PID` int(10) unsigned NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `mesto` */

/*Table structure for table `modul` */

DROP TABLE IF EXISTS `modul`;

CREATE TABLE `modul` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `smerID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `smerID` (`smerID`),
  CONSTRAINT `smerID` FOREIGN KEY (`smerID`) REFERENCES `smer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `modul` */

/*Table structure for table `praksa` */

DROP TABLE IF EXISTS `praksa`;

CREATE TABLE `praksa` (
  `praksaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pozicija` varchar(255) NOT NULL,
  `datumPocetka` date DEFAULT NULL,
  `datumZavrsetka` date DEFAULT NULL,
  `kompanijaID` int(10) unsigned NOT NULL,
  `godinaID` int(10) unsigned NOT NULL,
  `mestoID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`praksaID`),
  KEY `kompanija_fk` (`kompanijaID`),
  KEY `godina_fk` (`godinaID`),
  KEY `mesto_fk` (`mestoID`),
  CONSTRAINT `godina_fk` FOREIGN KEY (`godinaID`) REFERENCES `skolska_godina` (`godina`),
  CONSTRAINT `kompanija_fk` FOREIGN KEY (`kompanijaID`) REFERENCES `kompanija` (`ID`),
  CONSTRAINT `mesto_fk` FOREIGN KEY (`mestoID`) REFERENCES `mesto` (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `praksa` */

/*Table structure for table `skolska_godina` */

DROP TABLE IF EXISTS `skolska_godina`;

CREATE TABLE `skolska_godina` (
  `godina` int(10) unsigned NOT NULL,
  PRIMARY KEY (`godina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `skolska_godina` */

/*Table structure for table `smer` */

DROP TABLE IF EXISTS `smer`;

CREATE TABLE `smer` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `smer` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `studentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `adresa` varchar(100) NOT NULL,
  `telefon` char(15) NOT NULL,
  `indeks` char(9) NOT NULL,
  `smerID` int(10) unsigned NOT NULL,
  `modulID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`studentID`),
  KEY `smer_fk` (`smerID`),
  KEY `modul_fk` (`modulID`),
  CONSTRAINT `modul_fk` FOREIGN KEY (`modulID`) REFERENCES `modul` (`ID`),
  CONSTRAINT `smer_fk` FOREIGN KEY (`smerID`) REFERENCES `smer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `student` */

/*Table structure for table `ugovor` */

DROP TABLE IF EXISTS `ugovor`;

CREATE TABLE `ugovor` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `datumPocetka` datetime DEFAULT NULL,
  `datumZavrsetka` datetime DEFAULT NULL,
  `jeAktivan` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `ugovor` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
