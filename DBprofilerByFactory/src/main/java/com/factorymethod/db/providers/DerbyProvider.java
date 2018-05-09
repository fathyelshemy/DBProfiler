package com.factorymethod.db.providers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DerbyProvider implements IDBProvider {
	
	private Logger logger=Logger.getLogger(DerbyProvider.class);
	
	private String dbUrl;
	
	private Connection conn;
	private PreparedStatement prepareSat;
	
	public DerbyProvider() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			setDBURL();
			conn=DriverManager.getConnection(dbUrl);
		} catch (ClassNotFoundException |SQLException e) {
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
			prepareSat=conn.prepareStatement(query);
			rs = prepareSat.executeQuery(query);
		} catch (SQLException e) {
		
			logger.error(e);
		}
		return rs;
	}

	@Override
	public String setUserName() {
		logger.info("userName"+null);
		return null;
	}

	@Override
	public String setPassword() {
		logger.info("password"+null);
		return null;
	}

	@Override
	public String setDBURL() {
		dbUrl="jdbc:derby:/home/"+System.getProperty("user.name")+"/TrailDB;create=true;";
		logger.info("dbURL"+dbUrl);
		return dbUrl;
	}

	@Override
	public Connection getConn() {
		return conn;
	}

}
