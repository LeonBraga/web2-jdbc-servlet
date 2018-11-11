package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.suam.bean.Assento;
import com.suam.bean.AssentoComprados;
import com.suam.bean.Voo;
import com.suam.factory.ConnectionFactory;

public class AssentoCompradosService {

	public static void inserir(String[] assentos, String vooIdVoo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "INSERT INTO assentoscomprados VALUES(?,?)";

		for (String assento : assentos) {
			try {
				PreparedStatement ps = conexao.prepareStatement(sql);
				System.out.println("Assento ===>>" + assento + " - " + vooIdVoo);
				ps.setString(1, assento);
				ps.setString(2, vooIdVoo);

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

	public static List<AssentoComprados> ListaAssentosPorIvoo(String idVoo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<AssentoComprados> listaAssento = new ArrayList<AssentoComprados>();

		String sql = "select * from assentosComprados where voo_idvoo=? order by assentoscomprados ";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf(idVoo));

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				AssentoComprados assento = new AssentoComprados();
				assento.setNumeroAssento(rs.getInt("assentoscomprados"));
				assento.setIdVoo(rs.getInt("voo_idvoo"));
				listaAssento.add(assento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAssento;
	}

}
