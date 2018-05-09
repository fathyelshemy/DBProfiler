package com.FactoryMethod.DB.Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.factorymethod.db.model.Employee;

public class EmployeeTest {
	
	Employee employee= new Employee();

	@Before
	public void setUp() throws Exception {
		employee.setUserName("fathy elshemy");
		employee.setTxtAddress("abozabaal");
		employee.setId(1);
	}

	@Test
	public void testGetUserName() {
		assertEquals("fathy elshemy", employee.getUserName());
	}

	@Test
	public void testGetTxtAddress() {
		assertEquals("abozabaal", employee.getTxtAddress());
	}
	
	@Test
	public void testGetId() {
		assertEquals(1, employee.getId());
	}

}
