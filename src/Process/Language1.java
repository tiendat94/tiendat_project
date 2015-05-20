/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;
import javax.swing.*;
import java.sql.*;
import Data.*;
import static Process.Tacgia.conn;
import static Process.Tacgia.pst;
/**
 *
 * @author tiendat
 */
public class Language1 {
    public static Connection conn = Connect.getConnect();
    public static ResultSet rs = null;
    public static PreparedStatement pst = null;
    
    public static void InsertNN(String MaNN, String TenNN){
        String sql1 = "INSERT INTO `quanlythuvien`.`ngonngu` (`MaNgonNgu`, `TenNgonNgu`) VALUES (?,?)";
         try{
            pst = conn.prepareStatement(sql1);
            pst.setString(1, MaNN);
            pst.setString(2, TenNN);
            pst.execute();
            JOptionPane.showMessageDialog(null,"đã thêm ngon ngu"+TenNN+"thành công ","thông báo",1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Mã ngon ngu "+MaNN+"đã tồn tại không thể thêm","thông báo",1);
            
        }
    }
    public static void UpdateNN(String maNN1, String maNN,String TenNN){
        String sql ="UPDATE `quanlythuvien`.`ngonngu` SET `MaNgonNgu`='"+maNN+"',`TenNgonNgu`='"+TenNN+"' WHERE `MaNgonNgu`='"+maNN1+"'";
         try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"mã ngôn ngữ"+maNN1+"đã sửa thành"+maNN+"thanh cong","thong bao",1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"mã ngôn ngữ "+maNN1+"co the da ton tai truoc do khong the sua","thong bao",1);
        }
    }  
    public static void DeleteNN(String maNN){
        String sql ="DELETE FROM `quanlythuvien`.`ngonngu` WHERE `MaNgonNgu`='"+maNN+"'";
         try{
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Ngôn ngữ"+maNN+"da duoc xoa","thong bao",1);
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,"Ngôn Ngữ"+maNN+"co the duoc su dung o doi tuong khac nen khong duoc xoa","thong bao",1);
            
        }
    }
    }
    

