<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Inclusão do jQuery via link local -->
<!-- <script src="javascript/jquery.min.js" type="text/javascript"></script>
<script src="javascript/jquery.validate.js" type="text/javascript"></script>
 -->

<!-- Inclusão do bootstrap via link local -->
<!--  <link rel="stylesheet" href="css/bootstrap-4.1.3/css/bootstrap.min.css">
<script src="css/bootstrap-4.1.3/js/bootstrap.min.js"></script> -->

<!-- Inclusão do JS  -->
<!-- <script src="javascript/js.js" type="text/javascript"></script> -->

<!-- Inclusão da folha de estilo-->
<!-- <link rel="stylesheet" type="text/css" href="css/estilo.css"> -->

<c:import url="script_estilos.jsp" />
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



