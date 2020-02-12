CREATE DATABASE IF NOT EXISTS bookstore;
USE bookstore;

DROP TABLE IF EXISTS `Tax`;
DROP TABLE IF EXISTS `Clients`;
DROP TABLE IF EXISTS `Book_Authors`;
DROP TABLE IF EXISTS  `Book_Format`;
DROP TABLE IF EXISTS`Ads`;
DROP TABLE IF EXISTS `Order_Item`;
DROP TABLE IF EXISTS `News`;
DROP TABLE IF EXISTS `Authors`;
DROP TABLE IF EXISTS `Orders`;
DROP TABLE IF EXISTS `Survey_Data`;
DROP TABLE IF EXISTS `Surveys`;
DROP TABLE IF EXISTS `Book`;
DROP TABLE IF EXISTS `Client_Inventory`;
DROP TABLE IF EXISTS `Customer_Reviews`;
DROP TABLE IF EXISTS `Publisher`;

CREATE TABLE `Publisher` (
  `Publisher_ID` INT AUTO_INCREMENT,
  `Name` VARCHAR(300),
  `Address` VARCHAR(500),
  `City` VARCHAR(100),
  `Country` VARCHAR(100),
  `Postal_Code` VARCHAR(20),
  `Contact_Name` VARCHAR(100),
  `Phone_Number` VARCHAR(10),
  `Date_Created` DATETIME,
  `Last_Modified` DATETIME,
  `Is_Removed` BOOL,
  PRIMARY KEY (`Publisher_ID`)
);

CREATE TABLE `Customer_Reviews` (
  `Review_ID` INT AUTO_INCREMENT,
  `Client_ID` INT,
  `ISBN` VARCHAR(13),
  `Rating` Double(5,4),
  `Review_Body` VARCHAR(10000),
  `Review_Title` VARCHAR(100),
  `Upvotes` INT,
  `Downvotes` INT,
  `Is_Removed` BOOL,
  `Pending` BOOL,
  `Last_Modified` DATETIME,
  `Date_Entered` DATETIME,
  `Date_Removed` DATETIME,
  PRIMARY KEY (`Review_ID`),
  KEY `FK` (`Client_ID`, `ISBN`)
);

CREATE TABLE `Client_Inventory` (
  `Client_ID` INT,
  `ISBN` VARCHAR(13),
  `Date_Purchased` DATETIME,
  `Last_Modified` DATETIME,
  `Is_Removed` BOOL,
  KEY `FK` (`Client_ID`, `ISBN`)
);

CREATE TABLE `Book` (
  `ISBN` VARCHAR(13),
  `Title` VARCHAR(500),
  `Publisher_ID` INT,
  `Date_Of_Publication` DATETIME,
  `Num_Of_Pages` INT,
  `Genre` VARCHAR(50),
  `Description` VARCHAR(10000),
  `Wholesale_Price` DECIMAL(10,2) ,
  `List_Price` DECIMAL(10,2),
  `Sale_Price` DECIMAL(10,2),
  `Date_Entered` DATETIME,
  `Last_Modified` DATETIME,
  `Is_Removed` BOOL DEFAULT FALSE,
  CONSTRAINT Whole_Constraint CHECK (`Wholesale_Price` <= `List_Price`),
  CONSTRAINT Sale_Constraint CHECK (`Sale_Price` <= `List_Price` AND `Wholesale_Price` <= `Sale_Price`),
  PRIMARY KEY (`ISBN`),
  KEY `FK` (`Publisher_ID`)
);

CREATE TABLE `Surveys` (
  `Survey_ID` INT AUTO_INCREMENT,
  `Survey_Description` VARCHAR(500),
  `Survery_Name` VARCHAR(100),
  `Date_Created` DATETIME,
  `Last_Modified` DATETIME,
  `Is_Removed` BOOL,
  PRIMARY KEY (`Survey_ID`)
);

CREATE TABLE `Survey_Data` (
  `Data_ID` INT AUTO_INCREMENT,
  `Survey_ID` INT,
  `Choice` VARCHAR(200),
  `Votes` INT,
  `Date_Created` DATETIME,
  `Last_Modified` DATETIME,
  `Is_Removed` BOOL,
  PRIMARY KEY (`Data_ID`),
  KEY `FK` (`Survey_ID`)
);

CREATE TABLE `Orders` (
  `Order_ID` INT AUTO_INCREMENT,
  `Client_ID` INT,
  `Date_Created` DATETIME,
  `Last_Updated` DATETIME,
  `Is_Removed` BOOL,
  PRIMARY KEY (`Order_ID`),
  KEY `FK` (`Client_ID`)
);

CREATE TABLE `Authors` (
  `Author_ID` INT AUTO_INCREMENT,
  `Name` VARCHAR(100),
  `Is_Removed` BOOL,
  `Date_Entered` DATETIME,
  `Last_Modified` DATETIME,
  PRIMARY KEY (`Author_ID`)
);

CREATE TABLE `News` (
  `News_ID` INT AUTO_INCREMENT,
  `RSS_Feed` VARCHAR(500),
  `Date_Created` DATETIME,
  `Date_Ended` DATETIME,
  `Is_Removed` BOOL,
  `Last_Modified` DATETIME,
  PRIMARY KEY (`News_ID`)
);

CREATE TABLE `Order_Item` (
  `Item_ID` INT AUTO_INCREMENT,
  `Order_ID` INT,
  `ISBN` VARCHAR(13),
  `Price_Sold` DOUBLE(10,2),
  `Last_Updated` DATETIME,
  `Is_Removed` BOOL,
  PRIMARY KEY (`Item_ID`),
  KEY `FK` (`Order_ID`, `ISBN`)
);

CREATE TABLE `Ads` (
  `Ad_ID` INT AUTO_INCREMENT,
  `Image_Name` VARCHAR(500),
  `Ad_Url` VARCHAR(1000),
  `Date_Created` DATETIME,
  `Last_Modified` DATETIME,
  `Is_Removed` BOOL,
  PRIMARY KEY (`Ad_ID`)
);

CREATE TABLE `Book_Format` (
  `ISBN` VARCHAR(13),
  `Format` VARCHAR(6),
  `File_Location` VARCHAR(1000),
  `Date_Created` DATETIME,
  `Last_Modified` DATETIME,
  `Is_Removed` BOOL,
  KEY `FK` (`ISBN`)
);

CREATE TABLE `Book_Authors` (
  `Author_ID` INT,
  `ISBN` VARCHAR(13),
  KEY `FK` (`Author_ID`, `ISBN`)
);

CREATE TABLE `Clients` (
  `Client_ID` INT AUTO_INCREMENT,
  `Is_Manager` BOOL,
  `First_Name` VARCHAR(50),
  `Last_Name` VARCHAR(50),
  `Company_Name` VARCHAR(100),
  `Address_1` VARCHAR(300),
  `Address_2` VARCHAR(300),
  `City` VARCHAR(100),
  `Province_Abbreviation` INT,
  `Country` VARCHAR(30),
  `Postal_Code` VARCHAR(6),
  `Home_Telephone` VARCHAR(10),
  `Cell_Telephone` VARCHAR(10),
  `Email` VARCHAR(300),
  `Date_Entered` DATETIME,
  `Last_Modified` DATETIME,
  `Is_Removed` BOOL,
  PRIMARY KEY (`Client_ID`),
  KEY `FK` (`Province_Abbreviation`)
);

CREATE TABLE `Tax` (
  Province_Abbreviation VARCHAR(2),
  `GST` DECIMAL(8,5),
  `PST` DECIMAL(8,5),
  `HST` DECIMAL(8,5),
  PRIMARY KEY (`Province_Abbreviation`)
);