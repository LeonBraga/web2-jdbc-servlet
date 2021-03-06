package com.suam.acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suam.bean.Voo;
import com.suam.constantes.Constantes.NomeView;
import com.suam.service.VooService;

public class ListaVoo implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("A��O = LISTANDO VOOS");

		List<Voo> listaVoos = null;
		try {
			listaVoos = VooService.ListaVoo(); //MELHORAR - IMPLEMENTAR A ENTREGA DE PARCIAIS
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("voos", listaVoos);
		return "forward:"+NomeView.LISTA_VOOS;
	}

}
