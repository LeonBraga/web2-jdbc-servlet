<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TELA DE ALTERAÇÃO DE USUARIO</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	<form action="${linkEntradaServlet }" method="post">
		
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
				Nome titular do cartão: <input type="text" name="nome" value="${cartao.titular}"/>
			<br>
				Numero do cartao: <input type="text" name="numeroCartao" value="${cartao.numeroCartao}"/>
			<br>
				Data de Vencimento:<input type="text" name="dataVencimento" value="${cartao.dataVencimento}"/>
			<br>
		</c:if>
		
		<br>
		<br>
		<input type="hidden" name="id" value="${cartao.idUser }">
		<input type="hidden" name="acao" value="AlteraCartao">
		<input type="submit" /> 
	</form>

</body>
</html>