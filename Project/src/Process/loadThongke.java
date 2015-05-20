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

    public static void loadTensach( JTable tb) {
        String sql = "SELECT tuasach.MaTuaSach,TenSach,TenLinhVuc,count(*) as SoLuong FROM sach,tuasach,linhvuc where sach.MaTuaSach=tuasach.MaTuaSach and linhvuc.MaLV=tuasach.MaLV group by tuasach.MaTuaSach";
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
    public static void loadNgonngu( JTable tb) {
        String sql = "SELECT ngonngu.TenNgonNgu,count(*) as SoLuong FROM sach,tuasach,ngonngu where sach.MaTuaSach=tuasach.MaTuaSach and tuasach.mangonngu=ngonngu.MaNgonNgu group by ngonngu.MaNgonNgu";
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
    public static void loadTacgia( JTable tb) {
        String sql = "SELECT tacgia.TenTacGia,count(*) as SoLuong FROM sach,tuasach,tacgia where sach.MaTuaSach=tuasach.MaTuaSach and tuasach.MaTG = tacgia.maTG group by tacgia.TenTacGia";
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
    public static void loadDocumentLending( JTable tb) {
        String sql = "SELECT sach.MaSach,tuasach.TenSach FROM sach,tuasach\n" +
                     "where sach.MaTuaSach=tuasach.MaTuaSach and sach.MaPhieu!=?";
        DefaultTableModel tablemodel = new DefaultTableModel();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1," ");
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
    public static void loadDocumentOutOfDate( JTable tb) {
        String sql = "SELECT sach.MaSach,tuasach.TenSach,phieumuon.NgayHenTra,phieumuon.NgayTra FROM sach,phieumuon,tuasach\n" +
                     "where sach.MaTuaSach=tuasach.MaTuaSach and phieumuon.MaPhieu=sach.MaPhieu and phieumuon.NgayTra>phieumuon.NgayHenTra";
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
    public static void loadReadersList( JTable tb) {
        String sql = "SELECT MaDG,TenDG as TenDocGia,KhoaHoc,diachi as LopHoc FROM docgia";
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
                for (int i = 0; i < numberColums; i++) {
                    arrayrow.add(rs.getString(i+1));
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
