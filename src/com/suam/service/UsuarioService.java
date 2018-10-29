package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.suam.bean.Usuario;
import com.suam.factory.ConnectionFactory;

public class UsuarioService {

	public static void inserir(Usuario usuario) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "INSERT INTO usuario (login,senha) VALUES (?,?)";

		try {

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());

			ps.execute();
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			System.out.println("ERRO" + e);
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// fechar a conexão
			System.out.println("FECHANDO CONEXAO: ");
			conexao.close();
		}
	}

	public static List<Usuario> consultar(String login, String senha) throws SQLException {
		System.out.println("CONSULTAR ==> LOGIN: " + login + " SENHA: " + senha);
		Connection conexao = ConnectionFactory.getConnection();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		System.out.println("CONSULTAR conexao = " + conexao);
		String sql = "SELECT login,senha FROM usuario where login=? and senha=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);

			System.out.println("CONSULTAR SELECT: " + ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				listaUsuario.add(usuario);

				System.out.println("USUARIO: " + usuario.getNome() + " - " + usuario.getSobrenome() + "" + " - "
						+ usuario.getLogin() + " - " + usuario.getSenha() + " - " + usuario.getDataNascimento() + " - "
						+ usuario.isAdm());
			}

			/*
			 * Connection connection = ConnectionFactory.getConnection(); Statement
			 * statement = connection.createStatement(); boolean resultado =
			 * statement.execute("SELECT * FROM usuario where login='afc' and senha='123'");
			 * ResultSet resultSet = statement.getResultSet();
			 * 
			 * while (resultSet.next()) { int id = resultSet.getInt("idusuario"); String
			 * nome = resultSet.getString("nome"); System.out.println("id=" + id + ", nome="
			 * + nome); }
			 * 
			 * resultSet.close(); statement.close(); connection.close();
			 */

			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			System.out.println("ROLLBACK");
			conexao.rollback();
		} finally {
			// fechar a conexão
			System.out.println("FECHANDO CONEXAO");
			conexao.close();
		}

		return listaUsuario;
	}

	public static boolean autenticar(String login, String senha) throws SQLException {
		System.out.println("AUTENTICAR ==> LOGIN: " + login + " SENHA: " + senha);
		List<Usuario> listaUsuario = consultar(login, senha);

		if (!listaUsuario.isEmpty()) {
			System.out.println("autenticado true");
			return true;
		} else {
			System.out.println("autenticado false");
			return false;
		}

	}

	public static List<Usuario> ListaUsuario() throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		System.out.println("LISTAUSUARIO conexao = " + connection);

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from usuario");
		ResultSet rs = statement.getResultSet();

		while (rs.next()) {
			// imprimindo do banco
			int id = rs.getInt("idusuario");
			String nome = rs.getString("nome");
			System.out.println("IMRIMINDO DO BANCO: id=" + id + ", nome=" + nome);

			// adicionando na lista
			Usuario usuario = new Usuario();
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			listaUsuario.add(usuario);

			// imprimindo do objeto
			System.out.println("USUARIO: " + usuario.getNome() + " - " + usuario.getSobrenome() + "" + " - "
					+ usuario.getLogin() + " - " + usuario.getSenha() + " - " + usuario.getDataNascimento() + " - "
					+ usuario.isAdm());
		}

		rs.close();
		statement.close();
		connection.close();
		return listaUsuario;

	}
	
	
	

}
