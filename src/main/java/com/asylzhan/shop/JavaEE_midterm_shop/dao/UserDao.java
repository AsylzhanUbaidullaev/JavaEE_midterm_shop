package com.asylzhan.shop.JavaEE_midterm_shop.dao;

import com.asylzhan.shop.JavaEE_midterm_shop.model.Comment;
import com.asylzhan.shop.JavaEE_midterm_shop.model.Product;
import com.asylzhan.shop.JavaEE_midterm_shop.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, password) VALUES " +
                " (?, ?, ?);";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/rd", "postgres", "aktos2020");

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (Exception e) {
            // process sql exception
            System.out.println(e);;
        }
        return result;
    }

    public User validate(String email, String password) throws ClassNotFoundException, SQLException {
        boolean status = false;

        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/rd", "postgres", "aktos2020");

        PreparedStatement preparedStatement = connection
                .prepareStatement("select * from users where email = ? and password = ? ");
//            preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        if (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }
        rs.close();
        return user;
    }

    public User selectById(int id) throws SQLException, ClassNotFoundException{

        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/rd", "postgres", "aktos2020");

        PreparedStatement preparedStatement = connection
                .prepareStatement("select * from users where id = ? LIMIT 1");
//            preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setInt(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        if (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setEmail(rs.getString("email"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }
        rs.close();
        return user;
    }

    public ArrayList<Product> select() {

        ArrayList<Product> products = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rd", "postgres", "aktos2020")){

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
                while(resultSet.next()){
                    int productId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
//                    String description = resultSet.getString(3);
                    String image_link = resultSet.getString(3);
                    double price = resultSet.getDouble(4);
                    Product product = new Product();
                    product.setId(productId);
                    product.setName(name);
//                    product.setDescription(description);
                    product.setDescription(image_link);
                    product.setPrice(price);
                    products.add(product);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }

    public Product selectOne(int id) {

        Product product = null;
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rd", "postgres", "aktos2020")){

                String sql = "SELECT * FROM products WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int productId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
//                        String description = resultSet.getString(3);
                        String image_link = resultSet.getString(3);
                        double price = resultSet.getDouble(4);
                        product = new Product();
                        product.setId(productId);
                        product.setName(name);
//                        product.setDescription(description);
                        product.setDescription(image_link);
                        product.setPrice(price);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return product;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
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
