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
  `MachineDescription` varchar(200) DEFAULT NULL,
  `Color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ProductID`));

CREATE TABLE `buildingonlineshop`.`photoconstructionmaterials` (
  `id_photo` varchar(45)  NOT NULL,
  `Photo` varchar(45) NOT NULL,
  PRIMARY KEY (`Photo`));

CREATE INDEX `Photo` ON `buildingonlineshop`.`constructionmaterials` (`ProductID`);

ALTER TABLE `buildingonlineshop`.`photoconstructionmaterials` ADD CONSTRAINT `materials_fk1` FOREIGN KEY (`id_photo`)
REFERENCES `buildingonlineshop`.`constructionmaterials`(`ProductID`) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('1250x1250x15_sanded_FK', 'Raw plywood',1250,1250,15,1,1,1,20,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','');
INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('250x250x15_sanded_FK', 'Raw plywood',250,250,15,1,1,1,20,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','');
INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('550x250x15_sanded_FK', 'Raw plywood',550,250,15,1,1,1,20,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','');
INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('490x230x15_sanded_FK', 'Raw plywood',490,230,15,1,1,1,20,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','');
INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('90x290x3', 'Raw plywood',90,90,3,1,1,1,20,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','');

INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('2750x1830x16_BukBavarija_109', 'Laminated particle board',2750,1830,16,0,0,0,2.1,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','Book Bavarija 109');
INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('750x830x16_BukBavarija_109', 'Laminated particle board',750,830,16,0,0,0,2.1,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','Book Bavarija 109');
INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('132x321x16_BukBavarija_109', 'Laminated particle board',132,321,16,0,0,0,2.1,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','Book Bavarija 109');
INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('432x1830x16_BukBavarija_109', 'Laminated particle board',432,1830,16,0,0,0,2.1,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','Book Bavarija 109');
INSERT INTO `buildingonlineshop`.`constructionmaterials`(ProductID, Type, Length, Weight, Thickness, Grade, Price, Sanded, WaterResistance, NumberOfSheets, NumberOfPackages, MachineDescription, Color)
VALUES ('2750x123x16_BukBavarija_109', 'Laminated particle board',2750,123,16,0,0,0,2.1,40,9,'"Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>"','Book Bavarija 109');


INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('1250x1250x15_sanded_FK', 'fanera(1)');
INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('250x250x15_sanded_FK', 'fanera');
INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('550x250x15_sanded_FK', 'plywood');
INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('490x230x15_sanded_FK', 'plywood1');
INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('90x290x3', 'BukBavarija');

INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('2750x1830x16_BukBavarija_109', 'dsp');
INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('750x830x16_BukBavarija_109', 'dsp2');
INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('132x321x16_BukBavarija_109', 'particleboard');
INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('432x1830x16_BukBavarija_109', 'particleboard2');
INSERT INTO `buildingonlineshop`.`photoconstructionmaterials`(id_photo, Photo) VALUES ('2750x123x16_BukBavarija_109', 'particleboard3');

