package com.suam.acao;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.service.CartaoDeCreditoService;

public class AlteraCartao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = ALTERANDO CARTAO");

		String nome = request.getParameter("nome");
		String numero = request.getParameter("numero");
		String data = request.getParameter("dataVencimento");
		String idUser = request.getParameter("idUser");
		
		CartaoDeCredito cartao = new CartaoDeCredito();
		CartaoDeCreditoService cc = new CartaoDeCreditoService();
		
		
		cartao.setTitular(nome);
		cartao.setNumeroCartao(Long.parseLong(numero.trim()));
		cartao.setDataVencimento(data);
		System.out.println(idUser);
		
		cartao.setIdUser(Integer.parseInt(idUser.trim()));

		
		Boolean validaInsere;
			try {
				validaInsere = cc.update(cartao);
				if (validaInsere) {
					System.out.println("Inserido com sucesso");
				} else {
					request.setAttribute("cartao", cartao);
					return "forward:formNovoCartao.jsp";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "redirect:entrada?acao=MostraUsuario&id="+idUser;

	}
}
