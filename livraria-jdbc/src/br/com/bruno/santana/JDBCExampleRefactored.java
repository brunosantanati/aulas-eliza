package br.com.bruno.santana;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExampleRefactored {

	//Dados do Banco
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/livraria";
	static final String USER = "root";
	static final String PASS = "01061966";

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

		//	select(stmt);
			
		//	insert(conn);
		//	select(stmt);
			
		//	update(stmt);
		//	select(stmt);
			
		//	delete(stmt);
		//	select(stmt);
			int opcao = 0;
			while (opcao !=5) {
			 Scanner scanner = new Scanner(System.in);
			 System.out.println("Selecione uma opção");
			 System.out.println("1-Inclusão");
			 System.out.println("2-Alterção");
			 System.out.println("3-Exclusão");
			 System.out.println("4-Consulta");
			 System.out.println("5-Exit");
			 opcao = scanner.nextInt();
			 switch (opcao) {
			 case 1:
				insert(conn);
				break;
			 case 2:
				 update(conn);
				 break;
			 case 3:
				 delete(conn);
				 break;
			 case 4:
				 select(stmt);
				 break;	 
			 case 5:
			 	 break;
			 }
			 scanner.close();
			}
			

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
//		ps.setString(1, "Felicidade Verdadeira");
//		ps.setString(2, "Heber Campos Jr.");
		Scanner scanner = new Scanner(System.in);
		String newTitulo = "";
		String newAutor = "";
		System.out.println("Digite Titulo:");
		newTitulo = scanner.nextLine();
		System.out.println("Digite Autor.:");
		newAutor = scanner.nextLine();
		scanner.close();
		ps.setString(1, newTitulo);
		ps.setString(2, newAutor);
		ps.executeUpdate();
	}
	
	public static void update(Connection conn) throws SQLException {
		System.out.println("update...\n");
		Scanner scanner = new Scanner(System.in);
		String oldTitulo = "";
		String newAutor = "";
		System.out.println("Digite Titulo a alterar:");
		oldTitulo = scanner.nextLine();
		System.out.println("Digite novo autor......:");
		newAutor = scanner.nextLine();
		String sql = "UPDATE livros SET autor = ? where titulo = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, newAutor);
		ps.setString(2, oldTitulo);
		ps.executeUpdate();
		scanner.close();
	}
	
	public static void delete(Connection conn) throws SQLException {
		System.out.println("delete...\n");
		Scanner scanner = new Scanner(System.in);
		String delTitulo = "";
		System.out.println("Digite Titulo a excluir:");
		delTitulo = scanner.nextLine();
		String sql = "DELETE from livros where titulo = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, delTitulo);
		ps.executeUpdate();
		scanner.close();
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
