$(document)
		.ready(
				function() {
					$(document).on(
							"change",
							"[name='mujerCooperativa_cotizadorAutos']",
							function(e) {

								// alert("12312");
								var mujerCoop = $(this).val();
								if (mujerCoop == "SI") {
									// alert("12312");
									$("#rce_cotizadorAutos").val("08");
									$("#rce_cotizadorAutos").prop('disabled',
											'disabled');
									// $("#rce_cotizadorAutos").val("08");
								} else {
									$("#rce_cotizadorAutos").val("-1");
									$("#rce_cotizadorAutos").prop('disabled',
											false);
								}
							});

					$(document).on(
							"change",
							"#genero_cotizadorAutos",
							function(e) {

								var genero = $(this).val();
								if (genero == "M" || genero == "PJ") {
									$("#no_mujerCooperativa_cotizadorAutos")
											.prop('checked', true);
									$("#no_mujerCooperativa_cotizadorAutos")
											.prop('disabled', true);
									$("#si_mujerCooperativa_cotizadorAutos")
											.prop('disabled', true);
								} else {
									$("#no_mujerCooperativa_cotizadorAutos")
											.prop('checked', false);
									$("#si_mujerCooperativa_cotizadorAutos")
											.prop('checked', false);

									$("#no_mujerCooperativa_cotizadorAutos")
											.prop('disabled', false);
									$("#si_mujerCooperativa_cotizadorAutos")
											.prop('disabled', false);
								}
							});

					//
					// Inicializaci�n
					$("#fechaNacimiento_cotizadorAutos").datepicker(
							{
								changeMonth : true,
								changeYear : true,
								showButtonPanel : true,
								dayNamesMin : [ "Do", "Lu", "Ma", "Mi", "Ju",
										"Vi", "Sa" ],
								monthNamesShort : [ "Ene", "Feb", "Mar", "Abr",
										"May", "Jun", "Jul", "Ago", "Sep",
										"Oct", "Nov", "Dic" ],
								yearRange : '1935:2000',
								dateFormat : 'dd/mm/yy'
							});

					iniciarMarcas();
					iniciarOcupaciones();
					iniciarProductos();
					iniciarDepartamentos();
					iniciarRCE();
					iniciarAniosExperiencias();

					//
					// Anios Experiencia
					function iniciarAniosExperiencias() {
						var path = $("#path").val();
						$("#rtaBuenaExperiencia_cotizadorAutos").html(
								"Cargando");
						$
								.ajax({
									type : "POST",
									url : path + "/ServletAniosExperiencia",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : "",
									success : function(msg) {
										$('#buenaExperiencia_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var buenaExperiencia = msg[i];
											$(
													'#buenaExperiencia_cotizadorAutos')
													.append(
															'<option value="'
																	+ buenaExperiencia.identificador
																	+ '">'
																	+ buenaExperiencia.nombre
																	+ '</option>');
										}
										$("#rtaBuenaExperiencia_cotizadorAutos")
												.html("");
									}
								});
					}
					//
					// Ocupaciones
					function iniciarRCE() {
						var path = $("#path").val();
						$("#rtaRCE_cotizadorAutos").html("Cargando");
						$
								.ajax({
									type : "POST",
									url : path + "/ServletRCE",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : "",
									success : function(msg) {
										$('#rce_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var rces = msg[i];
											if (rces.identificador != "10") {
												$('#rce_cotizadorAutos')
														.append(
																'<option value="0'
																		+ rces.identificador
																		+ '">'
																		+ rces.nombre
																		+ '</option>');
											} else {
												$('#rce_cotizadorAutos')
														.append(
																'<option value="'
																		+ rces.identificador
																		+ '">'
																		+ rces.nombre
																		+ '</option>');
											}

										}
										$("#rtaRCE_cotizadorAutos").html("");
									}
								});
					}
					//
					// Departamentos
					$(document)
							.on(
									"change",
									"#departamentos_cotizadorAutos",
									function(e) {
										var identificadorDepartamento = $(
												"#departamentos_cotizadorAutos")
												.val();
										var marca = $("#marcas_cotizadorAutos")
												.val();
										reiniciarCiudades();
										cambiarCiudadesDepartamentos(identificadorDepartamento);
										cargarPerdidas(marca);
										cargarPerdidasTotales(marca);
									});
					function reiniciarCiudades() {
						$('#ciudades_cotizadorAutos').empty();
					}
					function iniciarDepartamentos() {
						var path = $("#path").val();
						$("#rtaDepartamentos_cotizadorAutos").html("Cargando");
						$
								.ajax({
									type : "POST",
									url : path + "/ServletDepartamentos",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : "",
									success : function(msg) {
										$('#departamentos_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var departamentos = msg[i];
											$('#departamentos_cotizadorAutos')
													.append(
															'<option value="'
																	+ departamentos.identificador
																	+ '">'
																	+ departamentos.nombre
																	+ '</option>');
										}
										$("#rtaDepartamentos_cotizadorAutos")
												.html("");
									}
								});
					}
					function cargarPerdidas(marca) {
						var path = $("#path").val();
						$("rtaPerdidaParcial_cotizadorAutos").html("Cargando");
						$('#perdidaParcial_cotizadorAutos').empty();
						var plan = $("#productos_cotizadorAutos").val();
						var info = {
							"marca" : marca,
							"plan" : plan
						};
						$
								.ajax({
									type : "POST",
									url : path + "/PerdidaTotalServlet",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : info,
									success : function(msg) {
										$('#perdidaParcial_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var modeloTemp = msg[i];
											$('#perdidaParcial_cotizadorAutos')
													.append(
															'<option value="'
																	+ modeloTemp.id
																	+ '">'
																	+ modeloTemp.nombre
																	+ '</option>');
										}
										$("#rtaPerdidaParcial_cotizadorAutos")
												.html("");

									}
								});
					}

					/**
					 * carolina agtrego esta funcion cargarModelo
					 */
					function cargarModelo(marca, modelo) {
						var path = $("#path").val();
						$("rtaPerdidaParcial_cotizadorAutos").html("Cargando");
						$('#perdidaParcial_cotizadorAutos').empty();
						var concatenacion = $("#productos_cotizadorAutos")
								.val();
						console.log(concatenacion);
						var plan = concatenacion;
						var info = {
							"marca" : marca,
							"modelo" : modelo,
							"plan" : plan
						};
						$
								.ajax({
									type : "POST",
									url : path + "/PerdidaTotalServletModelo",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : info,
									success : function(msg) {
										$('#perdidaParcial_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var modeloTemp = msg[i];
											$('#perdidaParcial_cotizadorAutos')
													.append(
															'<option value="'
																	+ modeloTemp.id
																	+ '">'
																	+ modeloTemp.nombre
																	+ '</option>');
										}
										$("#rtaPerdidaParcial_cotizadorAutos")
												.html("");

									}
								});
					}

					function cargarPerdidasTotales(marca) {
						var path = $("#path").val();
						$("rtaPerdidaTotal_cotizadorAutos").html("Cargando");
						$('#perdidaTotal_cotizadorAutos').empty();
						var plan = $("#productos_cotizadorAutos").val();

						var info = {
							"marca" : marca,
							"plan" : plan
						};
						$
								.ajax({
									type : "POST",
									url : path + "/PerdidaTotalTotalServlet",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : info,
									success : function(msg) {
										$('#perdidaTotal_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var modeloTemp = msg[i];
											$('#perdidaTotal_cotizadorAutos')
													.append(
															'<option value="'
																	+ modeloTemp.id
																	+ '">'
																	+ modeloTemp.nombre
																	+ '</option>');
										}
										$("#rtaPerdidaTotal_cotizadorAutos")
												.html("");

									}
								});
					}
					function cambiarCiudadesDepartamentos(
							identificadorDepartamento) {
						var path = $("#path").val();
						var info = {
							"identificadorDepartamento" : identificadorDepartamento
						};
						$("#rtaCiudades_cotizadorAutos").html("Cargando");
						$
								.ajax({
									type : "POST",
									url : path + "/ServletCiudadesDepartamento",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : info,
									success : function(msg) {
										$('#ciudades_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var ciudades = msg[i];
											var ids = ciudades.identificador;
											if ((ids + "").length == "3") {

												$('#ciudades_cotizadorAutos')
														.append(
																'<option value="00'
																		+ ciudades.identificador
																		+ '">'
																		+ ciudades.nombre
																		+ '</option>');
											} else if ((ids + "").length == "4") {

												$('#ciudades_cotizadorAutos')
														.append(
																'<option value="0'
																		+ ciudades.identificador
																		+ '">'
																		+ ciudades.nombre
																		+ '</option>');
											} else if ((ids + "").length == 5) {
												$('#ciudades_cotizadorAutos')
														.append(
																'<option value="'
																		+ ciudades.identificador
																		+ '">'
																		+ ciudades.nombre
																		+ '</option>');
											}

										}
										$("#rtaCiudades_cotizadorAutos").html(
												"");
									}
								});
					}
					//
					// Ocupaciones
					function iniciarOcupaciones() {
						var path = $("#path").val();
						$("#rtaOcupaciones_cotizadorAutos").html("Cargando");
						$
								.ajax({
									type : "POST",
									url : path + "/ServletOcupaciones",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : "",
									success : function(msg) {
										$('#ocupacion_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var modelo = msg[i];
											$('#ocupacion_cotizadorAutos')
													.append(
															'<option value="'
																	+ modelo.identificador
																	+ '">'
																	+ modelo.nombre
																	+ '</option>');
										}
										$("#rtaOcupaciones_cotizadorAutos")
												.html("");
									}
								});
					}
					//
					// productos
					function iniciarProductos() {
						var path = $("#path").val();

						$("#no_mujerCooperativa_cotizadorAutos").prop(
								'checked', false);
						$("#si_mujerCooperativa_cotizadorAutos").prop(
								'checked', false);

						$("#no_mujerCooperativa_cotizadorAutos").prop(
								'disabled', false);
						$("#si_mujerCooperativa_cotizadorAutos").prop(
								'disabled', false);

						$("#rtaProductos_cotizadorAutos").html("Cargando");
						$
								.ajax({
									type : "POST",
									url : path + "/ServletProductos",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : "",
									success : function(msg) {
										$('#productos_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var producto = msg[i];
											$('#productos_cotizadorAutos')
													.append(
															'<option value="'
																	+ producto.identificador
																	+ '">'
																	+ producto.nombre
																	+ '</option>');
										}
										$("#rtaProductos_cotizadorAutos").html(
												"");
									}
								});

					}

					//
					// cambio productos
					$(document)
							.on(
									"change",
									"#productos_cotizadorAutos",
									function(e) {
										var prod = $(
												"#productos_cotizadorAutos")
												.val();
										// alert('Producto '+prod);
										$("#roturaMecanica_cotizadorAutos")
												.val("02");
										if (prod == 11701) {

											$("#roturaMecanica_cotizadorAutos")
													.val("02");
											$("#roturaMecanica_cotizadorAutos")
													.prop('disabled', false);

											$("#hurtoCartera_cotizadorAutos")
													.val("02");
											$("#hurtoCartera_cotizadorAutos")
													.prop('disabled', false);
											$(
													"#asistenciaExtendida_cotizadorAutos")
													.val("NO");
											$(
													"#asistenciaExtendida_cotizadorAutos")
													.prop('disabled', false);
											$("#roturaMecanica_cotizadorAutos")
													.prop('disabled', false);
											// $("#roturaMecanica_cotizadorAutos").prop('visible',
											// true);
											// $("#lblRoturaMecanica_cotizadorAutos").prop('visible',
											// true);
											// $("#opcionesDeducibles_cotizadorAutos").prop('visibility',
											// true);
											/*
											 * $("#rce_cotizadorAutos").html("");
											 * iniciarRCE();
											 * $("[name='opcionesDeducibles_cotizadorAutos']").prop('disabled',
											 * false);
											 * $("#rce_cotizadorAutos").val("-1");
											 * $("#rce_cotizadorAutos").prop('disabled',
											 * false);
											 */

											$("#rce_cotizadorAutos").empty();
											$('#rce_cotizadorAutos')
													.append(
															'<option value="10">1.000.000.000</option>');
											$("#rce_cotizadorAutos").val("10");
											$("#rce_cotizadorAutos").prop(
													'disabled', 'disabled');

										} else {

											$(
													"[name='opcionesDeducibles_cotizadorAutos']")
													.prop('checked', false);
											$(
													"[name='opcionesDeducibles_cotizadorAutos']")
													.prop('disabled', true);
											$("#roturaMecanica_cotizadorAutos")
													.val("02");
											$("#roturaMecanica_cotizadorAutos")
													.prop('disabled', true);
											// $("#roturaMecanica_cotizadorAutos").hide();
											// $("#roturaMecanica_cotizadorAutos").prop('disabled',
											// true);
											// $("#lblRoturaMecanica_cotizadorAutos").hide();
										}

										if (prod == 11714) {

											$("#roturaMecanica_cotizadorAutos")
													.val("01");
											$("#roturaMecanica_cotizadorAutos")
													.prop('disabled', true);

											$("#hurtoCartera_cotizadorAutos")
													.val("01");
											$("#hurtoCartera_cotizadorAutos")
													.prop('disabled', true);
											$(
													"#asistenciaExtendida_cotizadorAutos")
													.val("NO");
											$(
													"#asistenciaExtendida_cotizadorAutos")
													.prop('disabled', false);

											$("#rce_cotizadorAutos").empty();
											$('#rce_cotizadorAutos')
													.append(
															'<option value="10">1.000.000.000</option>');
											$("#rce_cotizadorAutos").val("10");
											$("#rce_cotizadorAutos").prop(
													'disabled', 'disabled');
											$("#genero_cotizadorAutos").prop(
													'disabled', true);

											$("#genero_cotizadorAutos")
													.val("F");
											$(
													"#no_mujerCooperativa_cotizadorAutos")
													.prop('checked', false);
											$(
													"#si_mujerCooperativa_cotizadorAutos")
													.prop('checked', false);

											$(
													"#no_mujerCooperativa_cotizadorAutos")
													.prop('disabled', false);
											$(
													"#si_mujerCooperativa_cotizadorAutos")
													.prop('disabled', false);

										} else {

											$("#genero_cotizadorAutos").prop(
													'disabled', false);

											$(
													"#no_mujerCooperativa_cotizadorAutos")
													.prop('checked', true);
											$(
													"#no_mujerCooperativa_cotizadorAutos")
													.prop('disabled', true);
											$(
													"#si_mujerCooperativa_cotizadorAutos")
													.prop('disabled', true);

										}

										if (prod == 11712) {

											$("#hurtoCartera_cotizadorAutos")
													.val("02");
											$("#hurtoCartera_cotizadorAutos")
													.prop('disabled', false);
											$(
													"#asistenciaExtendida_cotizadorAutos")
													.val("NO");
											$(
													"#asistenciaExtendida_cotizadorAutos")
													.prop('disabled', false);

											$("#rce_cotizadorAutos").html("");
											iniciarRCE();
											$(
													"[name='opcionesDeducibles_cotizadorAutos']")
													.prop('disabled', false);
											$("#rce_cotizadorAutos").val("-1");
											$("#rce_cotizadorAutos").prop(
													'disabled', false);

											// $("#roturaMecanica_cotizadorAutos").val("02");
											// $("#roturaMecanica_cotizadorAutos").prop('disabled',
											// true);

											// alert('en prod 11712');
											/*
											 * $("#rce_cotizadorAutos").empty();
											 * $('#rce_cotizadorAutos').append('<option
											 * value="10">1.000.000.000</option>');
											 * $("#rce_cotizadorAutos").val("10");
											 * $("#rce_cotizadorAutos").prop('disabled',
											 * 'disabled');
											 */

										}

										if (prod == 11713) {

											$("#hurtoCartera_cotizadorAutos")
													.val("02");
											$("#hurtoCartera_cotizadorAutos")
													.prop('disabled', false);
											$(
													"#asistenciaExtendida_cotizadorAutos")
													.val("SI");
											$(
													"#asistenciaExtendida_cotizadorAutos")
													.prop('disabled', true);

											$("#roturaMecanica_cotizadorAutos")
													.val("01");
											$("#roturaMecanica_cotizadorAutos")
													.prop('disabled', true);

											$("#rce_cotizadorAutos").empty();
											$('#rce_cotizadorAutos')
													.append(
															'<option value="100">4.000.000.000</option>');
											$("#rce_cotizadorAutos").val("100");
											$("#rce_cotizadorAutos").prop(
													'disabled', 'disabled');

										}

										var marca = $("#marcas_cotizadorAutos")
												.val();

										cargarPerdidas(marca);
										cargarPerdidasTotales(marca);

									});

					/*
					 * $(document).on("change", "#genero_cotizadorAutos",
					 * function(e){
					 * 
					 * var genero = $(this).val(); if(genero == "M" || genero ==
					 * "PJ"){
					 * $("#no_mujerCooperativa_cotizadorAutos").prop('checked',true);
					 * $("#no_mujerCooperativa_cotizadorAutos").prop('disabled',
					 * true);
					 * $("#si_mujerCooperativa_cotizadorAutos").prop('disabled',
					 * true); }else{
					 * $("#no_mujerCooperativa_cotizadorAutos").prop('checked',false);
					 * $("#si_mujerCooperativa_cotizadorAutos").prop('checked',false);
					 * 
					 * $("#no_mujerCooperativa_cotizadorAutos").prop('disabled',
					 * false);
					 * $("#si_mujerCooperativa_cotizadorAutos").prop('disabled',
					 * false); } });
					 */

					//
					// Autos
					$(document).on("change", "#marcas_cotizadorAutos",
							function(e) {
								var marca = $("#marcas_cotizadorAutos").val();

								reiniciarAnios();
								reiniciarVersiones();
								reiniciarModelos();
								reiniciarValor();
								actualizarModelos(marca);

								cargarPerdidas(marca);
								cargarPerdidasTotales(marca);

							});
					$(document)
							.on(
									"change",
									"#modelos_cotizadorAutos",
									function(e) {
										var marca = $("#marcas_cotizadorAutos")
												.val();
										var modelo = $(
												"#modelos_cotizadorAutos")
												.val();

										reiniciarAnios();
										reiniciarVersiones();
										reiniciarValor();
										actualizarVersiones(marca, modelo);

										// cargarModelo(marca, modelo);
									});
					$(document).on(
							"change",
							"#versiones_cotizadorAutos",
							function(e) {
								var codigoFasecolda = $(
										"#versiones_cotizadorAutos").val();

								reiniciarAnios();
								reiniciarValor();
								actualizarAnios(codigoFasecolda);
							});
					$(document).on("change", "#anios_cotizadorAutos",
							function(e) {
								var valor = $("#anios_cotizadorAutos").val();
								actualizarValor(valor);
							});

					function reiniciarModelos() {
						$('#modelos_cotizadorAutos').empty();
					}
					function reiniciarVersiones() {
						$('#versiones_cotizadorAutos').empty();
					}
					function reiniciarAnios() {
						$('#anios_cotizadorAutos').empty();
					}
					function reiniciarValor() {
						$('#rtaValorAnios_cotizadorAutos').html("");
						$('#valorAnios_cotizadorAutos').val("");
					}
					function iniciarMarcas() {
						var path = $("#path").val();
						$("#rtaMarcas_cotizadorAutos").html("Cargando");
						$
								.ajax({
									type : "POST",
									url : path + "/ServletMarcas",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : "",
									success : function(msg) {
										$('#marcas_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var marca = msg[i];
											$('#marcas_cotizadorAutos').append(
													'<option value="'
															+ marca.id + '">'
															+ marca.nombre
															+ '</option>');
										}
										$("#rtaMarcas_cotizadorAutos").html("");
									}
								});
					}
					function actualizarModelos(marca) {
						var path = $("#path").val();
						$("#rtaModelos_cotizadorAutos").html("Cargando");
						var info = {
							"marca" : marca
						};
						$
								.ajax({
									type : "POST",
									url : path + "/ServletModelosMarca",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : info,
									success : function(msg) {
										$('#modelos_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var modelo = msg[i];
											$('#modelos_cotizadorAutos')
													.append(
															'<option value="'
																	+ modelo.id
																	+ '">'
																	+ modelo.nombre
																	+ '</option>');
										}
										$("#rtaModelos_cotizadorAutos")
												.html("");
									}
								});
					}
					function actualizarVersiones(marca, modelo) {
						var path = $("#path").val();
						var info = {
							"marca" : marca,
							"modelo" : modelo
						};
						$("#rtaVersiones_cotizadorAutos").html("Cargando");
						$
								.ajax({
									type : "POST",
									url : path + "/ServletVersionesMarcaModelo",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : info,
									success : function(msg) {
										$('#versiones_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var modelo = msg[i];
											$('#versiones_cotizadorAutos')
													.append(
															'<option value="'
																	+ modelo.id
																	+ '">'
																	+ modelo.nombre
																	+ '</option>');
										}
										$("#rtaVersiones_cotizadorAutos").html(
												"");
									}
								});
					}
					function actualizarAnios(codigoFasecolda) {
						var path = $("#path").val();
						var info = {
							"codigoFasecolda" : codigoFasecolda
						};
						$("#rtaAnios_cotizadorAutos").html("Cargando");
						$
								.ajax({
									type : "POST",
									url : path + "/ServletAniosCodigo",
									scriptCharset : "utf-8",
									contentType : "application/x-www-form-urlencoded; charset=UTF-8",
									data : info,
									success : function(msg) {
										$('#anios_cotizadorAutos')
												.append(
														'<option value="-1">[SELECCIONAR]</option>');
										for (var i = 0; i < msg.length; i++) {
											var modelo = msg[i];
											$('#anios_cotizadorAutos').append(
													'<option value="'
															+ modelo.valor
															+ '">'
															+ modelo.anio
															+ '</option>');
										}
										$("#rtaAnios_cotizadorAutos").html("");
									}
								});
					}
					function actualizarValor(valor) {
						$('#rtaValorAnios_cotizadorAutos').html(valor);
						$('#valorAnios_cotizadorAutos').val(valor);
					}

				});