package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Voo;
import com.suam.service.CompraVooService;
import com.suam.service.VooService;

public class RemoveVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = REMOVENDO VOO");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Voo voo = null;
		
		try {
			CompraVooService.deleteCompraPorVoo(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			voo = VooService.buscaVooPelaId(id);
			VooService.delete(voo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "redirect:entrada?acao=ListaVoo";
	}
}
