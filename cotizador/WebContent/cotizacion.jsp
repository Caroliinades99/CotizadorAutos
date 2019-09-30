<!-- <!DOCTYPE HTML PUBLIC <"-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!-- <html xmlns="http://www.w3.org/1999/xhtml"> -->
<!-- 	<head> -->
<!-- 		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
<!-- 		<title>Cotizador - Equidad Seguros</title> -->

<!-- 		<link href="css/custom.css" type="text/css" rel="stylesheet" /> -->

<!-- 	</head> -->
<!-- 	<body> -->
<div class="med">


	<input type="hidden" id="varNoCotizacion_cotizacion" />
	<!-- 	Datos Generales -->
	<input type="hidden" id="varCodigoProducto_cotizacion" /> <input
		type="hidden" id="varCodigoAgencia_cotizacion" /> <input type="hidden"
		id="varAgencia_cotizacion" /> <input type="hidden"
		id="varProducto_cotizacion" />
	<!-- 	Fechas -->
	<input type="hidden" id="varDiaExpedicion_cotizacion" /> <input
		type="hidden" id="varMesExpedicion_cotizacion" /> <input type="hidden"
		id="varAnioExpedicion_cotizacion" /> <input type="hidden"
		id="varDiaImpresion_cotizacion" /> <input type="hidden"
		id="varMesImpresion_cotizacion" /> <input type="hidden"
		id="varAnioImpresion_cotizacion" /> <input type="hidden"
		id="varDiaDesde_cotizacion" /> <input type="hidden"
		id="varMesDesde_cotizacion" /> <input type="hidden"
		id="varAnioDesde_cotizacion" /> <input type="hidden"
		id="varDiaHasta_cotizacion" /> <input type="hidden"
		id="varMesHasta_cotizacion" /> <input type="hidden"
		id="varAnioHasta_cotizacion" />
	<!-- 	Informacion General -->
	<input type="hidden" id="varTomador_cotizacion" /> <input type="hidden"
		id="varDireccion_cotizacion" /> <input type="hidden"
		id="varAsegurado_cotizacion" /> <input type="hidden"
		id="varBeneficiario_cotizacion" /> <input type="hidden"
		id="varCorreo_cotizacion" /> <input type="hidden"
		id="varDocumento_cotizacion" />
	<!-- 	Informacion General -->
	<input type="hidden" id="varCobertura1_cotizacion" /> <input
		type="hidden" id="varCobertura2_cotizacion" /> <input type="hidden"
		id="varPrimaNeta_cotizacion" /> <input type="hidden"
		id="varIVA_cotizacion" /> <input type="hidden"
		id="varTotalPagar_cotizacion" /> <input type="hidden"
		id="varFechaNacimiento_cotizacion" /> <input type="hidden"
		id="varGeneroTomador_cotizacion" /> <input type="hidden"
		id="varOcupacionTomador_cotizacion" /> <input type="hidden"
		id="varMujerCooperativista_cotizacion" /> <input type="hidden"
		id="varVehiculoNuevo_cotizacion" /> <input type="hidden"
		id="varPlaca_cotizacion" /> <input type="hidden"
		id="varModelo_cotizacion" /> <input type="hidden"
		id="varMarca_cotizacion" /> <input type="hidden"
		id="varVersion_cotizacion" /> <input type="hidden"
		id="varValor_cotizacion" /> <input type="hidden"
		id="varAnio_cotizacion" /> <input type="hidden"
		id="varDepartamento_cotizacion" /> <input type="hidden"
		id="varCiudad_cotizacion" /> <input type="hidden"
		id="varLimiteRCE_cotizacion" /> <input type="hidden"
		id="varHurto_cotizacion" /> <input type="hidden"
		id="varAsistencia_cotizacion" />
	<!-- 
	var fechaNacimiento = $("#").val();
		var generoTomador = $("#").val();
		var ocupacionTomador = $("#").val();
		var mujerCooperativista = $("#").val();
	 -->
	<div class="action">
		<form action="<%=request.getContextPath()%>/ServletGenerarPDF"
			target="_blank" method="post">
			<input type="hidden" id="varNoCotizacion_cotizacion" />
			<!-- 	Datos Generales -->
			<input type="hidden" id="producto" name="producto" /> <input
				type="hidden" id="codigoProducto" name="codigoProducto" /> <input
				type="hidden" id="codigoAgencia" name="codigoAgencia" /> <input
				type="hidden" id="agencia" name="agencia" /> <input type="hidden"
				id="noCotizacion" name="noCotizacion" />
			<!-- 	Fechas -->
			<input type="hidden" id="diaExpedicion" name="diaExpedicion" /> <input
				type="hidden" id="mesExpedicion" name="mesExpedicion" /> <input
				type="hidden" id="anioExpedicion" name="anioExpedicion" /> <input
				type="hidden" id="diaImpresion" name="diaImpresion" /> <input
				type="hidden" id="mesImpresion" name="mesImpresion" /> <input
				type="hidden" id="anioImpresion" name="anioImpresion" /> <input
				type="hidden" id="diaDesde" name="diaDesde" /> <input type="hidden"
				id="mesDesde" name="mesDesde" /> <input type="hidden" id="anioDesde"
				name="anioDesde" /> <input type="hidden" id="diaHasta"
				name="diaHasta" /> <input type="hidden" id="mesHasta"
				name="mesHasta" /> <input type="hidden" id="anioHasta"
				name="anioHasta" />
			<!-- 	Informacion General -->
			<input type="hidden" id="tomador" name="tomador" /> <input
				type="hidden" id="direccion" name="direccion" /> <input
				type="hidden" id="asegurado" name="asegurado" /> <input
				type="hidden" id="beneficiario" name="beneficiario" /> <input
				type="hidden" id="correo" name="correo" /> <input type="hidden"
				id="documento" name="documento" />
			<!-- 	Informacion General -->
			<input type="hidden" id="cobertura1_pdf" name="cobertura1_pdf" /> <input
				type="hidden" id="cobertura2_pdf" name="cobertura2_pdf" /> <input
				type="hidden" id="primaNeta" name="primaNeta" /> <input
				type="hidden" id="iva" name="iva" /> <input type="hidden"
				id="totalPagar" name="totalPagar" /> <input type="hidden"
				id="fechaNacimientoTomador_cotizacion"
				name="fechaNacimientoTomador_cotizacion" /> <input type="hidden"
				id="generoTomador_cotizacion" name="generoTomador_cotizacion" /> <input
				type="hidden" id="ocupacionTomador_cotizacion"
				name="ocupacionTomador_cotizacion" /> <input type="hidden"
				id="mujerCooperativista_cotizacion"
				name="mujerCooperativista_cotizacion" /> <input type="hidden"
				id="placa_cotizacion" name="placa_cotizacion" /> <input
				type="hidden" id="vehiculoNuevo_cotizacion"
				name="vehiculoNuevo_cotizacion" /> <input type="hidden"
				id="marca_cotizacion" name="marca_cotizacion" /> <input
				type="hidden" id="modelo_cotizacion" name="modelo_cotizacion" /> <input
				type="hidden" id="anio_cotizacion" name="anio_cotizacion" /> <input
				type="hidden" id="version_cotizacion" name="version_cotizacion" /> <input
				type="hidden" id="departamento_cotizacion"
				name="departamento_cotizacion" /> <input type="hidden"
				id="ciudad_cotizacion" name="ciudad_cotizacion" /> <input
				type="hidden" id="limiteRCE_cotizacion" name="limiteRCE_cotizacion" />
			<input type="hidden" id="asistenciaExt_cotizacion"
				name="asistenciaExt_cotizacion" /> <input type="hidden"
				id="hurto_cotizacion" name="hurto_cotizacion" /> <input
				type="hidden" id="departamento_cotizacion"
				name="departamento_cotizacion" /> <input type="hidden"
				id="ciudad_cotizacion" name="ciudad_cotizacion" /> <input
				type="hidden" id="valor_cotizacion" name="valor_cotizacion" /> <input
				type="submit" id="printpdf" value="Imprimir PDF" />
			<!-- a href="#" id="enviarcorreo">Enviar correo</a-->
		</form>
		<form action="<%=request.getContextPath()%>/ServletEnviarCorreo"
			target="_blank" method="post">
			<input type="hidden" id="varNoCotizacion_cotizacion" />
			<!-- 	Datos Generales -->
			<input type="hidden" id="producto" name="producto" /> <input
				type="hidden" id="codigoAgencia" name="codigoAgencia" /> <input
				type="hidden" id="agencia" name="agencia" /> <input type="hidden"
				id="noCotizacion" name="noCotizacion" />
			<!-- 	Fechas -->
			<input type="hidden" id="diaExpedicion" name="diaExpedicion" /> <input
				type="hidden" id="mesExpedicion" name="mesExpedicion" /> <input
				type="hidden" id="anioExpedicion" name="anioExpedicion" /> <input
				type="hidden" id="diaImpresion" name="diaImpresion" /> <input
				type="hidden" id="mesImpresion" name="mesImpresion" /> <input
				type="hidden" id="anioImpresion" name="anioImpresion" /> <input
				type="hidden" id="diaDesde" name="diaDesde" /> <input type="hidden"
				id="mesDesde" name="mesDesde" /> <input type="hidden" id="anioDesde"
				name="anioDesde" /> <input type="hidden" id="diaHasta"
				name="diaHasta" /> <input type="hidden" id="mesHasta"
				name="mesHasta" /> <input type="hidden" id="anioHasta"
				name="anioHasta" />
			<!-- 	Informacion General -->
			<input type="hidden" id="tomador" name="tomador" /> <input
				type="hidden" id="direccion" name="direccion" /> <input
				type="hidden" id="asegurado" name="asegurado" /> <input
				type="hidden" id="beneficiario" name="beneficiario" /> <input
				type="hidden" id="correo" name="correo" /> <input type="hidden"
				id="documento" name="documento" />
			<!-- 	Informacion General -->
			<input type="hidden" id="cobertura1_pdf" name="cobertura1_pdf" /> <input
				type="hidden" id="cobertura2_pdf" name="cobertura2_pdf" /> <input
				type="hidden" id="primaNeta" name="primaNeta" /> <input
				type="hidden" id="iva" name="iva" /> <input type="hidden"
				id="totalPagar" name="totalPagar" /> <input type="hidden"
				id="fechaNacimientoTomador_cotizacion"
				name="fechaNacimientoTomador_cotizacion" /> <input type="hidden"
				id="generoTomador_cotizacion" name="generoTomador_cotizacion" /> <input
				type="hidden" id="ocupacionTomador_cotizacion"
				name="ocupacionTomador_cotizacion" /> <input type="hidden"
				id="mujerCooperativista_cotizacion"
				name="mujerCooperativista_cotizacion" /> <input type="hidden"
				id="placa_cotizacion" name="placa_cotizacion" /> <input
				type="hidden" id="vehiculoNuevo_cotizacion"
				name="vehiculoNuevo_cotizacion" /> <input type="hidden"
				id="marca_cotizacion" name="marca_cotizacion" /> <input
				type="hidden" id="modelo_cotizacion" name="modelo_cotizacion" /> <input
				type="hidden" id="anio_cotizacion" name="anio_cotizacion" /> <input
				type="hidden" id="version_cotizacion" name="version_cotizacion" /> <input
				type="hidden" id="departamento_cotizacion"
				name="departamento_cotizacion" /> <input type="hidden"
				id="ciudad_cotizacion" name="ciudad_cotizacion" /> <input
				type="hidden" id="limiteRCE_cotizacion" name="limiteRCE_cotizacion" />
			<input type="hidden" id="asistenciaExt_cotizacion"
				name="asistenciaExt_cotizacion" /> <input type="hidden"
				id="hurto_cotizacion" name="hurto_cotizacion" /> <input
				type="hidden" id="departamento_cotizacion"
				name="departamento_cotizacion" /> <input type="hidden"
				id="ciudad_cotizacion" name="ciudad_cotizacion" /> <input
				type="hidden" id="valor_cotizacion" name="valor_cotizacion" /> <input
				type="submit" id="enviarcorreo" value="Enviar correo" />
		</form>
	</div>

</div>

<table id="Table_01" width="609" height="789" border="0" cellpadding="0"
	cellspacing="0"
	style="font-family: 'Trebuchet MS', Helvetica, sans-serif; color: black; background-image: url(images/fondo.png);">
	<tr>
		<td colspan="30" style="font-size: 0px; line-height: 0px;"><img
			src="images/header.png" width="617" height="130" alt=""></td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"><img
			src="images/flecha.png" width="28" height="14" alt=""></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"><img
			src="images/nocotizacion.png" width="92" height="14" alt=""></td>
		<td colspan="6" width="138" height="13"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="noCotizacion_cotizacion">COD</td>
		<td width="28" height="14" style="font-size: 0px; line-height: 0px;">
			<img src="images/flecha.png" width="28" height="14" alt="">
		</td>
		<td colspan="6" style="font-size: 0px; line-height: 0px;"><img
			src="images/cproducto.png" width="92" height="14" alt=""></td>
		<td colspan="8" width="127" height="13"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="codigoProducto_cotizacion">789456456</td>
		<td colspan="5" rowspan="3" style="font-size: 0px; line-height: 0px;">
			<img src="images/car.png" width="106" height="40" alt="">
		</td>

	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"><img
			src="images/flecha.png" width="28" height="14" alt=""></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"><img
			src="images/producto.png" width="92" height="14" alt=""></td>
		<td colspan="6" width="138" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="producto_cotizacion">PRODUCTO</td>
		<td width="28" height="14" style="font-size: 0px; line-height: 0px;">
			<img src="images/flecha.png" width="28" height="14" alt="">
		</td>
		<td width="1" height="14" style="font-size: 0px; line-height: 0px;">
		</td>
		<td colspan="5" style="font-size: 0px; line-height: 0px;"><img
			src="images/direccion.png" width="92" height="14" alt=""></td>
		<td colspan="8" width="127" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="direccion_cotizacion"></td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"><img
			src="images/flecha.png" width="28" height="14" alt=""></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"><img
			src="images/cagencia.png" width="92" height="14" alt=""></td>
		<td colspan="6" width="138" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="codigoAgencia_cotizacion">69852347</td>
		<td width="28" height="14" style="font-size: 0px; line-height: 0px;">
		</td>
		<td colspan="6" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="8" width="127" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;">

		</td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"><img
			src="images/flecha.png" width="28" height="14" alt=""></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"><img
			src="images/agencia.png" width="92" height="14" alt=""></td>
		<td colspan="6" width="138" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="agencia_cotizacion">Equidad</td>
		<td colspan="20" width="325" height="14"
			style="font-size: 0px; line-height: 0px;"></td>
	</tr>
	<tr>
		<td colspan="29" style="font-size: 0px; line-height: 0px;"><img
			src="images/fechas.png" width="617" height="34" alt=""></td>
		<!-- BANNER -->
	</tr>
	<tr>
		<td colspan="2" rowspan="3" style="font-size: 0px; line-height: 0px;">
		</td>
		<td colspan="2" rowspan="3" width="111" height="24"
			style="font-size: 18px; line-height: 16px; overflow: hidden; text-align: center;">
			<span id="diaExpedicion_cotizacion">03</span> <span
			id="mesExpedicion_cotizacion">03</span> <span
			id="anioExpedicion_cotizacion">2014</span>
		</td>
		<td colspan="2" rowspan="3" style="font-size: 0px; line-height: 0px;">
			<img src="images/desde.png" alt="" width="60" height="30">
		</td>
		<td width="47" height="10"
			style="font-size: 11px; line-height: 10px; overflow: hidden; text-align: center;"
			id="diaDesde_cotizacion">11</td>
		<td rowspan="3"
			style="font-size: 0px; line-height: 0px; background-color: rgb(0, 161, 58);">
		</td>
		<td colspan="5" width="49" height="10"
			style="font-size: 11px; line-height: 10px; overflow: hidden; text-align: center;"
			id="mesDesde_cotizacion">03</td>
		<td rowspan="3"
			style="font-size: 0px; line-height: 0px; background-color: rgb(0, 161, 58);">
		</td>
		<td colspan="3" width="63" height="10"
			style="font-size: 11px; line-height: 10px; overflow: hidden; text-align: center"
			id="anioDesde_cotizacion">2014</td>
		<td colspan="3" rowspan="3" style="font-size: 0px; line-height: 0px;">
			<!-- hora -->
		</td>
		<td colspan="2" width="49" height="10"
			style="font-size: 11px; line-height: 10px; overflow: hidden; text-align: center;">
		</td>
		<td rowspan="3" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="5" rowspan="3" width="119" height="24"
			style="font-size: 18px; line-height: 16px; overflow: hidden; text-align: center;">
			<span id="diaImpresion_cotizacion">03</span> <span
			id="mesImpresion_cotizacion">03</span> <span
			id="anioImpresion_cotizacion">2014</span>
		</td>
		<td rowspan="3" style="font-size: 0px; line-height: 0px;"></td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="5" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="3" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"></td>
	</tr>
	<tr>
		<td width="47" height="10"
			style="font-size: 11px; line-height: 10px; overflow: hidden; text-align: center;"
			id="diaHasta_cotizacion">30</td>
		<td colspan="5" width="49" height="10"
			style="font-size: 11px; line-height: 10px; overflow: hidden; text-align: center;"
			id="mesHasta_cotizacion">03</td>
		<td colspan="3" width="63" height="10"
			style="font-size: 11px; line-height: 10px; overflow: hidden; text-align: center;"
			id="anioHasta_cotizacion">2014</td>
		<td colspan="2" width="49" height="10"
			style="font-size: 11px; line-height: 10px; overflow: hidden; text-align: center;">

		</td>
	</tr>
	<tr>
		<td colspan="22" style="font-size: 0px; line-height: 0px;"><img
			src="images/datos.png" width="455" height="23" alt=""></td>
		<td style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="6" style="font-size: 0px; line-height: 0px;"></td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="6" width="138" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;" id="">

		</td>
		<td rowspan="4" width="28" height="52"
			style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="11" width="165" height="14"
			style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="6" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="2" width="76" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;" id="">

		</td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"><img
			src="images/flecha.png" width="28" height="14" alt=""></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"><img
			src="images/documento.png" alt="" width="92" height="14"></td>
		<td colspan="6" width="138" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="documento_cotizacion">C.C / NIT</td>
		<td colspan="5" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="6" width="136" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;" id="">

		</td>

		<td colspan="6" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="2" width="76" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"></td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"><img
			src="images/flecha.png" width="28" height="14" alt=""></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"><img
			src="images/correo.png" alt="" width="92" height="14"></td>
		<td colspan="6" width="138" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="correo_cotizacion">Correo</td>
		<td colspan="19" width="297" height="14"
			style="font-size: 0px; line-height: 0px;"></td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="7" width="138" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;" id="">

		</td>
		<!-- 			<td colspan="19" width="297" height="14" style="font-size: 0px; line-height: 0px;"> </td> -->
	</tr>
	<tr>
		<td colspan="29" style="font-size: 0px; line-height: 0px;"><img
			src="images/info.png" width="582" height="19" alt=""></td>
	</tr>
	<!-- 		<tr> -->
	<!-- 			<td colspan="29" style="font-size: 0px; line-height: 0px;"> -->
	<!-- 				<img src="http://cohombrocolombia.com/news/equidad/pag1_76.jpg" width="582" height="12" alt=""></td> -->
	<!-- 		</tr> -->
	<!-- 		<tr> -->
	<!-- 			<td  style="font-size: 0px; line-height: 0px;"> -->
	<!-- 				<img src="http://cohombrocolombia.com/news/equidad/pag1_77.jpg" width="27" height="5" alt=""></td> -->
	<!-- 			<td colspan="28"> -->
	<!-- 				<img src="http://cohombrocolombia.com/news/equidad/pag1_78.jpg" width="555" height="5" alt=""></td> -->
	<!-- 		</tr> -->
	<tr>
		<td rowspan="3" style="font-size: 0px; line-height: 0px;"></td>
		<td style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="26" width="161" height="370"
			style="font-size: 12px; line-height: 10px; overflow: hidden; vertical-align: top;">
			<!-- 				<span id = "cobertura1"></span> --> <!-- 				<span id = "cobertura2"></span> -->
			<table id="tabla_coberturas"
				style="height: 350; width: 100%; font-size: 7px; padding: 0; border: 0;">

			</table>
		</td>
		<!-- 			<td  style="font-size: 0px; line-height: 0px;"> -->
		<!-- 				<img src="http://cohombrocolombia.com/news/equidad/pag1_82.jpg" width="6" height="370" alt=""></td> -->
		<!-- 			<td colspan="6" width="95" height="370" style="font-size: 12px; line-height: 10px; overflow: hidden; vertical-align: top;"> -->
		<!-- 				dsa -->
		<!-- 			</td> -->
		<!-- 			<td  style="font-size: 0px; line-height: 0px;"> -->
		<!-- 				<img src="http://cohombrocolombia.com/news/equidad/pag1_84.jpg" width="5" height="370" alt=""></td> -->
		<!-- 			<td colspan="5" width="86" height="370" style="font-size: 12px; line-height: 10px; overflow: hidden; vertical-align: top;"> -->
		<!-- 				Tres -->
		<!-- 			</td> -->
		<!-- 			<td  style="font-size: 0px; line-height: 0px;"> -->
		<!-- 				<img src="http://cohombrocolombia.com/news/equidad/pag1_86.jpg" width="6" height="370" alt=""></td> -->
		<!-- 			<td colspan="6" width="96" height="370" style="font-size: 12px; line-height: 10px; overflow: hidden; vertical-align: top;"> -->
		<!-- 				Cuatro -->
		<!-- 			</td> -->
		<!-- 			<td  style="font-size: 0px; line-height: 0px;"> -->
		<!-- 				<img src="http://cohombrocolombia.com/news/equidad/pag1_88.jpg" width="5" height="370" alt=""></td> -->
		<!-- 			<td colspan="2" width="86" height="370" style="font-size: 12px; line-height: 10px; overflow: hidden; vertical-align: top;"> -->
		<!-- 				Cinco -->
		<!-- 			</td> -->
		<!-- 			<td  style="font-size: 0px; line-height: 0px;"> -->
		<!-- 				<img src="http://cohombrocolombia.com/news/equidad/pag1_90.jpg" width="4" height="370" alt=""></td> -->
	</tr>
	<tr>
		<td colspan="28"
			style="font-size: 0px; line-height: 0px; background-color: rgb(0, 161, 58);"
			height="3"></td>
	</tr>
	<tr>
		<td colspan="28" style="font-size: 0px; line-height: 0px;"></td>
	</tr>
	<!--<tr>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
			<td  style="font-size: 0px; line-height: 0px;">
				</td>
		</tr>-->
</table>
<table id="Table_01" width="609" height="100" border="0" cellpadding="0"
	cellspacing="0"
	style="font-family: 'Trebuchet MS', Helvetica, sans-serif; color: black;">

	<tr>
		<td style="font-size: 0px; line-height: 0px;"><img
			src="images/flecha.png" width="28" height="14" alt=""></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"><img
			src="images/prima.png" width="92" height="14" alt=""></td>
		<td colspan="6" width="138" height="13"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="primaNeta_cotizacion">Prima neta</td>
		<td width="28" height="13" style="font-size: 0px; line-height: 0px;">

		</td>
		<td colspan="6" style="font-size: 0px; line-height: 0px;"></td>
		<td colspan="8" width="127" height="13"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"></td>
		<td colspan="5" rowspan="3" style="font-size: 0px; line-height: 0px;">
		</td>
		<td rowspan="19" style="font-size: 0px; line-height: 0px;"></td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;"><img
			src="images/flecha.png" width="28" height="14" alt=""></td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;"><img
			src="images/iva.png" width="92" height="14" alt=""></td>
		<td colspan="6" width="138" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="iva_cotizacion">IVA</td>
		<td width="28" height="14" style="font-size: 0px; line-height: 0px;">
			<img src="images/flecha.png" width="28" height="14" alt="">
		</td>
		<td width="1" height="14" style="font-size: 0px; line-height: 0px;">
		</td>
		<td colspan="5" style="font-size: 0px; line-height: 0px;"><img
			src="images/total.png" width="92" height="14" alt=""></td>
		<td colspan="8" width="127" height="14"
			style="font-size: 12px; line-height: 10px; overflow: hidden;"
			id="totalPagar_cotizacion">Total a Pagar</td>
	</tr>

	<tr>
		<td colspan="21" width="556" height="33"
			style="font-size: 0px; line-height: 0px;"></td>
	</tr>
	<tr>
		<td colspan="21" width="556" height="311"
			style="font-size: 8px; line-height: 10px; text-align: left; color: #287239; vertical-align: top; font-family: 'Arial Black', Arial, Helvetica, sans-serif">
			Esta cotizaci&oacute;n no implica celebraci&oacute;n del contrato,
			tiene una v&aacute;lidez de cinco d&iacute;as y si dentro del
			t&eacute;rmino no se <br /> recibe aceptaci&oacute;n escrita, se
			entender&aacute; como no aceptada. En caso de aceptaci&oacute;n
			estar&aacute; sujeta a la informaci&oacute;n <br /> adicional e
			inspecci&oacute;n del riesgo que requiera La Equidad Seguros O.C,
			para confirmar la expedici&oacute;n de la p&oacute;liza.
		</td>
	</tr>

</table>










<!--
	<table id="Table_01" width="609" height="493" border="0" cellpadding="0" cellspacing="0" style="font-family: 'Trebuchet MS', Helvetica, sans-serif; color: black; background-color: white">
	<tr>
		<td colspan="23" style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td rowspan="21" style="font-size: 0px; line-height: 0px;">
			<img src="" width="30" height="655" alt=""></td>
		<td colspan="12" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="9" width="222" height="21" style="font-size: 0px; line-height: 0px;"> </td>
		<td rowspan="21" style="font-size: 0px; line-height: 0px;">
			<img src="" width="23" height="655" alt=""></td>
	</tr>
	<tr>
		<td colspan="21" width="556" height="19" style="font-size: 0px; line-height: 0px;"> </td>
	</tr>
	<tr>
		<td colspan="12" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="9" rowspan="3" width="222" height="19" style="font-size: 0px; line-height: 0px;"> </td>
	</tr>
	<tr>
		<td colspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="8" width="236" height="11" style="font-size: 12px; line-height: 10px; overflow: hidden;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td colspan="12" style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td width="4" height="11" style="font-size: 0px; line-height: 0px;"> </td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" width="73" height="11" style="font-size: 0px; line-height: 0px;"> </td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="5" width="62" height="11" style="font-size: 0px; line-height: 0px;"> </td>
		<td colspan="4" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" width="102" height="11" style="font-size: 0px; line-height: 0px;"> </td>
		<td colspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td rowspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
		<td rowspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="2" rowspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="6" style="font-size: 0px; line-height: 0px;">
			</td>
		<td rowspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
		<td rowspan="3" style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td colspan="3" width="137" height="11" style="font-size: 12px; line-height: 10px; overflow: hidden;" id = "primaNeta_cotizacion">
			123123
		</td>
		<td colspan="3" width="135" height="11" style="font-size: 12px; line-height: 10px; overflow: hidden;" id = "gastos_cotizacion">
			123123
		</td>
		<td colspan="6" width="134" height="11" style="font-size: 12px; line-height: 10px; overflow: hidden;" id = "iva_cotizacion">
			456465
		</td>
		<td colspan="3" width="123" height="11" style="font-size: 12px; line-height: 10px; overflow: hidden;" id = "totalPagar_cotizacion">
			5645646
		</td>
	</tr>
	<tr>
		<td colspan="3" style="font-size: 0px; line-height: 0px;background-color: rgb(0,161,58);">
			</td>
		<td colspan="3" style="font-size: 0px; line-height: 0px;background-color: rgb(0,161,58);">
			</td>
		<td colspan="6" style="font-size: 0px; line-height: 0px;background-color: rgb(0,161,58);">
			</td>
		<td colspan="3" style="font-size: 0px; line-height: 0px;background-color: rgb(0,161,58);">
			<img src="" width="123" height="3" alt=""></td>
	</tr>
	<tr>
		<td width="4" height="15" style="font-size: 12px; line-height: 0px;"> </td>
		<td style="font-size: 12px; line-height: 10px;">
			</td>
		<td colspan="8" width="214" height="15" style="font-size: 12px; line-height: 10px;">
			
		</td>
		<td colspan="5" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="6" width="187" height="15" style="font-size: 12px; line-height: 10px;">
			
		</td>
	</tr>
	<tr>
		<td width="4" height="23" style="font-size: 0px; line-height: 0px;"> </td>
		<td colspan="9" width="283" height="23" style="font-size: 0px; line-height: 0px;"> </td>
		<td colspan="11" width="269" height="23" style="font-size: 0px; line-height: 0px;"> </td>
	</tr>
	<tr>
		<td colspan="7" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="2" rowspan="7" width="11" height="67" style="font-size: 0px; line-height: 0px;"> </td>
		<td colspan="9" style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="2" style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" width="137" height="7"  style="font-size: 10px; line-height: 7px;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td width="121" height="7" style="font-size: 10px; line-height: 7px; text-align: center">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" width="56" height="7" style="font-size: 10px; line-height: 7px;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="4" width="123" height="7" style="font-size: 10px; line-height: 7px;">
			 
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td width="75" height="7" style="font-size: 10px; line-height: 7px;text-align: center;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td colspan="7" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="12" style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" width="137" height="10" style="font-size: 10px; line-height: 7px;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td width="121" height="10" style="font-size: 10px; line-height: 7px; text-align: center;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" width="56" height="10" style="font-size: 10px; line-height: 7px;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="4" width="123" height="10" style="font-size: 10px; line-height: 7px;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td width="75" height="10" style="font-size: 10px; line-height: 7px; text-align: center;">
				
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td colspan="7" style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="12" style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" width="137" height="11"  style="font-size: 10px; line-height: 7px;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td width="121" height="11" style="font-size: 10px; line-height: 7px;text-align: center;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="3" width="56" height="11" style="font-size: 0px; line-height: 0px;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td colspan="4" width="123" height="11" style="font-size: 10px; line-height: 7px;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td height="11" style="font-size: 10px; line-height: 7px; text-align: center;">
			
		</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td colspan="7" style="font-size: 0px; line-height: 0px;">
			<img src="" width="272" height="1" alt=""></td>
		<td colspan="12" style="font-size: 0px; line-height: 0px;">
			<img src="" width="273" height="1" alt=""></td>
	</tr>
	<tr>
		<td colspan="21" width="556" height="33" style="font-size: 0px; line-height: 0px;"> </td>
	</tr>
	<tr>
		<td colspan="21" width="556" height="311"  style="font-size: 8px; line-height: 10px; text-align: left; color: #287239; vertical-align: top; font-family: 'Arial Black', Arial, Helvetica, sans-serif">
			Esta cotizaci&oacute;n no implica celebraci&oacute;n del contrato, tiene una 
			v&aacute;lidez de cinco d&iacute;as y si dentro del t&eacute;rmino no se
			<br />
			recibe aceptaci&oacute;n escrita, se entender&aacute; como no aceptada. En caso
			de aceptaci&oacute;n estar&aacute; sujeta a la informaci&oacute;n
			<br />
			adicional e inspecci&oacute;n del riesgo que requiera La Equidad Seguros O.C,
			para confirmar la expedici&oacute;n de la p&oacute;liza.
		</td>
	</tr>
	<tr>
		<td colspan="21" style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
	<tr>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
		<td style="font-size: 0px; line-height: 0px;">
			</td>
	</tr>
</table>
-->

<img src="images/infografia.png" width="609" height="630"
	alt="Infografia Equidad" />


<!-- </body> -->
<!-- </html> -->