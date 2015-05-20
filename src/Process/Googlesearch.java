/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Data.*;
import static Process.checkLog.conn;
import static Process.checkLog.pst;
import static Process.checkLog.rs;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tiendat
 */
public class Googlesearch {

    public static Connection conn = Connect.getConnect();
    public static ResultSet rs = null;
    public static PreparedStatement pst = null;

    public static void loaddataCombo(String sql, DefaultComboBoxModel model, int columnIndex, JComboBox cbb) {
        model.removeAllElements();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                model.addElement(rs.getString(columnIndex));
            }
            cbb.setModel(model);
            rs.close();
            pst.close();
        } catch (Exception e) {
        }
    }

    public static void loadtable(String st1,String st2,JTable tb) {
        String sql =st1 + st2 + "'";
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
