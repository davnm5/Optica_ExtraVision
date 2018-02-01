-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: optica
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `armazon`
--

DROP TABLE IF EXISTS `armazon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `armazon` (
  `idArmazon` int(10) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `Proveedor_idProveedor` int(10) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idArmazon`),
  KEY `fk_Armazon_Proveedor1_idx` (`Proveedor_idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armazon`
--

LOCK TABLES `armazon` WRITE;
/*!40000 ALTER TABLE `armazon` DISABLE KEYS */;
INSERT INTO `armazon` VALUES (5,'Resistente',50.6,302,3,'Gucci'),(6,'Duraderos',150,301,2,'Ray Ban'),(7,'Flexibles',60,303,1,'Gucci'),(8,'Liviano',75.5,300,5,'Ray Ban'),(10,'ligeros',30,300,5,'gucci'),(11,'resistentes',30,301,4,'Angelina'),(12,'Flexibles',45,301,5,'Gucci');
/*!40000 ALTER TABLE `armazon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atencion`
--

DROP TABLE IF EXISTS `atencion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atencion` (
  `idAtencion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `Optometra_idOptometra` int(11) NOT NULL,
  `Paciente_cedula` varchar(10) NOT NULL,
  PRIMARY KEY (`idAtencion`),
  UNIQUE KEY `idAtencion_UNIQUE` (`idAtencion`),
  KEY `fk_Atencion_Optometra1_idx` (`Optometra_idOptometra`),
  KEY `kk_Atencion_Paciente_idx` (`Paciente_cedula`),
  CONSTRAINT `fk_Atencion_Optometra` FOREIGN KEY (`Optometra_idOptometra`) REFERENCES `optometra` (`idOptometra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atencion_Paciente` FOREIGN KEY (`Paciente_cedula`) REFERENCES `paciente` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atencion`
--

LOCK TABLES `atencion` WRITE;
/*!40000 ALTER TABLE `atencion` DISABLE KEYS */;
/*!40000 ALTER TABLE `atencion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `brigada_optometra_vendedor`
--

DROP TABLE IF EXISTS `brigada_optometra_vendedor`;
/*!50001 DROP VIEW IF EXISTS `brigada_optometra_vendedor`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `brigada_optometra_vendedor` AS SELECT 
 1 AS `Fecha_Brigada`,
 1 AS `Hora_Inicio_Brigada`,
 1 AS `Hora_Fin_Brigada`,
 1 AS `Lugar_Brigada`,
 1 AS `Nombre_Optometra`,
 1 AS `Apellido_Optometra`,
 1 AS `Nombre_Vendedor`,
 1 AS `Apellido_Vendedor`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `brigadas`
--

DROP TABLE IF EXISTS `brigadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brigadas` (
  `idBrigadas` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora_inicio` varchar(10) DEFAULT NULL,
  `hora_fin` varchar(10) DEFAULT NULL,
  `numero_pacientes` int(11) DEFAULT NULL,
  `lugar` varchar(45) DEFAULT NULL,
  `Vendedor_idVendedor` int(10) unsigned NOT NULL,
  `Optometra_idOptometra` int(11) NOT NULL,
  PRIMARY KEY (`idBrigadas`),
  UNIQUE KEY `idBrigadas_UNIQUE` (`idBrigadas`),
  KEY `fk_Brigadas_Vendedor1_idx` (`Vendedor_idVendedor`),
  KEY `fk_Brigadas_Optometra1_idx` (`Optometra_idOptometra`),
  KEY `brigadas_lugar_index` (`lugar`),
  CONSTRAINT `fk_Brigadas_Optometra1` FOREIGN KEY (`Optometra_idOptometra`) REFERENCES `optometra` (`idOptometra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Brigadas_Vendedor1` FOREIGN KEY (`Vendedor_idVendedor`) REFERENCES `vendedor` (`idVendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=704 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brigadas`
--

LOCK TABLES `brigadas` WRITE;
/*!40000 ALTER TABLE `brigadas` DISABLE KEYS */;
INSERT INTO `brigadas` VALUES (700,'2018-01-15','10:30:00','15:30:00',100,'Daule',500,205),(703,'2018-01-04','9:10:00','17:1:00',14,'Emplame',3,205);
/*!40000 ALTER TABLE `brigadas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `idCompra` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `total` float DEFAULT NULL,
  `Vendedor_idVendedor` int(10) unsigned NOT NULL,
  `Lentes_idLente` int(10) unsigned NOT NULL,
  `Paciente_cedula` varchar(10) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_Compra_Vendedor1_idx` (`Vendedor_idVendedor`),
  KEY `fk_Compra_Lente1_idx` (`Lentes_idLente`),
  KEY `fk_Compra_Paciente_idx` (`Paciente_cedula`),
  CONSTRAINT `fk_Compra_Lentes` FOREIGN KEY (`Lentes_idLente`) REFERENCES `lentes` (`idLente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_Paciente` FOREIGN KEY (`Paciente_cedula`) REFERENCES `paciente` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_Vendedor` FOREIGN KEY (`Vendedor_idVendedor`) REFERENCES `vendedor` (`idVendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (5,'sin descuentos',60.5,2,2,'0954297567','2018-01-04'),(6,'sin descuentos',60.5,2,2,'0954297567','2018-01-04'),(9,'Descuento del 50%',60,500,1,'0987645321','2018-01-10');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `compra_paciente_lentes`
--

DROP TABLE IF EXISTS `compra_paciente_lentes`;
/*!50001 DROP VIEW IF EXISTS `compra_paciente_lentes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `compra_paciente_lentes` AS SELECT 
 1 AS `Descripcion_Compra`,
 1 AS `Total_Compra`,
 1 AS `Cedula_Paciente`,
 1 AS `Nombre_Paciente`,
 1 AS `Apellido_Paciente`,
 1 AS `descripcion`,
 1 AS `precio`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diagnostico` (
  `idDiagnostico` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `esfera_OI` float DEFAULT NULL,
  `esfera_OD` float DEFAULT NULL,
  `cilindro_OD` float DEFAULT NULL,
  `cilindro_OI` float DEFAULT NULL,
  `ADD` float DEFAULT NULL,
  `recomendacion` varchar(100) DEFAULT NULL,
  `Optometra_idOptometra` int(11) NOT NULL,
  PRIMARY KEY (`idDiagnostico`),
  UNIQUE KEY `idDiagnostico_UNIQUE` (`idDiagnostico`),
  KEY `fk_Diagnostico_Optometra1_idx` (`Optometra_idOptometra`),
  CONSTRAINT `fk_Diagnostico_Optometra1` FOREIGN KEY (`Optometra_idOptometra`) REFERENCES `optometra` (`idOptometra`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico`
--

LOCK TABLES `diagnostico` WRITE;
/*!40000 ALTER TABLE `diagnostico` DISABLE KEYS */;
INSERT INTO `diagnostico` VALUES (40,'miopia',2.5,2,1.5,1.6,2,'lentes permanetes',205),(41,'astigmatismo',1.2,1.3,0.5,0.6,1.1,'lentes temporales',206),(42,'hipermetropia',3.4,3,1.2,4.5,1.5,'lentes permanentes',205);
/*!40000 ALTER TABLE `diagnostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEmpresa`),
  UNIQUE KEY `idEmpresa_UNIQUE` (`idEmpresa`),
  UNIQUE KEY `empresa_correo_index` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (3,'SEGUROS LATINA','seguros_LA@outlook.com','Alamos'),(4,'INDEG','indeg_contact@indeg.com','Urdesa central'),(5,'UNILEVER','unilever@gmail.com','Puntilla'),(6,'NO APLICA',NULL,NULL);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_clientes`
--

DROP TABLE IF EXISTS `historial_clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_clientes` (
  `idhistorial` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idhistorial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_clientes`
--

LOCK TABLES `historial_clientes` WRITE;
/*!40000 ALTER TABLE `historial_clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_proveedores`
--

DROP TABLE IF EXISTS `historial_proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_proveedores` (
  `idhistorial_p` int(11) NOT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idhistorial_p`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_proveedores`
--

LOCK TABLES `historial_proveedores` WRITE;
/*!40000 ALTER TABLE `historial_proveedores` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial_proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lentes`
--

DROP TABLE IF EXISTS `lentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lentes` (
  `idLente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `precio` float DEFAULT NULL,
  `Par_Lunas_idLunas` int(10) NOT NULL,
  `Armazon_idArmazon` int(10) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `cantidad` int(10) DEFAULT NULL,
  PRIMARY KEY (`idLente`),
  KEY `fk_Lente_Armazon1_idx` (`Armazon_idArmazon`),
  KEY `fk_Lente_Par_Lunas1_idx` (`Par_Lunas_idLunas`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lentes`
--

LOCK TABLES `lentes` WRITE;
/*!40000 ALTER TABLE `lentes` DISABLE KEYS */;
INSERT INTO `lentes` VALUES (1,90,8,10,'Bajo Precio',3),(2,100,8,11,'De calidad',5),(3,68,8,6,'Resistentes',2);
/*!40000 ALTER TABLE `lentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `lentes_par_lunas_armazon`
--

DROP TABLE IF EXISTS `lentes_par_lunas_armazon`;
/*!50001 DROP VIEW IF EXISTS `lentes_par_lunas_armazon`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `lentes_par_lunas_armazon` AS SELECT 
 1 AS `idLente`,
 1 AS `Precio_Lentes`,
 1 AS `Descripcion_Lentes`,
 1 AS `Precio_Lunas`,
 1 AS `Tipo_Lunas`,
 1 AS `Descripcion_Armazon`,
 1 AS `Marca_Armazon`,
 1 AS `Precio_Armazon`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `optometra`
--

DROP TABLE IF EXISTS `optometra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `optometra` (
  `idOptometra` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `sueldo` float DEFAULT NULL,
  PRIMARY KEY (`idOptometra`),
  UNIQUE KEY `idOptometra_UNIQUE` (`idOptometra`),
  UNIQUE KEY `optometra_correo_index` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=213 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `optometra`
--

LOCK TABLES `optometra` WRITE;
/*!40000 ALTER TABLE `optometra` DISABLE KEYS */;
INSERT INTO `optometra` VALUES (205,'Allison Azul','Aguayo Alvarez','alixi99@outlook.com',2745689,'la Joya Platino',600),(206,'Hernan Rodrigo','Diaz Lopez','hernan1980@gmail.com',2453703,'Mapasingue',570),(207,'Carlos Eduardo','Moreira Sanchez','sanchez@hotmail.com',2345678,'Alborada',520);
/*!40000 ALTER TABLE `optometra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `cedula` varchar(10) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `Diagnostico_idDiagnostico` int(11) DEFAULT NULL,
  `Empresa_idEmpresa` int(11) DEFAULT NULL,
  PRIMARY KEY (`cedula`),
  UNIQUE KEY `idPaciente_UNIQUE` (`cedula`),
  UNIQUE KEY `paciente_correo_index` (`mail`),
  KEY `fk_Paciente_Diagnostico1_idx` (`Diagnostico_idDiagnostico`),
  KEY `fk_Paciente_Empresa1_idx` (`Empresa_idEmpresa`),
  CONSTRAINT `fk_Paciente_Diagnostico1` FOREIGN KEY (`Diagnostico_idDiagnostico`) REFERENCES `diagnostico` (`idDiagnostico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paciente_Empresa1` FOREIGN KEY (`Empresa_idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES ('0954297567','Damian Rodrigo','Diaz Jacome','Orquideas','dam12@gmail.com','2456789',40,3),('0987564329','Carlos Estevan','Martinez Salazar','Alborada','caras2@gmail.com','2345678',42,4),('0987645321','Sebastian Matias','Salazar Paez','Guasmo','rerec@gmail.com','6789532',41,3);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `paciente_optometra_diagnostico`
--

DROP TABLE IF EXISTS `paciente_optometra_diagnostico`;
/*!50001 DROP VIEW IF EXISTS `paciente_optometra_diagnostico`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `paciente_optometra_diagnostico` AS SELECT 
 1 AS `Cedula_Paciente`,
 1 AS `Nombre_Paciente`,
 1 AS `Apellido_Paciente`,
 1 AS `Descripcion_Diagnostico`,
 1 AS `Recomendacion_Diagnostico`,
 1 AS `ID_Optometra`,
 1 AS `Nombre_Optometra`,
 1 AS `Apellido_Optometra`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `par_lunas`
--

DROP TABLE IF EXISTS `par_lunas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `par_lunas` (
  `idLunas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `precio` float DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `Proveedor_idProveedor` int(10) unsigned NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLunas`),
  KEY `fk_Par_Lunas_Proveedor1_idx` (`Proveedor_idProveedor`),
  CONSTRAINT `fk_Par_Lunas_Proveedor1` FOREIGN KEY (`Proveedor_idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par_lunas`
--

LOCK TABLES `par_lunas` WRITE;
/*!40000 ALTER TABLE `par_lunas` DISABLE KEYS */;
INSERT INTO `par_lunas` VALUES (8,50,'Medida Alta',1,2,'MONOFOCALES'),(9,45,'Medida Baja',305,5,'BIFOCALES');
/*!40000 ALTER TABLE `par_lunas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idProveedor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `comision` float DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProveedor`),
  UNIQUE KEY `proveedor_correo_index` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=306 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Karen Elizabeth','karenpe@gmail.com','2453709',40,'Izurieta Andrade','Orquideas'),(304,'Leonidas Manuel','leonida123@gmail.com','2456789',50,'Amorebieta Carrillo','Sauces 5'),(305,'Carlos Estevan ','cafg@hotmail.com','6789332',80,'Moreira Castro','Samborondon');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendedor` (
  `idVendedor` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `sueldo` float DEFAULT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`idVendedor`),
  UNIQUE KEY `vendedor_correo_index` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (2,'Fabian Andres','Garcia Jaramillo','fab1213@gmail.com','Orquideas',520,'2453789'),(3,'Carlos Marcos','Garcia Toala','1car@gmail.com','Alborada',520,'2453989'),(4,'Steven Eduardo','Martinez Garcia','stve3@gmail.com','Orquideas',600,'2458709'),(5,'Roberto Enrique','Jara Aspiazu','robwe@gmail.com','Urdesa',600,'2455678'),(6,'XavierFabian','Garcia Lopez','xafab23@gmail.com','Guasmo',600,'2453709'),(500,'Javier Hernan','Rodriguez Altamirano','gab123@gmail.com','Orquideas',400,'2456789');
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'optica'
--
/*!50003 DROP PROCEDURE IF EXISTS `descripcion_lentes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `descripcion_lentes`(in id int)
BEGIN
select l.idLente,l.descripcion,l.cantidad,l.precio,a.marca,pl.tipo,a.descripcion as descripcion_armazon,l.descripcion as descripcion_lunas  from par_lunas pl, armazon a, lentes l 
where l.idLente=id and l.Par_Lunas_idLunas=pl.idLunas and l.Armazon_idArmazon=a.idArmazon;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cliente`(in id varchar(45))
BEGIN
delete from compra where Paciente_cedula=id;
delete from paciente where cedula=id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `eliminar_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_proveedor`(in id int(10))
BEGIN
delete from par_lunas where par_lunas.Proveedor_idProveedor=id;
delete from proveedor where idProveedor=id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_armazones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_armazones`()
BEGIN
Select idArmazon,marca,precio from armazon;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_brigadas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_brigadas`(in f date)
BEGIN
select fecha,hora_inicio,hora_fin,numero_pacientes,lugar from brigadas where fecha=f;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_clientes`(in nombre_empresa varchar(45))
BEGIN
   SELECT * FROM paciente p, empresa e 
   WHERE p.Empresa_idEmpresa=e.idEmpresa AND e.nombre=nombre_empresa;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_empresas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_empresas`()
BEGIN
   SELECT * FROM empresa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_lentes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_lentes`()
BEGIN
select l.idLente,pl.tipo,a.marca from lentes l,armazon a,par_lunas pl where a.idArmazon=l.Armazon_idArmazon and l.Par_Lunas_idLunas=pl.idLunas;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_lunas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_lunas`()
BEGIN
Select idLunas,descripcion,tipo from par_lunas;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_optometras` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_optometras`()
BEGIN
select idOptometra,nombre,apellido from optometra;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_proveedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_proveedores`()
BEGIN
Select * from proveedor;
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_total_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_total_clientes`()
BEGIN
select nombre,apellido,cedula from paciente;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `obtener_vendedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `obtener_vendedores`()
BEGIN
select idVendedor,nombre,apellido from vendedor;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrar_armazones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_armazones`(in descripcion varchar(45), in marca varchar(45),in precio float,
in cantidad int,in idArmazon int, in idP int )
BEGIN
   insert into armazon(descripcion,marca,precio,cantidad,idArmazon,Proveedor_idProveedor)
   values(descripcion,marca,precio,cantidad,idArmazon,idP);
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrar_brigadas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_brigadas`(in idB int,in fecha date,in hi varchar(10),in hf varchar(10),in p int,in l varchar(45),
in idV int,in idO int)
BEGIN
insert into brigadas(idBrigadas,fecha,hora_inicio,hora_fin,numero_pacientes,lugar,Vendedor_idVendedor,Optometra_idOptometra) 
values(idB,fecha,hi,hf,p,l,idV,idO);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrar_clientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_clientes`(in nombres varchar(45), in apellidos varchar(45),in direccion varchar(45),
in x varchar(10),in telefono int (10), in id int(11),in mail varchar(45))
BEGIN
   SET SQL_SAFE_UPDATES = 0;
   delete from paciente where cedula=x;
   insert into paciente(nombre,apellido,direccion,cedula,telefono,Empresa_idEmpresa,mail)
   values(nombres,apellidos,direccion,x,telefono,id,mail);
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrar_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_empleado`(in id int,in nombre varchar(45),in apellido varchar (45),in mail varchar(45),in telefono varchar(45),in direccion varchar(45),
in tipo varchar(45),in sueldo float)
BEGIN
declare c varchar(45);
set c=tipo;
if (c="optometra")
then
insert into optometra(idOptometra,nombre,apellido,mail,telefono,direccion,sueldo) 
values(id,nombre,apellido,mail,telefono,direccion,sueldo);
end if;
if (c="vendedor")
then
insert into vendedor(idVendedor,nombre,apellido,mail,telefono,direccion,sueldo)
values(id,nombre,apellido,mail,telefono,direccion,sueldo);
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrar_lentes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_lentes`(in id int , in precio float,in idLunas int,
in idArmazon int,in descripcion varchar(45), in cantidad int )
BEGIN
   insert into lentes(idLente,precio,Par_Lunas_idLunas,Armazon_idArmazon,descripcion,cantidad)
   values(id,precio,idLunas,idArmazon,descripcion,cantidad);
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrar_lunas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_lunas`(in id int , in precio float,in tipo varchar(45),
in idP int,in descripcion varchar(45), in cantidad int )
BEGIN
   insert into par_lunas(idLunas,precio,tipo,cantidad,descripcion,Proveedor_idProveedor)
   values(id,precio,tipo,cantidad,descripcion,idP);
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrar_pacientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_pacientes`(in nombres varchar(45), in apellidos varchar(45),in direccion varchar(45),
in x varchar(10),in telefono int (10), in id int(11),in mail varchar(45))
BEGIN
   SET SQL_SAFE_UPDATES = 0;
   delete from paciente where cedula=x;
   insert into paciente(nombre,apellido,direccion,cedula,telefono,Empresa_idEmpresa,mail)
   values(nombres,apellidos,direccion,x,telefono,id,mail);
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrar_proveedores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_proveedores`(in id int , in nombres varchar(45),in apellidos varchar(45),in telefono varchar(45), in mail varchar(45),in comision float,in direccion varchar(45))
BEGIN
   SET SQL_SAFE_UPDATES = 0;
   delete from proveedor where idProveedor=id;
   insert into proveedor(idProveedor,nombre,apellidos,mail,telefono,comision,direccion)
   values(id,nombres,apellidos,mail,telefono,comision,direccion);
    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `registrar_ventas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrar_ventas`(in id int,in f date,in idL int,in t float,in d varchar(45),in idV int,in idP varchar(45))
BEGIN
insert into compra(idCompra,fecha,Lentes_idLente,total,descripcion,Vendedor_idVendedor,Paciente_cedula)
values(id,f,idL,t,d,idV,idP);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `brigada_optometra_vendedor`
--

/*!50001 DROP VIEW IF EXISTS `brigada_optometra_vendedor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `brigada_optometra_vendedor` AS select `br`.`fecha` AS `Fecha_Brigada`,`br`.`hora_inicio` AS `Hora_Inicio_Brigada`,`br`.`hora_fin` AS `Hora_Fin_Brigada`,`br`.`lugar` AS `Lugar_Brigada`,`o`.`nombre` AS `Nombre_Optometra`,`o`.`apellido` AS `Apellido_Optometra`,`v`.`nombre` AS `Nombre_Vendedor`,`v`.`apellido` AS `Apellido_Vendedor` from ((`brigadas` `br` join `optometra` `o`) join `vendedor` `v`) where ((`br`.`Optometra_idOptometra` = `o`.`idOptometra`) and (`br`.`Vendedor_idVendedor` = `v`.`idVendedor`)) group by `br`.`idBrigadas` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `compra_paciente_lentes`
--

/*!50001 DROP VIEW IF EXISTS `compra_paciente_lentes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `compra_paciente_lentes` AS select `c`.`descripcion` AS `Descripcion_Compra`,`c`.`total` AS `Total_Compra`,`p`.`cedula` AS `Cedula_Paciente`,`p`.`nombre` AS `Nombre_Paciente`,`p`.`apellido` AS `Apellido_Paciente`,`l`.`descripcion` AS `descripcion`,`l`.`precio` AS `precio` from ((`compra` `c` join `paciente` `p`) join `lentes` `l`) where ((`c`.`Lentes_idLente` = `l`.`idLente`) and (`c`.`Paciente_cedula` = `p`.`cedula`)) group by `c`.`idCompra` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `lentes_par_lunas_armazon`
--

/*!50001 DROP VIEW IF EXISTS `lentes_par_lunas_armazon`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `lentes_par_lunas_armazon` AS select `l`.`idLente` AS `idLente`,`l`.`precio` AS `Precio_Lentes`,`l`.`descripcion` AS `Descripcion_Lentes`,`pl`.`precio` AS `Precio_Lunas`,`pl`.`tipo` AS `Tipo_Lunas`,`a`.`descripcion` AS `Descripcion_Armazon`,`a`.`marca` AS `Marca_Armazon`,`a`.`precio` AS `Precio_Armazon` from ((`lentes` `l` join `par_lunas` `pl`) join `armazon` `a`) where ((`l`.`Armazon_idArmazon` = `a`.`idArmazon`) and (`l`.`Par_Lunas_idLunas` = `pl`.`idLunas`)) group by `l`.`idLente` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `paciente_optometra_diagnostico`
--

/*!50001 DROP VIEW IF EXISTS `paciente_optometra_diagnostico`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `paciente_optometra_diagnostico` AS select `p`.`cedula` AS `Cedula_Paciente`,`p`.`nombre` AS `Nombre_Paciente`,`p`.`apellido` AS `Apellido_Paciente`,`d`.`descripcion` AS `Descripcion_Diagnostico`,`d`.`recomendacion` AS `Recomendacion_Diagnostico`,`o`.`idOptometra` AS `ID_Optometra`,`o`.`nombre` AS `Nombre_Optometra`,`o`.`apellido` AS `Apellido_Optometra` from ((`paciente` `p` join `diagnostico` `d`) join `optometra` `o`) where ((`p`.`Diagnostico_idDiagnostico` = `d`.`idDiagnostico`) and (`d`.`Optometra_idOptometra` = `o`.`idOptometra`)) group by `p`.`cedula` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-31 23:45:24
