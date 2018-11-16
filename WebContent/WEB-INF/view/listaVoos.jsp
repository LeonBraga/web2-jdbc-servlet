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
<!-- Inclusão do js-->
<script src="javascript/js.js" type="text/javascript"></script>
<!-- Inclusão do js Filtro -->
<script src="javascript/filtro.js" type="text/javascript"></script>
<!-- Inclusão da folha de estilo-->
<link rel="stylesheet" type="text/css" href="css/filtro.css">


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
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<form name="formulario" action="${linkEntradaServlet }" method="post">
			<ul id="ulItens">
				<c:forEach items="${voos}" var="voo">
					<li><input type="radio" name="vooId" value="${voo.idVoo}">
						Origem: ${voo.origem} - Destino: ${voo.destino} - Ida: <fmt:formatDate
							value="${voo.ida}" pattern="dd/MM/yyyy" /> - Confirmação:
						${voo.confirmacao} - Valor por assento: ${voo.valorVoo} <br>
						<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
							<a href="entrada?acao=MostraVoo&id=${voo.idVoo}"><button>Editar
									este Voo</button></a>
							<a href="entrada?acao=RemoveVoo&id=${voo.idVoo}"><button>Remover
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
							<a href="entrada?acao=MostraVoo&id=${voo.idVoo}"><button>Editar
									este Voo</button></a>
							<a href="entrada?acao=RemoveVoo&id=${voo.idVoo}"><button>Remover
									este Voo</button></a>
						</c:if></li>
					<br>
				</c:forEach>
				<%-- </c:if> --%>
			</ul>




			Deseja comprar passagem de volta: ===>>> AINDA SENDO IMPLEMENTADO <br>
			<input type="radio" name="volta" id="soIda" checked="checked">
			Somente Ida <br> <input type="radio" name="volta" id="volta"
				value="1">Volta <br> ESTE TRECHO SO DEVE APARECER
			QUANDO VOLTA FOR SELECIONADO SERÁ RESOLVIDO COM JQUERY
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


			<br> <input type="hidden" name="acao" value="ListaAssento">
			<input type="submit" value="Confirmar escolhas" /> <br>
		</form>
	</c:if>


	<br>
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<a href="entrada?acao=FormNovoVoo"><button>Cadastrar Novo
				Voo</button></a>
	</c:if>

	<br>
	<c:import url="menuLinks.jsp" />




	<!-- TESTES -->

	<script>
		function check() {
			document.getElementById("soIda").checked = true;
			uncheckVooVolta();
		}
		function uncheck() {
			document.getElementById("soIda").checked = false;
			uncheckVooVolta();
		}

		function uncheckVooVolta() {
			document.getElementById("vooDeVolta").checked = false
			//document.getElementsByName("voltaId").checked = false
			var x = document.getElementsByName("voltaId");
			//console.log(document.getElementById("vooDeVolta"))
			//console.log(document.getElementsByName("voltaId"))
			
			var i;
			for (i = 0; i < x.length; i++) {
				if (x[i].type == "radio") {
					console.log(x[i])
					x[i].checked = false;
				}
			}

		}

		$(document).ready(function() {
			$('input[type=radio]').click(function() {
				//alert(this.value)
				console.log(this.value)
				if (this.value == 'on') {
					uncheckVooVolta();
				}
				;
			});
		});
	</script>

	<button onclick="check()">Check "so ida"</button>
	<button onclick="uncheck()">Uncheck "so ida"</button>
	<button onclick="uncheckVooVolta()">Uncheck "vooVolta Uncheck"</button>

</body>
</html>



