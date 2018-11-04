package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;
import com.suam.service.VooService;

public class RemoveVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = REMOVENDO VOO");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Voo voo = null;
		try {
			voo = VooService.buscaVooPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		// CÓDIGO PARA DESVINCULAR CC DO USUÁRIO.. SOMENTE SERÁ POSSÍVEL REMOÇÃO DE USER
		// SE SEU ID NÃO FOR FK NA TABELA CC
		List<CartaoDeCredito> listaCartao = null;
		// O MÉTODO DE BUSCA DEVE RETORNAR UMA LIST _ NECESSITA DE REFATORACAO
		Usuario usuario  =null;
		try {
			listaCartao = CartaoDeCreditoService.buscaCartoesPeloId(usuario.getId().toString());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		for (CartaoDeCredito cartao : listaCartao) {
			try {
				CartaoDeCreditoService.delete(cartao);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			UsuarioService.delete(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// request.setAttribute("usuario",usuario);
		return "redirect:entrada?acao=ListaUsuario";
	}
}
