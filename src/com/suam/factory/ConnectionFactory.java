package com.suam.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/* Constantes com os parâmetros da conexão */
	//MYSQL
	private static final String URL = "jdbc:mysql://localhost:3306/dbweb2?useTimezone=true&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static java.sql.Connection getConnection() {

		Connection conexao = null;
		try {
			/* Obtém o driver de conexão com o banco de dados */
			//Class.forName("com.mysql.cj.jdbc.Driver");

			/* Tenta se conectar */
			//conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//System.out.println("String de conexão: "+URL+USERNAME+PASSWORD);
			
			/* Configura commit como NÃO Automático */
			//conexao.setAutoCommit(false);

			/* Caso a conexão ocorra com sucesso, a conexão é retornada */
			//conxao com HSQLDB
			conexao = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/dbweb2", "SA", "");
			return conexao;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel conectar ao banco de dados.");
			return null;
		}
	}
}