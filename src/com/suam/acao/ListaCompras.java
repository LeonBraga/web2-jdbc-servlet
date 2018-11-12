package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suam.VO.CompraVooVO;
import com.suam.bean.CompraVoo;
import com.suam.bean.Usuario;
import com.suam.bean.Voo;
import com.suam.service.CompraVooService;
import com.suam.service.UsuarioService;
import com.suam.service.VooService;

public class ListaCompras implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AÇÃO = LISTANDO COMPRAS");

		List<CompraVoo> listaCompras = new ArrayList<CompraVoo>();
		List<CompraVooVO> listaComprasVO = new ArrayList<CompraVooVO>();
		Usuario usuario = new Usuario();
		// HashMap<Integer, CompraVoo> mapCompras = new HashMap<Integer, CompraVoo>();

		try {
			listaCompras = CompraVooService.ListaCompras();
			
			for (CompraVoo compraVoo : listaCompras) {
				CompraVooVO comprasVO = new CompraVooVO();
				comprasVO.setHoraCompra(compraVoo.getHoraCompra());
				comprasVO.setIdCartao(compraVoo.getIdCartao());
				comprasVO.setIdUser(compraVoo.getIdUser());
				comprasVO.setNomeUsuario(UsuarioService.buscaUsuarioPelaId(compraVoo.getIdUser()).getNome() + " "
						+ UsuarioService.buscaUsuarioPelaId(compraVoo.getIdUser()).getSobrenome());
				comprasVO.setValorTotalCompra(compraVoo.getValorTotalCompra());
				comprasVO.setIdVoo(compraVoo.getIdVoo());

				listaComprasVO.add(comprasVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// request.setAttribute("map", mapCompras);
		// request.setAttribute("usuario", listaUsuario);
		// request.setAttribute("compras", listaCompras);
		request.setAttribute("compras", listaComprasVO);
		return "forward:listaCompras.jsp";
	}

}
