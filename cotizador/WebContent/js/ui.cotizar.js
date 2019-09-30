$(document).ready(function() {
	$(document).on("submit", "#cotizar_cotizadorAutos", function(e){
		e.preventDefault();
		var path = $("#path").val();
		
		var producto_selecc = $("#productos_cotizadorAutos").val();
		//
		// Datos Personales
		var nombre = $("#nombre_cotizadorAutos").val();
		var direccion = $("#direccion_cotizadorAutos").val();
		var documentoIdentidad = $("#documentoIdentidad_cotizadorAutos").val();
		var fechaNacimiento = $("#fechaNacimiento_cotizadorAutos").val();
		var genero = $("#genero_cotizadorAutos").val();
		var ocupacion = $("#ocupacion_cotizadorAutos").val();
		var correo = $("#correo_cotizadorAutos").val();
		var mujerCooperativa = $("[name=mujerCooperativa_cotizadorAutos]:checked").val();
		
		//
		// Datos Vehiculo
		var placa = $("#placa_cotizadorAutos").val();
		var marca = $("#marcas_cotizadorAutos").val();
		var modelo = $("#modelos_cotizadorAutos").val();
		var version = $("#versiones_cotizadorAutos").val();
		var anio = $("#anios_cotizadorAutos option:selected").text();
		console.log("anio "+anio);
		var valor = $("#valorAnios_cotizadorAutos").val();
		
		//
		// Datos seguros
		var departamento = $("#departamentos_cotizadorAutos").val();
		var ciudad = $("#ciudades_cotizadorAutos").val();
		var rce = $("#rce_cotizadorAutos").val();
		var perdidaTotal = $("#perdidaTotal_cotizadorAutos").val();
		var perdidaParcial = $("#perdidaParcial_cotizadorAutos").val();
		var buenaExperiencia = $("#buenaExperiencia_cotizadorAutos").val();
		var asistenciaViajes = "SI";
		var vehiculoNuevo = $("[name=vehiculoNuevo_cotizadorAutos]:checked").val();
		var vehiculoReemplazo = "01";
		var gastosTransporte = "SI";
		var revisionTecnicomecanica = "SI";
		var asistenciaExtendida = $("#asistenciaExtendida_cotizadorAutos").val();
		var hurtoCartera = $("#hurtoCartera_cotizadorAutos").val();
		var asistenciaJuridica = "SI";
		var captcha = $('#captcha_cotizadorAutos').val();
		var color = $('#color_cotizadorAutos').val();
		var rotura= $('#roturaMecanica_cotizadorAutos').val();
		
		validaCaptcha(path, captcha, nombre, direccion, documentoIdentidad, fechaNacimiento, genero, ocupacion, mujerCooperativa,
				placa, marca, modelo, version, anio, valor,
				departamento, ciudad, rce, buenaExperiencia, asistenciaViajes, asistenciaExtendida, vehiculoReemplazo, 
				gastosTransporte, revisionTecnicomecanica, hurtoCartera, asistenciaJuridica, color, correo, perdidaParcial, perdidaTotal, vehiculoNuevo, 
				departamento, ciudad, producto_selecc,rotura);
		
	});
	
	
	function cotizar(path, nombre, direccion, documentoIdentidad, fechaNacimiento, genero, ocupacion, mujerCooperativa,
						placa, marca, modelo, version, anio, valor,
						departamento, ciudad, rce, buenaExperiencia, asistenciaViajes, asistenciaExtendida, vehiculoReemplazo, 
						gastosTransporte, revisionTecnicomecanica, hurtoCartera, asistenciaJuridica, color, correo, perdidaParcial, perdidaTotal, vehiculoNuevo, 
						departamento, ciudad, producto_selecc,rotura)
	{
		
		var info = {"nombre": nombre, "direccion":direccion, "documentoIdentidad":documentoIdentidad, "fechaNacimiento":fechaNacimiento, "genero":genero, "ocupacion":ocupacion, "mujerCooperativa":mujerCooperativa,
				"placa": placa, "marca":marca, "modelo":modelo, "version":version, "anio":anio, "valor":valor,
				"departamento": departamento, "ciudad":ciudad, "rce":rce, "buenaExperiencia":buenaExperiencia, "asistenciaViajes":asistenciaViajes, "asistenciaExtendida":asistenciaExtendida, "vehiculoReemplazo":vehiculoReemplazo,
				"gastosTransporte": gastosTransporte, "revisionTecnicomecanica":revisionTecnicomecanica, "hurtoCartera":hurtoCartera, "asistenciaJuridica":asistenciaJuridica, "correo": correo, "color": color,
				"perdidaParcial": perdidaParcial, "perdidaTotal":perdidaTotal, "vehiculoNuevo":vehiculoNuevo,"productoSelecc":producto_selecc,"rotura":rotura};
		$("#dialogoGenerico").dialog({width: 450, modal: false, draggable: false, resizable: false, closeText: 'X', dialogClass: 'modalcoti', closeOnEscape: false});
		$("#dialogoGenerico").html('<img src="images/cargando.gif" width="200" height="200" alt="Cargando" />  <a id="cerrarDialogo">X</a>');
		$.ajax({
			type: "POST",
	        url: path + "/cotizacion.jsp",
	        scriptCharset: "utf-8" ,
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        data: info ,
	        success: function(msg)
	        {
	        	$("#panelCotizacion").html(msg);
	        	$.ajax({
					type: "POST",
			        url: path + "/ServletCotizacion",
			        scriptCharset: "utf-8" ,
		    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
			        data: info,
			        success: function(msg)
			        {
			        	var tablaHTML = "";
			        	var coberturas = msg.cobertura1;
			        	for( var i = 0; i < coberturas.length;i++){
			        		var jconertura = coberturas[i];
			        		tablaHTML += 	"<tr>" +
			        							"<td>" + jconertura.descripcion + "</td>" +
			        							"<td>" + jconertura.valor1 + "</td>" +
			        							"<td>" + jconertura.valor2 + "</td>" +
			        							"<td>" + jconertura.valor3 + "</td>" +
			        							"<td>" + jconertura.valor4 + "</td>" +
			        						"</tr>";
			        	}
			        	var cober = "<table id = 'tabla_coberturas' style='height: 350; width: 100%; font-size: 7px; padding: 0; border: 0;'>" + tablaHTML + "</table>";
			        	$('#tabla_coberturas').append(tablaHTML);
			        	//
			        	// Impresi�n de datos
			        	$("#noCotizacion_cotizacion").html(msg.noCotizacion);
			        	$("#varNoCotizacion_cotizacion").val(msg.noCotizacion);
			        	$("#noCotizacion").val(msg.noCotizacion);
			        	/* Datos Generales */
			        	$("#codigoProducto_cotizacion").html(msg.codigoProducto);
			        	
			        	$("#codigoAgencia_cotizacion").html(msg.codigoAgencia);
			        	$("#agencia_cotizacion").html(msg.agencia);
			        	$("#producto_cotizacion").html(msg.producto);
			        	$("#codigoAgencia_cotizacion").html(msg.codigoAgencia);

			        	$("#varCodigoProducto_cotizacion").val(msg.codigoProducto);
			        	
			        	$("#varCodigoAgencia_cotizacion").val(msg.codigoAgencia);
			        	$("#varAgencia_cotizacion").val(msg.agencia);
			        	$("#producto_cotizacion").val(msg.producto);
			        	$("#varProducto_cotizacion").val(msg.producto);
			        	$("#varCodigoAgencia_cotizacion").val(msg.codigoAgencia);

			        	$("#codigo").val(msg.codigoProducto);
			        	$("#codigoAgencia").val(msg.codigoAgencia);
			        	$("#agencia").val(msg.agencia);
			        	$("#producto").val(msg.producto);
			        	
			        	

			        	
			        	//
			        	// Fechas
			        	$("#diaExpedicion_cotizacion").html(msg.diaFechaCotizacion);
			        	$("#mesExpedicion_cotizacion").html(msg.mesFechaCotizacion);
			        	$("#anioExpedicion_cotizacion").html(msg.anioFechaCotizacion);
			        	$("#diaImpresion_cotizacion").html(msg.diaFechaImpresion);
			        	$("#mesImpresion_cotizacion").html(msg.mesFechaImpresion);
			        	$("#anioImpresion_cotizacion").html(msg.anioFechaImpresion);
			        	$("#diaDesde_cotizacion").html(msg.diaFechaCotizacion);
			        	$("#mesDesde_cotizacion").html(msg.mesFechaCotizacion);
			        	$("#anioDesde_cotizacion").html(msg.anioFechaCotizacion);
			        	$("#diaHasta_cotizacion").html(msg.diaFechaHasta);
			        	$("#mesHasta_cotizacion").html(msg.mesFechaHasta);
			        	$("#anioHasta_cotizacion").html(msg.anioFechaHasta);
			        	
			        	$("#varDiaExpedicion_cotizacion").val(msg.diaFechaCotizacion);
			        	$("#varMesExpedicion_cotizacion").val(msg.mesFechaCotizacion);
			        	$("#varAnioExpedicion_cotizacion").val(msg.anioFechaCotizacion);
			        	$("#varDiaImpresion_cotizacion").val(msg.diaFechaImpresion);
			        	$("#varMesImpresion_cotizacion").val(msg.mesFechaImpresion);
			        	$("#varAnioImpresion_cotizacion").val(msg.anioFechaImpresion);
			        	$("#varDiaDesde_cotizacion").val(msg.diaFechaCotizacion);
			        	$("#varMesDesde_cotizacion").val(msg.mesFechaCotizacion);
			        	$("#varAnioDesde_cotizacion").val(msg.anioFechaCotizacion);
			        	$("#varDiaHasta_cotizacion").val(msg.diaFechaHasta);
			        	$("#varMesHasta_cotizacion").val(msg.mesFechaHasta);
			        	$("#varAnioHasta_cotizacion").val(msg.anioFechaHasta);
			        	
			        	$("#diaExpedicion").val(msg.diaFechaCotizacion);
			        	$("#mesExpedicion").val(msg.mesFechaCotizacion);
			        	$("#anioExpedicion").val(msg.anioFechaCotizacion);
			        	$("#diaImpresion").val(msg.diaFechaImpresion);
			        	$("#mesImpresion").val(msg.mesFechaImpresion);
			        	$("#anioImpresion").val(msg.anioFechaImpresion);
			        	$("#diaDesde").val(msg.diaFechaCotizacion);
			        	$("#mesDesde").val(msg.mesFechaCotizacion);
			        	$("#anioDesde").val(msg.anioFechaCotizacion);
			        	$("#diaHasta").val(msg.diaFechaHasta);
			        	$("#mesHasta").val(msg.mesFechaHasta);
			        	$("#anioHasta").val(msg.anioFechaHasta);
			        	
			        	//
			        	// Informacion General
			        	$("#tomador_cotizacion").html(msg.tomador);
			        	$("#direccion_cotizacion").html(msg.direccion);
			        	$("#asegurado_cotizacion").html(msg.asegurado);
			        	$("#beneficiario_cotizacion").html(msg.beneficiario);
			        	$("#correo_cotizacion").html(msg.correo);
			        	$("#documento_cotizacion").html(msg.nit);
			        	
			        	$("#varTomador_cotizacion").val(msg.tomador);
			        	$("#varDireccion_cotizacion").val(msg.direccion);
			        	$("#varAsegurado_cotizacion").val(msg.asegurado);
			        	$("#varBeneficiario_cotizacion").val(msg.beneficiario);
			        	$("#varCorreo_cotizacion").val(msg.correo);
			        	$("#varDocumento_cotizacion").val(msg.nit);
			        	
			        	$("#tomadoto").val(msg.tomador);
			        	$("#direccion").val(msg.direccion);
			        	$("#asegurado").val(msg.asegurado);
			        	$("#beneficiario").val(msg.beneficiario);
			        	$("#correo").val(msg.correo);
			        	$("#documento").val(msg.nit);
			        	//
			        	// Informaci�n
			        	$("#cobertura1").html(msg.cobertura1);
			        	$("#cobertura2").html(msg.cobertura2);
			        	
			        	$("#varCobertura1_cotizacion").val(msg.cobertura1);
			        	$("#varCobertura2_cotizacion").val(msg.cobertura2);
			        	
			        	$("#cobertura1_pdf").val(msg.cobertura1);
			        	$("#cobertura2_pdf").val(msg.cobertura2);
			        	
			        	//
			        	// Pagos
			        	$("#primaNeta_cotizacion").html(msg.primaNeta);
			        	$("#gastos_cotizacion").html(msg.gastos);
			        	$("#iva_cotizacion").html(msg.iva);
			        	$("#totalPagar_cotizacion").html(msg.totalPagar);
			        	
			        	$("#varPrimaNeta_cotizacion").val(msg.primaNeta);
			        	$("#varGastos_cotizacion").val(msg.gastos);
			        	$("#varIVA_cotizacion").val(msg.iva);
			        	$("#varTotalPagar_cotizacion").val(msg.totalPagar);
			        	
			        	$("#primaNeta").val(msg.primaNeta);
			        	$("#gastos").val(msg.gastos);
			        	$("#iva").val(msg.iva);
			        	$("#totalPagar").val(msg.totalPagar);
			        	
			        	
			        	$("#varFechaNacimiento_cotizacion").val(msg.fechaNacimientoTomador);
			        	$("#varGeneroTomador_cotizacion").val(msg.generoTomador);
			        	$("#varOcupacionTomador_cotizacion").val(msg.ocupacion);
			        	$("#varMujerCooperativista_cotizacion").val(msg.mujerCooperativista);
			        	$("#fechaNacimientoTomador_cotizacion").val(msg.fechaNacimientoTomador);
			        	$("#generoTomador_cotizacion").val(msg.generoTomador);
			        	$("#ocupacionTomador_cotizacion").val(msg.ocupacion);
			        	$("#mujerCooperativista_cotizacion").val(msg.mujerCooperativista);
			        	
			        	
			        	
			        	$("#vehiculoNuevo_cotizacion").val(vehiculoNuevo);
			        	$("#varVehiculoNuevo_cotizacion").val(vehiculoNuevo);
			        	$("#modelo_cotizacion").val(modelo);
			        	$("#varModelo_cotizacion").val(modelo);
			        	$("#marca_cotizacion").val(marca);
			        	$("#varMarca_cotizacion").val(marca);
			        	$("#version_cotizacion").val(version);
			        	$("#varVersion_cotizacion").val(version);
			        	$("#valor_cotizacion").val(valor);
			        	$("#varValor_cotizacion").val(valor);
			        	$("#anio_cotizacion").val(anio);
			        	$("#varAnio_cotizacion").val(anio);
			        	$("#placa_cotizacion").val(placa);
			        	$("#varPlaca_cotizacion").val(placa);
			        	
			        	$("#departamento_cotizacion").val(departamento);
			        	$("#ciudad_cotizacion").val(ciudad);
			        	$("#varDepartamento_cotizacion").val(departamento);
			        	$("#varCiudad_cotizacion").val(ciudad);
			        	$("#limiteRCE_cotizacion").val(rce);
			        	$("#varLimiteRCE_cotizacion").val(rce);
			        	
			        	$("#hurto_cotizacion").val(hurtoCartera);
			        	$("#varHurto_cotizacion").val(hurtoCartera);
			        	
			        	$("#rotura_cotizacion").val(rotura);
			        	$("#varRotura_cotizacion").val(rotura);
			        	
			        	$("#varAsistencia_cotizacion").val(asistenciaExtendida);
			        	$("#asistenciaExt_cotizacion").val(asistenciaExtendida);
			        	
//			        	alert(valor + " --- " + marca);
			        	
			        	$("#dialogoGenerico").dialog("close");
			        	
			        	
			        	
			        	
			        	
			        }	
				});
	        	
	        }	
		});
	}
	//
	// Validaci�n de datos
	$(document).on("keyup", "#placa_cotizadorAutos", function(e){
		var texto = $(this).val();
		if(texto.length > 6)
		{
			texto =  texto.substring(0,6)
		}
		$(this).val( texto.toUpperCase() );
		
	});
	
	$(document).on("click", "#cerrarDialogo", function(e){
		e.preventDefault();
		$("#dialogoGenerico").dialog("close");
	});
	function validaCaptcha(path, captcha, nombre, direccion, documentoIdentidad, fechaNacimiento, genero, ocupacion, mujerCooperativa,
			placa, marca, modelo, version, anio, valor,
			departamento, ciudad, rce, buenaExperiencia, asistenciaViajes, asistenciaExtendida, vehiculoReemplazo, 
			gastosTransporte, revisionTecnicomecanica, hurtoCartera, asistenciaJuridica, color, correo, perdidaParcial, perdidaTotal, vehiculoNuevo,
			departamento, ciudad, producto_selecc,rotura)
	{
		//alert(captcha);
		$.ajax({
			type: "GET",
	        url: path + "/ServletTextoCaptcha",
	        scriptCharset: "utf-8" ,
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        data: "" ,
	        success: function(msg)
	        {
	        	var captchaCorrecto = true;
	        	
	        	if(captcha != msg.captcha){
	        		
	        		captchaCorrecto = false;
	        		$("#imagenCaptcha_cotizadorAutos").attr("src", path + "/ServletImagenCaptcha");
	        		$("#lblCaptcha_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
	        	}else{
	        	//	alert("por dos");
	        		$("#lblCaptcha_cotizadorAutos").parent().css({ 'background': 'transparent'});
	        	}
	        	
	        	var datosCorrectos = validarDatos(nombre, direccion, documentoIdentidad, fechaNacimiento, genero, ocupacion, mujerCooperativa,
												placa, marca, modelo, version, anio, valor,
												departamento, ciudad, rce, buenaExperiencia, asistenciaViajes, asistenciaExtendida, vehiculoReemplazo, 
												gastosTransporte, revisionTecnicomecanica, hurtoCartera, asistenciaJuridica, color, correo, 
												perdidaParcial, perdidaTotal, vehiculoNuevo,
												departamento, ciudad, producto_selecc,rotura);
	        	
	        	if( captchaCorrecto && datosCorrectos)
	        	{
	        		
	        		cotizar(path, nombre, direccion, documentoIdentidad, fechaNacimiento, genero, ocupacion, mujerCooperativa,
							placa, marca, modelo, version, anio, valor,
							departamento, ciudad, rce, buenaExperiencia, asistenciaViajes, asistenciaExtendida, vehiculoReemplazo, 
							gastosTransporte, revisionTecnicomecanica, hurtoCartera, asistenciaJuridica, color, correo, perdidaParcial, perdidaTotal, vehiculoNuevo, 
							departamento, ciudad,producto_selecc,rotura);
	        	}
	        }
		});
	}
	function validarDatos(nombre, direccion, documentoIdentidad, fechaNacimiento, genero, ocupacion, mujerCooperativa,
						placa, marca, modelo, version, anio, valor,
						departamento, ciudad, rce, buenaExperiencia, asistenciaViajes, asistenciaExtendida, vehiculoReemplazo, 
						gastosTransporte, revisionTecnicomecanica, hurtoCartera, asistenciaJuridica, color, correo, perdidaParcial, perdidaTotal, vehiculoNuevo,
						departamento, ciudad, producto_selecc,rotura){
		var correcto = true;
		
		
		if(producto_selecc == "" || producto_selecc == "-1"){
			$("#lblTipoProducto_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblTipoProducto_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(perdidaTotal == "" || perdidaTotal=="-1"){
			$("#lblPerdidaTotal_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblPerdidaTotal_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		// Datos Personales
		if(correo == ""){
			$("#lblCorreo_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblCorreo_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(color == ""){
			$("#lblColor_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblColor_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(documentoIdentidad == ""){
			$("#lblDocumentoIdentidad_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblDocumentoIdentidad_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(fechaNacimiento == ""){
			$("#lblFechaNacimiento_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblFechaNacimiento_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(genero == null){
			$("#lblGenero_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblGenero_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(ocupacion == "-1"){
			$("#lblOcupacion_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblOcupacion_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(mujerCooperativa == null){
			$("#lblMujerCooperativa_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblMujerCooperativa_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		//
		// Datos Veh�culos
		if(vehiculoNuevo == 'NO'){
			if(placa == ""){
				$("#lblPlaca_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
				correcto = false;
			}else{
				$("#lblPlaca_cotizadorAutos").parent().css({ 'background': 'transparent'});
			}
			if(marca == "-1"){
				$("#lblMarcas_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
				correcto = false;
			}else{
				$("#lblMarcas_cotizadorAutos").parent().css({ 'background': 'transparent'});
			}
			if(modelo == "-1" || modelo == null || modelo == ""){
				$("#lblModelos_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
				correcto = false;
			}else{
				$("#lblModelos_cotizadorAutos").parent().css({ 'background': 'transparent'});
			}
			if(version == "-1" || version == null || version == ""){
				$("#lblVersion_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
				correcto = false;
			}else{
				$("#lblVersion_cotizadorAutos").parent().css({ 'background': 'transparent'});
			}
			if(anio == "-1" || anio == null || anio == ""){
				$("#lblAnio_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
				correcto = false;
			}else{
				$("#lblAnio_cotizadorAutos").parent().css({ 'background': 'transparent'});
			}
		}
		if(valor == "" || valor == null || valor == ""){
			$("#lblValor_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblValor_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		
		//
		// Datos Seguro
//		departamento, ciudad, rce, buenaExperiencia, asistenciaViajes, asistenciaExtendida, vehiculoReemplazo, 

		if(departamento == "-1"){
			$("#lblDepartamentos_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblDepartamentos_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(ciudad == "-1" || ciudad == null || ciudad == ""){
			$("#lblCiudades_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblCiudades_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(rce == "-1"){
			$("#lblRCE_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblRCE_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(buenaExperiencia == "-1"){
			$("#lblBuenaExperiencia_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblBuenaExperiencia_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(asistenciaViajes == null){
			$("#lblAsistenciaViajes_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblAsistenciaViajes_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(asistenciaExtendida == null){
			$("#lblAsistenciaExtendida_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblAsistenciaExtendida_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(vehiculoReemplazo == null){
			$("#lblVehiculoReemplazo_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblVehiculoReemplazo_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
//		gastosTransporte, revisionTecnicomecanica, hurtoCartera, asistenciaJuridica
		if(gastosTransporte == null){
			$("#lblGastosTransporte_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblGastosTransporte_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(revisionTecnicomecanica == null){
			$("#lblRevisionTecnicomecanica_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblRevisionTecnicomecanica_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(hurtoCartera == null){
			$("#lblHurtoCartera_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblHurtoCartera_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		if(asistenciaJuridica == null){
			$("#lblAsistenciaJuridica_cotizadorAutos").parent().css({ 'background': '#7BD49A'});
			correcto = false;
		}else{
			$("#lblAsistenciaJuridica_cotizadorAutos").parent().css({ 'background': 'transparent'});
		}
		return correcto;
	}
	
	
	
});