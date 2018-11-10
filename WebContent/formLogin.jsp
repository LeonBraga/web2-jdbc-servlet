<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tela de Login</title>


<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- Inclusão do js de validação-->
<script src="javascript/loginJS.js" type="text/javascript"></script>
<!-- Inclusão da folha de estilo-->
<link rel="stylesheet" type="text/css" href="css/estiloLogin.css">
</head>
<body>

	<%-- <form action="${linkEntradaServlet}" method="post">

		Login: <input type="text" name="login" /> Senha: <input
			type="password" name="senha" /> <input type="hidden" name="acao"
			value="Login"> <input type="submit" />
	</form> --%>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-12">
								<h2 class="active">Login</h2>
							</div>
							<!-- <div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div> -->

						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="${linkEntradaServlet}"
									method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" name="login" id="username" tabindex="1"
											class="form-control" placeholder="Username" value="">
									</div>
									<div class="form-group">
										<input type="password" name="senha" id="password" tabindex="2"
											class="form-control" placeholder="Password">
									</div>
									<div>
										<input type="hidden" name="acao" value="Login">
									</div>
									<!-- <div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div> -->
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit"
													tabindex="4" class="form-control btn btn-login"
													value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<h2 class="active">
											<a href="formEntradaCadastro?cadastrarNovo=true">Registrar-se</a>
										</h2>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>