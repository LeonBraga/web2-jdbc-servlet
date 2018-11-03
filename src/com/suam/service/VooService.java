package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.factory.ConnectionFactory;

public class VooService {

	public static boolean inserir(Voo voo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		List<Voo> listaVoos = ListaVoo();

		String sql = "INSERT INTO voo ( ida, volta, destino, confirmacao, assento ) VALUES (?,?,?,?,?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, voo.getIda());
			ps.setString(2, voo.getVolta());
			ps.setString(3, voo.getDestino());
			ps.setString(4, voo.getConfirmacao().toString());
			ps.setString(5, voo.getAssento());

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

	public static Boolean update(Voo voo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		// Trecho de código para Validar se existe usuário com mesmo login no banco.
		List<Voo> listaVoos = ListaVoo();

		String sql = "UPDATE usuario SET  ida = ?, volta = ?, destino = ?, confirmacao = ?, assento = ? WHERE idVoo = ?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, voo.getIda());
			ps.setString(2, voo.getVolta());
			ps.setString(3, voo.getDestino());
			ps.setString(4, voo.getConfirmacao().toString());
			ps.setString(5, voo.getAssento());
			ps.setString(6, voo.getIdVoo().toString());

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

	public static List<Voo> ListaVoo() throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		List<Voo> listaVoos = new ArrayList<Voo>();

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from voo");

		ResultSet rs = statement.getResultSet();

		while (rs.next()) {
			// adicionando na lista
			Voo voo = new Voo();
			voo.setIdVoo(rs.getInt("idvoo"));
			voo.setIda(rs.getString("ida"));
			voo.setVolta(rs.getString("volta"));
			voo.setConfirmacao(rs.getString("confirmacao").toString());
			voo.setAssento(rs.getString("assento"));
			voo.setDestino(rs.getString("destino"));
			listaVoos.add(voo);
		}

		rs.close();
		statement.close();
		connection.close();
		System.out.println("LISTA(SELECT) CRIADA COM SUCESSO!");
		return listaVoos;
	}

}
