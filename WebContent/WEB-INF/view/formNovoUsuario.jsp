<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="script_estilos.jsp" />
<title>Cadastrar Novo Usuário</title>
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
				<!-- <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p> -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Cadastrar novo usuário</h1>
				${erro}
				<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
					<form action="${linkEntradaServlet}" method="post">
						Nome: <input type="text" name="nome" value="${usuario.nome}"
							required="required" /> <br> Sobrenome:<input type="text"
							name="sobrenome" value="${usuario.sobrenome}" required="required">
						<br> Endereço:<input type="text" name="endereco"
							value="${usuario.endereco}" required="required"> <br>
						Login:<input type="text" name="login" value="${usuario.login}"
							required="required"> <br> Senha:<input type="text"
							name="senha" value="${usuario.senha}" required="required">
						<br> Confirma Senha:<input type="text" name="confirmaSenha"
							value="" required="required"> <br> Perfil do
						Usuário: <br> <input type="radio" name="ehAdm" value="1"
							required="required"> Administrador<br> <input
							type="radio" name="ehAdm" value="0"> Cliente<br>
						Data Nascimento: <input type="text" name="data"
							placeholder="DD/MM/YYYY" required="required"
							value="<fmt:formatDate value="${usuario.dataNascimento}" pattern="dd/MM/yyyy"/>" />
						<br> <br> <input type="hidden" name="acao"
							value="NovoUsuario"> <input type="submit"
							value="Cadastrar novo Usuário" /> <input name="Reset"
							type="reset" class="formobjects" value="Redefinir">
					</form>
					<c:import url="footerBar.jsp" />
				</c:if>
			</div>
			<div class="col-sm-2 sidenav">
				<!-- <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div> -->
			</div>
		</div>
	</div>


</body>
</html>