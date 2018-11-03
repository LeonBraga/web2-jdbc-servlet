package com.suam.bean;

public class CompraVoo {
	protected Integer idCompraVoo;
	protected Integer idUser;
	protected Integer idVoo; 
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
		return idVoo;
	}
	public void setIdVoo(Integer idVoo) {
		this.idVoo = idVoo;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}

}
