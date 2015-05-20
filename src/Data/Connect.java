/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author HoangDuoc
 */
public class Connect {

    public static Connection getConnect() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlythuvien", "root", "muathuvang");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ket noi co so du lieu that bai", "Warning", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

}
