package com.suam.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.service.UsuarioService;

@WebServlet("/formEntradaCadastro")
public class FormEntradaCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cadastroNovo = request.getParameter("cadastrarNovo");

		if (cadastroNovo != null) {
			System.out.println("CADASTRAR USÁRIO ==> CLIENTE NOVO");
			request.getRequestDispatcher("WEB-INF/view/formNovoUsuarioClienteNaoCadastrado.jsp").forward(request,
					response);
		} else {
			System.out.println("NÃO FOI POSSÍVEL CADASTRAR USÁRIO ==> CLIENTE NOVO");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = INSERINDO USUARIO");

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String endereco = request.getParameter("endereco");
		String senha = request.getParameter("senha");
		String confirmaSenha = request.getParameter("confirmaSenha");
		String login = request.getParameter("login");
		String data = request.getParameter("data");
		String ehAdm = request.getParameter("ehAdm");

		Usuario usuario = new Usuario();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setEndereco(endereco);
		usuario.setSenha(senha);
		usuario.setLogin(login);
		try {
			usuario.setDataNascimento(formato.parse(data));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (ehAdm != null) {
			// if (ehAdm.equalsIgnoreCase("TRUE")) {
			usuario.setIsAdm(true);
			// }
		} else {
			usuario.setIsAdm(false);
		}

		Boolean validaInsere;
		if (senha.equals(confirmaSenha)) {
			try {
				validaInsere = UsuarioService.inserir(usuario);
				if (validaInsere) {
					System.out.println("Inserido com sucesso");
				} else {
					System.out.println("CORRIGIR LOGIN!!");
					// request.setAttribute("usuario", usuario);
					System.out.println("ERRO NO LOGIN =====>>>>>");

				}
				request.getRequestDispatcher("formLogin.jsp").forward(request,
						response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("AS SENHAS NÃO CONFEREM");
			// request.setAttribute("usuario", usuario);
		}

	}
}