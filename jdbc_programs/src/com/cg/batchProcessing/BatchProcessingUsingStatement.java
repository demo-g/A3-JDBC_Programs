package com.cg.batchProcessing;
import java.sql.*;
public class BatchProcessingUsingStatement {
	public static void main(String []args)
	{
		Connection myCon;
		try {
			myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","litindia");
			System.out.println("got connection");
			myCon.setAutoCommit(false);
			//create statement
			Statement mystmt = myCon.createStatement();
			 mystmt.addBatch( "insert into books(tno,name,author) values(12,'C','Gautam')");
			 mystmt.addBatch("insert into books(tno,name,author) values(13,'Ramayan','Ramanand')");
			 mystmt.addBatch( "insert into books(tno,name,author) values(14,'Mahabharat','Bharat')");
			 mystmt.addBatch( "insert into books(tno,name,author) values(15,'Pk','RajKumar')");
			 mystmt.addBatch( "insert into books(tno,name,author) values(16,'Saria','FakirMohan')");
			 mystmt.addBatch( "insert into books(tno,name,author) values(17,'Sweet Selfie','Sili')");
			 mystmt.addBatch( "insert into books(tno,name,author) values(18,'Temple Run','Netwave')");
			 int[] result = mystmt.executeBatch();
		      System.out.println("The number of rows inserted: "+ result.length);
		      
			   myCon.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
