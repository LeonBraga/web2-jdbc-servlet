package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.constantes.Constantes.InfoCampos;
import com.suam.constantes.Constantes.NomeView;
import com.suam.constantes.Constantes.ParametroTela;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;
import com.suam.util.ConverteValores;

public class MostraCartao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = MOSTRANDO DADOS DO CARTAO");

		String paramId = request.getParameter("id");
		Integer id = ConverteValores.StringParaInteger( paramId);

		String info = null;
		if (id == null || id.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		}

		Usuario usuario = null;
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		CartaoDeCredito cartao = null;
		try {
			cartao = CartaoDeCreditoService.buscaCartaoPelaId(usuario.getId());
			cartao.setTitular(usuario.getNome());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		cartao.setTitular(usuario.getNome() + " " + usuario.getSobrenome());

		request.setAttribute(ParametroTela.OBJETO_CARTAO, cartao);

		return "forward:"+NomeView.FORM_ALTERA_CARTAO;
	}
}
