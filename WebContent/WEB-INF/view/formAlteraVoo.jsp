<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Altera cadastro do voo: ID-${voo.idVoo }</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	<form action="${linkEntradaServlet }" method="post">
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
			Origem:<input type="text" name="origem" value="${voo.origem}" readonly="readonly"/>
			<br>	
			Destino:<input type="text" name="destino" value="${voo.destino}" readonly="readonly"/>
			<br>
			Ida: <input type="text" name="ida" value="<fmt:formatDate value="${voo.ida}" pattern="dd/MM/yyyy"/>" />
			<br>
			<c:if test="${voo.confirmacao ==  'TRUE'}">
				Confirmação:<input type="checkbox" name="confirmacao" value="" checked="checked"/>
			</c:if>
			<c:if test="${voo.confirmacao ==  'FALSE'}">
				Confirmação:<input type="checkbox" name="confirmacao" value="" />
			</c:if>
			<br>
			Valor: <input type="text" name="confirmacao" value="${voo.valorVoo}"/>
		</c:if>
		<br>
		<br>
		<input type="hidden" name="idVoo" value="${voo.idVoo }">
		<input type="hidden" name="acao" value="AlteraVoo">
		<input type="submit" /> 
	</form>


<c:import url="menuLinks.jsp"/> 
</body>
</html>