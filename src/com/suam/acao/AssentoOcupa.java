package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Assento;
import com.suam.service.AssentoService;
import com.suam.service.UsuarioService;

public class AssentoOcupa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	//	String[] numeroAssento = request.getParameter("numeroAsssento");
		String idVoo = request.getParameter("idVooIda");
		String ocupa = request.getParameter("ocupa");
		String numeroAssento = request.getParameter("numeroAsssento");
		
		System.out.println("AÇÃO = OCUPANDO ASSENTO "+ numeroAssento);

		Assento assento = null;
		System.out.println("================>>>>"+idVoo);
		assento.setIdVoo(Integer.valueOf(idVoo));
		assento.setNumeroAssento(Integer.valueOf(numeroAssento));
		if (ocupa != null) {
			assento.setOcupado(true);
		} else {
			assento.setOcupado(false);
		}

		try {
			AssentoService.update(assento);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "redirect:entrada?acao=ListaAssento&vooId=" + assento.getIdVoo();
	}
}
