package com.mycompany.mavenproject1;





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author John Kyle G. Mistas
 */
public class CheckInput {
    public static boolean checkInput(String user, String password) {
        if(user.equals("admin") && password.equals("1234")) {
            return true;
        } else {
            return false;
        }
    }
}
