package com.cg.jdbcProcedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcProcedure {

	public static void main(String[] args) {
		PreparedStatement myStmnt = null;
		ResultSet myRes = null;
		Connection myCon;
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","litindia");
		
		System.out.println("got connection");
		//create statement
		Statement mystmt = myCon.createStatement();
		String pdept = "Engineering";
		int incrAmount= 10000;
		myStmnt = myCon.prepareCall("{call increase_salaries_for_department(?,?)}");
		myStmnt.setString(1, pdept);
		myStmnt.setDouble(2, incrAmount);
		
		//Show salary before increment
		System.out.println("Salary before increment:\n");
		showSalaries(myCon,pdept);
		myStmnt.execute();
		//Show salary after increment
		System.out.println("Salary after increment:\n");
		showSalaries(myCon,pdept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void showSalaries(Connection mycon, String department) throws SQLException
	{
		PreparedStatement myStmt= null;
		ResultSet myRs= null;
		myStmt = mycon.prepareStatement("select * from employees where department=? ");
		myStmt.setString(1, department);
		myRs = myStmt.executeQuery();
		while(myRs.next())
		{
			String lastName= myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String departments  = myRs.getString("department");
			System.out.printf("%s,%s,%.2f,%s\n",lastName,firstName,salary,departments);
		}
	}

}
