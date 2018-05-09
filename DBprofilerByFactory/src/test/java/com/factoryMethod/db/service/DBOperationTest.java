package com.factoryMethod.db.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.factorymethod.db.model.Employee;
import com.factorymethod.db.service.DBOperation;

public class DBOperationTest {

	Employee emp=null;
	DBOperation crud;
	Employee emp1=null;
	@Before
	public void setUp() throws Exception {
		emp=new Employee();
		emp.setId(10);
		emp.setTxtAddress("cairo");
		emp.setUserName("ahmed fathy");
		
		emp1= new Employee();
		emp1.setId(11);
		emp1.setTxtAddress("new Cairo");
		emp1.setUserName("ahmedFathy");
		crud= new DBOperation();
	}
	
	@Test
	public void testDbScaniro() {
		crud.insertEmployee(emp);
		crud.updateEmployee(emp1);
		crud.getEmployee(11);
		crud.delEmployee(11);
	}



}
