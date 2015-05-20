/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Data.Connect;
import static Process.MuonTra.conn;
import static Process.MuonTra.pst;
import static Process.MuonTra.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class Them {
    public static Connection conn = Connect.getConnect();
    public static ResultSet rs = null;
    public static PreparedStatement pst = null;
    
    public static Vector<String> truyvan(String sql){
        Vector<String> vt = new Vector<String>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                vt.addElement(rs.getString(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kết nối dữ liệu thất bại");
        }
        return vt;
    }
    
    public static String truyvanxau(String sql){
        String str = "";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                str = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kết nối dữ liệu thất bại");
            
        }
        return null;
    }
    
    
    
    public static void themSach(String str){
        try {
            pst = conn.prepareStatement(str);
            int a  = pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Không update được dữ liệu ");
        }
    }
}
