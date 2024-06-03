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
  `mestoID` int(10) unsigned DEFAULT NULL,
  `maticni_broj` int(8) unsigned NOT NULL,
  `PIB` int(9) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `mestoID` (`mestoID`),
  CONSTRAINT `mestoID` FOREIGN KEY (`mestoID`) REFERENCES `mesto` (`PID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `kompanija` */

insert  into `kompanija`(`ID`,`naziv`,`telefon`,`mestoID`,`maticni_broj`,`PIB`) values 
(1,'Nordeus','0116846749',11000,20622849,106525606),
(2,'Hemofarm','+38113803100',26300,8010536,102037788),
(3,'Endava','011 2057400',21000,6425747,100026798),
(4,'MDG','0332155000',31300,21022675,108554272);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `PID` int(10) unsigned NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `mesto` */

insert  into `mesto`(`PID`,`naziv`) values 
(11000,'Beograd'),
(18000,'Niš'),
(21000,'Novi Sad'),
(26300,'Vršac'),
(31300,'Prijepolje'),
(34000,'Kragujevac');

/*Table structure for table `modul` */

DROP TABLE IF EXISTS `modul`;

CREATE TABLE `modul` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `smerID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `smerID` (`smerID`),
  CONSTRAINT `smerID` FOREIGN KEY (`smerID`) REFERENCES `smer` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `modul` */

insert  into `modul`(`ID`,`naziv`,`smerID`) values 
(1,'Softversko inženjerstvo',1),
(2,'Informacione tehnologije',1),
(3,'Informacioni sistemi',1),
(4,'Poslovna analitika',1),
(5,'Informaciono inženjerstvo',1),
(6,'Tehnologije elektrsonskog poslovanja',1),
(7,'Finansijski menadžment',2),
(8,'Lin organizacija poslovanja',2),
(9,'Marketing menadžment i komunikacije',2),
(10,'Menadžment kvaliteta istandardizacija',2),
(11,'Operacioni menadžment',2),
(12,'Projektni menadžment',2);

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
  `studentID` int(10) unsigned DEFAULT NULL,
  `ugovorID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`praksaID`),
  KEY `kompanija_fk` (`kompanijaID`),
  KEY `godina_fk` (`godinaID`),
  KEY `mesto_fk` (`mestoID`),
  KEY `student_fk` (`studentID`),
  KEY `ugovor_fk` (`ugovorID`),
  CONSTRAINT `godina_fk` FOREIGN KEY (`godinaID`) REFERENCES `skolska_godina` (`godina`),
  CONSTRAINT `kompanija_fk` FOREIGN KEY (`kompanijaID`) REFERENCES `kompanija` (`ID`),
  CONSTRAINT `mesto_fk` FOREIGN KEY (`mestoID`) REFERENCES `mesto` (`PID`),
  CONSTRAINT `student_fk` FOREIGN KEY (`studentID`) REFERENCES `student` (`studentID`),
  CONSTRAINT `ugovor_fk` FOREIGN KEY (`ugovorID`) REFERENCES `ugovor` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `praksa` */

insert  into `praksa`(`praksaID`,`pozicija`,`datumPocetka`,`datumZavrsetka`,`kompanijaID`,`godinaID`,`mestoID`,`studentID`,`ugovorID`) values 
(21,'Software Developer','2024-06-01','2024-12-01',1,2023,11000,NULL,NULL),
(22,'Data Analyst','2024-07-01','2024-12-31',2,2023,11000,NULL,NULL),
(23,'Project Manager','2024-08-01','2025-01-31',3,2023,34000,NULL,NULL),
(24,'System Administrator','2024-09-01','2025-02-28',4,2023,11000,NULL,NULL),
(25,'UI/UX Designer','2024-10-01','2025-03-31',4,2023,18000,NULL,NULL);

/*Table structure for table `skolska_godina` */

DROP TABLE IF EXISTS `skolska_godina`;

CREATE TABLE `skolska_godina` (
  `godina` int(10) unsigned NOT NULL,
  PRIMARY KEY (`godina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `skolska_godina` */

insert  into `skolska_godina`(`godina`) values 
(2020),
(2021),
(2022),
(2023),
(2024);

/*Table structure for table `smer` */

DROP TABLE IF EXISTS `smer`;

CREATE TABLE `smer` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `smer` */

insert  into `smer`(`ID`,`naziv`) values 
(1,'Informacioni sistemi i tehnologije'),
(2,'Menadžment i organizacija');

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `student` */

insert  into `student`(`studentID`,`ime`,`prezime`,`adresa`,`telefon`,`indeks`,`smerID`,`modulID`) values 
(1,'Petar','Posrkača','Cara Romanova','+381613399994','2022/0372',1,3),
(2,'Jovan','Radomirović','Kostolačka','+381645766575','2022/0122',1,6),
(3,'Veljko','Rajković','Omladinski trg','+381621821457','2022/0277',1,1),
(4,'Lazar','Ratković','Studentski grad','+381645792525','2022/0080',1,3);

/*Table structure for table `ugovor` */

DROP TABLE IF EXISTS `ugovor`;

CREATE TABLE `ugovor` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `datumPocetka` datetime DEFAULT NULL,
  `datumZavrsetka` datetime DEFAULT NULL,
  `jeAktivan` tinyint(1) NOT NULL DEFAULT 0,
  `kompanijaID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `k_fk` (`kompanijaID`),
  CONSTRAINT `k_fk` FOREIGN KEY (`kompanijaID`) REFERENCES `kompanija` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

/*Data for the table `ugovor` */

insert  into `ugovor`(`ID`,`datumPocetka`,`datumZavrsetka`,`jeAktivan`,`kompanijaID`) values 
(1,'2023-06-30 12:14:07','2027-06-02 12:13:52',0,1),
(2,'2024-06-20 12:14:43','2025-03-05 12:14:35',1,4);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
