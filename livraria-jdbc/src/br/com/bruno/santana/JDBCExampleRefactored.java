package br.com.bruno.santana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExampleRefactored {

	//Dados do Banco
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/livraria";
	static final String USER = "root";
	static final String PASS = "123456";

	public static void main(String[] args) {
		executarQueries();
	}
	
	private static void executarQueries() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			select(stmt);
			
			insert(conn);
			select(stmt);
			
			update(stmt);
			select(stmt);
			
			delete(stmt);
			select(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException e) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fim!");
	}
	
	public static void insert(Connection conn) throws SQLException {
		System.out.println("insert...\n");
		String sql = "INSERT INTO livros(titulo, autor) VALUES (?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "Felicidade Verdadeira");
		ps.setString(2, "Heber Campos Jr.");
		ps.executeUpdate();
	}
	
	public static void update(Statement stmt) throws SQLException {
		System.out.println("update...\n");
		String sql = "UPDATE livros SET titulo ='Outro título' where titulo ='Felicidade Verdadeira'";
		stmt.executeUpdate(sql);
	}
	
	public static void delete(Statement stmt) throws SQLException {
		System.out.println("delete...\n");
		String sql = "DELETE from livros where titulo ='Outro título';";
		stmt.executeUpdate(sql);
	}
	
	public static void select(Statement stmt) throws SQLException {
		String sql = "SELECT * from livros;\n";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println("Título: "+rs.getString("titulo"));
			System.out.println("Autor: "+rs.getString("autor"));
			System.out.println();
		}
		System.out.println("#################################");
	}
	
}
