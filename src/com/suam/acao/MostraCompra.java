package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Assento;
import com.suam.bean.Voo;
import com.suam.service.AssentoService;
import com.suam.service.VooService;

public class MostraCompra implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = MOSTRANDO COMPRA");

		String[] idVoo = request.getParameterValues("idVoo");
		String idUsuario = request.getParameter("idUsuario");
		String valorTotal =  request.getParameter("valorTotal");
		String numeroCartao =  request.getParameter("numeroCartao");

		Integer vooId = Integer.valueOf(idVoo[0]);
		Integer userId = Integer.valueOf(idUsuario);
		List<Assento> listaAssentoPagamentoConfirmado = new ArrayList<Assento>();

		try {
			listaAssentoPagamentoConfirmado = AssentoService.listarAssentosPagosPorUsuarioIdVooId(userId, vooId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("listaAssentoPagamentoConfirmado", listaAssentoPagamentoConfirmado);
		request.setAttribute("numeroCartao", numeroCartao);
		request.setAttribute("valorTotal", valorTotal);
		return "forward:mostraCompra.jsp";
	}
}
