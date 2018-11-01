package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.factory.ConnectionFactory;

public class CartaoDeCreditoService {

	public static boolean inserir(CartaoDeCredito cartao) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "INSERT INTO cartaodecredito (numeroCartao, dataVencimento, usuario_idusuario) VALUES (?,?,?)";

		try {

			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cartao.getNumeroCartao().trim());
			ps.setString(2, cartao.getDataVencimento().trim());
			ps.setString(3, cartao.getIdUser().toString().trim());

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

	public static Boolean update(CartaoDeCredito cartao) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "UPDATE cartaodecredito SET dataVencimento= ? WHERE usuario_idusuario = ?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			//ps.setString(1, cartao.getNumeroCartao());
			ps.setString(1, cartao.getDataVencimento().trim());
			ps.setString(2, cartao.getIdUser().toString().trim());

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

	public static List<CartaoDeCredito> ListaCartoes() throws SQLException {
		System.out.println("LISTANDO TODOS!");
		Connection connection = ConnectionFactory.getConnection();
		List<CartaoDeCredito> listaCartoes = new ArrayList<CartaoDeCredito>();

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from cartaodecredito");

		ResultSet rs = statement.getResultSet();

		while (rs.next()) {
			// valores recebidos diretamente do banco de dados
			int id = rs.getInt("usuario_idusuario");
			String numeroCartao = rs.getString("numeroCartao");
			// System.out.println("IMRIMINDO DO BANCO: id=" + id + ", nome=" + nome);

			// adicionando na lista
			CartaoDeCredito cartao = new CartaoDeCredito();
			cartao.setIdUser(rs.getInt("usuario_idusuario"));
			cartao.setNumeroCartao(rs.getString("numeroCartao"));
			cartao.setDataVencimento(rs.getString("dataVencimento"));
			listaCartoes.add(cartao);
		}

		rs.close();
		statement.close();
		connection.close();
		System.out.println("LISTA(SELECT) CRIADA COM SUCESSO!");
		return listaCartoes;
	}

	public static void delete(CartaoDeCredito cartao) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "DELETE FROM cartaodecredito WHERE numerocartao = ?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);

			String id = cartao.getNumeroCartao().toString();
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

	public static List<CartaoDeCredito> consultar(String numero, String idUser) throws SQLException {
		System.out.println("CONSULTAR ==> NUMERO: " + numero + idUser);
		Connection conexao = ConnectionFactory.getConnection();
		List<CartaoDeCredito> listaCartoes = new ArrayList<CartaoDeCredito>();

		String sql = "SELECT * FROM cartaodecredito where numerocartao=? and usuario_idusuario=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, numero);
			ps.setString(2, idUser);

			System.out.println("CONSULTAR SELECT: " + ps);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CartaoDeCredito cartao = new CartaoDeCredito();
				ps.setString(1, cartao.getNumeroCartao().toString());
				ps.setString(2, cartao.getDataVencimento());
				ps.setString(3, cartao.getIdUser().toString());
				listaCartoes.add(cartao);

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
		return listaCartoes;
	}

	

	public static CartaoDeCredito buscaUsuarioPelaId(Integer id) throws SQLException {
		List<CartaoDeCredito> lista = ListaCartoes();
		for (CartaoDeCredito cartao : lista) {
			if (cartao.getIdUser() == id) {
				return cartao;
			}
		}
		return null;
	}

}
