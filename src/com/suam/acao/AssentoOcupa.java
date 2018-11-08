package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Assento;
import com.suam.service.AssentoService;

public class AssentoOcupa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String[] numeroAssento = request.getParameter("numeroAsssento");
		String idVoo = request.getParameter("idVoo");
		String ocupa = request.getParameter("ocupa");
		String desocupa = request.getParameter("desocupa");
		String[] numeroAssento = request.getParameterValues("numeroAssento");
		Assento assent = new Assento();
		Integer id = Integer.valueOf(idVoo);
		String[] numeroAssentoOcupado = request.getParameterValues("numeroAssentoOcupado");

		if (numeroAssento != null ) {
			for (String assentoNum : numeroAssento) {
				Integer numAssento = Integer.valueOf(assentoNum);
				assent.setIdVoo(id);
				assent.setNumeroAssento(numAssento);
				if (ocupa != null) {
					assent.setOcupado(true);
				} else {
					assent.setOcupado(false);
				}
				try {
					AssentoService.update(assent);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if (numeroAssentoOcupado != null ) {

			for (String assentoNum : numeroAssentoOcupado) {
				Integer numAssento = Integer.valueOf(assentoNum);
				assent.setIdVoo(id);
				assent.setNumeroAssento(numAssento);
				if (desocupa != null) {
					assent.setOcupado(false);
				} else {
					assent.setOcupado(true);
				}
				try {
					AssentoService.update(assent);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:entrada?acao=ListaAssento&vooId=" + assent.getIdVoo();
	}
}
