<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
		<h3>MENU de Administrador do Sistema</h3>
		<p>Usuario ${usuarioLogado.nome} com privilegios de Administrador.</p>
		<a href="entrada?acao=FormNovoUsuario">NOVO USUARIO</a>
		descrição:Tela de CRUD Administrador do Sistema
		<br>
		<a href="entrada?acao=ListaCartaoDeCredito">LISTAR TODOS OS CARTOES</a>
		<br>
		<a href="entrada?acao=ListaUsuario">LISTAR TODOS OS USUÁRIOS</a>
		descrição:Tela de CRUD Administrador do Sistema
		<br>
		<a href="entrada?acao=ListaVoo">LISTAR VOOS</a>
		descrição:Tela CRUD VOOS
		<br>
		<a href="entrada?acao=">Tela administração de Vôos</a>
		descrição: Tela de CRUD de Vôos
		<br>
		<a href="entrada?acao=">Tela de acompanhamento dos pedidos de vôos</a>
		<br>
		</c:if>
	<br>
	<c:if test="${usuarioLogado.isAdm ==  'FALSE'}">
		<h3>MENU de Cliente</h3>
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
	




