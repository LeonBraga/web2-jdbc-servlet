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
		Data Nascimento: <input type="text" name="data"  value="${usuario.dataNascimento }"/>
		<br>
		Dados do cartão de credito
		<br>
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
			É Administrador:<input type="text" name="ehAdm" value="${usuario.isAdm}">
			
			<br>
			<li>
				Nome titular do cartão: ${cartao.titular} -
				<a	href="/Web2Sistema/entrada?acao=MostraCartao&id=${cartao.idUser}">edita</a>
				<a href="/Web2Sistema/entrada?acao=RemoveCartao&id=${cartao.idUser}">remove</a>
			</li>
				<ul> 
					Numero do cartao: ${cartao.numeroCartao}
				</ul>
				<ul> 
					Data de Vencimento: ${cartao.dataVencimento}
				</ul>
			<br>
		</c:if>
		
		<br>
		<br>
		<input type="hidden" name="id" value="${usuario.id }">
		<input type="hidden" name="acao" value="AlteraUsuario">
		<input type="submit" /> 
	</form>

</body>
</html>