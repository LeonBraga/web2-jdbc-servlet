<!-- <a href="entrada?acao=TelaInicial">Tela inicial</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="entrada?acao=Logout">Sair</a>
<br> -->
<form>
	<input type="button" value="Voltar" onClick="history.go(-1)"> <input
		type="button" value="Avançar" onCLick="history.forward()"> <input
		type="button" value="Atualizar" onClick="history.go(0)">
</form>

Usuario Logado: ${usuarioLogado.login}

<a href="entrada?acao=Logout"><button>Sair</button></a>

<a href="entrada?acao=TelaInicial"><button>Tela Inicial</button></a>