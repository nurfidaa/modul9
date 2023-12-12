package org.example;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db_java",
                    "root",
                    ""
            );
            System.out.println("Database Connected");

            statement = connect.createStatement();
            String createTableSQL = "CREATE TABLE user ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                   + "name VARCHAR(50),"
                   + "age INT)";
           String insertSQL = "INSERT INTO user (name, age) VALUES (?, ?)";
           preparedStatement = connect.prepareStatement(insertSQL);

         preparedStatement.setInt(1, 1);
           preparedStatement.setString(1, "Abdul");
           preparedStatement.setInt(2, 30);
            preparedStatement.setString(1, "Bulan");
           preparedStatement.setInt(2, 12);

            preparedStatement.executeUpdate();
            System.out.println("Data Ditambahkan");

           statement.execute(createTableSQL);
           System.out.println("Table Created");

            //Akses Database
    //        resultSet = statement.executeQuery("SELECT * FROM user");
    //        while (resultSet.next()){
    //            int id = resultSet.getInt("id");
    //            String name = resultSet.getString("name");
    //            int age = resultSet.getInt("age");

     //           System.out.println("ID      : " + id + "\nName    : " + name + "\nAge     : " + age);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}