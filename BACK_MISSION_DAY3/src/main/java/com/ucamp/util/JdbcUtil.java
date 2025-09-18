package com.ucamp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcUtil {

    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        // JDBC Driver 로딩
        Class.forName("oracle.jdbc.OracleDriver");
        // Connection 획득
        final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
        Connection connection = DriverManager.getConnection(URL, "SCOTT", "TIGER");
        return connection;
    }

    public static void commit(Connection connection) throws SQLException {
        if (connection != null) {
            connection.commit();
            System.out.println("JdbcUtils.commit: Commit!");
        } else {
            System.out.println("JdbcUtils.commit: connection is null!");
        }
    }

    public static void rollback(Connection connection) throws SQLException {
        if (connection != null) {
            connection.rollback();
            System.out.println("JdbcUtils.rollback: Rollback!");
        } else {
            System.out.println("JdbcUtils.rollback: connection is null!");
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
