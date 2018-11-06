<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />

	Usuario Logado: ${usuarioLogado.login}
	<br>
	<br>
	<br>

	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<h3>Administrador do Sistema</h3>
		<p>Usuario ${usuarioLogado.nome} com privilegios de Administrador.</p>
		<a href="entrada?acao=FormNovoUsuario">Novo Usuário</a>
		descrição:Tela de CRUD Administrador do Sistema
		<br>
		<a href="entrada?acao=ListaUsuario">Listar usuários cadastrados no sistema</a>
		descrição:Tela de CRUD Administrador do Sistema
		<br>
		<a href="entrada?acao=ListaVoo">Tela administração de Vôos</a>
		descrição: Tela de CRUD de Vôos
		<br>
		<a href="entrada?acao=">Tela de acompanhamento dos pedidos de vôos</a>
		<br>
		</c:if>
		<br>
		<br>
	<h3>Para teste o adm ira ver opções disponiveis para clientes também.</h3>
	<c:if test="${usuarioLogado.isAdm ==  'FALSE' || usuarioLogado.isAdm ==  'TRUE'}">
		<h3>Cliente</h3>
		<a href="entrada?acao=MostraUsuario&id=${usuarioLogado.id}">Alterar Cadastro do Usuário</a>
		descrição: Telas de CRUD Cliente
		<br>
		<a href="entrada?acao=">Tela de Compra de passagem Aérea</a>
		decrição: Tela de Compra de passagem Aérea OBS: CRIAR Tela de finalização da compra
		<br>
		<a href="entrada?acao=">Tela de acompanhamento dos pedidos de vôos</a>
		<br>
		<a href="entrada?acao=">Tela de escolha de assento e Cálculo do valor final</a>
		<br>
		<a href="entrada?acao=">Tela da Lista de resultados e escolha do vôo do cliente com destaque da linha após ser escolhido e botão de enviar.</a>
		<br>
	</c:if>
</body>
</html>



