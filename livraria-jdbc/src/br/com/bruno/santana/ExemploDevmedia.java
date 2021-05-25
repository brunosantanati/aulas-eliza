package br.com.bruno.santana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Exemplo baseado em https://www.devmedia.com.br/manipulando-dados-com-jdbc-em-java/27287
public class ExemploDevmedia {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// conectarEmBaseOracle();
		conectarEmBaseMySQL();
		
		mostrarRegistros();
		
		inserirUmRegistro("John Piper", "Finalmente Vivos");
		inserirUmRegistro("Flávio Lisboa", "Do PHP ao Laminas");
		inserirUmRegistro("Eduardo Felipe Zambom Santana", "Back-end Java Microsserviços, Spring Boot e Kubernetes");
		mostrarRegistros();
		
		excluirUmRegistro();
		mostrarRegistros();
		
		excluirTodosRegistros();
		mostrarRegistros();
		
		inserirUmRegistro("Rodrigo Turini", "Java 9");
		mostrarRegistros();
		
		alterarUmRegistro();
		mostrarRegistros();
	}

	public static void conectarEmBaseOracle() {
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
			System.out.println("Conectado: " + connection);
		} catch (ClassNotFoundException e) {
			// Could not find the database driver
		} catch (SQLException e) {
			// Could not connect to the database
		}
	}

	public static void conectarEmBaseMySQL() {
		// Conectando em uma base mysql:
		Connection connection = null;
		try {
			// Load the JDBC driver
			String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
			Class.forName(driverName);

			// Create a connection to the database
			String serverName = "localhost";
			String mydatabase = "livraria";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC url
			String username = "root";
			String password = "root1234";
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Conectado: " + connection);
		} catch (ClassNotFoundException e) {
			// Could not find the database driver
		} catch (SQLException e) {
			// Could not connect to the database
		}
	}

	// Carregando o Driver JDBC:
	/*
	 * try { // Load the JDBC driver String driverName = "org.gjt.mm.mysql.Driver";
	 * Class.forName(driverName); } catch (ClassNotFoundException e) { // Could not
	 * find the driver }
	 */

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		try {
			// Load the JDBC driver
			String driverName = "com.mysql.jdbc.Driver"; // MySQL MM JDBC driver
			Class.forName(driverName);

			// Create a connection to the database
			String serverName = "localhost";
			String mydatabase = "livraria";
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // a JDBC url
			String username = "root";
			String password = "root1234";
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void excluirTodosRegistros() throws ClassNotFoundException {
		// Excluindo todos registros de uma tabela:
		try {
			Connection connection = getConnection();

			Statement stmt = connection.createStatement();

			// Use TRUNCATE
			String sql = "TRUNCATE livros";

			// Use DELETE
			sql = "DELETE FROM livros";

			// Execute deletion
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
		}
	}

	public static void excluirUmRegistro() throws ClassNotFoundException {
		// Excluindo apenas um registro:
		try {
			Connection connection = getConnection();

			// Create a statement
			Statement stmt = connection.createStatement();

			// Prepare a statement to insert a record
			String sql = "DELETE FROM livros WHERE titulo='Do PHP ao Laminas'";

			// Execute the delete statement
			int deleteCount = stmt.executeUpdate(sql);
			// deleteCount contains the number of deleted rows
			System.out.println("Registros deletados: " + deleteCount);
			
			// Use a prepared statement to delete

			// Prepare a statement to delete a record
			sql = "DELETE FROM livros WHERE titulo=?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			// Set the value
			pstmt.setString(1, "Do PHP ao Laminas");
			deleteCount = pstmt.executeUpdate();
			System.out.println("Registros deletados: " + deleteCount);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public static void alterarUmRegistro() throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();

		// Alterando um registro:
		try {
			Statement stmt = connection.createStatement();

			// Prepare a statement to update a record
			String sql = "UPDATE livros SET titulo='Java 9 Interativo, reativo e modularizado' WHERE titulo = 'Java 9'";

			// Execute the insert statement
			int updateCount = stmt.executeUpdate(sql);
			// updateCount contains the number of updated rows
			System.out.println("Registros atualizados: " + updateCount);
		} catch (SQLException e) {
		}
	}

	public static void inserirUmRegistro(String autor, String titulo) throws ClassNotFoundException, SQLException {

		Connection connection = getConnection();

		// Inserindo um registro:
		try {
			Statement stmt = connection.createStatement();

			// Prepare a statement to insert a record
			String sql = "INSERT INTO livros (autor, titulo) VALUES('" + autor + "', '" + titulo + "')";

			// Execute the insert statement
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
		}
	}
	
	public static void mostrarRegistros() throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		Statement stmt = connection.createStatement();
		
		String sql = "SELECT * from livros;\n";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println("Título: " + rs.getString("titulo"));
			System.out.println("Autor: " + rs.getString("autor"));
			System.out.println();
		}
		System.out.println("#################################");
	}

}
