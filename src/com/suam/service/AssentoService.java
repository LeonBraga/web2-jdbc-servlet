package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			conexao.close();
		}
	}

	public static Boolean update(Assento assento) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "UPDATE assento SET  ocupado = ? WHERE voo_idVoo = ? and idassento =?";
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			if (assento.isOcupado()) {
				ps.setString(1, "true");
			} else {
				ps.setString(1, "false");
			}
			ps.setInt(2, assento.getIdVoo());
			ps.setInt(3, assento.getNumeroAssento());

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

	public static List<Assento> ListaAssentos(Integer idVoo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Assento> listaAssento = new ArrayList<Assento>();

		String sql = "select * from assento where voo_idvoo=? order by idassento";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, idVoo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Assento assento = new Assento();
				assento.setNumeroAssento(rs.getInt("idassento"));
				assento.setIdVoo(rs.getInt("voo_idvoo"));
				assento.setOcupado(rs.getBoolean("ocupado"));
				if (assento.isOcupado()) {
					listaAssento.add(assento);
				} else {
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAssento;
	}

	public static List<Assento> ListaAssentosDesocupados(Integer idVoo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Assento> listaAssento = new ArrayList<Assento>();

		String sql = "select * from assento where voo_idvoo=? order by idassento";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, idVoo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Assento assento = new Assento();
				assento.setNumeroAssento(rs.getInt("idassento"));
				assento.setIdVoo(rs.getInt("voo_idvoo"));
				assento.setOcupado(rs.getBoolean("ocupado"));
				if (assento.isOcupado()) {
					
				} else {
					listaAssento.add(assento);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAssento;
	}

	// insere assentos ao cadastrar voos
	public static void inserirAssentosPorVoo() throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		Voo voo = new Voo();
		// Statement statement = conexao.createStatement();
		// statement.execute("SELECT * FROM voo WHERE idvoo= (SELECT MAX(idvoo) FROM
		// voo)");
		// ResultSet rs = statement.getResultSet();

		String sql = "INSERT INTO assento VALUES(?,false,?)";
		String sql1 = "SELECT * FROM voo WHERE idvoo= (SELECT MAX(idvoo) FROM voo)";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql1);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				voo.setIdVoo(rs.getInt("idVoo"));
				rs.close();
			}
		} catch (SQLException e) {

		}

		for (int assento = 0; assento < 100; assento++) {
			try {
				PreparedStatement ps = conexao.prepareStatement(sql);
				ps.setInt(1, assento);
				ps.setInt(2, voo.getIdVoo());

				ps.execute();
				conexao.commit();
			} catch (SQLException e) {
				conexao.rollback();
				e.printStackTrace();
				throw new SQLException();
			}
		}
		conexao.close();
	}
}
