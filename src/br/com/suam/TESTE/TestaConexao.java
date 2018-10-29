package br.com.suam.TESTE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		final String HOST = "jdbc:mysql://localhost:3306/";
		final String DB = "dbWeb2?useTimezone=true&serverTimezone=UTC";
		final String URL = HOST+DB;
		final String USERNAME = "root";
		final String PASSWORD = "root";
		
		Connection connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
		System.out.println("CONEXAO: ");
		System.out.println(connection);
		
		System.out.println("String de conexao: "+URL+USERNAME+PASSWORD);
		System.out.println("Abrindo uma conxeção");
		connection.close();
		System.out.println("Fechando uma conxeção");
	}

}
