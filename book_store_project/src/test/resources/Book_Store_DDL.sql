DROP DATABASE IF EXISTS bookstore;
CREATE DATABASE bookstore;
USE bookstore;

DROP USER IF EXISTS gb1w20@localhost;
CREATE USER gb1w20@'localhost' IDENTIFIED WITH mysql_native_password BY 'password123' REQUIRE NONE;
GRANT ALL ON bookstore.* TO gb1w20@'localhost';
FLUSH PRIVILEGES;