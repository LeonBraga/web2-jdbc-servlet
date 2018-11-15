package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Assento;
import com.suam.bean.CartaoDeCredito;
import com.suam.bean.CompraVoo;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.service.AssentoService;
import com.suam.service.CartaoDeCreditoService;
import com.suam.service.CompraVooService;
import com.suam.service.UsuarioService;
import com.suam.service.VooService;

public class NovoCompraVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramId = request.getParameter("idUser");
		String[] assento = request.getParameterValues("assento");
		String valorTotalCompra = request.getParameter("valorTotalCompra");
		String[] voo_idvoo = request.getParameterValues("idVoo");
		String cartaodecredito_numerocartao = request.getParameter("numerocartao");

		System.out.println(paramId + " - " + Arrays.toString(assento) + " - " + Arrays.toString(voo_idvoo) + " - "
				+ valorTotalCompra + " - " + cartaodecredito_numerocartao);

		Usuario usuario = new Usuario();
		try {
			usuario = UsuarioService.buscaUsuarioPelaId(Integer.valueOf(paramId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		CartaoDeCredito cartaoDeCredito = new CartaoDeCredito();
		try {
			cartaoDeCredito = CartaoDeCreditoService.buscaCartaoPeloNumero(cartaodecredito_numerocartao);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		List<Integer> listaNumeroVoo = new ArrayList<Integer>();
		Voo voo = new Voo();
		List<Assento> listaNumeroAssento = new ArrayList<Assento>();
		Integer totalCompra = 0;
		for (String vooIdVoo : voo_idvoo) {
			try {
				if(vooIdVoo != null && vooIdVoo != "" && vooIdVoo !="null") { 
				listaNumeroAssento = AssentoService.listarAssentosPorUsuarioIdVooIdPagamentoNaoConfirmado(usuario.getId(),
						Integer.valueOf(vooIdVoo));
				for (Assento assento2 : listaNumeroAssento) {
					AssentoService.PagamentoAssentoPorUsuarioId(usuario.getId(), assento2.getNumeroAssento(),
							Integer.valueOf(vooIdVoo));
				}

				voo = VooService.buscaVooPelaId(Integer.valueOf(vooIdVoo));
				listaNumeroVoo.add(Integer.valueOf(vooIdVoo));
				totalCompra += (voo.getValorVoo() * listaNumeroAssento.size());
				System.out.println("VALOR TOTAL:  " + valorTotalCompra);
				}
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
		}

		// Criando a compra
		CompraVoo compra = new CompraVoo();
		// compra.setAssento(listaAssentosNumeros);
		compra.setIdCartao(cartaodecredito_numerocartao);
		compra.setIdUser(usuario.getId());
		compra.setIdVoo(listaNumeroVoo);
		compra.setValorTotalCompra(totalCompra);
		// compra.setIdVooVolta(idVooVolta);

		// pagamento por assento
		for (String assent : assento) {
			try {
				AssentoService.PagamentoAssentoPorUsuarioId(usuario.getId(), Integer.valueOf(assent),
						Integer.valueOf(voo_idvoo[0]));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try {
			CompraVooService.inserir(compra);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("compradorId", paramId);
		request.setAttribute("idParam", paramId);
		
		return "forward:compraRealizadaComSucesso.jsp";
	}

}
