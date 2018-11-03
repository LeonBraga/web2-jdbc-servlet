package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;
import com.suam.service.VooService;

public class NovoVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = ALTERANDO VOO");

		String origem = request.getParameter("origem");
		String destino = request.getParameter("destino");
		String ida = request.getParameter("ida");
		String volta = request.getParameter("volta");
		String confirmacao = request.getParameter("confirmacao");
		String assento = request.getParameter("assento");

		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");

		Voo voo = new Voo();

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
		voo.setAssento(assento);
		voo.setOrigem(origem);
		voo.setDestino(destino);

		Boolean validaInsere;
		VooService vs = new VooService();
		
		try {
			validaInsere = vs.inserir(voo);
			if (validaInsere) {
				System.out.println("Inserido com sucesso");
			} else {
				request.setAttribute("voo", voo);
				return "forward:formNovoVoo.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("voo", voo);
		return "forward:formNovoVoo.jsp";

	}
}
