/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import static attendance.students.studentID;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class addStudentClass extends javax.swing.JFrame {

    /**
     * Creates new form addStudentClass
     */
    public addStudentClass() {
        initComponents();
        setLocationRelativeTo(null);
        txtyear.setText(year);
        update();
    }

    //variables
    String year = mainScreen.schoolYear;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    PreparedStatement pst1;
    ResultSet rs1;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboclass = new javax.swing.JComboBox<>();
        txtyear = new javax.swing.JLabel();
        btnadd = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Student Class");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(648, 401));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Surname", "First name", "Chinese name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(40);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 450, 350));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Class:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 40, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("School year:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, -1, -1));

        comboclass.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jPanel1.add(comboclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 90, 20));

        txtyear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 80, 20));

        btnadd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 70, 30));

        btncancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, 90, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Search name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 9, 280, 30));

        btnsearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void update(){
        int c;
        int stuID = 0;
        String surname;
        String firstName;
        String chinName;
        Boolean exist = false;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            //add class names to combo box
            pst = con.prepareStatement("select class_name from class_info");
            rs = pst.executeQuery();
            while (rs.next()) {
                comboclass.addItem(rs.getString("class_name")); //add school years into combo box
            }
            //get jtable1 properties
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel)jTable1.getModel();
            dft.setRowCount(0);
            //add the student to the table if their class don't exist
            pst = con.prepareStatement("select * from student_info");
            rs = pst.executeQuery();
            while(rs.next()){
                //retrieve student id, surname, first name, chinese name
                stuID = rs.getInt("student_id"); 
                surname = rs.getString("surname"); 
                firstName = rs.getString("first_name"); 
                chinName = rs.getString("chinese_name");
                pst1 = con.prepareStatement("select * from student_class where student_id = ? and school_year = ?");
                pst1.setInt(1, stuID);
                pst1.setString(2, year);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    exist = true;
                }
                if(!exist){
                    Vector v2 = new Vector();
                    for(int i = 1; i<=c; i++){ 
                        v2.add(stuID);
                        v2.add(surname);
                        v2.add(firstName);
                        v2.add(chinName);
                    }
                    dft.addRow(v2);
                }
                exist = false;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        int confirm = JOptionPane.showConfirmDialog(jf, "Are you sure you want to cancel?", "Add cancel", JOptionPane.YES_NO_OPTION);
        if(confirm == 0){
            dispose();  
        } 
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        if(jTable1.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(jf, "Please select one record", "Error", JOptionPane.OK_OPTION);
        } else if (jTable1.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(jf, "Please select one record only", "Error", JOptionPane.OK_OPTION);
        } else {
            String className = "";
            int classID = 0;
            //get ID of selected student
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();
            String id = model.getValueAt(selectedIndex, 0).toString();
            studentID = Integer.parseInt(id);
            try {
                className = comboclass.getSelectedItem().toString();
                pst = con.prepareStatement("select class_id from class_info where class_name = ?");
                pst.setString(1, className);
                rs = pst.executeQuery();
                while(rs.next()){
                    classID = rs.getInt("class_id");
                }
                pst1 = con.prepareStatement("insert into student_class(student_id,school_year,class_id)values(?,?,?)");
                pst1.setInt(1, studentID);
                pst1.setString(2, year);
                pst1.setInt(3, classID);
                pst1.executeUpdate();
                JOptionPane.showMessageDialog(jf, "Record has been added", "Record added", JOptionPane.PLAIN_MESSAGE);
                dispose();
            } catch (SQLException ex) {
                Logger.getLogger(addStudentClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        
        String input = txtsearch.getText(); //get result of search
        String search = input.substring(0,1).toUpperCase() + input.substring(1);
        int c;
        int stuID;
        String surname;
        String firstName;
        String chinName;
        
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver

            //create database connection
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
                
            pst = con.prepareStatement("select * from student_info");
            rs = pst.executeQuery();
                
            //get jtable1 properties
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel)jTable1.getModel();
            dft.setRowCount(0);
            
            
            while(rs.next()){
                if(search.equals(rs.getString("surname")) || search.equals(rs.getString("first_name")) || search.equals(rs.getString("chinese_name"))
                || input.equals(rs.getString("surname")) || input.equals(rs.getString("first_name")) || input.equals(rs.getString("chinese_name"))){
                    
                    stuID = rs.getInt("student_id"); //retrieve student id in the row
                    surname = rs.getString("surname"); //retrieve surname in the row
                    firstName = rs.getString("first_name"); //retrieve first name in the row
                    chinName = rs.getString("chinese_name"); //retrieve chinese name in the row

                               
                
                    Vector v2 = new Vector();
                    for(int i = 1; i<=c; i++){ 
                        v2.add(stuID);
                        v2.add(surname);
                        v2.add(firstName);
                        v2.add(chinName);
                    }
                    dft.addRow(v2);
                }
            }
                
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_btnsearchActionPerformed

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnsearch.doClick();
        } 
    }//GEN-LAST:event_txtsearchKeyPressed

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
            java.util.logging.Logger.getLogger(addStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addStudentClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox<String> comboclass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JLabel txtyear;
    // End of variables declaration//GEN-END:variables
}
