package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Voo;
import com.suam.constantes.Constantes.InfoCampos;
import com.suam.constantes.Constantes.NomeAcao;
import com.suam.constantes.Constantes.NomeView;
import com.suam.constantes.Constantes.ParametroTela;
import com.suam.service.AssentoService;
import com.suam.service.VooService;

public class NovoVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = ALTERANDO VOO");

		
		String origem = request.getParameter(ParametroTela.VOO_ORIGEM);
		String destino = request.getParameter(ParametroTela.VOO_DESTINO);
		String ida = request.getParameter(ParametroTela.VOO_DATA);
		String confirmacao = request.getParameter(ParametroTela.VOO_CONFIRMACAO);
		String valorVoo = request.getParameter(ParametroTela.VOO_VALOR);
		
		String info = null;

		if (origem == null ||origem.equals("")) {
			info = InfoCampos.ORIGEM_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} else if (destino == null ||destino.equals("")) {
			info = InfoCampos.DESTINO_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} else if (ida == null ||ida.equals("")) {
			info = InfoCampos.IDA_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} else if (confirmacao == null ||confirmacao.equals("")){
			info = InfoCampos.CONFIRMACAO_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} else if (valorVoo == null ||valorVoo.equals("")) {
			info = InfoCampos.VALOR_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+NomeView.ERRO_VIEW;
		} 
		
		Voo voo = new Voo();

		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = null;
		try {
			date = formato.parse(ida);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		java.sql.Date sqlIda = new java.sql.Date(date.getTime());

		voo.setIda(sqlIda);

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

		Boolean validaInsere;
		try {
			validaInsere = VooService.inserir(voo);
			if (validaInsere) {
				System.out.println("Inserido com sucesso");
			} else {
				request.setAttribute(ParametroTela.OBJETO_VOO, voo);
				return "forward:"+NomeView.NOVO_VOO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			AssentoService.inserirAssentosPorVoo();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// request.setAttribute("voo", voo);
		return "redirect:entrada?acao="+NomeAcao.LISTA_VOO;
	}
}
