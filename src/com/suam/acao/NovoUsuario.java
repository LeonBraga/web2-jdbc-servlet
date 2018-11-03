package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.service.UsuarioService;

public class NovoUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
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

		/*
		 * Date dataAbertura = null; try { SimpleDateFormat sdf = new
		 * SimpleDateFormat("dd/MM/yyyy"); dataAbertura = sdf.parse(paramDataEmpresa); }
		 * catch (ParseException e) { throw new ServletException(e); }
		 */

		Usuario usuario = new Usuario();
		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");


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
		if (ehAdm.equalsIgnoreCase("TRUE")) {
			usuario.setIsAdm(true);
		} else {
			usuario.setIsAdm(false);
		}

		UsuarioService us = new UsuarioService();
		Boolean validaInsere;
		if (senha.equals(confirmaSenha)) {
			try {
				validaInsere = us.inserir(usuario);
				if (validaInsere) {
					System.out.println("Inserido com sucesso");
				} else {
					System.out.println("CORRIGIR LOGIN!!");
					request.setAttribute("usuario", usuario);
					return "forward:formNovoUsuario.jsp";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "redirect:entrada?acao=ListaUsuario";
		} else {
			System.out.println("AS SENHAS NÃO CONFEREM");
			request.setAttribute("usuario", usuario);
			return "forward:formNovoUsuario.jsp";
		}

	}
}
