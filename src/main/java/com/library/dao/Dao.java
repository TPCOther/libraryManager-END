package com.library.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dao {
    protected static String dbClassName = "com.mysql.jdbc.Driver";
    protected static String dbUrl = "jdbc:mysql://localhost:3306/library";
    protected static String dbUser = "root";
    protected static String dbPwd = "123456";
    private static Connection conn = null;

    protected Dao() {
        try {
            if(conn == null) {
                Class.forName(dbClassName).getDeclaredConstructor().newInstance();
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            }
            else {return;}
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected ArrayList<Object> executeQuery(String sql, Object...args) {
        ArrayList<Object> result = new ArrayList<Object>();
        int colCount = 0;
        ResultSet rs = null;
        PreparedStatement pstmt;
        ResultSetMetaData rsmd;
        try {
            if(conn == null) { new Dao(); }
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++) {
                pstmt.setObject(i+1, args[i]);
            }
            rs = pstmt.executeQuery();
            rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();
            while(rs.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for(int i = 1; i <= colCount; i++) {
                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));
                }
                result.add(map);
            }
            return result;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
        finally {}
    }

    protected int executeUpdate(String sql, Object...args) {
        int status = -1;
        PreparedStatement pstmt;
        try {
            if(conn == null) { new Dao(); }
            pstmt = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++) {
                pstmt.setObject(i+1, args[i]);
            }
            status = pstmt.executeUpdate();
            return status;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return status;
        }
        finally{}
    }


    
}
