<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TELA DE ALTERAÇÃO DE USUARIO</title>
</head>
<body>
	<c:import url="logout-parcial.jsp"/> 
	Usuario Logado: ${usuarioLogado.login}
	<form action="${linkEntradaServlet }" method="post">
	
		Nome: <input type="text" name="nome" value="${usuario.nome}"/>
		<br>
		Sobrenome:<input type="text" name="sobrenome" value="${usuario.sobrenome}">
		<br>
		Endereço:<input type="text" name="endereco" value="${usuario.endereco}">
		<br>
		Login:<input type="text" name="login" value="${usuario.login}">
		<br>
		Senha:<input type="text" name="senha" value="${usuario.senha}">
		<br>
		Data Nascimento: <input type="text" name="data"  value="<fmt:formatDate value="${usuario.dataNascimento }" pattern="dd/MM/yyyy"/>"/>
		<br>
		<c:if test="${usuarioLogado.isAdm=='TRUE'}">
			Usuario possui perfil administrador:<input type="text" name="ehAdm" value="${usuario.isAdm}">
			<br>
		</c:if>
		<c:if test="${usuarioLogado.isAdm=='FALSE'}">
			Usuario possui perfil administrador:<input type="text" name="ehAdm" value="${usuario.isAdm}" readonly>
			<br>
		</c:if>
		<br>
		<%-- <c:if test="${usuarioLogado.isAdm ==  'TRUE'}"> --%>
			<c:if test="${cartoes!=null}">	
				<h3>Lista de cartões do usuário</h3> 
				<c:forEach items="${cartoes}" var="cartao">
					<c:if test="${usuario.id ==  cartao.idUser}">
						<li>
							Nome titular: ${cartao.titular} -
						</li>
						<li> 
							Numero do cartao: ${cartao.numeroCartao}
						</li>
						<li> 
							Data de Vencimento: <fmt:formatDate value="${cartao.dataVencimento}" pattern="dd/MM/yyyy"/>
						</li>
						<li>
						    <a href="entrada?acao=MostraCartao&id=${cartao.idUser}">edita</a>
							<a href="entrada?acao=RemoveCartao&id=${cartao.idUser}">remove</a>
						</li>
						<br>
				</c:if>
			</c:forEach>	
		</c:if>
		
		<%-- </c:if> --%>
		<!--USUARIO COM APENAS UM CARTAO SENDO MOSTRADO -->	
	<%-- <c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
			<c:if test="${cartao!=null}">
				<ul>
					Dados do cartão de credito
					<li>
						Nome titular do cartão: ${cartao.titular} -
					</li>
					<li> 
						Numero do cartao: ${cartao.numeroCartao}
					</li>
					<li> 
						Data de Vencimento: ${cartao.dataVencimento}
					</li>
					<li>
					    <a href="entrada?acao=MostraCartao&id=${cartao.idUser}">edita</a>
						<a href="entrada?acao=RemoveCartao&id=${cartao.idUser}">remove</a>
						<a href="entrada?acao=FormNovoCartao&idUser=${cartao.idUser}">Novo Cartão</a>
					</li>
				</ul>	
					<br>
			</c:if>	
	 --%>		
	 	<li>
			<a href="entrada?acao=FormNovoCartao&idUser=${usuario.id}">Novo Cartão</a>
		</li>
		<br>
		<br>
		<input type="hidden" name="id" value="${usuario.id}">
		<input type="hidden" name="acao" value="AlteraUsuario">
		<input type="submit" /> 
	</form>
<c:import url="menuLinks.jsp"/> 
</body>
</html>