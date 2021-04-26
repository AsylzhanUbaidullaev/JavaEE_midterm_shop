package com.asylzhan.shop.JavaEE_midterm_shop.dao;

import com.asylzhan.shop.JavaEE_midterm_shop.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

//    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (name, description, color, price) VALUES "
//            + " (?, ?, ?, ?);";
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (name, image_link, color, price) VALUES "
            + " (?, ?, ?, ?);";

//    private static final String SELECT_PRODUCT_BY_ID = "select id,name,description,color,price from products where id =?";
    private static final String SELECT_PRODUCT_BY_ID = "select id,name,image_link,color,price from products where id =?";
    private static final String SELECT_ALL_PRODUCTS = "select * from products";
    private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";
//    private static final String UPDATE_PRODUCTS_SQL = "update products set name = ?,description= ?, color =?, price =? where id = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update products set name = ?,image_link= ?, color =?, price =? where id = ?;";

    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String jdbcURL = "jdbc:postgresql://localhost:5432/roadtothedream";
            String jdbcUsername = "postgres";
            String jdbcPassword = "aktos2020";
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertProduct(Product product) throws SQLException {
        System.out.println(INSERT_PRODUCTS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL)) {
            preparedStatement.setString(1, product.getName());
//            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(2, product.getImage_link());
            preparedStatement.setString(3, product.getColor());
            preparedStatement.setDouble(4, product.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Product selectProduct(int id) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
//                String description = rs.getString("description");
                String image_link = rs.getString("image_link");
                String color = rs.getString("color");
                double price = rs.getDouble("price");
                product = new Product(id, name, image_link, color, price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    public List<Product> selectAllProducts() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Product> products = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
//                String description = rs.getString("description");
                String image_link = rs.getString("image_link");
                String color = rs.getString("color");
                double price = rs.getDouble("price");
                products.add(new Product(id, name, image_link, color, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCTS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCTS_SQL);) {
            statement.setString(1, product.getName());
//            statement.setString(2, product.getDescription());
            statement.setString(2, product.getImage_link());
            statement.setString(3, product.getColor());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
