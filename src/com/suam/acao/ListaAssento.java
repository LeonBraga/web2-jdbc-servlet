package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Assento;
import com.suam.service.AssentoService;

public class ListaAssento implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("AÇÃO = LISTANDO VOOS");
		String vooIdParam = request.getParameter("vooId");
		Integer vooId =Integer.valueOf(vooIdParam);
		
		List<Assento> listaAssentos = null;
		try {
			listaAssentos = AssentoService.ListaAssentos(vooId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("voos", listaAssentos);
		return "forward:listaAssentos.jsp";
	}

}
