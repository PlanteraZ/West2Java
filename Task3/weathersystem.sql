-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: weathersystem
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `beijingweatherinfo`
--

DROP TABLE IF EXISTS `beijingweatherinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `beijingweatherinfo` (
  `updateTime` datetime DEFAULT NULL,
  `city_name` char(5) DEFAULT NULL,
  `fxDate` date NOT NULL,
  `tempMax` int DEFAULT NULL,
  `tempMin` int DEFAULT NULL,
  `textDay` char(5) DEFAULT NULL,
  PRIMARY KEY (`fxDate`),
  KEY `idx_beijing_name` (`city_name`),
  KEY `idx_beijing_date` (`fxDate`),
  CONSTRAINT `fk_beijing_name` FOREIGN KEY (`city_name`) REFERENCES `cityinfo` (`city_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beijingweatherinfo`
--

LOCK TABLES `beijingweatherinfo` WRITE;
/*!40000 ALTER TABLE `beijingweatherinfo` DISABLE KEYS */;
INSERT INTO `beijingweatherinfo` VALUES ('2022-01-17 21:35:00','鍖椾含','2022-01-17',4,-8,'鏅?),('2022-01-17 21:35:00','鍖椾含','2022-01-18',3,-7,'鏅?),('2022-01-17 21:35:00','鍖椾含','2022-01-19',0,-8,'澶氫簯');
/*!40000 ALTER TABLE `beijingweatherinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cityinfo`
--

DROP TABLE IF EXISTS `cityinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cityinfo` (
  `city_id` char(10) DEFAULT NULL,
  `city_name` char(5) NOT NULL,
  `longitude` float DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  PRIMARY KEY (`city_name`),
  UNIQUE KEY `uni_city_name` (`city_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cityinfo`
--

LOCK TABLES `cityinfo` WRITE;
/*!40000 ALTER TABLE `cityinfo` DISABLE KEYS */;
INSERT INTO `cityinfo` VALUES ('101020100','涓婃捣',121.473,31.2317),('101010100','鍖椾含',116.405,39.905),('101230101','绂忓窞',119.306,26.0753);
/*!40000 ALTER TABLE `cityinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fuzhouweatherinfo`
--

DROP TABLE IF EXISTS `fuzhouweatherinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fuzhouweatherinfo` (
  `updateTime` datetime DEFAULT NULL,
  `city_name` char(5) DEFAULT NULL,
  `fxDate` date NOT NULL,
  `tempMax` int DEFAULT NULL,
  `tempMin` int DEFAULT NULL,
  `textDay` char(5) DEFAULT NULL,
  PRIMARY KEY (`fxDate`),
  KEY `idx_fuzhou_name` (`city_name`),
  KEY `idx_fuzhou_date` (`fxDate`),
  CONSTRAINT `fk_fuzhou_name` FOREIGN KEY (`city_name`) REFERENCES `cityinfo` (`city_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fuzhouweatherinfo`
--

LOCK TABLES `fuzhouweatherinfo` WRITE;
/*!40000 ALTER TABLE `fuzhouweatherinfo` DISABLE KEYS */;
INSERT INTO `fuzhouweatherinfo` VALUES ('2022-01-17 21:35:00','绂忓窞','2022-01-17',12,11,'闃?),('2022-01-17 21:35:00','绂忓窞','2022-01-18',13,11,'灏忛洦'),('2022-01-17 21:35:00','绂忓窞','2022-01-19',19,11,'澶氫簯');
/*!40000 ALTER TABLE `fuzhouweatherinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shanghaiweatherinfo`
--

DROP TABLE IF EXISTS `shanghaiweatherinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shanghaiweatherinfo` (
  `updateTime` datetime DEFAULT NULL,
  `city_name` char(5) DEFAULT NULL,
  `fxDate` date NOT NULL,
  `tempMax` int DEFAULT NULL,
  `tempMin` int DEFAULT NULL,
  `textDay` char(5) DEFAULT NULL,
  PRIMARY KEY (`fxDate`),
  KEY `idx_shanghai_name` (`city_name`),
  KEY `idx_shanghai_date` (`fxDate`),
  CONSTRAINT `fk_shanghai_name` FOREIGN KEY (`city_name`) REFERENCES `cityinfo` (`city_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shanghaiweatherinfo`
--

LOCK TABLES `shanghaiweatherinfo` WRITE;
/*!40000 ALTER TABLE `shanghaiweatherinfo` DISABLE KEYS */;
INSERT INTO `shanghaiweatherinfo` VALUES ('2022-01-17 21:35:00','涓婃捣','2022-01-17',11,6,'闃?),('2022-01-17 21:35:00','涓婃捣','2022-01-18',12,5,'鏅?),('2022-01-17 21:35:00','涓婃捣','2022-01-19',14,6,'澶氫簯');
/*!40000 ALTER TABLE `shanghaiweatherinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-17 23:00:59
