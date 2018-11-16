/*$(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});*/

//Filtro
$(function(){
    $("#txtBusca").keyup(function(){
        var texto = $(this).val();
        $("#ulItens li").css("display", "block");
        $("#ulItens li").each(function(){
        	// Modificação no filtro para torná-lo case insensitivo
        	if($(this).text().toUpperCase().indexOf(texto.toUpperCase()) < 0)
        	   $(this).css("display", "none");
        });
    });
});



//Quando um checkbox da tela de listagem de assentos for selecionado
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



