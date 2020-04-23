package com.cg.jdbcEmployee;

import java.sql.*;

public class JDBCExample {
	public static void main(String []args)
	{
		PreparedStatement myStmnt = null;
		ResultSet myRes = null;
		try {
			Connection myCon=  DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","litindia");
			System.out.println("got connection");
			//create statement
			Statement mystmt = myCon.createStatement();
			
			myStmnt = myCon.prepareStatement("select * from employees where salary >? or  department=?");

			 

			//Set the parameters 
			myStmnt.setDouble(1,75000);
			myStmnt.setString(2,"Legal");
			myRes = myStmnt.executeQuery();
			
			while(myRes.next())
			{
				String lastName = myRes.getString("last_name");
				String firstName = myRes.getString("first_name");
				double salary = myRes.getDouble("salary");
				String departments  = myRes.getString("department");
				System.out.printf("%s,%s,%.2f,%s\n",lastName,firstName,salary,departments);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
