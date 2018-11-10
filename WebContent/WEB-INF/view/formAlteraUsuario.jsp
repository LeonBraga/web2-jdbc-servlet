<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar dados do usuário</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>
	
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
			Usuario possui perfil administrador:
			<c:if test="${usuario.isAdm=='TRUE'}">
				<input type="checkbox"  name="ehAdm" value="${usuario.isAdm}" checked="checked"/>
				<%--<input type="text" name="ehAdm" value="${usuario.isAdm}"> --%>
				<br>
			</c:if>
			<c:if test="${usuario.isAdm=='FALSE'}">
				<input type="checkbox"  name="ehAdm" value="${usuario.isAdm}"/>
				<%--<input type="text" name="ehAdm" value="${usuario.isAdm}"> --%>
				<br>
			</c:if>
		</c:if>
		<%-- <c:if test="${usuarioLogado.isAdm=='FALSE'}">
			Usuario possui perfil administrador:
			<input type="checkbox"  name="ehAdm" value="${usuario.isAdm}" disabled="disabled"/>
			<input type="text" name="ehAdm" value="${usuario.isAdm}" readonly="readonly">
			<br>
		</c:if> --%>
		<br>
		 <c:if test="${usuario.isAdm ==  'FALSE'}"> 
			<c:if test="${cartoes!=null}">	
				<h3>Lista de cartões de ${usuario.nome}</h3> 
					<c:forEach items="${cartoes}" var="cartao">
						<c:if test="${usuario.id ==  cartao.idUser}">
							<li>
								Nome do titular: ${cartao.titular} 
							</li>
							<li> 
								Numero do cartao: ${cartao.numeroCartao}
							</li>
							<li> 
								Data de Vencimento: <fmt:formatDate value="${cartao.dataVencimento}" pattern="dd/MM/yyyy"/>
							</li>
							<li>
							    <a href="entrada?acao=MostraCartao&id=${cartao.idUser}"><button>Editar Cartão</button></a>
								<a href="entrada?acao=RemoveCartao&numero=${cartao.numeroCartao}"><button>Remover Cartão</button></a>
							</li>
							<br>
					</c:if>
				</c:forEach>	
			</c:if>
		</c:if>
		
	<c:if test="${usuario.isAdm=='FALSE'}"> 
		<li>
			<a href="entrada?acao=FormNovoCartao&idUser=${usuario.id}"><button>Cadastrar Novo Cartão</button></a>
		</li>
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
	 	
		<br>
		<input type="hidden" name="id" value="${usuario.id}">
		<input type="hidden" name="acao" value="AlteraUsuario">
		<input type="submit" value="Alterar Dados" /> 
	</form>
<c:import url="menuLinks.jsp"/> 
</body>
</html>