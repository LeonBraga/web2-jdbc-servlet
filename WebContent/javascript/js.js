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
$(function() {
	$("#txtBusca").keyup(function() {
		var texto = $(this).val();
		console.log(texto)
		$("#ulItens li").css("display", "block");
		$("#ulItens li").each(function() {
			// Modificação no filtro para torná-lo case insensitivo
			if ($(this).text().toUpperCase().indexOf(texto.toUpperCase()) < 0)
				$(this).css("display", "none");
		});
	});
});

// ***************************************************************

// Quando um checkbox da tela de listagem de assentos for selecionado
window.onload = function() {
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
}
// $('#numeroAssentoOcupado').click(function() {
// $("#ocupa").toggle(this.checked);
// });

// *****************************************************************

// Escondendo voo de volta ao carregar a página
window.onload = function() {
	$("#ulVolta").hide();
}

// Lista de voo de volta
function uncheckVooVolta() {
	document.getElementById("vooDeVolta").checked = false
	// document.getElementsByName("voltaId").checked = false
	var x = document.getElementsByName("voltaId");
	// console.log(document.getElementById("vooDeVolta"))
	// console.log(document.getElementsByName("voltaId"))

	var i;
	for (i = 0; i < x.length; i++) {
		if (x[i].type == "radio") {
			console.log(x[i])
			x[i].checked = false;
		}
	}

}

$(document).ready(function() {
	$('input[type=radio]').click(function() {
		// alert(this.value)
		console.log(this.value)
		if (this.value == 'on') {
			uncheckVooVolta();
			// CRIAR O HIDE ==>
			// $("input[type=radio]").click(function() {
			$("#ulVolta").hide();
			// });
		}
		if (this.value == '1') {
			// $("input[type=radio]").click(function() {
			$("#ulVolta").show();
			// });
		}
	});
});

// Marcando linha selecionada
$(document).ready(function() {
	// $('input[type=radio]').click(function() {
	$('#ulItens').find('input[type=radio]').click(function() {
		var id = $(".liIdaImput" + this.value).val();
		console.log("Ida***" + id);
		$(".liIda").css("background", "");
		if (this.value > 0 && id == this.value) {
			// muda a cor do fudo quando for marcado
			/* a função muda o background da div com id="box" */
			$("#liSelect" + this.value).css("background", "#BDB76B");

		}

	});
});

$(document).ready(function() {
	// $('input[type=radio]').click(function() {
	$('#ulVolta').find('input[type=radio]').click(function() {
		var id = $(".liVoltaImput" + this.value).val();
		console.log("Volta***" + id);
		$(".liVolta").css("background", "");
		if (this.value > 0 && id == this.value) {
			// muda a cor do fudo quando for marcado
			/* a função muda o background da div com id="box" */
			$("#liSelect" + this.value + "Volta").css("background", "#BDB76B");

		}

	});
});
