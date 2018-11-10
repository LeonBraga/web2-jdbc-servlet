//quando um checkbox da tela de listagem de assentos for selecionado
if (document.getElementById('numeroAssento').checked) {
	$("#ocupa").show();
} else {
	$("#ocupa").hide();
}

if (document.getElementById('numeroAssentoOcupado').checked) {
	$("#desocupa").show();
} else {
	$("#desocupa").hide();
}

//$('#numeroAssentoOcupado').click(function() {
//    $("#ocupa").toggle(this.checked);
//});
