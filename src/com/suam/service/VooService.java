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

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.factory.ConnectionFactory;

public class VooService {

	public static boolean inserir(Voo voo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		List<Voo> listaVoos = ListaVoo();

		String sql = "INSERT INTO voo ( ida, volta, destino, confirmacao, assento ) VALUES (?,?,?,?,?)";

		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, formato.format(voo.getIda()));
			ps.setString(2, formato.format(voo.getVolta()));
			ps.setString(3, voo.getDestino());
			ps.setString(4, voo.getConfirmacao().toString());
			ps.setString(5, voo.getAssento());

			ps.execute();
			conexao.commit();
			System.out.println("INSERT REALIZADO COM SUCESSO!");
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
		return true;
	}

	public static Boolean update(Voo voo) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();

		// Trecho de código para Validar se existe usuário com mesmo login no banco.
		List<Voo> listaVoos = ListaVoo();

		String sql = "UPDATE usuario SET  ida = ?, volta = ?, destino = ?, confirmacao = ?, assento = ? WHERE idVoo = ?";

		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015")

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, formato.format(voo.getIda()));
			ps.setString(2, formato.format(voo.getVolta()));
			ps.setString(3, voo.getDestino());
			ps.setString(4, voo.getConfirmacao().toString());
			ps.setString(5, voo.getAssento());
			ps.setString(6, voo.getIdVoo().toString());

			System.out.println("PS UPDATE: " + ps);
			ps.execute();
			conexao.commit();
			System.out.println("UPDATE REALIZADO COM SUCESSO!");
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

	public static List<Voo> ListaVoo() throws SQLException {

		Connection connection = ConnectionFactory.getConnection();
		List<Voo> listaVoos = new ArrayList<Voo>();

		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("select * from voo");

		ResultSet rs = statement.getResultSet();

		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");

		while (rs.next()) {
			// adicionando na lista
			Voo voo = new Voo();
			voo.setIdVoo(rs.getInt("idvoo"));
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
			voo.setAssento(rs.getString("assento"));
			voo.setDestino(rs.getString("destino"));
			listaVoos.add(voo);
		}

		rs.close();
		statement.close();
		connection.close();
		System.out.println("LISTA(SELECT) CRIADA COM SUCESSO!");
		return listaVoos;
	}
	
	public static Voo buscaVooPelaId(Integer id) throws SQLException {
		List<Voo> lista = ListaVoo();
		for (Voo voo : lista) {
			if (voo.getIdVoo()== id) {
				return voo;
			}
		}
		return null;
	}

}
