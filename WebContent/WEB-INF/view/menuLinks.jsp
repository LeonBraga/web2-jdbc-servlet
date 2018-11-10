<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.suam.bean.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br>
<c:if test="${usuarioLogado.isAdm ==  'TRUE'}">
	<h3>Menu do Administrador do Sistema</h3>
	<p>Usuario ${usuarioLogado.nome} com privilegios de Administrador.</p>
	<a href="entrada?acao=FormNovoUsuario"><button>Criar novo
			usuário</button></a>
	<br>
	<a href="entrada?acao=ListaUsuario"><button>Usuários
			cadastrados no sistema</button></a>
	<br>
	<a href="entrada?acao=ListaVoo"><button>Tela administração
			de Vôos</button></a>
	<br>
	<a href="entrada?acao="><button>Tela de acompanhamento dos
			pedidos de vôos</button></a>
	<br>
</c:if>
<br>



<h3>==>>Para teste o adm ira ver opções disponiveis para clientes
	também.****</h3>
<c:if
	test="${usuarioLogado.isAdm ==  'FALSE' || usuarioLogado.isAdm ==  'TRUE'}">
	<h3>Menu de Cliente</h3>
	<a href="entrada?acao=MostraUsuario&id=${usuarioLogado.id}"><button>Alterar
		Meus Dados</button></a>
		descrição: Telas de CRUD Cliente
		<br>
	<a href="entrada?acao=ListaVoo"><button>Tela de Compra de passagem Aérea</button></a>
		decrição: Tela de Compra de passagem Aérea OBS: CRIAR Tela de finalização da compra
		<br>
	<a href="entrada?acao=">Tela de acompanhamento dos pedidos de vôos</a>
	<br>
	<a href="entrada?acao=">Tela de escolha de assento e Cálculo do
		valor final</a>
	<br>
	<a href="entrada?acao=">Tela da Lista de resultados e escolha do
		vôo do cliente com destaque da linha após ser escolhido e botão de
		enviar.</a>
	<br>
</c:if>





