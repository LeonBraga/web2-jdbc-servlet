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
		<br>
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
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
					</li>
				</ul>	
					<br>
			</c:if>	
			É Administrador:<input type="text" name="ehAdm" value="${usuario.isAdm}">
			<br>
		</c:if>
		<c:if test="${cartao==null}">	
				Dados do cartão de credito
				<a href="entrada?acao=FormNovoCartao&idUser=${usuario.id}">Novo Cartão</a>
			</c:if>	
		
		<br>
		<br>
		<input type="hidden" name="id" value="${usuario.id}">
		<input type="hidden" name="acao" value="AlteraUsuario">
		<input type="submit" /> 
	</form>

</body>
</html>