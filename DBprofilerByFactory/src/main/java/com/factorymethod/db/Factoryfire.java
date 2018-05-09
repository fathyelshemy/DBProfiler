package com.factorymethod.db;

import com.factorymethod.db.model.Employee;
import com.factorymethod.db.service.DBOperation;

public class Factoryfire {

	public static void main(String[] args) {
		DBOperation operation=new DBOperation();
		Employee emp= new Employee();
		emp.setId(3);
		emp.setUserName("fathy ahmed");
		emp.setTxtAddress("Khanka");
		
//		operation.insertEmployee(emp);
		operation.getEmployee(3);
		System.out.println("done");
	}
}
