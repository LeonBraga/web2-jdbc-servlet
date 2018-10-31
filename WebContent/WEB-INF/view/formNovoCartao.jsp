<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserir Cartao</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	<form action="${linkEntradaServlet}" method="post">
		Nome: <input type="text" name="nome" value="${usuario.nome}"/>
		<br>
		Numero:<input type="text" name="numero" value=""/>
		<br>
		Data Vencimento:<input type="text" name="dataVencimento" value=""/>
		<br>
		<input type="hidden" name="id"  value="${usuario.id}"/>
		<input type="hidden" name="acao" value="NovoCartao">
		<input type="submit" /> 
	</form>

</body>
</html>