package com.suam.acao;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Voo;
import com.suam.service.AssentoService;
import com.suam.service.VooService;

public class NovoVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = ALTERANDO VOO");

		String origem = request.getParameter("origem");
		String destino = request.getParameter("destino");
		String ida = request.getParameter("ida");
		String confirmacao = request.getParameter("confirmacao");
		String valorVoo = request.getParameter("valorVoo");

		Voo voo = new Voo();
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");	
		java.util.Date date =null;
		try {
			date = formato.parse(ida);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqlIda = new java.sql.Date(date.getTime());
		
		
		voo.setIda(sqlIda);

		if (confirmacao != null) {
			voo.setConfirmacao(true);
		} else {
			voo.setConfirmacao(false);
		}
		voo.setOrigem(origem);
		voo.setDestino(destino);
		voo.setValorVoo(Integer.valueOf(valorVoo));

		Boolean validaInsere;
		try {
			validaInsere = VooService.inserir(voo);
			if (validaInsere) {
				System.out.println("Inserido com sucesso");
			} else {
				request.setAttribute("voo", voo);
				return "forward:NovoVoo.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			AssentoService.inserirAssentosPorVoo();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// request.setAttribute("voo", voo);
		return "redirect:entrada?acao=ListaVoo";
	}
}
