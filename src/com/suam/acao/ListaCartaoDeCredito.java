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

public class ListaCartaoDeCredito implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("AÇÃO = LISTANDO CARTAO DE CREDITO");
		
		List<CartaoDeCredito> listaCartao = null;
		try {
		 listaCartao =  CartaoDeCreditoService.ListaCartoes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Usuario usuario = null;
		for (CartaoDeCredito cartaoDeCredito : listaCartao) {
			try {
				usuario = UsuarioService.buscaUsuarioPelaId(cartaoDeCredito.getIdUser());
				cartaoDeCredito.setTitular(usuario.getNome());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("cartoes", listaCartao);
		return "forward:listaCartoes.jsp";
	}

}
