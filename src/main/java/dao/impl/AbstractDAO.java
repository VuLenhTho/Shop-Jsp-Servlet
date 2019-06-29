package dao.impl;

import constant.Constant;
import dao.IGenericDAO;
import mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements IGenericDAO<T> {

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/storemvc";
        String user = "root";
        String password = "1234";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            return null;
        } catch (SQLException e) {
            return null;
        }
    }


    public void insertUpdateDelete(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            setParameters(ps, parameters);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<T> findByProperties(String sql, RowMapper<T> mapper, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> results = new ArrayList<T>();
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            setParameters(ps, parameters);
            rs = ps.executeQuery();
            while (rs.next()){
                T object = mapper.map(rs);
                results.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return results;
    }

    @Override
    public long countAll(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            int count = 0;
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            setParameters(ps,parameters);
            rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException e) {
            return 0;
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                return 0;
            }
        }
    }

    private void setParameters(PreparedStatement ps, Object... parameters) throws SQLException {
        for (int i = 0; i < parameters.length; i++) {
            int index = i + 1;
            if (parameters[i] instanceof String) {
                ps.setString(index, (String) parameters[i]);
            } else if (parameters[i] instanceof Long) {
                ps.setLong(index, (Long) parameters[i]);
            } else if (parameters[i] instanceof Integer) {
                ps.setInt(index, (Integer) parameters[i]);
            } else if (parameters[i] instanceof Timestamp) {
                ps.setTimestamp(index, (Timestamp) parameters[i]);
            } else if (parameters[i] instanceof Boolean) {
                ps.setBoolean(index, (Boolean) parameters[i]);
            }
        }
    }
}
