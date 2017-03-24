drop DATABASE `onlinestorage`;
CREATE DATABASE `onlinestorage` DEFAULT CHARACTER SET utf8;

CREATE TABLE `onlinestorage`.`user_roles` (
  `username` varchar(45) NOT NULL,
  `role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`));


CREATE TABLE `onlinestorage`.`users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `enabled` int(45) DEFAULT NULL,
  PRIMARY KEY (`username`));
  
CREATE INDEX `username` ON `onlinestorage`.`users` (`username`);
ALTER TABLE `onlinestorage`.`user_roles` ADD CONSTRAINT `product_fk1` FOREIGN KEY (`username`)
REFERENCES `onlinestorage`.`users`(`username`) ON DELETE CASCADE ON UPDATE CASCADE;


CREATE TABLE `onlinestorage`.`basket` (
  `idBasket` int(11) NOT NULL auto_increment,
  `userName` varchar(45) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `productName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idBasket`));


-- -----------------------------------------------------
-- Table `onlinestorage`.`Catalog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`Catalog` (
  `IdCatalog` INT(11) NOT NULL,
  `CatalogName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`IdCatalog`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`Category` (
  `CategoryName` VARCHAR(255) NOT NULL,
  `CatalogId` INT(11) NOT NULL,
  `IdCategory` INT(11) NOT NULL,
  PRIMARY KEY (`IdCategory`),
  INDEX `fk_Category_Catalog1_idx` (`CatalogId` ASC),
  CONSTRAINT `fk_Category_Catalog1`
    FOREIGN KEY (`CatalogId`)
    REFERENCES `onlinestorage`.`Catalog` (`IdCatalog`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`Attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`Attribute` (
  `idAttribute` INT(45) NOT NULL,
  `AttributeName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAttribute`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`Product` (
  `idProduct` INT(11) NOT NULL,
  `ProductName` VARCHAR(255) NOT NULL,
  `Price` VARCHAR(255) NULL,
  `Description` VARCHAR(255) NULL,
  `CategoryId` INT(11) NOT NULL,
  PRIMARY KEY (`idProduct`),
  INDEX `product_category_idx` (`CategoryId` ASC),
  CONSTRAINT `product_category`
    FOREIGN KEY (`CategoryId`)
    REFERENCES `onlinestorage`.`Category` (`IdCategory`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`Value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`Value` (
  `AttributeId` INT(11) NOT NULL,
  `Value` VARCHAR(255) NULL,
  `iDValue` INT(11) NOT NULL auto_increment,
  `ProductID` INT(11) NOT NULL,
  PRIMARY KEY (`iDValue`),
  INDEX `at_value_idx` (`AttributeId` ASC),
  INDEX `productID` (`ProductID` ASC),
  CONSTRAINT `at_value`
    FOREIGN KEY (`AttributeId`)
    REFERENCES `onlinestorage`.`Attribute` (`idAttribute`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `product_value`
    FOREIGN KEY (`ProductID`)
    REFERENCES `onlinestorage`.`Product` (`idProduct`)
    ON DELETE cascade
    ON UPDATE cascade)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`CategoryAttribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`CategoryAttribute` (
  `CategoryId` INT(11) NOT NULL,
  `idAttribute` INT(11) NOT NULL,
  PRIMARY KEY (`CategoryId`, `idAttribute`),
  INDEX `attribute_idx` (`idAttribute` ASC),
  CONSTRAINT `category`
    FOREIGN KEY (`CategoryId`)
    REFERENCES `onlinestorage`.`Product` (`CategoryId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `attribute`
    FOREIGN KEY (`idAttribute`)
    REFERENCES `onlinestorage`.`Attribute` (`idAttribute`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `onlinestorage`.`Photo` (
  `idPhoto` INT(11) NOT NULL auto_increment,
  `photoName` VARCHAR(45) NOT NULL,
  `productId` INT(11) NOT NULL,
  PRIMARY KEY (`idPhoto`),
  INDEX `pr_ph_idx` (`productId` ASC),
  CONSTRAINT `pr_ph`
    FOREIGN KEY (`productId`)
    REFERENCES `onlinestorage`.`Product` (`idProduct`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;




