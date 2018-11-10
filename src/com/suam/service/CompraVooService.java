package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.suam.bean.Assento;
import com.suam.bean.CartaoDeCredito;
import com.suam.bean.CompraVoo;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.factory.ConnectionFactory;

public class CompraVooService {

	public static void inserir(CompraVoo compra) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "INSERT INTO compravoo (" + "voo_idvoo, " + "voo_idvooVolta, " + "valorTotalCompra, "
				+ "usuario_idusuario, " + "cartaodecredito_numerocartao," + "horaDaCompra) "
				+ "VALUES(?,?,?,?,?,SELECT NOW())";

		int contador = 1;

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			List<Integer> listaNumeroVoo = new ArrayList<Integer>();
			for (Integer idVoo : listaNumeroVoo) {
				ps.setInt(contador, idVoo);
				contador++;
			}
			ps.setInt(3, compra.getValorTotalCompra());
			ps.setInt(4, compra.getIdUser());
			ps.setString(5, compra.getIdCartao());
			
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
