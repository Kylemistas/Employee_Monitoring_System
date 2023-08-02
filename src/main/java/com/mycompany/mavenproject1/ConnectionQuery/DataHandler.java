/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.ConnectionQuery;

/**
 *
 * @author John Kyle G. Mistas
 */

import com.mycompany.mavenproject1.adminform.AdminDashboard;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
//import javax.swing.table.DefaultTableModel;

public class DataHandler {
    public static ArrayList<String> getAllData(){
        ArrayList<String> userList = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM users_acc";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Process the results
                    String columnName = rs.getString("username");
                    // Do something with the data
                    //JOptionPane.showMessageDialog(null, "The data are " + columnName);
                    userList.add(columnName);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage());
        }
        return userList;
    }

    public static boolean loginUser(String uname, String pass,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM users_acc WHERE username = ? AND password = ? AND employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uname);
            pstmt.setString(2, pass);
             pstmt.setString(3, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // User exists with the provided username and password
                
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // No user found with the provided username and password
        return false;
    }
    
    
    
     public static boolean checkAccount(String uname) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT role FROM users_acc WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uname);
            ResultSet rs = pstmt.executeQuery();
            
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text = rs.getString(1);
                 if(text.equals("admin")){
                    return true;
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return false;
     }
     
     public static boolean checkAccountis(String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT role FROM users_acc WHERE employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text = rs.getString(1);
                 if(text.equals("admin")){
                    return true;
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return false;
     }
     
     public static String savercheck(String date,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT value FROM saver WHERE date = ? AND employeeid=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);
            pstmt.setString(2, id);
            ResultSet rs = pstmt.executeQuery();
            
           // Check if the ResultSet contains any rows (records)
            if (rs.next()) {

                // Get the value from the first column (assuming it's a String) of the current row
                String text = rs.getString(1);

                // Return the retrieved value as a String
                return text;


            
            }else{
                return "0";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
     
      public static String leavecheck(String date,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT value FROM leavechecker WHERE date = ? AND employeeid=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);
            pstmt.setString(2, id);
            ResultSet rs = pstmt.executeQuery();
            
              // Check if the ResultSet contains any rows (records)
            if (rs.next()){
                // Get the value from the columnIndex (assuming it's a String) of the current row
                    String text = rs.getString(1);
                    // Return the retrieved value as a String
                    return text;
            
            }else{
                return "0";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
     
      public static boolean saver(String date,String value,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM saver WHERE date = ? AND employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);
            pstmt.setString(2, id);
            ResultSet rs = pstmt.executeQuery();
            
            
            if (rs.next()){
                
                 
                    return true;
            }else{
                 String insertQuery = "INSERT INTO saver (date,value,employeeid) VALUES (?,?,?)";
                 PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, date);
                insertStmt.setString(2, value);
                insertStmt.setString(3, id);
                insertStmt.executeUpdate();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return false;
     }
      
      public static boolean requestForm(String date,String name,String id,String req) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM employee_requests WHERE date = ? AND employee_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);
            pstmt.setString(2, id);
            ResultSet rs = pstmt.executeQuery();
            
            
            if (rs.next()){
                
                 
                    return true;
            }else{
                 String insertQuery = "INSERT INTO employee_requests (date,fullname,employee_id,request) VALUES (?,?,?,?)";
                 PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                    insertStmt.setString(1, date);
                    insertStmt.setString(2, name);
                    insertStmt.setString(3, id);
                    insertStmt.setString(4, req);
                    insertStmt.executeUpdate();
                    return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return false;
     }
      
      public static boolean leavebtncheck(String date,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT timeout FROM employee_record WHERE date = ? AND employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);
            pstmt.setString(2, id);
            ResultSet rs = pstmt.executeQuery();
            
            
            if (rs.next()){
    
                 return true;
            }else{
                
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return false;
     }
      
       public static boolean idexist(String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT employeeid FROM users_acc WHERE employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            
            if (rs.next()){
    
                 return true;
            }else{
                
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return false;
     }
      
//       public static boolean leavechecktimein(String date,String id) {
//        try (Connection conn = DatabaseConnector.getConnection()) {
//            String query = "SELECT timein FROM employee_record WHERE date = ? AND employeeid = ?";
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, date);
//            pstmt.setString(2, id);
//            ResultSet rs = pstmt.executeQuery();
//            
//            
//            if (rs.next()){
//    
//                 return true;
//            }else{
//                
//                return false;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        // User exists with the provided role = user
//        return false;
//     }
      
       public static boolean leave(String date,String value,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM leavechecker WHERE date = ? AND employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);
            pstmt.setString(2, id);
            ResultSet rs = pstmt.executeQuery();
            
            
            if (rs.next()){
                
                 
                    return true;
            }else{
                 String insertQuery = "INSERT INTO leavechecker (date,value,employeeid) VALUES (?,?,?)";
                 PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, date);
                insertStmt.setString(2, value);
                insertStmt.setString(3, id);
                insertStmt.executeUpdate();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return false;
     }

    //Create User
    public static boolean registerUser(String uname, String pass, String fname, String lname, String gender, String email, String empId, String role ) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT username FROM users_acc WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, uname);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                return true;
            } else {
                // Insert new user
                String insertQuery = "INSERT INTO users_acc (username, password,firstname,lastname,gender,email,employeeId, role) VALUES (? ,? ,? ,? ,? , ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, uname);
                insertStmt.setString(2, pass);
                insertStmt.setString(3, fname);
                insertStmt.setString(4, lname);
                insertStmt.setString(5, gender);
                insertStmt.setString(6, email);
                insertStmt.setString(7, empId);
                insertStmt.setString(8, role);
                insertStmt.executeUpdate();
                
                
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public static boolean adminUpdate( String uname, String pass,String fname, String lname, String gender, String email, String empId, String role,int unqid ) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT username,password,firstname,lastname,gender,email,employeeid,role FROM users_acc WHERE id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setInt(1, unqid);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "UPDATE public.users_acc SET username=?, password=?, firstname=?, lastname=?, gender=?, email=?, employeeid=?, role=? WHERE id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1, uname);
                updateStmt.setString(2, pass);
                updateStmt.setString(3, fname);
                updateStmt.setString(4, lname);
                updateStmt.setString(5, gender);
                updateStmt.setString(6, email);
                updateStmt.setString(7, empId);
                updateStmt.setString(8, role);
                updateStmt.setInt(9,unqid);
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
     public static boolean UpdateRec( String in,String out,String hr ,String date,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM employee_record WHERE employeeid = ? AND date = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, id);
            checkStmt.setString(2, date);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "UPDATE public.employee_record SET timein = ?, timeout = ?,hoursworked = ? WHERE employeeid = ? AND date = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1, in);
                updateStmt.setString(2, out);
                updateStmt.setString(3, hr);
                updateStmt.setString(4, id);
                updateStmt.setString(5, date);
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public static boolean changePass( String uname,String pass) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM users_acc WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, uname);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "UPDATE public.users_acc SET password = ? WHERE username = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1, pass);
                updateStmt.setString(2, uname);
                
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
     public static boolean changeid( String first,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT employeeid FROM users_acc WHERE employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, id);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                
               
                return true;
            } else {
                String updatetQuery = "UPDATE public.users_acc SET employeeid = ? WHERE firstname = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1, id);
                updateStmt.setString(2, first);
                
                updateStmt.executeUpdate();
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
     public static boolean changeidRec(String oldid,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM employee_record WHERE employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, oldid);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "UPDATE public.employee_record SET employeeid = ? WHERE employeeid = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1, id);
                updateStmt.setString(2, oldid);
                
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
     public static boolean changeupdate( String empid) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM employee_record WHERE employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, empid);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "UPDATE public.employee_record SET employeeid = ? WHERE employeeid = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1, empid);
                
                
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
     
      public static boolean delAcc( int unqid ) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM users_acc WHERE id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setInt(1, unqid);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "DELETE FROM public.users_acc WHERE id = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setInt(1,unqid);
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
      
      public static boolean delAccRec( String empdi ) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM employee_record WHERE employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, empdi);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "DELETE FROM public.employee_record WHERE employeeid = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1,empdi);
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
      
      public static boolean delEmergency( String empdi, String date ) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM leavechecker WHERE employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, empdi);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "DELETE FROM public.leavechecker WHERE employeeid = ? AND date = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1,empdi);
                updateStmt.setString(2,date);
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
      
         public static boolean delAllEmer( String empdi) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM leavechecker WHERE employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, empdi);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "DELETE FROM public.leavechecker WHERE employeeid = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1,empdi);
                
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
      
      public static boolean delAccRecOne( String empdi, String date ) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if username exists
            String checkQuery = "SELECT * FROM employee_record WHERE employeeid = ? AND date = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, empdi);
            checkStmt.setString(2, date);
            ResultSet rs = checkStmt.executeQuery();
            
           
            if (rs.next()) {
                String updatetQuery = "DELETE FROM public.employee_record WHERE employeeid = ? AND date = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updatetQuery);
                updateStmt.setString(1,empdi);
                updateStmt.setString(2,date);
                updateStmt.executeUpdate();
               
                return true;
            } else {
                // update new user
                 return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
      
     
    public static String welcomeUser(String uname) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT firstname,lastname FROM users_acc WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uname);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text1 = rs.getString("firstname");
                 String text2 = rs.getString("lastname");
                 String text = text1+" "+text2;
                 return text;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
    
     public static String welcomeUserid(String uname) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT firstname FROM users_acc WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uname);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text1 = rs.getString("firstname");
//                 String text2 = rs.getString("lastname");
                 
                 return text1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
    
     public static String welcomeUserlast(String uname) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT lastname FROM users_acc WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uname);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text = rs.getString(1);
                 return text;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
     
       public static String checkidchange(String fname) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT employeeid FROM users_acc WHERE firstname = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, fname);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text = rs.getString(1);
                 return text;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
    
     
      public static String userRecord(String empId) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT employeeid FROM users_acc WHERE employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, empId);
            ResultSet rs = pstmt.executeQuery();



            if (rs.next()) {
                 String idtext = rs.getString(1);
                 return idtext;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
      }
      public static String computeTime(String date,String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT timein FROM employee_record WHERE date = ? AND employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, date);
            pstmt.setString(2, id);
            ResultSet rs = pstmt.executeQuery();



            if (rs.next()) {
                 String idtext = rs.getString(1);
                 return idtext;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return null;
      }
      
      public static boolean emplyeeRectimeIn(String date, String tIn,String empid,String tout,String hrs) {
//         

        try (Connection conn = DatabaseConnector.getConnection()) {
//            Check if username exists
            String checkQuery = "SELECT date FROM employee_record WHERE date = ? AND employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, date);
             checkStmt.setString(2, empid);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
//                String insertQuery = "INSERT INTO employee_record (date, timein,employeeid,timeout,hoursworked) VALUES (?,? ,? , ?, ?)";
//                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
//                insertStmt.setString(1, date);
//                insertStmt.setString(2, tIn);
//                insertStmt.setString(3, empid);
//                insertStmt.setString(4, tout);
//                insertStmt.setString(5, hrs);
//                insertStmt.executeUpdate();
                return true;
            } else {
                
                String insertQuery = "INSERT INTO employee_record (date, timein,employeeid,timeout,hoursworked) VALUES (?,? ,? , ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setString(1, date);
                insertStmt.setString(2, tIn);
                insertStmt.setString(3, empid);
                insertStmt.setString(4, tout);
                insertStmt.setString(5, hrs);
                insertStmt.executeUpdate();
             
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
      
      public static boolean emplyeeRectimeOut(String tout,String hrswrk,String date,String id) {
//        


        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if timeout exists
            String checkQuery = "SELECT date FROM employee_record WHERE date = ? AND employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, date);
            checkStmt.setString(2, id);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                String updateQuery = "UPDATE public.employee_record SET timeout=?, hoursworked=? WHERE date = ? AND employeeid = ?";
                PreparedStatement updatetStmt = conn.prepareStatement(updateQuery);
                updatetStmt.setString(1, tout);
                updatetStmt.setString(2, hrswrk);
                updatetStmt.setString(3, date);
                updatetStmt.setString(4, id);
                updatetStmt.executeUpdate();
                return true;
            } else {
                
              
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        
    }
       public static boolean emplyeeRechourswork(String hrswork, String date) {
//          

        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if timeout exists
            String checkQuery = "SELECT date FROM employee_record WHERE date = ? ";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, date);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                 String insertQuery = "UPDATE public.employee_record SET hoursworked=? WHERE timein = ?;";
                PreparedStatement updatetStmt = conn.prepareStatement(insertQuery);
                updatetStmt.setString(1, hrswork);
                updatetStmt.setString(2, date);
                updatetStmt.executeUpdate();
                return true;
            } else {
                
              
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
       }
       
        public static String toutExist(String date, String id) {
//          

        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if timeout exists
            String checkQuery = "SELECT hoursworked FROM employee_record WHERE date = ? AND employeeid = ? ";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, date);
            checkStmt.setString(2, id);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                String text = rs.getString(1);
                return text;
               
            } else {
                
              
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
         return null;
       }
       
     public static String idCheker(String uname) {
//          

        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if timeout exists
            String checkQuery = "SELECT employeeid FROM users_acc WHERE username = ? ";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, uname);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                String idtext = rs.getString(1);
                return idtext;
          
            } else {
                
              
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
         return null;
       }
     
      public static boolean idChekerbol(String id) {
//          

        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if timeout exists
            String checkQuery = "SELECT employeeid FROM users_acc WHERE employeeid = ? ";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, id);
            ResultSet rs = checkStmt.executeQuery();

            if(rs.next()) {
               
                return true;
          
            }else {
                
              
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
         return false;
       }
     
      public static String setUp( String id,String date) {
//          

        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if timeout exists
            String checkQuery = "SELECT date FROM employee_record WHERE employeeid = ? AND date = ? ";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, id);
            checkStmt.setString(2, date);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                String idtext = rs.getString(1);
                return idtext;
            } else {
                
              
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
         return null;
      }
      
      public static boolean addRecod(String date,String in,String out,String hr,String id) {
//        


        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if timeout exists
            String checkQuery = "SELECT date FROM employee_record WHERE date = ? AND employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, date);
            checkStmt.setString(2, id);
            ResultSet rs = checkStmt.executeQuery();

            if(rs.next()) {
                return true;
            } else {
                String insertQuery = "INSERT INTO public.employee_record(date, timein, timeout, hoursworked, employeeid) VALUES (?, ?, ?, ?, ?);";
                PreparedStatement insertstmnt = conn.prepareStatement(insertQuery);
                insertstmnt.setString(1, date);
                insertstmnt.setString(2, in);
                insertstmnt.setString(3, out);
                insertstmnt.setString(4, hr);
                insertstmnt.setString(5, id);
                insertstmnt.executeUpdate();
              
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        
      }
      
      public static String profileGender(String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT gender FROM users_acc WHERE employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text = rs.getString(1);
                 return text;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
      
      public static String profileEmail(String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT email FROM users_acc WHERE employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text = rs.getString(1);
                 return text;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
      
      public static String profileUser(String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT username FROM users_acc WHERE employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text = rs.getString(1);
                 return text;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
      
      public static String gendercheck(String uname) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT gender FROM users_acc WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, uname);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text = rs.getString(1);
                 return text;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
      
       public static String delaccusingid(String id) {
//          

        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if timeout exists
            String checkQuery = "SELECT firstname,lastname FROM users_acc WHERE employeeid = ? ";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, id);
            ResultSet rs = checkStmt.executeQuery();

            if(rs.next()) {
               
                String text1 = rs.getString("firstname");
                String text2 = rs.getString("lastname");
                String text = text1 + " "+text2;
                 return text;
          
//            }else {
//                
//              
//                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
         return null;
       }
       
       public static String recordname(String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT firstname,lastname FROM users_acc WHERE employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text1 = rs.getString("firstname");
                 String text2 = rs.getString("lastname");
                 String text = text1 + " " + text2;
                 return text;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
       
       public static String newname(String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT firstname,lastname FROM users_acc WHERE employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 String text1 = rs.getString("firstname");
                  String text2 = rs.getString("lastname");
                  String text = text1 + " "+ text2;
                 return text;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
       
       public static String newnamelast(String id) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT lastname FROM users_acc WHERE employeeid = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                // User exists with the provided role = admin
                 
                 String text2 = rs.getString(1);
                 return text2;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // User exists with the provided role = user
        return null;
     }
       
         public static boolean employeeLeave(String timein,String tout,String hrswrk,String date,String id) {
//        


        try (Connection conn = DatabaseConnector.getConnection()) {
            // Check if timeout exists
            String checkQuery = "SELECT date,timein FROM employee_record WHERE date = ? AND employeeid = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, date);
            checkStmt.setString(2, id);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                String updateQuery = "UPDATE public.employee_record SET timeout=?, hoursworked=? WHERE date = ? AND employeeid = ?";
                PreparedStatement updatetStmt = conn.prepareStatement(updateQuery);
                updatetStmt.setString(1, tout);
                updatetStmt.setString(2, hrswrk);
                updatetStmt.setString(3, date);
                updatetStmt.setString(4, id);
                updatetStmt.executeUpdate();
                return true;
            } else {
                String InsertQuery = "INSERT INTO public.employee_record (date, timein, timeout, hoursworked, employeeid) VALUES ( ?, ?, ?, ?, ?)";
                PreparedStatement inserttStmt = conn.prepareStatement(InsertQuery);
                inserttStmt.setString(1, date);
                inserttStmt.setString(2, timein);
                inserttStmt.setString(3, tout);
                inserttStmt.setString(4, hrswrk);
                 inserttStmt.setString(5, id);
                inserttStmt.executeUpdate();
              
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        
        
    }
         
         public static String reqList(String date) {
            try (Connection conn = DatabaseConnector.getConnection()) {
                String query = "SELECT * FROM employee_requests WHERE date = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, date);
                ResultSet rs = pstmt.executeQuery();

                AdminDashboard admin = new AdminDashboard();
                if (rs.next()){
//                    // User exists with the provided role = admin
                     String text1 = rs.getString("fullname");
                     String text2 = rs.getString("employee_id");
                     String text3 = rs.getString("request");
                     String text = text1+" "+text2+" "+text3;
                     return text;
                     
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // User exists with the provided role = user
           return null;
         }
         
         
         
}


