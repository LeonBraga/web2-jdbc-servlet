package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.bean.Assento;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.service.AssentoService;
import com.suam.service.UsuarioService;
import com.suam.service.VooService;

public class NovoCompraVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("idUser");
		// String voo_idvooVolta = request.getParameter("idvooVolta");
		String assento = request.getParameter("assento");
		String valorTotalCompra = request.getParameter("valorTotalCompra");
		String voo_idvoo = request.getParameter("idVoo");
		String usuario_idusuario = request.getParameter("idusuario");
		String cartaodecredito_numerocartao = request.getParameter("numerocartao");

		Usuario usuario = new Usuario();
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(Integer.valueOf(paramId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		Voo voo = new Voo();
		try {
			voo = VooService.buscaVooPelaId(Integer.valueOf(voo_idvoo));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		List<Assento> assent = new ArrayList<Assento>();
		try {
			assent = AssentoService.listarAssentosPorUsuario(usuario.getId(), voo.getIdVoo()) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("compradorId", usuario_idusuario);
		request.setAttribute("idParam", paramId);
		// Formulário e java aina mão criado// mesma lógica do FormNovoCompraVoo.java
		return "forward:compraRealizadaComSucesso.jsp";
	}

}
