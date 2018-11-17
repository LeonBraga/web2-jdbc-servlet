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
<title>Cadastrar Voo</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>

	<form action="${linkEntradaServlet }" method="post">
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
			Origem:<input type="text" name="origem" value="" />
			<br>	
			Destino:<input type="text" name="destino" value="" />
			<br>
			Ida: <input type="text" pattern="\d{1,2}-\d{1,2}-\d{4}"
				class="datepicker" name="ida" value="" />
			<input class="datepicker" type="text" name="ida" value="XX-XX-XXXX"
				readonly />
			<br>
			Confirmação:<!-- <input type="checkbox" name="confirmacao" value="true" /> -->
			<br>
			<input type="radio" name="confirmacao" value="1"> Confirmado<br>
			<input type="radio" name="confirmacao" value="0">Não Confirmado<br>
			Valor:<input type="text" name="valorVoo" value="" />
		</c:if>
		<br> <br> <input type="hidden" name="acao" value="NovoVoo">
		<input type="submit" />
	</form>
	<br>
	<c:import url="menuLinks.jsp" />
</body>
</html>