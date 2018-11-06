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
	<br />

	<c:forEach var="i" begin="1" end="100">
         Assento<c:out value="${i}"/>
		<p>
		<c:forEach items="${assentos}" var="assento">
			<c:if test="${assento.numeroAssento}== ${i} " >
			
			
			</c:if>

		</c:forEach>
	</c:forEach>

	<c:forEach items="${assentos}" var="assento">


	</c:forEach>

	<br>
	<br>

	<br>
	<a href="entrada?acao=ListaAssento">REFRESH</a>
	<br>

	<br>
	<c:import url="logout-parcial.jsp" />
	<c:import url="menuLinks.jsp" />
</body>
</html>



