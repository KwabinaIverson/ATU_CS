package com.GameHub;

import javax.swing.*;
import java.sql.*;

/**
 * The `MySqlDB` class provides methods for interacting with a MySQL database,
 * specifically for managing a "MEMBERSHIP" table. It includes functionality
 * for establishing a connection, creating the table if it doesn't exist,
 * and inserting data into the table.
 */
public class MySqlDB {
    private static Connection myConn = null;


    /**
     * Establishes a connection to the MySQL database.
     *
     * @return The established Connection object, or null if the connection fails.
     */
    public static Connection createMyConn() {
        try {
            String dbURL = "jdbc:mysql://localhost:3306/"; // DB URL
            String dbUser = "root"; // DB User
            String dbPassword = ""; // Password to access DB

            myConn = DriverManager.getConnection(dbURL, dbUser, dbPassword); // Create connection

            // Display Connection message on a message dialog
            JOptionPane.showMessageDialog(null, "MySQL Connection established", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "MySQL Failed to connect", "Success", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return myConn;
    }

    /**
     * Creates the "MEMBERSHIP" table in the database if it doesn't already exist.
     */
    public static void createNewTable() {
        try {
            DatabaseMetaData metaData = myConn.getMetaData();
            ResultSet resultSet = metaData.getTables(null,null, "MEMBERSHIP", null);

            if (resultSet.next()) {
                return;
            } else {
                String sQL = "CREATE TABLE MEMBERS ("
                        + "membership_id INT(5) NOT NULL AUTO_INCREMENT,"
                        + "student_id varchar(15),"
                        + "first_name varchar(25),"
                        + "last_name varchar(25),"
                        + "email varchar(225),"
                        + "password varchar(225)"
                        + "PRIMARY KEY (membership_id)" +
                        ")";

                PreparedStatement statement = myConn.prepareStatement(sQL);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Game Membership Table created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserts data into the "MEMBERSHIP" table.
     *
     * @param firstName The first name of the member.
     * @param lastName The last name of the member.
     * @param studentID The student ID of the member.
     * @param email The email address of the member.
     * @param password The password of the member.
     */
    public static void insertData(String firstName, String lastName, String studentID, String email, String password) {
        try {
            String sQL = "INSERT INTO MEMBERSHIP VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = myConn.prepareStatement(sQL);

            statement.setInt(1, 0);
            statement.setString(2, studentID);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, email);
            statement.setString(6, password);
            
            int dataInserted = statement.executeUpdate();

            // Alert if data inserted failed or succeed
            if (dataInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data inserted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to insert data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}