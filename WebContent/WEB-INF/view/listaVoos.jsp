<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- Inclusão do js -->
<script src="javascript/filtro.js" type="text/javascript"></script>
<!-- Inclusão da folha de estilo-->
<link rel="stylesheet" type="text/css" href="css/filtro.css">

<title>Lista de Voos</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>

	<br> Lista de voos:
	<br> Pesquisar
	<input type="text" id="txtBusca"
		placeholder="Digite aqui um valor para filtrar..." />
	<br>
	<br>
	<%-- <ul id="ulItens">
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<c:forEach items="${voos}" var="voo">
			<li>Origem: ${voo.origem} - Destino: ${voo.destino} - Ida: <fmt:formatDate
					value="${voo.ida}" pattern="dd/MM/yyyy" /> - Confirmação:
				${voo.confirmacao} - Valor por assento: ${voo.valorVoo} <br> <c:if
					test="${usuarioLogado.isAdm ==  'TRUE'}">
					<a href="entrada?acao=MostraVoo&id=${voo.idVoo}"><button>Editar
							este Voo</button></a>
					<a href="entrada?acao=RemoveVoo&id=${voo.idVoo}"><button>Remover
							este Voo</button></a>
				</c:if> <c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
					<a href="entrada?acao=ListaAssento&vooId=${voo.idVoo}"><button>Escolher
							este voo, escolha seu assento no voo Identificador: ${voo.idVoo}.</button></a>
				</c:if> <c:if test="${usuarioLogado.isAdm ==  'FALSE'}">
					<a href="entrada?acao=ListaAssento&vooId=${voo.idVoo}">Escolher
						este voo, escolha seu assento no voo Identificador: ${voo.idVoo}.</a>
				</c:if> <br>
			</li>
			<br>
		</c:forEach>
		</c:if>
	</ul> --%>
	<br>

	<form action="${linkEntradaServlet }" method="post">
		<ul id="ulItens">
			<%-- <c:if test="${usuarioLogado.isAdm ==  'TRUE'}"> --%>
			<c:forEach items="${voos}" var="voo">
				<li><input type="radio" name="vooId" value="${voo.idVoo}">
					Origem: ${voo.origem} - Destino: ${voo.destino} - Ida: <fmt:formatDate
						value="${voo.ida}" pattern="dd/MM/yyyy" /> - Confirmação:
					${voo.confirmacao} - Valor por assento: ${voo.valorVoo} <br> <c:if
						test="${usuarioLogado.isAdm ==  'TRUE'}">
						<a href="entrada?acao=MostraVoo&id=${voo.idVoo}"><button>Editar
								este Voo</button></a>
						<a href="entrada?acao=RemoveVoo&id=${voo.idVoo}"><button>Remover
								este Voo</button></a>
					</c:if></li>
				<br>
			</c:forEach>
			<%-- </c:if> --%>
		</ul>
		
			
			Deseja comprar	passagem de volta: ===>>> AINDA SENDO IMPLEMENTADO <br> <input
			type="radio" name="volta" value="" checked="checked"> Somente
		Ida <br> <input type="radio" name="volta" value="1">Volta
		<br> 
		
		
		ESTE TRECHO SO DEVE APARECER QUANDO VOLTA FOR SELECIONADO
		<ul id="ulItens">
			<%-- <c:if test="${usuarioLogado.isAdm ==  'TRUE'}"> --%>
			<c:forEach items="${voos}" var="voo">
				<li><input type="radio" name="voltaId" value="${voo.idVoo}">
					Origem: ${voo.origem} - Destino: ${voo.destino} - Ida: <fmt:formatDate
						value="${voo.ida}" pattern="dd/MM/yyyy" /> - Confirmação:
					${voo.confirmacao} - Valor por assento: ${voo.valorVoo}
					</li>
				<br>
			</c:forEach>
			<%-- </c:if> --%>
		</ul>


	<br>
	<input type="hidden" name="acao" value="ListaAssento"> <input
			type="submit" value="Confirmar escolhas" /> <br> 
	</form>



	<br>
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<a href="entrada?acao=FormNovoVoo"><button>Cadastrar Novo
				Voo</button></a>
	</c:if>

	<br>
	<c:import url="menuLinks.jsp" />
</body>
</html>



