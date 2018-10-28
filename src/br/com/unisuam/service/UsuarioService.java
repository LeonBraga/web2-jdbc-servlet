package br.com.unisuam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unisuam.modelo.CartaoDeCredito;
import br.com.unisuam.modelo.Usuario;
import br.com.unisuam.factory.ConnectionFactory;

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
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// fechar a conexão
			conexao.close();
		}
	}

	public static List<Usuario> consultar(String login, String senha) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		String sql = "SELECT login,senha FROM usuario where login=? and senha=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setLogin(rs.getString("login"));
				usuario.setLogin(rs.getString("senha"));
				listaUsuario.add(usuario);
			}

			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
		} finally {
			// fechar a conexão
			conexao.close();
		}

		return listaUsuario;
	}

	// public static Boolean autenticar(String login, String senha) throws
	// SQLException {
	public Usuario autenticar(String login, String senha) throws SQLException {

		// List<Usuario> listaUsuario = consultar(login, senha);
		Usuario user = new Usuario();
		user = (Usuario) consultar(login, senha);

		/*
		 * if(!listaUsuario.isEmpty()){ return true; } else{ return false; }
		 */
		return user;
	}

}
