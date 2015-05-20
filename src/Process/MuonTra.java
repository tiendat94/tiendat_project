/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Data.Connect;
import Main.MuonSach;
import static Process.Googlesearch.conn;
import static Process.Googlesearch.pst;
import static Process.Googlesearch.rs;
import static Process.MuonTra.conn;
import static Process.MuonTra.pst;
import static Process.MuonTra.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tiendat
 */
public class MuonTra {
    public static Connection conn = Connect.getConnect();
    public static ResultSet rs = null;
    public static PreparedStatement pst = null;
    static Calendar cal = Calendar.getInstance();
    
    public static String inNgayHienTai(){
        
        return ""+cal.get(Calendar.YEAR) +"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
    }
    
    public static String inNgayTra(){
        
        int year  = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DATE);
        month = month + 3;
        if (month > 12){
            month = month - 12;
            year ++;
        }
        return ""+year+"-"+month+"-"+day;
    }
    
    
    
    //lấy số sách da mượn
    public static int getCount(String str){
        int number = 0;
        System.out.println("anh day em");
        try {
            pst = conn.prepareStatement("select count(*) from sachmuon, phieumuon where phieumuon.maphieu = sachmuon.maphieumuon and phieumuon.maDG = '"+str+"' and phieumuon.maDG is not null");
            rs = pst.executeQuery();
            if (rs.next() == true){
                
                number = Integer.parseInt(rs.getString(1));
            }
            System.out.println(number);
            pst = conn.prepareStatement("select count(*) from sachtra, phieutra where phieutra.maphieutra = sachtra.maphieutra and phieutra.maDG = '"+str+"' and phieutra.maDG is not null");
            rs = pst.executeQuery();
            if (rs.next() == true){
                 System.out.println(number - Integer.parseInt(rs.getString(1)));
                return number - Integer.parseInt(rs.getString(1));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(MuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    //Lấy thong tin nguoi muon mượn
    public static ArrayList<String> getMSND(){
        String command ="select MaDG , TenDG from docgia";
        ArrayList<String> array = new ArrayList<String>();
        try {
            pst = conn.prepareStatement(command);
            rs = pst.executeQuery();
            while (rs.next()){
                array.add(rs.getString(1));
                array.add(rs.getString(2));
                
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không kết nối được dữ liệu");
            return null;
        }
        return array;
    }
    
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
    
    public static int maxPhieuMuon(){
        try {
            String str = "select maphieu from phieumuon";
            int number = 0, trunggian =0;
            pst = conn.prepareStatement(str);
            rs = pst.executeQuery();
            while (rs.next()){
                number = Integer.parseInt(catXau(rs.getString(1)));
                if (number > trunggian){
                    trunggian = number;
                }
            }
            return trunggian;
        } catch (SQLException ex) {
            Logger.getLogger(MuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int maxPhieuTra(){
        try {
            String str = "select maphieutra from phieutra";
            int number = 0, trunggian =0;
            pst = conn.prepareStatement(str);
            rs = pst.executeQuery();
            while (rs.next()){
                number = Integer.parseInt(catXau(rs.getString(1)));
                if (number > trunggian){
                    trunggian = number;
                }
            }
            return trunggian;
        } catch (SQLException ex) {
            Logger.getLogger(MuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static void update(String str){
        try {
            pst = conn.prepareStatement(str);
            int a  = pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không update được dữ liệu ");
        }
        
    }
    
    public static void updateValue(Vector<String> vt, String manhanvien, String manguoidung){
        
            
            int size = vt.size();
            String str = "";
            String sql = "";
            int a;
            int number = maxPhieuMuon();
            str = noiXau("PM",""+(number+1));
            sql = "INSERT INTO phieumuon (`MaPhieu`, `NgayLap`, `NgayHenTra`, `MaNV`, `MaDG`) VALUES ('"+str+"', '"+inNgayHienTai()+"', '"+inNgayTra()+"', '"+manhanvien+"', '"+manguoidung+"')";
            update(sql);
            System.out.println("vbdsjbvjksd");
            for (int i = 0 ; i < size; i ++){
                System.out.println(vt.get(i));
                sql = "insert into sachmuon values (  '"+catXau(vt.get(i))+"','"+str+"' )";
                update(sql);
            }
        
    }
    
    public static void updateTraSach(Vector<String> vt, String maDG, String maNV){
        int size = vt.size();
            String str = "";
            String sql = "";
            int a;
            int number = maxPhieuTra();
            str = noiXau("PT",""+(number+1));
            sql = "INSERT INTO phieutra (`maPhieuTra`, `NgayTra`, `MaDG`, `MaNV`) VALUES ('"+str+"', '"+inNgayHienTai()+"', '"+maDG+"', '"+maNV+"');";
            update(sql);
            System.out.println("xhvchjzx       " + str);
            System.out.println(size);
            for (int i = 0 ; i < size; i ++){
                System.out.println(vt.get(i));
                sql = "insert into sachtra values (  '"+catXau(vt.get(i))+"','"+str+"' )";
                update(sql);
            }
    }
    
    public static void loadtableTen(String strTenSach,String strMSS, JTable tb) {
        xoaDuLieu(tb);
        int i = 1;
        String str = "";
        System.out.println(kiemtraMaTuaSach(strMSS) == true);
        if ((strMSS.length() == 0)&&(strTenSach.length() == 0)){
            str = "";
        }else if (strMSS.length() > 0){
                if ((strMSS.length() != 5)){
                    System.out.println("dvbhsdbv :" + strMSS);
                    JOptionPane.showMessageDialog(null,"Ban da sai ma so sach");
                    return;
                } else if (kiemtraMaTuaSach(strMSS) == true){
                    str = "and sach.MaSach = '"+catXau(strMSS)+"'";
                }else{
                    JOptionPane.showMessageDialog(null,"Ban da sai ma so sach");
                    return;
                }
            
        }else {
            str = " and tuasach.TenSach = '"+strTenSach+"'";
        }
        String sql = "select sach.matuasach, sach.MaSach, tuasach.tensach, ngonngu.tenngonngu, linhvuc.TenLinhVuc \n" +
"from sach, tuasach, linhvuc , ngonngu\n" +
"where sach.matuasach = tuasach.matuasach and tuasach.malv = linhvuc.malv  and tuasach.ChoMuon = 1 \n" +
"and tuasach.mangonngu = ngonngu.MaNgonNgu\n" +
"and (select count(*) from sachmuon where sachmuon.MaSach = sach.MaSach and sachmuon.MaSach is not null) = "
                + "(select count(*) from sachtra where sachtra.MaSach = sach.MaSach and sachtra.MaSach is not null) " + str;
                

        
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
                arrayrow.add(new Boolean(false));
                arrayrow.add(true);
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
    
    public static void loadtableTra(String strMSS,String msDG, JTable tb) {
        xoaDuLieu(tb);
        int i = 1;
        String str = "";
        if (strMSS.length() == 0){
            str = "";
        }else {
                if ((strMSS.length() != 5)){
                    JOptionPane.showMessageDialog(null,"Ban da sai ma so sach");
                    return;
                } else if (kiemtraMaTuaSach(strMSS) == true){
                    str = "and sach.MaSach = '"+catXau(strMSS)+"'";
                }else{
                    JOptionPane.showMessageDialog(null,"Ban da sai ma so sach");
                    return;
                }
            
        }
        String sql = "select distinct st1.masach , tuasach.MaTuaSach , tuasach.TenSach, ngonngu.TenNgonNgu, linhvuc.TenLinhVuc\n" +
"from sachmuon as st1 , sach, tuasach, ngonngu, linhvuc\n" +
"where st1.MaSach = sach.masach and sach.MaTuaSach = tuasach.matuasach and tuasach.MaNgonNgu = ngonngu.MaNgonNgu and tuasach.MaLV = linhvuc.MaLV\n" +
"and (select count(*) from sachmuon, phieumuon where sachmuon.MaSach = st1.masach and sachmuon.MaPhieuMuon = phieumuon.MaPhieu and phieumuon.maDG = '"+msDG+"' and sachmuon.masach is not null) >\n" +
" (select count(*) from sachtra, phieutra where sachtra.MaSach = st1.masach and sachtra.maPhieuTra = phieutra.maPhieuTra and phieutra.MaDG = '"+msDG+"' and sachtra.masach is not null)" + str;

        
        DefaultTableModel tablemodel = (DefaultTableModel) tb.getModel();
       
        
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            ArrayList arrayrow = new ArrayList();
            while (rs.next()) {
                arrayrow.add(""+i);
                arrayrow.add(noiXau(rs.getString(2),rs.getString(1)));
                arrayrow.add(rs.getString(3));
                arrayrow.add(rs.getString(4));
                arrayrow.add(rs.getString(5));
                arrayrow.add(new Boolean(false));
                arrayrow.add(true);
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
    
    
    
    public static String catXauDau(String str){
        if (str.length() < 5){
            return null;
        }else {
            return "" + str.charAt(0) + str.charAt(1);
        }
    }
    
    
    public static boolean kiemtraMaTuaSach(String str){
        try {
            String sql = "select tuasach.MaTuaSach from tuasach";
            String st = catXauDau(str);
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()){
                if (rs.getString(1).equals(st)){
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MuonTra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static String catXau(String str){
        if (str.length() < 5){
            return null;
        }else {
            return "" + str.charAt(2) + str.charAt(3) + str.charAt(4);
        }
    }
    
    public static String noiXau(String str1, String str2){
        if (str2.length() == 1){
            return str1 + "00" + str2;
        }else if (str2.length() == 2){
            return str1 + "0" + str2;
        }else return str1 + str2;
      
    }

    

    
}
