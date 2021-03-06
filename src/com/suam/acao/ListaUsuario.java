package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.constantes.Constantes.NomeView;
import com.suam.constantes.Constantes.ParametroTela;
import com.suam.service.UsuarioService;

public class ListaUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("A��O = LISTANDO USU�RIOS");

		List<Usuario> listaUsuario = null;
		try {
			listaUsuario = UsuarioService.ListaUsuarios();//MELHORAR - IMPLEMENTAR A ENTREGA DE PARCIAIS
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute(ParametroTela.OBJETO_LISTA_USUARIO, listaUsuario);
		return "forward:"+NomeView.LISTA_USUARIO;
	}

}
