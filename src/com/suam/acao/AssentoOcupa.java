package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Assento;
import com.suam.service.AssentoService;

public class AssentoOcupa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String comprar = request.getParameter("comprar");
		String idVoo = request.getParameter("idVoo");
		String ocupa = request.getParameter("ocupa");
		String desocupa = request.getParameter("desocupa");
		String ocupante = request.getParameter("ocupante");
		String[] numeroAssento = request.getParameterValues("numeroAssento");
		String[] numeroAssentoOcupado = request.getParameterValues("numeroAssentoOcupado");
		Assento assent = new Assento();
		Integer id = Integer.valueOf(idVoo);
		Integer idOcupante = Integer.valueOf(ocupante);
		String idVooVolta = request.getParameter("idVooVolta");
		Integer idVolta = null;
		if(idVooVolta != null) {
			idVolta = Integer.valueOf(idVooVolta);
		}
		String[] numeroAssentoVolta = request.getParameterValues("numeroAssentoVolta");
		String[] numeroAssentoOcupadoVolta = request.getParameterValues("numeroAssentoOcupadoVolta");
		
		if (numeroAssento != null ) {
			for (String assentoNum : numeroAssento) {
				Integer numAssento = Integer.valueOf(assentoNum);
				assent.setIdVoo(id);
				assent.setNumeroAssento(numAssento);
				assent.setOcupante(idOcupante);
				if (ocupa != null) {
					assent.setOcupado(true);
				} else {
					assent.setOcupado(false);
				}
				assent.setOcupante(idOcupante);
				try {
					AssentoService.update(assent);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		//List<String> listaAssentosOcupados = new ArrayList<String>();
		if (numeroAssentoOcupado != null ) {
			for (String assentoNum : numeroAssentoOcupado) {
				Integer numAssento = Integer.valueOf(assentoNum);
				assent.setIdVoo(id);
				assent.setNumeroAssento(numAssento);
				assent.setOcupante(idOcupante);
				if (desocupa != null) {
					assent.setOcupado(false);
				} else {
					assent.setOcupado(true);
				}
				try {
					AssentoService.update(assent);
					//listaAssentosOcupados.add(assentoNum);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		if(idVolta != null) {
			if (numeroAssento != null ) {
				for (String assentoNum : numeroAssentoVolta) {
					Integer numAssento = Integer.valueOf(assentoNum);
					assent.setIdVoo(idVolta);
					assent.setNumeroAssento(numAssento);
					assent.setOcupante(idOcupante);
					if (ocupa != null) {
						assent.setOcupado(true);
					} else {
						assent.setOcupado(false);
					}
					assent.setOcupante(idOcupante);
					try {
						AssentoService.update(assent);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
			//List<String> listaAssentosOcupados = new ArrayList<String>();
			if (numeroAssentoOcupado != null ) {
				for (String assentoNum : numeroAssentoOcupadoVolta) {
					Integer numAssento = Integer.valueOf(assentoNum);
					assent.setIdVoo(idVolta);
					assent.setNumeroAssento(numAssento);
					assent.setOcupante(idOcupante);
					if (desocupa != null) {
						assent.setOcupado(false);
					} else {
						assent.setOcupado(true);
					}
					try {
						AssentoService.update(assent);
						//listaAssentosOcupados.add(assentoNum);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return "redirect:entrada?acao=ListaAssento&vooId="+ idVoo+"&voltaId="+idVolta;
		}
		//QUANDO O USUÁRIO CLICAR EM COMPRAR SERÁ REDIRECIONADO PARA TELA DE COMPRA
		/*if (comprar != null) {
			for (String string : listaAssentosOcupados) {
				System.out.println("ASSENTO" + string);
			}
			
			request.setAttribute("numeroAssentoOcupado", listaAssentosOcupados);
			return "forward:entrada?acao=FormNovaCompraVoo&compradorId="+idOcupante+"&idvoo="+id;
		} */
		
		return "redirect:entrada?acao=ListaAssento&vooId=" + assent.getIdVoo();
	}
}
