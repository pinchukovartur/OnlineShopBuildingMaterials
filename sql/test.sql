drop DATABASE `onlinestorage`;
CREATE DATABASE `onlinestorage` DEFAULT CHARACTER SET utf8;

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
  `iDValue` INT(11) NOT NULL AUTO_INCREMENT,
  `ProductId` INT(11) NOT NULL,
  PRIMARY KEY (`iDValue`),
  INDEX `at_value_idx` (`AttributeId` ASC),
  INDEX `productID` (`ProductId` ASC),
  CONSTRAINT `at_value`
    FOREIGN KEY (`AttributeId`)
    REFERENCES `onlinestorage`.`Attribute` (`idAttribute`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `product_value`
    FOREIGN KEY (`ProductId`)
    REFERENCES `onlinestorage`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`CategoryAttribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`CategoryAttribute` (
  `AttributeID` INT(11) NOT NULL,
  `CategoryID` INT(11) NOT NULL,
  INDEX `attribute_idx` (`AttributeID` ASC),
  INDEX `fk_CategoryAttribute_Category1_idx` (`CategoryID` ASC),
  CONSTRAINT `attribute`
    FOREIGN KEY (`AttributeID`)
    REFERENCES `onlinestorage`.`Attribute` (`idAttribute`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CategoryAttribute_Category1`
    FOREIGN KEY (`CategoryID`)
    REFERENCES `onlinestorage`.`Category` (`IdCategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`User` (
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Enabled` TINYINT(1) NOT NULL,
  PRIMARY KEY (`UserName`),
  INDEX `role` (`UserName` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`UserRole`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`UserRole` (
  `UserRole` VARCHAR(45) NOT NULL,
  `UserName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`UserName`),
  INDEX `user` (`UserName` ASC),
  CONSTRAINT `fr_user`
    FOREIGN KEY (`UserName`)
    REFERENCES `onlinestorage`.`User` (`UserName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`Photo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`Photo` (
  `photoName` VARCHAR(45) NOT NULL,
  `productId` INT(11) NOT NULL,
  PRIMARY KEY (`photoName`),
  INDEX `pr_ph_idx` (`productId` ASC),
  CONSTRAINT `pr_ph`
    FOREIGN KEY (`productId`)
    REFERENCES `onlinestorage`.`Product` (`idProduct`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlinestorage`.`basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlinestorage`.`basket` (
  `UserName` VARCHAR(45) NOT NULL,
  `ProductID` INT(11) NOT NULL,
  INDEX `fk_User_has_Product_Product1_idx` (`ProductID` ASC),
  INDEX `user` (`UserName` ASC),
  CONSTRAINT `fk_User_has_Product_Product1`
    FOREIGN KEY (`ProductID`)
    REFERENCES `onlinestorage`.`Product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_fr`
    FOREIGN KEY (`UserName`)
    REFERENCES `onlinestorage`.`User` (`UserName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
