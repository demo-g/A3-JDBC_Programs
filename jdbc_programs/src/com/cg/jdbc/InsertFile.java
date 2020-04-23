package com.cg.jdbc;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 

public class InsertFile {
	
	

	
	  public static void main(String[] args) throws SQLException, FileNotFoundException 
	    {
	      Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","litindia");    
	      
	      
	      String query = "INSERT INTO Articles(Name, Article) VALUES (?, ?)";
	      
	      PreparedStatement pstmt = con.prepareStatement(query);
	      
	      pstmt.setString(1, "AboutYou");
	      
	      FileReader reader = new FileReader("E:\\notepad.txt");
	      
	      pstmt.setCharacterStream(2, reader);
	      pstmt.execute();
	      pstmt.setString(1, "article2");
	     
	      System.out.println("Data inserted......");
	 
	      
	    }

	 

	

}
