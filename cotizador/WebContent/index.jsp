<!DOCTYPE HTML PUBLIC <"-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge;chrome=1" />
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<title>Cotizador - Equidad Seguros</title>
		
		<link href="css/custom.css" type="text/css" rel="stylesheet" />
		
	</head>
	<body>
	
	<div class="med">
		
		<input type = "hidden" id = "path" value = "<%= request.getContextPath() %>"/>
		<div class="header"></div>
		<img src="images/banner.jpg" width="669" height="160" alt="Equidad Seguros" class="banner" />
		<div id = "panelCotizacion">
		<form id = "cotizar_cotizadorAutos">
			<h1>Producto</h1>
			<div class="item">
				<label id = "lblTipoProducto_cotizadorAutos">Tipo de producto:</label>
				<select id = "productos_cotizadorAutos">
				</select>
			</div>
			<h1>Datos Personales</h1>
			<!-- <div class="item">
				<label id = "lblNombre_cotizadorAutos">Nombre:</label>
				<input type="text" value="" class="wid"  id = "nombre_cotizadorAutos"/>
			</div> 
			<div class="item">
				<label id = "lblDireccion_cotizadorAutos">Direcci&oacute;n:</label>
				<input type="text" value="" class="wid"  id = "direccion_cotizadorAutos"/>
			</div>  -->
			<div class="item">
				<label id = "lblDocumentoIdentidad_cotizadorAutos">Documento de Identidad:</label>
				<input type="text" class="wid"  id = "documentoIdentidad_cotizadorAutos"/>
			</div>
			<div class="item">
				<label id = "lblFechaNacimiento_cotizadorAutos">Fecha Nacimiento:</label>
				<input type="text" class="wid"   id = "fechaNacimiento_cotizadorAutos" />
			</div>
			<div class="item">
				<label id = "lblCorreo_cotizadorAutos">Correo:</label>
				<input type="text" class="wid"   id = "correo_cotizadorAutos" />
			</div>
			<div class="item">
				<label id = "lblGenero_cotizadorAutos">Genero:</label>
					<select id = "genero_cotizadorAutos">
						<option value="F">Femenino&nbsp;</option>
						<option value="M">M&aacute;sculino&nbsp;</option>  						
 						<option value="PJ">Persona Jur&iacute;dica</option>
				</select><br/>
			</div>
			<div class="item">
				<label id = "lblOcupacion_cotizadorAutos">Ocupaci&oacute;n:</label>
				<select id = "ocupacion_cotizadorAutos">
				</select><br/>
				<span id = "rtaOcupaciones_cotizadorAutos"></span>
			</div>
			<div class="item">
				<label id = "lblMujerCooperativa_cotizadorAutos">Mujer Cooperativista:</label>
				<input type="radio" value="SI" id = "si_mujerCooperativa_cotizadorAutos" name = "mujerCooperativa_cotizadorAutos" />Si&nbsp;
				<input type="radio" value="NO" id = "no_mujerCooperativa_cotizadorAutos" name = "mujerCooperativa_cotizadorAutos"/>No&nbsp;
			</div>
			
			<h1>Datos del Veh&iacute;culo</h1>
			<div class="item">
				<label id = "lblPlaca_cotizadorAutos">Vehiculo Nuevo:</label>
				<input type="radio" value="SI" id = "vehiculoNuevo_cotizadorAutos" name = "vehiculoNuevo_cotizadorAutos" />Si&nbsp;
				<input type="radio" value="NO" id = "vehiculoNuevo_cotizadorAutos" name = "vehiculoNuevo_cotizadorAutos"/>No&nbsp;
			</div>
			<div class="item">
				<label id = "lblPlaca_cotizadorAutos">Placa:</label>
				<input type="text" class="widmin" id = "placa_cotizadorAutos" />
				<span id = "rtaPlaca_cotizadorAutos"></span>
				<input type="button" value="Buscar"  id = "buscarPlaca_cotizadorAutos"/>
			</div>
			<div class="item">
				<label id = "lblMarcas_cotizadorAutos">Marca:</label>
				<select id = "marcas_cotizadorAutos">
				</select>
				<span id = "rtaMarcas_cotizadorAutos"></span>
			</div>
			<div class="item">
				<label id = "lblModelos_cotizadorAutos">Modelo:</label>
				<select id = "modelos_cotizadorAutos">
				</select>
				<span id = "rtaModelos_cotizadorAutos"></span>
			</div>
			<div class="item">
				<label id = "lblVersion_cotizadorAutos">Versi&oacute;n:</label>
				<select id = "versiones_cotizadorAutos">
				</select>
				<span id = "rtaVersiones_cotizadorAutos"></span>
			</div>
			<div class="item">
				<label id = "lblAnio_cotizadorAutos">A&ntilde;o:</label>
				<select id = "anios_cotizadorAutos">
				</select>
				<span id = "rtaAnios_cotizadorAutos"></span>
			</div>
			<div class="item">
				<label id = "lblValor_cotizadorAutos">Valor:</label>
<!-- 				<span id = "rtaValorAnios_cotizadorAutos"></span> -->
				<input type = "text" id = "valorAnios_cotizadorAutos"/>
			</div>
			<div class="item" id = "textoAutoNuevo">
				
			</div>
			<!-- <div class="item">
				<label id = "lblColor_cotizadorAutos">Color:</label> -->
				<input type = "HIDDEN" id = "color_cotizadorAutos" value = "NA"/>
			<!-- </div> -->
			<h1>Datos del Seguro</h1>
			<div class="item">
				<label id = "lblDepartamentos_cotizadorAutos">Departamento de Circulaci&oacute;n:</label>
				<select id = "departamentos_cotizadorAutos">
				</select>
				<span id = "rtaDepartamentos_cotizadorAutos"></span>
			</div>
			<div class="item">
				<label id = "lblCiudades_cotizadorAutos">Ciudad de Circulaci&oacute;n:</label>
				<select id = "ciudades_cotizadorAutos">
				</select>
				<span id = "rtaCiudades_cotizadorAutos"></span>
			</div>
			<div class="item">
				<h2>Opciones Deducibles</h2>
			</div>
			<!--div class="item">
				<input type="radio" value="1" id = "opcionesDeducibles_cotizadorAutos" name = "opcionesDeducibles_cotizadorAutos" disabled="true"/>Opci&oacute;n 1
				<input type="radio" value="2" id = "opcionesDeducibles_cotizadorAutos" name = "opcionesDeducibles_cotizadorAutos" disabled="true"/>Opci&oacute;n 2
				<input type="radio" value="3" id = "opcionesDeducibles_cotizadorAutos" name = "opcionesDeducibles_cotizadorAutos" disabled="true"/>Opci&oacute;n 3
			</div-->
			<div class="item">
				<label id = "lblPerdidaParcial_cotizadorAutos">Perdida Parcial:</label>
				<select id = "perdidaParcial_cotizadorAutos">
				</select>
				<span id = "rtaPerdidaParcial_cotizadorAutos"></span>
			</div>
			<div class="item">
				<label id = "lblPerdidaTotal_cotizadorAutos">Perdida Total:</label>
				<select id = "perdidaTotal_cotizadorAutos">
					
				</select>
				<span id = "rtaPerdidaTotal_cotizadorAutos"></span>
				
			</div>
			<div class="item">
				<label id = "lblRCE_cotizadorAutos">L&iacute;mite RCE:</label>
				<select id = "rce_cotizadorAutos">
				</select>
				<span id = "rtaRCE_cotizadorAutos"></span>
				<input type = "hidden" id = "buenaExperiencia_cotizadorAutos" value = "01"/>
			</div>
			<div class="item">
				<label id = "lblAsistenciaExtendida_cotizadorAutos">Asistencia Extendida:</label>
				<select id = "asistenciaExtendida_cotizadorAutos">
					<option selected value="NO">NO</option>
  					<option value="SI">SI</option>
				</select>
				
			</div>
			<div class="item">
				<label id = "lblHurtoCartera_cotizadorAutos">Hurto Cartera:</label>
				
				<select id = "hurtoCartera_cotizadorAutos" >
					<option selected value="02">NO</option>
  					<option value="01">SI</option>
				</select>
				
			</div>
			<div class="item">
				<label id = "lblRoturaMecanica_cotizadorAutos">Rotura Mecanica:</label>
				
				<select id = "roturaMecanica_cotizadorAutos" >
					<option selected value="02">NO</option>
  					<option value="01">SI</option>
				</select>
				
			</div>
			
			<div class="item">
				<label id = "lblCaptcha_cotizadorAutos">Captcha:</label><br/>
				<img src = "<%= request.getContextPath() %>/ServletImagenCaptcha" width="300" height="75" id = "imagenCaptcha_cotizadorAutos"/><br/>
				<input type="text" value="" id = "captcha_cotizadorAutos" />
			</div>
			<div class="item">
				<input type="submit" value="Cotizar" />
			</div>
			<div class="item">
				<br/><br/><br/>LA PRESENTE COTIZACION DEBERA SER REALIZADA CON EL NUMERO DE DOCUMENTO DE IDENTIFICACION 
						DEL CLIENTE INTERESADO, ADICIONAL QUEDARA SUJETA A PREVIA VERIFICACION DE LA MISMA Y A LA 
						CONFIRMACION DE EDAD Y OCUPACION DEL CLIENTE, YA QUE ESTOS DATOS  SON IMPORTANTE AL 
						MOMENTO DE LAS VARIABLES USADAS PARA  DETERMINAR EL VALOR DE LA PRIMA REAL A COBRAR AL 
						MOMENTO DE LA EXPEDICION DEL SEGURO.
			</div>
		</form>
		</div>
	</div>
	
	
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery.min.js" ></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-ui.min.js" ></script>
<!-- 	<script src="http://code.jquery.com/jquery-2.0.0.js"></script> -->
<!-- 	<script src="http://code.jquery.com/jquery-migrate-1.1.1.js"></script> -->
	
	
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/ui.formularioCotizacion.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/ui.cotizar.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/ui.generarPDF.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/ui.enviarCorreo.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/ui.buscarAutos.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/ui.autoNuevo.js"></script>
	<script type="text/javascript" src="<%= request.getContextPath() %>/js/ui.opciones.js"></script>
	<div id = "dialogoGenerico"></div>
	</body>
</html>