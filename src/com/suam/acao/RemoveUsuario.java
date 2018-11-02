package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;

public class RemoveUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("A��O = REMOVENDO USUARIO");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Usuario usuario = null;
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// C�DIGO PARA DESVINCULAR CC DO USU�RIO.. SOMENTE SER� POSS�VEL REMO��O DE USER
		// SE SEU ID N�O FOR FK NA TABELA CC
		List<CartaoDeCredito> listaCartao = null;

		// O M�TODO DE BUSCA DEVE RETORNAR UMA LIST _ NECESSITA DE REFATORACAO
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
