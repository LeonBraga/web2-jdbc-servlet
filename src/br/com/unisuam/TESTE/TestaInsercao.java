package br.com.unisuam.TESTE;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unisuam.factory.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute(
				"insert into usuario(nome, sobrenome, endereco, senha, login, dataNascimento, isAdm ) "
				+ "values('And', 'F','Rua teste2', '123', 'afc', '15/05/2040', false)",	Statement.RETURN_GENERATED_KEYS);
		System.out.println("RESULTADO: "+resultado);
		//ResultSet generatedKeys = statement.getGeneratedKeys();
		/*while (generatedKeys.next()) {
			long id = generatedKeys.getLong("id");
			System.out.println("id gerado: " + id);
		}*/
		//generatedKeys.close();
		statement.close();
		connection.close();
	}
}
