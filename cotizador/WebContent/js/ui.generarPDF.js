$(document).ready(function() {
	$(document).on("click", "#printpdf_2", function(e){
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
		var  diaHasta = $("#varDiaDesde_cotizacion").val();
		var  mesHasta = $("#varMesDesde_cotizacion").val();
		var  anioHasta = $("#varAnioDesde_cotizacion").val();
		// Informacion General -->
		var  tomador = $("#varTomador_cotizacion").val();
		var  direccion = $("#varDireccion_cotizacion").val();
		var  asegurado = $("#varAsegurado_cotizacion").val();
		var  beneficiario = $("#varBeneficiario_cotizacion").val();
		var  correo = $("#varCorreo_cotizacion").val();
		var  documento = $("#varDocumento_cotizacion").val();
		// Informacion  
		var  valorAsegurado = $("#varCobertura1_cotizacion").val();
		var  deducible = $("#varCobertura2_cotizacion").val();
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
		var  hurtoCartera = $("#varHurtoCartera_cotizacion").val();
		var  asistenciaJuridica = $("#varAsistenciaJuridia_cotizacion").val();
		
		
		var  cobertura1 = $("#varCobertura1_cotizacion").val();
		var  cobertura2 = $("#varCobertura2_cotizacion").val();
//		alert(cobertura1);
//		alert(cobertura2);
		
		// Valores
		var  primaNeta = $("#varPrimaNeta_cotizacion").val();
		var  gastos = $("#varGastos_cotizacion").val();
		var  iva = $("#varIVA_cotizacion").val();
		var  totalPagar = $("#varTotalPagar_cotizacion").val();
		
		
		
		
		var info = {"noCotizacion": noCotizacion,
					"codigoProducto":codigoProducto,"codigoAgencia":codigoAgencia,"agencia":agencia,"producto":producto,
					"diaExpedicion":diaExpedicion,"mesExpedicion":mesExpedicion,"anioExpedicion":anioExpedicion,
					"diaImpresion":diaImpresion,"mesImpresion":mesImpresion,"anioImpresion":anioImpresion,
					"diaDesde":diaDesde,"mesDesde":mesDesde,"anioDesde":anioDesde,
					"diaHasta":diaHasta,"mesHasta":mesHasta,"anioHasta":anioHasta,
					"tomador":tomador,"direccion":direccion,"asegurado":asegurado,"beneficiario":beneficiario,"correo":correo,"documento":documento,
					"valorAsegurado":valorAsegurado,"deducible":deducible,"valorDeducible":valorDeducible,"color":color,"placa":placa,"noChasis":noChasis,"noMotor":noMotor,"noSerie":noSerie,
					"asistenciaViajes":asistenciaViajes,"asistenciaExtendida":asistenciaExtendida,"vehiculoReemplazo":vehiculoReemplazo,"gastoTransporte":gastoTransporte,"revisionTecnicomecanica":revisionTecnicomecanica,"hurtoCartera":hurtoCartera,"asistenciaJuridica":asistenciaJuridica,
					"primaNeta":primaNeta,"gastos":gastos,"iva":iva,"totalPagar":totalPagar,"cobertura1": cobertura1 , "cobertura2": cobertura2};
		
	    $.post(path + "/ServletGenerarPDF", info, function (data) {
	        //alert(data);
	        var win=window.open('about:blank');
	        with(win.document)
	        {
	            open();
	            write(data);
	            close();
	        }
	    }); 

		//alert(info);
		//window.open(path + "/ServletGenerarPDF?"+ info);
		
	 });
});