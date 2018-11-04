package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;



public class RemoveCartao  implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AÇÃO = REMOVENDO CARTÃO");
		
		String numero = request.getParameter("numero");
		//String paramId = request.getParameter("id");
		//Integer id = Integer.valueOf(paramId);
		
		CartaoDeCredito cartao = null;
		try {
			cartao = CartaoDeCreditoService.buscaCartaoPeloNumero(numero);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			CartaoDeCreditoService.delete(cartao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//request.setAttribute("usuario",usuario);
		return "redirect:entrada?acao=MostraUsuario&id="+cartao.getIdUser();
	}
}
