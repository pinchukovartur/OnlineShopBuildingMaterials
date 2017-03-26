INSERT INTO `heroku_be5b31f46086956`.`User`(username, password, email, enabled) VALUES ('user', 'user', 'pinchukovartur@gmail.com',1);
INSERT INTO `heroku_be5b31f46086956`.`User`(username, password, email, enabled) VALUES ('admin', 'admin', 'pinchukovartur@outlook.com',1);

INSERT INTO `heroku_be5b31f46086956`.`UserRole`(username, UserRole) VALUES ('admin', 'ROLE_ADMIN');
INSERT INTO `heroku_be5b31f46086956`.`UserRole`(username, UserRole) VALUES ('user', 'ROLE_USER');

INSERT INTO `heroku_be5b31f46086956`.`Catalog` (`IdCatalog`, `CatalogName`) VALUES ('1', 'Промышленное оборудование');
INSERT INTO `heroku_be5b31f46086956`.`Catalog` (`IdCatalog`, `CatalogName`) VALUES ('2', 'Строительные материалы');

INSERT INTO `heroku_be5b31f46086956`.`Category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Роботы', '1', '1');
INSERT INTO `heroku_be5b31f46086956`.`Category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Лазеры', '1', '2');
INSERT INTO `heroku_be5b31f46086956`.`Category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Вертикальные обрабатывающие центры', '1', '3');
INSERT INTO `heroku_be5b31f46086956`.`Category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Горизонтальные обрабатывающие центры', '1', '4');

INSERT INTO `heroku_be5b31f46086956`.`Category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Фанеры', '2', '5');
INSERT INTO `heroku_be5b31f46086956`.`Category` (`CategoryName`, `CatalogId`, `IdCategory`) VALUES ('Древесно-стружечные плиты', '2', '6');



INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('1', 'Робот1', '1', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '1');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('2', 'Робот2', '2', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '1');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('3', 'Лазер1', '3', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '2');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('4', 'Лазер2', '4', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '2');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('5', 'ВОМ1', '5', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '3');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('6', 'ВОМ2', '16', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '3');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('7', 'ГОМ2', '7', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '4');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('8', 'ГОМ1', '18', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '4');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('9', 'ФАН1', '20', 'Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '5');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('10', 'ФАН2', '19', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '5');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('11', 'ДСП1', '17', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '6');
INSERT INTO `heroku_be5b31f46086956`.`Product` (`idProduct`, `ProductName`, `Price`, `Description`, `CategoryId`) VALUES ('12', 'ДСП2', '11', ' Equipment  Main drive <br>Air conditioner for electrical cabinet <br>Half cabin <br>', '6');




INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('1', 'Длина');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('2', 'Вес');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('3', 'Толщина');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('4', 'Сорт');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('5', 'Шлифовальный');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('6', 'Водонепроницаемый');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('7', 'Количество листов в упаковке');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('8', 'Количество упаковок в фуре');

INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('9', 'Цвет');

INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('10', 'Модель');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('11', 'Производитель');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('12', 'Год производства');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('13', 'Состояние');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('14', 'Нахождение');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('15', 'Количествл осей');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('16', 'Максимальная нагрузка');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('17', 'Досягаемость');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('18', 'След');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('19', 'Воспроизводимость');

INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('20', 'Система ЧПУ');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('21', 'Перемещение по оси - X');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('22', 'Перемещение по оси - Y');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('23', 'Перемещение по оси - Z');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('24', 'Размер стола - X');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('25', 'Размер стола - Y');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('26', 'Нагрузка на стол');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('27', 'Частота вращения шпинделя');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('28', 'Мощность шпинделя');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('29', 'Количество инстрементов');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('30', 'Максимальный диаметр инструмента в магазине');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('31', 'Максимальный длина инструмента в магазине');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('32', 'Время смены инструмента');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('33', 'Наработка на шпинделе, ч ');
INSERT INTO `heroku_be5b31f46086956`.`Attribute` (`idAttribute`, `AttributeName`) VALUES ('34', 'Включение станка всего, ч ');




INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('5', '1');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('5', '2');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('5', '3');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('5', '4');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('5', '5');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('5', '6');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('5', '7');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('5', '8');

INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('6', '1');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('6', '2');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('6', '3');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('6', '7');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('6', '8');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('6', '9');

INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '2');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '10');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '11');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '12');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '13');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '14');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '15');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '16');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '17');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '18');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('1', '19');

INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '2');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '10');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '11');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '12');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '13');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '14');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '15');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '20');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '21');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '12');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '13');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '14');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '15');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '20');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '21');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '22');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '23');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '24');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '25');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '26');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '27');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '28');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '29');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '30');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '31');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '32');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '33');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '34');

INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '2');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '10');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '11');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '12');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '13');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '14');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('2', '15');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '20');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '21');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '12');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '13');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '14');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '15');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '20');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '21');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '22');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '23');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '24');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '25');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '26');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '27');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '28');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '29');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '30');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '31');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '32');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '33');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('3', '34');

INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '2');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '10');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '11');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '12');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '13');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '14');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '15');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '20');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '21');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '12');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '13');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '14');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '15');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '20');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '21');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '22');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '23');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '24');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '25');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '26');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '27');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '28');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '29');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '30');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '31');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '32');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '33');
INSERT INTO `heroku_be5b31f46086956`.`CategoryAttribute` (`CategoryId`, `AttributeID`) VALUES ('4', '34');




INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('1', '1250', '9');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '1250', '9');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('3', '15', '9');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('4', '1', '9');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('5', '1', '9');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('6', '1', '9');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('7', '40', '9');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('8', '9', '9');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('1', '1111', '10');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '2222', '10');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('3', '20', '10');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('4', '11', '10');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('1', '1111', '11');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '2222', '11');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('3', '20', '11');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('7', '11', '11');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('8', '11', '11');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('9', 'Черный', '11');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('1', '1111', '12');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '2222', '12');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('3', '20', '12');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('7', '11', '12');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('8', '11', '12');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('9', 'Белый', '12');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '12000', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'Fanuc M1', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'Fanuc', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2016', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'New- or Stockmachine "as new"', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '3', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('16', '20', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('17', '1662', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('18', 'wergwer', '1');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('19', '2', '1');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('2', '12000', '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'Fanuc M2', '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'Fanuc', '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2017', '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'New- or Stockmachine "as new"', '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany',  '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '2',  '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('16', '21',  '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('17', '1663',  '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('18', 'wergwer', '2');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('19', '3', '2');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'DMC 1035 V ecoline New Design', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'DECKEL MAHO', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2013', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'Demo, Training or Exhibition machine', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '3', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('20', 'Siemens', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('21', '3D-Control Siemens 840D', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('22', '1035', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('23', '560', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('24', '510', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('25', '1200', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('26', '560', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('27', '1000', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('28', '12000', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('29', '13/9', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('30', '30', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('31', '80', '5');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'DMC 1035 V ecoline New Design2', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'DECKEL MAHO2', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2014', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'Demo, Training or Exhibition machine', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '3', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('20', 'Siemens', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('21', '3D-Control Siemens 840D', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('22', '1035', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('23', '560', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('24', '510', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('25', '1200', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('26', '560', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('27', '1000', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('28', '12000', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('29', '13/9', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('30', '30', '6');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('31', '80', '6');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'DMC 55 H duoBLOCK', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'DECKEL MAHO', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2012', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'Demo, Training or Exhibition machine', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '3', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('20', 'Siemens', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('21', '3D-Control Siemens 840D', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('22', '1035', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('23', '560', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('24', '510', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('25', '1200', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('26', '560', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('27', '1000', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('28', '12000', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('29', '13/9', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('30', '30', '7');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('31', '80', '7');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'DMC 55 H duoBLOCK', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'DECKEL MAHO', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2012', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'Demo, Training or Exhibition machine', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '3', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('20', 'Siemens', '5');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('21', '3D-Control Siemens 840D', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('22', '1035', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('23', '560', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('24', '510', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('25', '1200', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('26', '560', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('27', '1000', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('28', '12000', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('29', '13/9', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('30', '30', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('31', '80', '8');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'Lather 55 H duoBLOCK', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'DECKEL MAHO', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2012', '8');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'Demo, Training or Exhibition machine', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '3', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('20', 'Siemens', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('21', '3D-Control Siemens 840D', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('22', '1035', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('23', '560', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('24', '510', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('25', '1200', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('26', '560', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('27', '1000', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('28', '12000', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('29', '13/9', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('30', '30', '3');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('31', '80', '3');

INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('10', 'Lather 56 H duoBLOCK', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('11', 'DECKEL MAHO', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('12', '2012', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('13', 'Demo, Training or Exhibition machine', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('14', 'Germany', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('15', '3', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('20', 'Siemens', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('21', '3D-Control Siemens 840D', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('22', '1035', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('23', '560', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('24', '510', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('25', '1200', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('26', '560', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('27', '1000', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('28', '12000', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('29', '13/9', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('30', '30', '4');
INSERT INTO `heroku_be5b31f46086956`.`Value` (`AttributeId`, `Value`, `ProductID`) VALUES ('31', '80', '4');




INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('rob1.png', '1');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('rob2.jpg', '2');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('laz1.jpg', '3');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('laz2.jpg', '4');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('vos1.jpg', '5');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('vos2.jpg', '6');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('gos1.jpg', '7');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('gos2.jpg', '8');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('f1.jpg', '9');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('f2.jpg', '10');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('dsp1.jpg', '11');
INSERT INTO `heroku_be5b31f46086956`.`Photo` (`photoName`, `productId`) VALUES ('dsp2.jpg', '12');