package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Voo;
import com.suam.service.VooService;

public class MostraVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = MOSTRANDO VOO");

		String idVoo = request.getParameter("id");
	
		Integer id = Integer.valueOf(idVoo);
		Voo voo = null;
		try {
			voo = VooService.buscaVooPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("voo", voo);

		return "forward:formAlteraVoo.jsp";
	}
}
