package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.service.UsuarioService;

public class FormNovoCompraVoo implements Acao {

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
		request.setAttribute("idvooVolta",voo_idvooVolta);
		request.setAttribute("assento", assento);
		request.setAttribute("valorTotalCompra", valorTotalCompra);
		request.setAttribute("idvoo", voo_idvoo);
		request.setAttribute("idusuario", usuario_idusuario);
		request.setAttribute("numerocartao", cartaodecredito_numerocartao);
		
		
		System.out.println("FORM NOVO COMPRA");
		return "forward:formNovoCompraVoo.jsp";
	}

}
