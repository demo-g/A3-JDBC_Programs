package com.cg.batchProcessing;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertText {

	public static void main(String[] args) throws FileNotFoundException {
		Connection myCon;
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","litindia");
			PreparedStatement mystmt = myCon.prepareStatement("INSERT INTO resume VALUES(?,?,?)");
			  mystmt.setInt(1, 10);
		      mystmt.setString(2, "my resume");
		      //Inserting Blob type
		      FileReader reader = new FileReader("C:\\Users\\Hacker\\Documents\\workspace-spring-tool-suite-4-4.6.0.RELEASE\\jdbc\\batch_processing\\resume.txt");
		      mystmt.setClob(3, reader);
		      //Executing the statement
		      mystmt.execute();
		      System.out.println("Record inserted......");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
