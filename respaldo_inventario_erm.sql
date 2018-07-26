-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: inventario_erm
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `almacen` (
  `Cod_Almacen` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_Almacen` varchar(30) DEFAULT NULL,
  `Descripcion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`Cod_Almacen`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
INSERT INTO `almacen` VALUES (1,'Almacen ERM','Ubicado en oficina central.'),(2,'Camioneta Ing.','Vehículo para ventas foráneas.'),(3,'Camioneta Celina','Vehículo para ventas foráneas.');
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `Id_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `Razon_Social` varchar(80) DEFAULT NULL,
  `No_Estacion` varchar(10) DEFAULT NULL,
  `Contacto` varchar(20) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `Correo` varchar(50) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id_Cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'ESTACION DE SERVICIOS RAJM ','M3957','Damian','5510951195','damian@rajm.com.mx','Blvd. Ojo de Agua'),(2,'ESTACION DE SERVICIOS DON GU ','A2519','Lucero','5535303621','lucy@dongu.com.mx','San Pedro Atzompa'),(3,'SERVICIO EXPRESS DEL BAJIO ','A2580','Anastasia','5559666547','pau@bajio.com.mx','Frac. Real del Cid');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_venta` (
  `Cod_Detalle` int(11) NOT NULL AUTO_INCREMENT,
  `Cantidad_Detalle` bigint(10) DEFAULT NULL,
  `Cod_ProductoFK` varchar(15) DEFAULT NULL,
  `Precio_Venta` bigint(15) DEFAULT NULL,
  `Id_VentaFK` int(11) DEFAULT NULL,
  `Factura` varchar(10) DEFAULT NULL,
  `Tipo_Pago` varchar(30) DEFAULT NULL,
  `Tipo_Cambio` float DEFAULT NULL,
  `Subtotal` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`Cod_Detalle`),
  KEY `Cod_ProductoFK` (`Cod_ProductoFK`),
  KEY `Id_VentaFK` (`Id_VentaFK`),
  CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`Cod_ProductoFK`) REFERENCES `producto` (`Cod_Producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`Id_VentaFK`) REFERENCES `venta` (`Id_Venta`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (1,1,'CNC-SM462B ',800,1,'0','Contado',0,800),(2,1,'CED-RM370 ',280,3,'0','Contado',0,9223372036854775807),(3,1,'RFB-114720G ',400,4,'0','Contado',20,20),(4,1,'CAL-SM71 ',100,4,'0','Contado',20,5),(5,3,'CED-RM370 ',280,5,'0','Contado',19.8,42);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_stock`
--

DROP TABLE IF EXISTS `historial_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial_stock` (
  `Cod_Historial` int(11) NOT NULL AUTO_INCREMENT,
  `Cod_ProductoFK` varchar(15) DEFAULT NULL,
  `Id_UsuarioFK` int(11) DEFAULT NULL,
  `Descripcion` varchar(80) DEFAULT NULL,
  `Referencia` varchar(80) DEFAULT NULL,
  `Cantidad_Nva` int(5) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  PRIMARY KEY (`Cod_Historial`),
  KEY `Cod_ProductoFK` (`Cod_ProductoFK`),
  KEY `Id_UsuarioFK` (`Id_UsuarioFK`),
  CONSTRAINT `historial_stock_ibfk_1` FOREIGN KEY (`Cod_ProductoFK`) REFERENCES `producto` (`Cod_Producto`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `historial_stock_ibfk_2` FOREIGN KEY (`Id_UsuarioFK`) REFERENCES `usuario` (`Id_Usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_stock`
--

LOCK TABLES `historial_stock` WRITE;
/*!40000 ALTER TABLE `historial_stock` DISABLE KEYS */;
INSERT INTO `historial_stock` VALUES (1,'ARN-SM369 ',1,'Agrego producto al stock.','Compra',2,'2018-05-11'),(2,'BAR-RM177 ',1,'Agrego producto al stock.',NULL,2,'2018-05-14'),(3,'BAR-RM177 ',1,'Resto producto al stock.','Venta no registrada',5,'2018-05-14'),(4,'ARN-SM369 ',1,'Agrego producto al stock.','Factura N320',5,'2018-05-14'),(5,'ARN-SM369 ',1,'Resto producto al stock.','Error de factura',1,'2018-05-14'),(7,'BOT-SM241 ',1,'Agrego producto al stock.','',5,'2018-05-21'),(8,'ARN-SM369 ',1,'Agrego producto al stock.','',2,'2018-05-21'),(9,'BAR-RM177 ',1,'Agrego producto al stock.','Nueva Compra',10,'2018-05-22'),(10,'CAL-SM317',1,'Agrego producto al stock.','',15,'2018-06-01'),(11,'BOT-SM241/1',1,'Agrego producto al stock.','',10,'2018-06-01'),(12,'BOT-SM241 ',1,'Agrego producto al stock.','',19,'2018-06-01'),(13,'BAR-RM177 ',1,'Agrego producto al stock.','',12,'2018-06-01'),(14,'ARN-SM369 ',1,'Agrego producto al stock.','',23,'2018-06-01');
/*!40000 ALTER TABLE `historial_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `Cod_Producto` varchar(15) NOT NULL,
  `Proveedor` varchar(80) DEFAULT NULL,
  `Nombre_Producto` varchar(40) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Precio_Venta` bigint(15) DEFAULT NULL,
  `Precio_Compra` bigint(15) DEFAULT NULL,
  `Existencia` int(5) DEFAULT NULL,
  `Cod_AlmacenFK` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`Cod_Producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('ARN-SM369 ','INVENTARIO ERM','M00515A003 ','ARNES P/TECLADO MAESTRO ',350,200,24,'1'),('BAR-RM177 ','INVENTARIO ERM','331898-001 ','BARRIER PARA TLS 350 ',400,210,16,'1'),('BOT-SM241 ','INVENTARIO','BN-75-100 ','BOTA FLEXIBLE DE 3/4\" O 1\" ',120,60,20,'1'),('BOT-SM241/1','SEM','BN-75-100','BOTA FLEXIBLE DE 3/4\" O 1\"',120,75,10,'2'),('BOT-SM241BA ','INVENTARIO','BN-300 ','BOTA FLEXIBLE DE 3\" (PENETRACION RUBERSTONNE) ',8265,4950,5,'1'),('BOT-SM241BN ','INVENTARIO','BN-200','BOTA FLEXIBLE DE 2\" (NACIONAL) ',82358,60000,8,'3'),('CAL-SM317','TAMTO','TN-7','CALIBRADOR PERSONAL',450,360,15,'3'),('CAL-SM318C ','TAMTO','TN-6C ','CALIBRADOR LARGO 30CM (150psi) cuello CORTO ',65,1285,20,'3'),('CAL-SM71 ','CASTILLO','102049 ','LEXAN PARA PRESET TEAM GASOLINA ',100,45,49,'1'),('CED-RM370 ','RNB','1801DRE ','CEDAZO PARA DISPENSARIO WAYNE  ',280,140,6,'1'),('CNC-SM462B ','ARTE','MS-XP-200-200 ','CONECTOR DE 2\" ESPIGA X 2\" MACHO C/DEST. ',800,350,3,'2'),('COD-SM279 ','INVENTARIO','80TT ','CODO HERMETICO P/DESCARGA 3\"CIVACON REC VAP ',2800,1200,1,'2'),('RFB-114720G ','INVENTARIO','GL73054 ','PISTOLERA BENNETT MCA GLOBAL (INCLUYE 2 RUEDAS, 1 RESORTE, 1 IMAN, 3 PERNOS) ',400,180,4,'2'),('SEN-SM266 ','C-ING','LS-3AB ','SENSOR UNIVERSAL DE LIQUIDOS PARA USARSE EN CONTENEDOR Y/O ESPACIO ANULAR GEMS ',850,590,2,'1');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `Id_Proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `Razon_Social` varchar(80) DEFAULT NULL,
  `Contacto` varchar(20) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `Correo` varchar(50) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id_Proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'INVENTARIO ERM','Adriana','5510951196','adri@ermdemexico.com.mz','Calz. De La Hacienda'),(2,'SEM','Carmen','5576991245','maricar@serviciosem.com.mx','Tlahuac'),(3,'PETROEMPAQUES','Carmen Morales','5547892036','g.lupe@petro.com.mx','Azcapotzalco');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_almacen`
--

DROP TABLE IF EXISTS `stock_almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stock_almacen` (
  `Cod_Producto` varchar(15) NOT NULL,
  `Nombre_Producto` varchar(40) DEFAULT NULL,
  `Descripcion` varchar(100) DEFAULT NULL,
  `Precio_Venta` bigint(15) DEFAULT NULL,
  `Precio_Compra` bigint(15) DEFAULT NULL,
  `Existencia` int(5) DEFAULT NULL,
  PRIMARY KEY (`Cod_Producto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_almacen`
--

LOCK TABLES `stock_almacen` WRITE;
/*!40000 ALTER TABLE `stock_almacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `Id_Usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) DEFAULT NULL,
  `Usuario` varchar(15) DEFAULT NULL,
  `Contrasenia` varchar(10) DEFAULT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `Estado` varchar(20) DEFAULT NULL,
  `Tipo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Fernando','Fer','123','5535852596','Activo','Administrador'),(2,'Abril','Abril','123','5510951195','Activo','Vendedor');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `Id_Venta` int(11) NOT NULL AUTO_INCREMENT,
  `Id_UsuarioFK` int(11) DEFAULT NULL,
  `Id_ClienteFK` int(11) DEFAULT NULL,
  `Fecha_Venta` date DEFAULT NULL,
  `Tipo_Comprobante` varchar(15) DEFAULT NULL,
  `Factura` varchar(10) DEFAULT NULL,
  `Tipo_Pago` varchar(30) DEFAULT NULL,
  `Tipo_Cambio` float DEFAULT NULL,
  `Total_Venta` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`Id_Venta`),
  KEY `Id_UsuarioFK` (`Id_UsuarioFK`),
  KEY `Id_ClienteFK` (`Id_ClienteFK`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`Id_UsuarioFK`) REFERENCES `usuario` (`Id_Usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`Id_ClienteFK`) REFERENCES `cliente` (`Id_Cliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,1,1,'2018-07-23','Reporte','0','Contado',0,800),(2,1,3,'2018-07-23','Reporte','0','Contado',0,0),(3,1,2,'2018-07-25','Reporte','0','Contado',0,9223372036854775807),(4,1,2,'2018-07-25','Reporte','0','Contado',20,25),(5,1,1,'2018-07-26','Reporte','0','Contado',19.8,42);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'inventario_erm'
--
/*!50003 DROP PROCEDURE IF EXISTS `getUtilidad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUtilidad`(idVentaIN int)
BEGIN 
DECLARE pVenta float;
DECLARE pCompra float;
DECLARE utilidad float;

set pVenta = (select sum(Producto.Precio_Venta) from producto 
inner join detalle_Venta 
on detalle_Venta.Cod_ProductoFK = Producto.Cod_Producto
inner join venta 
on venta.Id_Venta = detalle_venta.Id_VentaFK
where venta.Id_Venta = idVentaIN);

set pCompra = (select sum(Precio_Compra) from producto 
inner join detalle_Venta 
on detalle_Venta.Cod_ProductoFK = Producto.Cod_Producto
inner join venta 
on venta.Id_Venta = detalle_venta.Id_VentaFK
where venta.Id_Venta = idVentaIN);

set utilidad = (pVenta - pCompra);

select(utilidad);

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

-- Dump completed on 2018-07-26  1:10:09
