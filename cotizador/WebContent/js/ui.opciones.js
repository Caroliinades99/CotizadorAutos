$(document).ready(function() {
	$(document).on("change", "[name='opcionesDeducibles_cotizadorAutos']",  function(e){
		var valor = $(this).val();
		if(valor == "1")
		{
			$("#perdidaParcial_cotizadorAutos").val("002");
			$("#perdidaTotal_cotizadorAutos").val("001");
			$("#rce_cotizadorAutos").val("08");
		}
		if(valor == "2")
		{
			$("#perdidaParcial_cotizadorAutos").val("001");
			$("#perdidaTotal_cotizadorAutos").val("001");
			$("#rce_cotizadorAutos").val("10");
		}
		if(valor == "3")
		{
			$("#perdidaParcial_cotizadorAutos").val("002");
			$("#perdidaTotal_cotizadorAutos").val("002");
			$("#rce_cotizadorAutos").val("10");
		}
	});
	
	
	
});