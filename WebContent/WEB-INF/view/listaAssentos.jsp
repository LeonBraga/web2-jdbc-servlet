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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- Inclusão do js -->
<script src="javascript/validacaoAssentos.js" type="text/javascript"></script>
<title>Assentos</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>
	<br> Listagem dos assentos do Voo - Indentificador: ${vooId}.
	<br>
	<!-- SOMENTE O CLIENTE QUE OCUPOU O ASSENTO PODERÁ DESOCUPAR O MESMO -->
	<form action="${linkEntradaServlet }" method="post">
		Assentos já ocupados: Clique para desocupar: <br>

		<c:forEach items="${assentos}" var="assento">
			<c:if test="${assento.ocupante == usuarioLogado.id}">
				<c:if test="${assento.comfirmaPagamento != true}">
					<c:out value="${assento.numeroAssento}" /> - NÃO	Confirmado
					<input type="checkbox" name="numeroAssentoOcupado"
						id="numeroAssentoOcupado" value="${assento.numeroAssento}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 </c:if>
			</c:if>

			<c:if test="${assento.ocupante == usuarioLogado.id}">
				<c:if test="${assento.comfirmaPagamento == true}">
					<c:out value="${assento.numeroAssento}" /> - Pagamento Confirmado
					<input type="checkbox" name="numeroAssentoOcupado"
						id="numeroAssentoOcupado" value="${assento.numeroAssento}"
						disabled="disabled">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 </c:if>
			</c:if>


			<c:if test="${assento.ocupante != usuarioLogado.id}">
				<c:out value="${assento.numeroAssento}" />
				<input type="checkbox" name="numeroAssentoOcupado"
					id="numeroAssentoOcupado" value="${assento.numeroAssento}"
					disabled="disabled">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 </c:if>
		</c:forEach>
		<br> <br> Assentos Livres: Clique para ocupar: <br>
		<c:forEach items="${assentosDesocupados}" var="assento">
			<%--  <c:if test="${assento.ocupado == 'false'}">  --%>
			<c:out value="${assento.numeroAssento}" />
			<input type="checkbox" name="numeroAssento" id="numeroAssento"
				value="${assento.numeroAssento}">
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <%-- </c:if> --%>
		</c:forEach>

		<!-- parametro adicionado via jQuery -->
		<div id="ocupa" style="display: none">
			<input type="hidden" name="ocupa" value="true">
		</div>

		<div id="desocupa" style="display: none">
			<input type="hidden" name="desocupa" value="true">
		</div>
		<input type="hidden" name="ocupante" value="${usuarioLogado.id}" /> <input
			type="hidden" name="vooId" value="${vooId}"> <input
			type="hidden" name="acao" value="AssentoOcupa"> <br> <input
			type="submit" value="Ocupar/Desocupar Assento" />
	</form>
	<br>
	<br>






	<br>
	<c:if test="${volta == true }">
		<br> Listagem dos assentosVolta do Voo de VOLTA - Indentificador: ${vooIdVolta}.
		<br>
		<!-- SOMENTE O CLIENTE QUE OCUPOU O ASSENTO PODERÁ DESOCUPAR O MESMO -->
		<form action="${linkEntradaServlet }" method="post">
			Assentos do voo de Volta já ocupados: Clique para desocupar: <br>

			<c:forEach items="${assentosVolta}" var="assento">
				<c:if test="${assento.ocupante == usuarioLogado.id}">
					<c:if test="${assento.comfirmaPagamento != true}">
						<c:out value="${assento.numeroAssento}" /> - NÃO	Confirmado
					<input type="checkbox" name="numeroAssentoOcupadoVolta"
							id="numeroAssentoOcupado" value="${assento.numeroAssento}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 </c:if>
				</c:if>

				<c:if test="${assento.ocupante == usuarioLogado.id}">
					<c:if test="${assento.comfirmaPagamento == true}">
						<c:out value="${assento.numeroAssento}" /> - Pagamento Confirmado
					<input type="checkbox" name="numeroAssentoOcupadoVolta"
							id="numeroAssentoOcupado" value="${assento.numeroAssento}"
							disabled="disabled">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 </c:if>
				</c:if>


				<c:if test="${assento.ocupante != usuarioLogado.id}">
					<c:out value="${assento.numeroAssento}" />
					<input type="checkbox" name="numeroAssentoOcupadoVolta"
						id="numeroAssentoOcupadoVolta" value="${assento.numeroAssento}"
						disabled="disabled">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 </c:if>
			</c:forEach>
			<br> <br> assentosVolta Livres: Clique para ocupar: <br>
			<c:forEach items="${assentosDesocupadosVolta}" var="assento">
				<%--  <c:if test="${assento.ocupado == 'false'}">  --%>
				<c:out value="${assento.numeroAssento}" />
				<input type="checkbox" name="numeroAssentoVolta"
					id="numeroAssentoVolta" value="${assento.numeroAssento}">
		    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		    <%-- </c:if> --%>
			</c:forEach>
			<!-- parametro adicionado via jQuery -->
			<div id="ocupa" style="display: none">
				<input type="hidden" name="ocupa" value="true">
			</div>
			<div id="desocupa" style="display: none">
				<input type="hidden" name="desocupa" value="true">
			</div>
			<input type="hidden" name="ocupante" value="${usuarioLogado.id}" />
			<input type="hidden" name="vooId" value="${vooId}"> <input
				type="hidden" name="idVooVolta" value="${vooIdVolta}"> <input
				type="hidden" name="acao" value="AssentoOcupa"> <br> <input
				type="submit" value="Ocupar/Desocupar Assento" />
		</form>
		<br>
	</c:if>






	<form action="${linkEntradaServlet }" method="post">
		<input type="hidden" name="compradorId" value="${usuarioLogado.id}" />
		<input type="hidden" name="idvoo" value="${vooId}"> <input
			type="hidden" name="acao" value="FormNovoCompraVoo"> <input
			type="submit" value="Comprar Assentos(s)" />
	</form>


	<c:import url="menuLinks.jsp" />
</body>
</html>