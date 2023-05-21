/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.entityKHO;
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
public class daoKHO {
    public static List<entityKHO> getAllHH() throws SQLException, ClassNotFoundException
    {
    List<entityKHO> lstHH = new ArrayList<>();
    Connection con;
    con = ketnoi.Connect.getConnection();
    String sql = "Select * from KHO";
        PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            entityKHO hh = new entityKHO();
            hh.setIDSP(rs.getInt("IDSP"));
            hh.setTenSP(rs.getString("TenSP"));
            hh.setGia(rs.getFloat("Gia"));
            hh.setTenNV(rs.getString("TenNV"));
            lstHH.add(hh);
        }
        return lstHH; 
    }
    
    public static List<entityKHO> getOneHH(String ID) throws SQLException, ClassNotFoundException
    {
    List<entityKHO> lstHH = new ArrayList<>();
    Connection con;
    con = ketnoi.Connect.getConnection();
    String sql = "Select * from KHO where IDSP = '"+ID+"'" ;
        PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            entityKHO hh = new entityKHO();
            hh.setIDSP(rs.getInt("IDSP"));
            hh.setTenSP(rs.getString("TenSP"));
            hh.setGia(rs.getFloat("Gia"));
            hh.setTenNV(rs.getString("price"));
            lstHH.add(hh);
        }
        return lstHH;
    }
    
    public static void DeleteHH(String ID) throws ClassNotFoundException, SQLException
    {
        List<entityKHO> lstHH = new ArrayList<>();
        Connection con;
        con = ketnoi.Connect.getConnection();
        String sql = "delete from KHO where IDSP = '"+ID+"'";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.executeUpdate();
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);
    }
    
    public static void InsertHH(entityKHO hh1) throws ClassNotFoundException, SQLException
    {
        List<entityKHO> lstHH = new ArrayList<>();
        Connection con;
        con = ketnoi.Connect.getConnection();
        String sql = "insert into KHO(IDSP,TenSP,Gia,TenNV) values (N'"+hh1.getIDSP()+"','"+hh1.getTenSP()+"','"+hh1.getGia()+"','"+hh1.getTenNV()+"')";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.executeUpdate();
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);
    }
    
    public static void UpdateHH(entityKHO hh1) throws SQLException, ClassNotFoundException
    {
        Connection con;
        con = ketnoi.Connect.getConnection();
        String sql = "update KHO set TenSP = N'"+hh1.getTenSP()+"', Gia = '"+hh1.getGia()+"', TenNV = '"+hh1.getTenNV()+"'where IDSP ='"+hh1.getIDSP()+"'";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.executeUpdate();
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);
    }
    
    public static List<entityKHO> searchHH(String keyword) throws SQLException, ClassNotFoundException {
    Connection con = ketnoi.Connect.getConnection();
    List<entityKHO> hhList = new ArrayList<>();
    String sql = "SELECT * FROM KHO WHERE TenSP LIKE '%" + keyword + "%'";
    PreparedStatement pStmt = con.prepareStatement(sql);
    ResultSet rs = pStmt.executeQuery();

    while (rs.next()) {
        entityKHO hh = new entityKHO();
        hh.setIDSP(rs.getInt("IDSP"));
        hh.setTenSP(rs.getString("TenSP"));
        hh.setGia(rs.getFloat("Gia"));
        hh.setTenNV(rs.getString("TenNV"));
        hhList.add(hh);
    }
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);

    return hhList;
}
}


