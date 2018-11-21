package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.CompraVoo;
import com.suam.bean.Usuario;
import com.suam.service.CompraVooService;
import com.suam.service.UsuarioService;

public class MostraCompra implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("AÇÃO = MOSTRANDO COMPRA");

		String idCompra = request.getParameter("idCompra");
		Integer idCompraInt = Integer.valueOf(idCompra);
		
		String info = null;
		if (idCompra == null || idCompra.equals("")) {
			info = "Alguma coisa não funcionou!!";
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		}
		CompraVoo compraVoo = new CompraVoo();
		Usuario usuario = new Usuario();

		try {
			compraVoo = CompraVooService.comprasPorId(idCompraInt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			usuario = UsuarioService.buscaUsuarioPelaIdHistoricoDeCompras(compraVoo.getIdUser());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			compraVoo.setListaNumeroAssentosIda(
					CompraVooService.comprasAssentosVooIda(idCompraInt, compraVoo.getIdVoo()));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (compraVoo.getIdVooVolta() != null) {
			try {
				compraVoo.setListaNumeroAssentosVolta(
						CompraVooService.comprasAssentosVooVolta(idCompraInt, compraVoo.getIdVooVolta()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		compraVoo.setNomeUsuario(usuario.getNome()+" "+usuario.getSobrenome());

		/*
		 * try { listaAssentoPagamentoConfirmado =
		 * AssentoService.listarAssentosPagosPorUsuarioIdVooId(compraVoo.getIdUser(),
		 * CvooId); } catch (SQLException e) { e.printStackTrace(); }
		 */
		// Integer valorTotal = (listaAssentoPagamentoConfirmado.size() *
		// voo.getValorVoo())+valorTotal;

		request.setAttribute("compra", compraVoo);
		return "forward:mostraCompra.jsp";
	}
}
