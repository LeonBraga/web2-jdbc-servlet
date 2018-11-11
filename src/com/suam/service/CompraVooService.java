package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.suam.bean.Assento;
import com.suam.bean.CompraVoo;
import com.suam.factory.ConnectionFactory;

public class CompraVooService {

	public static void inserir(CompraVoo compra) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "INSERT INTO compravoo (" + "voo_idvoo, " + "voo_idvooVolta, " + "valorTotalCompra, "
				+ "usuario_idusuario, " + "cartaodecredito_numerocartao," + "horaDaCompra) " + "VALUES(?,?,?,?,?,?)";

		System.out.println("valores do objeto compra:: " + compra.getIdCartao() + " - " + compra.getIdVoo().toString()
				+ " - " + compra.getIdUser() + " - " + compra.getValorTotalCompra());

		
		//PEGANDO A DATA ATUAL:::
		String agora = null;
		Statement statement = conexao.createStatement();
		try {
			statement.execute("SELECT DATE_FORMAT(now(), '%y-%m-%d %H:%i:%s')as 'agora'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = statement.getResultSet();
		try {
			while (rs.next()) {
				agora = rs.getString("agora");
				System.out.println(rs.getString("agora"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			System.out.println("ID-Voo " + compra.getIdVoo().get(0));
			ps.setInt(1, compra.getIdVoo().get(0));
			ps.setInt(2, compra.getIdVoo().get(0));
			ps.setInt(3, compra.getValorTotalCompra());
			ps.setInt(4, compra.getIdUser());
			ps.setString(5, compra.getIdCartao());
			ps.setString(6, agora);

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
