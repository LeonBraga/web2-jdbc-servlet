package com.suam.servlet.bean;

public class CartaoDeCredito {
	
	private Integer numeroCartao;
	private String dataVencimento;
	private Usuario user;
	
//	public CartaoDeCredito(Integer numeroCartao, String dataVencimento, Usuario user) {
//		super();
//		this.numeroCartao = numeroCartao;
//		this.dataVencimento = dataVencimento;
//		this.user = user;
//	}
	
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Integer getNumeroCarto() {
		return numeroCartao;
	}
	public void setNumeroCarto(Integer numeroCarto) {
		this.numeroCartao = numeroCarto;
	}
	public String getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	

}
