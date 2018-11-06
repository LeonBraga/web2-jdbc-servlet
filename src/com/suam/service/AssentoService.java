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

import com.suam.bean.Assento;
import com.suam.bean.Voo;
import com.suam.factory.ConnectionFactory;

public class AssentoService {

	public static void inserir(String assento, Integer idVoo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "INSERT INTO assento VALUES(?,true,?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, assento);
			ps.setInt(2, idVoo);

			ps.execute();
			conexao.commit();
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
	}

	public static Boolean update(Assento assento) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "UPDATE assento SET  ocupado = ? WHERE Voo_idVoo = ? and idassento =?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			if (assento.isOcupado()) {
				ps.setString(1, "true");
			} else {
				ps.setString(1, "false");
			}
			ps.setInt(2, assento.getIdVoo());
			ps.setInt(1, assento.getNumeroAssento());

			System.out.println("PS UPDATE: " + ps);
			ps.execute();
			conexao.commit();
			System.out.println("UPDATE REALIZADO COM SUCESSO ==>tabela voo!");
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

	public static List<Voo> ListaAssentos(Voo voo) throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		List<Voo> listaVoos = new ArrayList<Voo>();

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from assento where vooid_voo");

		ResultSet rs = statement.getResultSet();

		while (rs.next()) {
			// adicionando na lista
			Assento assento = new Assento();
			assento.setIdVoo(rs.getInt));
			try {
				voo.setIda(formato.parse(rs.getString("ida")));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			try {
				voo.setVolta(formato.parse(rs.getString("volta")));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			voo.setConfirmacao(rs.getBoolean("confirmacao"));
			voo.setOrigem(rs.getString("origem"));
			voo.setDestino(rs.getString("destino"));
			listaVoos.add(voo);
		}

		rs.close();
		statement.close();
		connection.close();
		System.out.println("LISTA(SELECT) CRIADA COM SUCESSO ==> tabela voo!");
		return listaVoos;
	}

}
