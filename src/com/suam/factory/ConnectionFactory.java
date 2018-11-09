package com.suam.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	/* Constantes com os parâmetros da conexão */
	// MYSQL
	private static final String URL = "jdbc:mysql://localhost:3306/dbweb2?useTimezone=true&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String STRINGCONEXAO = URL + USERNAME + PASSWORD;

	public static java.sql.Connection getConnection() throws SQLException {

		Connection conexao = null;
		try {
			/* Obtém o driver de conexão com o banco de dados */
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			/* Tenta se conectar */
			System.out.println("String de conexão MYSQL: " + STRINGCONEXAO);
			conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			/* Configura commit como NÃO Automático */
			conexao.setAutoCommit(false);

			/* Caso a conexão ocorra com sucesso, a conexão é retornada */
			// conexao com HSQLDB
			// conexao = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/dbweb2",
			// "SA", "");
			// System.out.println("CONEXAO FACTORY STRING: "+conexao );

			// TENTANDO SE CONECTAR A HSQLDB
			// Class.forName("org.hsqldb.jdbcDriver");

			/* Caso a conexão ocorra com sucesso, a conexão é retornada */
			// conexao com HSQLDB
			// conexao = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/dbweb2",
			// "SA", "");
			// System.out.println("CONEXAO FACTORY STRING: "+conexao );
			return conexao;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel conectar ao banco de dados.");
			return null;
		}
	}
}