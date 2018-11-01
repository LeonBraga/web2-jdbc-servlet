package com.suam.bean;

import java.math.BigInteger;

public class CartaoDeCredito {

	private String titular;
	private Long  numeroCartao;
	private String dataVencimento;
	private Integer idUser;

	public CartaoDeCredito() {
		super();
	}

	public CartaoDeCredito(Long  numeroCartao, String dataVencimento, Integer idUser) {
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

	public Long  getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(Long  numeroCarto) {
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
