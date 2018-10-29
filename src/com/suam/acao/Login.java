package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.servlet.service.UsuarioService;



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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*
		if (autenticou) {
			RequestDispatcher r = request.getRequestDispatcher("usuario-autenticado.html");
			r.forward(request, response);
		}*/
		

		
		if (autenticou){
			//HttpSession sessao = request.getSession();
			//sessao.setAttribute("usuarioLogado", usuario.getNome());
			return "redirect:entrada?acao=ListaUsuario";
			//return "redirect:usuario-autenticado.html";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}

	}

}
