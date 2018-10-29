package com.suam.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.servlet.bean.Usuario;
import com.suam.servlet.service.UsuarioService;

@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Controle() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		try {

			if (acao.equals("1")) {
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");

				boolean autenticou = UsuarioService.autenticar(login, senha);

				if (autenticou) {
					RequestDispatcher r = request.getRequestDispatcher("usuario-autenticado.html");
					r.forward(request, response);
				}

				else {
					RequestDispatcher r = request.getRequestDispatcher("usuario-nao-autenticado.html");
					r.forward(request, response);
				}

			}

			if (acao.equals("2")) {
				Usuario usuario = new Usuario();
				String login = request.getParameter("login");
				String senha = request.getParameter("senha");
				usuario.setLogin(login);
				usuario.setSenha(senha);
				UsuarioService.inserir(usuario);
				RequestDispatcher r = request.getRequestDispatcher("usuario-inserido.html");
				r.forward(request, response);

			}

		} catch (Exception e) {
			RequestDispatcher r = request.getRequestDispatcher("erro.html");
			r.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
