package com.asylzhan.shop.JavaEE_midterm_shop;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public static Connection connect() {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020");
            return connection;
        } catch (Exception ex) {

        }
        return null;
    }
}
