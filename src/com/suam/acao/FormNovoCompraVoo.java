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
import com.suam.constantes.Info.InfoCampos;
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
		String voo_idvooVolta = request.getParameter("idvooVolta");

		String info = null;

		 if (compradorId == null ||compradorId.equals("")) {
			info = InfoCampos.GENERICO;
			request.setAttribute("erro", info);
			return "forward:erro.jsp";
		}

		
		
		Usuario user = new Usuario();
		List<CartaoDeCredito> listaCartao = null;
		boolean idaVolta = false;
		Integer idVoo = Integer.valueOf(voo_idvoo);
		Voo vooIda = null;
		List<Assento> listaNumeroAssento = new ArrayList<Assento>();
		List<Assento> listaNumeroAssentoTratada = new ArrayList<Assento>();
		List<Assento> listaNumeroAssentoVolta = new ArrayList<Assento>();
		List<Assento> listaNumeroAssentoTratadaVolta = new ArrayList<Assento>();

		// usuario
		try {
			user = UsuarioService.buscaUsuarioPelaId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("usuario", user);

		// lista de cartões do usuario
		try {
			listaCartao = CartaoDeCreditoService.buscaCartoesPeloIdUsuario(compradorId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("cartoes", listaCartao);

		// encontra voo
		try {
			vooIda = VooService.buscaVooPelaId(idVoo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("idvoo", vooIda);

		// Voo ida
		// LISTARÁ TODOS ===> FILTAR SOMENTE SO ESCOLHIDOS NAQUELE INSTANTE
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

		// Voo Volta
		// LISTARÁ TODOS ===> FILTAR SOMENTE SO ESCOLHIDOS NAQUELE INSTANTE
		if (voo_idvooVolta != null && voo_idvooVolta != "" && voo_idvooVolta != "null") {
			idaVolta = true;
			// encontra voo
			Integer idVooVolta = Integer.valueOf(voo_idvooVolta);
			Voo vooIdaVolta = null;
			try {
				vooIdaVolta = VooService.buscaVooPelaId(idVooVolta);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("idvooVolta", vooIdaVolta);

			try {
				listaNumeroAssentoVolta = AssentoService.listarAssentosPorUsuarioIdVooId(id, idVooVolta);
				for (Assento numeroAssento : listaNumeroAssentoVolta) {
					if (numeroAssento.isComfirmaPagamento()) {
						System.out.println("ASSENTO JÁ COMPRADO: " + numeroAssento.getNumeroAssento());
						continue;
					} else {
						listaNumeroAssentoTratadaVolta.add(numeroAssento);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("idaVolta", idaVolta);
		request.setAttribute("assentos", listaNumeroAssentoTratada);
		request.setAttribute("assentosVolta", listaNumeroAssentoTratadaVolta);
		return "forward:formNovoCompraVoo.jsp";
	}

}
