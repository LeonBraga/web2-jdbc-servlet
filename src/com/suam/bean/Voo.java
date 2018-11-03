package com.suam.bean;

import java.util.Date;

public class Voo {
	Integer idVoo;
	Date ida;
	Date volta;
	String destino;
	Boolean confirmacao;
	String assento;
	
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
	public Date getVolta() {
		return volta;
	}
	public void setVolta(Date date) {
		this.volta = date;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
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
