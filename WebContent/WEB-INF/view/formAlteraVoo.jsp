<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TELA DE ALTERAÇÃO DE VOO</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	<form action="${linkEntradaServlet }" method="post">
		
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
				Destino:<input type="text" name="nome" value="${voo.destino}"/>
			<br>
			
		</c:if>
		
		<br>
		<br>
		<input type="hidden" name="idUser" value="${cartao.idUser }">
		<input type="hidden" name="acao" value="AlteraCartao">
		<input type="submit" /> 
	</form>


<c:import url="menuLinks.jsp"/> 
</body>
</html>