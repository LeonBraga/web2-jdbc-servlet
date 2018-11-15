package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.suam.bean.CompraVoo;
import com.suam.bean.Usuario;
import com.suam.factory.ConnectionFactory;
import com.suam.util.DataUtils;

public class CompraVooService {

	public static void inserir(CompraVoo compra) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql;
		if (compra.getIdVoo().size() > 1) {
			sql = "INSERT INTO compravoo (" + "voo_idvoo, " + "voo_idvooVolta, " + "valorTotalCompra, "
					+ "usuario_idusuario, " + "cartaodecredito_numerocartao," + "horaDaCompra) "
					+ "VALUES(?,?,?,?,?,?)";
		} else {
			sql = "INSERT INTO compravoo (" + "voo_idvoo, " + "valorTotalCompra, " + "usuario_idusuario, "
					+ "cartaodecredito_numerocartao," + "horaDaCompra) " + "VALUES(?,?,?,?,?)";
		}
		System.out.println("Dados da Compra:: " + compra.getIdCartao() + " - " + compra.getIdVoo().toString() + " - "
				+ compra.getIdUser() + " - " + compra.getValorTotalCompra());

		String agora = DataUtils.gravarDataEHoraAtualBD();
		System.out.println("HORA====>>> " + agora);

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			System.out.println("ID-Voo " + compra.getIdVoo().get(0));
			ps.setInt(1, compra.getIdVoo().get(0));
			if (compra.getIdVoo().size() > 1) {
				ps.setInt(2, compra.getIdVoo().get(1));
				ps.setInt(3, compra.getValorTotalCompra());
				ps.setInt(4, compra.getIdUser());
				ps.setString(5, compra.getIdCartao());
				ps.setString(6, agora);
			}
			ps.setInt(2, compra.getValorTotalCompra());
			ps.setInt(3, compra.getIdUser());
			ps.setString(4, compra.getIdCartao());
			ps.setString(5, agora);

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

	// Deletando compras feitas por um usuario
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

	// Deletando voos comprados =>> AO DELETAR UM VOO ELE PERMANECERÁ REGISTRADO
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

	// Listando Todas as Compras
	public static List<CompraVoo> ListaCompras() throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		List<CompraVoo> listaCompras = new ArrayList<CompraVoo>();

		Statement statement = connection.createStatement();
		statement.execute("select * from compravoo where exclusaoLogica = '1' ");

		ResultSet rs = statement.getResultSet();

		while (rs.next()) {
			CompraVoo compraVoo = new CompraVoo();
			compraVoo.setIdUser(rs.getInt("usuario_IDUSUARIO"));
			compraVoo.setIdCartao(rs.getString("cartaodecredito_NUMEROCARTAO"));
			List<Integer> listaNumeroVoo = new ArrayList<Integer>();
			listaNumeroVoo.add(rs.getInt("voo_idvoo"));
			listaNumeroVoo.add(rs.getInt("voo_idvooVolta"));
			compraVoo.setIdVoo(listaNumeroVoo);
			compraVoo.setValorTotalCompra(rs.getInt("valorTotalCompra"));
			compraVoo.setIdCompra(rs.getString("idcompraVoo"));

			String dataRecebida = rs.getString("horaDaCompra");
			compraVoo.setHoraCompra(dataRecebida);

			listaCompras.add(compraVoo);
		}

		for (CompraVoo compraVoo : listaCompras) {
			System.out.println(compraVoo.getHoraCompra());
		}

		rs.close();
		statement.close();
		connection.close();
		return listaCompras;
	}

}
