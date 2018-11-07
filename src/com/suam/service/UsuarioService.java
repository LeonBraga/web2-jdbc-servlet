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

		// Código para Validar se existe usuário com mesmo login no banco.
		List<Usuario> listaUsuarios = ListaUsuarios();
		for (Usuario u : listaUsuarios) {
			if (u.getLogin().equals(usuario.getLogin())) {
				return false;
			}
		}

		String sql = "INSERT INTO usuario (nome, sobrenome, endereco, senha, login, dataNascimento, isadm ) VALUES (?,?,?,?,?,?,?)";

		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");

		System.out.println("Usuario a ser inserido: " + usuario.getNome() + " - " + usuario.getSobrenome() + " - "
				+ usuario.getEndereco() + " - " + usuario.getSenha() + " - " + usuario.getLogin() + " - "
				+ formato.format(usuario.getDataNascimento()) + " - " + usuario.getIsAdm());
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
		} catch (SQLException e) {
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			conexao.close();
		}
		return true;
	}

	public static Boolean update(Usuario usuario) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		// Código para Validar se existe usuário com mesmo login no banco.
		List<Usuario> listaUsuarios = ListaUsuarios();

		for (Usuario u : listaUsuarios) {
			if (!u.getId().equals(usuario.getId())) {
				if (u.getLogin().equals(usuario.getLogin())) {
					System.out.println("Usuario com login já cadastrado!");
					System.out.println("CORRIGIR LOGIN!!");
					return false;
				}
			}
		}

		String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, endereco = ?,  senha = ?, login = ?, dataNascimento = ?, isadm = ? WHERE idusuario = ?";

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		/*
		 * System.out.println("Usuario a ser atualizado: " + usuario.getNome() + " - " +
		 * usuario.getSobrenome() + " - " + usuario.getEndereco() + " - " +
		 * usuario.getSenha() + " - " + usuario.getLogin() + " - " +
		 * formato.format(usuario.getDataNascimento()) + " - " + usuario.getIsAdm());
		 */
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

			ps.execute();
			conexao.commit();
		} catch (SQLException e) {
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			conexao.close();
		}
		return true;
	}

	public static List<Usuario> ListaUsuarios() throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		Statement statement = connection.createStatement();
		statement.execute("select * from usuario");

		ResultSet rs = statement.getResultSet();

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		while (rs.next()) {
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
			 * System.out.println("Usuario adicionado a lista: " + usuario.getNome() + " - "
			 * + usuario.getSobrenome() + " - " + usuario.getEndereco() + " - " +
			 * usuario.getSenha() + " - " + usuario.getLogin() + " - " +
			 * formato.format(usuario.getDataNascimento()) + " - " + usuario.getIsAdm() +
			 * "\n");
			 */ }

		rs.close();
		statement.close();
		connection.close();
		return listaUsuario;
	}

	public static void delete(Usuario usuario) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "DELETE FROM usuario WHERE idusuario = ?";

		System.out.println("Usuario a ser removido: " + usuario.getNome() + " - " + usuario.getSobrenome() + " - "
				+ usuario.getEndereco() + " - " + usuario.getSenha() + " - " + usuario.getLogin() + " - "
				+ usuario.getDataNascimento() + " - " + usuario.getIsAdm());
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);

			String id = usuario.getId().toString();
			ps.setString(1, id);
			ps.execute();
			conexao.commit();
		} catch (SQLException e) {
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
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

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

			while (rs.next()) {
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

			}
			// conexao.commit();
		} catch (SQLException e) {
			System.out.println("ERRO: " + e);
			// conexao.rollback();
		} finally {
			conexao.close();
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
