package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

/*
 * Nossa abordagem é funcional, mas vários controladores do mercado 
 * usam uma outra abordagem para definir o nome da ação. 
 * A ideia é que nosso controlador receba qualquer requisição para 
 * qualquer URL, através do mapeamento /:
 * 
 * @WebServlet("/")
 * */

//ATENÇÃO  ==>>ATRIBUIÇÕES DESTA SERVLET REPASSADAS AO ControladorFilter.Java

//@WebServlet("/entrada") 
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");

		// Verificação de segurança atribuida aos Filter's
		// HttpSession sessao = request.getSession();
		// boolean usuarioNaoEstalogado = (sessao.getAttribute("usuarioLogado")==null);
		// boolean ehUmaAcaoProtegida =
		// !(paramAcao.equals("Login")||paramAcao.equals("LoginForm"));
		//
		// if(usuarioNaoEstalogado && ehUmaAcaoProtegida) {
		// response.sendRedirect("entrada?acao=LoginForm");
		// return;
		// }

		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;

		/*
		 * O método getRequestURI(), do objeto HttpServletRequest, devolve exatamente
		 * essa informação:
		 */
		String url = request.getRequestURI();
		System.out.println("URL: " + url);

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);// carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = nome.split(":");
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
	}
}
