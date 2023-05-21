/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.entityNhanVien;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HungNguyen
 */
public class daoNhanVien {
    public static List<entityNhanVien> getAllNV() throws SQLException, ClassNotFoundException
    {
    List<entityNhanVien> lstNV = new ArrayList<>();
    Connection con;
    con = ketnoi.Connect.getConnection();
    String sql = "Select * from NhanVien";
        PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            entityNhanVien nv = new entityNhanVien();
            nv.setAnhNV(rs.getBytes("AnhNV"));
            nv.setTenNV(rs.getString("TenNV"));
            nv.setSDTNV(rs.getInt("SDTNV"));
            lstNV.add(nv);
        }
        return lstNV; 
    }
    
    public static List<entityNhanVien> getOneNV(String TenNV) throws SQLException, ClassNotFoundException
    {
    List<entityNhanVien> lstNV = new ArrayList<>();
    Connection con;
    con = ketnoi.Connect.getConnection();
    String sql = "Select * from NhanVien where TenNV = '"+TenNV+"'" ;
        PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            entityNhanVien nv = new entityNhanVien();
            nv.setTenNV(rs.getString("TenNV"));
            nv.setSDTNV(rs.getInt("SDTNV"));
            lstNV.add(nv);
        }
        return lstNV;
    }
    
    public static void DeleteNV(String TenNV) throws ClassNotFoundException, SQLException
    {
        List<entityNhanVien> lstNV = new ArrayList<>();
        Connection con;
        con = ketnoi.Connect.getConnection();
        String sql = "delete from NhanVien where TenNV = '"+TenNV+"'";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.executeUpdate();
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);
    }
    
    public static void InsertNV(entityNhanVien nv1, String imagePath) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException
    {
    Connection con = null;
    PreparedStatement pStmt = null;
    
    try {
        con = ketnoi.Connect.getConnection();
        String sql = "INSERT INTO NhanVien (AnhNV, TenNV, SDTNV) VALUES (?, ?, ?)";
        // Đọc dữ liệu ảnh từ tệp tin
        File imageFile = new File(imagePath);
        FileInputStream fis = new FileInputStream(imageFile);
        int imageLength = (int) imageFile.length();
        byte[] imageData = new byte[imageLength];
        fis.read(imageData);
        fis.close();
        
        pStmt = con.prepareStatement(sql);
        pStmt.setBytes(1, imageData);
        pStmt.setString(2, nv1.getTenNV());
        pStmt.setInt(3, nv1.getSDTNV());
        pStmt.executeUpdate();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);
    }
    }
    
    public static void UpdateNV(entityNhanVien nv1) throws SQLException, ClassNotFoundException
    {
        Connection con;
        con = ketnoi.Connect.getConnection();
        String sql = "update NhanVien set SDTNV = '"+nv1.getSDTNV()+"', where TenNV ='"+nv1.getTenNV()+"'";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.executeUpdate();
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);
    }
}
