package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.constantes.Diretorios.Local;
import com.suam.constantes.Info.InfoCampos;
import com.suam.constantes.Parametros.ParametroTela;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;

public class MostraUsuario implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = MOSTRANDO DADOS DO USUARIO");

		String usuarioId = request.getParameter(ParametroTela.USUARIO_ID_USER);
		String info = null;

		if (usuarioId == null || usuarioId.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+Local.ERRO_VIEW;
		}

		Integer id = Integer.valueOf(usuarioId);
		Usuario usuario = null;
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		List<CartaoDeCredito> listaCartao = null;
		try {
			listaCartao = CartaoDeCreditoService.buscaCartoesPeloIdUsuario(usuarioId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (!listaCartao.isEmpty()) {
			request.setAttribute(ParametroTela.OBJETO_CARTAO, listaCartao);
		} else {
			info = "Usuário sem cartão cadastrado  ";
			request.setAttribute(ParametroTela.ERRO, info);
			// return "forward:"+Local.ERRO_VIEW;
		}

		request.setAttribute(ParametroTela.OBJETO_USUARIO, usuario);

		return "forward:formAlteraUsuario.jsp";
	}
}
