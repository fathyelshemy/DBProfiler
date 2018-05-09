package com.factorymethod.db.factoryProvider;

import com.factorymethod.db.providers.DerbyProvider;
import com.factorymethod.db.providers.IDBProvider;
import com.factorymethod.db.providers.MySqlProvider;
import com.factorymethod.db.service.DBPropertyReader;

public class FactoryProvider {

	public IDBProvider chooceProvider() {
		DBPropertyReader dbtypr=new DBPropertyReader();
		String dbType=dbtypr.getDBProvider();
		IDBProvider dbProvider=null;
		if(dbType.equals("mysql")) {
			dbProvider=new MySqlProvider();
		}else if(dbType.equals("derby")) {
			dbProvider=new DerbyProvider();
		}
		
		return dbProvider;
	}
}
