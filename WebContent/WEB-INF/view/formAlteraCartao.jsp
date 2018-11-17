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
<title>Alterar cadastro de cartão de credito</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>
<br>
	<form action="${linkEntradaServlet }" method="post">

		<c:if test="${usuarioLogado.isAdm ==  'FALSE'}">
				Nome titular do cartão: <input type="text" name="nome"
				value="${cartao.titular}" readonly="readonly" />
			<br>
				Numero do cartao: <input type="text" name="numero"
				value="${cartao.numeroCartao}" readonly="readonly" />
			<br>
				Data de Vencimento:<input type="text" name="dataVencimento"
				value="<fmt:formatDate value="${cartao.dataVencimento}" pattern="dd/MM/yyyy"/>" />
			<br>
		</c:if>

		<br> <br> <input type="hidden" name="idUser"
			value="${cartao.idUser }"> <input type="hidden" name="acao"
			value="AlteraCartao"> <input type="submit" value="Alterar Dados" />
	</form>


	<c:import url="menuLinks.jsp" />
</body>
</html>