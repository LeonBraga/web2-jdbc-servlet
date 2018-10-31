<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Usuários</title>
</head>
<body>

	Usuario Logado: ${usuarioLogado.login}
	<br>
	<br>
	<br> Lista de usuarios:
	<br />
	<ul>
		<c:forEach items="${usuarios}" var="usuario">
			<li>ID:${usuario.id} -NOME: ${usuario.nome} - <a
				href="/Web2Sistema/entrada?acao=MostraUsuario&id=${usuario.id}">edita</a>
				<a href="/Web2Sistema/entrada?acao=RemoveUsuario&id=${usuario.id}">remove</a>
			</li>
		</c:forEach>
		<li>
			<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
				<a href="entrada?acao=FormNovoUsuario">Novo usuário</a>
			</c:if>
		</li>
	</ul>
	<br>
	<br>
	
	<br>
	<a href="entrada?acao=ListaUsuario">REFRESH</a>
	<br>
	
	<br>
	<c:import url="logout-parcial.jsp" />
</body>
</html>



