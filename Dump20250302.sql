-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: 7cm1
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `periodoescolar`
--

DROP TABLE IF EXISTS `periodoescolar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodoescolar` (
  `idPeriodoEscolar` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(54) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaTermino` date NOT NULL,
  `status` tinyint NOT NULL,
  PRIMARY KEY (`idPeriodoEscolar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodoescolar`
--

LOCK TABLES `periodoescolar` WRITE;
/*!40000 ALTER TABLE `periodoescolar` DISABLE KEYS */;
/*!40000 ALTER TABLE `periodoescolar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programaacademico`
--

DROP TABLE IF EXISTS `programaacademico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programaacademico` (
  `idProgramaAcademico` int NOT NULL AUTO_INCREMENT,
  `clave` bigint NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `status` tinyint NOT NULL,
  PRIMARY KEY (`idProgramaAcademico`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programaacademico`
--

LOCK TABLES `programaacademico` WRITE;
/*!40000 ALTER TABLE `programaacademico` DISABLE KEYS */;
INSERT INTO `programaacademico` VALUES (1,1,'asdas','asdasd','2025-03-19',1),(2,2,'asdasas','sadadsa','2025-03-02',1),(3,3,'asdas','dassadas','2025-03-13',1),(4,4,'asdas','asdasdsa','2025-03-20',0),(5,5,'eeeeee','asdasdsa','2025-03-02',0),(6,6,'sadasd','sadasda','2025-03-20',1);
/*!40000 ALTER TABLE `programaacademico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-02 15:34:45
