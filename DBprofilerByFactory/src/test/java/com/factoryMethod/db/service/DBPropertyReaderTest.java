package com.factoryMethod.db.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.factorymethod.db.service.DBPropertyReader;

public class DBPropertyReaderTest {

	DBPropertyReader dbPropertyReader= new DBPropertyReader();
	
	@Test
	public void testGetPropertiesFilePath() {
		assertEquals("src/main/resources/DatabaseProvider.properties", dbPropertyReader.getPropertiesFilePath());
	}

	@Test
	public void testGetDBProvider() {
		assertEquals("mysql", dbPropertyReader.getDBProvider());
	}

	@Test
	public void testGetFileProperties() {
		assertNotEquals(null, dbPropertyReader.getFileProperties());
	}

}
