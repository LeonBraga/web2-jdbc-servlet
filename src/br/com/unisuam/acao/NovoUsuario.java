package br.com.unisuam.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisuam.modelo.Usuario;
import br.com.unisuam.service.Banco;


public class NovoUsuario  implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Cadastrando nova usuario");
		
		String nomeUsuario = request.getParameter("nome");
		String paramDataUsuario = request.getParameter("data");
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataUsuario);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(nomeUsuario);
		
		
		Banco banco = new Banco();
		banco.adiciona(usuario);
		
		request.setAttribute("usuario", usuario.getNome());
		
		return "redirect:entrada?acao=ListaUsuario";
	
	}
}
