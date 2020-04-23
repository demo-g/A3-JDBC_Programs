package com.cg.jdbcdriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	public static void main(String[] args) {
		
		
		try {
			Connection myCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","litindia");
			
			Statement stmt=myCon.createStatement();
			String sql="insert into books(tno,name,author) values (30,'java','Jerry')";
			stmt.executeUpdate(sql);
			
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next())
			{
				System.out.println(rs.getString("name")+" "+rs.getString("author")+" "+rs.getString("tno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
