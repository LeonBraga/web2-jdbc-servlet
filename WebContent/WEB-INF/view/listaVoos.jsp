<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Voos</title>
</head>
<body>

	Usuario Logado: ${usuarioLogado.login}
	<br>
	<br>
	<br> Lista de voos:
	<br/>
	<ul>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<c:forEach items="${voos}" var="voo">
			<li>
				Origem: ${voo.origem} -
				Destino: ${voo.destino} - 
				Ida: <fmt:formatDate value="${voo.ida}" pattern="dd/MM/yyyy"/> - 
				Volta: <fmt:formatDate value="${voo.volta}" pattern="dd/MM/yyyy"/> - 
				Confirmação: ${voo.confirmacao}<br>
				<a	href="entrada?acao=MostraVoo&id=${voo.idVoo}">edita</a>
				<a href="entrada?acao=RemoveVoo&id=${voo.idVoo}">remove</a>
			</li>
			<br>
		</c:forEach>
	</c:if>
	</ul>
	<br>
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<a href="entrada?acao=FormNovoVoo">NOVO VOO</a>
	</c:if>
	<br>
	<a href="entrada?acao=ListaVoos">REFRESH</a>
	<br>
	
	<br>
	<c:import url="logout-parcial.jsp" />
	<c:import url="menuLinks.jsp"/> 
</body>
</html>



