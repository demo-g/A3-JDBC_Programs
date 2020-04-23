package com.cg.jdbcProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Types;

public class GreetDepartment {
	public static void main(String[] args) {
		CallableStatement myStmnt = null;
		Connection myCon;
		
				try {
					myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","litindia");
					System.out.println("got connection");
					String pdept = "HR";
					
					myStmnt = myCon.prepareCall("{call greet_the_department (?)}");
					myStmnt.setString(1, pdept);
					myStmnt.registerOutParameter(1, Types.VARCHAR);
					myStmnt.execute();
					
					String theResult= myStmnt.getString(1);
					System.out.println("Result is:"+theResult);
					
					/*ResultSet myRes= myStmnt.executeQuery("select * from employees"); 
					while(myRes.next())
					{
						String lastName = myRes.getString("last_name");
						String firstName = myRes.getString("first_name");
						double salary = myRes.getDouble("salary");
						String departments  = myRes.getString("department");
						System.out.printf("%s,%s,%.2f,%s\n",lastName,firstName,salary,departments);
					}*/
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
}
}
