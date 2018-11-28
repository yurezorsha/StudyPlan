-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: study_plan-test
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `certification`
--

DROP TABLE IF EXISTS `certification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certification` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_plan` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcerf` (`id_plan`),
  CONSTRAINT `FKcerf` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certification`
--

LOCK TABLES `certification` WRITE;
/*!40000 ALTER TABLE `certification` DISABLE KEYS */;
/*!40000 ALTER TABLE `certification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competence`
--

DROP TABLE IF EXISTS `competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competence` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) DEFAULT NULL,
  `name_competence` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competence`
--

LOCK TABLES `competence` WRITE;
/*!40000 ALTER TABLE `competence` DISABLE KEYS */;
INSERT INTO `competence` VALUES (1,'БПК-3','Быть способным использовать основные законы электротехники и владеть методами их применения, применять электронные элементы и приборы в системах автоматизации');
/*!40000 ALTER TABLE `competence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `creator_study_programm`
--

DROP TABLE IF EXISTS `creator_study_programm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `creator_study_programm` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_teacher` int(10) DEFAULT NULL,
  `id_study_programm` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcr` (`id_study_programm`),
  CONSTRAINT `FKcr` FOREIGN KEY (`id_study_programm`) REFERENCES `study_programm` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `creator_study_programm`
--

LOCK TABLES `creator_study_programm` WRITE;
/*!40000 ALTER TABLE `creator_study_programm` DISABLE KEYS */;
INSERT INTO `creator_study_programm` VALUES (1,1,1);
/*!40000 ALTER TABLE `creator_study_programm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fakultativ`
--

DROP TABLE IF EXISTS `fakultativ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fakultativ` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_plan` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfak` (`id_plan`),
  CONSTRAINT `FKfak` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fakultativ`
--

LOCK TABLES `fakultativ` WRITE;
/*!40000 ALTER TABLE `fakultativ` DISABLE KEYS */;
INSERT INTO `fakultativ` VALUES (1,NULL,'Факультатив 1');
/*!40000 ALTER TABLE `fakultativ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_components`
--

DROP TABLE IF EXISTS `group_components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_components` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` enum('Государственный компонент','Компонент учреждения высшего образования','Факультативные дисциплины','Дополнительные виды обучения') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_components`
--

LOCK TABLES `group_components` WRITE;
/*!40000 ALTER TABLE `group_components` DISABLE KEYS */;
INSERT INTO `group_components` VALUES (1,'Государственный компонент'),(2,'Компонент учреждения высшего образования'),(3,'Факультативные дисциплины'),(4,'Дополнительные виды обучения');
/*!40000 ALTER TABLE `group_components` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_units`
--

DROP TABLE IF EXISTS `group_units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_units` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `id_group_components` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgrunit` (`id_group_components`),
  CONSTRAINT `FKgrunit` FOREIGN KEY (`id_group_components`) REFERENCES `group_components` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_units`
--

LOCK TABLES `group_units` WRITE;
/*!40000 ALTER TABLE `group_units` DISABLE KEYS */;
INSERT INTO `group_units` VALUES (1,'Социально-гуманитарный модуль 1',1);
/*!40000 ALTER TABLE `group_units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groups`
--

DROP TABLE IF EXISTS `groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `groups` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_plan` int(10) DEFAULT NULL,
  `count_students` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgr` (`id_plan`),
  CONSTRAINT `FKgr` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` VALUES (1,1,20),(2,1,25),(3,NULL,26);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `node`
--

DROP TABLE IF EXISTS `node`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `node` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_subject` int(10) DEFAULT NULL,
  `id_cathedra` int(10) DEFAULT NULL,
  `id_plan` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK` (`id_subject`),
  KEY `FK10` (`id_plan`),
  CONSTRAINT `FK` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`),
  CONSTRAINT `FK10` FOREIGN KEY (`id_plan`) REFERENCES `plan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `node`
--

LOCK TABLES `node` WRITE;
/*!40000 ALTER TABLE `node` DISABLE KEYS */;
INSERT INTO `node` VALUES (1,4,0,1),(2,2,0,1),(4,1,0,2),(5,2,0,2),(6,3,0,NULL),(7,3,0,2);
/*!40000 ALTER TABLE `node` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_speciality` int(10) DEFAULT NULL,
  `set_data_group` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpp1` (`id_speciality`),
  CONSTRAINT `FKpp1` FOREIGN KEY (`id_speciality`) REFERENCES `speciality` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,1,2009),(2,1,2010);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semestr`
--

DROP TABLE IF EXISTS `semestr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `semestr` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `number` int(10) NOT NULL,
  `lecture` int(10) DEFAULT NULL,
  `laboratory` int(10) DEFAULT NULL,
  `practice` int(10) DEFAULT NULL,
  `seminar` int(10) DEFAULT NULL,
  `id_type` int(10) DEFAULT NULL,
  `rgr` int(1) DEFAULT NULL,
  `course_work_type` enum('курсовой проект','курсовая работа') DEFAULT NULL,
  `id_node` int(10) DEFAULT NULL,
  `ze` int(10) DEFAULT NULL,
  `cource_work_ze` int(10) DEFAULT NULL,
  `cource_work_hours` int(10) DEFAULT NULL,
  `id_teacher` int(10) DEFAULT NULL,
  `id_faculty` int(10) DEFAULT NULL,
  `diplom_hour` int(10) DEFAULT NULL,
  `diplom_ze` int(10) DEFAULT NULL,
  `prac_hour` int(10) DEFAULT NULL,
  `prac_ze` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKS` (`id_node`),
  KEY `FKtype` (`id_type`),
  CONSTRAINT `FKS` FOREIGN KEY (`id_node`) REFERENCES `node` (`id`),
  CONSTRAINT `FKtype` FOREIGN KEY (`id_type`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semestr`
--

LOCK TABLES `semestr` WRITE;
/*!40000 ALTER TABLE `semestr` DISABLE KEYS */;
INSERT INTO `semestr` VALUES (1,1,15,15,15,15,1,1,'курсовой проект',1,5,1,300,1,1,0,0,0,0),(2,2,15,15,15,15,1,1,'курсовой проект',1,5,1,10,1,1,0,0,1,1),(3,3,15,15,15,15,1,1,'курсовой проект',1,5,1,10,1,1,0,0,1,1),(4,4,15,15,15,15,1,1,'курсовой проект',1,5,1,10,1,1,1,1,0,0),(11,1,15,15,15,15,1,1,NULL,2,5,0,0,1,1,0,0,0,0),(12,2,15,15,15,15,1,1,NULL,2,5,0,0,1,1,0,0,0,0),(13,1,15,15,15,15,1,1,'курсовой проект',4,5,1,10,1,1,0,0,0,0),(14,2,15,15,15,15,1,1,'курсовой проект',4,5,1,10,1,1,0,0,1,1),(15,3,15,15,15,15,1,1,'курсовой проект',4,5,1,10,1,1,0,0,1,1),(16,4,15,15,15,15,1,1,'курсовой проект',4,5,1,10,1,1,1,1,0,0),(17,1,15,15,15,15,1,1,NULL,5,5,0,0,1,1,0,0,0,0),(18,2,15,15,15,15,1,1,NULL,5,5,0,0,1,1,0,0,0,0);
/*!40000 ALTER TABLE `semestr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `speciality`
--

DROP TABLE IF EXISTS `speciality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `speciality` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `shifr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `speciality`
--

LOCK TABLES `speciality` WRITE;
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
INSERT INTO `speciality` VALUES (1,'Информационные системы и технологии','1-40 05 01-01'),(2,'Автоматизация технологических процессов и производств (легкая промышленность)','1-53 01 01-05');
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `study_programm`
--

DROP TABLE IF EXISTS `study_programm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `study_programm` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_subject` int(10) DEFAULT NULL,
  `date_approve` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKstudy` (`id_subject`),
  CONSTRAINT `FKstudy` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `study_programm`
--

LOCK TABLES `study_programm` WRITE;
/*!40000 ALTER TABLE `study_programm` DISABLE KEYS */;
INSERT INTO `study_programm` VALUES (1,1,'2020-08-20');
/*!40000 ALTER TABLE `study_programm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_competence`
--

DROP TABLE IF EXISTS `sub_competence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sub_competence` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `id_competence` int(10) DEFAULT NULL,
  `id_subject` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcom` (`id_competence`),
  KEY `FKcom2` (`id_subject`),
  CONSTRAINT `FKcom` FOREIGN KEY (`id_competence`) REFERENCES `competence` (`id`),
  CONSTRAINT `FKcom2` FOREIGN KEY (`id_subject`) REFERENCES `subject` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_competence`
--

LOCK TABLES `sub_competence` WRITE;
/*!40000 ALTER TABLE `sub_competence` DISABLE KEYS */;
INSERT INTO `sub_competence` VALUES (1,1,1);
/*!40000 ALTER TABLE `sub_competence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `shifr` varchar(50) DEFAULT NULL,
  `id_unit` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsub` (`id_unit`),
  CONSTRAINT `FKsub` FOREIGN KEY (`id_unit`) REFERENCES `group_units` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'История','shifr',1),(2,'Политология','shifr',1),(3,'Философия','shifr',1),(4,'Экономика','shifr',1);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `koff` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'зачет',0.3),(2,'диф. зачет',0.35),(3,'экзамен',0.4),(4,'просмотр',0.4),(5,'test',4);
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weeks_semestr`
--

DROP TABLE IF EXISTS `weeks_semestr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weeks_semestr` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `number_semestr` int(10) DEFAULT NULL,
  `count_weeks` int(10) DEFAULT NULL,
  `id_semestr` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKweek` (`id_semestr`),
  CONSTRAINT `FKweek` FOREIGN KEY (`id_semestr`) REFERENCES `semestr` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weeks_semestr`
--

LOCK TABLES `weeks_semestr` WRITE;
/*!40000 ALTER TABLE `weeks_semestr` DISABLE KEYS */;
INSERT INTO `weeks_semestr` VALUES (1,1,10,1);
/*!40000 ALTER TABLE `weeks_semestr` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-28 15:29:29
