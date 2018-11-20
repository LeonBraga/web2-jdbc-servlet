<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/formEntradaCadastro" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="script_estilos.jsp" />
<title>Cadastrar Novo Usuário</title>
</head>
<body>
	<a href="formLogin.jsp">Tela de Login</a>
	<br> Seja bem vindo, insira seus dados!


	<form action="${linkEntradaServlet}" method="post">
		Nome: <input type="text" name="nome" value="" /> <br> Sobrenome:<input
			type="text" name="sobrenome" value=""> <br> Endereço:<input
			type="text" name="endereco" value=""> <br> Login:<input
			type="text" name="login" value=""> <br> Senha:<input
			type="text" name="senha" value=""> <br> Confirma Senha:<input
			type="text" name="confirmaSenha" value=""> <br> <br>
		Data Nascimento: <input type="text" name="data" value="" /> <br>
		<br> <input type="submit" value="Cadastrar" />
	</form>


	<br>
	<c:import url="menuLinks.jsp" />

</body>
</html>