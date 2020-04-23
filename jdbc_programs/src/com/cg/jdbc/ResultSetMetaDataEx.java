package com.cg.jdbc;

import java.sql.*;


public class ResultSetMetaDataEx 
{
	    public static void main(String[] args) 
	    {
	        try {
	            Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","litindia");
	            System.out.println("Got ...connection..");
	            Statement stmt =mycon.createStatement();
	            System.out.println("Statement .created...");
	            ResultSet rs = stmt.executeQuery("select * from employees");
	            
	            ResultSetMetaData rsmd = rs.getMetaData();
	            
	            int n = rsmd.getColumnCount();
	            
	            System.out.println("No of columns : "+n);
	            
	            for(int i=1;i<=n;i++)
	            {
	                System.out.println("column number "+i);
	                System.out.println("column name "+rsmd.getColumnName(i));
	                System.out.println("Column Type "+rsmd.getColumnType(i));
	                System.out.println("Is AutoIncrement "+rsmd.isAutoIncrement(i));
	                System.out.println("Schema name"+rsmd.getSchemaName(i));
	                System.out.println("Is Nullable "+rsmd.isNullable(i));
	            }        
	        }
	        
	    catch (SQLException e) 
	        {
	            e.printStackTrace();
	        }
	    }

	 

	}


