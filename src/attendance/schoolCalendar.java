/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class schoolCalendar extends javax.swing.JFrame {

    /**
     * Creates new form schoolCalendar
     */
    public schoolCalendar() {
        initComponents();
        setLocationRelativeTo(null);
        tableupdate();
    }

    //variables
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    static String schoolYear;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btndone = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("School Years");
        setResizable(false);

        jPanel1.setMinimumSize(new java.awt.Dimension(590, 369));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Year", "Start date", "End date", "No. of classes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(1);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 460, 310));

        btnadd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 90, 40));

        btndelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 90, 40));

        btndone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btndone.setText("Done");
        btndone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoneActionPerformed(evt);
            }
        });
        jPanel1.add(btndone, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 90, 40));

        btnedit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void tableupdate(){
        //variables
        int c;
        String year;
        String startDate;
        String endDate;
        int numClass;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            pst = con.prepareStatement("select * from school_calendar");
            rs = pst.executeQuery();
            //get jtable1 properties
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel)jTable1.getModel();
            dft.setRowCount(0);
            while (rs.next()) {
                year = rs.getString("school_year"); //retrieve school year of the record
                startDate = rs.getDate("start_date").toString(); //retrieve start date of the record
                endDate = rs.getDate("end_date").toString(); //retrieve end date of the record
                numClass = rs.getInt("num_of_class"); //retrieve number of classes of the record

                Vector v2 = new Vector();
                for(int i = 1; i<=c; i++){
                    v2.add(year);
                    v2.add(startDate);
                    v2.add(endDate);
                    v2.add(numClass);
                }
                dft.addRow(v2);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        addYear gui = new addYear();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                tableupdate();
            }
        });
    }//GEN-LAST:event_btnaddActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        if(jTable1.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Please select one record", "Error", JOptionPane.OK_OPTION);
        } else if (jTable1.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "Please select one record only", "Error", JOptionPane.OK_OPTION);
        } else {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();
            String year = model.getValueAt(selectedIndex, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete school year", JOptionPane.YES_NO_OPTION);
            if(confirm == 0){
                try {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver

                    //create database connection
                    con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
                    pst = con.prepareStatement("delete from school_calendar where school_year = ?");
                    pst.setString(1, year);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record has been deleted", "Record deleted", JOptionPane.PLAIN_MESSAGE);
                    tableupdate();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }        
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btndoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoneActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btndoneActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        if(jTable1.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Please select one record", "Error", JOptionPane.OK_OPTION);
        } else if (jTable1.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "Please select one record only", "Error", JOptionPane.OK_OPTION);
        } else {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();
            String year = model.getValueAt(selectedIndex, 0).toString();
            schoolYear = year;
            
            editYear gui = new editYear();
            gui.setVisible(true);
            gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            gui.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosed(WindowEvent e) {
                tableupdate();
            }

        });
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
            java.util.logging.Logger.getLogger(schoolCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(schoolCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(schoolCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(schoolCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new schoolCalendar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btndone;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
