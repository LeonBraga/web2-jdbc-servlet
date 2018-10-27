package br.om.suam.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unisuam.modelo.CartaoDeCredito;
import br.com.unisuam.modelo.Cliente;
import br.com.unisuam.factory.ConnectionFactory;

public class ClienteService {

	public static void inserir(Cliente cliente, CartaoDeCredito cc) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		String sql = "INSERT INTO cliente (nome, sobrenome, login, senha, dataNascimento, endereco (?,?,?,?,?,?)";

		CartaoDeCredito cC = new CartaoDeCredito();
		cC=cc;
		
		try {
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getSobrenome());
			ps.setString(3, cliente.getLogin());
			ps.setString(3, cliente.getSenha());
			ps.setString(3, cliente.getDataNascimento());
			ps.setString(3, cliente.getEndereco());
			
			ps.execute();
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
			e.printStackTrace();
			throw new SQLException();
		} finally {
			// fechar a conexão
			conexao.close();
		}
	}
	
	public static List<Cliente> consultar(String login, String senha) throws SQLException {
		Connection conexao = ConnectionFactory.getConnection();
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		String sql = "SELECT login,senha FROM cliente where login=? and senha=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setLogin(rs.getString("login"));
				cliente.setLogin(rs.getString("senha"));
				listaCliente.add(cliente);
			}
			
			conexao.commit();
		} catch (SQLException e) {
			// Erro, provoca um Rollback (volta ao estado anterior do banco)
			conexao.rollback();
		} finally {
			// fechar a conexão
			conexao.close();
		}
		
		return listaCliente;
	}
	
	public static boolean autenticar(String login, String senha) throws SQLException {
		
		List<Cliente> listacliente = consultar(login, senha);;
		
		if(!listacliente.isEmpty()){
			return true;
		} 
		
		else{
			return false;
		}
		
	}

}
