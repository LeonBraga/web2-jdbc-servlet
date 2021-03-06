package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Voo;
import com.suam.constantes.Constantes.InfoCampos;
import com.suam.constantes.Constantes.NomeView;
import com.suam.constantes.Constantes.ParametroTela;
import com.suam.service.VooService;

public class MostraVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("A��O = MOSTRANDO VOO");

		String idVoo = request.getParameter(ParametroTela.VOO_ID);
		String info = null;

		if (idVoo == null || idVoo.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + NomeView.ERRO_VIEW;
		}

		Integer id = Integer.valueOf(idVoo);
		Voo voo = null;
		try {
			voo = VooService.buscaVooPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute(ParametroTela.OBJETO_VOO, voo);

		return "forward:" + NomeView.FORM_ALTERA_VOO;
	}
}
