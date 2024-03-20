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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.math.NumberUtils;

public class editYear extends javax.swing.JFrame {

    /**
     * Creates new form editYear
     */
    public editYear() {
        initComponents();
        setLocationRelativeTo(null);
        update();
    }

    //variables
    int id;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String year = schoolCalendar.schoolYear;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        btnedit = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        startdate = new com.toedter.calendar.JDateChooser();
        enddate = new com.toedter.calendar.JDateChooser();
        txtyear = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit School Year");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(427, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("School year");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 80, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Start date");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 97, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("End date");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 60, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Number of classes");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        txtnum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumActionPerformed(evt);
            }
        });
        jPanel1.add(txtnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 50, -1));

        btnedit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnedit.setText("Save");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 70, 30));

        btncancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 80, 30));

        startdate.setDateFormatString("yyyy-MM-dd");
        startdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(startdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 120, 30));

        enddate.setDateFormatString("yyyy-MM-dd");
        enddate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(enddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 120, 30));

        txtyear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 110, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try {
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            //create database connection
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            //initialize variables
            String yearUpdate, startDate, endDate, numClass;
            int num;
            Date start, end;
            Boolean numflag;
            Boolean yearflag = false;
            //check if school year already exist in record
            yearUpdate = txtyear.getText();
            pst = con.prepareStatement("select school_year from school_calendar");
            rs = pst.executeQuery();
            if(!year.equals(yearUpdate)){
                while(rs.next()){
                    if(yearUpdate.equals(rs.getString("school_year"))){
                        yearflag = true;
                    }
                }
            }
            //check if number of class is integer
            numClass = txtnum.getText();
            numflag = NumberUtils.isDigits(numClass);
            //check if everything is filled
            if("".equals(txtyear.getText()) || "".equals(startdate.getDate()) || "".equals(enddate.getDate()) || "".equals(txtnum.getText()))
            JOptionPane.showMessageDialog(jf, "Please fill in required fields", "WARNING", JOptionPane.WARNING_MESSAGE);
            else if(yearflag)
            JOptionPane.showMessageDialog(jf, "This year already exists", "WARNING", JOptionPane.WARNING_MESSAGE);
            else if(!numflag)
            JOptionPane.showMessageDialog(jf, "Please enter number in Number of classes", "WARNING", JOptionPane.WARNING_MESSAGE);
            else {
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                //get variables values
                start = startdate.getDate();
                end = enddate.getDate();
                num = Integer.parseInt(numClass);
                startDate = sdformat.format(start);
                endDate = sdformat.format(end);
                //add record into student_info table
                pst = con.prepareStatement("update school_calendar set schooL_year=?, start_date=?, end_date=?, num_of_class=? where ID=?");
                pst.setString(1, yearUpdate);
                pst.setString(2, startDate);
                pst.setString(3, endDate);
                pst.setInt(4, num);
                pst.setInt(5, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(jf, "Change is now saved", "Record edited", JOptionPane.PLAIN_MESSAGE);
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void txtnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        int confirm = JOptionPane.showConfirmDialog(jf, "Are you sure you want to cancel?", "Edit cancel", JOptionPane.YES_NO_OPTION);
        if(confirm == 0){
            dispose();
        }
    }//GEN-LAST:event_btncancelActionPerformed

    public void update(){
        txtyear.setText(year);
        Date startDate, endDate;
        int numClass;
        String num;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            pst = con.prepareStatement("select * from school_calendar where school_year=?");
            pst.setString(1, year);
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("ID");
                startDate = rs.getDate("start_date"); //retrieve start date of the record
                endDate = rs.getDate("end_date"); //retrieve end date of the record
                numClass = rs.getInt("num_of_class"); //retrieve number of classes of the record
                num = Integer.toString(numClass);
                startdate.setDate(startDate);
                enddate.setDate(endDate);
                txtnum.setText(num);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
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
            java.util.logging.Logger.getLogger(editYear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editYear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editYear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editYear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editYear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnedit;
    private com.toedter.calendar.JDateChooser enddate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser startdate;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}
