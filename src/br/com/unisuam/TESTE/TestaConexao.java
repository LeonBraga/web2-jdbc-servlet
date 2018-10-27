package br.com.unisuam.TESTE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		final String HOST = "jdbc:mysql://localhost:3306/";
		final String DB = "dbWeb2?useTimezone=true&serverTimezone=UTC";
		final String URL = HOST+DB;
		final String username = "root";
		final String password = "root";
		
		Connection connection = DriverManager.getConnection(URL,username, password);
		System.out.println("Abrindo uma conxeção");
		connection.close();
	}

}
