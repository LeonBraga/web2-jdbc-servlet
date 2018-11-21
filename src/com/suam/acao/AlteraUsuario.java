package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Usuario;
import com.suam.service.UsuarioService;
import com.suam.util.DataUtils;

public class AlteraUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = ALTERANDO USUARIO");

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String endereco = request.getParameter("endereco");
		String senha = request.getParameter("senha");
		String login = request.getParameter("login");
		String data = request.getParameter("data");
		String paramId = request.getParameter("id");
		String ehAdm = request.getParameter("ehAdm");
		Integer id = Integer.valueOf(paramId);
		String info = null;

		if (nome == null  ||nome.equals("")) {
			info = "Nome não prennchido";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		} else if (sobrenome == null  ||sobrenome.equals("")) {
			info = "Sobrenome não prennchido";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		} else if (endereco == null ||endereco.equals("")) {
			info = "Endereço não informado!";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		} else if (senha == null  ||senha.equals("")) {
			info = "Senha não informada!";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		} else if (login == null ||login.equals("")) {
			info = "Login não informado!";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		} else if (data == null ||data.equals("")) {
			info = "Data não informada!";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		} else if (id == null ||id.equals("")) {
			info = "Alguma coisa não funcionou!!";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		}

		Usuario usuario = null;
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setEndereco(endereco);
		usuario.setSenha(senha);
		usuario.setLogin(login);
		try {
			usuario.setDataNascimento(DataUtils.formatarData().parse(data));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (ehAdm != null) {
			System.out.println("NOVO USUARIO, LOGIN: " + usuario.getLogin() + " É ADM: " + ehAdm);
			if (ehAdm.equals("true") || ehAdm.equals("administrador") || ehAdm.equals("1")) {
				usuario.setIsAdm(true);
			} else if (ehAdm.equals("cliente") || ehAdm.equals("") || ehAdm.equals("0")) {
				usuario.setIsAdm(false);
			}
		} else {
			usuario.setIsAdm(false);
		}

		Boolean validaInsere;
		try {
			validaInsere = UsuarioService.update(usuario);
			if (validaInsere) {

			} else {
				info = "ERRO,  Alguma coisa não funcionou como deveria!";
				request.setAttribute("usuario", usuario);
				request.setAttribute("erro", info);
				return "forward:formAlteraUsuario.jsp";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "redirect:entrada?acao=MostraUsuario&id=" + usuario.getId();
	}
}
