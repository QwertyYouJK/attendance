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

public class addStudent extends javax.swing.JFrame {

    public addStudent() {
        initComponents();
        setLocationRelativeTo(null);
        
    }

    //variables
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtsurname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfirstname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtchinname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnmale = new javax.swing.JRadioButton();
        btnfemale = new javax.swing.JRadioButton();
        btnadd = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Student");
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(1000, 1000));
        setMinimumSize(new java.awt.Dimension(481, 321));
        setResizable(false);

        jPanel1.setAlignmentX(10.0F);
        jPanel1.setAlignmentY(10.0F);
        jPanel1.setName("Add Student"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("English Surname*");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 120, -1));

        txtsurname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtsurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 110, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("English first name*");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        txtfirstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtfirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 210, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Chinese name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        txtchinname.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jPanel1.add(txtchinname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Gender*");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        buttonGroup1.add(btnmale);
        btnmale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnmale.setText("Male");
        jPanel1.add(btnmale, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        buttonGroup1.add(btnfemale);
        btnfemale.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnfemale.setText("Female");
        jPanel1.add(btnfemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 210, -1, -1));

        btnadd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 90, 30));

        btncancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
        try {
            // TODO add your handling code here:
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            int stuID = 1;
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            pst = con.prepareStatement("select max(student_id) as highID from student_info");
            rs = pst.executeQuery();
            while (rs.next()){
                stuID = rs.getInt("highID");
                stuID++; //new student ID
            }
            //initialize variables
            String surname, firstName, chinName, gender;
            //check if everything is filled
            if("".equals(txtsurname.getText()) || "".equals(txtfirstname.getText()))
                JOptionPane.showMessageDialog(jf, "Please fill in required fields", "WARNING", JOptionPane.WARNING_MESSAGE);
            else if(!btnmale.isSelected() && !btnfemale.isSelected())
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
                pst = con.prepareStatement("insert into student_info(student_id,surname,first_name,chinese_name,gender)values(?,?,?,?,?)");
                pst.setInt(1, stuID);
                pst.setString(2, surname);
                pst.setString(3, firstName);
                pst.setString(4, chinName);
                pst.setString(5, gender);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(jf, "Record has been added", "Record added", JOptionPane.PLAIN_MESSAGE);
                dispose();
            }   
        } catch (SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnaddActionPerformed

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
            java.util.logging.Logger.getLogger(addStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncancel;
    private javax.swing.JRadioButton btnfemale;
    private javax.swing.JRadioButton btnmale;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtchinname;
    private javax.swing.JTextField txtfirstname;
    private javax.swing.JTextField txtsurname;
    // End of variables declaration//GEN-END:variables
}
