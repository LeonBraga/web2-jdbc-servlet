package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.suam.bean.Usuario;
import com.suam.factory.ConnectionFactory;

public class UsuarioService {

	public static boolean inserir(Usuario usuario) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		// Trecho de código para Validar se existe usuário com mesmo login no banco.
		List<Usuario> listaUsuarios = ListaUsuarios();
		for (Usuario u : listaUsuarios) {
			if (u.getLogin().equals(usuario.getLogin())) {
				System.out.println("Usuario com login já cadastrado!");
				// retornar um redirect para página de edição;
				return false;
			}
			// o else se dá com a execução normal do método de inserção, porem temos que
			// retornar uma string no final da execução.
		}

		String sql = "INSERT INTO usuario (nome, sobrenome, endereco, senha, login, dataNascimento, isadm ) VALUES (?,?,?,?,?,?,?)";

		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSobrenome());
			ps.setString(3, usuario.getEndereco());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getLogin());
			ps.setString(6, formato.format(usuario.getDataNascimento()));
			ps.setString(7, usuario.getIsAdm().toString());

			ps.execute();
			conexao.commit();
			System.out.println("INSERT REALIZADO COM SUCESSO!");
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			System.out.println("ERRO ROLLBACK" + e);
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// fechar a conexão
			System.out.println("FECHANDO CONEXAO: ");
			conexao.close();
		}
		return true;
	}

	public static Boolean update(Usuario usuario) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		// Trecho de código para Validar se existe usuário com mesmo login no banco.
		List<Usuario> listaUsuarios = ListaUsuarios();

		for (Usuario u : listaUsuarios) {
			if (!u.getId().equals(usuario.getId())) {
				if (u.getLogin().equals(usuario.getLogin())) {
					System.out.println("Usuario com login já cadastrado!");
					System.out.println("CORRIGIR LOGIN!!");
					// retornar um redirect para página de edição;
					return false;
				}
			}
			// o else se dá com a execução normal do método de inserção, porem temos que
			// retornar uma string no final da execução.
		}

		String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, endereco = ?,  senha = ?, login = ?, dataNascimento = ?, isadm = ? WHERE idusuario = ?";

		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSobrenome());
			ps.setString(3, usuario.getEndereco());
			ps.setString(4, usuario.getSenha());
			ps.setString(5, usuario.getLogin());
			ps.setString(6, formato.format(usuario.getDataNascimento()));
			ps.setString(7, usuario.getIsAdm().toString());
			String id = usuario.getId().toString();
			ps.setString(8, id);

			System.out.println("PS UPDATE: " + ps);
			ps.execute();
			conexao.commit();
			System.out.println("UPDATE REALIZADO COM SUCESSO!");
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)

			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// fechar a conexão
			conexao.close();
		}
		return true;
	}

	public static List<Usuario> ListaUsuarios() throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from usuario");

		ResultSet rs = statement.getResultSet();

		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");

		while (rs.next()) {

			// adicionando na lista
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("idusuario"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSobrenome(rs.getString("sobrenome"));
			usuario.setEndereco(rs.getString("endereco"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setLogin(rs.getString("login"));
			try {
				usuario.setDataNascimento(formato.parse(rs.getString("datanascimento")));
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("A data não pode ser convertida");
			}
			usuario.setIsAdm(rs.getBoolean("isAdm"));
			listaUsuario.add(usuario);

			// imprimindo do objeto

		}

		rs.close();
		statement.close();
		connection.close();
		System.out.println("LISTA(SELECT) CRIADA COM SUCESSO!");
		return listaUsuario;
	}

	public static void delete(Usuario usuario) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "DELETE FROM usuario WHERE idusuario = ?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);

			String id = usuario.getId().toString();
			ps.setString(1, id);

			System.out.println("PS DELETE: " + ps);
			ps.execute();
			conexao.commit();
			System.out.println("DELETE REALIZADO COM SUCESSO!");
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
		System.out.println("CONSULTAR ==> LOGIN: " + login + " SENHA: " + senha);
		Connection conexao = ConnectionFactory.getConnection();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		String sql = "SELECT * FROM usuario where login=? and senha=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);

			System.out.println("CONSULTAR SELECT: " + ps);
			ResultSet rs = ps.executeQuery();

			// convertendo data para string
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			// Date data = formato.parse("23/11/2015");

			while (rs.next()) {
				// adicionando na lista
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("idusuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setLogin(rs.getString("login"));
				try {
					usuario.setDataNascimento(formato.parse(rs.getString("datanascimento")));
				} catch (ParseException e) {
					e.printStackTrace();
					System.out.println("A data não pode ser convertida");
				}
				usuario.setIsAdm(rs.getBoolean("isAdm"));
				listaUsuario.add(usuario);

				/*
				 * System.out.println("USUARIO: " + usuario.getNome() + " - " +
				 * usuario.getSobrenome() + "" + " - " + usuario.getLogin() + " - " +
				 * usuario.getSenha() + " - " + usuario.getDataNascimento() + " - " +
				 * usuario.isAdm());
				 */
			}
			// conexao.commit();
			System.out.println("SELECT REALIZADO COM SUCESSO!");
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			System.out.println("ERRO: " + e);
			// conexao.rollback();
		} finally {
			// fechar a conexão
			// System.out.println("FECHANDO CONEXAO");
			// conexao.close();
		}
		return listaUsuario;
	}

	public static boolean autenticar(String login, String senha) throws SQLException {
		System.out.println("TENTANDO AUTENTICAR ==> LOGIN: " + login + " SENHA: " + senha);
		List<Usuario> listaUsuario = consultar(login, senha);

		if (!listaUsuario.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public static Usuario buscaUsuarioPelaId(Integer id) throws SQLException {
		List<Usuario> lista = ListaUsuarios();
		for (Usuario usuario : lista) {
			if (usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}

}
