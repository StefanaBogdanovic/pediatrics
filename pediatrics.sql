/*
SQLyog Community v12.2.1 (64 bit)
MySQL - 5.7.21-log : Database - pediatrics
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pediatrics` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pediatrics`;

/*Table structure for table `doctor` */

DROP TABLE IF EXISTS `doctor`;

CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `date_of_employment` date DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `doctor_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`),
  KEY `doctor_type_id` (`doctor_type_id`),
  CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`doctor_type_id`) REFERENCES `doctor_type` (`doctor_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `doctor` */

insert  into `doctor`(`doctor_id`,`name`,`surname`,`birth_date`,`phone`,`date_of_employment`,`salary`,`doctor_type_id`) values 
(1,'Milan','Martinovic','1990-07-12','060000555','2019-01-01','120000',1),
(5,'Bogdan','Bogdanovic','1990-11-11','06784593','2019-11-11','38794',2),
(6,'Stefana','Bogdanovic','1995-07-17','06583494','2018-08-23','120000',3);

/*Table structure for table `doctor_type` */

DROP TABLE IF EXISTS `doctor_type`;

CREATE TABLE `doctor_type` (
  `doctor_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`doctor_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `doctor_type` */

insert  into `doctor_type`(`doctor_type_id`,`name`) values 
(1,'opthalmologist'),
(2,'gynecologist'),
(3,'pediatrition'),
(5,'dentist'),
(6,'urologist');

/*Table structure for table `examination` */

DROP TABLE IF EXISTS `examination`;

CREATE TABLE `examination` (
  `doctor_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `examination_id` int(11) NOT NULL AUTO_INCREMENT,
  `date_time` date DEFAULT NULL,
  `report` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`examination_id`,`doctor_id`,`patient_id`),
  KEY `doctor_fk` (`doctor_id`),
  KEY `patient_fk` (`patient_id`),
  CONSTRAINT `doctor_fk` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`doctor_id`),
  CONSTRAINT `patient_fk` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `examination` */

insert  into `examination`(`doctor_id`,`patient_id`,`examination_id`,`date_time`,`report`) values 
(1,1,3,'2019-09-12','Control needed.'),
(5,2,4,'2019-10-10','New examination appointed.'),
(1,1,5,'2020-01-01','Patient has reported headache after long time spent in front of computer.');

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `patient` */

insert  into `patient`(`patient_id`,`name`,`surname`,`birth_date`,`phone`) values 
(1,'Mira','Stanojevic','1995-08-01','061556677'),
(2,'Marija','Micic','1990-11-11','06083958230'),
(3,'Svetlana','Ilic','1972-05-17','017473566'),
(4,'Branko','Bogdanovic','1967-02-27','061425632');

/*Table structure for table `refer` */

DROP TABLE IF EXISTS `refer`;

CREATE TABLE `refer` (
  `examination_id` int(11) NOT NULL,
  `refer_id` int(11) NOT NULL AUTO_INCREMENT,
  `valid_until` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `doctor_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`refer_id`,`examination_id`),
  KEY `examination_id` (`examination_id`),
  KEY `doctor_type_id` (`doctor_type_id`),
  CONSTRAINT `refer_ibfk_1` FOREIGN KEY (`examination_id`) REFERENCES `examination` (`examination_id`),
  CONSTRAINT `refer_ibfk_2` FOREIGN KEY (`doctor_type_id`) REFERENCES `doctor_type` (`doctor_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `refer` */

insert  into `refer`(`examination_id`,`refer_id`,`valid_until`,`description`,`doctor_type_id`) values 
(3,3,'2019-09-19','Receipe needed.',2),
(4,4,'2020-01-01','Needed to consult.',NULL),
(3,7,'2020-01-01','New pills required.',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
