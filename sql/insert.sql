INSERT INTO `onlinestorage`.`users`(username, password, email, enabled) VALUES ('user', 'user', 'pinchukovartur@gmail.com',1);
INSERT INTO `onlinestorage`.`users`(username, password, email, enabled) VALUES ('admin', 'admin', 'pinchukovartur@outlook.com',1);

INSERT INTO `onlinestorage`.`user_roles`(username, role) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `onlinestorage`.`user_roles`(username, role) VALUES ('user', 'ROLE_USER');

INSERT INTO `onlinestorage`.`catalog` (`IdCatalog`, `CatalogName`) VALUES ('1', 'Промышленное оборудование');
INSERT INTO `onlinestorage`.`catalog` (`IdCatalog`, `CatalogName`) VALUES ('2', 'Строительные материалы');

INSERT INTO `onlinestorage`.`category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Роботы', '1', '1');
INSERT INTO `onlinestorage`.`category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Лазеры', '1', '2');
INSERT INTO `onlinestorage`.`category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Вертикальные обрабатывающие центры', '1', '3');
INSERT INTO `onlinestorage`.`category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Горизонтальные обрабатывающие центры', '1', '4');

INSERT INTO `onlinestorage`.`category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Фанеры', '2', '5');
INSERT INTO `onlinestorage`.`category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Древесно-стружечные плиты', '2', '6');

INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('1', 'Робот1', '1', '1', '1');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('2', 'Робот2', '1', '1', '1');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('3', 'Лазер1', '1', '1', '2');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('4', 'Лазер2', '1', '1', '2');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('5', 'ВОМ1', '1', '1', '3');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('6', 'ВОМ2', '1', '1', '3');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('7', 'ГОМ2', '1', '1', '4');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('8', 'ГОМ1', '1', '1', '4');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('9', 'ФАН1', '20', '  Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '5');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('10', 'ФАН2', '1', '1', '5');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('11', 'ДСП1', '1', '1', '6');
INSERT INTO `onlinestorage`.`product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('12', 'ДСП2', '1', '1', '6');


INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('1', 'Длина');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('2', 'Вес');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('3', 'Толщина');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('4', 'Сорт');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('5', 'Шлифовальный');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('6', 'Водонепроницаемый');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('7', 'Количество листов в упаковке');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('8', 'Количество упаковок в фуре');

INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('9', 'Цвет');

INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('10', 'Модель');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('11', 'Производитель');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('12', 'Год производства');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('13', 'Состояние');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('14', 'Нахождение');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('15', 'Количествл осей');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('16', 'Максимальная нагрузка');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('17', 'Досягаемость');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('18', 'След');
INSERT INTO `onlinestorage`.`attribute` (`idAttribute`, `AttributeName`) VALUES ('19', 'Воспроизводимость');



INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('5', '1');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('5', '2');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('5', '3');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('5', '4');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('5', '5');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('5', '6');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('5', '7');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('5', '8');

INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('6', '1');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('6', '2');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('6', '3');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('6', '7');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('6', '8');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('6', '9');

INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '2');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '10');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '11');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '12');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '13');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '14');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '15');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '16');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '17');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '18');
INSERT INTO `onlinestorage`.`CategoryAttribute` (`CategoryId`, `idAttribute`) VALUES ('1', '19');


INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('1', '1250', '9');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '1250', '9');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('3', '15', '9');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('4', '1', '9');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('5', '1', '9');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('6', '1', '9');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('7', '40', '9');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('8', '9', '9');

INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('1', '1111', '10');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '2222', '10');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('3', '20', '10');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('4', '11', '10');

INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '12000', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'Fanuc M1', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'Fanuc', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2016', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'New- or Stockmachine "as new"', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '3', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('16', '20', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('17', '1662', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('18', 'wergwer', '1');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('19', '2', '1');

INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '12000', '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'Fanuc M2', '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'Fanuc', '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2017', '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'New- or Stockmachine "as new"', '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany',  '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '2',  '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('16', '21',  '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('17', '1663',  '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('18', 'wergwer', '2');
INSERT INTO `onlinestorage`.`value` (`AttributeId`, `Value`, `ProductID`) VALUES ('19', '3', '2');

INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('rob1.png', '1');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('rob1.png', '2');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('rob2.jpg', '2');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('rob2.jpg', '1');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('laz1.jpg', '3');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('laz2.jpg', '4');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('vom1.jpg', '5');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('vom2.jpg', '6');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('gos1.jpg', '7');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('gos2.jpg', '8');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('f1.jpg', '9');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('f1.jpg', '10');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('f2.jpg', '9');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('f2.jpg', '10');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('dsp1.jpg', '11');
INSERT INTO `onlinestorage`.`photo` (`photoName`, `productId`) VALUES ('dsp2.jpg', '12');