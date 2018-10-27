package br.com.unisuam.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.unisuam.gerenciador.modelo.Banco;
import br.com.unisuam.gerenciador.modelo.Usuario;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		//sessao.removeAttribute("usuarioLogado");
		//Outra forma de fazer, invalidando toda a sessao http:
		sessao.invalidate();
		
		return "redirect:entrada?acao=LoginForm";
	}
}
