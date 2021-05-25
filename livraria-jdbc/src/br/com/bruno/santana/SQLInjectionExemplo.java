package br.com.bruno.santana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Mais exemplos em: https://riptutorial.com/jdbc/example/28671/statement---sql-injection-evil
public class SQLInjectionExemplo {

	//Dados do Banco
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/livraria?allowMultiQueries=true";
	static final String USER = "root";
	static final String PASS = "root1234";

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

			insert(stmt, "Finalmente Vivos", "John Piper");
			insert(stmt, "Coronavírus e Cristo", "John Piper");
			insert(stmt, "Java 9", "Rodrigo Turini");
			select(stmt);
			
			selectComSqlInjection(stmt, "Rodrigo Turini");
			select(stmt);
			
			selectComSqlInjection(stmt, "Rodrigo Turini';delete from livros; #");
			select(stmt);
			
			insert(stmt, "Finalmente Vivos", "John Piper");
			
			selectComPreparedStatement(conn, "John Piper");
			select(stmt);
			
			selectComPreparedStatement(conn, "John Piper';delete from livros; #");
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
	
	public static void insert(Statement stmt, String titulo, String autor) throws SQLException {
		System.out.println("insert...\n");
		String sql = "INSERT INTO livros(titulo, autor) VALUES ('" + titulo + "', '" + autor + "')";
		stmt.executeUpdate(sql);
	}
	
	public static void select(Statement stmt) throws SQLException {
		String sql = "SELECT * from livros;\n";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println("Titulo: "+rs.getString("titulo"));
			System.out.println("Autor: "+rs.getString("autor"));
			System.out.println();
		}
		System.out.println("#################################");
	}
	
	public static void selectComSqlInjection(Statement stmt, String autor) throws SQLException {
		System.out.println("select com vulnerabilidade...\n");
		String sql = "SELECT * from livros where autor = '" + autor + "'";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next())
			System.out.println("Primeiro registro: " + rs.getString("titulo") + "\n");
	}
	
	public static void selectComPreparedStatement(Connection conn, String autor) throws SQLException {
		System.out.println("select sem vulnerabilidade...\n");
		String sql = "SELECT * from livros where autor = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, autor);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			System.out.println("Primeiro registro: " + rs.getString("titulo") + "\n");
	}
	
}