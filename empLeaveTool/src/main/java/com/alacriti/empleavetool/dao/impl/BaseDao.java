package com.alacriti.empleavetool.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BaseDao {

	public static Connection getConnection() throws SQLException {
		Connection conn = null;
		DataSource ds = null;
		try {
			ds = (DataSource) new InitialContext()
					.lookup("java:jboss/datasources/TRAINEEE");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Exception in getConnection() " + e);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Exception in closeConnection() " + e);
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void commitConnection(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			System.out.println("Exception in commitConnection() " + e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception in commitConnection() " + e);
			e.printStackTrace();
		}
	}

	public static void rollBackTransaction(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			System.out.println("Exception in Rollback() " + e);
			e.printStackTrace();
		}
	}

}
