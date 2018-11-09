package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.service.UsuarioService;

public class AlteraCompraVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("idUser");
		String voo_idvooVolta = request.getParameter("idvooVolta");
		String assento = request.getParameter("assento");
		String valorTotalCompra = request.getParameter("valorTotalCompra");
		String voo_idvoo = request.getParameter("idvoo");
		String usuario_idusuario = request.getParameter("idusuario");
		String cartaodecredito_numerocartao = request.getParameter("numerocartao");

		request.setAttribute("idParam", paramId);
		System.out.println("FORM NOVO CARTAO 2 ==>");
		return "forward:formNovoCartao.jsp";
	}

}
