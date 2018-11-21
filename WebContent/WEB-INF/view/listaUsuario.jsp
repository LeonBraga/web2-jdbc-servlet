<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="script_estilos.jsp" />
<title>Lista de Usuários</title>
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
				<h1>Lista de usuários cadastrados no sistema</h1>

				Lista de usuarios: <br> Pesquisar: <br> <input type="text"
					id="txtBusca" placeholder="Digite aqui um valor para filtrar..." />
				<br><br>
				<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
					<a href="entrada?acao=FormNovoUsuario"><button>Novo
							usuário</button></a>
				</c:if>
				<br>
				<ul id="ulItens">
					<c:if test="${usuarioLogado.isAdm == 'TRUE'}">
						<h3>Usuários cadastrados com perfil administrador do sistema:</h3>
						<c:forEach items="${usuarios}" var="usuario">
							<c:if test="${usuario.isAdm ==  'TRUE'}">
								<div class="row">
									<li>
										<div class="col-sm-8 text-left">NOME: ${usuario.nome}
											${usuario.sobrenome}</div>
										<div class="col-sm-4 text-right">
											<a href="entrada?acao=MostraUsuario&id=${usuario.id}"><button
													type="button">Editar Usuário</button></a> <a
												href="entrada?acao=RemoveUsuario&id=${usuario.id}"><button
													type="button">Remover Usuário</button></a> <br>
										</div>
									</li>
								</div>
							</c:if>
						</c:forEach>
					</c:if>
					<br>
					<h3>Usuários cadastrados com perfil Cliente</h3>
					<c:forEach items="${usuarios}" var="usuario">
						<c:if test="${usuario.isAdm ==  'FALSE'}">

							<div class="row">
								<li>
									<div class="col-sm-8 text-left">NOME: ${usuario.nome}
										${usuario.sobrenome}</div>
									<div class="col-sm-4 text-right">
										<a href="entrada?acao=MostraUsuario&id=${usuario.id}"><button
												type="button">Editar Usuário</button></a> <a
											href="entrada?acao=RemoveUsuario&id=${usuario.id}"><button
												type="button">Remover Usuário</button></a> <br>
									</div>
								</li>
							</div>

						</c:if>
					</c:forEach>
				</ul>


				<br>
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



