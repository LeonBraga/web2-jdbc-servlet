package com.suam.bean;

public class CompraVoo {

	protected Integer idUser;
	protected Integer idCartao;
	protected Integer idVooIda;
	protected Integer idVooVolta;
	protected Integer assento;
	protected Integer valorCompra;

	protected Integer idCompraVoo;

	public Integer getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Integer idCartao) {
		this.idCartao = idCartao;
	}

	public Integer getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Integer valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Integer getIdVooIda() {
		return idVooIda;
	}

	public void setIdVooIda(Integer idVooIda) {
		this.idVooIda = idVooIda;
	}

	public Integer getAssento() {
		return assento;
	}

	public void setAssento(Integer assento) {
		this.assento = assento;
	}

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
