IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'ecommerce')
    BEGIN
        CREATE DATABASE ecommerce;
    END;
