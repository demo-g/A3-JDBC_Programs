package com.cg.batchProcessing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

public class InsertImage {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","litindia");
			PreparedStatement mystmt = myCon.prepareStatement("INSERT INTO images VALUES(?,?,?)");
			  mystmt.setInt(1, 10);
		      mystmt.setString(2, "sample image");
		      //Inserting Blob type
		      InputStream in = new FileInputStream("C:\\Users\\Hacker\\Documents\\workspace-spring-tool-suite-4-4.6.0.RELEASE\\jdbc\\batch_processing\\images\\image.png");
		      mystmt.setBlob(3, in);
		      //Executing the statement
		      mystmt.execute();
		      System.out.println("Record inserted......");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
