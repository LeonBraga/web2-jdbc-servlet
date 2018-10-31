package com.suam.bean;

public class CartaoDeCredito {

	private String titular;
	private Integer numeroCartao;
	private String dataVencimento;
	private Integer idUser;

	public CartaoDeCredito() {
		super();
	}

	public CartaoDeCredito(Integer numeroCartao, String dataVencimento, Integer idUser) {
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

	public Integer getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Integer numeroCarto) {
		this.numeroCartao = numeroCarto;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
}
