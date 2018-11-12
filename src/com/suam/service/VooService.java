package com.suam.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.suam.bean.Voo;
import com.suam.factory.ConnectionFactory;

public class VooService {

	public static boolean inserir(Voo voo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "INSERT INTO voo ( ida, origem, destino, confirmacao, valorVoo) VALUES (?,?,?,?,?)";

		// SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setDate(1, voo.getIda());
			ps.setString(2, voo.getOrigem());
			ps.setString(3, voo.getDestino());
			ps.setBoolean(4, voo.getConfirmacao());
			ps.setInt(5, voo.getValorVoo());

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

	public static Boolean update(Voo voo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "UPDATE voo SET  ida = ?,origem = ?,  destino = ?, confirmacao = ?, valorVoo = ? WHERE idVoo = ?";

		//SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setDate(1, voo.getIda());
			ps.setString(2, voo.getOrigem());
			ps.setString(3, voo.getDestino());
			if(voo.getConfirmacao()) {
				ps.setString(4, "1");
			}else {
				ps.setString(4, "0");
			}
			
			ps.setInt(5, voo.getValorVoo());
			ps.setString(6, voo.getIdVoo().toString());

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

	public static List<Voo> ListaVoo() throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		List<Voo> listaVoos = new ArrayList<Voo>();

		Statement statement = connection.createStatement();
		statement.execute("select * from voo where exclusaoLogica = '1'");

		ResultSet rs = statement.getResultSet();

		// SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		while (rs.next()) {
			Voo voo = new Voo();
			voo.setIdVoo(rs.getInt("idvoo"));
			voo.setIda(rs.getDate("ida"));
			voo.setConfirmacao(rs.getBoolean("confirmacao"));
			voo.setOrigem(rs.getString("origem"));
			voo.setDestino(rs.getString("destino"));
			voo.setValorVoo(rs.getInt("valorVoo"));
			listaVoos.add(voo);
		}
		rs.close();
		statement.close();
		connection.close();
		return listaVoos;
	}

	public static Voo buscaVooPelaId(Integer id) throws SQLException {
		List<Voo> lista = ListaVoo();
		for (Voo voo : lista) {
			if (voo.getIdVoo() == id) {
				return voo;
			}
		}
		return null;
	}

	public static void delete(Voo voo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		//String sql = "DELETE FROM voo WHERE idVoo = ?";
		String sql = "UPDATE voo SET exclusaoLogica = '0' WHERE idVoo = ?";
		//String sql1 = "DELETE FROM ASSENTO WHERE voo_idVoo =?";
		String sql1 = "UPDATE assento SET exclusaoLogica = '0' WHERE voo_idvoo = ?";
		
		try {
			PreparedStatement ps1 = conexao.prepareStatement(sql1);
			ps1.setInt(1, voo.getIdVoo());
			ps1.execute();
			conexao.commit();

		} catch (SQLException e) {
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		}

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1,voo.getIdVoo());
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

}
