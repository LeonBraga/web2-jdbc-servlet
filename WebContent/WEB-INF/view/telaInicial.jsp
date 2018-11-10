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
	<a href="entrada?acao=ListaAssento">Atualizar Página</a>
	<br>
	
	<br>
	<br>
	<br>
	
	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<h3>Administrador do Sistema</h3>
		<p>Usuario ${usuarioLogado.nome} com privilegios de Administrador.</p>
		<a href="entrada?acao=FormNovoUsuario">Criar Usuário</a>
		<br>
		<a href="entrada?acao=ListaUsuario">Usuários cadastrados no sistema</a>
		<br>
		<a href="entrada?acao=ListaVoo">Tela administração de Vôos</a>
		<br>
		Tela de acompanhamento dos pedidos de vôos. ==> A FAZER
		<br>
		</c:if>
		<br>
		<br>
		
	
	<c:if test="${usuarioLogado.isAdm ==  'FALSE' || usuarioLogado.isAdm ==  'TRUE'}">
		<h3>Cliente      ===>>>==>>Para teste o adm ira ver opções disponiveis para clientes também.****</h3>
		<a href="entrada?acao=MostraUsuario&id=${usuarioLogado.id}">Alterar Meus Dados</a>
		<br>
		<a href="entrada?acao=ListaVoo">Tela de Compra de passagem Aérea</a>
		decrição: Tela de Compra de passagem Aérea OBS: CRIAR Tela de finalização da compra
		<br>
		<a href="entrada?acao=">Tela de acompanhamento dos pedidos de vôos</a> ==>> A FAZER
		<br>
		Tela de escolha de assento e Cálculo do valor final.  ===>>> PRONTO
		<br>
		Tela da Lista de resultados e escolha do vôo do cliente com destaque da linha após ser escolhido e botão de enviar. ==>>EM DESENVOLVIMENTO
		<br>
	</c:if>
</body>
</html>



