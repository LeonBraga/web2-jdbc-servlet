package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.servlet.bean.Usuario;
import com.suam.servlet.service.UsuarioService;



public class ListaUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		System.out.println("listando empresas");
		
	
		UsuarioService usuario = new UsuarioService();
		
		List<Usuario> listaUsuario = null;
		try {
			listaUsuario = usuario.ListaUsuario();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("usuarios", listaUsuario);

		// AULA 02 ==> Esse tipo de tarefa deve ser executada no servlet
		// despachando a requisição e seus parâmetros para outra servlet
		// RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		// 'passando para frente'
		// rd.forward(request, response);

		// O "forward:" serve para fazer um foward para o jsp
		// return "/listaEmpresas.jsp";
		return "forward:listaUsuarios.jsp";
	}

}
