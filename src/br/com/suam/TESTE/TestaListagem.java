package br.com.suam.TESTE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.suam.servlet.factory.ConnectionFactory;



public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from usuario");
		ResultSet resultSet = statement.getResultSet();
		
		while (resultSet.next()) {
			int id = resultSet.getInt("idusuario");
			String nome = resultSet.getString("nome");
			System.out.println("id=" + id + ", nome=" + nome);
		}
		
		resultSet.close();
		statement.close();
		connection.close();
	}


}
