package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Voo;
import com.suam.service.VooService;

public class AlteraVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = ALTERANDO VOO");

		String origem = request.getParameter("origem");
		String destino = request.getParameter("destino");
		String ida = request.getParameter("ida");
		String confirmacao = request.getParameter("confirmacao");
		String idVoo = request.getParameter("idVooIda");
		String valorVoo = request.getParameter("valorVoo");

		// Integer idVooIda = Integer.valueOf(paramId);

		System.out.println("acao altera voo: " + idVoo);

		Voo voo = null;
		try {
			voo = VooService.buscaVooPelaId(Integer.valueOf(idVoo));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = null;
		try {
			date = formato.parse(ida);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqlIda = new java.sql.Date(date.getTime());

		if (confirmacao != null) {
			if (confirmacao.equals("true") || confirmacao.equals("administrador") || confirmacao.equals("1")) {
				voo.setConfirmacao(true);
			} else if (confirmacao.equals("cliente") || confirmacao.equals("") || confirmacao.equals("0")) {
				voo.setConfirmacao(false);
			}
		} else {
			voo.setConfirmacao(false);
		}
		voo.setOrigem(origem);
		voo.setDestino(destino);
		voo.setValorVoo(Integer.valueOf(valorVoo));

		Boolean validaInsere;

		try {
			validaInsere = VooService.update(voo);
			if (validaInsere) {
			} else {
				request.setAttribute("voo", voo);
				return "forward:formAlteraVoo.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:entrada?acao=MostraVoo&id=" + idVoo;
	}
}
