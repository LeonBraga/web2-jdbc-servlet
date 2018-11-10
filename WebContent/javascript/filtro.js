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

