package com.suam.bean;

public class CartaoDeCredito {

	private String numeroCartao;
	private String dataVencimento;
	private Integer idUser;

	public CartaoDeCredito() {
		super();
	}
	
	public CartaoDeCredito(String numeroCartao, String dataVencimento, Integer idUser) {
		super();
		this.numeroCartao = numeroCartao;
		this.dataVencimento = dataVencimento;
		this.idUser = idUser;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getNumeroCarto() {
		return numeroCartao;
	}

	public void setNumeroCarto(String numeroCarto) {
		this.numeroCartao = numeroCarto;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}
