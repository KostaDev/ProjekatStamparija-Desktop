/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 10.4.11-MariaDB : Database - stamparija
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stamparija` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `stamparija`;

/*Table structure for table `dokument` */

DROP TABLE IF EXISTS `dokument`;

CREATE TABLE `dokument` (
  `dokumentID` int(11) NOT NULL AUTO_INCREMENT,
  `koricenje` varchar(255) NOT NULL,
  `instrukcijeZaStampu` varchar(255) NOT NULL,
  `datumStampanja` date NOT NULL,
  `masinaID` int(11) NOT NULL,
  `stampanjeID` int(11) NOT NULL,
  PRIMARY KEY (`dokumentID`,`stampanjeID`),
  KEY `eksponatID` (`masinaID`),
  KEY `aukcijaID` (`stampanjeID`),
  CONSTRAINT `dokument_ibfk_1` FOREIGN KEY (`masinaID`) REFERENCES `masina` (`masinaID`),
  CONSTRAINT `dokument_ibfk_2` FOREIGN KEY (`stampanjeID`) REFERENCES `stampanje` (`stampanjeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `dokument` */

insert  into `dokument`(`dokumentID`,`koricenje`,`instrukcijeZaStampu`,`datumStampanja`,`masinaID`,`stampanjeID`) values 
(6,'Basic java spring experience ','Pocetna java pozicijau kompaniji 2','2020-07-01',3,5),
(7,'junior java programmer with bachelor degree','Java graduate program','2020-05-30',1,5),
(8,'senior node.js developer with more than 5 years of experience','Konkurs za kompaniju 4','2020-07-10',5,6);

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `klijentID` int(11) NOT NULL AUTO_INCREMENT,
  `imeKlijenta` varchar(255) NOT NULL,
  `prezimeKlijenta` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefon` varchar(255) NOT NULL,
  PRIMARY KEY (`klijentID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `klijent` */

insert  into `klijent`(`klijentID`,`imeKlijenta`,`prezimeKlijenta`,`email`,`telefon`) values 
(1,'Milan','Milanovic','milance@gmail.com','Milancika 123'),
(2,'Petar','Peric','peca@gmail.com','Takovska 44'),
(3,'Marija','Zivic','zivkcia@gmail.com','Obrenovacka 676'),
(4,'Milena','Maravic','mileeeena@gmail.com','Jove Ilica 55');

/*Table structure for table `masina` */

DROP TABLE IF EXISTS `masina`;

CREATE TABLE `masina` (
  `masinaID` int(11) NOT NULL AUTO_INCREMENT,
  `opis` varchar(255) NOT NULL,
  `datumProizvodnje` date NOT NULL,
  `marka` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  PRIMARY KEY (`masinaID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;

/*Data for the table `masina` */

insert  into `masina`(`masinaID`,`opis`,`datumProizvodnje`,`marka`,`model`) values 
(1,'kompanija1.com','2018-02-10','Kompanija 1','opis kompanije 1'),
(3,'kompanija2.com','2018-02-12','Kompanija 2 ','opis kompanije 2'),
(5,'kompanija4.com','2007-02-14','Kompanija 4','opis kompanije 4'),
(7,'kompanija5.com','2016-03-02','Kompanija 5','opis kompanije 5'),
(33,'kompanija6.com','1996-03-12','Kompanija 6','opis kompanije 6'),
(36,'kompanija8.com','1992-03-10','Kompanija 8','jebavanje');

/*Table structure for table `narucivanje` */

DROP TABLE IF EXISTS `narucivanje`;

CREATE TABLE `narucivanje` (
  `narucivanjeID` int(11) NOT NULL AUTO_INCREMENT,
  `datumNarucivanja` date NOT NULL,
  `stampanjeID` int(11) NOT NULL,
  `klijentID` int(11) NOT NULL,
  PRIMARY KEY (`narucivanjeID`),
  KEY `aukcijaID` (`stampanjeID`),
  KEY `posetilacID` (`klijentID`),
  CONSTRAINT `narucivanje_ibfk_1` FOREIGN KEY (`stampanjeID`) REFERENCES `stampanje` (`stampanjeID`) ON DELETE CASCADE,
  CONSTRAINT `narucivanje_ibfk_2` FOREIGN KEY (`klijentID`) REFERENCES `klijent` (`klijentID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `narucivanje` */

insert  into `narucivanje`(`narucivanjeID`,`datumNarucivanja`,`stampanjeID`,`klijentID`) values 
(5,'2020-10-30',5,3);

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `radnikID` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) NOT NULL,
  `prezime` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`radnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `radnik` */

insert  into `radnik`(`radnikID`,`ime`,`prezime`,`username`,`password`) values 
(1,'Administrator','Administrator','admin','admin123'),
(2,'Milica','Jankovic','mia','mia123');

/*Table structure for table `stampanje` */

DROP TABLE IF EXISTS `stampanje`;

CREATE TABLE `stampanje` (
  `stampanjeID` int(11) NOT NULL AUTO_INCREMENT,
  `napomena` varchar(255) NOT NULL,
  `rokZaIzvrsenje` date NOT NULL,
  `placeno` tinyint(1) NOT NULL,
  `radnikID` int(11) NOT NULL,
  PRIMARY KEY (`stampanjeID`),
  KEY `kustosID` (`radnikID`),
  CONSTRAINT `stampanje_ibfk_1` FOREIGN KEY (`radnikID`) REFERENCES `radnik` (`radnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `stampanje` */

insert  into `stampanje`(`stampanjeID`,`napomena`,`rokZaIzvrsenje`,`placeno`,`radnikID`) values 
(5,'Junior Java Developer','2020-03-10',1,2),
(6,'Senior node.js','2020-01-10',1,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
