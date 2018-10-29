package br.com.unisuam.TESTE;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unisuam.factory.ConnectionFactory;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate("delete from usuario where idusuario>5");
		int updateCount = statement.getUpdateCount();
		System.out.println(updateCount + " linhas atualizadas");
		
		statement.close();
		connection.close();
	}

}
