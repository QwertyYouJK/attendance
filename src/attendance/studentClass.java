/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import java.awt.event.KeyEvent;
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

public class studentClass extends javax.swing.JFrame {

    /**
     * Creates new form studentClass
     */
    public studentClass() {
        initComponents();
        setLocationRelativeTo(null);
        txtyear.setText(year);
        tableupdate();
        
    }
    
    //variables
    String year = mainScreen.schoolYear;
    static int studentID = 0;
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    PreparedStatement pst1;
    ResultSet rs1;
    PreparedStatement pst2;
    ResultSet rs2;
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtsearch = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        btndone = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtyear = new javax.swing.JLabel();
        btnrefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Class");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        jPanel1.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Surname", "First name", "Chinese name", "class"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(40);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(4).setMinWidth(70);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 560, 410));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Search name (Eng):");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 130, 20));

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtsearchKeyPressed(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 9, 260, 30));

        btnsearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, 30));

        btndone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btndone.setText("Done");
        btndone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoneActionPerformed(evt);
            }
        });
        jPanel1.add(btndone, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 421, 110, 40));

        btndelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 371, 110, 40));

        btnedit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 321, 110, 40));

        btnadd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 271, 110, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("School year:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, -1));

        txtyear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txtyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 110, 20));

        btnrefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnrefresh.setText("Refresh");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 10, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void tableupdate(){
        int c;
        int stuID;
        String surname;
        String firstName;
        String chinName;
        String className = "";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
            //create database connection
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
            //retrive students' information
            pst = con.prepareStatement("select * from student_info");
            rs = pst.executeQuery();
            //get jtable1 properties
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel)jTable1.getModel();
            dft.setRowCount(0);
            while (rs.next()) {
                //retrieve student id, surname, first name and chinese name
                stuID = rs.getInt("student_id"); 
                surname = rs.getString("surname"); 
                firstName = rs.getString("first_name"); 
                chinName = rs.getString("chinese_name");
                //get class name
                pst1 = con.prepareStatement("select * from student_class where student_id = ? and school_year = ?");
                pst1.setInt(1, stuID);
                pst1.setString(2, year);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    int id = rs1.getInt("class_id");
                    if(id > 0){
                        pst2 = con.prepareStatement("select * from class_info where class_id = ?");
                        pst2.setInt(1, id);
                        rs2 = pst2.executeQuery();
                        while(rs2.next()){
                            className = rs2.getString("class_name");
                        }
                        Vector v2 = new Vector();
                        for(int i = 1; i<=c; i++){ 
                            v2.add(stuID);
                            v2.add(surname);
                            v2.add(firstName);
                            v2.add(chinName);
                            v2.add(className);
                        }
                        dft.addRow(v2);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void btndoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoneActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btndoneActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Please select one record", "Error", JOptionPane.OK_OPTION);
        } else if (jTable1.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "Please select one record only", "Error", JOptionPane.OK_OPTION);
        } else {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();
            String id = model.getValueAt(selectedIndex, 0).toString();
            int stuID = Integer.parseInt(id);
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Remove student from class", JOptionPane.YES_NO_OPTION);
            if(confirm == 0){
                try {
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
                    con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb");
                    pst = con.prepareStatement("delete from student_class where student_id = ? and school_year = ?");
                    pst.setInt(1, stuID);
                    pst.setString(2, year);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record has been deleted", "Record deleted", JOptionPane.PLAIN_MESSAGE);
                    tableupdate();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        addStudentClass gui = new addStudentClass();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                tableupdate();
            }
        });
    }//GEN-LAST:event_btnaddActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        if(jTable1.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Please select one record", "Error", JOptionPane.OK_OPTION);
        } else if (jTable1.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "Please select one record only", "Error", JOptionPane.OK_OPTION);
        } else {
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();
            String id = model.getValueAt(selectedIndex, 0).toString();
            studentID = Integer.parseInt(id);
        
            editStudentClass gui;
            gui = new editStudentClass();
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

    private void txtsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnsearch.doClick();
        } 
    }//GEN-LAST:event_txtsearchKeyPressed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        String input = txtsearch.getText(); //get result of search
        String search = input.substring(0,1).toUpperCase() + input.substring(1);
        int c;
        int stuID;
        String surname;
        String firstName;
        String chinName;
        String gender;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
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
                    gender = rs.getString("gender"); //retrieve gender in the row
                
                    Vector v2 = new Vector();
                    for(int i = 1; i<=c; i++){ 
                        v2.add(stuID);
                        v2.add(surname);
                        v2.add(firstName);
                        v2.add(chinName);
                        v2.add(gender);
                    }
                    dft.addRow(v2);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(students.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        tableupdate();
    }//GEN-LAST:event_btnrefreshActionPerformed

      
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
            java.util.logging.Logger.getLogger(studentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentClass().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btndone;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtsearch;
    private javax.swing.JLabel txtyear;
    // End of variables declaration//GEN-END:variables
}
