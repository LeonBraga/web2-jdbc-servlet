package br.com.suam.TESTE;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.suam.factory.ConnectionFactory;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionFactory.getConnection();
		Statement statement = connection.createStatement();

		// int resultado = statement.executeUpdate(
		boolean resultado = statement.execute(
				"INSERT INTO cartaodecredito (numeroCartao, dataVencimento, usuario_idusuario) VALUES ('2222222','15/01/2001','4')",
				Statement.RETURN_GENERATED_KEYS);
		System.out.println("RESULTADO: " + resultado);

		/*
		 * ResultSet generatedKeys = statement.getGeneratedKeys(); while
		 * (generatedKeys.next()) { long id = generatedKeys.getInt("idusuario");
		 * System.out.println("id gerado: " + id); } generatedKeys.close();
		 */
		statement.close();
		connection.close();
	}
}
