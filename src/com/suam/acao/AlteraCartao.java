package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.constantes.Constantes.InfoCampos;
import com.suam.constantes.Constantes.NomeAcao;
import com.suam.constantes.Constantes.NomeView;
import com.suam.constantes.Constantes.ParametroTela;
import com.suam.service.CartaoDeCreditoService;
import com.suam.util.DataUtils;

public class AlteraCartao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = ALTERANDO CARTAO");

		String nome = request.getParameter(ParametroTela.USUARIO_NOME);
		String numero = request.getParameter(ParametroTela.CARTAO_NUMERO);
		String data = request.getParameter(ParametroTela.CARTAO_DATA_VENCIMENTO_CARTAO);
		String idUser = request.getParameter(ParametroTela.USUARIO_ID_USER);
		String info = null;
		CartaoDeCredito cartao = new CartaoDeCredito();

		if (nome == null || nome.equals("") || nome.length() < 2) {
			info = InfoCampos.NOME_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + NomeView.ERRO_VIEW;
		} else if (numero == null || numero.equals("") || numero.length() < 15 || numero.length() > 15) {
			info = InfoCampos.NUMERO_CARTAO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + NomeView.ERRO_VIEW;
		} else if (data == null || data.equals("") ||data.length()< 10) { //MELHORAR
			info = InfoCampos.DATA_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + NomeView.ERRO_VIEW;
		} else if (idUser == null || idUser.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + NomeView.ERRO_VIEW;
		}

		cartao.setTitular(nome);

		try {
			cartao.setDataVencimento(DataUtils.formatarData().parse(data));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		cartao.setNumeroCartao(numero);
		cartao.setIdUser(Integer.parseInt(idUser));

		try {
			if (CartaoDeCreditoService.update(cartao)) {
				info = InfoCampos.SUCESSO;
				request.setAttribute(ParametroTela.ERRO, info);
				return "forward:" + NomeView.ERRO_VIEW;
			} else {
				request.setAttribute(ParametroTela.OBJETO_CARTAO, cartao);
				return "forward:"+NomeView.FORM_NOVO_CARTAO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:entrada?acao="+NomeAcao.MOSTRA_USUARIO+"&"+ParametroTela.USUARIO_ID_USER +"=" + idUser;
	}
}
