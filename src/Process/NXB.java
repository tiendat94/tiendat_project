/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import javax.swing.*;
import java.sql.*;
import Data.*;
import Main.Publisher;
import static Process.Tacgia.conn;
import static Process.Tacgia.pst;

/**
 *
 * @author tiendat
 */
public class NXB {
    public static Connection conn = Connect.getConnect();
    public static ResultSet rs = null;
    public static PreparedStatement pst = null;
    public static void InsertNXB(String maNXB, String TenNXB,String diachi,String phone){
        String sql11 ="INSERT INTO quanlythuvien.nhaxuatban (MaNXB,TenNXB,DiaChi,DienThoai) VALUES (?,?,?,?)";
           try{
            pst = conn.prepareStatement(sql11);
            pst.setString(1, maNXB);
            pst.setString(2, TenNXB);
            pst.setString(3, diachi);
            pst.setString(4, phone);
            pst.execute();
            JOptionPane.showMessageDialog(null,"đã thêm nhà xuất bản "+TenNXB+"thành công ","thông báo",1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Mã tác giả "+maNXB+"đã tồn tại không thể thêm","thông báo",1);
            
        }
    }
  public static void UpdateNXB(String maNXB1, String maNXB, String TenNXB,String diachi,String phone){
        String sql =" UPDATE `quanlythuvien`.`nhaxuatban` SET `MaNXB`='"+maNXB+"', `TenNXB`='"+TenNXB+"', `DiaChi`='"+diachi+"', `DienThoai`='"+phone+"' WHERE `MaNXB`='"+maNXB1+"' ";
         try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"mã nhà xuất bản "+maNXB1+"đã sửa thành"+maNXB+"thành công","thong bao",1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"mã nhà xuất  "+maNXB1+"co the da ton tai truoc do khong the sua","thong bao",1);
        }
    
    }
  
    public static void DeleteNXB(String maNXB){
        String sql = "DELETE FROM `quanlythuvien`.`nhaxuatban` WHERE `MaNXB`='"+maNXB+"'";
         try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Nhà Xuất Bản"+maNXB+"đã được xóa","thong bao",1);
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,"nhà xuất bản"+maNXB+"co the duoc su dung o doi tuong khac nen khong duoc xoa","thong bao",1);
            
        }
        
    }
    
}
