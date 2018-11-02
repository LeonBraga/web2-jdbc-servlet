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
		
			<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
			<h3>Administradores</h3>
				<c:forEach items="${usuarios}" var="usuario">	
					<c:if test="${usuario.isAdm ==  'TRUE'}">	
						<li>ID:${usuario.id} -NOME: ${usuario.nome} - <a
							href="entrada?acao=MostraUsuario&id=${usuario.id}">edita</a>
							<a href="entrada?acao=RemoveUsuario&id=${usuario.id}">remove</a>
						</li>
					</c:if>
				</c:forEach>
			</c:if>
			
		
			<h3>Clientes</h3>
			<c:forEach items="${usuarios}" var="usuario">
				<c:if test="${usuario.isAdm ==  'FALSE'}">	
					<li>ID:${usuario.id} -NOME: ${usuario.nome} - <a
						href="entrada?acao=MostraUsuario&id=${usuario.id}">edita</a>
						<a href="entrada?acao=RemoveUsuario&id=${usuario.id}">remove</a>
					</li>
				</c:if>
			</c:forEach>
	</ul>
	
	<br><br><br><br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<a href="entrada?acao=FormNovoUsuario">Novo usuário</a>
	</c:if>
		
	<br>
	<br>
	
	<br>
	<a href="entrada?acao=ListaUsuario">REFRESH</a>
	<br>
	
	<br>
	<c:import url="logout-parcial.jsp" />
</body>
</html>



