package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.service.AssentoService;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.CompraVooService;
import com.suam.service.UsuarioService;

public class RemoveUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = REMOVENDO USUARIO");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Usuario usuario = null;
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			CartaoDeCreditoService.deleteCartoes(usuario);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		try {
			AssentoService.desocuparAssentoPorUsuarioId(usuario.getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			CompraVooService.deleteCompraPorUsuario(usuario.getId());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
