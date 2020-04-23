package com.cg.batchProcessing;

import java.sql.*;

public class BatchProcessingUsingPreparedStatement {

	public static void main(String[] args) {
		Connection myCon;
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","litindia");
			System.out.println("got connection");
			//create statement
			myCon.setAutoCommit(false);
			String sql = "insert into books values (?,?,?)";
			PreparedStatement mystmt = myCon.prepareStatement(sql);
			
			mystmt.setInt(1, 19);
			mystmt.setString(2, "Subway Surfer");
			mystmt.setString(3, "Richard Davidson");
			mystmt.addBatch();
			
			mystmt.setInt(1, 20);
			mystmt.setString(2, "Boss");
			mystmt.setString(3, "Harley Davidson");
			mystmt.addBatch();

			mystmt.setInt(1, 21);
			mystmt.setString(2, "Spyder");
			mystmt.setString(3, "Mahesh Babu");
			mystmt.addBatch();

			mystmt.setInt(1, 22);
			mystmt.setString(2, "Home Coming");
			mystmt.setString(3, "Steve Smith");
			mystmt.addBatch();

			mystmt.setInt(1, 23);
			mystmt.setString(2, "Corona");
			mystmt.setString(3, "Kim Jung");
			mystmt.addBatch();

			
			int[] result = mystmt.executeBatch();
		     System.out.println("The number of rows inserted: "+ result.length);
		     myCon.commit();
		} catch (SQLException e) {
		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
