package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.suam.bean.Usuario;
import com.suam.service.UsuarioService;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("Logando " + login);

		boolean autenticou = false;
		try {
			autenticou = UsuarioService.autenticar(login, senha);
			System.out.println("OK");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("NOK");
		}
		/*
		 * if (autenticou) { RequestDispatcher r =
		 * request.getRequestDispatcher("usuario-autenticado.html"); r.forward(request,
		 * response); }
		 */
		List<Usuario> listaUsuario = null;
		try {
		 listaUsuario = UsuarioService.consultar(login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Usuario user = new Usuario();
		for (Usuario usuario : listaUsuario) {
			System.out.println("USUARIO LISTA: "+usuario.getLogin());
			user = usuario;
		}
		
		if (autenticou) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", user);
			System.out.println("AUTENTICOU EM LOGIN");
			return "redirect:entrada?acao=ListaUsuario";
			// return "redirect:usuario-autenticado.html";
		} else {
			// return "redirect:entrada?acao=ListaUsuario";
			return "redirect:entrada?acao=LoginForm";
		}

	}

}
