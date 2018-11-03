<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Cartoes</title>
</head>
<body>

	Usuario Logado: ${usuarioLogado.login}
	<br>
	<br>
	<br> Lista de cartoes:
	<br/>
	<ul>
		<c:forEach items="${cartoes}" var="cartao">
			<li>
				Nome titular: ${cartao.titular} -
			</li>
			<li> 
				Numero do cartao: ${cartao.numeroCartao}
			</li>
			<li> 
				Data de Vencimento: <fmt:formatDate value="${cartao.dataVencimento}" pattern="dd/MM/yyyy"/>
			</li>
			<li>
				<a	href="/Web2Sistema/entrada?acao=MostraCatao&id=${cartao.idUser}">edita</a>
				<a href="/Web2Sistema/entrada?acao=RemoveCartao&id=${cartao.idUser}">remove</a>
			</li>
			<br>
		</c:forEach>
	</ul>
	<br>
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<a href="entrada?acao=FormNovoCartao">NOVO CARTAO</a>
	</c:if>
	<br>
	<a href="entrada?acao=ListaCartoes">REFRESH</a>
	<br>
	
	<br>
	<c:import url="logout-parcial.jsp" />
	<c:import url="menuLinks.jsp"/> 
</body>
</html>



