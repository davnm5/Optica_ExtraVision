CREATE DATABASE  IF NOT EXISTS `optica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `optica`;
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
  `idArmazon` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` varchar(45) DEFAULT NULL,
  `Proveedor_idProveedor` int(10) unsigned NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `Armazoncol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idArmazon`),
  KEY `fk_Armazon_Proveedor1_idx` (`Proveedor_idProveedor`),
  CONSTRAINT `fk_Armazon_Proveedor1` FOREIGN KEY (`Proveedor_idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armazon`
--

LOCK TABLES `armazon` WRITE;
/*!40000 ALTER TABLE `armazon` DISABLE KEYS */;
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
  `Paciente_idPaciente` int(11) NOT NULL,
  `Optometra_idOptometra` int(11) NOT NULL,
  PRIMARY KEY (`idAtencion`),
  UNIQUE KEY `idAtencion_UNIQUE` (`idAtencion`),
  KEY `fk_Atencion_Paciente1_idx` (`Paciente_idPaciente`),
  KEY `fk_Atencion_Optometra1_idx` (`Optometra_idOptometra`),
  CONSTRAINT `fk_Atencion_Optometra1` FOREIGN KEY (`Optometra_idOptometra`) REFERENCES `optometra` (`idOptometra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Atencion_Paciente1` FOREIGN KEY (`Paciente_idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
-- Table structure for table `brigadas`
--

DROP TABLE IF EXISTS `brigadas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brigadas` (
  `idBrigadas` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `hora_inicio` datetime DEFAULT NULL,
  `hora_fin` datetime DEFAULT NULL,
  `numero_pacientes` int(11) DEFAULT NULL,
  `lugar` varchar(45) DEFAULT NULL,
  `Vendedor_idVendedor` int(10) unsigned NOT NULL,
  `Optometra_idOptometra` int(11) NOT NULL,
  PRIMARY KEY (`idBrigadas`),
  UNIQUE KEY `idBrigadas_UNIQUE` (`idBrigadas`),
  KEY `fk_Brigadas_Vendedor1_idx` (`Vendedor_idVendedor`),
  KEY `fk_Brigadas_Optometra1_idx` (`Optometra_idOptometra`),
  CONSTRAINT `fk_Brigadas_Optometra1` FOREIGN KEY (`Optometra_idOptometra`) REFERENCES `optometra` (`idOptometra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Brigadas_Vendedor1` FOREIGN KEY (`Vendedor_idVendedor`) REFERENCES `vendedor` (`idVendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brigadas`
--

LOCK TABLES `brigadas` WRITE;
/*!40000 ALTER TABLE `brigadas` DISABLE KEYS */;
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
  `Paciente_idPaciente` int(11) NOT NULL,
  `Vendedor_idVendedor` int(10) unsigned NOT NULL,
  `Lente_idLente` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `fk_Compra_Paciente1_idx` (`Paciente_idPaciente`),
  KEY `fk_Compra_Vendedor1_idx` (`Vendedor_idVendedor`),
  KEY `fk_Compra_Lente1_idx` (`Lente_idLente`),
  CONSTRAINT `fk_Compra_Lente1` FOREIGN KEY (`Lente_idLente`) REFERENCES `lente` (`idLente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_Paciente1` FOREIGN KEY (`Paciente_idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_Vendedor1` FOREIGN KEY (`Vendedor_idVendedor`) REFERENCES `vendedor` (`idVendedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=407 DEFAULT CHARSET=utf8;
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
  UNIQUE KEY `idEmpresa_UNIQUE` (`idEmpresa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (3,'Seguros Latina','seguros_LA@outlook.com','Alamos'),(4,'INDEG','indeg_contact@indeg.com','Urdesa central'),(5,'UNILEVER','unilever@gmail.com','Puntilla');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lente`
--

DROP TABLE IF EXISTS `lente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lente` (
  `idLente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `precio` float DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `Armazon_idArmazon` int(10) unsigned NOT NULL,
  `Par_Lunas_idLunas` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idLente`),
  KEY `fk_Lente_Armazon1_idx` (`Armazon_idArmazon`),
  KEY `fk_Lente_Par_Lunas1_idx` (`Par_Lunas_idLunas`),
  CONSTRAINT `fk_Lente_Armazon1` FOREIGN KEY (`Armazon_idArmazon`) REFERENCES `armazon` (`idArmazon`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Lente_Par_Lunas1` FOREIGN KEY (`Par_Lunas_idLunas`) REFERENCES `par_lunas` (`idLunas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lente`
--

LOCK TABLES `lente` WRITE;
/*!40000 ALTER TABLE `lente` DISABLE KEYS */;
/*!40000 ALTER TABLE `lente` ENABLE KEYS */;
UNLOCK TABLES;

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
  UNIQUE KEY `idOptometra_UNIQUE` (`idOptometra`)
) ENGINE=InnoDB AUTO_INCREMENT=407 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `optometra`
--

LOCK TABLES `optometra` WRITE;
/*!40000 ALTER TABLE `optometra` DISABLE KEYS */;
INSERT INTO `optometra` VALUES (205,'Allison Azul','Aguayo Alvarez','alixi99@outlook.com',2745689,'la Joya Platino',600),(206,'Hernan Rodrigo','Diaz Lopez','hernan1980@gmail.com',2453703,'Mapasingue',570);
/*!40000 ALTER TABLE `optometra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `telefono` int(10) DEFAULT NULL,
  `Diagnostico_idDiagnostico` int(11) NOT NULL,
  `Empresa_idEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`idPaciente`),
  UNIQUE KEY `idPaciente_UNIQUE` (`idPaciente`),
  KEY `fk_Paciente_Diagnostico1_idx` (`Diagnostico_idDiagnostico`),
  KEY `fk_Paciente_Empresa1_idx` (`Empresa_idEmpresa`),
  CONSTRAINT `fk_Paciente_Diagnostico1` FOREIGN KEY (`Diagnostico_idDiagnostico`) REFERENCES `diagnostico` (`idDiagnostico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Paciente_Empresa1` FOREIGN KEY (`Empresa_idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (123,'javier leonidas','vera pincay','la joya Quarzo','davnm5@outlook.com',979431880,40,4),(124,'daniel andres','neira martrus','la joya Quarzo','daniel1996@outlook.com',989485736,41,3),(125,'jose estevan','garcia Rodriguez','Orquideas','josdrg@espol.edu.ec',98765348,42,5);
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `par_lunas`
--

DROP TABLE IF EXISTS `par_lunas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `par_lunas` (
  `idLunas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `precio` float DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `Proveedor_idProveedor` int(10) unsigned NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `Par_Lunascol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLunas`),
  KEY `fk_Par_Lunas_Proveedor1_idx` (`Proveedor_idProveedor`),
  CONSTRAINT `fk_Par_Lunas_Proveedor1` FOREIGN KEY (`Proveedor_idProveedor`) REFERENCES `proveedor` (`idProveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `par_lunas`
--

LOCK TABLES `par_lunas` WRITE;
/*!40000 ALTER TABLE `par_lunas` DISABLE KEYS */;
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
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=303 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (300,'Karen Izurieta','karen245@gmail.com','451987',300),(301,'Bolivar Garcia','bolivar56@outlook.com','456809',550),(302,'Carlos Peña','carlospe@gmail.com','425738',400);
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
  `telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVendedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'optica'
--
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
   SELECT  p.nombre, p.apellido, p.telefono,p.direccion FROM paciente p, empresa e 
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
   SELECT  nombre,direccion,mail FROM empresa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-23 21:57:44
