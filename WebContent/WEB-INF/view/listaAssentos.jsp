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
	<br> Todos os assentos do voo - id: ${assento.idVoo}:
	<br>

	<form action="${linkEntradaServlet }" method="get">
		Assentos já ocupados:
		<c:forEach items="${assentos}" var="assento">
			<c:if test="${assento.ocupado =='true'}">
				<br>
				 <c:out value="${assento.numeroAssento}"/>
				<input type="hidden" nome="ocupa" value="true">
				<input type="checkbox" nome="numeroAssento" value="${assento.numeroAssento}" checked="checked">
				<br>
			</c:if>
		</c:forEach>
<br><br>
		Assentos Livres:
		<c:forEach items="${assentos}" var="assento">
			 <c:if test="${assento.ocupado == 'false'}"> 
			 	<br>
				 <c:out value="${assento.numeroAssento}"/>
				<!--  <input type="hidden" nome="ocupa" value="true"> -->
				<input type="checkbox" nome="numeroAssento" value="${assento.numeroAssento}">
				<br>
		    </c:if> 
		</c:forEach>

		<input type="hidden" name="idVooIda" value="${voo.idVoo }"> 
		<input type="hidden" name="acao" value="AssentoOcupa">
		 <input type="submit" />

	</form>
	<br>
	<a href="entrada?acao=ListaAssento">REFRESH</a>
	<br>

	<br>
	<c:import url="logout-parcial.jsp" />
	<c:import url="menuLinks.jsp" />
</body>
</html>



