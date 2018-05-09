package com.factorymethod.db.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.factorymethod.db.factoryProvider.FactoryProvider;
import com.factorymethod.db.model.Employee;
import com.factorymethod.db.providers.IDBProvider;

public class DBOperation {
	private Logger logger=Logger.getLogger(DBOperation.class);
	FactoryProvider factory= new FactoryProvider();
	IDBProvider DBProfider=factory.chooceProvider();
	
	
	public void createTable() {
		String createTableQuery="create table employee (id int not null ,username varchar(20) not null,txtaddress varchar(20),primary key(id))";
		try {
			ResultSet rs=DBProfider.getConn().getMetaData().getTables(null, "APP", "employee", null);
			if (rs.next()) {
				logger.info("table is existed");
			}else {
				DBProfider.excuteQuery(createTableQuery);
				logger.info("table created");
			}
		} catch (SQLException e) {
			logger.error(e);
		}
	}
	
	public Employee insertEmployee(Employee emp) {
		String insertQuery="insert into employee(id,username,txtaddress)"
				+ "values("+emp.getId()+",'"+emp.getUserName()+"','"+emp.getTxtAddress()+"')";
		
		DBProfider.excuteQuery(insertQuery);
		logger.info("insert employee \t"+emp.toString());
		return emp;
		
	}
	
	public Employee updateEmployee(Employee emp) {
			String updateQuery="update employee set id="+emp.getId()+","
					+ " username='"+emp.getUserName()+"', txtaddress='"+emp.getTxtAddress()+"' "
							+ "where id="+emp.getId()+" ";
			DBProfider.excuteQuery(updateQuery);
		logger.info("update employee \t"+emp.toString());
		return emp;
	}
	
	public int delEmployee(int id) {
		String delQuery="delete  from employee where id="+id+"";
		DBProfider.excuteQuery(delQuery);
		logger.info("delete employee with id=\t"+id);
		return id;
	}
	
	public Employee getEmployee(int id) {
		String selectedQuery="select id,username,txtaddress from employee where id="+id+"";
		ResultSet rs=DBProfider.retrieveResult(selectedQuery);
		Employee emp= new Employee();
		try {
			while(rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setUserName(rs.getString("username"));
				emp.setTxtAddress("txtaddress");
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		logger.info("find your employee is\t"+emp.toString());
		return emp;
		
	}

}
