<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/formEntradaCadastro" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Inclusão do jQuery via link local -->
<!-- <script src="javascript/jquery.min.js" type="text/javascript"></script>
<script src="javascript/jquery.validate.js" type="text/javascript"></script>
 -->

<!-- Inclusão do bootstrap via link local -->
<!--  <link rel="stylesheet" href="css/bootstrap-4.1.3/css/bootstrap.min.css">
<script src="css/bootstrap-4.1.3/js/bootstrap.min.js"></script> -->

<!-- Inclusão do JS  -->
<!-- <script src="javascript/js.js" type="text/javascript"></script> -->

<!-- Inclusão da folha de estilo-->
<!-- <link rel="stylesheet" type="text/css" href="css/estilo.css"> -->

<c:import url="script_estilos.jsp" />
<title>Cadastrar Novo Usuário</title>
</head>

<body>
	<a href="formLogin.jsp">Tela de Login</a>

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