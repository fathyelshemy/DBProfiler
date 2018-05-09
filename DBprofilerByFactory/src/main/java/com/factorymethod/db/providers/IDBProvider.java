package com.factorymethod.db.providers;

import java.sql.Connection;
import java.sql.ResultSet;

public interface IDBProvider {
	
	public void excuteQuery(String query);
	
	public ResultSet retrieveResult(String query);
	
	public String setUserName();
	
	public String setPassword();
	
	public String setDBURL();
	
	public Connection getConn();

}
