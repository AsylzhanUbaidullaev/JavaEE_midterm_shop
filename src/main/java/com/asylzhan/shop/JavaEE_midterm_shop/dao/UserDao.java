package com.asylzhan.shop.JavaEE_midterm_shop.dao;

import com.asylzhan.shop.JavaEE_midterm_shop.model.Comment;
import com.asylzhan.shop.JavaEE_midterm_shop.model.Product;
import com.asylzhan.shop.JavaEE_midterm_shop.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public int registerUser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO account" + "  (id, name, email, password) VALUES " +
                " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020");

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 16);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (Exception e) {
            // process sql exception
            System.out.println(e);;
        }
        return result;
    }

    public boolean validate(User user) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("org.postgresql.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020");

             PreparedStatement preparedStatement = connection
                     .prepareStatement("select * from account where email = ? and password = ? ")) {
//            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
    }

    public ArrayList<Product> select() {

        ArrayList<Product> products = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020")){

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
                    product.setImage_link(image_link);
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
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020")){

                String sql = "SELECT * FROM products WHERE product_id=?";
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
                        product.setImage_link(image_link);
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

    public List<?> selectComments(int id) {
        ArrayList<Comment> comments = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020")){

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM comments WHERE product_id=" + id);
                while(resultSet.next()){
                    int commentId = resultSet.getInt(1);
                    String commentBody = resultSet.getString(2);
                    int productId = resultSet.getInt(3);
                    String userName = resultSet.getString(4);
                    Comment comment = new Comment();
                    comment.setId(commentId);
                    comment.setComment(commentBody);
                    comment.setProduct_id(productId);
                    comment.setUser_name(userName);
                    comments.add(comment);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return comments;
    }

    private boolean addComment(Comment comment) {
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/roadtothedream", "postgres", "aktos2020")){

                String sql = "INSERT INTO comments (comment, product_id, user_name) VALUES (?, ?, ?)";
                try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setString(1, comment.getComment());
                    preparedStatement.setInt(2, comment.getProduct_id());
                    preparedStatement.setString(3, comment.getUser_name());
                    preparedStatement.executeUpdate();

                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
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
