<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<title>Cadastrar Cartao de Credito para ${usuarioLogado.login}</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>
	<br>
	<p>Olá ${usuarioLogado.login}, insira os dados de seu cartão aqui:</p>
	<br>
	<form action="${linkEntradaServlet}" method="post">
		Nome: <input type="text" name="nome" value="${usuario.nome}- "
			readonly="true" /> <br> Numero:<input type="text" name="numero"
			value="" /> <br> Data Vencimento:<input type="text"
			name="dataVencimento" value="" /> <br> <input type="hidden"
			name="idUser" value="${usuario.id}" /> <input type="hidden"
			name="acao" value="NovoCartao"> <input type="submit"
			value="Cadastrar Cartão" />
	</form>
	<br>
	<c:import url="menuLinks.jsp" />
</body>
</html>