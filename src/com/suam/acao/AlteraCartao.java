package com.suam.acao;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		
		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");

		cartao.setTitular(nome);
		// cartao.setNumeroCartao(numero);
		try {
			cartao.setDataVencimento(formato.parse(data));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Id do usuario titular: "+idUser);
		
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
