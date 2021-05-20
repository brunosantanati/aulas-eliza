package br.com.bruno.santana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class update_delet_devmedia {
// base oracle
	Connection connection = null;
	try {
	    // Load the JDBC driver
	    String driverName = "oracle.jdbc.driver.OracleDriver";
	    Class.forName(driverName);
	 
	    // Create a connection to the database
	    String serverName = "127.0.0.1";
	    String portNumber = "1521";
	    String sid = "mydatabase";
	    String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
	    String username = "username";
	    String password = "password";
	    connection = DriverManager.getConnection(url, username, password);
	} catch (ClassNotFoundException e) {
	    // Could not find the database driver
	} catch (SQLException e) {
	    // Could not connect to the database
	}
	
	//Conectando em uma base mysql:
	Connection connection = null;
	try {
	    // Load the JDBC driver
	    String driverName = "org.gjt.mm.mysql.Driver"; // MySQL MM JDBC driver
	    Class.forName(driverName);
	 
	    // Create a connection to the database
	    String serverName = "localhost";
	    String mydatabase = "mydatabase";
	    String url = "jdbc:mysql://" + serverName +  "/" + mydatabase; // a JDBC url
	    String username = "username";
	    String password = "password";
	    connection = DriverManager.getConnection(url, username, password);
	} catch (ClassNotFoundException e) {
	    // Could not find the database driver
	} catch (SQLException e) {
	    // Could not connect to the database
	}
	//Carregando o Driver JDBC:
	try {
	    // Load the JDBC driver
	    String driverName = "org.gjt.mm.mysql.Driver";
	    Class.forName(driverName);
	} catch (ClassNotFoundException e) {
	    // Could not find the driver
	}
	//Excluindo todos registros de uma tabela:
	try {
	    Statement stmt = connection.createStatement();
	 
	    // Use TRUNCATE
	    String sql = "TRUNCATE my_table";
	 
	    // Use DELETE
	    sql = "DELETE FROM my_table";
	 
	    // Execute deletion
	    stmt.executeUpdate(sql);
	} catch (SQLException e) {
	}
	
	//Excluindo apenas um registro:
	try {
	     // Create a statement
	     Statement stmt = connection.createStatement();
	  
	     // Prepare a statement to insert a record
	     String sql = "DELETE FROM my_table WHERE col_string='a string'";
	  
	     // Execute the delete statement
	     int deleteCount = stmt.executeUpdate(sql);
	     // deleteCount contains the number of deleted rows
	  
	     // Use a prepared statement to delete
	  
	     // Prepare a statement to delete a record
	     sql = "DELETE FROM my_table WHERE col_string=?";
	     PreparedStatement pstmt = connection.prepareStatement(sql);
	     // Set the value
	     pstmt.setString(1, "a string");
	     deleteCount = pstmt.executeUpdate();
	     System.err.println(e.getMessage());
	//Alterando um registro:
	     try {
	    	    Statement stmt = connection.createStatement();
	    	 
	    	    // Prepare a statement to update a record
	    	    String sql = "UPDATE my_table SET col_string='a new string' WHERE col_string = 'a string'";
	    	 
	    	    // Execute the insert statement
	    	    int updateCount = stmt.executeUpdate(sql);
	    	    // updateCount contains the number of updated rows
	    	} catch (SQLException e) {
	    	}
	     //Inserindo um registro:
	     try {
	         Statement stmt = connection.createStatement();
	      
	         // Prepare a statement to insert a record
	         String sql = "INSERT INTO my_table (col_string) VALUES('a string')";
	      
	         // Execute the insert statement
	         stmt.executeUpdate(sql);
	     } catch (SQLException e) {
	     }
}
