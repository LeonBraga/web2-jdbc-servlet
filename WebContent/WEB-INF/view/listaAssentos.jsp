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
<title>Assentos </title>
</head>
<body>
	Usuario Logado: ${usuarioLogado.login}
	<br>
	<br> Todos os assentos:
	<br>

	<form action="${linkEntradaServlet }" method="post">
		Assentos já ocupados:
		<c:forEach items="${assentos}" var="assento">
			<c:if test="${assento.ocupado =='true'}">
				<br>
				 <c:out value="${assento.numeroAssento}"/>
				<input type="checkbox" nome="ocupa" value="">
				<br>
			</c:if>
		</c:forEach>
<br><br>
		Assentos Livres:
		<c:forEach items="${assentos}" var="assento">
			 <c:if test="${assento.ocupado == 'false'}"> 
			 	<br>
				 <c:out value="${assento.numeroAssento}" />
				<input type="checkbox" nome="ocupa" value="">
				<br>
		    </c:if> 
		</c:forEach>

		<input type="hidden" name="idVoo" value="${voo.idVoo }"> <input
			type="hidden" name="acao" value="AssentoOcupa"> <input
			type="submit" />

	</form>
	<br>
	<a href="entrada?acao=ListaAssento">REFRESH</a>
	<br>

	<br>
	<c:import url="logout-parcial.jsp" />
	<c:import url="menuLinks.jsp" />
</body>
</html>



