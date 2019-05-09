-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 132.232.115.154    Database: nacos_config1
-- ------------------------------------------------------
-- Server version	5.7.25

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
-- Table structure for table `config_info`
--

DROP TABLE IF EXISTS `config_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text COLLATE utf8_bin COMMENT 'source user',
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `c_use` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `effect` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `c_schema` text COLLATE utf8_bin,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info`
--

LOCK TABLES `config_info` WRITE;
/*!40000 ALTER TABLE `config_info` DISABLE KEYS */;
INSERT INTO `config_info` VALUES (44,'smaker-auth-dev.yml','DEFAULT_GROUP','# ???\r\nspring:\r\n  datasource:\r\n    type: com.zaxxer.hikari.HikariDataSource\r\n    driver-class-name: com.mysql.jdbc.Driver\r\n    username: root\r\n    password: 123456\r\n    url: jdbc:mysql://smakercloud-mysql:3306/pig?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai\r\n','df63fa69deec0d5341824c36bae328f0','2019-04-15 18:04:18','2019-04-30 11:42:30',NULL,'0:0:0:0:0:0:0:1','','','',NULL,NULL,'yaml',NULL),(46,'smaker-codegen-dev.yml','DEFAULT_GROUP','## spring security ??\r\nsecurity:\r\n  oauth2:\r\n    client:\r\n      client-id: ENC(9B/m5968iJ9S5B4M5EGGAw==)\r\n      client-secret: ENC(8gKvQndS06/1UJJkkpP01w==)\r\n      scope: server\r\n\r\n# ?????\r\nspring:\r\n  datasource:\r\n    type: com.zaxxer.hikari.HikariDataSource\r\n    driver-class-name: com.mysql.jdbc.Driver\r\n    username: root\r\n    password: rengtao!Q2w3e\r\n    url: jdbc:mysql://smakercloud-mysql:3306/pig?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai\r\n  resources:\r\n    static-locations: classpath:/static/,classpath:/views/\r\n\r\n# ????URL\r\nignore:\r\n  urls:\r\n    - /actuator/**\r\n','9b30718ff7310d8d7cab81342990154e','2019-04-15 18:33:13','2019-04-30 11:42:42',NULL,'0:0:0:0:0:0:0:1','','','',NULL,NULL,'yaml',NULL),(47,'smaker-gateway-dev.yml','DEFAULT_GROUP','spring:\r\n  cloud:\r\n    gateway:\r\n      locator:\r\n        enabled: true\r\n      routes:\r\n      # ????\r\n      - id: smaker-auth\r\n        uri: lb://smaker-auth\r\n        predicates:\r\n        - Path=/auth/**\r\n        filters:\r\n          # ?????\r\n        - ValidateCodeGatewayFilter\r\n          # ??????\r\n        - PasswordDecoderFilter\r\n      #UPMS ??\r\n      - id: smaker-back\r\n        uri: lb://smaker-back\r\n        predicates:\r\n        - Path=/admin/**\r\n        filters:\r\n          # ????\r\n        - name: RequestRateLimiter\r\n          args:\r\n            key-resolver: \'#{@remoteAddrKeyResolver}\'\r\n            redis-rate-limiter.replenishRate: 10\r\n            redis-rate-limiter.burstCapacity: 20\r\n          # ????\r\n        - name: Hystrix\r\n          args:\r\n            name: default\r\n            fallbackUri: \'forward:/fallback\'\r\n      # ??????\r\n      - id: smaker-codegen\r\n        uri: lb://smaker-codegen\r\n        predicates:\r\n        - Path=/gen/**\r\n\r\n\r\nsecurity:\r\n  encode:\r\n    key: \'smakercloudrenzl\'\r\n\r\n# ????????\r\nignore:\r\n  clients:\r\n    - test\r\n','fb92cd438204827eaa86146b749551db','2019-04-15 18:34:19','2019-04-29 15:45:30',NULL,'0:0:0:0:0:0:0:1','','','',NULL,NULL,'yaml',NULL),(48,'smaker-monitor-dev.yml','DEFAULT_GROUP','spring:\r\n  # ????\r\n  security:\r\n    user:\r\n      name: ENC(9B/m5968iJ9S5B4M5EGGAw==)     \r\n      password: ENC(8gKvQndS06/1UJJkkpP01w==) \r\n','07391f44e95a09a2f74d63552553a4c0','2019-04-15 18:34:41','2019-04-29 14:27:00',NULL,'0:0:0:0:0:0:0:1','','','',NULL,NULL,'yaml',NULL),(49,'smaker-back-dev.yml','DEFAULT_GROUP','# ??????\r\njasypt:\r\n  encryptor:\r\n    password: smaker #???\r\nsecurity:\r\n  oauth2:\r\n    client:\r\n      client-id: ENC(9B/m5968iJ9S5B4M5EGGAw==)\r\n      client-secret: ENC(8gKvQndS06/1UJJkkpP01w==)\r\n      scope: server\r\n    resource:\r\n      loadBalanced: true\r\n      token-info-uri: http://smaker-auth/oauth/check_token\r\n\r\n\r\n# ???\r\nspring:\r\n  datasource:\r\n    type: com.zaxxer.hikari.HikariDataSource\r\n    driver-class-name: com.mysql.jdbc.Driver\r\n    username: root\r\n    password: 123456\r\n    url: jdbc:mysql://smakercloud-mysql:3306/pig?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai\r\n\r\n# ????URL\r\nignore:\r\n  urls:\r\n    - /actuator/**\r\n    - /user/info/*\r\n    - /log/**\r\n    - /v2/api-docs/*\r\n    - /swagger-resources/**\r\n    - /webjars/**\r\n    - /swagger-ui.html\r\n','6534f3f44f48ed9194f351ce34813e70','2019-04-15 18:35:03','2019-04-30 11:43:04',NULL,'0:0:0:0:0:0:0:1','','','',NULL,NULL,'yaml',NULL),(50,'smaker-zipkin-dev.yml','DEFAULT_GROUP','spring:\r\n  # ???\r\n  datasource:\r\n    type: com.zaxxer.hikari.HikariDataSource\r\n    driver-class-name: com.mysql.jdbc.Driver\r\n    username: root\r\n    password: 123456\r\n    url: jdbc:mysql://smakercloud-mysql:3306/pig?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai\r\nmanagement:\r\n  metrics:\r\n    web:\r\n      server:\r\n        auto-time-requests: false\r\nzipkin:\r\n  storage:\r\n    type: mysql\r\nsleuth:\r\n  enabled: true\r\n','18782cb338490fbf504fd1f2b92e76ff','2019-04-15 18:35:27','2019-04-30 11:43:15',NULL,'0:0:0:0:0:0:0:1','','','',NULL,NULL,'yaml',NULL);
/*!40000 ALTER TABLE `config_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-09 16:21:14
