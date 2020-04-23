package com.cg.jdbcProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class CountForDept {
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
	
		myStmnt = myCon.prepareCall("{call get_count_for_department (?,?)}");
		myStmnt.setString(1, pdept);
		((CallableStatement) myStmnt).registerOutParameter(2,Types.INTEGER);
		myStmnt.execute();
		int count= ((CallableStatement) myStmnt).getInt(2);
		System.out.println("\n The count ="+count);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
