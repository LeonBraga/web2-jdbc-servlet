<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comprar passagem</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	
	<h1>TESTE===>>> cheqguei até aqui</h1>	
	<%-- Nome: <input type="text" name="nome" value="${usuario.nome}" readonly="readonly"/>
	<form action="${linkEntradaServlet }" method="post">		
		<c:if test="${cartoes!=null}">	
				<h3>Lista de cartões de ${usuario.nome}</h3> 
					<c:forEach items="${cartoes}" var="cartao">
						<c:if test="${usuario.id ==  cartao.idUser}">
							<li> 
							 Numero do cartao:  ${cartao.numeroCartao} <input type="checkbox" name="cartaoSelecionado"  value="${cartao.numeroCartao}">
							</li>
							<br>
					</c:if>
				</c:forEach>	
			</c:if>
	<input type="text" name="idVooIda" value="${vooIda.idVoo}" readonly="readonly"/>
	<input type="text" name="idVooVolta" value="${vooVolta.idVoo}" readonly="readonly"/>
	
	
		
		
		<br>
		<input type="hidden" name="acao" value="NovoCompraVoo">
		<input type="submit" /> 
	</form> --%>


<c:import url="menuLinks.jsp"/> 
</body>
</html>