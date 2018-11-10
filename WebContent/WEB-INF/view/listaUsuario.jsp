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
<title>Lista de Usuários</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>


	<br>
	<br> Lista de usuarios:
	<br> Pesquisar:
	<input type="text" id="txtBusca"
		placeholder="Digite aqui um valor para filtrar..." />
	<br>
	<br>
	<ul id="ulItens">
		<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
			<h3>Usuários administradores do sistema:</h3>
			<c:forEach items="${usuarios}" var="usuario">
				<c:if test="${usuario.isAdm ==  'TRUE'}">
					<li>ID:${usuario.id} -NOME: ${usuario.nome} - <a
						href="entrada?acao=MostraUsuario&id=${usuario.id}"><button>Editar
								Usuário</button></a> <a href="entrada?acao=RemoveUsuario&id=${usuario.id}"><button>Remover
								Usuário</button></a>
					</li>
				</c:if>
			</c:forEach>
		</c:if>

		<h3>Clientes</h3>
		<c:forEach items="${usuarios}" var="usuario">
			<c:if test="${usuario.isAdm ==  'FALSE'}">
				<li>ID:${usuario.id} -NOME: ${usuario.nome} - <a
					href="entrada?acao=MostraUsuario&id=${usuario.id}"><button>Editar
							Usuário</button></a> <a href="entrada?acao=RemoveUsuario&id=${usuario.id}"><button>Remover
							Usuário</button></a>
				</li>
			</c:if>
		</c:forEach>
	</ul>

	<br>
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<a href="entrada?acao=FormNovoUsuario"><button>Novo usuário</button></a>
	</c:if>

</body>
</html>



