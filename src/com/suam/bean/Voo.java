package com.suam.bean;

import java.util.Date;

public class Voo {
	protected Integer idVoo;
	protected Date ida;
	protected String destino;
	protected String origem;
	protected Boolean confirmacao;
	protected String assento;

	public Integer getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(Integer idVoo) {
		this.idVoo = idVoo;
	}

	public Date getIda() {
		return ida;
	}

	public void setIda(Date ida) {
		this.ida = ida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Boolean getConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(Boolean string) {
		this.confirmacao = string;
	}

	public String getAssento() {
		return assento;
	}

	public void setAssento(String assento) {
		this.assento = assento;
	}

}
