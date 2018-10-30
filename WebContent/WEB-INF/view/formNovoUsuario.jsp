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
	<form action="${linkEntradaServlet }" method="post">
	
		Nome: <input type="text" name="nome" value=""/>
		<br>
		Sobrenome:<input type="text" name="sobrenome" value="">
		<br>
		Endereço:<input type="text" name="endereco" value="">
		<br>
		Login:<input type="text" name="login" value="">
		<br>
		Senha:<input type="text" name="senha" value="">
		<br>
		É Administrador:<input type="text" name="ehAdm" value="">
		<br>
		Data Nascimento: <input type="text" name="data"  value=""/><!--  pattern="dd/MM/yyyy"/> -->
		<br><!-- "<fmt:formatDate value="${usuario.dataNascimento }" pattern="dd/MM/yyyy"/>" /> -->
		<br>
		<input type="hidden" name="acao" value="NovoUsuario">
		<input type="submit" /> 
	</form>

</body>
</html>