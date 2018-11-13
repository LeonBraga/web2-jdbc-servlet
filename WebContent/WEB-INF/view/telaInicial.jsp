<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>
	<c:import url="logout-parcial.jsp" />
	<br>

	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<h3>Usuario ${usuarioLogado.nome} com privilegios de
			Administrador.</h3>
		<a href="entrada?acao=FormNovoUsuario">Criar Usuário</a>
		<br>
		<a href="entrada?acao=ListaUsuario">Usuários cadastrados no
			sistema</a>
		<br>
		<a href="entrada?acao=ListaVoo">Tela administração de Vôos</a>
		<br>
		<a href="entrada?acao=ListaCompras">Tela de acompanhamento dos pedidos de vôos</a>
		<br>
	</c:if>
	<br>
	<br>


	<c:if
		test="${usuarioLogado.isAdm ==  'FALSE' || usuarioLogado.isAdm ==  'TRUE'}">
		<h3>Espaço do Cliente, seja bem vindo ${usuarioLogado.nome}. ===>>>==>>Para teste o adm ira ver opções disponiveis
			para clientes também.****</h3>
		<a href="entrada?acao=MostraUsuario&id=${usuarioLogado.id}">Alterar
			Meus Dados</a>
		<br>
		<a href="entrada?acao=ListaVoo">Tela de Compra de passagem Aérea</a>
		<br>
		<a href="entrada?acao=ListaCompras">Tela de acompanhamento dos pedidos de vôos</a>
		<br>
		Tela da Lista de resultados e escolha do vôo do cliente com destaque da linha após ser escolhido e botão de enviar. ==>>EM DESENVOLVIMENTO
		<br>
	</c:if>
</body>
</html>



