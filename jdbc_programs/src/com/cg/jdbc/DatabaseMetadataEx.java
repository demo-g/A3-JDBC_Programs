package com.cg.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseMetadataEx {

	public static void main(String[] args) {
		
	
	try {
		Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","litindia");
		
		System.out.println("Got connection");
		Statement stmt=myCon.createStatement();
		System.out.println("Statement created");
		DatabaseMetaData db=myCon.getMetaData();
		
		System.out.println("DB name"+db.getDatabaseProductName());
		System.out.println("DB version"+db.getDatabaseProductVersion());
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}	
