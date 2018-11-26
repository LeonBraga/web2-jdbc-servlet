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
import com.suam.constantes.Diretorios.Local;
import com.suam.constantes.Info.InfoCampos;
import com.suam.constantes.Parametros.ParametroTela;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;

public class NovoCartao implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = CRIANDO CARTAO");

		String nome = request.getParameter(ParametroTela.NOME);
		String numero = request.getParameter(ParametroTela.NUMERO);
		String data = request.getParameter(ParametroTela.DATA_VENCIMENTO_CARTAO);
		String idUser = request.getParameter("idUser");
	
		String info = null;
		CartaoDeCredito cartao = new CartaoDeCredito();

		if(nome == null ||nome.equals("")) {
			info = InfoCampos.NOME_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+Local.ERRO_VIEW;
		}else if(numero == null ||numero.equals("")) {
			info = InfoCampos.NUMERO_CARTAO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+Local.ERRO_VIEW;
		}else if(data == null  || data.equals("")) {
			info = InfoCampos.DATA_PROBLEMA;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+Local.ERRO_VIEW;
		}else if(idUser == null  ||idUser.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute(ParametroTela.ERRO, info);
			return "forward:"+Local.ERRO_VIEW;
		}
	
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
					info = "Cartão inválido, favor verificar";
					request.setAttribute(ParametroTela.ERRO, info);
					request.setAttribute(ParametroTela.OBJETO_USUARIO, usuario);
					request.setAttribute("cartao", cartao);
					return "forward:"+Local.FORM_NOVO_CARTAO;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "redirect:entrada?acao=MostraUsuario&id="+idUser;

	}
}
