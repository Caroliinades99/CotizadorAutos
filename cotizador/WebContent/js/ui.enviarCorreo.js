$(document).ready(function() {
	/**** ACCIONES COTIZACION ****/
	$(document).on("click", "#enviarcorreo", function(e){
		e.preventDefault();
		var path = $("#path").val();
		
		var  noCotizacion = $("#varNoCotizacion_cotizacion").val();
		
		// Datos Generales
		var  codigoProducto = $("#varCodigoProducto_cotizacion").val();
		
		var  codigoAgencia = $("#varCodigoAgencia_cotizacion").val();
		var  agencia = $("#varAgencia_cotizacion").val();
		var  producto = $("#varProducto_cotizacion").val();
		// Fechas
		var  diaExpedicion = $("#varDiaExpedicion_cotizacion").val();
		var  mesExpedicion = $("#varMesExpedicion_cotizacion").val();
		var  anioExpedicion = $("#varAnioExpedicion_cotizacion").val();
		var  diaImpresion = $("#varDiaImpresion_cotizacion").val();
		var  mesImpresion = $("#varMesImpresion_cotizacion").val();
		var  anioImpresion = $("#varAnioImpresion_cotizacion").val();
		var  diaDesde = $("#varDiaDesde_cotizacion").val();
		var  mesDesde = $("#varMesDesde_cotizacion").val();
		var  anioDesde = $("#varAnioDesde_cotizacion").val();
		var  diaHasta = $("#varDiaHasta_cotizacion").val();
		var  mesHasta = $("#varMesHasta_cotizacion").val();
		var  anioHasta = $("#varAnioHasta_cotizacion").val();
		// Informacion General -->
		var  tomador = $("#varTomador_cotizacion").val();
		var  direccion = $("#varDireccion_cotizacion").val();
		var  asegurado = $("#varAsegurado_cotizacion").val();
		var  beneficiario = $("#varBeneficiario_cotizacion").val();
		var  correo = $("#varCorreo_cotizacion").val();
		var  documento = $("#varDocumento_cotizacion").val();
		// Informacion  
		var  valorAsegurado = $("#varValorAsegurado_cotizacion").val();
		var  deducible = $("#varDeducible_cotizacion").val();
		var  valorDeducible = $("#varValorDeducible_cotizacion").val();
		var  color = $("#varColor_cotizacion").val();
		var  placa = $("#varPlaca_cotizacion").val();
		var  noChasis = $("#varNoChasis_cotizacion").val();
		var  noMotor = $("#varNoMotor_cotizacion").val();
		var  noSerie = $("#varNoSerie_cotizacion").val();
		
		var  asistenciaViajes = $("#varAsistenciaViajes_cotizacion").val();
		var  asistenciaExtendida = $("#varAsistenciaExtendida_cotizacion").val();
		var  vehiculoReemplazo = $("#varVehiculoReemplazo_cotizacion").val();
		var  gastoTransporte = $("#varGastoTransporte_cotizacion").val();
		var  revisionTecnicomecanica = $("#varRevisionTecnicomecanica_cotizacion").val();
		var  hurtoCartera = $("#varHurto_cotizacion").val();
		//alert(hurtoCartera);
		var  asistenciaJuridica = $("#varAsistenciaJuridia_cotizacion").val();
		
		var  departamento = $("#varDepartamento_cotizacion").val();
		var  limiteRCE = $("#varLimiteRCE_cotizacion").val();
		
		//
		// Nuevos valores
		/*
		 * String fechaNacimientoTomador = request.getParameter("fechaNacimientoTomador");
			String generoTomador = request.getParameter("generoTomador");
			String ocupacionTomador = request.getParameter("ocupacionTomador");
			String mujerCooperativista = request.getParameter("mujerCooperativista");
		 */
		var fechaNacimiento = $("#varFechaNacimiento_cotizacion").val();
		var generoTomador = $("#varGeneroTomador_cotizacion").val();
		var ocupacionTomador = $("#varOcupacionTomador_cotizacion").val();
		var mujerCooperativista = $("#varMujerCooperativista_cotizacion").val();
		
		
		
		// Valores
		var  primaNeta = $("#varPrimaNeta_cotizacion").val();
		var  gastos = $("#varGastos_cotizacion").val();
		var  iva = $("#varIVA_cotizacion").val();
		var  totalPagar = $("#varTotalPagar_cotizacion").val();
		
		
		var cobertura1= $("#varCobertura1_cotizacion").val();
		var cobertura2= $("#varCobertura2_cotizacion").val();
		
		var modelo= $("#varPlaca_cotizacion").val();
		var marca= $("#varMarca_cotizacion").val();
		var placa= $("#varPlaca_cotizacion").val();
		var version= $("#varVersion_cotizacion").val();
		
		var ciudad= $("#varCiudad_cotizacion").val();
//		alert(ciudad);
		
		var info = {"noCotizacion": noCotizacion,
				"codigoProducto":codigoProducto,"codigoAgencia":codigoAgencia,"agencia":agencia,"producto":producto,
				"diaExpedicion":diaExpedicion,"mesExpedicion":mesExpedicion,"anioExpedicion":anioExpedicion,
				"diaImpresion":diaImpresion,"mesImpresion":mesImpresion,"anioImpresion":anioImpresion,
				"diaDesde":diaDesde,"mesDesde":mesDesde,"anioDesde":anioDesde,
				"diaHasta":diaHasta,"mesHasta":mesHasta,"anioHasta":anioHasta,
				"tomador":tomador,"direccion":direccion,"asegurado":asegurado,"beneficiario":beneficiario,"correo":correo,"documento":documento,
				"valorAsegurado":valorAsegurado,"deducible":deducible,"valorDeducible":valorDeducible,"color":color,
				"placa":placa,"modelo":modelo, "marca":marca,"version":version,
				"noChasis":noChasis,"noMotor":noMotor,"noSerie":noSerie,
				"asistenciaViajes":asistenciaViajes,"asistenciaExtendida":asistenciaExtendida,"vehiculoReemplazo":vehiculoReemplazo,
				"gastoTransporte":gastoTransporte,"revisionTecnicomecanica":revisionTecnicomecanica,"hurtoCartera":hurtoCartera,
				"asistenciaJuridica":asistenciaJuridica,
				"primaNeta":primaNeta,"gastos":gastos,"iva":iva,"totalPagar":totalPagar , "cobertura1": cobertura1 , "cobertura2": cobertura2,
				// Nuevos Datos
				"fechaNacimientoTomador":fechaNacimiento,"generoTomador":generoTomador,"ocupacionTomador":ocupacionTomador,"mujerCooperativista":mujerCooperativista,
				"departamento":departamento, "limiteRCE": limiteRCE, "ciudad": ciudad};
		
		$("#dialogoGenerico").dialog({width: 450, modal: false, draggable: false, resizable: false, closeText: 'X', dialogClass: 'modalcoti', closeOnEscape: false});
		$("#dialogoGenerico").html('Enviando Correo ... <br /><br />Le llegar&aacute; a su correo toda la informaci&oacute;n relacionada con la cotizaci&oacute;n solicitada <a id="cerrarDialogo">X</a>');
		
		
		$.ajax({
			type: "POST",
//	        url: "http://dynaco.co:8080/CotizadorWEB/ServletEnviarCorreo",
			 url: path + "/ServletEnviarCorreo",
	        scriptCharset: "utf-8" ,
//	        dataType: 'jsonp',
    		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
	        data: info ,
	        success: function(msg)
	        {
	        	$("#dialogoGenerico").dialog("close");
	        },
	        error: function(msg)
	        {
	        	$("#dialogoGenerico").dialog("close");
	        }
		});
	});
});