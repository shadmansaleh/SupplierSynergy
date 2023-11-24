/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SypplierSynergy;
import java.sql.*;
/**
 *
 * @author shadman
 */
public class DBConnection {
    static Connection con = null;
    static Connection con_auth = null;
    
    public static Connection getConnection() {
        if (con != null) return con;
        String url = "jdbc:mysql://localhost:3306/SupplierSynergy";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SupplierSynergy", "root", "");            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getConnectionAuth() {
        if (con_auth != null) return con_auth;
        String url = "jdbc:mysql://localhost:3306/SupplierSynergyAuth";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            con_auth = DriverManager.getConnection("jdbc:mysql://localhost:3306/SupplierSynergyAuth", "root", "");            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return con_auth;
    }

    public static int getQueryValue(String query) {
        var res = 0;
        try {
            var con = getConnection();
            var pat = con.prepareStatement(query);
            var rs = pat.executeQuery();
            if (rs.next()) {
                res = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
