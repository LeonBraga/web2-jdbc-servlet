package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		String erro = null;
		String info = null;
		
		CartaoDeCredito cartao = new CartaoDeCredito();
	
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		cartao.setTitular(nome);
		cartao.setNumeroCartao(numero);
		try {
			cartao.setDataVencimento(formato.parse(data));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		cartao.setIdUser(Integer.parseInt(idUser.trim()));

		Usuario usuario =  new Usuario();
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(Integer.parseInt(idUser.trim()));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Boolean validaInsere;
			try {
				validaInsere = CartaoDeCreditoService.inserirCartao(cartao);
				if (validaInsere) {
				} else {
					erro = "Cartão inválido, favor verificar";
					request.setAttribute("erro", erro);
					request.setAttribute("usuario", usuario);
					request.setAttribute("cartao", cartao);
					return "forward:formNovoCartao.jsp";
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "redirect:entrada?acao=MostraUsuario&id="+idUser;

	}
}
