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
	
		Nome: <input type="text" name="nome" value="${usuario.nome }" />
		Data Abertura: <input type="text" name="data"  value="<fmt:formatDate value="${usuario.dataNascimento }" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${usuario.id }">
		<input type="hidden" name="acao" value="Alterausuario">
		<input type="submit" />
	</form>

</body>
</html>