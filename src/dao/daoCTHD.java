/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.entityCTHD;
import entity.entityKHO;
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
public class daoCTHD {
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
    
    public static List<entityCTHD> getAllHD() throws SQLException, ClassNotFoundException
    {
    List<entityCTHD> lstHD = new ArrayList<>();
    Connection con;
    con = ketnoi.Connect.getConnection();
    String sql = "Select * from CTHD";
        PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            entityCTHD hd = new entityCTHD();
            hd.setIDHD(rs.getInt("IDHD"));
            hd.setTenSP(rs.getString("TenSP"));
            hd.setGia(rs.getFloat("Gia"));
            hd.setSL(rs.getInt("SL"));
            hd.setTenKH(rs.getString("TenKH"));
            hd.setSDT(rs.getInt("SDT"));
            hd.setIDSP(rs.getInt("IDSP"));
            lstHD.add(hd);
        }
        return lstHD; 
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
    
    public static List<entityCTHD> getOneHD(String ID) throws SQLException, ClassNotFoundException
    {
    List<entityCTHD> lstHD = new ArrayList<>();
    Connection con;
    con = ketnoi.Connect.getConnection();
    String sql = "Select * from CTHD where IDHD = '"+ID+"'" ;
        PreparedStatement pStmt = con.prepareStatement(sql);
        ResultSet rs = pStmt.executeQuery();
        while(rs.next()){
            entityCTHD hd = new entityCTHD();
            hd.setIDHD(rs.getInt("IDHD"));
            hd.setTenSP(rs.getString("TenSP"));
            hd.setGia(rs.getFloat("Gia"));
            hd.setSL(rs.getInt("SL"));
            hd.setTenKH(rs.getString("TenKH"));
            hd.setSDT(rs.getInt("SDT"));
            hd.setIDSP(rs.getInt("IDSP"));
            lstHD.add(hd);
        }
        return lstHD; 
    }
    
    public static void DeleteHD(String ID) throws ClassNotFoundException, SQLException
    {
        List<entityCTHD> lstHD = new ArrayList<>();
        Connection con;
        con = ketnoi.Connect.getConnection();
        String sql = "delete from CTHD where IDHD = '"+ID+"'";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.executeUpdate();
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);
    }
    
    public static void InsertHD(entityCTHD hd1) throws ClassNotFoundException, SQLException
    {
        List<entityKHO> lstHD = new ArrayList<>();
        Connection con;
        con = ketnoi.Connect.getConnection();
        String sql = "insert into CTHD(IDHD,TenSP,Gia,SL,TenKH,SDT,IDSP) values (N'"+hd1.getIDHD()+"','"+hd1.getTenSP()+"','"+hd1.getGia()+"','"+hd1.getSL()+"','"+hd1.getTenKH()+"','"+hd1.getSDT()+"','"+hd1.getIDSP()+"')";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.executeUpdate();
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);
    }
    
    public static void UpdateHD(entityCTHD hd1) throws SQLException, ClassNotFoundException
    {
        Connection con;
        con = ketnoi.Connect.getConnection();
        String sql = "update CTHD set TenSP = N'"+hd1.getTenSP()+"', Gia = '"+hd1.getGia()+"', SL = '"+hd1.getSL()+"', TenKH = '"+hd1.getTenKH()+"', SDT = '"+hd1.getSDT()+"', IDSP = '"+hd1.getIDSP()+"' where IDHD ='"+hd1.getIDHD()+"'";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.executeUpdate();
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);
    }
    
    public static List<entityCTHD> searchHD(String keyword) throws SQLException, ClassNotFoundException {
    Connection con = ketnoi.Connect.getConnection();
    List<entityCTHD> hdList = new ArrayList<>();
    String sql = "SELECT * FROM KHO WHERE TenSP LIKE '%" + keyword + "%'";
    PreparedStatement pStmt = con.prepareStatement(sql);
    ResultSet rs = pStmt.executeQuery();

    while (rs.next()) {
        entityCTHD hd = new entityCTHD();
        hd.setIDHD(rs.getInt("IDHD"));
        hd.setTenSP(rs.getString("TenSP"));
        hd.setGia(rs.getFloat("Gia"));
        hd.setSL(rs.getInt("SL"));
        hd.setTenKH(rs.getString("TenKH"));
        hd.setSDT(rs.getInt("SDT"));
        hd.setIDSP(rs.getInt("IDSP"));
        hdList.add(hd);
    }
        ketnoi.Connect.closePreparedStatement(pStmt);
        ketnoi.Connect.closeConnection(con);

    return hdList;
}
}