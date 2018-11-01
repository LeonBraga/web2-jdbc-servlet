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

		System.out.println("=======================>>1");
		for (CartaoDeCredito cartaoDeCredito : listaCartao) {
			System.out.println("=======================>>2");

			if (cartaoDeCredito != null) {
				System.out.println("=======================>>3");
				try {
					System.out.println("=======================>>4");
					if (cartaoDeCredito.getIdUser() == usuario.getId()||cartaoDeCredito.getIdUser()!=null) {
						System.out.println("=======================>>5");
						System.out.println("cartaoDeCredito.getIdUser() ::" + cartaoDeCredito.getIdUser());
						usuario = UsuarioService.buscaUsuarioPelaId(cartaoDeCredito.getIdUser());
						System.out.println("=======================>>6");
						cartaoDeCredito.setTitular(usuario.getNome());
					} else {
						listaCartao.remove(cartaoDeCredito);
					}
				} catch (SQLException e) {
					e.printStackTrace();
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
