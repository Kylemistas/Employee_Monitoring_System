/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.ConnectionQuery;

/**
 *
 * @author John Kyle G. Mistas
 */
import com.mycompany.mavenproject1.ConnectionQuery.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateUser {

    public static void main(String[] args) {

        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement()) {

//             Create the table
            String sql = "CREATE TABLE users_acc (id SERIAL PRIMARY KEY, username VARCHAR(50) NOT NULL, password VARCHAR(50) NOT NULL, firstname VARCHAR(50) NOT NULL, lastname VARCHAR(50) NOT NULL, gender VARCHAR(50) NOT NULL, email VARCHAR(50) NOT NULL, employeeId VARCHAR(50) NOT NULL)";
            stmt.executeUpdate(sql);

            // Insert default user
            String insertQuery = "INSERT INTO users_acc (username, password, firstname, lastname, gender, email, employeeId) VALUES ('admin1', 'admin1','kyle','mistas', 'Male', 'sjsk', '12' )";
            stmt.executeUpdate(insertQuery);

            System.out.println("Table created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        try (Connection conn = DatabaseConnector.getConnection();
            Statement stmt = conn.createStatement()) {

           // Create the table
           String sql = "CREATE TABLE employee_record (id SERIAL PRIMARY KEY, date VARCHAR(50) NOT NULL, timein VARCHAR(50) NOT NULL, timeout VARCHAR(50) NOT NULL, hoursworked VARCHAR(50) NOT NULL, employeeid VARCHAR(50) NOT NULL)";
           stmt.executeUpdate(sql);

           // Insert default data
           String insertQuery = "INSERT INTO employee_record (date, timein, timeout, hoursworked, employeeid) VALUES ('2023-08-01', '08:00 AM', '05:00 PM', '9 hours', 'EMP001')";
           stmt.executeUpdate(insertQuery);

           System.out.println("Table created successfully...");
       } catch (SQLException e) {
           e.printStackTrace();
       }
        
        try (Connection conn = DatabaseConnector.getConnection();
            Statement stmt = conn.createStatement()) {

           // Create the table
           String sql = "CREATE TABLE employee_requests (id SERIAL PRIMARY KEY, date VARCHAR(50) NOT NULL, fullname VARCHAR(100) NOT NULL, employee_id VARCHAR(50) NOT NULL, request VARCHAR(200) NOT NULL)";
           stmt.executeUpdate(sql);

           // Insert default data
           String insertQuery = "INSERT INTO employee_request (date, fullname, employee_id, request) VALUES ('2023-08-01', 'John Doe', 'EMP001', 'Day off request')";
           stmt.executeUpdate(insertQuery);

           System.out.println("Table created successfully...");
       } catch (SQLException e) {
           e.printStackTrace();
       }
        
        try (Connection conn = DatabaseConnector.getConnection();
            Statement stmt = conn.createStatement()) {

           // Create the table
           String sql = "CREATE TABLE leavechecker (id SERIAL PRIMARY KEY, date VARCHAR(50) NOT NULL, value VARCHAR(50) NOT NULL, employee_id VARCHAR(50) NOT NULL)";
           stmt.executeUpdate(sql);

           // Insert default data
           String insertQuery = "INSERT INTO leavechecker (date, value, employee_id) VALUES ('2023-08-01', 'Approved', 'EMP001')";
           stmt.executeUpdate(insertQuery);

           System.out.println("Table created successfully...");
       } catch (SQLException e) {
           e.printStackTrace();
       }

        try (Connection conn = DatabaseConnector.getConnection();
            Statement stmt = conn.createStatement()) {

           // Create the table
           String sql = "CREATE TABLE saver (id SERIAL PRIMARY KEY, date VARCHAR(50) NOT NULL, value VARCHAR(50) NOT NULL, employee_id VARCHAR(50) NOT NULL)";
           stmt.executeUpdate(sql);

           // Insert default data
           String insertQuery = "INSERT INTO saver (date, value, employee_id) VALUES ('2023-08-01', 'Approved', 'EMP001')";
           stmt.executeUpdate(insertQuery);

           System.out.println("Table created successfully...");
       } catch (SQLException e) {
           e.printStackTrace();
       }

    }
}