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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.math.NumberUtils;

public class addYear extends javax.swing.JFrame {

    /**
     * Creates new form addYear
     */
    public addYear() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnum = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        startdate = new com.toedter.calendar.JDateChooser();
        enddate = new com.toedter.calendar.JDateChooser();
        txtyear1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtyear2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add School Year");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(427, 303));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("School Year*");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 90, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Start date*");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("End date*");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Number of classes*");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, 20));

        txtnum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 50, 20));

        btnadd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 70, 30));

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
        jPanel1.add(startdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 130, 30));

        enddate.setDateFormatString("yyyy-MM-dd");
        enddate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(enddate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 130, 30));

        txtyear1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtyear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 50, 20));

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("(yyyy-yyyy)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        txtyear2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtyear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 50, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("-");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            JFrame jf=new JFrame();
            jf.setAlwaysOnTop(true);
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            //initialize variables
            String year1, year2, numClass;
            String startDate = null;
            String endDate = null;
            int num=0;
            Date start, end;
            Boolean numvalid = false;
            Boolean yearflag = false;
            Boolean yearvalid = false;
            Boolean dateflag = false;
            //check if school year already exist in record
            year1 = txtyear1.getText();
            year2 = txtyear2.getText();
            Boolean numflag1 = NumberUtils.isDigits(year1);
            Boolean numflag2 = NumberUtils.isDigits(year2);
            if(numflag1 && numflag2){
                if(Integer.parseInt(year1) < Integer.parseInt(year2)){
                    yearvalid = true;
                }
            }
            String year = year1+"-"+year2;
            pst = con.prepareStatement("select school_year from school_calendar");
            rs = pst.executeQuery();
            while(rs.next()){
                if(year.equals(rs.getString("school_year"))){
                    yearflag = true;
                }
            }
            //check if dates are valid
            if(yearvalid){
                String yr1 = txtyear1.getText() + "-01-01";
                String yr2 = txtyear2.getText() + "-01-01";
                SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                Date y1 = sdformat.parse(yr1);
                Date y2 = sdformat.parse(yr2);

                start = startdate.getDate();
                end = enddate.getDate();
                startDate = sdformat.format(start);
                endDate = sdformat.format(end);
            
                if(start.compareTo(y1) > 0 && start.compareTo(y2) < 0 && end.compareTo(y2) > 0){
                    dateflag = true;
                }
            }
            //check if number of class is integer
            numClass = txtnum.getText();
            Boolean numflag = NumberUtils.isDigits(numClass);
            if(numflag){
                num = Integer.parseInt(numClass);
                if(numflag && num > 0){
                    numvalid = true;
                }
            }
            //check if everything is filled
            if("".equals(txtyear1.getText()) || "".equals(startdate.getDate()) || "".equals(enddate.getDate()) || "".equals(txtnum.getText()))
                JOptionPane.showMessageDialog(jf, "Please fill in required fields", "WARNING", JOptionPane.WARNING_MESSAGE);
            else if(yearflag)
                JOptionPane.showMessageDialog(jf, "School year already exists", "WARNING", JOptionPane.WARNING_MESSAGE);
            else if(!yearvalid)
                JOptionPane.showMessageDialog(jf, "Invalid school year", "WARNING", JOptionPane.WARNING_MESSAGE);
            else if(!dateflag)
                JOptionPane.showMessageDialog(jf, "Invalid school dates", "WARNING", JOptionPane.WARNING_MESSAGE);
            else if(!numvalid)
                JOptionPane.showMessageDialog(jf, "Invalid number of classes", "WARNING", JOptionPane.WARNING_MESSAGE);
            else {
                //add record into student_info table
                pst = con.prepareStatement("insert into school_calendar(school_year,start_date,end_date,num_of_class)values(?,?,?,?)");
                pst.setString(1, year);
                pst.setString(2, startDate);
                pst.setString(3, endDate);
                pst.setInt(4, num);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(jf, "Record has been added", "Record added", JOptionPane.PLAIN_MESSAGE);
                dispose();
            }
        } catch (SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(addYear.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(addYear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addYear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addYear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addYear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addYear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btncancel;
    private com.toedter.calendar.JDateChooser enddate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser startdate;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtyear1;
    private javax.swing.JTextField txtyear2;
    // End of variables declaration//GEN-END:variables
}
