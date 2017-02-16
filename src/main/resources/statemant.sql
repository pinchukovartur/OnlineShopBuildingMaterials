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

CREATE TABLE `buildingonlineshop`.`product` (
  `ProductID` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  `Discriminator` varchar(45) NOT NULL,
  `Price` double DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Weight` int(45) DEFAULT NULL,
  `Length` int(45) DEFAULT NULL,
  `Thickness` int(45) DEFAULT NULL,
  `Grade` varchar(45) DEFAULT NULL,
  `Sanded` int(25) DEFAULT NULL,
  `WaterResistance` int(45) DEFAULT NULL,
  `NumberOfSheets` int(45) DEFAULT NULL,
  `NumberOfPackages` int(45) DEFAULT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `Model` varchar(45) DEFAULT NULL,
  `Manufacturer` varchar(45) DEFAULT NULL,
  `ProductionYear` INT(45) DEFAULT NULL,
  `RobotCondition` varchar(45) DEFAULT NULL,
  `Axles` varchar(45) DEFAULT NULL,
  `MaxLoad` INT(45) DEFAULT NULL,
  `Reach` INT(45) DEFAULT NULL,
  `Footprint` varchar(45) DEFAULT NULL,
  `Repeatability` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ProductID`));

INSERT INTO `buildingonlineshop`.`product`(ProductID, Type, Discriminator, Price) VALUES ('test', 'Plywood', 'Plywood',1);
INSERT INTO `buildingonlineshop`.`product`(ProductID, Type, Discriminator, Price) VALUES ('test2', 'Robot', 'Robot',1);
INSERT INTO `buildingonlineshop`.`product`(ProductID, Type, Discriminator, Price) VALUES ('test3', 'ParticleBoard', 'ParticleBoard',1);

CREATE TABLE `buildingonlineshop`.`photo` (
  `ProductID` VARCHAR(45) NOT NULL,
  `Photo` VARCHAR(45) NOT NULL,
  `id_photo` INT(5) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_photo`));

CREATE TABLE `buildingonlineshop`.`purchase` (
  `id_purchase` INT(5) NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(45) NOT NULL,
  `quantity` INT(6) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_purchase`));

CREATE INDEX `product` ON `buildingonlineshop`.`product` (`ProductID`);

ALTER TABLE `buildingonlineshop`.`photo` ADD CONSTRAINT `product_fk1` FOREIGN KEY (`ProductID`)
REFERENCES `buildingonlineshop`.`product`(`ProductID`) ON DELETE CASCADE ON UPDATE CASCADE;

--

