CREATE DATABASE  IF NOT EXISTS `crmgertjan` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `crmgertjan`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: crmgertjan
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `box` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `archived` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'2','Leuven','België','7','Tessenstraat','PRIV','3000',_binary ''),(2,'2','Leuven','België','73','Brusselsetraat','PROF','3000',_binary '\0'),(3,'','Leuven','België','76A','Tiensestraat','PRIV','3000',_binary '\0'),(4,'2','Leuven','België','7','Tessenstraat','PRIV','3000',_binary '\0'),(5,'2','Leuven','België','73','Brusselsetraat','PROF','3000',_binary '\0'),(6,'','Leuven','België','76A','Tiensestraat','PRIV','3000',_binary '\0'),(7,'2','Leuven','België','7','Tessenstraat','PRIV','3000',_binary '\0'),(8,'2','Leuven','België','73','Brusselsetraat','PROF','3000',_binary ''),(9,'','Leuven','België','76A','Tiensestraat','PRIV','3000',_binary ''),(10,'2','Leuven','België','7','Tessenstraat','PRIV','3000',_binary ''),(11,'2','Leuven','België','73','Brusselsetraat','PROF','3000',_binary ''),(12,'','Leuven','België','76A','Tiensestraat','PRIV','3000',_binary ''),(13,'2','Leuven','België','7','Tessenstraat','PRIV','3000',_binary ''),(14,'2','Leuven','België','73','Brusselsetraat','PROF','3000',_binary ''),(15,'','Leuven','België','76A','Tiensestraat','PRIV','3000',_binary ''),(16,'','Piringen','België','406','Sint-Truidersteenweg','PROF','3700',_binary '\0');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community`
--

DROP TABLE IF EXISTS `community`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `archived` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community`
--

LOCK TABLES `community` WRITE;
/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` VALUES (1,'TestCommunity updated',_binary ''),(2,'Jaarlijkse BBQ',_binary ''),(3,'eenmalig doopfeest',_binary '\0'),(4,'Jaarlijkse kerstkaartjes',_binary '\0'),(5,'Jaarlijkse BBQ',_binary '\0'),(6,'eenmalig doopfeest',_binary '\0'),(7,'Jaarlijkse kerstkaartjes',_binary '\0'),(8,'Jaarlijkse BBQ',_binary '\0'),(9,'eenmalig doopfeest',_binary '\0'),(10,'Jaarlijkse kerstkaartjes',_binary '\0'),(11,'Jaarlijkse BBQ',_binary '\0'),(12,'eenmalig doopfeest',_binary '\0'),(13,'Jaarlijkse kerstkaartjes',_binary '\0'),(14,'Jaarlijkse BBQ',_binary '\0'),(15,'eenmalig doopfeest',_binary '\0');
/*!40000 ALTER TABLE `community` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `community_id` bigint DEFAULT NULL,
  `archived` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa0t6mch3mk0riuwyh6psx1lfi` (`community_id`),
  CONSTRAINT `FKa0t6mch3mk0riuwyh6psx1lfi` FOREIGN KEY (`community_id`) REFERENCES `community` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'2020-12-16','kerstkaartjes 2020',1,_binary ''),(2,'2020-07-21','BBQ 2020',1,_binary ''),(3,'2021-05-31','doopfeest 2021',1,_binary ''),(4,'2020-12-16','kerstkaartjes 2020',2,_binary ''),(5,'2020-07-21','BBQ 2020',3,_binary '\0'),(6,'2021-05-31','doopfeest 2021',3,_binary '\0'),(7,'2020-12-16','kerstkaartjes 2020',4,_binary '\0'),(8,'2020-07-21','BBQ 2020',4,_binary '\0'),(9,'2021-05-31','doopfeest 2021',4,_binary '\0'),(13,'2021-08-16','sdqfdqfsqd',6,_binary '\0'),(14,'2021-06-23','TestEvent',8,_binary '\0'),(15,'2021-06-25','External to internal',1,_binary '');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `community_id` bigint NOT NULL,
  `person_id` bigint NOT NULL,
  `since` date DEFAULT NULL,
  `until` date DEFAULT NULL,
  PRIMARY KEY (`community_id`,`person_id`),
  KEY `FK79njwgt8bxb68pih42kbhaaq7` (`person_id`),
  CONSTRAINT `FK79njwgt8bxb68pih42kbhaaq7` FOREIGN KEY (`person_id`) REFERENCES `community` (`id`),
  CONSTRAINT `FKehb6bowo4rti0skf5ugjv12g6` FOREIGN KEY (`community_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (4,1,'1999-08-01','9999-12-31'),(4,2,'1999-08-01','9999-12-31'),(4,3,'1990-08-01','9999-12-31'),(6,4,'2021-06-12','2021-07-08');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birth_day` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `archived` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'1963-06-29','Jack','Bauer 5',_binary ''),(2,'1973-04-29','Kim','Bauer',_binary ''),(3,'1983-10-24','David','Palmer',_binary ''),(4,'1993-07-29','Michelle','Dessler',_binary '\0'),(5,'1963-06-29','Jack','Bauer',_binary '\0'),(6,'1973-04-29','Kim','Bauer',_binary ''),(7,'1983-10-24','David','Palmer',_binary ''),(8,'1993-07-29','Michelle','Dessler',_binary ''),(9,'1963-06-29','Jack','Bauer',_binary ''),(10,'1973-04-29','Kim','Bauer',_binary ''),(11,'1983-10-24','David','Palmer',_binary ''),(12,'1993-07-29','Michelle','Dessler',_binary ''),(13,'1963-06-29','Jack','Bauer',_binary ''),(14,'1973-04-29','Kim','Bauer',_binary '\0'),(15,'1983-10-24','David','Palmer',_binary ''),(16,'1993-07-29','Michelle','Dessler',_binary ''),(17,'1963-06-29','Jack','Bauer',_binary ''),(18,'1973-04-29','Kim','Bauer',_binary ''),(19,'1983-10-24','David','Palmer',_binary '\0'),(20,'1993-07-29','Michelle','Dessler',_binary '\0'),(21,'2020-06-03','Gert-Jan','Spilstijns',_binary '');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_address`
--

DROP TABLE IF EXISTS `person_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_address` (
  `address_id` bigint NOT NULL,
  `person_id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`address_id`,`person_id`),
  KEY `FKnndfs0btabect8upo03uwgfxt` (`person_id`),
  CONSTRAINT `FKcyc1krsxqelkm4uwh65avij23` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`),
  CONSTRAINT `FKnndfs0btabect8upo03uwgfxt` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_address`
--

LOCK TABLES `person_address` WRITE;
/*!40000 ALTER TABLE `person_address` DISABLE KEYS */;
INSERT INTO `person_address` VALUES (1,2,'b@c.com','34567789','23434567','P'),(2,3,'d@e.com','34567789','34345678','P'),(6,4,'gspilstijns@gmail.com','0491227301','0491227301','PROF'),(6,21,'gspilstijns@gmail.com','0491227301','0491227301','PROF'),(14,21,'gspilstijns@gmail.com','0491227301','0491227301','PROF');
/*!40000 ALTER TABLE `person_address` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-14  0:08:47
