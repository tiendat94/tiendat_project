/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Data.Connect;
import static Process.MuonTra.catXau;
import static Process.MuonTra.conn;
import static Process.MuonTra.noiXau;
import static Process.MuonTra.pst;
import static Process.MuonTra.rs;
import static Process.MuonTra.update;
import static Process.MuonTra.xoaDuLieu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenthienbao
 */
public class Xoa {
    public static Connection conn = Connect.getConnect();
    public static ResultSet rs = null;
    public static PreparedStatement pst = null;
    
    public static void xoaDuLieu(JTable tb){
        DefaultTableModel tablemodel = (DefaultTableModel) tb.getModel();
        int size = tb.getRowCount();
        
        if (size < 0){
            return ;
        }
        for (int i = 0 ; i < size ; i++){
            tablemodel.removeRow(0);
        }
        
        tb.repaint();
    }
    
    public static void loadtableTen(String strMSS, JTable tb) {
        xoaDuLieu(tb);
        int i = 1;
        String str="";
        if (strMSS.equals("") == false){
            str = " and sach.masach = " + catXau(strMSS);
        }
        String sql = "select sach.MaTuaSach, sach.MaSach,tuasach.TenSach, tuasach.giasach, tuasach.SoTrang, ngonngu.TenNgonNgu, tacgia.TenTacGia, nhaxuatban.TenNXB, linhvuc.TenLinhVuc\n" +
"from sach, tuasach, ngonngu, tacgia, nhaxuatban, linhvuc\n" +
"where sach.MaTuaSach = tuasach.MaTuaSach and tuasach.MaNgonNgu = ngonngu.MaNgonNgu and tacgia.MaTG = tuasach.MaTG and nhaxuatban.MaNXB = tuasach.MaNXB and linhvuc.MaLV = tuasach.MaLV\n" +
"" + str;

        
        DefaultTableModel tablemodel = (DefaultTableModel) tb.getModel();
       
        
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            ArrayList arrayrow = new ArrayList();
            while (rs.next()) {
                arrayrow.add(""+i);
                arrayrow.add(noiXau(rs.getString(1),rs.getString(2)));
                arrayrow.add(rs.getString(3));
                arrayrow.add(rs.getString(4));
                arrayrow.add(rs.getString(5));
                arrayrow.add(rs.getString(6));
                arrayrow.add(rs.getString(7));
                arrayrow.add(rs.getString(8));
                arrayrow.add(rs.getString(9));
                arrayrow.add(new Boolean(false));
                tablemodel.addRow(arrayrow.toArray());
                arrayrow.clear();
                i++;
            }
            tb.setModel(tablemodel);
            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", 1);
        }
    }
    
    public static void xoa(String str){
        String sql = "delete from sach where MaSach = " + str;
        update(sql);
    }
}
