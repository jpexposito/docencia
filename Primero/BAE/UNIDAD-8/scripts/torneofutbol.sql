drop database if exists torneofutbol;
CREATE DATABASE  `torneofutbol` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `torneofutbol`;
-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: torneofutbol
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.04.1

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
-- Table structure for table `entrenador`
--

DROP TABLE IF EXISTS `entrenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrenador` (
  `idEntrenador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido1` varchar(25) NOT NULL,
  `apellido2` varchar(25) NOT NULL,
  `fecNacimiento` date DEFAULT NULL,
  `telefono` char(9) DEFAULT NULL,
  `codPoblacion` int(11) NOT NULL,
  PRIMARY KEY (`idEntrenador`),
  KEY `fk_entrenador_poblacion1_idx` (`codPoblacion`),
  CONSTRAINT `fk_entrenador_poblacion1` FOREIGN KEY (`codPoblacion`) REFERENCES `poblacion` (`codPoblacion`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
INSERT INTO `entrenador` VALUES (1,'Juan','Rodríguez','Pérez','1985-11-11','665587441',14),(2,'Manuel','López','Gil','1975-10-31','658897156',12),(3,'Juan Alberto','Santos','Pérez','1969-02-25','699877458',22),(4,'Antonio','LLanes','Ruiz','1990-05-04','633225887',10),(5,'Antonio','González','Beltrán','1981-03-04',NULL,7),(6,'Juan','Benítez','García','1972-02-28','669897581',12),(7,'Pedro','Guillén','Santana','1977-01-15','665558778',6),(8,'Ernesto','Díaz','Huertas','1965-12-15','610554795',9),(9,'Pepe','Sánchez','Maldonado','1964-04-06',NULL,4),(10,'Alberto','Cortés','Sánchez','1999-09-01','611022365',20),(11,'Federico','López','López','1997-01-02','600220236',21);
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo` (
  `nombre` char(15) NOT NULL,
  `puntos` decimal(3,0) DEFAULT NULL,
  `posicion` decimal(2,0) DEFAULT NULL,
  `numTemporadas` decimal(1,0) NOT NULL DEFAULT '0',
  `codPoblacion` int(11) NOT NULL,
  `idCapitan` int(11) DEFAULT NULL,
  `idEntrenador` int(11) DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  KEY `fk_equipo_poblacion1_idx` (`codPoblacion`),
  KEY `fk_equipo_jugador1_idx` (`idCapitan`),
  KEY `fk_equipo_entrenador1_idx` (`idEntrenador`),
  CONSTRAINT `fk_equipo_entrenador1` FOREIGN KEY (`idEntrenador`) REFERENCES `entrenador` (`idEntrenador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipo_jugador1` FOREIGN KEY (`idCapitan`) REFERENCES `jugador` (`idJugador`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_equipo_poblacion1` FOREIGN KEY (`codPoblacion`) REFERENCES `poblacion` (`codPoblacion`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES ('Aire de Levan',6,10,0,7,NULL,11),('Antrax',20,4,3,12,NULL,6),('Athlético PI',17,6,1,13,28,9),('Campeones',18,5,1,15,NULL,1),('Camperos',2,11,2,6,21,7),('Club DAW',NULL,NULL,0,16,NULL,9),('Club del Sur',12,7,1,11,37,4),('Club Raya',27,3,1,8,NULL,5),('Lagartos',11,8,2,12,9,2),('Mosquitos',28,2,0,22,56,3),('Roteña',30,1,3,6,53,8),('Sin Sentido',9,9,2,15,NULL,10);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jugador` (
  `idJugador` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido1` varchar(25) NOT NULL,
  `apellido2` varchar(25) NOT NULL,
  `alias` varchar(20) DEFAULT NULL,
  `dorsal` decimal(2,0) DEFAULT '9',
  `fecNacimiento` date DEFAULT NULL,
  `sueldo` decimal(6,2) DEFAULT '100.00',
  `codPoblacion` int(11) NOT NULL,
  `equipo_nombre` char(15) NOT NULL,
  PRIMARY KEY (`idJugador`),
  KEY `fk_jugador_poblacion1_idx` (`codPoblacion`),
  KEY `fk_jugador_equipo1_idx` (`equipo_nombre`),
  CONSTRAINT `fk_jugador_equipo1` FOREIGN KEY (`equipo_nombre`) REFERENCES `equipo` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_jugador_poblacion1` FOREIGN KEY (`codPoblacion`) REFERENCES `poblacion` (`codPoblacion`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES (1,'Pepe','Lillo','San Pedro','Pepillo',9,'1995-06-12',105.00,12,'Lagartos'),(2,'Pedro','González','Hernández','Pedro',1,'1997-05-06',89.25,12,'Lagartos'),(3,'Manolo','Fernández','Díaz','Manolo',2,'1994-01-08',102.90,12,'Lagartos'),(4,'Manuel','Rodríguez','Moreno','Lolo',3,'1987-10-14',126.00,12,'Lagartos'),(5,'Oscar','López','Álvarez','Oscar',4,'1987-11-10',52.50,12,'Lagartos'),(6,'Antonio','Martínez','Muñoz','Antonio',6,'1990-04-18',141.75,12,'Lagartos'),(7,'Manuel J.','Sánchez','Romero','Romerito',8,'1997-06-25',105.00,12,'Lagartos'),(8,'Alejandro','Pérez','Alonso','Alejandro',15,'1990-09-15',262.50,12,'Lagartos'),(9,'Santiago','Gómez','Gutiérrez','Gago',11,'1987-06-01',109.20,12,'Lagartos'),(10,'Rafael','Martín','Santos','Rafael',7,'1989-06-08',231.00,12,'Lagartos'),(11,'Antonio','Jiménez','Gil','Toño',13,'1998-01-07',147.00,13,'Lagartos'),(12,'Pepe','Ruiz','García','Gato',1,'1997-06-11',120.00,6,'Camperos'),(13,'Federico','Hernández','González','Lio',2,'1991-08-19',115.00,6,'Camperos'),(14,'Manolo','Díaz','Fernández','Lolo',3,'1993-03-21',100.00,6,'Camperos'),(15,'Fernando','Moreno','Rodríguez','Fernando',4,'1994-12-25',150.00,6,'Camperos'),(16,'Rafael','Álvarez','López','Lute',5,'1999-06-04',125.00,6,'Camperos'),(17,'Jimeno','Muñoz','Martínez','Jimeno',6,'1998-11-04',100.00,8,'Camperos'),(18,'Juan','Romero','Sánchez','Juan',7,'1999-04-03',100.00,9,'Camperos'),(19,'Juan','Alonso','Pérez','Coco',8,'1993-08-04',144.00,10,'Camperos'),(20,'Victor','Gutiérrez','Gómez','Victor',10,'1994-06-01',251.00,7,'Camperos'),(21,'José Manuel','Santos','Martín','Flequi',11,'1990-02-27',122.00,6,'Camperos'),(22,'Ángel','Gil','Jiménez','Ángel',12,'1996-07-04',155.00,6,'Camperos'),(23,'Manuel','Otero','Martínez','Gato',1,'1984-10-22',82.00,13,'Athlético PI'),(24,'Manuel','Torres','García','Manuel',2,'1993-07-03',129.00,13,'Athlético PI'),(25,'Antonio','Pérez','Gil','Antonio',3,'1981-02-17',65.00,13,'Athlético PI'),(26,'Fernando','Coll','Pelayo','El balita',4,'1984-10-21',110.00,13,'Athlético PI'),(27,'Sergio','Bueno','Gómez','Sergio',5,'1983-01-10',105.00,16,'Athlético PI'),(28,'José','Domínguez','Álvarez','José',6,'1981-01-20',87.00,13,'Athlético PI'),(29,'José Manuel','Murillo','Corbalán','José Manuel',7,'1984-07-05',163.00,13,'Athlético PI'),(30,'Suso','López','Figueroa','Ronco',8,'1988-08-23',186.00,16,'Athlético PI'),(31,'Mario','Laguna','Osuna','Tigre',9,'1981-09-25',175.00,13,'Athlético PI'),(32,'José María','Martin','Suarez','José María',10,'1996-10-26',86.00,13,'Athlético PI'),(33,'Antonio','Fernández','Gómez','Antonio',11,'1991-01-08',190.00,16,'Athlético PI'),(34,'Juan Antonio','González','Gil','Juan Antonio',1,'1993-04-14',73.00,8,'Club del Sur'),(35,'Rafael','Martin','Sánchez','Pelao',2,'1989-04-28',129.00,11,'Club del Sur'),(36,'Miguel Ángel','Bayón','Gutiérrez','Miguel Ángel',3,'1987-01-05',103.00,11,'Club del Sur'),(37,'Pablo','Vázquez','Soria','Pablo',4,'1981-04-04',168.00,11,'Club del Sur'),(38,'Francisco Javier','Domínguez','Rojas','Francisco Javier',5,'1982-05-09',56.00,11,'Club del Sur'),(39,'Jorge','Ferri','Barrios','Jorge',6,'1988-12-20',194.00,7,'Club del Sur'),(40,'Francisco Javier','Bazán','Fernández','Francisco Javier',7,'1997-04-26',119.00,11,'Club del Sur'),(41,'Jorge','Sempere','Ramírez','Foty',8,'1987-11-02',52.00,7,'Club del Sur'),(42,'Juan','Ramírez','Martin','Juan',9,'1994-07-17',118.00,11,'Club del Sur'),(43,'Alejandro','Costa','Vera','Alejandro',10,'1989-06-14',78.00,11,'Club del Sur'),(44,'Mario','Orellana','Cañadas','Mario',12,'1988-12-19',240.00,8,'Roteña'),(45,'Julio','Menacho','Rodríguez','Julio',1,'1988-11-22',188.00,6,'Roteña'),(46,'Juan','Ortiz','Ortega','Pilu',2,'1982-09-24',89.00,6,'Roteña'),(47,'Víctor','Muñoz','Muñiz','Víctor',3,'1985-10-15',52.00,8,'Roteña'),(48,'Manuel','Ramírez','Singh','Manuel',4,'1983-04-18',154.00,6,'Roteña'),(49,'Antonio','Molina','Gutiérrez','Antonio',5,'1985-11-07',156.00,9,'Roteña'),(50,'Sergio','García','Mínguez','Sergio',6,'1987-02-20',183.00,9,'Roteña'),(51,'Francisco','Pérez','García','Francisco',7,'1993-12-02',124.00,8,'Roteña'),(52,'Raúl','Blanco','Santos','Raúl',8,'1991-03-13',149.00,6,'Roteña'),(53,'Daniel','Pascual','Robles','Daniel',9,'1980-02-29',90.00,6,'Roteña'),(54,'Antonio','Martínez','Ferrer','Cafelito',10,'1988-07-14',187.00,6,'Roteña'),(55,'Marcos','Vega','Herraiz','Marcos',11,'1991-09-13',74.00,6,'Roteña'),(56,'Pedro','Rivera','Bernardo','Pedro',1,'1981-03-23',143.00,22,'Mosquitos'),(57,'José Luis','Mesa','Pérez','José Luis',2,'1995-09-04',69.00,22,'Mosquitos'),(58,'Javier','Carazo','Romero','Javier',3,'1989-03-18',55.00,22,'Mosquitos'),(59,'Jesús','Vega','Contreras','Jesús',4,'1995-11-15',166.00,22,'Mosquitos'),(60,'Jesús','Caballero','Ferrándiz','Jesús',5,'1989-08-02',143.00,22,'Mosquitos'),(61,'Joaquín','Giner','Sánchez','Joaquín',6,'1984-03-28',113.00,22,'Mosquitos'),(62,'Juan','Rodríguez','Noguera','Juan',7,'1986-01-02',148.00,22,'Mosquitos'),(63,'Jorge','Gómez','Vila','Negro',8,'1987-11-18',114.00,22,'Mosquitos'),(64,'Miguel Ángel','Villanueva','Flores','Miguel Ángel',9,'1988-12-06',140.00,22,'Mosquitos'),(66,'Antonio','Fuster','López','Rubio',11,'1995-08-06',82.00,22,'Mosquitos');
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partido` (
  `nombreEquipoLocal` char(15) NOT NULL,
  `nombreEquipoVisitante` char(15) NOT NULL,
  `fecEncuentro` date DEFAULT NULL,
  `resultado` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`nombreEquipoLocal`,`nombreEquipoVisitante`),
  KEY `fk_equipo_has_equipo_equipo2_idx` (`nombreEquipoVisitante`),
  KEY `fk_equipo_has_equipo_equipo1_idx` (`nombreEquipoLocal`),
  CONSTRAINT `fk_equipo_has_equipo_equipo1` FOREIGN KEY (`nombreEquipoLocal`) REFERENCES `equipo` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipo_has_equipo_equipo2` FOREIGN KEY (`nombreEquipoVisitante`) REFERENCES `equipo` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES ('Aire de Levan','Antrax',NULL,NULL),('Aire de Levan','Athlético PI',NULL,NULL),('Aire de Levan','Campeones',NULL,NULL),('Aire de Levan','Camperos',NULL,NULL),('Aire de Levan','Club DAW',NULL,NULL),('Aire de Levan','Club del Sur',NULL,NULL),('Aire de Levan','Club Raya',NULL,NULL),('Aire de Levan','Lagartos',NULL,NULL),('Aire de Levan','Mosquitos',NULL,NULL),('Aire de Levan','Roteña',NULL,NULL),('Aire de Levan','Sin Sentido',NULL,NULL),('Antrax','Aire de Levan',NULL,NULL),('Antrax','Athlético PI',NULL,NULL),('Antrax','Campeones',NULL,NULL),('Antrax','Camperos',NULL,NULL),('Antrax','Club DAW',NULL,NULL),('Antrax','Club del Sur',NULL,NULL),('Antrax','Club Raya',NULL,NULL),('Antrax','Lagartos',NULL,NULL),('Antrax','Mosquitos',NULL,NULL),('Antrax','Roteña',NULL,NULL),('Antrax','Sin Sentido',NULL,NULL),('Athlético PI','Aire de Levan',NULL,NULL),('Athlético PI','Antrax',NULL,NULL),('Athlético PI','Campeones',NULL,NULL),('Athlético PI','Camperos','2005-02-12','1-3'),('Athlético PI','Club DAW',NULL,NULL),('Athlético PI','Club del Sur','2005-07-19','2-4'),('Athlético PI','Club Raya',NULL,NULL),('Athlético PI','Lagartos','2005-05-06','2-2'),('Athlético PI','Mosquitos','2006-09-07','1-1'),('Athlético PI','Roteña','2006-02-18','5-1'),('Athlético PI','Sin Sentido',NULL,NULL),('Campeones','Aire de Levan',NULL,NULL),('Campeones','Antrax',NULL,NULL),('Campeones','Athlético PI',NULL,NULL),('Campeones','Camperos',NULL,NULL),('Campeones','Club DAW',NULL,NULL),('Campeones','Club del Sur',NULL,NULL),('Campeones','Club Raya',NULL,NULL),('Campeones','Lagartos',NULL,NULL),('Campeones','Mosquitos',NULL,NULL),('Campeones','Roteña',NULL,NULL),('Campeones','Sin Sentido',NULL,NULL),('Camperos','Aire de Levan',NULL,NULL),('Camperos','Antrax',NULL,NULL),('Camperos','Athlético PI','2005-05-05','3-4'),('Camperos','Campeones',NULL,NULL),('Camperos','Club DAW',NULL,NULL),('Camperos','Club del Sur','2006-10-03','2-1'),('Camperos','Club Raya',NULL,NULL),('Camperos','Lagartos','2005-02-14','3-4'),('Camperos','Mosquitos','2005-01-19','0-1'),('Camperos','Roteña','2006-04-27','0-5'),('Camperos','Sin Sentido',NULL,NULL),('Club DAW','Aire de Levan',NULL,NULL),('Club DAW','Antrax',NULL,NULL),('Club DAW','Athlético PI',NULL,NULL),('Club DAW','Campeones',NULL,NULL),('Club DAW','Camperos',NULL,NULL),('Club DAW','Club del Sur',NULL,NULL),('Club DAW','Club Raya',NULL,NULL),('Club DAW','Lagartos',NULL,NULL),('Club DAW','Mosquitos',NULL,NULL),('Club DAW','Roteña',NULL,NULL),('Club DAW','Sin Sentido',NULL,NULL),('Club del Sur','Aire de Levan',NULL,NULL),('Club del Sur','Antrax',NULL,NULL),('Club del Sur','Athlético PI','2006-05-08','5-4'),('Club del Sur','Campeones',NULL,NULL),('Club del Sur','Camperos','2005-10-14','0-5'),('Club del Sur','Club DAW',NULL,NULL),('Club del Sur','Club Raya',NULL,NULL),('Club del Sur','Lagartos','2006-02-25','3-0'),('Club del Sur','Mosquitos','2006-04-25','2-3'),('Club del Sur','Roteña','2005-09-03','3-3'),('Club del Sur','Sin Sentido',NULL,NULL),('Club Raya','Aire de Levan',NULL,NULL),('Club Raya','Antrax',NULL,NULL),('Club Raya','Athlético PI',NULL,NULL),('Club Raya','Campeones',NULL,NULL),('Club Raya','Camperos',NULL,NULL),('Club Raya','Club DAW',NULL,NULL),('Club Raya','Club del Sur',NULL,NULL),('Club Raya','Lagartos',NULL,NULL),('Club Raya','Mosquitos',NULL,NULL),('Club Raya','Roteña',NULL,NULL),('Club Raya','Sin Sentido',NULL,NULL),('Lagartos','Aire de Levan',NULL,NULL),('Lagartos','Antrax',NULL,NULL),('Lagartos','Athlético PI','2005-10-06','4-3'),('Lagartos','Campeones',NULL,NULL),('Lagartos','Camperos','2005-10-04','0-4'),('Lagartos','Club DAW',NULL,NULL),('Lagartos','Club del Sur','2005-09-23','0-5'),('Lagartos','Club Raya',NULL,NULL),('Lagartos','Mosquitos','2006-05-02','3-0'),('Lagartos','Roteña','2006-01-09','2-2'),('Lagartos','Sin Sentido',NULL,NULL),('Mosquitos','Aire de Levan',NULL,NULL),('Mosquitos','Antrax',NULL,NULL),('Mosquitos','Athlético PI','2005-10-18','0-3'),('Mosquitos','Campeones',NULL,NULL),('Mosquitos','Camperos','2006-01-06','3-1'),('Mosquitos','Club DAW',NULL,NULL),('Mosquitos','Club del Sur','2006-05-18','5-4'),('Mosquitos','Club Raya',NULL,NULL),('Mosquitos','Lagartos','2006-06-04','1-4'),('Mosquitos','Roteña','2006-07-23','2-5'),('Mosquitos','Sin Sentido',NULL,NULL),('Roteña','Aire de Levan',NULL,NULL),('Roteña','Antrax',NULL,NULL),('Roteña','Athlético PI','2005-10-08','4-4'),('Roteña','Campeones',NULL,NULL),('Roteña','Camperos','2005-06-23','0-4'),('Roteña','Club DAW',NULL,NULL),('Roteña','Club del Sur','2005-03-29','1-4'),('Roteña','Club Raya',NULL,NULL),('Roteña','Lagartos','2006-04-28','0-5'),('Roteña','Mosquitos','2005-09-11','3-3'),('Roteña','Sin Sentido',NULL,NULL),('Sin Sentido','Aire de Levan',NULL,NULL),('Sin Sentido','Antrax',NULL,NULL),('Sin Sentido','Athlético PI',NULL,NULL),('Sin Sentido','Campeones',NULL,NULL),('Sin Sentido','Camperos',NULL,NULL),('Sin Sentido','Club DAW',NULL,NULL),('Sin Sentido','Club del Sur',NULL,NULL),('Sin Sentido','Club Raya',NULL,NULL),('Sin Sentido','Lagartos',NULL,NULL),('Sin Sentido','Mosquitos',NULL,NULL),('Sin Sentido','Roteña',NULL,NULL);
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poblacion`
--

DROP TABLE IF EXISTS `poblacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poblacion` (
  `codPoblacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `codProvincia` int(11) NOT NULL,
  PRIMARY KEY (`codPoblacion`),
  KEY `fk_poblacion_provincia_idx` (`codProvincia`),
  CONSTRAINT `fk_poblacion_provincia` FOREIGN KEY (`codProvincia`) REFERENCES `provincia` (`codProvincia`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poblacion`
--

LOCK TABLES `poblacion` WRITE;
/*!40000 ALTER TABLE `poblacion` DISABLE KEYS */;
INSERT INTO `poblacion` VALUES (2,'Alcolea',1),(3,'Adra',1),(4,'Albox',1),(5,'Almería',1),(6,'Rota',2),(7,'Cádiz',2),(8,'Puerto Real',2),(9,'Chipiona',2),(10,'Chiclana',2),(11,'San Fernando',2),(12,'Alcalá de Guadaira',3),(13,'Sevilla',3),(14,'Carmon',3),(15,'El Viso del Alcor',3),(16,'Mairena del Alcor',3),(17,'Baena',4),(18,'Baeza',5),(19,'Benalmádena',6),(20,'Torremolinos',6),(21,'Ayamonte',7),(22,'Almuñécar',8),(23,'Guadix',4),(24,'Motril',4),(25,'Cartagena',9),(26,'Lorca',9);
/*!40000 ALTER TABLE `poblacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `codProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  PRIMARY KEY (`codProvincia`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'Almería'),(2,'Cádiz'),(3,'Sevilla'),(4,'Córdoba'),(5,'Jaén'),(6,'Málaga'),(7,'Huelva'),(8,'Granada'),(9,'Murcia');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'torneofutbol'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-25 17:56:58