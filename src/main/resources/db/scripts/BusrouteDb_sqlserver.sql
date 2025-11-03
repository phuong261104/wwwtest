-- SQL Server script to create database and table for Busroute
IF DB_ID('BusrouteDb') IS NULL
    CREATE DATABASE BusrouteDb;
GO

USE BusrouteDb;
GO

IF OBJECT_ID('dbo.Busroute', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.Busroute (
        Id BIGINT IDENTITY(1,1) NOT NULL PRIMARY KEY,
        Name NVARCHAR(255) NOT NULL,
        [Start] NVARCHAR(255) NOT NULL,
        [End] NVARCHAR(255) NOT NULL,
        Price DECIMAL(10,2) NULL DEFAULT 0,
        Priority INT NULL DEFAULT 0,
        StationNo INT NULL DEFAULT 0
    );
END
GO

-- Sample data
INSERT INTO dbo.Busroute (Name, [Start], [End], Price, Priority, StationNo) VALUES
    (N'Tuyến 01', N'Bến xe Miền Đông', N'Bến Thành', 7000, 1, 15),
    (N'Tuyến 02', N'Ngã tư Ga', N'Chợ Lớn', 7000, 2, 20),
    (N'Tuyến 03', N'Thủ Đức', N'Quận 1', 7000, 3, 18);
GO

