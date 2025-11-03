-- MariaDB script to create database and table for Busroute
CREATE DATABASE IF NOT EXISTS BusrouteDb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE BusrouteDb;

-- Table: Busroute
CREATE TABLE IF NOT EXISTS Busroute (
    Id BIGINT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255) NOT NULL,
    `Start` VARCHAR(255) NOT NULL,
    `End` VARCHAR(255) NOT NULL,
    Price DECIMAL(10,2) DEFAULT 0,
    Priority INT DEFAULT 0,
    StationNo INT DEFAULT 0
);

-- Sample data
INSERT INTO Busroute (Name, `Start`, `End`, Price, Priority, StationNo) VALUES
('Tuyến 01', 'Bến xe Miền Đông', 'Bến Thành', 7000, 1, 15),
('Tuyến 02', 'Ngã tư Ga', 'Chợ Lớn', 7000, 2, 20),
('Tuyến 03', 'Thủ Đức', 'Quận 1', 7000, 3, 18);

