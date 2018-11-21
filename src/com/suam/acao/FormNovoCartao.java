package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.service.UsuarioService;

public class FormNovoCartao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("idUser");
		Integer id = Integer.valueOf(paramId);

		String info = null;
		
		if (paramId == null ||paramId.equals("")) {
			info = "Alguma coisa não funcionou!!";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		}
		
		Usuario user = null;
		System.out.println("FORM NOVO CARTAO 1 ==>");
		try {
			user = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("usuario", user);
		return "forward:formNovoCartao.jsp";
	}

}
