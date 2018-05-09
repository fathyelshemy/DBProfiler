package com.factorymethod.db.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class DBPropertyReader {
	
	Logger logger=Logger.getLogger(DBPropertyReader.class);
	
	public String getPropertiesFilePath() {
		return ("src/main/resources/DatabaseProvider.properties");
		 
	}
	
	public String getDBProvider() {
		Properties property= new Properties();
		File file=getFileProperties();
		String dbProviderType=null;
		try {
			FileInputStream propertiesFile= new FileInputStream(file);
			property.load(propertiesFile);
			dbProviderType=property.getProperty("DBprovider");
		} catch (IOException e) {
			logger.error(e);
		}
		return dbProviderType;
	}
	
	public File getFileProperties() {
		String filePath=getPropertiesFilePath();
		 File propertiesDB= new File(filePath);
		 if(propertiesDB.exists())
			 return propertiesDB;
		 
		 return null;
	}

}
