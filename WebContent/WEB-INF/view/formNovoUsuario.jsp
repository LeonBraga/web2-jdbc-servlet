<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/entrada" var="linkEntradaServlet" />

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
	<c:import url="logout-parcial.jsp" />
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<form action="${linkEntradaServlet}" method="post">
			Nome: <input type="text" name="nome" value="${usuario.nome}" /> <br>
			Sobrenome:<input type="text" name="sobrenome"
				value="${usuario.sobrenome}"> <br> Endereço:<input
				type="text" name="endereco" value="${usuario.endereco}"> <br>
			Login:<input type="text" name="login" value="${usuario.login}">
			<br> Senha:<input type="text" name="senha"
				value="${usuario.senha}"> <br> Confirma Senha:<input
				type="text" name="confirmaSenha" value=""> <br>
			<%--  Usuário
			possui perfil Administrador:<input type="checkbox" name="ehAdm"
				value="${usuario.isAdm}" /> --%>
			Perfil do Usuário: <br> <input type="radio" name="ehAdm"
				value="1"> Administrador<br> <input type="radio"
				name="ehAdm" value="0"> Cliente<br>
			<%--<input type="text" name="ehAdm" value="${usuario.isAdm}"> --%>
			<br> <br> Data Nascimento: <input type="text" name="data"
				value="<fmt:formatDate value="${usuario.dataNascimento}" pattern="dd/MM/yyyy"/>" />
			<br> <br> <input type="hidden" name="acao"
				value="NovoUsuario"> <input type="submit" />
		</form>
		<c:import url="menuLinks.jsp" />
	</c:if>

	<br>
	<c:import url="menuLinks.jsp" />

</body>
</html>