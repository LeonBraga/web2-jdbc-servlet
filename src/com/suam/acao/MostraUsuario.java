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

public class MostraUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = MOSTRANDO DADOS DO USUARIO");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Usuario usuario = null;
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// EXIBINDO APENAS UM CARTÃO DO USUÁRIO
		// CartaoDeCredito cartao = null;
		// try {
		// cartao = CartaoDeCreditoService.buscaUsuarioPelaId(usuario.getId());
		// if (cartao != null) {
		// cartao.setTitular(usuario.getNome());
		// request.setAttribute("cartao", cartao);
		// }
		// } catch (
		// SQLException e) {
		// e.printStackTrace();
		// }

		List<CartaoDeCredito> listaCartao = null;
		try {
			listaCartao = CartaoDeCreditoService.ListaCartoes();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (CartaoDeCredito cartaoDeCredito : listaCartao) {
			if (cartaoDeCredito != null) {
				try {

					if (cartaoDeCredito.getIdUser() == usuario.getId()) {
						usuario = UsuarioService.buscaUsuarioPelaId(cartaoDeCredito.getIdUser());
						cartaoDeCredito.setTitular(usuario.getNome());
					}
				} catch (SQLException e) {
					e.printStackTrace();
					listaCartao.remove(cartaoDeCredito);
				}
			}
		}

		if (!listaCartao.isEmpty()) {
			request.setAttribute("cartoes", listaCartao);
		}

		request.setAttribute("usuario", usuario);

		return "forward:formAlteraUsuario.jsp";
	}
}
