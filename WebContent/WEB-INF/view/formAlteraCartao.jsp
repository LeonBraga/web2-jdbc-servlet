<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar cadastro de cartão de credito</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>
	<a href="entrada?acao=ListaAssento">Atualizar Página</a>
	<br>
	
	
	<form action="${linkEntradaServlet }" method="post">

		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
				Nome titular do cartão: <input type="text" name="nome"
				value="${cartao.titular}" readonly="true" />
			<br>
				Numero do cartao: <input type="text" name="numero"
				value="${cartao.numeroCartao}" />
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