<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TELA DE CRIAÇÃO DE USUARIO</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	<form action="${linkEntradaServlet}" method="post">
		Nome: <input type="text" name="nome" value="${usuario.nome}"/>
		<br>
		Sobrenome:<input type="text" name="sobrenome" value="${usuario.sobrenome}">
		<br>
		Endereço:<input type="text" name="endereco" value="${usuario.endereco}">
		<br>
		Login:<input type="text" name="login" value="${usuario.login}">
		<br>
		Senha:<input type="text" name="senha" value="${usuario.senha}">
		<br>
		Confirma Senha:<input type="text" name="confirmaSenha" value="">
		<br>
		É Administrador:<input type="text" name="ehAdm" value="${usuario.isAdm}">
		<br>
		Data Nascimento: <input type="text" name="data"  value="${usuario.dataNascimento}"/><!--  pattern="dd/MM/yyyy"/> -->
		<br>
		<br>
		<input type="hidden" name="acao" value="NovoUsuario">
		<input type="submit" /> 
	</form>
<c:import url="menuLinks.jsp"/> 
</body>
</html>