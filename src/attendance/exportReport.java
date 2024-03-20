/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exportReport extends javax.swing.JFrame {

    /**
     * Creates new form exportReport
     */
    public exportReport() {
        initComponents();
        setLocationRelativeTo(null);
        System.out.println(type);
    }

    //initialize variables
    int type = showReport.reporttype;
    static String sklyr = mainScreen.schoolYear;
    static Connection con;
    static PreparedStatement pst;
    static PreparedStatement pst1;
    static PreparedStatement pst2;
    static PreparedStatement pst3;
    static ResultSet rs;
    static ResultSet rs1;
    static ResultSet rs2;
    static ResultSet rs3;
    ResultSet rst;
    static int stuid;
    static String surname;
    static String firstName;
    static String chinName;
    static int classid;
    static String clas;
    static int percentage;
    static int count = 0;
    static int total = 1;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnexport = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Export Report");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Save as...");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 60, 20));

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 190, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText(".xlsx");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 31, 20));

        btnexport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnexport.setText("Export");
        btnexport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportActionPerformed(evt);
            }
        });
        jPanel1.add(btnexport, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 80, 30));

        btncancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel1.add(btncancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void exportExcel(int type) throws ParseException, ClassNotFoundException, SQLException{
        switch (type) {
        //attendance award
            case 1:
                try{
                    Cell cell;
                    //Create workbook in .xlsx format
                    Workbook workbook = new XSSFWorkbook();
                    //Custom sheet name
                    String sheetName = "Attendance award";
                    //Create Sheet
                    Sheet sh = workbook.createSheet(sheetName);
                    //Create title font
                    Font titleFont = workbook.createFont();
                    titleFont.setBold(true);
                    titleFont.setFontHeightInPoints((short)14);
                    titleFont.setColor(IndexedColors.BLACK.index);
                    //Create a CellStyle with the font
                    CellStyle titleStyle = workbook.createCellStyle();
                    titleStyle.setFont(titleFont);
                    //Create top row with title
                    Row row1 = sh.createRow(0);
                    sh.addMergedRegion(CellRangeAddress.valueOf("A1:C1"));
                    cell = row1.createCell(0);
                    cell.setCellValue("Attendance Award Report");
                    cell.setCellStyle(titleStyle);
                    //Create second row with school year
                    Row row2 = sh.createRow(1);
                    cell = row2.createCell(0);
                    cell.setCellValue("School year:");
                    Cell cell1 = row2.createCell(1);
                    cell1.setCellValue(sklyr);
                    //Create fourth row with column headings
                    String[] columnHeadings = {"Student ID", "Surname", "First Name", "Chinese Name", "Class", "Percentage"};
                    //We want to make it bold with a foreground color.
                    Font headerFont = workbook.createFont();
                    headerFont.setBold(true);
                    headerFont.setFontHeightInPoints((short)11);
                    headerFont.setColor(IndexedColors.BLACK.index);        
                    //Create a CellStyle with the font
                    CellStyle headerStyle = workbook.createCellStyle();
                    headerStyle.setFont(headerFont);
                    //Create the header row in row 4
                    Row headerRow = sh.createRow(3);
                    //Iterate over the column headings to create columns
                    for(int i=0;i<columnHeadings.length;i++) {
                        cell = headerRow.createCell(i);
                        cell.setCellValue(columnHeadings[i]);
                        cell.setCellStyle(headerStyle);
                    }
                    //Fill data
                    LinkedList<student> a = AAcreateData();
                    int rownum = 4;
                    int dataRow =4;
                    for(student i : a) {
                        Row row = sh.createRow(rownum++);
                        row.createCell(0).setCellValue(i.getstuid());
                        row.createCell(1).setCellValue(i.getsurname());
                        row.createCell(2).setCellValue(i.getfirstName());
                        row.createCell(3).setCellValue(i.getchinName());
                        row.createCell(4).setCellValue(i.getclas());
                        row.createCell(5).setCellValue(i.getpercentage());
                        dataRow = rownum;
                    }
                    //Create "summary" line two rows below
                    sh.createRow(rownum++);
                    Row summaryRow = sh.createRow(rownum++);
                    cell = summaryRow.createCell(0);
                    cell.setCellValue("Summary");
                    cell.setCellStyle(headerStyle);
                    //Create the columns of summary table
                    Row summaryTableRow = sh.createRow(rownum++);
                    cell = summaryTableRow.createCell(0);
                    cell.setCellValue("Class");
                    cell.setCellStyle(headerStyle);
                    cell = summaryTableRow.createCell(1);
                    cell.setCellValue("Total no. of awards");
                    cell.setCellStyle(headerStyle);
                    //Create the rows for the summary table
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
                    con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb"); //create database connection
            
                    pst = con.prepareStatement("select class_name from class_info");
                    rs = pst.executeQuery();
                    while(rs.next()){
                        String className = rs.getString("class_name");
                        Row class1 = sh.createRow(rownum++);
                    Cell classname1 = class1.createCell(0);
                    classname1.setCellValue(className);
                    String strFormula1 = "COUNTIF(E2:E"+dataRow+", \""+className+"\")";    
                    Cell classcount1 = class1.createCell(1);
                    classcount1.setCellFormula(strFormula1);
                    classcount1.setCellValue(true);
                    }
                    //Autosize columns
                    for(int i=0;i<columnHeadings.length;i++) {
                        sh.autoSizeColumn(i);
                    }
                    //Custom file name
                    String fileName = txtname.getText();
                    //Write the output to file
                    FileOutputStream fileOut = new FileOutputStream("C:/TakeAttendance/Excel files/"+fileName+".xlsx");
                    workbook.write(fileOut);
                    fileOut.close();
                    workbook.close();
                    System.out.println("Completed");
                }
                catch(IOException | IllegalStateException | FormulaParseException e){
                    e.printStackTrace();
                }
                break;
        //re-enrolment
            case 2:
                try{
                    Cell cell;
                    //Create workbook in .xlsx format
                    Workbook workbook = new XSSFWorkbook();
                    //Custom sheet name
                    String sheetName = "Re-enrolment";
                    //Create Sheet
                    Sheet sh = workbook.createSheet(sheetName);
                    //Create title font
                    Font titleFont = workbook.createFont();
                    titleFont.setBold(true);
                    titleFont.setFontHeightInPoints((short)14);
                    titleFont.setColor(IndexedColors.BLACK.index);
                    //Create a CellStyle with the font
                    CellStyle titleStyle = workbook.createCellStyle();
                    titleStyle.setFont(titleFont);
                    //Create top row with title
                    Row row1 = sh.createRow(0);
                    sh.addMergedRegion(CellRangeAddress.valueOf("A1:C1"));
                    cell = row1.createCell(0);
                    cell.setCellValue("Eligible for re-enrolment");
                    cell.setCellStyle(titleStyle);
                    //Create second row with school year
                    Row row2 = sh.createRow(1);
                    cell = row2.createCell(0);
                    cell.setCellValue("School year:");
                    Cell cell1 = row2.createCell(1);
                    cell1.setCellValue(sklyr);
                    //Create fourth row with column headings
                    String[] columnHeadings = {"Student ID", "Surname", "First Name", "Chinese Name", "Class", "Percentage"};
                    //We want to make it bold with a foreground color.
                    Font headerFont = workbook.createFont();
                    headerFont.setBold(true);
                    headerFont.setFontHeightInPoints((short)11);
                    headerFont.setColor(IndexedColors.BLACK.index);        
                    //Create a CellStyle with the font
                    CellStyle headerStyle = workbook.createCellStyle();
                    headerStyle.setFont(headerFont);
                    //Create the header row in row 4
                    Row headerRow = sh.createRow(3);
                    //Iterate over the column headings to create columns
                    for(int i=0;i<columnHeadings.length;i++) {
                        cell = headerRow.createCell(i);
                        cell.setCellValue(columnHeadings[i]);
                        cell.setCellStyle(headerStyle);
                    }
                    //Fill data
                    LinkedList<student> a = REcreateData();
                    int rownum = 4;
                    int dataRow =4;
                    for(student i : a) {
                        //System.out.println("rownum-before"+(rownum));
                        Row row = sh.createRow(rownum++);
                        //System.out.println("rownum-after"+(rownum));
                        row.createCell(0).setCellValue(i.getstuid());
                        row.createCell(1).setCellValue(i.getsurname());
                        row.createCell(2).setCellValue(i.getfirstName());
                        row.createCell(3).setCellValue(i.getchinName());
                        row.createCell(4).setCellValue(i.getclas());
                        row.createCell(5).setCellValue(i.getpercentage());
                        dataRow = rownum;
                    }
                    //Create "summary" line two rows below
                    sh.createRow(rownum++);
                    Row summaryRow = sh.createRow(rownum++);
                    cell = summaryRow.createCell(0);
                    cell.setCellValue("Summary");
                    cell.setCellStyle(headerStyle);
                    //Create the columns of summary table
                    Row summaryTableRow = sh.createRow(rownum++);
                    cell = summaryTableRow.createCell(0);
                    cell.setCellValue("Class");
                    cell.setCellStyle(headerStyle);
                    cell = summaryTableRow.createCell(1);
                    cell.setCellValue("Total no. of eligible students");
                    cell.setCellStyle(headerStyle);
                    //Create the rows for the summary table
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
                    con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb"); //create database connection
            
                    pst = con.prepareStatement("select class_name from class_info");
                    rs = pst.executeQuery();
                    while(rs.next()){
                        String className = rs.getString("class_name");
                        Row class1 = sh.createRow(rownum++);
                    Cell classname1 = class1.createCell(0);
                    classname1.setCellValue(className);
                    String strFormula1 = "COUNTIF(E2:E"+dataRow+", \""+className+"\")";    
                    Cell classcount1 = class1.createCell(1);
                    classcount1.setCellFormula(strFormula1);
                    classcount1.setCellValue(true);
                    }
                    //Autosize columns
                    for(int i=0;i<columnHeadings.length;i++) {
                        sh.autoSizeColumn(i);
                    }
                    //Custom file name
                    String fileName = txtname.getText();
                    //Write the output to file
                    FileOutputStream fileOut = new FileOutputStream("C:/TakeAttendance/Excel files/"+fileName+".xlsx");
                    workbook.write(fileOut);
                    fileOut.close();
                    workbook.close();
                    System.out.println("Completed");
                }
                catch(IOException | IllegalStateException | FormulaParseException e){
                    e.printStackTrace();
                }
                break;
        //full report
            case 3:
                try{
                    Cell cell;
                    //Create workbook in .xlsx format
                    Workbook workbook = new XSSFWorkbook();
                    //Custom sheet name
                    String sheetName = "Full";
                    //Create Sheet
                    Sheet sh = workbook.createSheet(sheetName);
                    //Create title font
                    Font titleFont = workbook.createFont();
                    titleFont.setBold(true);
                    titleFont.setFontHeightInPoints((short)14);
                    titleFont.setColor(IndexedColors.BLACK.index);
                    //Create a CellStyle with the font
                    CellStyle titleStyle = workbook.createCellStyle();
                    titleStyle.setFont(titleFont);
                    //Create top row with title
                    Row row1 = sh.createRow(0);
                    sh.addMergedRegion(CellRangeAddress.valueOf("A1:C1"));
                    cell = row1.createCell(0);
                    cell.setCellValue("Attendance Report (Full)");
                    cell.setCellStyle(titleStyle);
                    //Create second row with school year
                    Row row2 = sh.createRow(1);
                    cell = row2.createCell(0);
                    cell.setCellValue("School year:");
                    Cell cell1 = row2.createCell(1);
                    cell1.setCellValue(sklyr);
                    //Create third row with total number of class
                    Row row3 = sh.createRow(2);
                    cell = row3.createCell(0);
                    cell.setCellValue("Total number of lessons: ");
                    Cell cell2 = row3.createCell(1);
                    int count = 0;
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
                    con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb"); //create database connection
                    pst = con.prepareStatement("select num_of_class from school_calendar where school_year = ?");
                    pst.setString(1, sklyr);
                    rs = pst.executeQuery();
                    while(rs.next()){
                        count = rs.getInt("num_of_class");
                    }
                    cell2.setCellValue(count);
                    //Create column headings
                    LinkedList<String> l = new LinkedList();
                    l.add("Student ID");
                    l.add("Surname");
                    l.add("First name");
                    l.add("Chinese name");
                    l.add("Gender");
                    l.add("Class");
                    //add school dates to column headings
                    pst = con.prepareStatement("select class_date from school_date where school_year = ?");
                    pst.setString(1, sklyr);
                    rs = pst.executeQuery();
                    SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
                    while(rs.next()){
                        Date time = rs.getDate("class_date");
                        l.add(sdformat.format(time));
                    }
                    l.add("No. of attendance");
                    l.add("No. of late attendance");
                    l.add("Attendance rate");
                    //Create a bold font with black foreground color
                    Font headerFont = workbook.createFont();
                    headerFont.setBold(true);
                    headerFont.setFontHeightInPoints((short)11);
                    headerFont.setColor(IndexedColors.BLACK.index);        
                    //Create a CellStyle with the font
                    CellStyle headerStyle = workbook.createCellStyle();
                    headerStyle.setFont(headerFont);
                    //Create the header row in row 4
                    Row headerRow = sh.createRow(3);
                    //Iterate over the column headings to create columns
                    int num = l.size();
                    for(int i=0;i<num;i++) {
                        cell = headerRow.createCell(i);
                        cell.setCellValue(l.removeFirst());
                        cell.setCellStyle(headerStyle);
                    }
                    //Fill data
                    int id = 0;
                    int rownum = 4;
                    pst = con.prepareStatement("select student_id from student_info");
                    rst = pst.executeQuery();
                    while(rst.next()){
                        Row row = sh.createRow(rownum++);
                        id = rst.getInt("student_id");
                        LinkedList<String> a = FULLcreateData(id);
                        num = a.size();
                        for(int i=0;i<num;i++) {
                            cell = row.createCell(i);
                            cell.setCellValue(a.removeFirst());
                            cell.setCellStyle(headerStyle);
                        }
                    }
                    //Autosize columns
                    for(int i=0;i<num;i++) {
                        sh.autoSizeColumn(i);
                    }
                    //Custom file name
                    String fileName = txtname.getText();
                    //Write the output to file
                    FileOutputStream fileOut = new FileOutputStream("C:/TakeAttendance/Excel files/"+fileName+".xlsx");
                    workbook.write(fileOut);
                    fileOut.close();
                    workbook.close();
                    System.out.println("Completed");
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
    
    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        int confirm = JOptionPane.showConfirmDialog(jf, "Are you sure you want to cancel?", "Export cancel", JOptionPane.YES_NO_OPTION);
        if(confirm == 0){
            dispose();
        }
    }//GEN-LAST:event_btncancelActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
              
    }//GEN-LAST:event_txtnameActionPerformed

    private void btnexportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportActionPerformed
        JFrame jf=new JFrame();
        jf.setAlwaysOnTop(true);
        switch (type) {
            case 1: //attendance award
                try {
                    exportExcel(1);
                    JOptionPane.showMessageDialog(jf, "The excel sheet is exported at C:/TakeAttendance/Excel files/", "Report exported", JOptionPane.PLAIN_MESSAGE);
                    dispose();
                } catch (ParseException | ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(exportReport.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2: //re-enrolment
                try {
                    exportExcel(2);
                    JOptionPane.showMessageDialog(jf, "The excel sheet is exported at C:/TakeAttendance/Excel files/", "Report exported", JOptionPane.PLAIN_MESSAGE);
                dispose();
                    dispose();
                } catch (ParseException | ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(exportReport.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 3: //full report
                try {
                    exportExcel(3);
                    JOptionPane.showMessageDialog(jf, "The excel sheet is exported at C:/TakeAttendance/Excel files/", "Report exported", JOptionPane.PLAIN_MESSAGE);
                    dispose();
                } catch (ParseException | ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(exportReport.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnexportActionPerformed

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
            java.util.logging.Logger.getLogger(exportReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(exportReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(exportReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(exportReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new exportReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnexport;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
    
    private static LinkedList<student> AAcreateData() throws ParseException, ClassNotFoundException {
        LinkedList<student> a = new LinkedList();
        int value = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb"); //create database connection
            //Retrieve student id, surname, first name, chinese name, class, and attendance percentage
            pst = con.prepareStatement("select * from student_info");
            rs = pst.executeQuery();
            while(rs.next()){
                //Retrieve student id, surname, first name, chinese name
                stuid  = rs.getInt("student_id");
                surname = rs.getString("surname");
                firstName = rs.getString("first_name");
                chinName = rs.getString("chinese_name");
                //retrieve class name
                pst2= con.prepareStatement("select * from student_class where school_year = ? and student_id = ?");
                pst2.setString(1, sklyr);
                pst2.setInt(2, stuid);
                rs2 = pst2.executeQuery();
                while(rs2.next()){
                    classid = rs2.getInt("class_id");
                    pst3= con.prepareStatement("select * from class_info where class_id = ?");
                    pst3.setInt(1, classid);
                    rs3 = pst3.executeQuery();
                    while(rs3.next()){
                        clas = rs3.getString("class_name");
                    }
                }
                //retrieve percentage
                pst1 = con.prepareStatement("select num_of_class from school_calendar where school_year = ?");
                pst1.setString(1, sklyr);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    total = rs1.getInt("num_of_class");
                }
                pst1 = con.prepareStatement("select count(*) as count from attendance_log where student_id = ? and school_year = ? and late_flag = ?");
                pst1.setInt(1, stuid);
                pst1.setString(2, sklyr);
                pst1.setInt(3, 0);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    count = rs1.getInt("count");
                }
                //retrieve percentage requirement
                pst1 = con.prepareStatement("select * from settings where option = ?");
                pst1.setString(1, "att");
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    value = rs1.getInt("num");
                }
                int result = (count*100) / total;
                    if(result >= value){
                        String percent = Integer.toString(result)+"%";
                        a.add(new student(stuid, surname, firstName, chinName, clas, percent));
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(exportReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    private static LinkedList<student> REcreateData() throws ParseException, ClassNotFoundException {
        LinkedList<student> a = new LinkedList();
        int value = 0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb"); //create database connection
            //Retrieve student id, surname, first name, chinese name, class, and attendance percentage
            pst = con.prepareStatement("select * from student_info");
            rs = pst.executeQuery();
            while(rs.next()){
                //Retrieve student id, surname, first name, chinese name
                stuid  = rs.getInt("student_id");
                surname = rs.getString("surname");
                firstName = rs.getString("first_name");
                chinName = rs.getString("chinese_name");
                //retrieve class
                pst2= con.prepareStatement("select * from student_class where school_year = ? and student_id = ?");
                pst2.setString(1, sklyr);
                pst2.setInt(2, stuid);
                rs2 = pst2.executeQuery();
                while(rs2.next()){
                    classid = rs2.getInt("class_id");
                    pst3= con.prepareStatement("select * from class_info where class_id = ?");
                    pst3.setInt(1, classid);
                    rs3 = pst3.executeQuery();
                    while(rs3.next()){
                        clas = rs3.getString("class_name");
                    }
                }
                //retrieve percentage
                pst1 = con.prepareStatement("select num_of_class from school_calendar where school_year = ?");
                pst1.setString(1, sklyr);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    total = rs1.getInt("num_of_class");
                }
                pst1 = con.prepareStatement("select count(*) as count from attendance_log where student_id = ? and school_year = ? and late_flag = ?");
                pst1.setInt(1, stuid);
                pst1.setString(2, sklyr);
                pst1.setInt(3, 0);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    count = rs1.getInt("count");
                }
                //retrieve percentage requirement
                pst1 = con.prepareStatement("select * from settings where option = ?");
                pst1.setString(1, "ree");
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    value = rs1.getInt("num");
                }
                int result = (count*100) / total;
                    if(result >= value){
                        String percent = Integer.toString(result)+"%";
                        a.add(new student(stuid, surname, firstName, chinName, clas, percent));
                    }
            }
        } catch (SQLException ex) {
            Logger.getLogger(exportReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    private static LinkedList<String> FULLcreateData(int id) throws ParseException, ClassNotFoundException {
        LinkedList<String> a = new LinkedList();
        int lateCount=0;
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");  //load jdbc driver
            con = DriverManager.getConnection("jdbc:ucanaccess://C:/TakeAttendance/testdb.accdb"); //create database connection
            //Retrieve student id, surname, first name, chinese name, class, and attendance percentage
            pst = con.prepareStatement("select * from student_info where student_id = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while(rs.next()){
                //Retrieve student id, surname, first name, chinese name and gender
                stuid = rs.getInt("student_id");
                a.add(Integer.toString(stuid));
                a.add(rs.getString("surname"));
                a.add(rs.getString("first_name"));
                a.add(rs.getString("chinese_name"));
                a.add(rs.getString("gender"));
                //retrieve class
                pst2= con.prepareStatement("select * from student_class where school_year = ? and student_id = ?");
                pst2.setString(1, sklyr);
                pst2.setInt(2, stuid);
                rs2 = pst2.executeQuery();
                while(rs2.next()){
                    classid = rs2.getInt("class_id");
                    pst3= con.prepareStatement("select * from class_info where class_id = ?");
                    pst3.setInt(1, classid);
                    rs3 = pst3.executeQuery();
                    while(rs3.next()){
                        clas = rs3.getString("class_name");
                    }
                }
                a.add(clas);
                //retrieve whether student is on time or late in specific school dates
                String attend = null;
                Boolean exist = false;
                pst1 = con.prepareStatement("select * from school_date where school_year = ?");
                pst1.setString(1, sklyr);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    pst2 = con.prepareStatement("select * from attendance_log where student_id = ? and school_year = ? and attend_date = ?");
                    pst2.setInt(1, id);
                    pst2.setString(2, sklyr);
                    pst2.setDate(3, rs1.getDate("class_date"));
                    rs2 = pst2.executeQuery();
                    while(rs2.next()){
                        exist = true;
                        if(rs2.getInt("late_flag") == 0)
                            attend = "Y";
                        else if (rs2.getInt("late_flag") == 1)
                            attend = "L";
                    }
                    if(!exist)
                        attend = "N";
                    a.add(attend);
                }
                
                //retrieve percentage
                pst1 = con.prepareStatement("select num_of_class from school_calendar where school_year = ?");
                pst1.setString(1, sklyr);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    total = rs1.getInt("num_of_class");
                }
                pst1 = con.prepareStatement("select count(*) as count from attendance_log where student_id = ? and school_year = ? and late_flag = ?");
                pst1.setInt(1, stuid);
                pst1.setString(2, sklyr);
                pst1.setInt(3, 0);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    count = rs1.getInt("count");
                }
                System.out.println(stuid+" attendance count is "+count);
                a.add(Integer.toString(count));
                pst1 = con.prepareStatement("select count(*) as count from attendance_log where student_id = ? and school_year = ? and late_flag = ?");
                pst1.setInt(1, stuid);
                pst1.setString(2, sklyr);
                pst1.setInt(3, 1);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    lateCount = rs1.getInt("count");
                }
                a.add(Integer.toString(lateCount));
                int result = (count*100) / total;
                String rate = Integer.toString(result) + "%";
                a.add(rate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(exportReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
}
