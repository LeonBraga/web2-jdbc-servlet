<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="script_estilos.jsp" />
<title>Alterar cadastro de cartão de credito</title>
</head>
<body>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<c:import url="navBar.jsp" />
	</c:if>
	<c:if test="${usuarioLogado.isAdm ==  'FALSE'}">
		<c:import url="navBarCli.jsp" />
	</c:if>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!--  <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p> -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Editar cadastro de cartão de crédito</h1>
				<form action="${linkEntradaServlet }" method="post">

					<c:if
						test="${usuarioLogado.isAdm ==  'FALSE' || usuarioLogado.isAdm ==  'TRUE'}">
				Nome titular do cartão: <input type="text" name="nome"
							value="${cartao.titular}" readonly="readonly" />
						<br>
				Numero do cartao: <input type="text" name="numero"
							value="${cartao.numeroCartao}" readonly="readonly" />
						<br>
				Data de Vencimento:<input type="text" name="dataVencimento"
							placeholder="DD/MM/YYYY" required="required"
							value="<fmt:formatDate value="${cartao.dataVencimento}" pattern="dd/MM/yyyy"/>" />
						<br>
					</c:if>

					<br> <br> <input type="hidden" name="id"
						value="${cartao.idUser }"> <input type="hidden"
						name="acao" value="AlteraCartao"> <input type="submit"
						value="Alterar Dados" />
				</form>
			</div>
			<div class="col-sm-2 sidenav">
				<!--  <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div> -->
			</div>
		</div>
	</div>

	<c:import url="footerBar.jsp" />


</body>
</html>