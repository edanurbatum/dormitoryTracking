-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: dormitorytracking
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `refectory`
--

DROP TABLE IF EXISTS `refectory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refectory` (
  `date` varchar(11) NOT NULL,
  `day` varchar(10) NOT NULL,
  `food1` varchar(20) NOT NULL,
  `food2` varchar(20) NOT NULL,
  `food3` varchar(20) NOT NULL,
  `food4` varchar(20) NOT NULL,
  `food5` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refectory`
--

LOCK TABLES `refectory` WRITE;
/*!40000 ALTER TABLE `refectory` DISABLE KEYS */;
INSERT INTO `refectory` VALUES ('03/09/2021','Perşembe','brokoli çorba','tas kebabı','erişte pilavı','çiğköfte','yoğurt'),('04/09/2021','Cuma','tarhana çorbası','köfte','pilav','ayran','üzüm'),('06/09/2021','Pazartesi','yoğurtlu çorba','fasülye','makarna','kemalpaşa tatlısı','salata'),('07/09/2021','Salı','mercimek çorbası','döner','pirinç pilavı','aşure','ayran'),('08/09/2021','Çarşamba','ezogelin çorbası','makarna','nohut','salata','ayran'),('09/09/2021','Perşembe','gemici çorbası','köfte','makarna','brokoli haşlama','üzüm');
/*!40000 ALTER TABLE `refectory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-31 23:05:14
