drop DATABASE `heroku_be5b31f46086956`;
CREATE DATABASE `heroku_be5b31f46086956` DEFAULT CHARACTER SET utf8;

-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`Catalog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`Catalog` (
  `IdCatalog` INT(11) NOT NULL,
  `CatalogName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`IdCatalog`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`Category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`Category` (
  `CategoryName` VARCHAR(255) NOT NULL,
  `CatalogId` INT(11) NOT NULL,
  `IdCategory` INT(11) NOT NULL,
  PRIMARY KEY (`IdCategory`),
  INDEX `fk_Category_Catalog1_idx` (`CatalogId` ASC),
  CONSTRAINT `fk_Category_Catalog1`
    FOREIGN KEY (`CatalogId`)
    REFERENCES `heroku_be5b31f46086956`.`Catalog` (`IdCatalog`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`Attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`Attribute` (
  `idAttribute` INT(45) NOT NULL,
  `AttributeName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAttribute`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`Product` (
  `idProduct` INT(11) NOT NULL auto_increment, -- -----------------------------------------
  `ProductName` VARCHAR(255) NOT NULL,
  `Price` VARCHAR(255) NULL,
  `Description` VARCHAR(255) NULL,
  `CategoryId` INT(11) NOT NULL,
  PRIMARY KEY (`idProduct`),
  INDEX `product_category_idx` (`CategoryId` ASC),
  CONSTRAINT `product_category`
    FOREIGN KEY (`CategoryId`)
    REFERENCES `heroku_be5b31f46086956`.`Category` (`IdCategory`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`Value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`Value` (
  `AttributeId` INT(11) NOT NULL,
  `Value` VARCHAR(255) NULL,
  `iDValue` INT(11) NOT NULL AUTO_INCREMENT,
  `ProductId` INT(11) NOT NULL,
  PRIMARY KEY (`iDValue`),
  INDEX `at_value_idx` (`AttributeId` ASC),
  INDEX `productID` (`ProductId` ASC),
  CONSTRAINT `at_value`
    FOREIGN KEY (`AttributeId`)
    REFERENCES `heroku_be5b31f46086956`.`Attribute` (`idAttribute`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_value`
    FOREIGN KEY (`ProductId`)
    REFERENCES `heroku_be5b31f46086956`.`Product` (`idProduct`)
    ON DELETE cascade
    ON UPDATE cascade)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`CategoryAttribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`CategoryAttribute` (
  `AttributeID` INT(11) NOT NULL,
  `CategoryID` INT(11) NOT NULL,
  INDEX `attribute_idx` (`AttributeID` ASC),
  INDEX `fk_CategoryAttribute_Category1_idx` (`CategoryID` ASC),
  CONSTRAINT `attribute`
    FOREIGN KEY (`AttributeID`)
    REFERENCES `heroku_be5b31f46086956`.`Attribute` (`idAttribute`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CategoryAttribute_Category1`
    FOREIGN KEY (`CategoryID`)
    REFERENCES `heroku_be5b31f46086956`.`Category` (`IdCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`User` (
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Enabled` TINYINT(1) NOT NULL,
  PRIMARY KEY (`UserName`),
  INDEX `role` (`UserName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`UserRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`UserRole` (
  `UserRole` VARCHAR(45) NOT NULL,
  `UserName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserName`),
  INDEX `user` (`UserName` ASC),
  CONSTRAINT `fr_user`
    FOREIGN KEY (`UserName`)
    REFERENCES `heroku_be5b31f46086956`.`User` (`UserName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`Photo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`Photo` (
  `photoName` VARCHAR(45) NOT NULL,
  `productId` INT(11) NOT NULL,
  PRIMARY KEY (`photoName`),
  INDEX `pr_ph_idx` (`productId` ASC),
  CONSTRAINT `pr_ph`
    FOREIGN KEY (`productId`)
    REFERENCES `heroku_be5b31f46086956`.`Product` (`idProduct`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `heroku_be5b31f46086956`.`basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `heroku_be5b31f46086956`.`basket` (
  `UserName` VARCHAR(45) NOT NULL,
  `ProductID` INT(11) NOT NULL,
  INDEX `fk_User_has_Product_Product1_idx` (`ProductID` ASC),
  INDEX `user` (`UserName` ASC),
  CONSTRAINT `fk_User_has_Product_Product1`
    FOREIGN KEY (`ProductID`)
    REFERENCES `heroku_be5b31f46086956`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_fr`
    FOREIGN KEY (`UserName`)
    REFERENCES `heroku_be5b31f46086956`.`User` (`UserName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
