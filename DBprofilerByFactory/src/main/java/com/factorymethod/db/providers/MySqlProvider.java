package com.factorymethod.db.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class MySqlProvider implements IDBProvider {

	private Logger logger= Logger.getLogger(MySqlProvider.class);
	private String userName;
	private String password;
	private String dbURL;
	
	private Connection conn;
	private PreparedStatement prepareSat;
	
	public MySqlProvider() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			setDBURL();
			setUserName();
			setPassword();
			conn=DriverManager.getConnection(dbURL, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			logger.error(e);
		}

	}
	@Override
	public void excuteQuery(String query) {
		try {
			prepareSat=conn.prepareStatement(query);
			prepareSat.executeUpdate();
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	@Override
	public ResultSet retrieveResult(String query) {

		ResultSet rs=null;
		try {
			rs = prepareSat.executeQuery(query);
		} catch (SQLException e) {
		
			logger.error(e);
		}
		return rs;
	}

	@Override
	public String setUserName() {
		userName="root";
		logger.info("userName:"+userName);
		return userName;
	}

	@Override
	public String setPassword() {
		password="root";
		logger.info("password"+password);
		return password;
	}

	@Override
	public String setDBURL() {
		dbURL="jdbc:mysql://localhost:3306/factoryMethodex?useSSL=false";
		logger.info("dbURL"+dbURL);
		return dbURL;
	}
	@Override
	public Connection getConn() {
		
		return conn;
	}

}
