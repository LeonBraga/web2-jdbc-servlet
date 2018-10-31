<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />

	Usuario Logado: ${usuarioLogado.login}
	<br> Usuario Administrador: ${usuarioLogado.isAdm}
	<br>
	<br>
	<br>

	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<a href="entrada?acao=FormNovoUsuario">NOVO USUARIO</a>
		<br>
		<a href="entrada?acao=ListaCartaoDeCredito">LISTAR CARTOES</a>
	</c:if>
	<br>
	<a href="entrada?acao=ListaUsuario">LISTAR USUÁRIOS</a>
	<br>

</body>
</html>



