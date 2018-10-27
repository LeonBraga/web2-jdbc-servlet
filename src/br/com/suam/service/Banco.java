package br.com.suam.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.unisuam.modelo.Admistrador;
import br.com.unisuam.modelo.Cliente;
import br.com.unisuam.modelo.Usuario;

/*
 * Classe Banco
 * 
 * Simulando um bando de dados para o sistema gerenciador
 * 
 * */
public class Banco {

	private static List<Cliente> listaCliente = new ArrayList<>();
	private static List<Admistrador> listaAdm = new ArrayList<>();
	// simulando uma primary key
	private static Integer chaveSequencial = 1;

	// Toda a evz que o sistema for reiniciado, será inicializado com as clients
	// abaixo e adms
	static {
		// CADASTRANDO clientS NO BANCO
		Admistrador adm = new Admistrador();
		adm.setId(chaveSequencial++);
		adm.setNome("adm");
		adm.setSobrenome("adm");
		adm.setLogin("adm");
		adm.setSenha("adm");
		adm.setConfirmaSenha("adm");
		adm.setEndereco("adm");
		adm.setDataNascimento("00/00/0000");
		adm.setAdm(true);;

		Cliente client = new Cliente();
		client.setNome("user");
		client.setSobrenome("user");
		client.setLogin("user");
		client.setSenha("user");
		client.setConfirmaSenha("user");
		client.setEndereco("user");
		client.setDataNascimento("00/00/0000");

		listaAdm.add(adm);
		listaCliente.add(client);
	}

	// CREATE
	public void adiciona(Cliente client) {
		client.setId(Banco.chaveSequencial++);
		Banco.listaCliente.add(client);
	}

	public void adicionaADM(Admistrador adm) {
		adm.setId(Banco.chaveSequencial++);
		Banco.listaAdm.add(adm);
	}

	// READ

	public Cliente buscaclientPelaId(Integer id) {
		for (Cliente client : listaCliente) {
			if (client.getId() == id) {
				return client;
			}
		}
		return null;
	}

	public Admistrador buscaAdmPelaId(Integer id) {
		for (Admistrador adm : listaAdm) {
			if (adm.getId() == id) {
				return adm;
			}
		}
		return null;
	}

	public List<Cliente> getclients() {
		return Banco.listaCliente;
	}

	public List<Admistrador> getAdm() {
		return Banco.listaAdm;
	}

	// UPDATE

	// DELETE
	public void removeClient(Integer id) {
		// pederia ser feito com foreach
		Iterator<Cliente> it = listaCliente.iterator();

		while (it.hasNext()) {
			Cliente cli = it.next();

			if (cli.getId() == id) {
				it.remove();
			}
		}
	}

	public void removeAdm(Integer id) {
		// pederia ser feito com foreach
		Iterator<Admistrador> it = listaAdm.iterator();

		while (it.hasNext()) {
			Admistrador adm = it.next();

			if (adm.getId() == id) {
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
		List<Usuario> listaUsuarios = new ArrayList<>();

		listaUsuarios.addAll(listaAdm);
		listaUsuarios.addAll(listaCliente);
		for (Usuario usuario : listaUsuarios) {
			System.out.println("USUARIO N°: " + i++ + " - " + usuario.getLogin());
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
