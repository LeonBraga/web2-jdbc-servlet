package com.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.suam.bean.Assento;
import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.factory.ConnectionFactory;

public class CompraVooService {

	public static void inserir(List<Voo> listaVoo, Usuario usuario, Assento assento,
			CartaoDeCredito cartao) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		String sql = "INSERT INTO compravoo (voo_idvooVolta, assento, valorTotalCompra, voo_idvoo,"
				+ "usuario_idusuario, cartaodecredito_numerocartao, horaDaCompra) " + "VALUES(?,?,?,?,?,?,SELECT NOW())";

		//INCLUIR DATA DA COMPRA APÓS REALIZAR TESTES
		
		
		Integer valorTotal = 0;
		int contador = 0;

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);

			for (Voo voo : listaVoo) {
				valorTotal += voo.getValorVoo();
				if (contador == 0) {
					ps.setInt(4, voo.getIdVoo());
				}
				if (contador > 0) {
					ps.setInt(1, voo.getIdVoo());
				}
				if (contador > 1) {
					System.out.println("Erro voo ida e volta");
				}
				ps.setInt(3,valorTotal);
				contador++;
			}

			ps.setInt(2,assento.getNumeroAssento());
			ps.setInt(4,assento.getIdVoo());
			ps.setInt(5,usuario.getId());
			ps.setString(6,cartao.getNumeroCartao());
		
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
