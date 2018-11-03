package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;

public class NovoCartao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = CRIANDO CARTAO");

		String nome = request.getParameter("nome");
		String numero = request.getParameter("numero");
		String data = request.getParameter("dataVencimento");
		String idUser = request.getParameter("idUser");
		
		CartaoDeCredito cartao = new CartaoDeCredito();
		CartaoDeCreditoService cc = new CartaoDeCreditoService();
		
		Usuario usuario = new Usuario();
		// convertendo data para string
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		// Date data = formato.parse("23/11/2015");
		// Date data = formato.format("23/11/2015");
		
		cartao.setTitular(nome);
		cartao.setNumeroCartao(numero);
		try {
			cartao.setDataVencimento(formato.parse(data));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(idUser);
		
		cartao.setIdUser(Integer.parseInt(idUser.trim()));

		
		Boolean validaInsere;
			try {
				validaInsere = cc.inserir(cartao);
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
