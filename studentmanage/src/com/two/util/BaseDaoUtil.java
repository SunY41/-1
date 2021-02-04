package com.two.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoUtil {
    private Connection con = JDBCUtil.getConnection();
    private PreparedStatement selectUse(String sql, Object[] obj) throws SQLException {
        PreparedStatement ps = null;
        ps = con.prepareStatement(sql);
        int pc = ps.getParameterMetaData().getParameterCount();
        for (int i = 1; i <= pc; i++) {
            ps.setObject(i, obj[i - 1]);
        }
        return ps;
    }

    public int updateData(String sql, Object[] obj) throws SQLException {
        PreparedStatement ps = selectUse(sql, obj);
        int update = ps.executeUpdate();
        JDBCUtil.close(ps);
        return update;
    }
    public <T> List<T> selectData(String sql, Object[] obj, Class<T> clas) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        PreparedStatement ps = selectUse(sql, obj);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int count = metaData.getColumnCount();
        List<T> list = new ArrayList<>();
        while (rs.next()){
            T t = clas.getConstructor().newInstance();
            for (int j = 1; j <= count; j++){
                String name = metaData.getColumnName(j);
                Object object = rs.getObject(name);
                BeanUtils.setProperty(t, name, object);
            }
            list.add(t);
        }
        JDBCUtil.close(ps,rs);
        return list==null?null:list;
    }
}
