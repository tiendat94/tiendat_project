
package Process;
import java.sql.*;
import javax.swing.*;
import Data.*;
import Main.ManagementUser;
/**
 *
 * @author tiendat
 */
public class User {
    public static Connection conn = Connect.getConnect();
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static void InsertDG(String madocgia, String tendocgia){
        String sql = "INSERT INTO `quanlythuvien`.`docgia` (`MaDG`, `TenDG`) VALUES (?, ?);";
        try{
           pst = conn.prepareStatement(sql);
           pst.setString(1, madocgia);
           pst.setString(2, tendocgia);
           pst.execute();
           JOptionPane.showMessageDialog(null,"đã thêm độc giả "+tendocgia+"thành công","thông báo",1);
           
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Mã độc giả "+madocgia+"đã tồn tại không thể thêm","thông báo",1);
        }
    }
    public static void UpdateDG(String madocgia1,String madocgia,String tendocgia){
        String sql ="UPDATE `quanlythuvien`.`docgia` SET `MaDG`='"+madocgia+"', `TenDG`='"+tendocgia+"' WHERE `MaDG`='"+madocgia1+"' ";
        try{
             pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"độc giả"+madocgia1+"đã sửa thành "+madocgia+"thành công","thông báo",1);
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,"độc giả "+madocgia1+"có thể đã tồn tại trước đó không thể thêm","thông báo",1); 
        }
    }
    public static void DeleteDG(String madocgia){
       String sql ="DELETE FROM `quanlythuvien`.`docgia` WHERE `MaDG`='"+madocgia+"'"; 
       try{
           pst = conn.prepareStatement(sql);
           pst.execute();
           JOptionPane.showMessageDialog(null,"lớp"+madocgia+"đã được xóa","thông báo",1);
       }catch(Exception e){
             JOptionPane.showMessageDialog(null,"lớp"+madocgia+"có thể được sử dụng ở đối tượng khác nên không được xóa","thông báo",1);
       }
    }

    }

