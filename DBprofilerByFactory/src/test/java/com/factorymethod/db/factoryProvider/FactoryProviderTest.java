package com.factorymethod.db.factoryProvider;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.factorymethod.db.providers.DerbyProvider;
import com.factorymethod.db.providers.MySqlProvider;

public class FactoryProviderTest {
	FactoryProvider factoryProvider;
	@Before
	public void setUp() throws Exception {
		factoryProvider= new FactoryProvider();

	}

	@Test
	public void testChooceProvider() {

		assertNotEquals(new DerbyProvider(), new FactoryProvider().chooceProvider());
		
	}

}
