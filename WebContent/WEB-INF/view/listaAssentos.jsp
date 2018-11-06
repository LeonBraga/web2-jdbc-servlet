<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assentos</title>
</head>
<body>
	Usuario Logado: ${usuarioLogado.login}
	<br>
	<br>
	<br> Assentos:
	<br>
	
	Todos os assentos:
	<c:forEach var="i" begin="1" end="100">
         Assento <c:out value="${i}" />
		<p>
	</c:forEach>

	Assentos já ocupados:
	<c:forEach items="${assentos}" var="assento">
		<c:if test="${assento.isocupado ==  'TRUE'} ">
			Assento ocupados <c:out value="${assento.numeroAssento}" />
		</c:if>
	</c:forEach>


	<br>
	<a href="entrada?acao=ListaAssento">REFRESH</a>
	<br>

	<br>
	<c:import url="logout-parcial.jsp" />
	<c:import url="menuLinks.jsp" />
</body>
</html>



