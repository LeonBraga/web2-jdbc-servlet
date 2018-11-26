package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Usuario;
import com.suam.constantes.Diretorios.Local;
import com.suam.constantes.Info.InfoCampos;
import com.suam.constantes.Parametros.ParametroTela;
import com.suam.service.UsuarioService;

public class FormNovoCartao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("idUser");
		Integer id = Integer.valueOf(paramId);

		String info = null;
		
		if (paramId == null ||paramId.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+Local.ERRO_VIEW;
		}
		
		Usuario user = null;
		try {
			user = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute(ParametroTela.OBJETO_USUARIO, user);
		
		return Local.FORM_NOVO_CARTAO;
	}

}
