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
		String info = null;

		if (paramId == null || paramId.equals("")) {
			info = "Alguma coisa não funcionou!!";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		}

		Integer id = Integer.valueOf(paramId);
		Usuario usuario = null;
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<CartaoDeCredito> listaCartao = null;
		try {
			listaCartao = CartaoDeCreditoService.buscaCartoesPeloIdUsuario(paramId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!listaCartao.isEmpty()) {
			request.setAttribute("cartoes", listaCartao);
		} else {
			info = "Usuário sem cartão cadastrado  ";
			request.setAttribute("erro", info);
			// return "forward:erro.jsp";
		}

		request.setAttribute("usuario", usuario);

		return "forward:formAlteraUsuario.jsp";
	}
}
