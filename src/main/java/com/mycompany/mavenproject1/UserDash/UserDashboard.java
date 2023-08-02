/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1.UserDash;


import com.mycompany.mavenproject1.LoginForm.Login;
import com.mycompany.mavenproject1.ConnectionQuery.DatabaseConnector;
import com.mycompany.mavenproject1.ConnectionQuery.DataHandler;
import com.mycompany.mavenproject1.LoadingSplash.Logoutscreen;
import com.mycompany.mavenproject1.LoadingSplash.Splash;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author John Kyle G. Mistas
 */
public class UserDashboard extends javax.swing.JFrame {
        
    
    LocalTime currentTimecomp1;
    private LocalDate lastClickedDate;

    /**
     * Creates new form UserDashboard
     */
    public UserDashboard() {
        initComponents();
        String idhold = idHolder.getText();
       
        date.setEditable(false);
        time.setEditable(false);
        dt();
        times();
        conbtn();
        handleButtonClick();
        displaUserData(idhold);
        saver.setVisible(false);
        
        
       
//        endTime.setVisible(false);
     
     }
     public void updateLabelText(String newText) {
//        welcome.setText(newText);
    }
     
     public void dt(){
         
         Date d = new Date();
         
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         
         String dd = sdf.format(d);
         date.setText(dd);
         
     }
     
     public void times(){
         Timer t;
         SimpleDateFormat st;
         
         t = new Timer(0, new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
//                 throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
             Date dt = new Date();
             SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss a");
             String tt = st.format(dt);
             time.setText(tt);
             timein.setText(tt);
             endTime.setText(tt);
             
             }
         } );
         t.start();
     }
     
     public void conbtn(){
         if(timein.isEnabled() && endTime.isEnabled()){
            times();
           
        }else if(!timein.isEnabled()){
           timein.setEnabled(true);
           timein.setText("Already In!");  
           timein.setEnabled(false);
        }else if(!endTime.isEnabled()){
            endTime.setEnabled(true);
            endTime.setText("Already Out!");  
            endTime.setEnabled(false);
        }else{
            timein.setEnabled(true);
            endTime.setEnabled(true);
            timein.setText("Already In!");     
            endTime.setText("Already Out!");    
            timein.setEnabled(false);
            endTime.setEnabled(false);
        }
     }
     
     private void handleButtonClick() {
        String val = "1";
        LocalDate currentDate = LocalDate.now();
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(currentTime);
        if (lastClickedDate == null || !lastClickedDate.equals(currentDate)) {
            // Button can be clicked
            lastClickedDate = currentDate;
            endTime.setEnabled(false);
            out.setVisible(false);
        } else {
            // Button already clicked today
           String idhold = idHolder.getText();
            
            boolean isExist = DataHandler.saver(dd,val,idhold);
            if(isExist){
                
                saver.setEnabled(false);
               
            }else{
                DataHandler.saver(dd,val,idhold);
                String temptout = "-";
                String tempHW = "-";
                String dateupdate = date.getText();
                String hold = idHolder.getText();
        
                DataHandler.emplyeeRectimeOut(temptout,tempHW,dateupdate,hold);
                endTime.setEnabled(true); 
                out.setVisible(true);
                saver.setEnabled(false);
                saver.setVisible(false);
                
                DefaultTableModel model = new DefaultTableModel(null, new String[]{"Date", "Time In", "Time Out", "Hours Worked", "EmployeeId"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Make all cells uneditable
                }
            };

                userTable.setModel(model);
//            displaUserData(hold);
                       
               displaUserData(idhold);
            }
            
        }
    }
     
     private void handleButtonClickLeave() {
        String val = "1";
        LocalDate currentDate = LocalDate.now();
        Date currentTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dd = sdf.format(currentTime);
        if (lastClickedDate == null || !lastClickedDate.equals(currentDate)) {
            // Button can be clicked
            lastClickedDate = currentDate;
            leavebtn.setEnabled(false);
//            endTime.setEnabled(false);
//            out.setVisible(false);
        } else {
            // Button already clicked today
           String idhold = idHolder.getText();
            
            boolean isExist = DataHandler.leave(dd,val,idhold);
            if(isExist){
                
                leavebtn.setEnabled(false);
               
            }else{
                DataHandler.leave(dd,val,idhold);
                
                leavebtn.setEnabled(false);
            }
            
        }
    }
     
     public void splashShow(){
        int i = 0;
        try {
            dispose();
            Splash open = new Splash();
            open.setVisible(false);
            for(i = 0; i<=100; i++){
              Thread.sleep(40);
              open.progress.setText(Integer.toString(i) + "%");
              open.bar.setValue(i);
              open.process.setText("Logout...");
              
            if (i == 100){
            open.dispose();
            Login newLog = new Login();
            newLog.setVisible(true);
        }
            }
        } catch (Exception e) {
        }
     }
        public void displaUserData(String id){
            Object[][] data =null;
            String[] columnName = {"date","timein","timeout","hoursworked","employeeid"};
            DefaultTableModel displayModel = new DefaultTableModel(){
                
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            userTable.getTableHeader().setResizingAllowed(false);
            userTable.getTableHeader().setReorderingAllowed(false);
            try (Connection conn = DatabaseConnector.getConnection()) {
            
            String checkQuery = "SELECT * FROM employee_record WHERE employeeid = ? ORDER BY date ASC  ;";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, id);
            ResultSet rs = checkStmt.executeQuery();

            while (rs.next()) {
                String date3 = rs.getString("date");
                String timein3 = rs.getString("timein");
                String timeout = rs.getString("timeout");
                String hrswrk = rs.getString("hoursworked");
                String empid = rs.getString("employeeid");
                
                String list[] = {date3,timein3,timeout,hrswrk,empid};
                DefaultTableModel tbluser = (DefaultTableModel)userTable.getModel();
                tbluser.addRow(list);
                
            } 
                
        } catch (SQLException e) {
            e.printStackTrace();
          
        }
            
        }
        
        public void playAlarmSound() {
        try {
//            File soundFile = new File("C:\\mavenproject1\\src\\main\\java\\com\\mycompany\\mavenproject1"); // Replace with the actual path to your sound file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("Popular-Alarm-Clock-Sound-Effect.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
//       private void removeAllRows() {
//    int rowCount = userTable.getRowCount();
//    for (int i = rowCount - 1; i >= 0; i--) {
//        userTable.re(i);
//    }
//}
   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        date = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        endTime = new javax.swing.JButton();
        idHolder = new javax.swing.JTextField();
        timein = new javax.swing.JButton();
        saver = new javax.swing.JButton();
        out = new javax.swing.JLabel();
        in = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        recordtab = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        leavebtn = new javax.swing.JButton();
        profilebtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        reQuestBox = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        firstprof = new javax.swing.JLabel();
        gen = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        usern = new javax.swing.JTextField();
        idprof = new javax.swing.JTextField();
        logogirl = new javax.swing.JLabel();
        logoboy = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        record = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Time Recorder");
        setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLayeredPane1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.add(jLayeredPane1);
        jLayeredPane1.setBounds(400, 0, 490, 40);

        date.setEditable(false);
        date.setBackground(new java.awt.Color(255, 255, 255));
        date.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        date.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        date.setText("0");
        date.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)), "Date", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        jPanel1.add(date);
        date.setBounds(20, 110, 180, 50);

        time.setEditable(false);
        time.setBackground(new java.awt.Color(255, 255, 255));
        time.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        time.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        time.setText("0");
        time.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)), "Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });
        jPanel1.add(time);
        time.setBounds(20, 160, 180, 50);

        endTime.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        endTime.setForeground(new java.awt.Color(0, 0, 0));
        endTime.setText("0");
        endTime.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 0)), "Timeout", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 12))); // NOI18N
        endTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTimeActionPerformed(evt);
            }
        });
        jPanel1.add(endTime);
        endTime.setBounds(60, 410, 260, 50);

        idHolder.setEditable(false);
        idHolder.setBackground(new java.awt.Color(255, 255, 255));
        idHolder.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        idHolder.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idHolder.setText("0");
        idHolder.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 255, 0)), "Employee ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI Symbol", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        idHolder.setCaretColor(new java.awt.Color(0, 0, 0));
        idHolder.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        idHolder.setSelectionColor(new java.awt.Color(0, 0, 0));
        idHolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idHolderActionPerformed(evt);
            }
        });
        jPanel1.add(idHolder);
        idHolder.setBounds(40, 230, 190, 50);

        timein.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        timein.setForeground(new java.awt.Color(0, 0, 0));
        timein.setText("0");
        timein.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 0)), "Time in", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        timein.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeinActionPerformed(evt);
            }
        });
        jPanel1.add(timein);
        timein.setBounds(60, 330, 260, 50);

        saver.setBackground(null);
        saver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        saver.setForeground(new java.awt.Color(0, 0, 0));
        saver.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\opportunity1.png")); // NOI18N
        saver.setBorder(null);
        saver.setContentAreaFilled(false);
        saver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saverActionPerformed(evt);
            }
        });
        jPanel1.add(saver);
        saver.setBounds(0, 470, 40, 30);

        out.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        out.setText("Time Out");
        jPanel1.add(out);
        out.setBounds(160, 460, 80, 20);

        in.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        in.setText("TIme In");
        jPanel1.add(in);
        in.setBounds(160, 380, 60, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\1GFIILOGO-1.png")); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 40, 40, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 540);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(null);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(null);

        jLabel28.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\1GFIILOGO-1.png")); // NOI18N
        jPanel5.add(jLabel28);
        jLabel28.setBounds(10, -10, 40, 60);

        jLabel31.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 255, 102));
        jLabel31.setText("green");
        jPanel5.add(jLabel31);
        jLabel31.setBounds(60, -18, 70, 50);

        jLabel32.setFont(new java.awt.Font("Segoe UI Symbol", 1, 26)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 153, 51));
        jLabel32.setText("future");
        jPanel5.add(jLabel32);
        jLabel32.setBounds(120, -20, 100, 50);

        jLabel30.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel30.setText("Innovation, Inc.");
        jPanel5.add(jLabel30);
        jLabel30.setBounds(70, 2, 170, 50);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(0, 0, 490, 40);

        recordtab.setBackground(new java.awt.Color(204, 255, 204));

        jPanel3.setBackground(new java.awt.Color(102, 255, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Records", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 12))); // NOI18N
        jPanel3.setLayout(null);

        userTable.setBackground(new java.awt.Color(204, 255, 204));
        userTable.setBorder(new javax.swing.border.MatteBorder(null));
        userTable.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Time In", "Time Out", "Hours Worked", "Employeeid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTable.setRowHeight(25);
        userTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                userTableComponentResized(evt);
            }
        });
        jScrollPane1.setViewportView(userTable);
        if (userTable.getColumnModel().getColumnCount() > 0) {
            userTable.getColumnModel().getColumn(0).setResizable(false);
            userTable.getColumnModel().getColumn(1).setResizable(false);
            userTable.getColumnModel().getColumn(2).setResizable(false);
            userTable.getColumnModel().getColumn(3).setResizable(false);
            userTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 90, 460, 280);

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\1.png")); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(430, 380, 50, 30);

        leavebtn.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        leavebtn.setForeground(new java.awt.Color(255, 0, 0));
        leavebtn.setText("Emergency Leave");
        leavebtn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        leavebtn.setContentAreaFilled(false);
        leavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leavebtnActionPerformed(evt);
            }
        });
        jPanel3.add(leavebtn);
        leavebtn.setBounds(350, 430, 130, 27);

        profilebtn.setBackground(new java.awt.Color(102, 255, 102));
        profilebtn.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        profilebtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\1Iconoir-Team-Iconoir-Profile-circle.512.png")); // NOI18N
        profilebtn.setBorder(null);
        profilebtn.setContentAreaFilled(false);
        profilebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilebtnActionPerformed(evt);
            }
        });
        jPanel3.add(profilebtn);
        profilebtn.setBounds(440, 10, 40, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel3.setText("Profile");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(440, 40, 50, 20);

        reQuestBox.setBackground(new java.awt.Color(102, 255, 102));
        reQuestBox.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        reQuestBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<default>", "Change Time in", "Change Time out", "Emergency Leave" }));
        reQuestBox.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 0)), "Request", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 10))); // NOI18N
        reQuestBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reQuestBoxActionPerformed(evt);
            }
        });
        jPanel3.add(reQuestBox);
        reQuestBox.setBounds(30, 410, 110, 40);

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jButton3.setText("Request");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 0)));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(150, 430, 80, 20);

        recordtab.addTab("Record", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        firstprof.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        firstprof.setText("Given Name");
        jPanel4.add(firstprof);
        firstprof.setBounds(190, 140, 200, 25);

        gen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        gen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 255, 51)), "Gender", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.add(gen);
        gen.setBounds(110, 230, 240, 50);

        mail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mail.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 255, 51)), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 12))); // NOI18N
        jPanel4.add(mail);
        mail.setBounds(110, 280, 240, 50);

        usern.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usern.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usern.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 255, 51)), "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 12))); // NOI18N
        jPanel4.add(usern);
        usern.setBounds(110, 330, 240, 50);

        idprof.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        idprof.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idprof.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 255, 51)), "Employee ID", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 12))); // NOI18N
        jPanel4.add(idprof);
        idprof.setBounds(110, 380, 240, 50);

        logogirl.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\ezgif.com-resize (3).gif")); // NOI18N
        jPanel4.add(logogirl);
        logogirl.setBounds(160, 20, 200, 120);

        logoboy.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\ezgif.com-resize (6).gif")); // NOI18N
        jPanel4.add(logoboy);
        logoboy.setBounds(160, 0, 210, 160);

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel8.setText("Profile");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(10, 0, 110, 50);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\John Kyle G. Mistas\\Downloads\\logout (2).png")); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(440, 420, 40, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jLabel1.setText("Logout");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(440, 450, 50, 16);

        record.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        record.setForeground(new java.awt.Color(0, 153, 0));
        record.setText("Record");
        record.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 0)));
        record.setContentAreaFilled(false);
        record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordActionPerformed(evt);
            }
        });
        jPanel4.add(record);
        record.setBounds(420, 10, 60, 30);

        recordtab.addTab("Profile", jPanel4);

        jPanel2.add(recordtab);
        recordtab.setBounds(0, 10, 490, 530);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(400, 0, 490, 510);

        setSize(new java.awt.Dimension(905, 549));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String  idhold = idHolder.getText();
        
        DefaultTableModel model = new DefaultTableModel(null, new String[]{"Date", "Time In", "Time Out", "Hours Worked", "EmployeeId"}) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Make all cells uneditable
                }
            };

            userTable.setModel(model);
//            displaUserData(hold);
                       
        displaUserData(idhold);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saverActionPerformed
        // TODO add your handling code here:
        
        leavebtn.setEnabled(true);
        handleButtonClick();
    }//GEN-LAST:event_saverActionPerformed

    private void idHolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idHolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idHolderActionPerformed

    private void endTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTimeActionPerformed
        // TODO add your handling code here:
//        endTime.setText("Already Out!");
//        leavebtn.setEnabled(false);
       
        String hold = idHolder.getText();
        String date1 = date.getText();
        //        timeIn.setEnabled(true);
        //         endTime.setEnabled(false);
         String outExist = DataHandler.toutExist(date1, hold);
         if(outExist.equals("-")){
            int result = JOptionPane.showConfirmDialog(null,"Are you sure? You can't Change it anymore.", "Confirm", JOptionPane.YES_NO_OPTION);
            if (result ==JOptionPane.YES_OPTION) {

                Date currentTime = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dd = sdf.format(currentTime);

                SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
                String formattedTime = timeFormat.format(currentTime);
                JOptionPane.showMessageDialog(null, dd + " " + formattedTime, "Time Out",JOptionPane.INFORMATION_MESSAGE);

                String timeString = DataHandler.computeTime(dd,hold); // Example time string

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

                LocalTime timeIn = LocalTime.parse(timeString.toLowerCase(), formatter);
                LocalTime timeOut = LocalTime.parse(formattedTime.toLowerCase(), formatter);

                // Handle cases where the time-out is before the time-in (e.g., time-in: 08:00 PM, time-out: 02:00 AM)
                if (timeOut.isBefore(timeIn)) {
                    timeOut = timeOut.plus(Duration.ofDays(1));
                }

                Duration duration = Duration.between(timeIn, timeOut);

                long totalHours = duration.toHours();
                long remainingMinutes = duration.toMinutes() % 60;
                String totalHourString = String.valueOf(totalHours);

                JOptionPane.showMessageDialog(this,"Total hours worked: " + totalHours + " hours " + remainingMinutes + " minutes");


                boolean isExist = DataHandler.emplyeeRectimeOut(formattedTime,totalHourString,dd,hold);
                if(isExist){

                    DataHandler.emplyeeRectimeOut(formattedTime,totalHourString,dd,hold);
                    JOptionPane.showMessageDialog(null, "Time Recorded ");
                    leavebtn.setEnabled(false);
                    endTime.setEnabled(false);
                    out.setVisible(false);
                    timein.setEnabled(false);
                    in.setVisible(false);
                     saver.setVisible(true);
                     saver.setEnabled(true);
                    DefaultTableModel model = new DefaultTableModel(null, new String[]{"Date", "Time In", "Time Out", "Hours Worked", "EmployeeId"}) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false; // Make all cells uneditable
                            }
                };

                userTable.setModel(model);
                displaUserData(hold);
                }
            }else{
                timein.setEnabled(false);
                in.setVisible(false);
                endTime.setEnabled(true);
                out.setVisible(true);
            }
        }else{
             JOptionPane.showMessageDialog(null,"Already Out","Warning",JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_endTimeActionPerformed

    private void timeinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeinActionPerformed
        // TODO add your handling code here:
        timein.setText("Already In");

        String hold = idHolder.getText();
     
        String idCorrect = DataHandler.userRecord(hold);
        if (hold.equals("")){
            JOptionPane.showMessageDialog(null,"Please Input Employee ID","Warning",JOptionPane.INFORMATION_MESSAGE);
        }else{

            if(hold.equals(idCorrect)){
                
                idHolder.setEditable(false);
                //currentTimecomp1 = LocalTime.now();
                Date currentTime = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dd = sdf.format(currentTime);

                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
                String formattedTime1 = dateFormat.format(currentTime);
                
                String temptout = "-";
                 String tempHW = "-";
                
                boolean isExist = DataHandler.emplyeeRectimeIn(dd,formattedTime1,hold,temptout,tempHW);
                
                if(isExist){
                     JOptionPane.showMessageDialog(null, "You Already Time In!");
                    
                }
                else {
                    DataHandler.emplyeeRectimeIn(dd,formattedTime1,hold,temptout,tempHW);
                    JOptionPane.showMessageDialog(null, dd + " " + formattedTime1, "Time In",JOptionPane.INFORMATION_MESSAGE);

                    endTime.setEnabled(true);
                    out.setVisible(true);
                    timein.setEnabled(false);
                    in.setVisible(false);
                    saver.setVisible(true);
                    saver.setEnabled(false);
                    leavebtn.setEnabled(true);
                    
//                    userTable.setModel(new DefaultTableModel(null,new String[]{"Date","Time In","Time Out","Hours Worked","Employeeid"}));
                    
                    
                    DefaultTableModel model = new DefaultTableModel(null, new String[]{"Date", "Time In", "Time Out", "Hours Worked", "EmployeeId"}) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false; // Make all cells uneditable
                        }
            };

            userTable.setModel(model);
            displaUserData(hold);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Employee ID Time Not Recorded " , "Warning",JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_timeinActionPerformed

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void profilebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilebtnActionPerformed
        // TODO add your handling code here:
            recordtab.setSelectedIndex(1);
//        ProfileUser prof = new ProfileUser();
//        String idemp = idHolder.getText();
          
       
        
        
    }//GEN-LAST:event_profilebtnActionPerformed

    private void userTableComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_userTableComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_userTableComponentResized

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Toolkit.getDefaultToolkit().beep();
        Toolkit.getDefaultToolkit().beep();
        Toolkit.getDefaultToolkit().beep();
        
        if (timein.isEnabled()) {
            Toolkit.getDefaultToolkit().beep();
            Toolkit.getDefaultToolkit().beep();
            Toolkit.getDefaultToolkit().beep();

             int result = JOptionPane.showConfirmDialog(null, "Do you want to Logout without Timing in?", "Confirmation", JOptionPane.YES_NO_OPTION);

                // Check the user's choice
                if (result == JOptionPane.YES_OPTION) {
                    // User clicked "Yes"
                   dispose();
        Logoutscreen logout = new Logoutscreen();
        Login log = new Login();
         Thread countdownThread = new Thread(() -> {
                                         int ctr = 4;
                                    while (ctr >= 0) {
//                                SwingUtilities.invokeLater(() -> countersec.setText(Integer.toString(countdown)));
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                }
                                ctr--;
                            }

                            logout.setVisible(false);
                            log.setVisible(true);
                            
                        });
                        logout.setVisible(true);
                        countdownThread.start();
                } else {
                    // User clicked "No" or closed the dialog
                    JOptionPane.showMessageDialog(null, "Canceled.", "Notification", JOptionPane.WARNING_MESSAGE);
                }

             
                
        }else{
         dispose();
        Logoutscreen logout = new Logoutscreen();
        Login log = new Login();
         Thread countdownThread = new Thread(() -> {
                                         int ctr = 4;
                                    while (ctr >= 0) {

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                }
                                ctr--;
                            }

                            logout.setVisible(false);
                            log.setVisible(true);
                            
                        });
                        logout.setVisible(true);
                        countdownThread.start();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordActionPerformed
        // TODO add your handling code here:
        recordtab.setSelectedIndex(0);
    }//GEN-LAST:event_recordActionPerformed

    private void leavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leavebtnActionPerformed
        // TODO add your handling code here:

        handleButtonClickLeave();
        String idHold = idHolder.getText();
        String fullname = firstprof.getText();
        String dateHold = date.getText();
        LeaveForm newLeaveForm = new LeaveForm();
        newLeaveForm.empname.setText(fullname);
        newLeaveForm.leavedate.setText(dateHold);
        newLeaveForm.empid.setText(idHold);
        newLeaveForm.setVisible(true);
        saver.setEnabled(true);
        
    }//GEN-LAST:event_leavebtnActionPerformed

    private void reQuestBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reQuestBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reQuestBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String selectedRequest = (String) reQuestBox.getSelectedItem();
        String fullname = firstprof.getText();
        String dd = date.getText();
        String idh = idHolder.getText();

                // Check if the default option is selected
                if (selectedRequest.equals("<default>")) {
                    // Perform action or show message for the default option
                    JOptionPane.showMessageDialog(null, "No Selected Request " , "Warning",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Perform action for the selected option
                    boolean reqExist = DataHandler.requestForm(dd, fullname, idh, selectedRequest);
                    if(reqExist){
                        JOptionPane.showMessageDialog(null, fullname + " you already submitted request!" , "Warning",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Submitted Request!" , "Warning",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashboard().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField date;
    public javax.swing.JButton endTime;
    public javax.swing.JLabel firstprof;
    public javax.swing.JTextField gen;
    public javax.swing.JTextField idHolder;
    public javax.swing.JTextField idprof;
    public javax.swing.JLabel in;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton leavebtn;
    public javax.swing.JLabel logoboy;
    public javax.swing.JLabel logogirl;
    public javax.swing.JTextField mail;
    public javax.swing.JLabel out;
    private javax.swing.JButton profilebtn;
    private javax.swing.JComboBox<String> reQuestBox;
    private javax.swing.JButton record;
    private javax.swing.JTabbedPane recordtab;
    public javax.swing.JButton saver;
    public javax.swing.JTextField time;
    public javax.swing.JButton timein;
    private javax.swing.JTable userTable;
    public javax.swing.JTextField usern;
    // End of variables declaration//GEN-END:variables
}

