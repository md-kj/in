package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	private Connection con;

	public Connection getCsCon() throws ClassNotFoundException, SQLException {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.10.10.30:1521:orcl";
			// String url =
			// "jdbc:oracle:thin:@(description=(ADDRESS_LIST=(ADDRESS = (PROTOCOL = TCP)(HOST = 10.1.0.23)(PORT = 1521))(ADDRESS = (PROTOCOL = TCP)(HOST = 10.1.0.24)(PORT = 1521))(load_balance=yes)(failover=yes))(connect_data=(service_name= jldb)(instance_name=jldb1)(instance_name=jldb2)))";
			String userName = "jldbcs";
			String password = "jldbcs";

			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException ex) {
			throw ex;
		} catch (ClassNotFoundException ex) {
			throw ex;
		}
		return con;
	}

	public Connection getNcCon() throws SQLException, ClassNotFoundException {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.10.10.35:1521:orcl";
			// String url =
			// "jdbc:oracle:thin:@(description=(ADDRESS_LIST=(ADDRESS = (PROTOCOL = TCP)(HOST = 10.1.0.23)(PORT = 1521))(ADDRESS = (PROTOCOL = TCP)(HOST = 10.1.0.24)(PORT = 1521))(load_balance=yes)(failover=yes))(connect_data=(service_name= jldb)(instance_name=jldb1)(instance_name=jldb2)))";
			String userName = "jldbnj";
			String password = "jldbnj";
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException ex) {
			throw ex;
		} catch (ClassNotFoundException ex) {
			throw ex;
		}
		return con;
	}
	public Connection getYlCon() throws SQLException, ClassNotFoundException {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.10.10.2:1521:orcl";
			// String url =
			// "jdbc:oracle:thin:@(description=(ADDRESS_LIST=(ADDRESS = (PROTOCOL = TCP)(HOST = 10.1.0.23)(PORT = 1521))(ADDRESS = (PROTOCOL = TCP)(HOST = 10.1.0.24)(PORT = 1521))(load_balance=yes)(failover=yes))(connect_data=(service_name= jldb)(instance_name=jldb1)(instance_name=jldb2)))";
			String userName = "yljzn";
			String password = "yljzn";
			con = DriverManager.getConnection(url, userName, password);
		} catch (SQLException ex) {
			throw ex;
		} catch (ClassNotFoundException ex) {
			throw ex;
		}
		return con;
	}
	public Connection getCon() {

		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

}
