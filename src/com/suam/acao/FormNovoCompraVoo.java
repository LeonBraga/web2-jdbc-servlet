package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;
import com.suam.service.VooService;

public class FormNovoCompraVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("idUser");
		String voo_idvooVolta = request.getParameter("idvooVolta");
		String assento = request.getParameter("assento");
		String valorTotalCompra = request.getParameter("valorTotalCompra");
		String voo_idvoo = request.getParameter("idvoo");
		Integer id = Integer.valueOf(paramId);

		// usuario
		Usuario user = new Usuario();
		try {
			user = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("usuario", user);

		// lista de cartões do usuario
		List<CartaoDeCredito> listaCartao = null;
		try {
			listaCartao = CartaoDeCreditoService.buscaCartoesPeloIdUsuario(paramId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("cartoes", listaCartao);

		Integer idVoo = Integer.valueOf(voo_idvoo);
		Voo vooIda = null;
		try {
			vooIda = VooService.buscaVooPelaId(idVoo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("idvoo", vooIda);
		
		
		Integer idVooVolta = Integer.valueOf(voo_idvooVolta);
		Voo vooVolta = null;
		try {
			vooVolta = VooService.buscaVooPelaId(idVooVolta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("idvooVolta", vooVolta);

		
		request.setAttribute("assento", assento);
		request.setAttribute("valorTotalCompra", valorTotalCompra);

		System.out.println("FORM NOVO COMPRA");
		return "forward:formNovoCompraVoo.jsp";
	}

}
