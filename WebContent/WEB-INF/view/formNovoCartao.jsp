<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Cartao de Credito para ${usuarioLogado.login}</title>
</head>
<body>
<p>Olá ${usuarioLogado.login}, insira os dados de seu cartão aqui:</p>
<br>
	<c:import url="logout-parcial.jsp"/> 
	<form action="${linkEntradaServlet}" method="post">
		Nome: <input type="text" name="nome" value="${usuario.nome}" readonly="true"/>
		<br>
		Numero:<input type="text" name="numero" value=""/>
		<br>
		Data Vencimento:<input type="text" name="dataVencimento" value=""/>
		<br>
		<input type="hidden" name="idUser"  value="${usuario.id}"/>
		<input type="hidden" name="acao" value="NovoCartao">
		<input type="submit" /> 
	</form>
<c:import url="menuLinks.jsp"/> 
</body>
</html>