package com.suam.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
				+ "usuario_idusuario, " + "cartaodecredito_numerocartao," + "horaDaCompra) " + "VALUES(?,?,?,?,?,?)";

		System.out.println("valores do objeto compra:: " + compra.getIdCartao() + " - " + compra.getIdVoo().toString()
				+ " - " + compra.getIdUser() + " - " + compra.getValorTotalCompra());

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			/*
			 * List<Integer> listaNumeroVoo = new ArrayList<Integer>(); for (Integer idVoo :
			 * listaNumeroVoo) { if (listaNumeroVoo.get(0) == idVoo) { ps.setInt(1, idVoo);
			 * } else { ps.setInt(2, idVoo); } }
			 */
			// =================CORRIGIR código acima
			System.out.println("ID-Voo " + compra.getIdVoo().get(0));
			ps.setInt(1, compra.getIdVoo().get(0));
			ps.setInt(2, compra.getIdVoo().get(0));
			ps.setInt(3, compra.getValorTotalCompra());
			ps.setInt(4, compra.getIdUser());
			ps.setString(5, compra.getIdCartao());

			// Obtém LocalDateTime de agora
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String agoraFormatado = agora.format(formatador);
			System.out.println("LocalDateTime depois de formatar: " + agoraFormatado);

			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			java.util.Date date = null;
			try {
				date = formato.parse(agora.format(formatador).toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			java.sql.Date sqlAgora = new java.sql.Date(date.getTime());
			System.out.println("HORA::::" + sqlAgora);
			ps.setDate(6, sqlAgora);

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
