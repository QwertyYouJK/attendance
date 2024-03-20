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

public class editStudentClass extends javax.swing.JFrame {

    /**
     * Creates new form editClass
     */
    public editStudentClass() {
        initComponents();
        setLocationRelativeTo(null);
        update();
    }

    int stuID = studentClass.studentID;
    String year = mainScreen.schoolYear;
    int classID;
    String surname;
    String firstName;
    String chinName;
    String yearUpdate;
    String classNameUpdate;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboclass = new javax.swing.JComboBox<>();
        btnedit = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JLabel();
        txtyear = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtfirstname = new javax.swing.JLabel();
        txtsurname = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtchin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Student Class");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Year");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Class");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 50, 20));

        comboclass.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jPanel1.add(comboclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 80, -1));

        btnedit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnedit.setText("Save");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 70, 30));

        btncancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 80, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Student ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        txtid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 80, 20));

        txtyear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 90, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("English name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 90, 30));

        txtfirstname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtfirstname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtfirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 60, 30));

        txtsurname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtsurname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtsurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 70, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Chinese name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 90, 20));

        txtchin.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        jPanel1.add(txtchin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void update(){
        try {
            String id = Integer.toString(stuID);
            txtid.setText(id);
            txtyear.setText(year);
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            //display student name
            pst = con.prepareStatement("select * from student_info where student_id = ?");
            pst.setInt(1,stuID);
            rs = pst.executeQuery();
            while(rs.next()){
                surname = rs.getString("surname"); //retrieve surname in the row
                firstName = rs.getString("first_name"); //retrieve first name in the row
                chinName = rs.getString("chinese_name"); //retrieve chinese name in the row
            }
            txtfirstname.setText(firstName);
            txtsurname.setText(surname);
            txtchin.setText(chinName);
            //add school years into combo box
            pst = con.prepareStatement("select class_name from class_info");
            rs = pst.executeQuery();
            while (rs.next()) {
                comboclass.addItem(rs.getString("class_name")); 
            }
            //pre-select the year in the combo box
            pst = con.prepareStatement("select * from student_class where student_id=? and school_year=?");
            pst.setInt(1,stuID);
            pst.setString(2,year);
            rs = pst.executeQuery();
            while(rs.next()){
                classID = rs.getInt("class_id");
            }
            pst = con.prepareStatement("select class_name from class_info where class_id = ?");
            pst.setInt(1, classID);
            rs = pst.executeQuery();
            while (rs.next()) {
                comboclass.setSelectedItem(rs.getString("class_name"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
            //get class id for the class name
            classNameUpdate = comboclass.getSelectedItem().toString();
            pst = con.prepareStatement("select class_id from class_info where class_name = ?");
            pst.setString(1, classNameUpdate);
            rs = pst.executeQuery();
            while(rs.next()){
                classID = rs.getInt("class_id");
            }
            //update record in student_class
            pst = con.prepareStatement("update student_class set class_id=? where student_id=? and school_year=?");
            pst.setInt(1, classID);
            pst.setInt(2, stuID);
            pst.setString(3, year);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(jf, "Change is now saved", "Record edited", JOptionPane.PLAIN_MESSAGE);
            dispose();
        } catch (SQLException ex) {}
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
            java.util.logging.Logger.getLogger(editStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editStudentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editStudentClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnedit;
    private javax.swing.JComboBox<String> comboclass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtchin;
    private javax.swing.JLabel txtfirstname;
    private javax.swing.JLabel txtid;
    private javax.swing.JLabel txtsurname;
    private javax.swing.JLabel txtyear;
    // End of variables declaration//GEN-END:variables
}
