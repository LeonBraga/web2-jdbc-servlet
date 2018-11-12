package com.suam.VO;

import java.util.List;

public class CompraVooVO {

	// protected Integer idCompra;
	protected List<Integer> idVoo;
	protected Integer idUser;
	protected String idCartao;
	protected Integer valorTotalCompra;
	protected String horaCompra;
	protected String nomeUsuario;
	
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public List<Integer> getIdVoo() {
		return idVoo;
	}
	public void setIdVoo(List<Integer> idVoo) {
		this.idVoo = idVoo;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public String getIdCartao() {
		return idCartao;
	}
	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}
	public Integer getValorTotalCompra() {
		return valorTotalCompra;
	}
	public void setValorTotalCompra(Integer valorTotalCompra) {
		this.valorTotalCompra = valorTotalCompra;
	}
	public String getHoraCompra() {
		return horaCompra;
	}
	public void setHoraCompra(String horaCompra) {
		this.horaCompra = horaCompra;
	}
	
	
}
