package com.suam.VO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.CompraVoo;
import com.suam.bean.Usuario;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.CompraVooService;

public class UsuarioVO {

	protected String nome;
	protected String sobrenome;
	protected Date dataNascimento;
	protected String endereco;
	protected String login;
	protected String senha;
	protected String confirmaSenha;
	protected Integer id;
	protected Boolean isAdm;
	protected CartaoDeCredito cartao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {// String id) {
		this.id = id;
	}

	public Boolean getIsAdm() {
		return isAdm;
	}

	public void setIsAdm(Boolean isAdm) {
		this.isAdm = isAdm;
	}
	
	public List<CartaoDeCredito> getListaDeCartao() {
		List<CartaoDeCredito> listaCartao = new ArrayList<CartaoDeCredito>();
		try {
			listaCartao = CartaoDeCreditoService.buscaCartoesPeloIdUsuario(this.id.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCartao;
	}

	public List<CompraVoo> getListaDeCompras() {
		List<CompraVoo> listaCompra = new ArrayList<CompraVoo>();
		try {
			for (CompraVoo compraVoo : CompraVooService.ListaCompras()) {
				if (compraVoo.getIdUser().equals(this.id)) {
					listaCompra.add(compraVoo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaCompra;
	}
	
	public CartaoDeCredito getCartao() {
		return cartao;
	}

	public void setCartao(CartaoDeCredito cartao) {
		this.cartao = cartao;
	}
	
	//CRIAR SET CARTAO

}
