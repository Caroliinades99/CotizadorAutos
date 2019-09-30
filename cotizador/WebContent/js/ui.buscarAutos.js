$(document).ready(function() {
	$(document).on("click", "#buscarPlaca_cotizadorAutos", function(e){
		e.preventDefault();
		var path = $("#path").val();
		
		$("#marcas_cotizadorAutos").val("-1");
		$('#modelos_cotizadorAutos').empty();
		$('#versiones_cotizadorAutos').empty();
		$('#anios_cotizadorAutos').empty();
		$("#rtaPlaca_cotizadorAutos").html("Cargando");
		var placa = $("#placa_cotizadorAutos").val();
		var info = {"placa": placa};
		$.ajax({
			type: "POST",
	        url: path + "/ServletCodigoFasecoldaPlaca",
	        scriptCharset: "utf-8" ,
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        data: info ,
	        success: function(msg)
	        {
	        	//alert(msg.valorActual + " - " + msg.codigoFasecolda + " - " + msg.modelo);
	        	$("#rtaPlaca_cotizadorAutos").html("");
	        	
	        	if(msg.respuesta == "exito")
	        	{
	        		actualizarModelosFasecolda(msg.marca, msg.modelo, msg.codigoFasecolda, msg.anio);
	        		$("#marcas_cotizadorAutos").val(msg.marca);
	        	}else{
	        		$("#rtaPlaca_cotizadorAutos").html("Vehiculo no encontrado");
	        		$("#marcas_cotizadorAutos").val("-1");
        			$('#modelos_cotizadorAutos').empty();
        			$('#versiones_cotizadorAutos').empty();
        			$('#anios_cotizadorAutos').empty();
	        	}
	        	
	        }
		});
	});
	function actualizarModelosFasecolda(marca, modelo, codigoFasecolda, anio){
		var path = $("#path").val();
		$("#rtaModelos_cotizadorAutos").html("Cargando");
		var info = {"marca":marca};
		$.ajax({
			type: "POST",
	        url: path + "/ServletModelosMarca",
	        scriptCharset: "utf-8" ,
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        data: info ,
	        success: function(msg)
	        {
	        	$('#modelos_cotizadorAutos').append('<option value="-1">[SELECCIONAR]</option>');
	        	for ( var i = 0; i < msg.length; i++) 
	        	{
	        		var modeloTemp = msg[i];
	        		$('#modelos_cotizadorAutos').append('<option value="' + modeloTemp.id + '">' + modeloTemp.nombre + '</option>');
				}
	        	$("#rtaModelos_cotizadorAutos").html("");
	        	$('#modelos_cotizadorAutos').val(modelo);
	        	actualizarVersiones(marca, modelo, codigoFasecolda, anio);
	        }	
		});
	}
	function actualizarVersiones(marca, modelo, codigoFasecolda, anio){
		var path = $("#path").val();
		var info = {"marca":marca, "modelo":modelo};
		
		$("#rtaVersiones_cotizadorAutos").html("Cargando");
		$.ajax({
			type: "POST",
	        url: path + "/ServletVersionesMarcaModelo",
	        scriptCharset: "utf-8" ,
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        data: info ,
	        success: function(msg)
	        {
	        	
	        	$('#versiones_cotizadorAutos').append('<option value="-1">[SELECCIONAR]</option>');
	        	for ( var i = 0; i < msg.length; i++) 
	        	{
	        		var modelo = msg[i];
	        		$('#versiones_cotizadorAutos').append('<option value="' + modelo.id + '">' + modelo.nombre + '</option>');
	        		
				}
	        	$("#rtaVersiones_cotizadorAutos").html("");
	        	$("#versiones_cotizadorAutos").val(codigoFasecolda);
	        	actualizarAnios(codigoFasecolda, anio);
	        	cargarPerdidas(marca);
	        	cargarPerdidasTotales(marca);
	        }	
		});
	}
	function actualizarAnios(codigoFasecolda, anio)
	{
		var path = $("#path").val();
		var info = {"codigoFasecolda":codigoFasecolda};
		var valor = "";
		$("#rtaAnios_cotizadorAutos").html("Cargando");
		$.ajax({
			type: "POST",
	        url: path + "/ServletAniosCodigo",
	        scriptCharset: "utf-8" ,
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        data: info ,
	        success: function(msg)
	        {
	        	$('#anios_cotizadorAutos').append('<option value="-1">[SELECCIONAR]</option>');
	        	for ( var i = 0; i < msg.length; i++) 
	        	{
	        		var modelo = msg[i];
	        		$('#anios_cotizadorAutos').append('<option value="' + modelo.valor + '">' + modelo.anio + '</option>');
	        		if(modelo.anio == anio)
	        		{
	        			valor =  modelo.valor;
	        		}
				}
	        	$("#rtaAnios_cotizadorAutos").html("");
	        	$('#anios_cotizadorAutos').val(valor);
	        	$('#rtaValorAnios_cotizadorAutos').html(valor);
	        	$('#valorAnios_cotizadorAutos').val(valor);
	        	
	        	
	        }	
		});
	}
	
	function cargarPerdidas(marca){
		var path = $("#path").val();
		$("rtaPerdidaParcial_cotizadorAutos").html("Cargando");
		$('#perdidaParcial_cotizadorAutos').empty();
		var plan = $("#productos_cotizadorAutos").val();
		
		var info = {"marca":marca, "plan":plan};
		$.ajax({
			type: "POST",
	        url: path + "/PerdidaTotalServlet",
	        scriptCharset: "utf-8" ,
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        data: info ,
	        success: function(msg)
	        {
	        	$('#perdidaParcial_cotizadorAutos').append('<option value="-1">[SELECCIONAR]</option>');
	        	for ( var i = 0; i < msg.length; i++) 
	        	{
	        		var modeloTemp = msg[i];
	        		$('#perdidaParcial_cotizadorAutos').append('<option value="' + modeloTemp.id + '">' + modeloTemp.nombre + '</option>');
				}
	        	$("#rtaPerdidaParcial_cotizadorAutos").html("");
	        	
	        	
	        }	
		});
	}
	function cargarPerdidasTotales(marca){
		var path = $("#path").val();
		$("rtaPerdidaTotal_cotizadorAutos").html("Cargando");
		$('#perdidaTotal_cotizadorAutos').empty();
		
		var plan = $("#productos_cotizadorAutos").val();
		
		var info = {"marca":marca, "plan":plan};
		
		$.ajax({
			type: "POST",
	        url: path + "/PerdidaTotalTotalServlet",
	        scriptCharset: "utf-8" ,
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        data: info ,
	        success: function(msg)
	        {
	        	$('#perdidaTotal_cotizadorAutos').append('<option value="-1">[SELECCIONAR]</option>');
	        	for ( var i = 0; i < msg.length; i++) 
	        	{
	        		var modeloTemp = msg[i];
	        		$('#perdidaTotal_cotizadorAutos').append('<option value="' + modeloTemp.id + '">' + modeloTemp.nombre + '</option>');
				}
	        	$("#rtaPerdidaTotal_cotizadorAutos").html("");
	        	
	        	
	        }	
		});
	}
	
});