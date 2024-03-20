/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class editStudent extends javax.swing.JFrame {

    /**
     * Creates new form editStudent 
     */
    public editStudent() {
        initComponents();  
        setLocationRelativeTo(null);
        update();
    }

    int stuID;
    String surname;
    String firstName;
    String chinName;
    String gender;
    String year;
    String className;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtsurname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfirstname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtchinname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnmale = new javax.swing.JRadioButton();
        btnfemale = new javax.swing.JRadioButton();
        btnedit = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Student");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Student ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        txtid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 90, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("English surname*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 90, 120, -1));

        txtsurname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtsurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("English first name*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 120, 130, -1));

        txtfirstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtfirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 200, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Chinese name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        txtchinname.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jPanel1.add(txtchinname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 120, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gender");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        buttonGroup1.add(btnmale);
        btnmale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnmale.setText("Male");
        jPanel1.add(btnmale, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, -1, -1));

        buttonGroup1.add(btnfemale);
        btnfemale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnfemale.setText("Female");
        btnfemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfemaleActionPerformed(evt);
            }
        });
        jPanel1.add(btnfemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        btnedit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnedit.setText("Save");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 70, 30));

        btncancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void update(){
        stuID = students.studentID;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            pst = con.prepareStatement("select * from student_info where student_id = ?");
            pst.setInt(1,stuID);
            rs = pst.executeQuery();
            while(rs.next()){
                stuID = rs.getInt("student_id"); //retrieve student id in the row
                surname = rs.getString("surname"); //retrieve surname in the row
                firstName = rs.getString("first_name"); //retrieve first name in the row
                chinName = rs.getString("chinese_name"); //retrieve chinese name in the row
                gender = rs.getString("gender"); //retrieve gender in the row
            }
            //auto input the information into the fields
            String id = Integer.toString(stuID);
            txtid.setText(id);
            txtsurname.setText(surname);
            txtfirstname.setText(firstName);
            txtchinname.setText(chinName);
            if("M".equals(gender)){
                btnmale.setSelected(true);
            } else {
                btnfemale.setSelected(true);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    private void btnfemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnfemaleActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        int confirm = JOptionPane.showConfirmDialog(jf, "Are you sure you want to cancel?", "Edit cancel", JOptionPane.YES_NO_OPTION);
        if(confirm == 0){ 
            dispose();
        } 
    }//GEN-LAST:event_btncancelActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try {
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            if("".equals(txtsurname.getText()) || "".equals(txtfirstname.getText()))
                JOptionPane.showMessageDialog(jf, "Please fill in required fields", "WARNING", JOptionPane.WARNING_MESSAGE);
            else {
                //get variables values
                surname = txtsurname.getText();
                firstName = txtfirstname.getText();
                chinName = txtchinname.getText();
                if(btnmale.isSelected())
                    gender = "M";
                else
                    gender = "F";
                //add record into student_info table
                pst = con.prepareStatement("update student_info set surname=?, first_name=?, chinese_name=?, gender=? where student_id=?");
                pst.setString(1, surname);
                pst.setString(2, firstName);
                pst.setString(3, chinName);
                pst.setString(4, gender);
                pst.setInt(5, stuID);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(jf, "Change is now saved", "Record edited", JOptionPane.PLAIN_MESSAGE);
                dispose();
            }
        } catch (SQLException ex) { 
            Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btneditActionPerformed

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
            java.util.logging.Logger.getLogger(editStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new editStudent().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnedit;
    private javax.swing.JRadioButton btnfemale;
    private javax.swing.JRadioButton btnmale;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtchinname;
    private javax.swing.JTextField txtfirstname;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtsurname;
    // End of variables declaration//GEN-END:variables
}
