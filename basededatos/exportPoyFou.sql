-- MySQL dump 10.13  Distrib 8.0.44, for Linux (x86_64)
--
-- Host: localhost    Database: tpIntegrador
-- ------------------------------------------------------
-- Server version	8.0.44-0ubuntu0.24.04.1

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
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `anio` int NOT NULL,
  `precio_por_dia` double NOT NULL,
  `tipo` enum('DEPORTIVO','SUV','SEDAN','CLASICO','COUPE','CONVERTIBLE') NOT NULL,
  `disponible` tinyint(1) DEFAULT '1',
  `descripcion` varchar(255) DEFAULT NULL,
  `imagen1` varchar(255) DEFAULT NULL,
  `imagen2` varchar(255) DEFAULT NULL,
  `imagen3` varchar(255) DEFAULT NULL,
  `imagen4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,'Porsche','911 Turbo S',2024,500,'DEPORTIVO',1,'Superdeportivo alemán de altísimo rendimiento','/img/porsche1.jpg','/img/porsche2.jpg','/img/porsche3.jpg','/img/porsche4.jpg'),(2,'Ferrari','F8 Tributo',2024,650,'DEPORTIVO',1,'Deportivo italiano con motor V8 biturbo','/img/ferrari1.jpg','/img/ferrari2.jpg','/img/ferrari3.jpg','/img/ferrari4.jpg'),(3,'Lamborghini','Huracán EVO',2024,700,'DEPORTIVO',1,'Deportivo extremo con tracción integral','/img/lambo1.jpg','/img/lambo2.jpg','/img/lambo3.jpg','/img/lambo4.jpg'),(4,'Range Rover','Autobiography',2024,450,'SUV',1,'SUV de lujo con interior de cuero premium','/img/rangerover1.jpg','/img/rangerover2.jpg','/img/rangerover3.jpg','/img/rangerover4.jpg'),(5,'Mercedes-Benz','GLS 600',2024,480,'SUV',1,'SUV ejecutivo con todas las comodidades','/img/mercedes1.jpg','/img/mercedes2.jpg','/img/mercedes3.jpg','/img/mercedes4.jpg'),(6,'Chevrolet','Corvette Stingray 67',1967,800,'CLASICO',1,'Clásico americano en estado de colección','/img/corvette1.jpg','/img/corvette2.jpg','/img/corvette3.jpg','/img/corvette4.jpg'),(7,'Ford','Mustang Shelby GT500',1968,750,'CLASICO',1,'Muscle car legendario totalmente restaurado','/img/mustang1.jpg','/img/mustang2.jpg','/img/mustang3.jpg','/img/mustang4.jpg'),(8,'Aston Martin','DB11 Volante',2024,600,'CONVERTIBLE',1,'Convertible de lujo británico','/img/aston1.jpg','/img/aston2.jpg','/img/aston3.jpg','/img/aston4.jpg'),(9,'BMW','M8 Competition',2024,550,'COUPE',1,'Coupe deportivo alemán de alto rendimiento',NULL,NULL,NULL,NULL),(10,'Audi','R8 V10',2024,680,'DEPORTIVO',1,'Deportivo alemán con motor V10',NULL,NULL,NULL,NULL),(11,'McLaren','720S',2024,850,'DEPORTIVO',0,'Superdeportivo británico ultraligero',NULL,NULL,NULL,NULL),(12,'Tesla','Model S Plaid',2024,400,'SEDAN',1,'Sedán eléctrico de alta performance',NULL,NULL,NULL,NULL),(13,'Jaguar','F-Type',2024,520,'CONVERTIBLE',1,'Convertible deportivo británico',NULL,NULL,NULL,NULL),(14,'Maserati','MC20',2024,720,'DEPORTIVO',1,'Deportivo italiano con motor Nettuno',NULL,NULL,NULL,NULL),(15,'Rolls Royce','Ghost',2024,1200,'SEDAN',1,'Sedán de lujo supremo británico',NULL,NULL,NULL,NULL),(16,'Bentley','Continental GT',2024,950,'COUPE',1,'Gran turismo de lujo inglés',NULL,NULL,NULL,NULL),(17,'Lexus','LC 500',2024,580,'COUPE',1,'Coupe japonés de alta gama',NULL,NULL,NULL,NULL),(18,'Nissan','GT-R Nismo',2024,620,'DEPORTIVO',1,'Deportivo japonés legendario',NULL,NULL,NULL,NULL),(19,'Chevrolet','Camaro ZL1',2024,480,'DEPORTIVO',1,'Muscle car americano moderno',NULL,NULL,NULL,NULL),(20,'Dodge','Challenger Hellcat',2024,520,'DEPORTIVO',1,'Muscle car extremo americano',NULL,NULL,NULL,NULL),(21,'Ford','Mustang GT',2024,420,'DEPORTIVO',1,'Icono americano deportivo',NULL,NULL,NULL,NULL),(22,'Volvo','XC90 Excellence',2024,380,'SUV',1,'SUV familiar premium sueco',NULL,NULL,NULL,NULL),(23,'Audi','Q8',2024,450,'SUV',1,'SUV coupé alemán de lujo',NULL,NULL,NULL,NULL),(24,'BMW','X7',2024,480,'SUV',1,'SUV full-size alemán',NULL,NULL,NULL,NULL),(25,'Mercedes-Benz','S-Class',2024,550,'SEDAN',1,'Sedán ejecutivo alemán',NULL,NULL,NULL,NULL),(26,'Cadillac','Escalade',2024,520,'SUV',1,'SUV americano icónico',NULL,NULL,NULL,NULL),(27,'Land Rover','Defender',2024,400,'SUV',1,'SUV todoterreno británico',NULL,NULL,NULL,NULL),(28,'Jeep','Grand Cherokee',2024,350,'SUV',1,'SUV americano versátil',NULL,NULL,NULL,NULL),(29,'Toyota','Land Cruiser',2024,380,'SUV',1,'SUV confiable japonés',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `contrasena` varchar(255) NOT NULL,
  `codigo_postal` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `membresia` tinyint DEFAULT NULL,
  `categoria_licencia` enum('A','B','C','D','E') DEFAULT NULL,
  `habilitado` bit(1) NOT NULL,
  `vip` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario` (`usuario`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Juan','Pérez','1155667788','30123456','Av. Corrientes 1234','juan.vip@email.com','clave123','C1043','Argentina',0,NULL,_binary '\0',_binary '\0'),(2,'María','Gómez','1166778899','32123456','Florida 456','maria.gomez@email.com','clave456','C1005','Argentina',2,NULL,_binary '\0',_binary '\0'),(3,'Carlos','López','1144556677','34123456','Lavalle 789','carlos.lopez@email.com','clave789','C1047','Argentina',2,NULL,_binary '\0',_binary '\0'),(4,'Ana','Martínez','1133445566','36123456','Cabildo 2345','ana.martinez@email.com','clave101','C1428','Argentina',0,NULL,_binary '\0',_binary '\0'),(5,'Pedro','Rodríguez','1122334455','38123456','Santa Fe 3210','pedro.rodriguez@email.com','clave202','C1125','Argentina',0,NULL,_binary '\0',_binary '\0'),(6,'Laura','Fernández','1199887766','40123456','Rivadavia 567','laura.fernandez@email.com','clave303','C1033','Argentina',0,NULL,_binary '\0',_binary '\0'),(7,'Diego','García','1155443322','42123456','Av. Libertador 2345','diego.garcia@email.com','clave404','C1428','Argentina',2,NULL,_binary '\0',_binary '\0'),(8,'Sofía','López','1166554433','44123456','Cabildo 1500','sofia.lopez@email.com','clave505','C1426','Argentina',0,NULL,_binary '\0',_binary '\0'),(9,'Martín','Díaz','1177665544','46123456','Av. Santa Fe 2100','martin.diaz@email.com','clave606','C1125','Argentina',2,NULL,_binary '\0',_binary '\0'),(10,'Lucía','Rodríguez','1188776655','48123456','Av. Corrientes 800','lucia.rodriguez@email.com','clave707','C1043','Argentina',0,NULL,_binary '\0',_binary '\0'),(11,'Gabriel','Fernández','1199887766','50123456','Palermo 345','gabriel.fernandez@email.com','clave808','C1414','Argentina',2,NULL,_binary '\0',_binary '\0'),(12,'Valentina','Martínez','1100998877','52123456','Belgrano 567','valentina.martinez@email.com','clave909','C1093','Argentina',0,NULL,_binary '\0',_binary '\0'),(13,'Alejandro','Silva','1144332211','54123456','Av. Cabildo 2800','alejandro.silva@email.com','clave111','C1428','Argentina',2,NULL,_binary '\0',_binary '\0'),(14,'Camila','Torres','1155223344','56123456','Av. Rivadavia 4500','camila.torres@email.com','clave222','C1406','Argentina',0,NULL,_binary '\0',_binary '\0'),(15,'Facundo','Mendoza','1166334455','58123456','Av. Directorio 2300','facundo.mendoza@email.com','clave333','C1407','Argentina',2,NULL,_binary '\0',_binary '\0'),(16,'Brenda','Rios','1177445566','60123456','Av. Nazca 1200','brenda.rios@email.com','clave444','C1419','Argentina',0,NULL,_binary '\0',_binary '\0'),(17,'Gonzalo','Castro','1188556677','62123456','Av. Gaona 1800','gonzalo.castro@email.com','clave555','C1405','Argentina',2,NULL,_binary '\0',_binary '\0'),(18,'Florencia','Ortiz','1199667788','64123456','Av. Juan B. Justo 3500','florencia.ortiz@email.com','clave666','C1414','Argentina',0,NULL,_binary '\0',_binary '\0'),(19,'Lucas','Acosta','1100778899','66123456','Av. Medrano 900','lucas.acosta@email.com','clave777','C1179','Argentina',2,NULL,_binary '\0',_binary '\0'),(20,'Carolina','Vargas','1111889977','68123456','Av. Scalabrini Ortiz 2200','carolina.vargas@email.com','clave888','C1425','Argentina',0,NULL,_binary '\0',_binary '\0'),(21,'Matías','Romero','1122998877','70123456','Av. Córdoba 3200','matias.romero@email.com','clave999','C1186','Argentina',2,NULL,_binary '\0',_binary '\0'),(22,'Natalia','Suarez','1133887766','72123456','Av. Santa Fe 1800','natalia.suarez@email.com','clave1010','C1123','Argentina',0,NULL,_binary '\0',_binary '\0'),(23,'Pablo','Herrera','1144776655','74123456','Av. Pueyrredón 1500','pablo.herrera@email.com','clave1111','C1119','Argentina',2,NULL,_binary '\0',_binary '\0'),(24,'Daniela','Gimenez','1155665544','76123456','Av. Callao 800','daniela.gimenez@email.com','clave1212','C1022','Argentina',0,NULL,_binary '\0',_binary '\0'),(25,'Sebastián','Molina','1166554433','78123456','Av. Las Heras 2400','sebastian.molina@email.com','clave1313','C1127','Argentina',2,NULL,_binary '\0',_binary '\0'),(26,'Verónica','Paz','1177443322','80123456','Av. Monroe 1600','veronica.paz@email.com','clave1414','C1429','Argentina',0,NULL,_binary '\0',_binary '\0'),(27,'Ezequiel','Reyes','1188332211','82123456','Av. Triunvirato 3800','ezequiel.reyes@email.com','clave1515','C1431','Argentina',2,NULL,_binary '\0',_binary '\0'),(28,'Agustina','Flores','1199221133','84123456','Av. Álvarez Jonte 4200','agustina.flores@email.com','clave1616','C1408','Argentina',0,NULL,_binary '\0',_binary '\0'),(29,'Julián','Campos','1100112233','86123456','Av. La Plata 1900','julian.campos@email.com','clave1717','C1245','Argentina',2,NULL,_binary '\0',_binary '\0'),(30,'Lourdes','Santos','1111223344','88123456','Av. Carabobo 800','lourdes.santos@email.com','clave1818','C1406','Argentina',0,NULL,_binary '\0',_binary '\0'),(31,'Brian','Luna','1122334455','90123456','Av. Acoyte 600','brian.luna@email.com','clave1919','C1405','Argentina',1,NULL,_binary '\0',_binary '\0'),(32,'Micaela','Cáceres','1133445566','92123456','Av. Boedo 1200','micaela.caceres@email.com','clave2020','C1221','Argentina',0,NULL,_binary '\0',_binary '\0'),(33,'lulo','rojas','352531','34532513','23123','lulorojas11@gmail.com','lulo123','1231','Argentina',0,NULL,_binary '\0',_binary '\0'),(34,'lulo','scanio','5345345345','32432534534','2312','lulo@gmail.com','1234','3424','Argentina',0,NULL,_binary '\0',_binary '\0');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garages`
--

DROP TABLE IF EXISTS `garages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garages` (
  `id_garage` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `ubicacion` varchar(255) DEFAULT NULL,
  `cantidad_lugares` int DEFAULT NULL,
  `pisos` int DEFAULT '1',
  PRIMARY KEY (`id_garage`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garages`
--

LOCK TABLES `garages` WRITE;
/*!40000 ALTER TABLE `garages` DISABLE KEYS */;
INSERT INTO `garages` VALUES (1,'Garage Central Microcentro','Av. Corrientes 1234, CABA',50,3),(2,'Garage Premium Palermo','Av. Santa Fe 3250, CABA',30,2),(3,'Garage Puerto Madero','Alicia Moreau de Justo 300, CABA',40,2);
/*!40000 ALTER TABLE `garages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugares`
--

DROP TABLE IF EXISTS `lugares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugares` (
  `id_lugar` int NOT NULL AUTO_INCREMENT,
  `id_garage` int NOT NULL,
  `numero_lugar` int NOT NULL,
  `tipo` enum('auto','moto','premium') DEFAULT 'auto',
  `piso` int DEFAULT '1',
  `estado` enum('disponible','ocupado','reservado','inactivo') DEFAULT 'disponible',
  `precio` int DEFAULT NULL,
  PRIMARY KEY (`id_lugar`),
  KEY `id_garage` (`id_garage`),
  CONSTRAINT `lugares_ibfk_1` FOREIGN KEY (`id_garage`) REFERENCES `garages` (`id_garage`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugares`
--

LOCK TABLES `lugares` WRITE;
/*!40000 ALTER TABLE `lugares` DISABLE KEYS */;
INSERT INTO `lugares` VALUES (1,1,1,'premium',1,'disponible',100),(2,1,2,'premium',1,'disponible',100),(3,1,3,'auto',1,'disponible',50),(4,1,4,'auto',1,'disponible',50),(5,1,5,'moto',1,'disponible',30),(6,2,1,'premium',1,'disponible',120),(7,2,2,'premium',1,'disponible',120),(8,2,3,'auto',1,'disponible',60),(9,2,4,'auto',1,'disponible',60),(10,3,1,'premium',1,'disponible',150),(11,3,2,'premium',1,'disponible',150),(12,3,3,'auto',1,'disponible',80),(13,3,4,'auto',1,'disponible',80);
/*!40000 ALTER TABLE `lugares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo_autorizado`
--

DROP TABLE IF EXISTS `modelo_autorizado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `modelo_autorizado` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `costo` double NOT NULL,
  `nombre_modelo` varchar(255) DEFAULT NULL,
  `cliente_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4sxy2sp8yy5umlgee049334t4` (`cliente_id`),
  CONSTRAINT `FK4sxy2sp8yy5umlgee049334t4` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo_autorizado`
--

LOCK TABLES `modelo_autorizado` WRITE;
/*!40000 ALTER TABLE `modelo_autorizado` DISABLE KEYS */;
INSERT INTO `modelo_autorizado` VALUES (1,500,'Ferrari F8',31),(2,500,'Ferrari F8',31),(3,500,'Ferrari F8',31);
/*!40000 ALTER TABLE `modelo_autorizado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_reserva` int NOT NULL,
  `monto` double NOT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `metodo` enum('EFECTIVO','TARJETA','TRANSFERENCIA') NOT NULL,
  `estado` enum('PENDIENTE','COMPLETADO','RECHAZADO') DEFAULT 'PENDIENTE',
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_pago` datetime(6) DEFAULT NULL,
  `numero_transaccion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_reserva` (`id_reserva`),
  CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (1,1,1000,'2024-11-09 15:30:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(2,2,1300,'2024-11-14 11:20:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(3,3,900,'2024-11-19 16:45:00','EFECTIVO','PENDIENTE',NULL,NULL,NULL),(4,4,1400,'2024-11-24 10:15:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(5,6,1100,'2024-01-14 10:00:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(6,7,900,'2024-01-19 14:30:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(7,8,1360,'2024-02-09 11:20:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(8,9,960,'2024-02-17 16:45:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(9,10,2550,'2024-03-04 09:15:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(10,11,1600,'2024-03-14 13:20:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(11,12,800,'2024-04-09 15:30:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(12,13,1040,'2024-04-19 10:45:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(13,14,1440,'2024-05-04 12:00:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(14,15,1000,'2024-05-14 17:30:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(15,16,1300,'2024-06-09 14:20:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(16,17,1400,'2024-06-19 11:10:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(17,18,1800,'2024-06-30 16:00:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(18,19,1920,'2024-07-09 10:30:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(19,20,4000,'2024-07-19 15:45:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(20,21,1500,'2024-08-04 13:20:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(21,22,1200,'2024-08-14 09:30:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(22,23,1100,'2024-09-09 14:15:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(23,24,1360,'2024-09-19 11:45:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(24,25,2550,'2024-10-04 16:20:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(25,26,800,'2024-10-14 12:30:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(26,27,2400,'2023-11-09 14:20:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(27,28,1900,'2023-11-14 16:45:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(28,29,2900,'2023-12-19 10:30:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(29,30,3100,'2023-12-21 11:15:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(30,31,2400,'2023-12-17 15:20:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(31,32,2600,'2024-01-04 09:45:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(32,33,1680,'2024-01-07 13:30:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(33,34,1140,'2024-01-11 17:20:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(34,35,1350,'2024-01-14 14:10:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(35,36,1920,'2024-02-09 16:30:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(36,37,2200,'2024-02-11 10:45:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(37,38,2080,'2024-02-14 12:20:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(38,39,1200,'2024-03-04 15:40:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(39,40,1050,'2024-03-09 11:25:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(40,41,1140,'2024-03-14 14:50:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(41,42,3000,'2024-03-31 16:15:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(42,43,3900,'2024-04-02 10:30:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(43,44,4200,'2024-04-04 13:45:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(44,45,900,'2024-05-09 17:20:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(45,46,960,'2024-05-14 14:35:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(46,47,1600,'2024-05-19 11:50:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(47,48,1500,'2024-06-04 15:10:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(48,49,1200,'2024-06-09 12:25:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(49,50,1100,'2024-06-14 16:40:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(50,51,4080,'2024-06-30 10:55:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(51,52,4250,'2024-07-04 14:20:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(52,53,1600,'2024-07-07 17:35:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(53,54,1040,'2024-08-09 11:50:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(54,55,1440,'2024-08-14 15:05:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(55,56,2400,'2024-08-19 12:20:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(56,57,2850,'2024-09-04 16:35:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(57,58,1740,'2024-09-09 10:50:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(58,59,1860,'2024-09-14 14:15:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(59,60,960,'2024-09-30 17:30:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(60,61,1560,'2024-10-04 11:45:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(61,62,840,'2024-10-09 15:00:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(62,63,1140,'2024-10-14 12:15:00','EFECTIVO','COMPLETADO',NULL,NULL,NULL),(63,64,1350,'2024-10-19 16:30:00','TARJETA','COMPLETADO',NULL,NULL,NULL),(64,65,1440,'2024-10-24 10:45:00','TRANSFERENCIA','COMPLETADO',NULL,NULL,NULL),(65,66,1650,'2024-10-29 14:00:00','TARJETA','COMPLETADO',NULL,NULL,NULL);
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resenia`
--

DROP TABLE IF EXISTS `resenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resenia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_auto` int NOT NULL,
  `calificacion` int DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_auto` (`id_auto`),
  CONSTRAINT `resenia_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `resenia_ibfk_2` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id`),
  CONSTRAINT `resenia_chk_1` CHECK ((`calificacion` between 1 and 5))
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resenia`
--

LOCK TABLES `resenia` WRITE;
/*!40000 ALTER TABLE `resenia` DISABLE KEYS */;
INSERT INTO `resenia` VALUES (1,1,1,5,'Excelente auto, muy potente y cómodo. Servicio impecable!','2024-11-13 10:00:00'),(2,2,2,4,'Increíble experiencia, el Ferrari es una bestia. Volvería a alquilar!','2024-11-18 14:30:00'),(3,3,3,5,'El Lamborghini superó todas mis expectativas. Atención de primera!','2024-11-28 16:20:00'),(4,7,9,5,'El BMW M8 es una bestia! Muy cómodo para viajes largos.','2024-01-18 09:00:00'),(5,8,4,4,'Buen SUV, ideal para familia. Podría mejorar el consumo.','2024-01-23 14:30:00'),(6,9,10,5,'Audi R8 espectacular! Sonido del V10 increíble.','2024-02-13 11:20:00'),(7,10,5,3,'Mercedes correcto, pero esperaba más por el precio.','2024-02-21 16:45:00'),(8,11,11,5,'McLaren 720S: simplemente perfecto! Velocidad brutal.','2024-03-09 10:15:00'),(9,12,6,4,'Corvette clásico muy bien mantenido. Experiencia única!','2024-03-18 13:20:00'),(10,1,12,5,'Tesla Model S Plaid: el futuro ya llegó! Aceleración increíble.','2024-04-13 15:30:00'),(11,13,15,5,'Rolls Royce Ghost: el máximo del lujo! Atención impecable.','2023-11-13 09:00:00'),(12,14,16,4,'Bentley Continental muy cómodo para viajes largos.','2023-11-18 14:30:00'),(13,15,17,5,'Lexus LC 500: diseño espectacular y confort excelente.','2023-12-26 11:20:00'),(14,16,18,5,'Nissan GT-R: bestia japonesa! Aceleración brutal.','2023-12-28 16:45:00'),(15,17,19,4,'Camaro ZL1 muy potente, consumo algo elevado.','2023-12-24 10:15:00'),(16,18,20,3,'Challenger Hellcat incómodo para ciudad, mejor en ruta.','2024-01-11 13:20:00'),(17,19,21,4,'Mustang GT clásico americano, muy divertido de manejar.','2024-01-13 15:30:00'),(18,20,22,5,'Volvo XC90 perfecto para familia, muy seguro.','2024-01-16 10:45:00'),(19,21,23,4,'Audi Q8 diseño moderno, tecnología de punta.','2024-01-19 12:00:00'),(20,22,24,5,'BMW X7 espacioso y lujoso, ideal para viajes.','2024-02-15 17:30:00'),(21,23,25,5,'Mercedes S-Class: el rey de los sedanes!','2024-02-17 14:20:00'),(22,24,26,4,'Cadillac Escalade enorme y cómodo, gasta mucho.','2024-02-20 11:10:00'),(23,25,27,5,'Land Rover Defender todoterreno excepcional.','2024-03-09 16:00:00'),(24,26,28,3,'Jeep Grand Cherokee correcto, nada especial.','2024-03-14 10:30:00'),(25,27,29,4,'Toyota Land Cruiser muy confiable para cualquier terreno.','2024-03-19 15:45:00'),(26,28,1,5,'Porsche 911 siempre impecable! Segunda vez que lo alquilo.','2024-04-08 09:15:00'),(27,29,2,5,'Ferrari F8 Tributo: sonido del V8 es música!','2024-04-10 14:20:00'),(28,30,3,4,'Lamborghini Huracán llamativo, algo incómodo para viajar.','2024-04-12 16:35:00'),(29,31,4,5,'Range Rover Autobiography: lujo y confort absolutos.','2024-05-13 11:50:00'),(30,32,5,4,'Mercedes GLS muy espacioso, buen andar.','2024-05-18 13:05:00'),(31,13,6,5,'Corvette clásico en perfecto estado! Experiencia única.','2024-05-23 15:20:00'),(32,14,7,4,'Mustang Shelby muy bien cuidado, potencia controlada.','2024-06-08 10:35:00'),(33,15,8,5,'Aston Martin DB11: elegancia británica en estado puro.','2024-06-13 12:50:00'),(34,16,9,4,'BMW M8 Competition muy rápido, consumo aceptable.','2024-06-18 17:05:00'),(35,17,10,5,'Audi R8 V10: deportivo perfecto! Sonido increíble.','2024-07-08 14:20:00');
/*!40000 ALTER TABLE `resenia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_auto` int NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `estado` enum('PENDIENTE','CONFIRMADA','CANCELADA','FINALIZADA') DEFAULT 'PENDIENTE',
  `total` double NOT NULL,
  `metodo_pago` enum('EFECTIVO','TARJETA','TRANSFERENCIA') DEFAULT 'TARJETA',
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_auto` (`id_auto`),
  CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,1,1,'2024-11-10','2024-11-12','CONFIRMADA',1000,'TARJETA'),(2,2,2,'2024-11-15','2024-11-17','CONFIRMADA',1300,'TARJETA'),(3,4,4,'2024-11-20','2024-11-22','PENDIENTE',900,'EFECTIVO'),(4,3,3,'2024-11-25','2024-11-27','CONFIRMADA',1400,'TRANSFERENCIA'),(5,5,5,'2024-12-01','2024-12-03','PENDIENTE',960,'EFECTIVO'),(6,7,9,'2024-01-15','2024-01-17','FINALIZADA',1100,'TARJETA'),(7,8,4,'2024-01-20','2024-01-22','FINALIZADA',900,'EFECTIVO'),(8,9,10,'2024-02-10','2024-02-12','FINALIZADA',1360,'TARJETA'),(9,10,5,'2024-02-18','2024-02-20','FINALIZADA',960,'TRANSFERENCIA'),(10,11,11,'2024-03-05','2024-03-08','FINALIZADA',2550,'TARJETA'),(11,12,6,'2024-03-15','2024-03-17','FINALIZADA',1600,'EFECTIVO'),(12,1,12,'2024-04-10','2024-04-12','FINALIZADA',800,'TARJETA'),(13,2,13,'2024-04-20','2024-04-22','FINALIZADA',1040,'TARJETA'),(14,3,14,'2024-05-05','2024-05-07','FINALIZADA',1440,'TRANSFERENCIA'),(15,4,1,'2024-05-15','2024-05-17','FINALIZADA',1000,'EFECTIVO'),(16,5,2,'2024-06-10','2024-06-12','FINALIZADA',1300,'TARJETA'),(17,6,3,'2024-06-20','2024-06-22','FINALIZADA',1400,'TARJETA'),(18,7,4,'2024-07-01','2024-07-05','FINALIZADA',1800,'TARJETA'),(19,8,5,'2024-07-10','2024-07-14','FINALIZADA',1920,'TARJETA'),(20,9,6,'2024-07-20','2024-07-25','FINALIZADA',4000,'TRANSFERENCIA'),(21,10,7,'2024-08-05','2024-08-07','FINALIZADA',1500,'EFECTIVO'),(22,11,8,'2024-08-15','2024-08-17','FINALIZADA',1200,'TARJETA'),(23,12,9,'2024-09-10','2024-09-12','FINALIZADA',1100,'TARJETA'),(24,1,10,'2024-09-20','2024-09-22','FINALIZADA',1360,'TARJETA'),(25,2,11,'2024-10-05','2024-10-08','FINALIZADA',2550,'TRANSFERENCIA'),(26,3,12,'2024-10-15','2024-10-17','FINALIZADA',800,'EFECTIVO'),(27,13,15,'2023-11-10','2023-11-12','FINALIZADA',2400,'TARJETA'),(28,14,16,'2023-11-15','2023-11-17','FINALIZADA',1900,'EFECTIVO'),(29,15,17,'2023-12-20','2023-12-25','FINALIZADA',2900,'TARJETA'),(30,16,18,'2023-12-22','2023-12-27','FINALIZADA',3100,'TARJETA'),(31,17,19,'2023-12-18','2023-12-23','FINALIZADA',2400,'TRANSFERENCIA'),(32,18,20,'2024-01-05','2024-01-10','FINALIZADA',2600,'TARJETA'),(33,19,21,'2024-01-08','2024-01-12','FINALIZADA',1680,'EFECTIVO'),(34,20,22,'2024-01-12','2024-01-15','FINALIZADA',1140,'TARJETA'),(35,21,23,'2024-01-15','2024-01-18','FINALIZADA',1350,'TARJETA'),(36,22,24,'2024-02-10','2024-02-14','FINALIZADA',1920,'TARJETA'),(37,23,25,'2024-02-12','2024-02-16','FINALIZADA',2200,'TRANSFERENCIA'),(38,24,26,'2024-02-15','2024-02-19','FINALIZADA',2080,'EFECTIVO'),(39,25,27,'2024-03-05','2024-03-08','FINALIZADA',1200,'TARJETA'),(40,26,28,'2024-03-10','2024-03-13','FINALIZADA',1050,'TARJETA'),(41,27,29,'2024-03-15','2024-03-18','FINALIZADA',1140,'EFECTIVO'),(42,28,1,'2024-04-01','2024-04-07','FINALIZADA',3000,'TARJETA'),(43,29,2,'2024-04-03','2024-04-09','FINALIZADA',3900,'TARJETA'),(44,30,3,'2024-04-05','2024-04-11','FINALIZADA',4200,'TRANSFERENCIA'),(45,31,4,'2024-05-10','2024-05-12','FINALIZADA',900,'EFECTIVO'),(46,32,5,'2024-05-15','2024-05-17','FINALIZADA',960,'TARJETA'),(47,13,6,'2024-05-20','2024-05-22','FINALIZADA',1600,'TARJETA'),(48,14,7,'2024-06-05','2024-06-07','FINALIZADA',1500,'EFECTIVO'),(49,15,8,'2024-06-10','2024-06-12','FINALIZADA',1200,'TARJETA'),(50,16,9,'2024-06-15','2024-06-17','FINALIZADA',1100,'TARJETA'),(51,17,10,'2024-07-01','2024-07-07','FINALIZADA',4080,'TARJETA'),(52,18,11,'2024-07-05','2024-07-10','FINALIZADA',4250,'TARJETA'),(53,19,12,'2024-07-08','2024-07-12','FINALIZADA',1600,'EFECTIVO'),(54,20,13,'2024-08-10','2024-08-12','FINALIZADA',1040,'TARJETA'),(55,21,14,'2024-08-15','2024-08-17','FINALIZADA',1440,'TRANSFERENCIA'),(56,22,15,'2024-08-20','2024-08-22','FINALIZADA',2400,'TARJETA'),(57,23,16,'2024-09-05','2024-09-08','FINALIZADA',2850,'TARJETA'),(58,24,17,'2024-09-10','2024-09-13','FINALIZADA',1740,'EFECTIVO'),(59,25,18,'2024-09-15','2024-09-18','FINALIZADA',1860,'TARJETA'),(60,26,19,'2024-10-01','2024-10-03','FINALIZADA',960,'EFECTIVO'),(61,27,20,'2024-10-05','2024-10-08','FINALIZADA',1560,'TARJETA'),(62,28,21,'2024-10-10','2024-10-12','FINALIZADA',840,'TARJETA'),(63,29,22,'2024-10-15','2024-10-18','FINALIZADA',1140,'EFECTIVO'),(64,30,23,'2024-10-20','2024-10-23','FINALIZADA',1350,'TARJETA'),(65,31,24,'2024-10-25','2024-10-28','FINALIZADA',1440,'TRANSFERENCIA'),(66,32,25,'2024-10-30','2024-11-02','FINALIZADA',1650,'TARJETA'),(67,13,26,'2024-11-05','2024-11-08','CONFIRMADA',1560,'TARJETA'),(68,14,27,'2024-11-10','2024-11-13','CONFIRMADA',1200,'EFECTIVO'),(69,15,28,'2024-11-15','2024-11-18','PENDIENTE',1050,'TARJETA'),(70,16,29,'2024-11-20','2024-11-23','PENDIENTE',1140,'TARJETA'),(71,17,1,'2024-11-25','2024-11-28','PENDIENTE',1500,'EFECTIVO'),(72,18,2,'2024-11-30','2024-12-03','PENDIENTE',1950,'TARJETA'),(73,19,3,'2024-12-05','2024-12-08','PENDIENTE',2100,'TRANSFERENCIA'),(74,20,4,'2024-12-10','2024-12-13','PENDIENTE',1350,'TARJETA'),(75,21,5,'2024-12-15','2024-12-18','PENDIENTE',1440,'EFECTIVO'),(76,22,6,'2024-12-20','2024-12-25','PENDIENTE',4000,'TARJETA'),(77,1,1,'2025-12-25','2025-12-30','CONFIRMADA',2500,'TARJETA');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva_conductores`
--

DROP TABLE IF EXISTS `reserva_conductores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva_conductores` (
  `id_reserva` int NOT NULL,
  `id_conductor` int NOT NULL,
  PRIMARY KEY (`id_reserva`,`id_conductor`),
  KEY `FK79xnm2co3j4j5p4torsl6vcma` (`id_conductor`),
  CONSTRAINT `FK717o5pn3mtep4uv9mn5lq8r89` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`),
  CONSTRAINT `FK79xnm2co3j4j5p4torsl6vcma` FOREIGN KEY (`id_conductor`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva_conductores`
--

LOCK TABLES `reserva_conductores` WRITE;
/*!40000 ALTER TABLE `reserva_conductores` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva_conductores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservasGaraje`
--

DROP TABLE IF EXISTS `reservasGaraje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservasGaraje` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_lugar` int NOT NULL,
  `fecha_reserva` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  `duracion` int GENERATED ALWAYS AS (timestampdiff(HOUR,`fecha_inicio`,`fecha_fin`)) STORED,
  `estado` enum('pendiente','activa','finalizada','cancelada') DEFAULT 'pendiente',
  PRIMARY KEY (`id_reserva`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_lugar` (`id_lugar`),
  CONSTRAINT `reservasGaraje_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `reservasGaraje_ibfk_2` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservasGaraje`
--

LOCK TABLES `reservasGaraje` WRITE;
/*!40000 ALTER TABLE `reservasGaraje` DISABLE KEYS */;
INSERT INTO `reservasGaraje` (`id_reserva`, `id_cliente`, `id_lugar`, `fecha_reserva`, `fecha_inicio`, `fecha_fin`, `estado`) VALUES (1,1,1,'2025-11-07 11:29:39','2024-11-10 08:00:00','2024-11-12 20:00:00','finalizada'),(2,2,6,'2025-11-07 11:29:39','2024-11-15 09:00:00','2024-11-17 18:00:00','finalizada'),(3,4,8,'2025-11-07 11:29:39','2024-11-20 10:00:00','2024-11-22 19:00:00','pendiente'),(4,3,10,'2025-11-07 11:29:39','2024-11-25 07:00:00','2024-11-27 21:00:00','pendiente'),(5,7,2,'2025-11-07 09:56:58','2024-01-15 08:00:00','2024-01-17 20:00:00','finalizada'),(6,8,3,'2025-11-07 09:56:58','2024-01-20 09:00:00','2024-01-22 18:00:00','finalizada'),(7,9,7,'2025-11-07 09:56:58','2024-02-10 07:00:00','2024-02-12 21:00:00','finalizada'),(8,10,8,'2025-11-07 09:56:58','2024-02-18 10:00:00','2024-02-20 19:00:00','finalizada'),(9,11,11,'2025-11-07 09:56:58','2024-03-05 08:30:00','2024-03-08 20:30:00','finalizada'),(10,12,12,'2025-11-07 09:56:58','2024-03-15 09:15:00','2024-03-17 18:45:00','finalizada'),(11,13,2,'2025-11-07 10:09:55','2023-11-10 08:00:00','2023-11-12 20:00:00','finalizada'),(12,14,3,'2025-11-07 10:09:55','2023-11-15 09:00:00','2023-11-17 18:00:00','finalizada'),(13,15,4,'2025-11-07 10:09:55','2023-12-20 07:00:00','2023-12-25 21:00:00','finalizada'),(14,16,5,'2025-11-07 10:09:55','2023-12-22 08:30:00','2023-12-27 19:30:00','finalizada'),(15,17,7,'2025-11-07 10:09:55','2023-12-18 10:00:00','2023-12-23 20:00:00','finalizada'),(16,18,8,'2025-11-07 10:09:55','2024-01-05 09:15:00','2024-01-10 18:45:00','finalizada'),(17,19,9,'2025-11-07 10:09:55','2024-01-08 08:45:00','2024-01-12 19:15:00','finalizada'),(18,20,10,'2025-11-07 10:09:55','2024-01-12 07:30:00','2024-01-15 20:30:00','finalizada'),(19,21,11,'2025-11-07 10:09:55','2024-01-15 09:00:00','2024-01-18 18:00:00','finalizada'),(20,22,12,'2025-11-07 10:09:55','2024-02-10 08:15:00','2024-02-14 19:45:00','finalizada'),(21,23,13,'2025-11-07 10:09:55','2024-02-12 07:45:00','2024-02-16 20:15:00','finalizada'),(22,24,1,'2025-11-07 10:09:55','2024-02-15 09:30:00','2024-02-19 18:30:00','finalizada'),(23,25,2,'2025-11-07 10:09:55','2024-03-05 08:00:00','2024-03-08 20:00:00','finalizada'),(24,26,3,'2025-11-07 10:09:55','2024-03-10 09:15:00','2024-03-13 18:45:00','finalizada'),(25,27,4,'2025-11-07 10:09:55','2024-03-15 08:30:00','2024-03-18 19:30:00','finalizada'),(26,28,5,'2025-11-07 10:09:55','2024-04-01 07:45:00','2024-04-07 20:15:00','finalizada'),(27,29,7,'2025-11-07 10:09:55','2024-04-03 09:00:00','2024-04-09 18:00:00','finalizada'),(28,30,8,'2025-11-07 10:09:55','2024-04-05 08:15:00','2024-04-11 19:45:00','finalizada'),(29,31,9,'2025-11-07 10:09:55','2024-05-10 09:30:00','2024-05-12 18:30:00','finalizada'),(30,32,10,'2025-11-07 10:09:55','2024-05-15 08:45:00','2024-05-17 19:15:00','finalizada'),(31,13,11,'2025-11-07 10:09:55','2024-05-20 07:00:00','2024-05-22 20:00:00','finalizada'),(32,14,12,'2025-11-07 10:09:55','2024-06-05 09:15:00','2024-06-07 18:45:00','finalizada'),(33,15,13,'2025-11-07 10:09:55','2024-06-10 08:30:00','2024-06-12 19:30:00','finalizada'),(34,16,1,'2025-11-07 10:09:55','2024-06-15 07:45:00','2024-06-17 20:15:00','finalizada'),(35,17,2,'2025-11-07 10:09:55','2024-07-01 09:00:00','2024-07-07 18:00:00','finalizada'),(36,18,3,'2025-11-07 10:09:55','2024-07-05 08:15:00','2024-07-10 19:45:00','finalizada'),(37,19,4,'2025-11-07 10:09:55','2024-07-08 09:30:00','2024-07-12 18:30:00','finalizada'),(38,20,5,'2025-11-07 10:09:55','2024-08-10 08:45:00','2024-08-12 19:15:00','finalizada'),(39,21,7,'2025-11-07 10:09:55','2024-08-15 07:00:00','2024-08-17 20:00:00','finalizada'),(40,22,8,'2025-11-07 10:09:55','2024-08-20 09:15:00','2024-08-22 18:45:00','finalizada');
/*!40000 ALTER TABLE `reservasGaraje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trayecto`
--

DROP TABLE IF EXISTS `trayecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trayecto` (
  `id_trayecto` int NOT NULL AUTO_INCREMENT,
  `direccion_destino` varchar(255) DEFAULT NULL,
  `direccion_origen` varchar(255) DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `id_reserva` int DEFAULT NULL,
  PRIMARY KEY (`id_trayecto`),
  KEY `FKqhj397hj4yr0ktai7iifq7l2g` (`id_reserva`),
  CONSTRAINT `FKqhj397hj4yr0ktai7iifq7l2g` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trayecto`
--

LOCK TABLES `trayecto` WRITE;
/*!40000 ALTER TABLE `trayecto` DISABLE KEYS */;
INSERT INTO `trayecto` VALUES (1,'Aeropuerto Internacional Ezeiza','Garage Central Microcentro','2024-11-10','2024-11-10',1),(2,'Tigre, Buenos Aires','Aeropuerto Internacional Ezeiza','2024-11-12','2024-11-11',1),(3,'La Plata, Buenos Aires','Garage Premium Palermo','2024-11-15','2024-11-15',2),(4,'Mar del Plata, Buenos Aires','La Plata, Buenos Aires','2024-11-17','2024-11-16',2),(5,'Luján, Buenos Aires','Garage Puerto Madero','2024-11-25','2024-11-25',4),(6,'San Antonio de Areco','Luján, Buenos Aires','2024-11-27','2024-11-26',4),(7,'San Carlos de Bariloche','Garage Central Microcentro','2024-07-02','2024-07-01',18),(8,'Mendoza','Garage Premium Palermo','2024-07-11','2024-07-10',19),(9,'Córdoba Capital','Garage Puerto Madero','2024-07-21','2024-07-20',20),(10,'Mar del Plata','Garage Central Microcentro','2024-08-06','2024-08-05',21),(11,'Tandil','Garage Premium Palermo','2024-08-16','2024-08-15',22),(12,'Salta','Garage Puerto Madero','2024-09-11','2024-09-10',23),(13,'Iguazú','Garage Central Microcentro','2024-09-21','2024-09-20',24),(14,'Usuahia','Garage Premium Palermo','2024-10-06','2024-10-05',25),(15,'Puerto Madryn','Garage Puerto Madero','2024-10-16','2024-10-15',26),(16,'Carlos Paz, Córdoba','Garage Central Microcentro','2023-11-11','2023-11-10',27),(17,'Villa General Belgrano','Carlos Paz, Córdoba','2023-11-12','2023-11-11',27),(18,'Mina Clavero, Córdoba','Garage Premium Palermo','2023-11-16','2023-11-15',28),(19,'Non','Mina Clavero, Córdoba','2023-11-17','2023-11-16',28),(20,'San Martín de los Andes','Garage Puerto Madero','2023-12-21','2023-12-20',29),(21,'Villa La Angostura','San Martín de los Andes','2023-12-25','2023-12-22',29),(22,'Bariloche','Garage Central Microcentro','2023-12-23','2023-12-22',30),(23,'El Bolsón','Bariloche','2023-12-27','2023-12-24',30),(24,'Mendoza Capital','Garage Premium Palermo','2023-12-19','2023-12-18',31),(25,'Potrerillos','Mendoza Capital','2023-12-23','2023-12-20',31),(26,'San Rafael','Garage Puerto Madero','2024-01-06','2024-01-05',32),(27,'Malargüe','San Rafael','2024-01-10','2024-01-07',32),(28,'Gualeguaychú','Garage Central Microcentro','2024-01-09','2024-01-08',33),(29,'Colón','Gualeguaychú','2024-01-12','2024-01-10',33),(30,'Villa Gesell','Garage Premium Palermo','2024-01-13','2024-01-12',34),(31,'Pinamar','Villa Gesell','2024-01-15','2024-01-14',34),(32,'Cariló','Garage Puerto Madero','2024-01-16','2024-01-15',35),(33,'San Clemente','Cariló','2024-01-18','2024-01-17',35),(34,'Termas de Río Hondo','Garage Central Microcentro','2024-02-11','2024-02-10',36),(35,'Santiago del Estero','Termas de Río Hondo','2024-02-14','2024-02-12',36),(36,'Tafí del Valle','Garage Premium Palermo','2024-02-13','2024-02-12',37),(37,'Amaicha del Valle','Tafí del Valle','2024-02-16','2024-02-14',37),(38,'Cafayate','Garage Puerto Madero','2024-02-16','2024-02-15',38),(39,'Cachi','Cafayate','2024-02-19','2024-02-17',38),(40,'Humahuaca','Garage Central Microcentro','2024-03-06','2024-03-05',39),(41,'Tilcara','Humahuaca','2024-03-08','2024-03-07',39),(42,'Purmamarca','Garage Premium Palermo','2024-03-11','2024-03-10',40),(43,'Salinas Grandes','Purmamarca','2024-03-13','2024-03-12',40),(44,'El Calafate','Garage Puerto Madero','2024-03-16','2024-03-15',41),(45,'El Chaltén','El Calafate','2024-03-18','2024-03-17',41);
/*!40000 ALTER TABLE `trayecto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-04  9:41:57
