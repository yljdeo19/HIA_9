package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class Gold implements Customer{

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private int DIS = 15;
    private double schet;
    @Value("${gold.schet}")


    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Gold(double schet) {
        this.schet = schet;
    }

    @Override
    public double platy(double cena) {
        return schet - cena;
    }

    @Override
    public int getDIS() {
        return DIS;
    }

    @Override
    public ArrayList<String> getProducts() {
        ArrayList<String> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Products";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                String name = resultSet.getString("name");
                products.add(name);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public ArrayList<String> getServices() {
        ArrayList<String> services = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Services";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                String name = resultSet.getString("name");
                services.add(name);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return services;
    }

    @Override
    public double getSchet() {
        return schet;
    }

    public String toString() {
        return "Gold{" +
                "params='" + DIS + '\'' + schet +
                '}';
    }

}
