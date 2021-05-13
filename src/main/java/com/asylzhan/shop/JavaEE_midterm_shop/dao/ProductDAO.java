package com.asylzhan.shop.JavaEE_midterm_shop.dao;

import com.asylzhan.shop.JavaEE_midterm_shop.model.Comment;
import com.asylzhan.shop.JavaEE_midterm_shop.model.Product;
import com.asylzhan.shop.JavaEE_midterm_shop.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    //    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (name, description, color, price) VALUES "
//            + " (?, ?, ?, ?);";
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products" + "  (name, description, color, price) VALUES "
            + " (?, ?, ?, ?);";

    //    private static final String SELECTx_PRODUCT_BY_ID = "select id,name,description,color,price from products where id =?";
    private static final String SELECT_PRODUCT_BY_ID = "select * from products where id =?";
    private static final String SELECT_ALL_PRODUCTS = "select * from products";
    private static final String DELETE_PRODUCTS_SQL = "delete from products where id = ?;";
    //    private static final String UPDATE_PRODUCTS_SQL = "update products set name = ?,description= ?, color =?, price =? where id = ?;";
    private static final String UPDATE_PRODUCTS_SQL = "update products set name = ?,description= ?, color =?, price =? where id = ?;";

    public ProductDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            String jdbcURL = "jdbc:postgresql://localhost:5432/rd";
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
            preparedStatement.setString(2, product.getDescription());
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
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                String imglink = rs.getString("imglink");
                String imglink2 = rs.getString("imglink2");
                String color = rs.getString("color");
                double price = rs.getDouble("price");
                product = new Product(id, name, description,imglink,imglink2, color, price);
                product.setCommentList(selectComments(id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    public List<Product> selectAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String imglink = rs.getString("imglink");
                String imglink2 = rs.getString("imglink2");
                String color = rs.getString("color");
                double price = rs.getDouble("price");
                products.add(new Product(id, name, description,imglink,imglink2, color, price));
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
            statement.setString(2, product.getDescription());
            statement.setString(3, product.getColor());
            statement.setDouble(4, product.getPrice());
            statement.setInt(5, product.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public List<Comment> selectComments(int id) {
        List<Comment> comments = new ArrayList<>();
        UserDao userDao = new UserDao();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rd", "postgres", "aktos2020")){

                Statement statement = connection.createStatement();
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM comments WHERE product_id = ?");
                ps.setInt(1,id);
                ResultSet resultSet = ps.executeQuery();
                while(resultSet.next()){
                    int commentId = resultSet.getInt(1);
                    String commentBody = resultSet.getString(2);
                    int productId = resultSet.getInt(3);
                    int userid = resultSet.getInt(4);

                    User user = userDao.selectById(userid);

                    Comment com = new Comment(commentId,commentBody,productId,userid,user);

                    comments.add(com);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return comments;
    }

    public int addComment(Comment comment) {
        int res = 0;
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/rd", "postgres", "aktos2020")){

                String sql = "INSERT INTO comments (comment, product_id, userid) VALUES (?, ?, ?)";
                try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setString(1, comment.getComment());
                    preparedStatement.setInt(2, comment.getProduct_id());
                    preparedStatement.setInt(3, comment.getUserid());
                    res = preparedStatement.executeUpdate();
                    connection.close();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return res;
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
