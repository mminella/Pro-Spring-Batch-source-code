-- MySQL dump 10.13  Distrib 5.1.39, for apple-darwin9.5.0 (i386)
--
-- Host: localhost    Database: statement
-- ------------------------------------------------------
-- Server version	5.1.39

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
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `ssn` varchar(9) NOT NULL,
  `address1` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(2) NOT NULL,
  `zip` varchar(9) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
INSERT INTO `Customer` VALUES (3,'Joshua','Thompson','205866465','3708 Park','Fairview','LA','58517'),(4,'Daniel','Williams','212391657','9564 Sixth','Springfield','VA','93928'),(5,'Emma','Smith','551747157','1242 Seventh','Franklin','MN','5748'),(6,'Anthony','Brown','311728240','8316 Fifth','Salen','GA','21402'),(7,'Alexander','Miller','540175442','8972 Main','Clinton','CT','10486'),(8,'Sophia','White','522959465','577 Fifth','Fairview','MI','65775'),(9,'Anthony','Thomas','722323173','8973 Fifth','Springfield','KS','83642'),(10,'Joshua','Thompson','655434602','3131 Fourth','Madison','CO','83665'),(11,'Ava','Brown','717041257','5276 Seventh','Madison','OK','8461'),(12,'Anthony','Miller','285991898','1306 Third','Franklin','TX','15220'),(13,'Ava','Miller','303797818','72 Oak','Fairview','UT','16736'),(14,'Daniel','Williams','681877727','8964 Pine','Fairview','ND','61757'),(15,'Chloe','Williams','472454460','8535 Third','Springfield','CO','15299'),(16,'Ava','Anderson','550482082','7733 Oak','Madison','IA','96916'),(17,'Jacob','Brown','110739334','7845 Fourth','Salen','ND','42963'),(18,'Michael','Wilson','446504999','5634 Pine','Greenville','WI','35165'),(19,'Madison','Miller','532436583','9965 Park','Salen','WA','6830'),(20,'Daniel','Williams','328865128','7989 Second','Salen','RI','16878'),(21,'Daniel','Jones','429330418','2907 Second','Madison','KY','36104'),(22,'Sophia','Harris','926597358','1620 Fourth','Springfield','OR','89952'),(23,'Jayden','Wilson','241694516','7567 Third','Springfield','KY','20979'),(24,'Chloe','Smith','612803936','4720 Fourth','Greenville','UT','61014'),(25,'Emily','Wilson','421574905','3227 Park','Fairview','CO','3808'),(26,'Abigail','White','691618706','7024 Fourth','Franklin','NM','25660'),(27,'Emma','Thompson','365211644','6779 Park','Greenville','ND','80113'),(28,'Madison','Anderson','395688556','76 Pine','Springfield','CT','80968'),(29,'Ava','Brown','706944482','4507 Sixth','Springfield','MN','2131'),(30,'Sophia','Davis','280471547','5167 Park','Fairview','KS','71969'),(31,'Joshua','Thompson','881617968','9607 Sixth','Clinton','NY','45521'),(32,'Olivia','Jackson','063787111','4772 Oak','Fairview','OR','82549'),(33,'Alexander','Brown','214594594','1383 Fifth','Salen','UT','97939'),(34,'Michael','Anderson','385220933','6120 Main','Greenville','WY','62830'),(35,'William','Taylor','205967993','8365 Sixth','Salen','AR','61480'),(36,'William','Williams','299824258','3711 Oak','Springfield','ID','36459'),(37,'William','Williams','137982395','7543 Third','Franklin','CA','48193'),(38,'Joshua','Jackson','060143122','5699 Fourth','Springfield','RI','19234'),(39,'Daniel','Davis','759448110','2837 Seventh','Greenville','MT','37209'),(40,'Ethan','Thompson','691184385','3924 Sixth','Clinton','OR','82203'),(41,'Noah','Davis','520244929','3532 Fourth','Clinton','SD','72723'),(42,'Ava','Wilson','110591838','1138 Oak','Clinton','SD','74205'),(43,'Emily','Harris','101998229','6507 Sixth','Franklin','DC','59993'),(44,'Abigail','Taylor','484914570','8902 Fourth','Franklin','OR','98447'),(45,'Emma','Williams','416242854','2104 Second','Greenville','AZ','27980'),(46,'Abigail','Miller','619565461','3283 Pine','Clinton','TN','1575'),(47,'Daniel','Davis','559407674','5463 Pine','Fairview','IL','69788'),(48,'Emily','Moore','666364620','3472 Main','Salen','WY','49359'),(49,'Isabella','Smith','121041019','9891 Second','Clinton','ND','74158'),(50,'Anthony','Wilson','193425636','4437 Park','Fairview','FL','37300'),(51,'Emily','White','769019297','5975 Park','Greenville','NY','40755'),(52,'Alexander','Jones','955270107','6115 Oak','Fairview','ID','57303'),(53,'Jayden','Davis','106561544','4595 Fourth','Springfield','NH','66057'),(54,'Isabella','Davis','511098689','8175 Fifth','Madison','RI','30899'),(55,'Ethan','Miller','494387428','7324 Maple','Franklin','MA','5457'),(56,'Alexander','Smith','849129841','5284 Pine','Fairview','CO','85199'),(57,'Mia','Thomas','540530027','7163 Fourth','Salen','LA','42532'),(58,'Michael','Taylor','211041124','5544 Fifth','Madison','OR','76989'),(59,'Michael','Davis','569421543','1639 Second','Clinton','MN','47813'),(60,'Anthony','White','079812743','4763 Third','Greenville','KS','41998'),(61,'Mia','Thomas','171055973','2452 Park','Springfield','WA','55669'),(62,'Isabella','Anderson','055661422','2412 Pine','Springfield','NE','27308'),(63,'Anthony','White','138606881','9221 Oak','Fairview','RI','75634'),(64,'Michael','Williams','173290782','9572 Sixth','Greenville','SD','70965'),(65,'Alexander','Harris','591394095','3237 Main','Greenville','WA','66879'),(66,'Emma','Wilson','882389590','6323 Sixth','Franklin','MN','43233'),(67,'Ava','Anderson','946157125','9971 Pine','Clinton','WV','95997'),(68,'Emma','Anderson','421465109','5090 Park','Salen','NY','39691'),(69,'Alexander','Harris','380109442','403 Maple','Clinton','AL','24984'),(70,'Emma','White','744943241','492 Pine','Greenville','WI','67885'),(71,'Noah','White','416267006','5502 Fourth','Fairview','WI','13939'),(72,'Olivia','White','820131961','8411 Oak','Fairview','DC','90529'),(73,'Jayden','Davis','941674329','6641 Fourth','Salen','VT','51283'),(74,'Ava','Davis','921488995','4013 Fifth','Springfield','SC','83453'),(75,'Abigail','Miller','821236111','2107 Seventh','Fairview','OK','12827'),(76,'Sophia','Taylor','522910469','3216 Fourth','Salen','AK','28846'),(77,'Noah','Smith','095226059','4081 Sixth','Springfield','HI','50546'),(78,'Emma','Jones','310382247','9142 Maple','Clinton','NC','63954'),(79,'Sophia','Harris','853422321','6852 Second','Greenville','WA','24189'),(80,'Daniel','Wilson','122930928','9349 Fourth','Madison','MN','78911'),(81,'Emma','Smith','727778116','568 Third','Salen','IL','51964'),(82,'Madison','Jackson','019492171','2270 Second','Salen','MN','29669'),(83,'Emma','Jackson','655794081','5080 Fifth','Franklin','NM','80082'),(84,'Madison','Williams','988463328','7991 Pine','Franklin','OR','15030'),(85,'Jacob','Davis','762422791','8078 Pine','Greenville','UT','46501'),(86,'Olivia','Williams','690244307','9186 Third','Fairview','ME','75376'),(87,'Ethan','Thomas','312828282','5204 Park','Springfield','LA','9533'),(88,'Olivia','Anderson','809598460','2554 Second','Fairview','MS','39454'),(89,'Ethan','Davis','973117258','4442 Fourth','Greenville','LA','88524'),(90,'Noah','Williams','099792785','4559 Sixth','Salen','AZ','57892'),(91,'Anthony','Williams','653645852','5537 Seventh','Fairview','MT','54226'),(92,'Daniel','Thompson','427504544','118 Sixth','Greenville','AZ','26162'),(93,'Jacob','Anderson','736419149','6522 Third','Salen','OK','64771'),(94,'Sophia','Smith','415616506','1812 Main','Springfield','NH','40494'),(95,'William','Davis','303214034','908 Fifth','Fairview','ID','72060'),(96,'Chloe','White','569920047','5835 Maple','Fairview','IA','46482'),(97,'Noah','Taylor','421048459','4799 Third','Madison','NH','32455'),(98,'Olivia','Moore','408026853','1070 Oak','Fairview','ID','74340'),(99,'Alexander','Moore','918162459','5467 Park','Springfield','DE','47137'),(100,'Emily','Jackson','225536271','9669 Oak','Franklin','OH','80925'),(101,'Jacob','Davis','939807263','493 Fourth','Clinton','HI','54645'),(102,'Daniel','Davis','498142667','8769 Maple','Fairview','VA','1341');
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transaction`
--

DROP TABLE IF EXISTS `Transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transactionType` int(11) NOT NULL,
  `executedTime` datetime NOT NULL,
  `dollarAmount` decimal(15,2) NOT NULL,
  `qty` int(11) DEFAULT NULL,
  `tickerId` int(11) NOT NULL,
  `Account_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Transaction_Ticker` (`tickerId`),
  KEY `fk_Transaction_Account1` (`Account_id`),
  CONSTRAINT `fk_Transaction_Ticker` FOREIGN KEY (`tickerId`) REFERENCES `ticker` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Transaction_Account1` FOREIGN KEY (`Account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=24895 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accountNumber` varchar(16) NOT NULL,
  `cashBalance` decimal(15,2) NOT NULL,
  `tier` int(11) DEFAULT NULL,
  `Customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Account_Customer1` (`Customer_id`),
  CONSTRAINT `fk_Account_Customer1` FOREIGN KEY (`Customer_id`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'3276793917668488','5520.11',NULL,3),(2,'5171631657768328','8741.57',NULL,4),(3,'8854766441005292','7147.54',NULL,5),(4,'9391261778818192','9512.98',NULL,6),(5,'0361380493957038','6122.29',NULL,7),(6,'6461140860176083','2072.51',NULL,8),(7,'8822831877709336','1995.68',NULL,9),(8,'8533709618924418','3760.86',NULL,10),(9,'7214351097067542','2817.28',NULL,11),(10,'3352090531096083','2803.81',NULL,12),(11,'8965828319679017','5567.23',NULL,13),(12,'8766766621923854','9424.69',NULL,14),(13,'5168310825894175','421.78',NULL,15),(14,'9762834789564296','3834.82',NULL,16),(15,'2851274414003829','7908.77',NULL,17),(16,'0953135340089982','8039.40',NULL,18),(17,'0384755249328853','6470.70',NULL,19),(18,'3688727254433653','8235.27',NULL,20),(19,'1969415692861906','1764.27',NULL,21),(20,'5859820469602279','4115.54',NULL,22),(21,'1964887403809103','5284.89',NULL,23),(22,'1264275549989150','4077.84',NULL,24),(23,'8165856557728054','4534.53',NULL,25),(24,'9769779593958748','439.12',NULL,26),(25,'9523219675115703','8591.99',NULL,27),(26,'2292827215711433','1642.63',NULL,28),(27,'1474167076636969','2437.15',NULL,29),(28,'6221832713859052','7257.86',NULL,30),(29,'9976755662462823','8977.84',NULL,31),(30,'3892988152705261','3115.65',NULL,32),(31,'6403008061125617','8644.73',NULL,33),(32,'4794942708805889','3876.70',NULL,34),(33,'3788669390292532','3449.31',NULL,35),(34,'2409529407718043','5616.43',NULL,36),(35,'5761189379047087','7734.22',NULL,37),(36,'2807763018269641','1821.82',NULL,38),(37,'2537387545629377','5906.45',NULL,39),(38,'2962537133222488','4066.77',NULL,40),(39,'0427214916985122','2614.49',NULL,41),(40,'3911783018909803','872.16',NULL,42),(41,'3387453384976676','6517.32',NULL,43),(42,'3657727309801767','9970.13',NULL,44),(43,'4037217242147454','298.68',NULL,45),(44,'3250015280680940','1583.03',NULL,46),(45,'7245457915671866','7019.11',NULL,47),(46,'5091233763887242','346.43',NULL,48),(47,'3173481944100785','674.85',NULL,49),(48,'1939265444673138','2334.94',NULL,50),(49,'1845278610888522','9650.15',NULL,51),(50,'8511536187678117','1245.95',NULL,52),(51,'2946537439164373','7279.29',NULL,53),(52,'7998677729703020','2658.58',NULL,54),(53,'8905314425713292','1455.04',NULL,55),(54,'1135512011537037','9299.47',NULL,56),(55,'9855611990744271','2132.24',NULL,57),(56,'9514475702665905','2762.80',NULL,58),(57,'3344034565372237','7417.26',NULL,59),(58,'2630419478061050','8797.88',NULL,60),(59,'8660974577145624','1737.65',NULL,61),(60,'9472740786767200','2294.62',NULL,62),(61,'6280165021479463','6260.13',NULL,63),(62,'6663297541629898','4416.80',NULL,64),(63,'9163779189594187','3303.62',NULL,65),(64,'1600055676628956','3267.69',NULL,66),(65,'6450724972408824','6427.61',NULL,67),(66,'7150574767886318','2334.97',NULL,68),(67,'9408521768046791','2392.00',NULL,69),(68,'5229889252134166','4955.12',NULL,70),(69,'9828510608716564','7599.60',NULL,71),(70,'5827411585979232','3132.63',NULL,72),(71,'5506432978034704','2864.37',NULL,73),(72,'7423173567252344','4923.94',NULL,74),(73,'6234469285261416','6026.58',NULL,75),(74,'2872826349766874','5361.07',NULL,76),(75,'8703134014872438','8725.64',NULL,77),(76,'5222041131960585','7544.96',NULL,78),(77,'6582908958735920','1547.90',NULL,79),(78,'8628640664817662','5104.62',NULL,80),(79,'0205699072098834','879.39',NULL,81),(80,'6454797706390709','9083.11',NULL,82),(81,'4824642400828680','2777.37',NULL,83),(82,'4166297201350107','6637.53',NULL,84),(83,'0211239509364145','4855.52',NULL,85),(84,'4960594229480411','4365.03',NULL,86),(85,'8165764369123198','7258.59',NULL,87),(86,'2235251355634057','3197.85',NULL,88),(87,'3644268751659507','4213.49',NULL,89),(88,'3106814323444694','1473.91',NULL,90),(89,'9692662615112849','4729.07',NULL,91),(90,'3249806464389087','9223.60',NULL,92),(91,'3532249236831155','1930.82',NULL,93),(92,'9696914927645688','1983.31',NULL,94),(93,'9875166958101778','4124.08',NULL,95),(94,'3751056778038311','4670.46',NULL,96),(95,'3926119569550738','980.08',NULL,97),(96,'2087519552870389','889.01',NULL,98),(97,'1866589123147820','1504.81',NULL,99),(98,'1286292438586267','4857.02',NULL,100),(99,'9968964241973594','9770.68',NULL,101),(100,'3273935472634383','4282.33',NULL,102);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticker`
--

DROP TABLE IF EXISTS `ticker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticker` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticker` varchar(45) NOT NULL,
  `currentPrice` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3369 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-03-19 16:05:26
