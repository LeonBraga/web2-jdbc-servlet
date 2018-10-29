package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.service.UsuarioService;



public class MostraUsuario  implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mostrando dados do usuario");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		
		//Empresa empresa = banco.buscaEmpresaPelaId(id);
		
		//System.out.println(empresa.getNome());
		
		Usuario usuario = null;
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("usuario",usuario);
		
		return "forward:formAlteraUsuario.jsp";
	}
}
