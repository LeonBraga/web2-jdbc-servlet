package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Voo;
import com.suam.constantes.Constantes.InfoCampos;
import com.suam.constantes.Constantes.Local;
import com.suam.constantes.Constantes.ParametroTela;
import com.suam.service.VooService;

public class AlteraVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = ALTERANDO VOO");

		String origem = request.getParameter(ParametroTela.VOO_ORIGEM);
		String destino = request.getParameter(ParametroTela.VOO_DESTINO);
		String ida = request.getParameter(ParametroTela.VOO_DATA);
		String confirmacao = request.getParameter(ParametroTela.VOO_CONFIRMACAO);
		String idVoo = request.getParameter(ParametroTela.VOO_ID_IDA);
		String valorVoo = request.getParameter(ParametroTela.VOO_VALOR);

		System.out.println("acao altera voo: " + idVoo);

		String info = null;

		if (origem == null || origem.equals("")) {
			info = InfoCampos.ORIGEM_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
		} else if (destino == null || destino.equals("")) {
			info = InfoCampos.DESTINO_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
		} else if (ida == null || ida.equals("")) {
			info = InfoCampos.IDA_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
		} else if (confirmacao == null || confirmacao.equals("")) {
			info = InfoCampos.CONFIRMACAO_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
		} else if (valorVoo == null || valorVoo.equals("")) {
			info = InfoCampos.VALOR_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
		} else if (idVoo == null || idVoo.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
		}

		Voo voo = null;
		try {
			voo = VooService.buscaVooPelaId(Integer.valueOf(idVoo));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (confirmacao != null) {
			if (confirmacao.equals("true") || confirmacao.equals("administrador") || confirmacao.equals("1")) {
				voo.setConfirmacao(true);
			} else if (confirmacao.equals("cliente") || confirmacao.equals("") || confirmacao.equals("0")) {
				voo.setConfirmacao(false);
			}
		} else {
			voo.setConfirmacao(false);
		}
		voo.setOrigem(origem);
		voo.setDestino(destino);
		voo.setValorVoo(Integer.valueOf(valorVoo));

		try {
			if (VooService.update(voo)) {
			} else {
				request.setAttribute(ParametroTela.OBJETO_VOO, voo);
				return "forward:" + Local.FORM_ALTERA_VOO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:entrada?acao=MostraVoo&id=" + idVoo;
	}
}
