package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String volta = request.getParameter("volta");
		String confirmacao = request.getParameter("confirmacao");
		String idVoo = request.getParameter("idVoo");
		//Integer idVoo = Integer.valueOf(paramId);

		System.out.println("acao altera voo: " + idVoo);

		Voo voo = null;
		try {
			voo = VooService.buscaVooPelaId(Integer.parseInt(idVoo));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");

		try {
			voo.setIda(formato.parse(ida));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			voo.setVolta(formato.parse(volta));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (confirmacao.equalsIgnoreCase("TRUE")) {
			voo.setConfirmacao(true);
		} else {
			voo.setConfirmacao(false);
		}
		voo.setOrigem(origem);
		voo.setDestino(destino);

		VooService vooS = new VooService();
		Boolean validaInsere;

		try {
			validaInsere = vooS.update(voo);
			if (validaInsere) {
				System.out.println("ATUALIZADO com sucesso");
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
