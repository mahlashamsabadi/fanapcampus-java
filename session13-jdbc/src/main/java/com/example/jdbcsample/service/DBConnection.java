package com.example.jdbcsample.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private Connection connection;
    private Properties properties;

    public DBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Driver could not be loaded");
        }
        properties = new Properties();
        try(InputStream inputStream = Files.newInputStream(Paths.get("./src/main/resources/DBSettings.txt"));) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("DB setting file could not be loaded");
        }
    }
    public void openConnection() throws SQLException {
        this.connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("username"), properties.getProperty("password"));
    }

    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
