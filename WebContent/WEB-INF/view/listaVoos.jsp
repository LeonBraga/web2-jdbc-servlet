<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada" var="linkEntradaServlet" />
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

<title>Lista de Voos</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>

	<br> Lista de voos:
	<br> Pesquisar
	<input type="text" id="txtBusca"
		placeholder="Digite aqui um valor para filtrar..." />

	<br>
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<form name="formulario" action="${linkEntradaServlet }" method="post">
			<ul id="ulItens">
				<c:forEach items="${voos}" var="voo">
					<li><input type="radio" name="vooId" value="${voo.idVoo}">
						Origem: ${voo.origem} - Destino: ${voo.destino} - Ida: <fmt:formatDate
							value="${voo.ida}" pattern="dd/MM/yyyy" /> - Confirmação:
						${voo.confirmacao} - Valor por assento: ${voo.valorVoo} <br>
						<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
							<a href="entrada?acao=MostraVoo&id=${voo.idVoo}"><button type="button">Editar
									este Voo</button></a>
							<a href="entrada?acao=RemoveVoo&id=${voo.idVoo}"><button type="button">Remover
									este Voo</button></a>
						</c:if></li>
					<br>
				</c:forEach>
			</ul>
			<br> <input type="hidden" name="acao" value="ListaAssento">
			<input type="submit" value="Selecionar Voo" /> <br>
		</form>
	</c:if>

	<c:if test="${usuarioLogado.isAdm ==  'FALSE'}">
		<form action="${linkEntradaServlet }" method="post">
			<ul id="ulItens">
				<%-- <c:if test="${usuarioLogado.isAdm ==  'TRUE'}"> --%>
				<c:forEach items="${voos}" var="voo">
					<li><input type="radio" name="vooId" value="${voo.idVoo}">
						Origem: ${voo.origem} - Destino: ${voo.destino} - Ida: <fmt:formatDate
							value="${voo.ida}" pattern="dd/MM/yyyy" /> - Confirmação:
						${voo.confirmacao} - Valor por assento: ${voo.valorVoo} <br>
						<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
							<a href="entrada?acao=MostraVoo&id=${voo.idVoo}"><button type="button">Editar
									este Voo</button></a>
							<a href="entrada?acao=RemoveVoo&id=${voo.idVoo}"><button type="button">Remover
									este Voo</button></a>
						</c:if></li>
					<br>
				</c:forEach>
				<%-- </c:if> --%>
			</ul>
			<br> Deseja comprar passagem de volta:<br> <input
				type="radio" name="volta" id="soIda" checked="checked">
			Somente Ida <br> <input type="radio" name="volta" id="volta"
				value="1">Volta <br>
			<div id="ulVolta">
				<ul id="ulItens">
					<%-- <c:if test="${usuarioLogado.isAdm ==  'TRUE'}"> --%>
					<c:forEach items="${voos}" var="voo">
						<li><input type="radio" name="voltaId" id="vooDeVolta"
							value="${voo.idVoo}"> Origem: ${voo.origem} - Destino:
							${voo.destino} - Ida: <fmt:formatDate value="${voo.ida}"
								pattern="dd/MM/yyyy" /> - Confirmação: ${voo.confirmacao} -
							Valor por assento: ${voo.valorVoo}</li>
						<br>
					</c:forEach>
					<%-- </c:if> --%>
				</ul>
			</div>


			<br> <input type="hidden" name="acao" value="ListaAssento">
			<input type="submit" value="Confirmar escolhas" /> <br>
		</form>
	</c:if>


	<br>
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<a href="entrada?acao=FormNovoVoo"><button type="button">Cadastrar Novo
				Voo</button></a>
	</c:if>

	<br>
	<c:import url="menuLinks.jsp" />


</body>
</html>



