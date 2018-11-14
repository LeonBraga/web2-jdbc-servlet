package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Assento;
import com.suam.bean.Voo;
import com.suam.service.AssentoService;
import com.suam.service.VooService;

public class ListaAssento implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = LISTANDO Assentos");
		String vooIdParam = request.getParameter("vooId");
		Integer vooId = Integer.valueOf(vooIdParam);
		String vooVolta = request.getParameter("voltaId");
		Integer vooIdVolta = null;
		if (vooVolta != null) {
			vooIdVolta = Integer.valueOf(vooVolta);
		}

		List<Assento> listaAssentos = null;
		List<Assento> listaAssentosDesocupados = null;

		try {
			listaAssentos = AssentoService.ListaAssentos(vooId);
			listaAssentosDesocupados = AssentoService.ListaAssentosDesocupados(vooId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		boolean vVolta = false;
		if (vooVolta != null) {
			List<Assento> listaAssentosVolta = null;
			List<Assento> listaAssentosDesocupadosVolta = null;
			// List<AssentoComprados>listaDeAssentosPagos = null;
			try {
				listaAssentosVolta = AssentoService.ListaAssentos(vooIdVolta);
				listaAssentosDesocupadosVolta = AssentoService.ListaAssentosDesocupados(vooIdVolta);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			vVolta = true;
			request.setAttribute("volta", vVolta);
			// voo ida
			request.setAttribute("vooId", vooId);
			request.setAttribute("assentosDesocupados", listaAssentosDesocupados);
			request.setAttribute("assentos", listaAssentos);

			// voo volta
			request.setAttribute("vooIdVolta", vooIdVolta);
			request.setAttribute("assentosDesocupadosVolta", listaAssentosDesocupadosVolta);
			request.setAttribute("assentosVolta", listaAssentosVolta);

			return "forward:listaAssentos.jsp";
		} else {

			vVolta = false;
			request.setAttribute("volta", vVolta);
			request.setAttribute("vooId", vooId);
			request.setAttribute("assentosDesocupados", listaAssentosDesocupados);
			request.setAttribute("assentos", listaAssentos);
			return "forward:listaAssentos.jsp";
		}
	}
}
