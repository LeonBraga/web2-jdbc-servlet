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
<title>Listar Compras Realizadas</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>
	<br>
	<br> Lista de Compras Confirmadas:
	<br> Pesquisar:
	<input type="text" id="txtBusca"
		placeholder="Digite aqui um valor para filtrar..." />
	<br>
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<ul>
			<c:forEach items="${compras}" var="compra">
					<li>
						Número da Compra: ${compra.idCompra}
						<br>
						Nome do Comprador: ${compra.nomeUsuario}
						<br>
						Hora da compra: ${compra.horaCompra}
						<br>	
						 <a href="entrada?acao=MostraCompra&idCompra=${compra.idCompra}">
						 	<button>Mostrar Detalhes</button>
						 </a>
						<br>
					</li>
			</c:forEach>
		</ul>
	</c:if>

	<c:if test="${usuarioLogado.isAdm ==  'FALSE'}">
	
		<ul id="ulItens">
			<c:forEach items="${compras}" var="compra">
			<c:if test="${usuarioLogado.id ==  compra.idUser}">
					<li>
					<br>
						Número da Compra: ${compra.idCompra}
						<br>
						Nome do Comprador: ${compra.nomeUsuario}
						<br>
						Hora da compra: ${compra.horaCompra}
						<br>
						 <a href="entrada?acao=MostraCompra&idCompra=${compra.idCompra}">
						 	<button>Mostrar Detalhes</button>
						 </a>
						<br>
					</li>
				</c:if>
			</c:forEach>
		</ul>
	</c:if>	
	<br>
	<br>
	<c:import url="menuLinks.jsp" />




</body>
</html>



