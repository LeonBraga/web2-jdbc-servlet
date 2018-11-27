package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Assento;
import com.suam.constantes.Constantes.NomeView;
import com.suam.constantes.Constantes.ParametroTela;
import com.suam.service.AssentoService;
import com.suam.service.VooService;

public class ListaAssento implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = LISTANDO Assentos");
		String vooIdParam = request.getParameter("vooId");
		Integer vooId = null;
		String vooVolta = request.getParameter("voltaId");
		Integer vooIdVolta = null;
		String erro = null;

		if (!(vooIdParam == null || vooIdParam == "" || vooIdParam == "null")) {
			if (vooIdParam != null && vooIdParam != "" && vooIdParam != "null") {
				vooId = Integer.valueOf(vooIdParam);
			}
			if (vooVolta != null && vooVolta != "" && vooVolta != "null") {
				vooIdVolta = Integer.valueOf(vooVolta);
			}

			List<Assento> listaAssentos = null;
			List<Assento> listaAssentosDesocupados = null;

			try {
				if (!VooService.buscaVooPelaId(vooId).getConfirmacao()) {
					System.out.println("============" + VooService.buscaVooPelaId(vooId).getConfirmacao());
					erro = "Você selecionaou um voo ainda não confirmado!";
					request.setAttribute(ParametroTela.ERRO, erro);
					return "forward:"+NomeView.ERRO_VIEW;
				}
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
					if (!VooService.buscaVooPelaId(vooIdVolta).getConfirmacao()) {
						System.out.println("============" + VooService.buscaVooPelaId(vooId).getConfirmacao());
						erro = "Você selecionaou um voo ainda não confirmado!";
						request.setAttribute("erro", erro);
						return "forward:erro.jsp";
					}
					if (VooService.buscaVooPelaId(vooId).getIdVoo()
							.equals(VooService.buscaVooPelaId(vooIdVolta).getIdVoo())) {
						System.out.println("VOO IGUAL SELECIONADO");
						erro = "Você selecionaou o mesmo voo para ida e para a volta!";
						request.setAttribute("erro", erro);
						return "forward:erro.jsp";
					}
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
		} else {

			if (vooVolta != null) {
				erro = "Selecione primero o voo de ida! <a href=\"entrada?acao=ListaVoo\"><button>Voltar a Tela de Voos</button></a>";
				request.setAttribute("erro", erro);
				return "forward:erro.jsp";
			}

			erro = "Selecione o Voo que deseja utililizar!<a href=\"entrada?acao=ListaVoo\"><button>Voltar a Tela de Voos</button></a>";
			request.setAttribute("erro", erro);
			return "forward:erro.jsp";
		}
	}
}
