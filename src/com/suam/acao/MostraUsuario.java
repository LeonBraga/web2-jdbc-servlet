package com.suam.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.service.UsuarioService;



public class MostraUsuario  implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mostrando dados da empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		
		//Empresa empresa = banco.buscaEmpresaPelaId(id);
		
		//System.out.println(empresa.getNome());
		
		UsuarioService usuario = usuario.buscaEmpresaPelaId(id);

		request.setAttribute("usuario",usuario);
		
		return "forward:formAlteraEmpresa.jsp";
	}
}
