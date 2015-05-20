/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Data.*;
import static Process.Googlesearch.conn;
import static Process.Googlesearch.pst;
import static Process.Googlesearch.rs;
import java.sql.*;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HoangDuoc
 */
public class loadThongke {

   public static Connection conn = Connect.getConnect();
   public static ResultSet rs = null;
   public static PreparedStatement pst = null;

    public static void loadDocument(String st, JTable tb) {
        String sql = st;
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
}