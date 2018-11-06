package com.suam.bean;

public class CompraVoo {
	protected Integer idCompraVoo;
	protected Integer idUser;
	protected Integer idVooIda;
	protected Integer idVooVolta;
	protected String preco;

	public Integer getIdCompraVoo() {
		return idCompraVoo;
	}

	public void setIdCompraVoo(Integer idCompraVoo) {
		this.idCompraVoo = idCompraVoo;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public Integer getIdVoo() {
		return idVooIda;
	}

	public void setIdVoo(Integer idVoo) {
		this.idVooIda = idVoo;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Integer getIdVooVolta() {
		return idVooVolta;
	}

	public void setIdVooVolta(Integer idVooVolta) {
		this.idVooVolta = idVooVolta;
	}
}
