<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	
	Usuario Logado: ${usuarioLogado.login}
	<br>
	<br>
	<br>

	<!--<c:if test="${not empty empresa}">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>-->

	Lista de usuarios:
	<br />

	<ul>
		<c:forEach items="${usuarios}" var="usuario">
			<li>ID:${usuario.id}  -NOME: ${usuario.nome}  - 
			<!--<fmt:formatDate
					value="${usuario.dataNascimento }" pattern="dd/MM/yyyy" />--> <a
				href="/Web2Sistema/entrada?acao=MostraUsuario&id=${usuario.id}">edita</a>
				<a href="/Web2Sistema/entrada?acao=RemoveUsuario&id=${usuario.id}">remove</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>



