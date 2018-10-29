package br.com.unisuam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.unisuam.modelo.Usuario;
import br.com.unisuam.service.Banco;
import br.com.unisuam.service.UsuarioService;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("Logando " + login);

		UsuarioService us = new UsuarioService();
		Boolean usuario = false;
	
			try {
				usuario = UsuarioService.autenticar(login, senha);
			} catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		

		
		if (usuario){
			//HttpSession sessao = request.getSession();
			//sessao.setAttribute("usuarioLogado", usuario.getNome());
			return "redirect:entrada?acao=ListaUsuario";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}

	}

}