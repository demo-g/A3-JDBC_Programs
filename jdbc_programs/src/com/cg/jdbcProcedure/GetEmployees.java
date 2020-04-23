package com.cg.jdbcProcedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEmployees {
	public static void main(String[] args) {
		PreparedStatement myStmnt = null;
		ResultSet myRes = null;
		Connection myCon;
			try {
				myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","litindia");
			
		
		System.out.println("got connection");
		//create statement
	
		String pdept = "HR";
	
		myStmnt = myCon.prepareCall("{call get_employees_for_department (?)}");
		myStmnt.setString(1, pdept);
		myRes= myStmnt.executeQuery();
		while(myRes.next())
		{
			String lastName = myRes.getString("last_name");
			String firstName = myRes.getString("first_name");
			double salary = myRes.getDouble("salary");
			String departments  = myRes.getString("department");
			System.out.printf("%s,%s,%.2f,%s\n",lastName,firstName,salary,departments);
		}
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}