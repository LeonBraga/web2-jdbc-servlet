package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.constantes.Parametros.ParametroTela;
import com.suam.service.UsuarioService;

public class ListaUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = LISTANDO USUÁRIOS");

		List<Usuario> listaUsuario = null;
		try {
			listaUsuario = UsuarioService.ListaUsuarios();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute(ParametroTela.OBJETO_LISTA_USUARIO, listaUsuario);
		return "forward:listaUsuario.jsp";
	}

}
