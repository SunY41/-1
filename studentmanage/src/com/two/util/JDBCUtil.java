package com.two.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String uri = null;
    private static String username = null;
    private static String password = null;
    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties"));
            String driver = properties.getProperty("driver");
            uri = properties.getProperty("uri");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(uri, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(PreparedStatement ps, ResultSet rs){
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement ps){
        close(ps, null);
    }
}
