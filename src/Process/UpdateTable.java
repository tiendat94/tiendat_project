/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import java.sql.*;
import javax.swing.*;
import Data.*;
import static Process.Googlesearch.conn;
import static Process.Googlesearch.pst;
import static Process.Googlesearch.rs;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.*; 
/**
 *
 * @author tiendat
 */
public class UpdateTable {
    public static PreparedStatement pst = null; //hien thuc thi sql
    public static ResultSet rs = null; //ket qua tra ve dang 1 bang hay 1 dong du lieu
    public static Connection conn = Connect.getConnect(); //lay tu lop co ban ket noi data
    //ham nap du lieu cho bang
    public static void LoadData(String sql, JTable tb){
        DefaultTableModel tablemodel = new DefaultTableModel();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData metadata = rs.getMetaData();
            int numberColums = metadata.getColumnCount();
            ArrayList arraycolum = new ArrayList();
            for (int i = 1; i <= numberColums; i++) {
                arraycolum.add(metadata.getColumnName(i));
            }
            tablemodel.setColumnIdentifiers(arraycolum.toArray());
            ArrayList arrayrow = new ArrayList();
            while (rs.next()) {
                for (int i = 1; i <= numberColums; i++) {
                    arrayrow.add(rs.getString(i));
                }
                tablemodel.addRow(arrayrow.toArray());
                arrayrow.clear();
            }
            tb.setModel(tablemodel);
            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", 1);
        }
    }
    //phuong thuc nay dung de do 1 dong du lieu len textfield
    public static ResultSet ShowTextField(String sql){
        try{
            pst = conn.prepareStatement(sql);
          return  pst.executeQuery();
          //tra ve 1 dong du lieu doc duoc
        }
        catch(Exception e){
           // JOptionPane.showMessageDialog(null, e,"thong bao loi ",1)
      return null;
        }
    }
    
    
    
}
