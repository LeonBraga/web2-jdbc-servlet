package br.com.unisuam.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.unisuam.modelo.Usuario;
import br.om.suam.service.Banco;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		System.out.println("Logando " + login);

		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(login, senha);

		// Sem o hhtp session
		// if(usuario != null) {
		// System.out.println("Usuario existe");
		// return "redirect:entrada?acao=ListaEmpresas";
		// } else {
		// return "redirect:entrada?acao=LoginForm";
		// }
		
		// Com o hhtp session
		if (usuario != null){
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=LoginForm";
		}

	}

}
