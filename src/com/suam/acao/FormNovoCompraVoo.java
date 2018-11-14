package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Assento;
import com.suam.bean.CartaoDeCredito;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.service.AssentoService;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.UsuarioService;
import com.suam.service.VooService;

public class FormNovoCompraVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FORM NOVO COMPRA");

		String compradorId = request.getParameter("compradorId");
		Integer id = Integer.valueOf(compradorId);
		String voo_idvoo = request.getParameter("idvoo");

		System.out.println("PARAMETROS RECEBIDOS: " + compradorId + " - " + voo_idvoo);

		// COMPRAR VOO VOLTA===>>>>IMPLEMENTAR
		//String voo_idvooVolta = request.getParameter("vooVolta");

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
			listaCartao = CartaoDeCreditoService.buscaCartoesPeloIdUsuario(compradorId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("cartoes", listaCartao);
		
		//encontra voo
		Integer idVoo = Integer.valueOf(voo_idvoo);
		Voo vooIda = null;
		try {
			vooIda = VooService.buscaVooPelaId(idVoo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("idvoo", vooIda);

		// ==========>>>>>LÓGICA TRANSFERIDA PARA OCUPA ASSENTO
		// LISTARÁ TODOS ===> FILTAR SOMENTE SO ESCOLHIDOS NAQUELE INSTANTE
		List<Assento> listaNumeroAssento = new ArrayList<Assento>();
		List<Assento> listaNumeroAssentoTratada = new ArrayList<Assento>();
		
		try {
			listaNumeroAssento = AssentoService.listarAssentosPorUsuarioIdVooId(id, idVoo);
			for (Assento numeroAssento : listaNumeroAssento) {
				if (numeroAssento.isComfirmaPagamento()) {
					System.out.println("ASSENTO JÁ COMPRADO: " + numeroAssento.getNumeroAssento());
					continue;
				} else {
					listaNumeroAssentoTratada.add(numeroAssento);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		/*if(voo_idvooVolta != null) {
			request.setAttribute("assentosTratados", listaNumeroAssentoTratada);
			return "forward:entrada?acao=MostraVoo&id="+voo_idvooVolta;
		}*/
		
		boolean somenteIda = true;
			
		request.setAttribute("somenteIda", somenteIda);
		request.setAttribute("assentos", listaNumeroAssentoTratada);
		return "forward:formNovoCompraVoo.jsp";
	}

}
