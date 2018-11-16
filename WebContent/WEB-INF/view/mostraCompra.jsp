<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- Inclusão do js -->
<script src="javascript/filtro.js" type="text/javascript"></script>
<!-- Inclusão da folha de estilo-->
<link rel="stylesheet" type="text/css" href="css/filtro.css">
<title>Listar Detalhes</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>
	<%-- <c:if test="${usuarioLogado.isAdm ==  'TRUE'}"> --%>
		Número da Compra: ${compra.idCompra}
		<br>
		Assentos comprados no voo id ${compra.idVoo} pelo usuário:<br>
		<ul >
			<c:forEach items="${compra.listaNumeroAssentosIda}" var="assento">
				<li><c:out value="${assento}" /> <input type="checkbox"
					value="${assento}" disabled="disabled">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			</c:forEach>
		</ul>
		<br>
		<c:if test="${compra.idVooVolta != '0'}">
			Assentos comprados no voo id ${compra.idVooVolta} pelo usuário:<br>
			<ul >
				<c:forEach items="${compra.listaNumeroAssentosVolta}" var="assento">
					<li><c:out value="${assento}" /> <input type="checkbox"
						value="${assento}" disabled="disabled">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
				</c:forEach>
			</ul>
		</c:if>
		<br>
		<br>
		Número do Cartão utilizado: ${compra.idCartao}
		<br>
		Valor total desta compra: ${compra.valorTotalCompra}  
	<%-- </c:if>
	 --%>

</body>
</html>



