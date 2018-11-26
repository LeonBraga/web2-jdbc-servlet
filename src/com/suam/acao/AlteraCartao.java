package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.CartaoDeCredito;
import com.suam.constantes.Diretorios;
import com.suam.constantes.Diretorios.Local;
import com.suam.constantes.Info.InfoCampos;
import com.suam.constantes.Parametros.ParametroTela;
import com.suam.service.CartaoDeCreditoService;
import com.suam.util.DataUtils;

public class AlteraCartao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = ALTERANDO CARTAO");

		String nome = request.getParameter(ParametroTela.USUARIO_NOME);
		String numero = request.getParameter(ParametroTela.CARTAO_NUMERO);
		String data = request.getParameter(ParametroTela.CARTAO_DATA_VENCIMENTO_CARTAO);
		String idUser = request.getParameter("idUser");
		String info = null;
		CartaoDeCredito cartao = new CartaoDeCredito();

		if (nome == null || nome.equals("")) {
			info = InfoCampos.NOME_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
		} else if (numero == null || numero.equals("") || numero.length() < 15 || numero.length() > 15) {
			info = InfoCampos.NUMERO_CARTAO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
		} else if (data == null || data.equals("")) {
			info = InfoCampos.DATA_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
		} else if (idUser == null || idUser.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:" + Local.ERRO_VIEW;
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
				System.out.println("Atualizado com sucesso!");
			} else {
				request.setAttribute("cartao", cartao);
				return "forward:formNovoCartao.jsp";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:entrada?acao=MostraUsuario&id=" + idUser;
	}
}
