<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="script_estilos.jsp" />
<title>Altera cadastro do voo: ID - ${voo.idVoo}</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br> Alterar cadastro do voo: ID - ${voo.idVoo}
	<br>
	<form action="${linkEntradaServlet }" method="post">
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
			Origem:<input type="text" name="origem" value="${voo.origem}"
				readonly="readonly" />
			<br>	
			Destino:<input type="text" name="destino" value="${voo.destino}"
				readonly="readonly" />
			<br>
			Ida: <input type="text" pattern="\d{1,2}-\d{1,2}-\d{4}"
				class="datepicker" name="ida"
				value="<fmt:formatDate value="${voo.ida}" pattern="dd-MM-yyyy"/>" />
			<input class="datepicker" type="text" name="ida" value="XX-XX-XXXX"
				readonly />
			<br>
			<br>
			<c:if test="${voo.confirmacao ==  'TRUE'}">
				Confirmação:<!-- <input type="checkbox" name="confirmacao" value="true" /> -->
				<br>
				<input type="radio" name="confirmacao" value="1" checked="checked"> Confirmado<br>
				<input type="radio" name="confirmacao" value="0">Não Confirmado<br>
				<!-- Confirmação:<input type="checkbox" name="confirmacao" value="" checked="checked"/> -->
			</c:if>
			<c:if test="${voo.confirmacao ==  'FALSE'}">
			Confirmação:<!-- <input type="checkbox" name="confirmacao" value="true" /> -->
				<br>
				<input type="radio" name="confirmacao" value="1"> Confirmado<br>
				<input type="radio" name="confirmacao" value="0" checked="checked">Não Confirmado<br>
				<!-- Confirmação:<input type="checkbox" name="confirmacao" value="" /> -->
			</c:if>
			<br>
			Valor: <input type="text" name="valorVoo" value="${voo.valorVoo}" />
		</c:if>
		<br> <br> <input type="hidden" name="idVooIda"
			value="${voo.idVoo}"> <input type="hidden" name="acao"
			value="AlteraVoo"> <input type="submit" value="Alterar Dados" />
	</form>

	<br>
	<c:import url="menuLinks.jsp" />
</body>
</html>