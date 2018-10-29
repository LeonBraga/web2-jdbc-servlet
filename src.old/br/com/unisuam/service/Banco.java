package br.com.unisuam.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.unisuam.modelo.CartaoDeCredito;
import br.com.unisuam.modelo.Usuario;

/*
 * Classe Banco
 * 
 * Simulando um bando de dados para o sistema gerenciador
 * 
 * */
public class Banco {

	private static List<Usuario> listaUsuario = new ArrayList<>();
	// simulando uma primary key
	private static Integer chaveSequencial = 1;

	// Toda a evz que o sistema for reiniciado, será inicializado com as clients
	// abaixo e adms
	static {
		// CADASTRANDO clientS NO BANCO
		Usuario adm = new Usuario();
		adm.setId(chaveSequencial++);
		adm.setNome("adm");
		adm.setSobrenome("adm");
		adm.setLogin("adm");
		adm.setSenha("adm");
		adm.setConfirmaSenha("adm");
		adm.setEndereco("adm");
		adm.setDataNascimento("15/04/1988");
		adm.setAdm(true);;

		Usuario client = new Usuario();;
		client.setId(chaveSequencial++);
		client.setNome("user");
		client.setSobrenome("user");
		client.setLogin("user");
		client.setSenha("user");
		client.setConfirmaSenha("user");
		client.setEndereco("user");
		client.setDataNascimento("16/02/2008");
		client.setAdm(false);
		
		listaUsuario.add(adm);
		listaUsuario.add(client);
		
		CartaoDeCredito cc = new CartaoDeCredito();
		cc.setNumeroCarto(00000000);
		cc.setDataVencimento("15/12/2015");
		cc.setUser(client);
	}

	// CREATE
	/*public void adiciona(Usuario usuario) {
		usuario.setId(Banco.chaveSequencial++);
		Banco.listaUsuario.add(usuario);
	}*/


	// READ
	public Usuario buscaclientPelaId(Integer id) {
		for (Usuario user : listaUsuario) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}


	public List<Usuario> getclients() {
		return Banco.listaUsuario;
	}


	// UPDATE

	// DELETE
	public void removeClient(Integer id) {
		// pederia ser feito com foreach
		Iterator<Usuario> it = listaUsuario.iterator();

		while (it.hasNext()) {
			Usuario user = it.next();

			if (user.getId() == id) {
				it.remove();
			}
		}
	}
	/*
	 * for (client client : lista) { if(client.getId() == id) { it.remove(); } }
	 */

	public Usuario existeUsuario(String login, String senha) {
		System.out.println("(VALORES RECEBIDOS PARA VERIFICAÇÃO NO BD): " + login + " :: " + senha);
		int i = 0;
	
		for (Usuario usuario : listaUsuario) {
			System.out.println("USUARIO N°: " + i++ + " - " + usuario.getLogin());
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
