/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import java.sql.*;
import javax.swing.*;
import Data.*;
import Main.Author;

/**
 *
 * @author tiendat
 */
public class Tacgia {
    public static Connection conn = Connect.getConnect();
    public static PreparedStatement pst =null;
    public static ResultSet rs = null;

    
    public static void InsertTG(String matg, String Tentg,String diachi){
        String sql  = "INSERT INTO quanlythuvien.tacgia(MaTG,TenTacGia,DiaChi) VALUES (?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, matg);
            pst.setString(2, Tentg);
            pst.setString(3, diachi);
            pst.execute();
            JOptionPane.showMessageDialog(null,"đã thêm tác giả"+Tentg+"thành công ","thông báo",1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Mã tác giả "+matg+"đã tồn tại không thể thêm","thông báo",1);
            
        }
    }
    public static void UpdateTG(String matg1, String matg,String Tentg,String diachi){
        String sql = "UPDATE `quanlythuvien`.`tacgia` SET `MaTG`='"+matg+"', `TenTacGia`='"+Tentg+" ', `DiaChi`='"+diachi+"' WHERE `MaTG`='"+matg1+"'";
       
        try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null ,"mã tác giả "+matg1+"đã sửa thành"+matg+"thành công","thông báo",1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"mã tác giả "+matg1+"có thể tồn tại trước đó không thể sửa","thông báo",1);
        }
    }  
    public static void DeleteTG(String matg){
        String sql ="DELETE FROM `quanlythuvien`.`tacgia` WHERE `MaTG`='"+matg+"'";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"tác giả"+matg+"đã được xóa","thông báo",1);
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,"tác giả"+matg+"đã được sử dụng không xóa được","thông báo",1);
            
        }
    }
    
    
}
