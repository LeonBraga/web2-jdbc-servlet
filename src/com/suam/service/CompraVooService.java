package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.suam.bean.CompraVoo;
import com.suam.factory.ConnectionFactory;
import com.suam.util.DataUtils;

public class CompraVooService {

	public static void inserir(CompraVoo compra) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "INSERT INTO compravoo (" + "voo_idvoo, " + "voo_idvooVolta, " + "valorTotalCompra, "
				+ "usuario_idusuario, " + "cartaodecredito_numerocartao," + "horaDaCompra) " + "VALUES(?,?,?,?,?,?)";

		System.out.println("Dados da Compra:: " + compra.getIdCartao() + " - " + compra.getIdVoo().toString() + " - "
				+ compra.getIdUser() + " - " + compra.getValorTotalCompra());

//		// PEGANDO A DATA ATUAL:::
//		String agora = null;
//		Statement statement = conexao.createStatement();
//		try {
//			statement.execute("SELECT DATE_FORMAT(now(), '%y-%m-%d %H:%i:%s')as 'agora'");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		ResultSet rs = statement.getResultSet();
//		try {
//			while (rs.next()) {
//				agora = rs.getString("agora");
//				System.out.println("Hora da Compra: " + rs.getString("agora"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		String agora = DataUtils.gravarDataEHoraAtualBD();
		System.out.println("HORA====>>> "+agora);

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

	//Deletando compras feitas por um usuario
	public static void deleteCompraPorVoo(Integer vooId) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		// String sql = "DELETE FROM compravoo WHERE usuario_IDUSUARIO = ?";
		String sql = "UPDATE compravoo SET exclusaoLogica = '0' WHERE voo_idvoo = ?";

		try {
			PreparedStatement ps1 = conexao.prepareStatement(sql);
			ps1.setInt(1, vooId);
			ps1.execute();
			conexao.commit();
		} catch (SQLException e) {
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			conexao.close();
		}
	}
	
	//Deletando voos comprados =>> AO DELETAR UM VOO ELE PERMANECERÁ REGISTRADO
		public static void deleteCompraPorUsuario(Integer usuarioId) throws SQLException {
			Connection conexao = ConnectionFactory.getConnection();

			// String sql = "DELETE FROM compravoo WHERE usuario_IDUSUARIO = ?";
			String sql = "UPDATE compravoo SET exclusaoLogica = '0' WHERE usuario_IDUSUARIO = ?";

			try {
				PreparedStatement ps1 = conexao.prepareStatement(sql);
				ps1.setInt(1, usuarioId);
				ps1.execute();
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
