package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.constantes.Constantes.InfoCampos;
import com.suam.constantes.Constantes.NomeView;
import com.suam.constantes.Constantes.ParametroTela;
import com.suam.service.UsuarioService;

public class NovoUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = INSERINDO USUARIO");

		String nome = request.getParameter(ParametroTela.USUARIO_NOME);
		String sobrenome = request.getParameter(ParametroTela.USUARIO_SOBRENOME);
		String endereco = request.getParameter(ParametroTela.USUARIO_ENDERECO);
		String senha = request.getParameter(ParametroTela.USUARIO_SENHA);
		String login = request.getParameter(ParametroTela.USUARIO_LOGIN);
		String data = request.getParameter(ParametroTela.USUARIO_DATA);
		String ehAdm = request.getParameter(ParametroTela.USUARIO_EH_ADM);
		String confirmaSenha = request.getParameter(ParametroTela.USUARIO_CONFIRMA_SENHA);
		
		String info = null;

		if (nome == null  ||nome.equals("")) {
			info = InfoCampos.NOME_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} else if (sobrenome == null  ||sobrenome.equals("")) {
			info = InfoCampos.SOBRENOME_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} else if (endereco == null ||endereco.equals("")) {
			info = InfoCampos.ENDERECO_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} else if (senha == null  ||senha.equals("")) {
			info = InfoCampos.SENHA_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} else if (login == null ||login.equals("")) {
			info = InfoCampos.LOGIN_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} else if (data == null ||data.equals("")) {
			info = InfoCampos.DATA_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} 

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
			System.out.println("NOVO USUARIO E ADM: " + ehAdm);
			if (ehAdm.equals("true") || ehAdm.equals("administrador") || ehAdm.equals("1")) {
				usuario.setIsAdm(true);
			} else if (ehAdm.equals("cliente") || ehAdm.equals("") || ehAdm.equals("0")) {
				usuario.setIsAdm(false);
			}
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
					info = "Login não informado!";
					request.setAttribute(ParametroTela.ERRO, info);
					request.setAttribute(ParametroTela.OBJETO_USUARIO, usuario);
					return "forward:formNovoUsuario.jsp";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "redirect:entrada?acao=ListaUsuario";
		} else {
			System.out.println("AS SENHAS NÃO CONFEREM");
			request.setAttribute(ParametroTela.OBJETO_USUARIO, usuario);
			return "forward:formNovoUsuario.jsp";
		}

	}
}
