package com.suam.bean;

public class Assento {
	protected Integer idVoo;
	protected Integer numeroAssento;
	protected boolean ocupado;

	public Integer getNumeroAssento() {
		return numeroAssento;
	}

	public void setNumeroAssento(Integer numeroAssento) {
		this.numeroAssento = numeroAssento;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Integer getIdVoo() {
		return idVoo;
	}

	public void setIdVoo(Integer idVoo) {
		this.idVoo = idVoo;
	}
}
