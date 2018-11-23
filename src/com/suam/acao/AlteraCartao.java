package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.CartaoDeCredito;
import com.suam.constantes.Info.InfoCampos;
import com.suam.service.CartaoDeCreditoService;
import com.suam.util.DataUtils;

public class AlteraCartao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = ALTERANDO CARTAO");

		String nome = request.getParameter("nome");
		String numero = request.getParameter("numero");
		String data = request.getParameter("dataVencimento");
		String idUser = request.getParameter("idUser");
		String info = null;
		CartaoDeCredito cartao = new CartaoDeCredito();

		if(nome == null ||nome.equals("")) {
			info = InfoCampos.NOME_PROBLEMA;
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		}else if(numero == null ||numero.equals("")) {
			info = InfoCampos.NUMERO_CARTAO;
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		}else if(data == null  || data.equals("")) {
			info = InfoCampos.DATA_PROBLEMA;
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		}else if(idUser == null  ||idUser.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		}
		
		
		cartao.setTitular(nome);

		try {
			cartao.setDataVencimento(DataUtils.formatarData().parse(data));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		cartao.setNumeroCartao(numero);
		cartao.setIdUser(Integer.parseInt(idUser));

		Boolean validaInsere;
		try {
			validaInsere = CartaoDeCreditoService.update(cartao);
			if (validaInsere) {
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
