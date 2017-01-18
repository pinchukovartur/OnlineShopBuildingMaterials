drop DATABASE `buildingonlineshop`;
CREATE DATABASE `buildingonlineshop` DEFAULT CHARACTER SET utf8;

CREATE TABLE `buildingonlineshop`.`authorities` (
  `username` varchar(45) NOT NULL,
  `authority` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`));
  
  INSERT INTO `buildingonlineshop`.`authorities`(username, authority) VALUES ('admin', 'ROLE_ADMIN');
  INSERT INTO `buildingonlineshop`.`authorities`(username, authority) VALUES ('user', 'ROLE_USER');
  
  CREATE TABLE `buildingonlineshop`.`users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `enabled` int(45) DEFAULT NULL,
  PRIMARY KEY (`username`));
  
INSERT INTO `buildingonlineshop`.`users`(username, password, email, enabled) VALUES ('user', 'user', 'pinchukovartur@gmail.com',1);
INSERT INTO `buildingonlineshop`.`users`(username, password, email, enabled) VALUES ('admin', 'admin', 'pinchukovartur@outlook.com',1);

CREATE TABLE `buildingonlineshop`.`basket` (
  `username` varchar(45) NOT NULL,
  `ProductID` varchar(45) NOT NULL,
  `id` int(45) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `buildingonlineshop`.`constructionmaterials` (
  `ProductID` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  `Length` int(45) DEFAULT NULL,
  `Weight` int(45) DEFAULT NULL,
  `Thickness` int(45) DEFAULT NULL,
  `Grade` varchar(45) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  `Sanded` int(25) DEFAULT NULL,
  `WaterResistance` int(45) DEFAULT NULL,
  `NumberOfSheets` int(45) DEFAULT NULL,
  `NumberOfPackages` int(45) DEFAULT NULL,
  `MachineDescription` varchar(45) DEFAULT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `id_photo` int NOT NULL,
  PRIMARY KEY (`ProductID`));
  
  CREATE TABLE `buildingonlineshop`.`photoconstructionmaterials` (
  `id_photo` varchar(45)  NOT NULL,
  `Photo` varchar(45) NOT NULL,
  PRIMARY KEY (`Photo`));
  
  CREATE INDEX `Photo` ON `buildingonlineshop`.`constructionmaterials` (`id_photo`);
  
  ALTER TABLE `buildingonlineshop`.`photoconstructionmaterials` ADD CONSTRAINT `materials_fk1` FOREIGN KEY (`id_photo`) 
  REFERENCES `buildingonlineshop`.`constructionmaterials`(`ProductID`) ON DELETE CASCADE ON UPDATE CASCADE;


