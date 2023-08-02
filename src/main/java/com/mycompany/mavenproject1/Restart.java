/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.LoadingSplash.Splash;
import com.mycompany.mavenproject1.LoginForm.Login;

/**
 *
 * @author John Kyle G. Mistas
 */
public class Restart {
    public void doSomething() {
        // Create an instance of the 'Splash' class (assuming 'Splash' is a subclass of JFrame)
        Splash openLog = new Splash();

        // Set the 'Splash' frame as visible to display it on the screen
        openLog.setVisible(true);

        // Declare an integer variable to be used for the loop
        int i = 0;

        try {
            // Loop from 0 to 100 (inclusive)
            for (i = 0; i <= 100; i++) {
                // Pause the execution for 40 milliseconds (to simulate progress update delay)
                Thread.sleep(40);

                // Update the 'progress' JTextComponent in 'openLog' with the current progress value
                openLog.progress.setText(Integer.toString(i) + "%");

                // Set the progress value of the progress bar in 'openLog' with the current progress value
                openLog.bar.setValue(i);

                // Check if the progress has reached 100%
                if (i == 100) {
                    // If the progress is 100%, close (dispose) the 'Splash' frame
                    openLog.setVisible(false);
                    // Create an instance of the 'Login' class (assuming 'Login' is a subclass of JFrame)
                    Login newLog = new Login();

                    // Set the 'Login' frame as visible to display it on the screen
                    newLog.setVisible(true);
                }
            }
        } catch (Exception e) {
            // Catch any exceptions that might occur during the execution (ignored in this case)
        }

            }
}
