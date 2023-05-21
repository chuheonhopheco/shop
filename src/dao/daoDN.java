/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.entityDN;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javax.management.remote.JMXConnectorFactory.connect;
/**
 *
 * @author HungNguyen
 */
public class daoDN {
    public static List<entityDN> getOneNV(String _txtTaiKhoan, String _txtMatKhau) throws ClassNotFoundException, SQLException
    {
        List<entityDN> lstNguoiDung = new ArrayList<>();
        Connection con;
        con = ketnoi.Connect.getConnection();
        String sql = "Select * from NguoiDung where TaiKhoan = '"+_txtTaiKhoan+"' and MatKhau = '"+_txtMatKhau+"'";
        PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next())
        {
            entityDN ndx = new entityDN();
            ndx.setTaiKhoan(rs.getString("TaiKhoan"));
            ndx.setMatKhau(rs.getString("MatKhau"));
            lstNguoiDung.add(ndx);
        }
        return lstNguoiDung;        
    }
}
