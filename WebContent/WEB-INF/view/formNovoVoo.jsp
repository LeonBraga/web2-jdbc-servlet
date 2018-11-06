<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar VOO</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	<form action="${linkEntradaServlet }" method="post">		
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
			Origem:<input type="text" name="origem" value=""/>
			<br>	
			Destino:<input type="text" name="destino" value=""/>
			<br>
			Ida: <input type="text" name="ida" value="" />
			<br>
			Confirmação:<input type="text" name="confirmacao" value=""/>
		</c:if>
		<br>
		<br>
		<input type="hidden" name="acao" value="NovoVoo">
		<input type="submit" /> 
	</form>


<c:import url="menuLinks.jsp"/> 
</body>
</html>