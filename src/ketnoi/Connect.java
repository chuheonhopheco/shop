/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ketnoi;

/**
 *
 * @author HungNguyen
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ggwpm
 */
public class Connect {
            public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection oConn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");        
        oConn = DriverManager.getConnection(
                 "jdbc:sqlserver://localhost:1433;"
                        + "database=QLBH;"
                        + "user=sa;"
                        + "password=123;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;"
        );
        return oConn;
    }

    public static void closeConnection(Connection oConn) throws SQLException {
        if (oConn != null) {
            oConn.close();
        }
    }

 
    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void closeCallableStatement(CallableStatement callableStatement) throws SQLException {
        if (callableStatement != null) {
            callableStatement.close();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
