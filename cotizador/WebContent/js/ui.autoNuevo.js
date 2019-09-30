$(document).ready(function() {
	$(document).on("change", "[name='vehiculoNuevo_cotizadorAutos']",  function(e){
		var nuevo = $(this).val();
		if(nuevo == "NO")
		{
			$("#valorAnios_cotizadorAutos").prop('disabled', 'disabled');
			$("#valorAnios_cotizadorAutos").val("");
			$("#textoAutoNuevo").html("");
//			$("#rce_cotizadorAutos").val("08");
		}else{
			
			$("#valorAnios_cotizadorAutos").prop('disabled', false);
			$("#textoAutoNuevo").html("Debe ingresar el valor de la factura");
		}
	});
});