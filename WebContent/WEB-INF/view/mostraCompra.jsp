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
	<br>
	<br> Lista de Compras Confirmadas:
	<br> Pesquisar:
	<input type="text" id="txtBusca"
		placeholder="Digite aqui um valor para filtrar..." />
	<br>
	<br>
	
<!-- LISTANDO UM MAP EXEMPLO-->
<%-- Write all your code inside form tag.

Use this code :

<c:forEach var="configParams" items="${configParamsMap}" varStatus="itemsRow">
   <tr>
        <td>
        <c:out value="${configParams.key}" />
        </td>
        <td><input type="text" name="" value="${configParams.value}" /></td>
  </tr>
</c:forEach>
Use a hidden field that will contain ${configParams.key} value. Use loop iterator ${itemsRow.index} to make distinguished parameter names like

<input type="text"name="configParam.${itemsRow.index}"value="${configParams.value}" />

When form will be submitted then you can access all these values from request by giving names in getParameter('') method. --%>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		Assentos comprados neste voo pelo usuário:<br>
		<ul id="ulItens">
			<c:forEach items="${listaAssentoPagamentoConfirmado}" var="assento">
					<li>
						<c:if test="${assento.comfirmaPagamento == true}">
							<c:out value="${assento.numeroAssento}"/> - Pagamento Confirmado
							<input type="checkbox" name="numeroAssentoOcupado"
							id="numeroAssentoOcupado" value="${assento.numeroAssento}" disabled="disabled">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 		</c:if>
					</li>
			</c:forEach>
		</ul>
		<br>
		Número do Cartão utilizado: ${numeroCartao}
		<br>
		Valor total desta compra: ${valorTotal}  
		
	</c:if>
	<br>
	<br>




</body>
</html>



