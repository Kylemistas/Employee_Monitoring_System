/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1.RegisterForm;


import com.mycompany.mavenproject1.LoginForm.Login;
import com.mycompany.mavenproject1.ConnectionQuery.DataHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author John Kyle G. Mistas
 */
public class Register2acc extends javax.swing.JFrame {
        private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        private static final String SPECIAL_CHARACTERS_REGEX = ".*[^a-zA-Z0-9].*";
    /**
     * Creates new form Register2acc
     */
    public Register2acc() {
        
        initComponents();
        
        
    }
    
   
    
    
        public static boolean validateEmail(String email) {
            Pattern pattern = Pattern.compile(EMAIL_REGEX);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        
      
    
    public static boolean validateInput(String input, int minLength) {
        // Check minimum length
        if (input.length() < minLength) {
            return false;
        }
        
        // Check for special characters
//        if(Pattern.matches(SPECIAL_CHARACTERS_REGEX, input)) {
//            return true;
//        }
        
        return true;
    }
    
     public static boolean validateInputNoCharOrNumber(String input) {
        // Check for special characters
        // Check for special characters and numbers
        if (Pattern.matches(SPECIAL_CHARACTERS_REGEX, input) || containsNumbers(input)) {
            return false;
        }

        return true;
    }
     
     // Helper method to check if the input contains numbers
private static boolean containsNumbers(String input) {
    for (char c : input.toCharArray()) {
        if (Character.isDigit(c)) {
            return true;
        }
    }
    return false;
}
     
     public void aboutUs(){
          dispose();
        AboutInfo info = new AboutInfo();
        info.aboutUsArea.setText("""
                                 
                                 A corporation fully committed towards a green and sustainable development. 
                                 Taking from its cue from the Philippine Renewable Energy Program, 
                                 GFII built and operated a large-scale bioethanol and cogeneration plant in San Mariano, 
                                 Isabela Ecofuel Agro-Industrial Ecozone.
                                 
                                 GFII maintains sugarcane growership contracts with 4, 000 farmer families in 
                                 Isabela Province thus affecting 20, 000 Filipinos. 
                                 The plant operations provide employment for 15, 000 workers having a tremendous positive impact to the local community.""");
        info.missionArea.setText("""
                                 
                                 GREEN COMMITMENT
                                 
                                 GFII operates a state-of-the-art bioethanol and cogeneration plant to produce alternative and 
                                 renewable energy while simultaneously creating frsh opportunities for 
                                 sustainable rural development. Partnering with regional farmers, 
                                 its effors are focused on developing the next generation of biofuels with 
                                 the enforcement of appropriate regulations pertinent to energy production from renewable feedstock 
                                 and other agricultural by-products.
                                 
                                 GREEN FUEL
                                 
                                 True to its green commitment and pursuant to the Philippine Renewable Energy Pan, 
                                 GFII’s bioethanol plant utilizes local sugarcane resources. 
                                 The plant producers anhydrous alcohol commonly called 
                                 bioethanol is the “E” component in gasoline that displaces fossil fuel. 
                                 The production of biofuel is the key to curtailing our reliance on foreign oil 
                                 as well as rectifying the environmental impacts of energy use.
                                 
                                 GREEN POWER
                                 
                                 The cogeneration plant generates low-carbon alternative energy that powers up the national 
                                 electricity grid to enhance energy security and sel-sufficiency.
                                 
                                 GREEN FUTURE
                                 
                                 Merging economic development and social responsibility, GFII is working towards ensuring a 
                                 GREEN FUTURE for the Philippines and the world. By encouraging the aggregate use of energy 
                                 crops to create various agro-industries, the cogeneration plant seeks to revitalize 
                                 and improve the level of work and income among rural economies.
                                 """);
        info.vissionArea.setText("""
                                 
                                    Green Future Innovations, Inc. (GFII) aims to become 
                                a world-class provider of alternative and 
                                renewable energy that is environmentally friendly. 
                                In its endeavor to reduce energy on imported fuel, 
                                GFII aspires to bring about nationwide energy security 
                                and self-sufficiency.It seeks to create rural wealth and employment 
                                by using environmentally sound technology and by maximizing 
                                local resource and manpower. GFII seeks to deliver a sustainable, 
                                low-carbon alternative with proper assessment 
                                of Natural and Ecological Conservation.
                                """);
        info.setVisible(true);
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        gender = new javax.swing.ButtonGroup();
        genderuser = new javax.swing.ButtonGroup();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        fnametxt = new javax.swing.JTextField();
        Lnane1 = new javax.swing.JLabel();
        Lnane = new javax.swing.JLabel();
        maleuser = new javax.swing.JRadioButton();
        femaleuser = new javax.swing.JRadioButton();
        lnameText = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        userText = new javax.swing.JLabel();
        userText1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        confirmpassword = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        registerUser = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        adminreg = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        empid1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        userreg = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fname1 = new javax.swing.JLabel();
        fnametxt1 = new javax.swing.JTextField();
        Lnane2 = new javax.swing.JLabel();
        Lnane3 = new javax.swing.JLabel();
        malebtn = new javax.swing.JRadioButton();
        femalebtn = new javax.swing.JRadioButton();
        lnameText1 = new javax.swing.JTextField();
        email1 = new javax.swing.JLabel();
        emailText1 = new javax.swing.JTextField();
        userText2 = new javax.swing.JLabel();
        userText3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordText1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        confirmpassword1 = new javax.swing.JPasswordField();
        jCheckBox2 = new javax.swing.JCheckBox();
        clearadmin = new javax.swing.JButton();
        registerbtn1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        empid2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 0, new java.awt.Color(0, 0, 0)));
        getContentPane().add(jPanel8);
        jPanel8.setBounds(0, 0, 610, 20);

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 153));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setText("Register");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 30, 126, 30);

        fname.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        fname.setText("First Name");
        jPanel1.add(fname);
        fname.setBounds(30, 90, 60, 16);

        fnametxt.setBackground(null);
        fnametxt.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        fnametxt.setForeground(new java.awt.Color(0, 102, 0));
        fnametxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        fnametxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fnametxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fnametxtFocusLost(evt);
            }
        });
        fnametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnametxtActionPerformed(evt);
            }
        });
        jPanel1.add(fnametxt);
        fnametxt.setBounds(30, 110, 196, 30);

        Lnane1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lnane1.setText("Last Name");
        jPanel1.add(Lnane1);
        Lnane1.setBounds(30, 150, 60, 16);

        Lnane.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lnane.setText("Gender");
        jPanel1.add(Lnane);
        Lnane.setBounds(180, 150, 50, 16);

        genderuser.add(maleuser);
        maleuser.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        maleuser.setForeground(new java.awt.Color(0, 102, 0));
        maleuser.setText("Male");
        maleuser.setActionCommand("Male");
        maleuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleuserActionPerformed(evt);
            }
        });
        jPanel1.add(maleuser);
        maleuser.setBounds(170, 170, 60, 21);
        maleuser.getAccessibleContext().setAccessibleDescription("male");

        genderuser.add(femaleuser);
        femaleuser.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        femaleuser.setForeground(new java.awt.Color(0, 102, 0));
        femaleuser.setText("Female");
        femaleuser.setActionCommand("Female");
        femaleuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleuserActionPerformed(evt);
            }
        });
        jPanel1.add(femaleuser);
        femaleuser.setBounds(170, 190, 98, 20);

        lnameText.setBackground(null);
        lnameText.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lnameText.setForeground(new java.awt.Color(0, 102, 0));
        lnameText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        lnameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lnameTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lnameTextFocusLost(evt);
            }
        });
        lnameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameTextActionPerformed(evt);
            }
        });
        jPanel1.add(lnameText);
        lnameText.setBounds(30, 170, 130, 30);

        email.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        email.setText("e-mail");
        jPanel1.add(email);
        email.setBounds(30, 210, 60, 16);

        emailText.setBackground(null);
        emailText.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        emailText.setForeground(new java.awt.Color(0, 102, 0));
        emailText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        emailText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailTextFocusLost(evt);
            }
        });
        emailText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextActionPerformed(evt);
            }
        });
        jPanel1.add(emailText);
        emailText.setBounds(30, 230, 196, 30);

        userText.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        userText.setText("UserName");
        jPanel1.add(userText);
        userText.setBounds(30, 330, 58, 16);

        userText1.setBackground(null);
        userText1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        userText1.setForeground(new java.awt.Color(0, 102, 0));
        userText1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        userText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userText1FocusLost(evt);
            }
        });
        userText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userText1ActionPerformed(evt);
            }
        });
        jPanel1.add(userText1);
        userText1.setBounds(30, 350, 196, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel4.setText("Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 390, 70, 17);

        passwordText.setBackground(null);
        passwordText.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        passwordText.setForeground(new java.awt.Color(0, 102, 0));
        passwordText.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        passwordText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordTextFocusLost(evt);
            }
        });
        passwordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });
        jPanel1.add(passwordText);
        passwordText.setBounds(30, 410, 196, 33);

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel3.setText("Confrim Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 450, 115, 17);

        confirmpassword.setBackground(null);
        confirmpassword.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        confirmpassword.setForeground(new java.awt.Color(0, 102, 0));
        confirmpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        confirmpassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmpasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmpasswordFocusLost(evt);
            }
        });
        confirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpasswordActionPerformed(evt);
            }
        });
        jPanel1.add(confirmpassword);
        confirmpassword.setBounds(30, 470, 196, 33);

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox1.setText("Show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(30, 510, 120, 20);

        jButton1.setBackground(new java.awt.Color(102, 255, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(160, 540, 80, 27);

        registerUser.setBackground(new java.awt.Color(102, 255, 51));
        registerUser.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registerUser.setText("Register");
        registerUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerUserActionPerformed(evt);
            }
        });
        jPanel1.add(registerUser);
        registerUser.setBounds(20, 560, 80, 27);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(0, 255, 204));
        jPanel6.setLayout(null);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\3GFIILOGO-1.png")); // NOI18N
        jPanel6.add(jLabel7);
        jLabel7.setBounds(60, 70, 210, 210);

        jButton4.setBackground(null);
        jButton4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(204, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\2logout.png")); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4);
        jButton4.setBounds(280, 20, 30, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel12.setText("Register As");
        jPanel6.add(jLabel12);
        jLabel12.setBounds(110, 560, 100, 25);

        adminreg.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        adminreg.setForeground(new java.awt.Color(0, 102, 0));
        adminreg.setText("ADMIN");
        adminreg.setBorder(null);
        adminreg.setContentAreaFilled(false);
        adminreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminregActionPerformed(evt);
            }
        });
        jPanel6.add(adminreg);
        adminreg.setBounds(100, 590, 110, 30);

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 255, 102));
        jLabel15.setText("green");
        jPanel6.add(jLabel15);
        jLabel15.setBounds(90, 280, 70, 32);

        jLabel16.setFont(new java.awt.Font("Segoe UI Symbol", 1, 26)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 51));
        jLabel16.setText("future");
        jPanel6.add(jLabel16);
        jLabel16.setBounds(150, 280, 100, 30);

        jLabel17.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel17.setText("Innovation, Inc.");
        jPanel6.add(jLabel17);
        jLabel17.setBounds(100, 300, 170, 32);

        jButton2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 153, 0));
        jButton2.setText("ABOUT US");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);
        jButton2.setBounds(130, 400, 70, 20);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(290, 0, 320, 850);

        jLabel11.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel11.setText("Emoplyee ID");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 270, 80, 16);

        empid1.setBackground(null);
        empid1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        empid1.setForeground(new java.awt.Color(0, 102, 0));
        empid1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        empid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empid1ActionPerformed(evt);
            }
        });
        jPanel1.add(empid1);
        empid1.setBounds(30, 290, 200, 30);

        jLabel14.setFont(new java.awt.Font("Stencil", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 51));
        jLabel14.setText("USER");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(110, 50, 43, 30);

        jTabbedPane1.addTab("User", jPanel1);

        jPanel2.setLayout(null);

        jPanel3.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(0, 255, 204));
        jPanel7.setLayout(null);

        jButton5.setBackground(null);
        jButton5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(204, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\2logout.png")); // NOI18N
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton5);
        jButton5.setBounds(280, 20, 30, 30);

        userreg.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        userreg.setForeground(new java.awt.Color(0, 102, 0));
        userreg.setText("USER");
        userreg.setBorderPainted(false);
        userreg.setContentAreaFilled(false);
        userreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userregActionPerformed(evt);
            }
        });
        jPanel7.add(userreg);
        userreg.setBounds(100, 590, 110, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel1.setText("Register As");
        jPanel7.add(jLabel1);
        jLabel1.setBounds(110, 560, 100, 25);

        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\3GFIILOGO-1.png")); // NOI18N
        jPanel7.add(jLabel18);
        jLabel18.setBounds(60, 70, 210, 210);

        jLabel19.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 255, 102));
        jLabel19.setText("green");
        jPanel7.add(jLabel19);
        jLabel19.setBounds(90, 280, 70, 32);

        jLabel20.setFont(new java.awt.Font("Segoe UI Symbol", 1, 26)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 51));
        jLabel20.setText("future");
        jPanel7.add(jLabel20);
        jLabel20.setBounds(150, 280, 100, 30);

        jLabel21.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel21.setText("Innovation, Inc.");
        jPanel7.add(jLabel21);
        jLabel21.setBounds(100, 300, 170, 32);

        jButton6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 153, 0));
        jButton6.setText("ABOUT US");
        jButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton6);
        jButton6.setBounds(130, 400, 70, 20);

        jPanel3.add(jPanel7);
        jPanel7.setBounds(290, 0, 320, 620);

        jLabel5.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 51));
        jLabel5.setText("Register");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(70, 30, 126, 30);

        fname1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        fname1.setText("First Name");
        jPanel3.add(fname1);
        fname1.setBounds(30, 90, 60, 16);

        fnametxt1.setBackground(null);
        fnametxt1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        fnametxt1.setForeground(new java.awt.Color(0, 102, 0));
        fnametxt1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        fnametxt1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fnametxt1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fnametxt1FocusLost(evt);
            }
        });
        fnametxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnametxt1ActionPerformed(evt);
            }
        });
        jPanel3.add(fnametxt1);
        fnametxt1.setBounds(30, 110, 196, 30);

        Lnane2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lnane2.setText("Last Name");
        jPanel3.add(Lnane2);
        Lnane2.setBounds(30, 150, 60, 16);

        Lnane3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        Lnane3.setText("Gender");
        jPanel3.add(Lnane3);
        Lnane3.setBounds(180, 150, 50, 16);

        gender.add(malebtn);
        malebtn.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        malebtn.setForeground(new java.awt.Color(0, 102, 0));
        malebtn.setText("Male");
        malebtn.setActionCommand("Male");
        malebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                malebtnActionPerformed(evt);
            }
        });
        jPanel3.add(malebtn);
        malebtn.setBounds(170, 170, 60, 21);

        gender.add(femalebtn);
        femalebtn.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        femalebtn.setForeground(new java.awt.Color(0, 102, 0));
        femalebtn.setText("Female");
        femalebtn.setActionCommand("Female");
        femalebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femalebtnActionPerformed(evt);
            }
        });
        jPanel3.add(femalebtn);
        femalebtn.setBounds(170, 190, 98, 20);

        lnameText1.setBackground(null);
        lnameText1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lnameText1.setForeground(new java.awt.Color(0, 102, 0));
        lnameText1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        lnameText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lnameText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lnameText1FocusLost(evt);
            }
        });
        lnameText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameText1ActionPerformed(evt);
            }
        });
        jPanel3.add(lnameText1);
        lnameText1.setBounds(30, 170, 130, 30);

        email1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        email1.setText("e-mail");
        jPanel3.add(email1);
        email1.setBounds(30, 210, 60, 16);

        emailText1.setBackground(null);
        emailText1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        emailText1.setForeground(new java.awt.Color(0, 102, 0));
        emailText1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        emailText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailText1FocusLost(evt);
            }
        });
        emailText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailText1ActionPerformed(evt);
            }
        });
        jPanel3.add(emailText1);
        emailText1.setBounds(30, 230, 196, 30);

        userText2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        userText2.setText("UserName");
        jPanel3.add(userText2);
        userText2.setBounds(30, 330, 58, 16);

        userText3.setBackground(null);
        userText3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        userText3.setForeground(new java.awt.Color(0, 102, 0));
        userText3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        userText3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userText3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userText3FocusLost(evt);
            }
        });
        userText3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userText3ActionPerformed(evt);
            }
        });
        jPanel3.add(userText3);
        userText3.setBounds(30, 350, 196, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel6.setText("Password");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(30, 390, 70, 17);

        passwordText1.setBackground(null);
        passwordText1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        passwordText1.setForeground(new java.awt.Color(0, 102, 0));
        passwordText1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        passwordText1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordText1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordText1FocusLost(evt);
            }
        });
        passwordText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordText1ActionPerformed(evt);
            }
        });
        jPanel3.add(passwordText1);
        passwordText1.setBounds(30, 410, 196, 33);

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel8.setText("Confrim Password");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(30, 450, 115, 17);

        confirmpassword1.setBackground(null);
        confirmpassword1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        confirmpassword1.setForeground(new java.awt.Color(0, 102, 0));
        confirmpassword1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        confirmpassword1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmpassword1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmpassword1FocusLost(evt);
            }
        });
        confirmpassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpassword1ActionPerformed(evt);
            }
        });
        jPanel3.add(confirmpassword1);
        confirmpassword1.setBounds(30, 470, 196, 33);

        jCheckBox2.setBackground(null);
        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox2.setText("Show password");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox2);
        jCheckBox2.setBounds(30, 510, 120, 20);

        clearadmin.setBackground(new java.awt.Color(102, 255, 51));
        clearadmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearadmin.setText("Clear");
        clearadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearadminActionPerformed(evt);
            }
        });
        jPanel3.add(clearadmin);
        clearadmin.setBounds(160, 540, 80, 27);

        registerbtn1.setBackground(new java.awt.Color(102, 255, 51));
        registerbtn1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        registerbtn1.setText("Register");
        registerbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerbtn1ActionPerformed(evt);
            }
        });
        jPanel3.add(registerbtn1);
        registerbtn1.setBounds(20, 560, 80, 27);

        jLabel10.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel10.setText("Admin ID");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(30, 270, 80, 16);

        empid2.setBackground(null);
        empid2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        empid2.setForeground(new java.awt.Color(0, 102, 0));
        empid2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        empid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empid2ActionPerformed(evt);
            }
        });
        jPanel3.add(empid2);
        empid2.setBounds(30, 290, 200, 30);

        jLabel13.setFont(new java.awt.Font("Stencil", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 204, 51));
        jLabel13.setText("ADMIN");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(110, 50, 43, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 610, 620);

        jTabbedPane1.addTab("Admin", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 0, 610, 660);

        setSize(new java.awt.Dimension(621, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnametxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnametxtFocusGained
        // TODO add your handling code here:
        //         if(fnameText.getText().equals("First Name")){
            //            fnameText.setText(null);
            //            fnameText.requestFocus();
            //        }
    }//GEN-LAST:event_fnametxtFocusGained

    private void fnametxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnametxtFocusLost
        // TODO add your handling code here:
        //        if(fnameText.getText().length()==0){
            //            fnameText.setText("First Name");
            //        }
    }//GEN-LAST:event_fnametxtFocusLost

    private void fnametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnametxtActionPerformed
        // TODO add your handling code here:
//        registerUser.doClick();

    }//GEN-LAST:event_fnametxtActionPerformed

    private void maleuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleuserActionPerformed
        // TODO add your handling code here:
//         registerUser.doClick();
    }//GEN-LAST:event_maleuserActionPerformed

    private void femaleuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleuserActionPerformed
        // TODO add your handling code here:
         registerUser.doClick();
    }//GEN-LAST:event_femaleuserActionPerformed

    private void lnameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lnameTextFocusGained
        // TODO add your handling code here:
        //        if(lnameText.getText().equals("Last Name")){
            //            lnameText.setText(null);
            //            lnameText.requestFocus();
            //        }
    }//GEN-LAST:event_lnameTextFocusGained

    private void lnameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lnameTextFocusLost
        // TODO add your handling code here:
        //        if(lnameText.getText().length()==0){
            //            lnameText.setText("Last Name");
            //        }

    }//GEN-LAST:event_lnameTextFocusLost

    private void lnameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameTextActionPerformed
        // TODO add your handling code here:
        registerUser.doClick();
    }//GEN-LAST:event_lnameTextActionPerformed

    private void emailTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFocusGained
        // TODO add your handling code here:
        //        if(emailText.getText().equals("juan@gmail.com")){
            //            emailText.setText(null);
            //            emailText.requestFocus();
            //        }
    }//GEN-LAST:event_emailTextFocusGained

    private void emailTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFocusLost
        // TODO add your handling code here:
        //        if(emailText.getText().length()==0){
            //            emailText.setText("juan@gmail.com");
            //        }
    }//GEN-LAST:event_emailTextFocusLost

    private void emailTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextActionPerformed
        // TODO add your handling code here:
        registerUser.doClick();
    }//GEN-LAST:event_emailTextActionPerformed

    private void userText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userText1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_userText1FocusGained

    private void userText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userText1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_userText1FocusLost

    private void userText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userText1ActionPerformed
        // TODO add your handling code here:
        registerUser.doClick();
    }//GEN-LAST:event_userText1ActionPerformed

    private void passwordTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextFocusGained
        // TODO add your handling code here:
        //        if(passwordText.getText().equals("Password")){
            //            passwordText.setText(null);
            ////            passwordText.requestFocus();
            //            passwordText.setEchoChar('*');
            //        }
    }//GEN-LAST:event_passwordTextFocusGained

    private void passwordTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTextFocusLost
        // TODO add your handling code here:
        //        if(passwordText.getText().length()==0){
            //            passwordText.setText("Password");
            //            passwordText.setEchoChar((char)0);
            //        }
    }//GEN-LAST:event_passwordTextFocusLost

    private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextActionPerformed
        // TODO add your handling code here:
        registerUser.doClick();
    }//GEN-LAST:event_passwordTextActionPerformed

    private void confirmpasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmpasswordFocusGained
        // TODO add your handling code here:
        //        if(confirmpassword.getText().equals("Confirm Password")){
            //            confirmpassword.setText(null);
            ////            confirmpassword.requestFocus();
            //            confirmpassword.setEchoChar('*');
            //        }
    }//GEN-LAST:event_confirmpasswordFocusGained

    private void confirmpasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmpasswordFocusLost
        // TODO add your handling code here:
        //        if(confirmpassword.getText().length()==0){
            //            confirmpassword.setText("Confirm Password");
            //             confirmpassword.setEchoChar((char)0);
            //        }
    }//GEN-LAST:event_confirmpasswordFocusLost

    private void confirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpasswordActionPerformed
        // TODO add your handling code here:
        registerUser.doClick();
    }//GEN-LAST:event_confirmpasswordActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            //          passwordText.setEchoChar('*');
            passwordText.setEchoChar((char) 0);
            confirmpassword.setEchoChar((char) 0);
        } else {
            passwordText.setEchoChar('*');
            confirmpassword.setEchoChar('*');

        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        fnametxt.setText("");
        lnameText.setText("");
        emailText.setText("");
        empid1.setText("");
        userText1.setText("");
        passwordText.setText("");
        confirmpassword.setText("");
        genderuser.clearSelection();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void registerUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerUserActionPerformed
        // TODO add your handling code here:
        String user = userText1.getText();
        String password = passwordText.getText();
        String confirm = confirmpassword.getText();
        String email1 = emailText.getText();
        String first = fnametxt.getText();
        String last = lnameText.getText();
        String empid = empid1.getText();
        String role = "user";
        int minLength = 8;
        boolean idExist = DataHandler.idexist(empid);

        if (user.equals("") && password.equals("") && confirm.equals("") && email1.equals("") && first.equals("") && last.equals("") && !maleuser.isSelected() && !femaleuser.isSelected() && email1.equals("") && empid.equals("")) {
            JOptionPane.showMessageDialog(null,"Empty Input","Warning",JOptionPane.ERROR_MESSAGE);
           
        } else if (first.equals("")){
            JOptionPane.showMessageDialog(null,"Required First Name","Warning",JOptionPane.ERROR_MESSAGE);

        } else if(!validateInputNoCharOrNumber (first)){
            JOptionPane.showMessageDialog(null,"First Name can't contain Special/Numeric Characters","Warning",JOptionPane.ERROR_MESSAGE);

        } else if(!validateInputNoCharOrNumber (last)){
            JOptionPane.showMessageDialog(null,"Last Name can't contain Special/Numeric Characters","Warning",JOptionPane.ERROR_MESSAGE);

        }else if (last.equals("")){
            JOptionPane.showMessageDialog(null,"Required Last Name","Warning",JOptionPane.ERROR_MESSAGE);

        }else if (!maleuser.isSelected() && !femaleuser.isSelected()){
            JOptionPane.showMessageDialog(null,"Gender Required","Warning",JOptionPane.ERROR_MESSAGE);

        }else if (email1.equals("")){
            JOptionPane.showMessageDialog(null,"Required Email","Warning",JOptionPane.ERROR_MESSAGE);

        }else if (empid.equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Eployee ID","Warning",JOptionPane.ERROR_MESSAGE);

        } else if (user.equals("")){
            JOptionPane.showMessageDialog(null,"Required UserName","Warning",JOptionPane.ERROR_MESSAGE);

        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(null,"Required Password","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if(user.contains(" ")){
            JOptionPane.showMessageDialog(null,"Username can't contain space ","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if(empid.contains(" ")){
            JOptionPane.showMessageDialog(null,"Employee Id can't contain space ","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if(password.contains(" ")){
            JOptionPane.showMessageDialog(null,"Password Id can't contain space ","Warning",JOptionPane.ERROR_MESSAGE);
                    
        }else if (!validateInputNoCharOrNumber(user)) {
             JOptionPane.showMessageDialog(null, "Username contains special characters and is invalid.","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if (!validateInput(user, minLength)) {
             JOptionPane.showMessageDialog(null, "Invalid Username Minimum 8 character","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if (!validateEmail(email1)) {
             JOptionPane.showMessageDialog(null, "Email is invalid.","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if (!validateInput(password, minLength)) {
             JOptionPane.showMessageDialog(null, "Invalid Password Minimum 8 character","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if(idExist){
             JOptionPane.showMessageDialog(null, "Employee ID Exists Already","Warning",JOptionPane.ERROR_MESSAGE);
        }
        else {
            

            if(password.equals(confirm)){
                String genderidentity = genderuser.getSelection().getActionCommand();
                boolean isExist = DataHandler.registerUser(user,password,first,last,genderidentity,email1,empid,role);

                if(isExist){
                   JOptionPane.showMessageDialog(null, "Username Exists Already","Warning",JOptionPane.ERROR_MESSAGE);

                }else{
                   JOptionPane.showMessageDialog(null, "Account Registered Successfully. ","Message",JOptionPane.INFORMATION_MESSAGE);

                   Login loginback = new Login();
                   loginback.setVisible(true);
                   setVisible(false);

               }


            }else{
                JOptionPane.showMessageDialog(null,"Invalid Input password","Failed",JOptionPane.INFORMATION_MESSAGE);

            }
                    
        }

        

    }//GEN-LAST:event_registerUserActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Login backLog = new Login();
        backLog.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void fnametxt1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnametxt1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fnametxt1FocusGained

    private void fnametxt1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fnametxt1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fnametxt1FocusLost

    private void fnametxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnametxt1ActionPerformed
        // TODO add your handling code here:
//        registerbtn1.doClick();
    }//GEN-LAST:event_fnametxt1ActionPerformed

    private void malebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_malebtnActionPerformed
        // TODO add your handling code here:
//        registerbtn1.doClick();
    }//GEN-LAST:event_malebtnActionPerformed

    private void femalebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femalebtnActionPerformed
        // TODO add your handling code here:
//        registerbtn1.doClick();
    }//GEN-LAST:event_femalebtnActionPerformed

    private void lnameText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lnameText1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameText1FocusGained

    private void lnameText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lnameText1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameText1FocusLost

    private void lnameText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameText1ActionPerformed
        // TODO add your handling code here:
        registerbtn1.doClick();
    }//GEN-LAST:event_lnameText1ActionPerformed

    private void emailText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailText1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_emailText1FocusGained

    private void emailText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailText1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_emailText1FocusLost

    private void emailText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailText1ActionPerformed
        // TODO add your handling code here:
        registerbtn1.doClick();
    }//GEN-LAST:event_emailText1ActionPerformed

    private void userText3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userText3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_userText3FocusGained

    private void userText3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userText3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_userText3FocusLost

    private void userText3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userText3ActionPerformed
        // TODO add your handling code here:
        registerbtn1.doClick();
    }//GEN-LAST:event_userText3ActionPerformed

    private void passwordText1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordText1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordText1FocusGained

    private void passwordText1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordText1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordText1FocusLost

    private void passwordText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordText1ActionPerformed
        // TODO add your handling code here:
        registerbtn1.doClick();
    }//GEN-LAST:event_passwordText1ActionPerformed

    private void confirmpassword1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmpassword1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpassword1FocusGained

    private void confirmpassword1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmpassword1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpassword1FocusLost

    private void confirmpassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpassword1ActionPerformed
        // TODO add your handling code here:
        registerbtn1.doClick();
    }//GEN-LAST:event_confirmpassword1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
         if (jCheckBox2.isSelected()) {
            //          passwordText.setEchoChar('*');
            passwordText1.setEchoChar((char) 0);
            confirmpassword1.setEchoChar((char) 0);
        } else {
            passwordText1.setEchoChar('*');
            confirmpassword1.setEchoChar('*');

        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void clearadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearadminActionPerformed
        // TODO add your handling code here:
        fnametxt1.setText("");
        lnameText1.setText("");
        emailText1.setText("");
        empid2.setText("");
        userText3.setText("");
        passwordText1.setText("");
        confirmpassword1.setText("");
        gender.clearSelection();
    }//GEN-LAST:event_clearadminActionPerformed

    private void registerbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerbtn1ActionPerformed
        // TODO add your handling code here:
        String user = userText3.getText();
        String password = passwordText1.getText();
        String confirm = confirmpassword1.getText();
        String email1 = emailText1.getText();
        String first = fnametxt1.getText();
        String last = lnameText1.getText();
        String empid = empid2.getText();
        String role = "admin";
        String code = "admin1";
        int minLength = 8;
        boolean idExist = DataHandler.idexist(empid);

        if (user.equals("") && password.equals("") && confirm.equals("") && email1.equals("") && first.equals("") && empid.equals("")) {
            JOptionPane.showMessageDialog(null,"Empty Input","Warning",JOptionPane.ERROR_MESSAGE);
           
        } else if (first.equals("")){
            JOptionPane.showMessageDialog(null,"Required First Name","Warning",JOptionPane.ERROR_MESSAGE);

        } else if (last.equals("")){
            JOptionPane.showMessageDialog(null,"Required Last Name","Warning",JOptionPane.ERROR_MESSAGE);

        }else if(!validateInputNoCharOrNumber (first)){
            JOptionPane.showMessageDialog(null,"First Name can't contain Special/Numeric Characters","Warning",JOptionPane.ERROR_MESSAGE);

        } else if(!validateInputNoCharOrNumber (last)){
            JOptionPane.showMessageDialog(null,"Last Name can't contain Special/Numeric Characters","Warning",JOptionPane.ERROR_MESSAGE);

        }else if (!malebtn.isSelected() && !femalebtn.isSelected()){
            JOptionPane.showMessageDialog(null,"Gender Required","Warning",JOptionPane.ERROR_MESSAGE);

        }else if (email1.equals("")){
            JOptionPane.showMessageDialog(null,"Required Email","Warning",JOptionPane.ERROR_MESSAGE);

        }else if (empid.equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter Eployee ID","Warning",JOptionPane.ERROR_MESSAGE);

        } else if (user.equals("")){
            JOptionPane.showMessageDialog(null,"Required UserName","Warning",JOptionPane.ERROR_MESSAGE);

        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(null,"Required Password","Warning",JOptionPane.ERROR_MESSAGE);

        }else if(user.contains(" ")){
            JOptionPane.showMessageDialog(null,"Username can't contain space ","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if(empid.contains(" ")){
            JOptionPane.showMessageDialog(null,"Employee Id can't contain space ","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if(password.contains(" ")){
            JOptionPane.showMessageDialog(null,"Password Id can't contain space ","Warning",JOptionPane.ERROR_MESSAGE);
                    
        }else if (!validateInputNoCharOrNumber(user)) {
             JOptionPane.showMessageDialog(null, "Username contains special characters and is invalid.","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if (!validateInput(user, minLength)) {
             JOptionPane.showMessageDialog(null, "Invalid Username Minimum 8 character","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if (!validateEmail(email1)) {
             JOptionPane.showMessageDialog(null, "Email is invalid.","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if (!validateInput(password, minLength)) {
             JOptionPane.showMessageDialog(null, "Invalid Password Minimum 8 character","Warning",JOptionPane.ERROR_MESSAGE);
        
        }else if(idExist){
             JOptionPane.showMessageDialog(null, "ID Exists Already","Warning",JOptionPane.ERROR_MESSAGE);
        }else {
             String genderidentity = gender.getSelection().getActionCommand();
             boolean isExist = DataHandler.registerUser(user,password,first,last,genderidentity,email1,empid, role);

                if(password.equals(confirm)){
                    if(isExist){
                        JOptionPane.showMessageDialog(null, "Username Exists Already","Warning",JOptionPane.ERROR_MESSAGE);
                    }else {
                        String secretcode = JOptionPane.showInputDialog(null,"Enter Secret Code ","Confirm",JOptionPane.QUESTION_MESSAGE);
                        if(code.equals(secretcode)){
                            JOptionPane.showMessageDialog(null, "Account Registered Successfully. ","Message",JOptionPane.INFORMATION_MESSAGE);
    //                        DataHandler.registerUser(user,password,first,last,genderidentity,email1,empid, role);
                            Login loginback = new Login();
                            loginback.setVisible(true);
                            setVisible(false);
                    
                        }else{
                            JOptionPane.showMessageDialog(null, "Wrong Code","Warning",JOptionPane.ERROR_MESSAGE);

                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Input password","Failed",JOptionPane.INFORMATION_MESSAGE);

                }
//            
        }
    }//GEN-LAST:event_registerbtn1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Login backLog = new Login();
        backLog.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void userregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userregActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_userregActionPerformed

    private void adminregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminregActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_adminregActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
      aboutUs();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         aboutUs();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void empid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empid1ActionPerformed
        // TODO add your handling code here:
        registerUser.doClick();
    }//GEN-LAST:event_empid1ActionPerformed

    private void empid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empid2ActionPerformed
        // TODO add your handling code here:
        registerbtn1.doClick();
    }//GEN-LAST:event_empid2ActionPerformed

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
            java.util.logging.Logger.getLogger(Register2acc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register2acc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register2acc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register2acc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register2acc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lnane;
    private javax.swing.JLabel Lnane1;
    private javax.swing.JLabel Lnane2;
    private javax.swing.JLabel Lnane3;
    private javax.swing.JButton adminreg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearadmin;
    private javax.swing.JPasswordField confirmpassword;
    private javax.swing.JPasswordField confirmpassword1;
    private javax.swing.JLabel email;
    private javax.swing.JLabel email1;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField emailText1;
    private javax.swing.JTextField empid1;
    private javax.swing.JTextField empid2;
    private javax.swing.JRadioButton femalebtn;
    private javax.swing.JRadioButton femaleuser;
    private javax.swing.JLabel fname;
    private javax.swing.JLabel fname1;
    private javax.swing.JTextField fnametxt;
    private javax.swing.JTextField fnametxt1;
    private javax.swing.ButtonGroup gender;
    private javax.swing.ButtonGroup genderuser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lnameText;
    private javax.swing.JTextField lnameText1;
    private javax.swing.JRadioButton malebtn;
    private javax.swing.JRadioButton maleuser;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JPasswordField passwordText1;
    private javax.swing.JButton registerUser;
    private javax.swing.JButton registerbtn1;
    private javax.swing.JLabel userText;
    private javax.swing.JTextField userText1;
    private javax.swing.JLabel userText2;
    private javax.swing.JTextField userText3;
    private javax.swing.JButton userreg;
    // End of variables declaration//GEN-END:variables


}
