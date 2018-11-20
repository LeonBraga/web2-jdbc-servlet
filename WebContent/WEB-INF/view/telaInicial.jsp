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
<title>Inicio</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<h3>Menu do Administrador</h3>
		<h3>Usuario ${usuarioLogado.nome} com privilegios de
			Administrador.</h3>
		<a href="entrada?acao=FormNovoUsuario"><button type="button">Criar
				Usuário</button></a>
		<br>
		<a href="entrada?acao=ListaUsuario"><button type="button">Usuários
				cadastrados no sistema</button></a>
		<br>
		<a href="entrada?acao=ListaVoo"><button type="button">Tela
				administração de Vôos</button></a>
		<br>
		<a href="entrada?acao=ListaCompras"><button type="button">Tela de
				acompanhamento dos pedidos de voos</button></a>
		<br>
		<br>
		<br>
	</c:if>



	<c:if
		test="${usuarioLogado.isAdm ==  'FALSE' || usuarioLogado.isAdm ==  'TRUE'}">
		<h3>Menu do Cliente</h3>
		<h3>Seja bem vindo ${usuarioLogado.nome}.</h3>
		<a href="entrada?acao=MostraUsuario&id=${usuarioLogado.id}"><button type="button">Alterar
				Meus Dados</button></a>
		<br>
		<a href="entrada?acao=ListaVoo"><button type="button">Tela de Compra de
				passagem Aérea</button> </a>
		<br>
		<a href="entrada?acao=ListaCompras"><button type="button">Tela de
				acompanhamento dos pedidos de vôos</button></a>
		<br>
	</c:if>
</body>
</html>



