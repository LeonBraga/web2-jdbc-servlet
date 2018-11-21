<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="script_estilos.jsp" />
<title>Alterar dados do usuário</title>
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
				<h1>Editar cadastro de usuário</h1>
				<br> ${erro}
				<form action="${linkEntradaServlet }" method="post">

					Nome: <input type="text" name="nome" value="${usuario.nome}" /> <br>
					Sobrenome:<input type="text" name="sobrenome"
						value="${usuario.sobrenome}"> <br> Endereço:<input
						type="text" name="endereco" value="${usuario.endereco}"> <br>
					Login:<input type="text" name="login" value="${usuario.login}">
					<br> Senha:<input type="text" name="senha"
						value="${usuario.senha}"> <br> Data Nascimento: <input
						type="text" name="data"
						value="<fmt:formatDate value="${usuario.dataNascimento }" pattern="dd/MM/yyyy"/>" />
					<br>
					<c:if test="${usuarioLogado.isAdm=='TRUE'}">
			 Usuario possui perfil administrador:
			 <br>
						<c:if test="${usuario.isAdm=='TRUE'}">
							<input type="radio" name="ehAdm" value="1" checked="checked"> Administrador<br>
							<input type="radio" name="ehAdm" value="0"> Cliente
							<br>
						</c:if>
						<c:if test="${usuario.isAdm=='FALSE'}">
							<input type="radio" name="ehAdm" value="1"> Administrador<br>
							<input type="radio" name="ehAdm" value="0" checked="checked"> Cliente
						</c:if>
					</c:if>
					<br> <input type="hidden" name="id" value="${usuario.id}">
					<input type="hidden" name="acao" value="AlteraUsuario"> <input
						type="submit" value="Alterar Dados" />
				</form>
				<ul>
					<c:if test="${usuario.isAdm ==  'FALSE'}">
		${erro}
			<c:if test="${cartoes!=null}">
							<h3>Lista de cartões de ${usuario.nome}</h3>
							<c:forEach items="${cartoes}" var="cartao">
								<c:if test="${usuario.id ==  cartao.idUser}">
									<li>Nome do titular: ${cartao.titular} <br>Numero do
										cartao: ${cartao.numeroCartao}<br> Data de Vencimento: <fmt:formatDate
											value="${cartao.dataVencimento}" pattern="dd/MM/yyyy" /><br>
										<a href="entrada?acao=MostraCartao&id=${cartao.idUser}"><button
												type="button">Editar Cartão</button></a> <a
										href="entrada?acao=RemoveCartao&numero=${cartao.numeroCartao}"><button
												type="button">Remover Cartão</button></a>
									</li>
									<br>
								</c:if>
							</c:forEach>
						</c:if>
					</c:if>
					<c:if test="${usuarioLogado.isAdm =='FALSE'}">
						<li><a
							href="entrada?acao=FormNovoCartao&idUser=${usuario.id}"><button
									type="button">Cadastrar Novo Cartão</button></a></li>
					</c:if>
				</ul>
				<br>
				<br>
				<br>
				<br>

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