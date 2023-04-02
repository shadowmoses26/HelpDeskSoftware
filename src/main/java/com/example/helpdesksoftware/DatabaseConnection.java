package com.example.helpdesksoftware;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnetction() {
        String databaseName = "HelpDesk";
        String databaseUser = "postgresql";
        String databasePassword = "root";
        String url = "jdbc:postgresql://localhost:5432/postgres" + databaseName;

        try {
            Class.forName("org.postgresql.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return databaseLink;
    }


}
