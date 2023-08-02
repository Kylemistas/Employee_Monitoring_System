/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1.LoginForm;

import com.mycompany.mavenproject1.LoginForm.ConfirmForgot;
import com.mycompany.mavenproject1.LoginForm.Login;
import com.mycompany.mavenproject1.ConnectionQuery.DataHandler;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author John Kyle G. Mistas
 */
public class ForgotPassForm extends javax.swing.JFrame {

    /**
     * Creates new form ForgotPassForm
     */
    public ForgotPassForm() {
        initComponents();
        error.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        passwordText1 = new javax.swing.JPasswordField();
        error = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        first = new javax.swing.JLabel();
        last = new javax.swing.JLabel();
        Exitbtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel1.setText("UserName");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 300, 80, 16);

        userText.setFont(new java.awt.Font("Segoe UI Emoji", 3, 12)); // NOI18N
        userText.setForeground(new java.awt.Color(204, 204, 204));
        userText.setText("UserName");
        userText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 51), 2));
        userText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userTextFocusLost(evt);
            }
        });
        getContentPane().add(userText);
        userText.setBounds(100, 320, 200, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel3.setText("New Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 360, 90, 16);

        passwordText.setFont(new java.awt.Font("Segoe UI Emoji", 3, 12)); // NOI18N
        passwordText.setForeground(new java.awt.Color(204, 204, 204));
        passwordText.setText("New Password");
        passwordText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 51), 2));
        passwordText.setCaretColor(new java.awt.Color(153, 255, 102));
        passwordText.setEchoChar('\u0000');
        passwordText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordTextFocusLost(evt);
            }
        });
        getContentPane().add(passwordText);
        passwordText.setBounds(100, 380, 200, 30);

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox1.setText("show password");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(100, 480, 130, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel4.setText("Re-enter New Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 420, 140, 16);

        passwordText1.setFont(new java.awt.Font("Segoe UI Emoji", 3, 12)); // NOI18N
        passwordText1.setForeground(new java.awt.Color(204, 204, 204));
        passwordText1.setText("Re-enter New Password");
        passwordText1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 51), 2));
        passwordText1.setCaretColor(new java.awt.Color(153, 255, 102));
        passwordText1.setEchoChar('\u0000');
        passwordText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordText1FocusLost(evt);
            }
        });
        getContentPane().add(passwordText1);
        passwordText1.setBounds(100, 440, 200, 30);

        error.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 0));
        error.setText("error");
        getContentPane().add(error);
        error.setBounds(120, 530, 120, 16);

        jButton1.setBackground(null);
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\1exchange.png")); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 500, 50, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel2.setText("Change Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 230, 170, 30);

        first.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        first.setText("First");
        getContentPane().add(first);
        first.setBounds(130, 270, 100, 16);

        last.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        last.setText("Last");
        getContentPane().add(last);
        last.setBounds(200, 270, 90, 17);

        Exitbtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\1button.png")); // NOI18N
        Exitbtn.setContentAreaFilled(false);
        Exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitbtnActionPerformed(evt);
            }
        });
        getContentPane().add(Exitbtn);
        Exitbtn.setBounds(370, 0, 30, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\3GFIILOGO-1.png")); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(100, 0, 210, 180);

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 102));
        jLabel15.setText("green");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(130, 170, 70, 32);

        jLabel16.setFont(new java.awt.Font("Segoe UI Symbol", 1, 26)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 51));
        jLabel16.setText("future");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(190, 170, 100, 30);

        jLabel17.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel17.setText("Innovation, Inc.");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(140, 190, 170, 32);

        setSize(new java.awt.Dimension(414, 607));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTextFocusGained
        // TODO add your handling code here:
        Border bnorm = BorderFactory.createLineBorder(Color.gray);
        userText.setBorder(bnorm);
        error.setText("");
        if(userText.getText().equals("UserName")){
            userText.setText(null);
            userText.requestFocus();
            userText.setForeground(Color.BLACK);
            
        }
    }//GEN-LAST:event_userTextFocusGained

    private void userTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTextFocusLost
        // TODO add your handling code here:
        if(userText.getText().length()==0){
            userText.setText("UserName");
            userText.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_userTextFocusLost

    private void passwordTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextFocusGained
        // TODO add your handling code here:
        Border bnorm = BorderFactory.createLineBorder(Color.gray);
        passwordText.setBorder(bnorm);
        error.setText("");
        if(passwordText.getText().equals("New Password")){
            passwordText.setText(null);
            passwordText.requestFocus();
            passwordText.setEchoChar('*');
            passwordText.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_passwordTextFocusGained

    private void passwordTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextFocusLost
        //         TODO add your handling code here:
        if(passwordText.getText().length()==0){
            passwordText.setText("New Password");
            passwordText.setEchoChar((char)0);
            passwordText.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_passwordTextFocusLost

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            passwordText.setEchoChar((char) 0);
             passwordText1.setEchoChar((char) 0);
            
        } else {
            passwordText.setEchoChar('*');
            passwordText1.setEchoChar('*');

        }

    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void passwordText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordText1FocusGained
        // TODO add your handling code here:
         Border bnorm = BorderFactory.createLineBorder(Color.gray);
        passwordText1.setBorder(bnorm);
        error.setText("");
        if(passwordText1.getText().equals("Re-enter New Password")){
            passwordText1.setText(null);
            passwordText1.requestFocus();
            passwordText1.setEchoChar('*');
            passwordText1.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_passwordText1FocusGained

    private void passwordText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordText1FocusLost
        // TODO add your handling code here:
        if(passwordText1.getText().length()==0){
            passwordText1.setText("Re-enter New Password");
            passwordText1.setEchoChar((char)0);
            passwordText1.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_passwordText1FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Border bnorm = BorderFactory.createLineBorder(Color.gray);
          Border bred = BorderFactory.createLineBorder(Color.red);
        String user = userText.getText();
        String pass = passwordText.getText();
        String pass2 = passwordText1.getText();
        
        if(user.equals("UserName") && pass.equals("New Password") && pass2.equals("Re-enter New Password")){
             userText.setBorder(bred);
             passwordText.setBorder(bred);
             passwordText1.setBorder(bred);
            error.setText("Empty Input");
             error.setVisible(true);
            
        }else if(user.equals("") && pass.equals("") && pass2.equals("")){
             userText.setBorder(bred);
             passwordText.setBorder(bred);
             passwordText1.setBorder(bred);
             error.setText("Empty Input");
             error.setVisible(true);
             
        }else if(user.equals("UserName") ){
             userText.setBorder(bred);
             passwordText.setBorder(bnorm);
             passwordText1.setBorder(bnorm);
             error.setText("Required UserName");
             error.setVisible(true);
             
        }else if(user.equals("") ){
             userText.setBorder(bred);
             passwordText.setBorder(bnorm);
             passwordText1.setBorder(bnorm);
            error.setText("Required UserName");
            error.setVisible(true);
            
        }else if( pass.equals("New Password")){
             userText.setBorder(bnorm);
             passwordText.setBorder(bred);
             passwordText1.setBorder(bnorm);
            error.setText("Required New Password");
            error.setVisible(true);
            
        }else if( pass.equals("")){
             userText.setBorder(bnorm);
             passwordText.setBorder(bred);
             passwordText1.setBorder(bnorm);
            error.setText("Required New Password");
            error.setVisible(true);
            
        }else if( pass2.equals("Re-enter New Password")){
             userText.setBorder(bnorm);
             passwordText.setBorder(bnorm);
             passwordText1.setBorder(bred);
            error.setText("Required RE-enter New Password");
            error.setVisible(true);
            
        }else if( pass2.equals("")){
            userText.setBorder(bnorm);
             passwordText.setBorder(bnorm);
             passwordText1.setBorder(bred);
            error.setText("Required RE-enter New Password");
            error.setVisible(true);
             
        }else{
             if(pass.equals(pass2)){
                 userText.setBorder(bnorm);
                 passwordText.setBorder(bnorm);
                 passwordText1.setBorder(bnorm);
                 boolean accExist = DataHandler.changePass(user, pass);
                 if(accExist){
                    DataHandler.changePass(user, pass);
                    int ans =  JOptionPane.showConfirmDialog(null, "Are you Sure?","Message",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(ans == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null,"Change Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
                        
                        dispose();
                        Login loginback = new Login();
                        loginback.setVisible(true);
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(null,"Change Unsuccessfully","Message",JOptionPane.ERROR_MESSAGE);
                        
                        dispose();
                        Login loginback = new Login();
                        loginback.setVisible(true);
                    }
                   }
             }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        // TODO add your handling code here:
       if (jCheckBox1.isSelected()) {
          
            passwordText.setEchoChar((char) 0);
             passwordText1.setEchoChar((char) 0);
            
        } else {
            passwordText.setEchoChar('*');
            passwordText1.setEchoChar('*');

        }

    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void ExitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitbtnActionPerformed
        // TODO add your handling code here:
        ConfirmForgot forg = new ConfirmForgot();
        forg.setVisible(true);
        dispose();
    }//GEN-LAST:event_ExitbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForgotPassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exitbtn;
    private javax.swing.JLabel error;
    public javax.swing.JLabel first;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel last;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JPasswordField passwordText1;
    private javax.swing.JTextField userText;
    // End of variables declaration//GEN-END:variables
}
