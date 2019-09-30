package co.dynaco.cotizadorweb.cotizar;

import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.types.date.CalendarUnit;
import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang.time.DateUtils;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import co.dynaco.cotizador.dao.DAO;
import co.dynaco.cotizador.vo.Cotizador;
import co.dynaco.cotizador.vo.CotizadorMultiProducto;
import co.dynaco.cotizadorweb.util.ServletGenerico;
import co.dynaco.main.Main;
import coop.equidad.gacelaplus.cexper.servicio.Servicios;

/**
 * Servlet implementation class ServletCotizacion
 */
public class ServletCotizacion extends ServletGenerico {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCotizacion() {
		super();
	}

	@Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Calendar cFechaCotizacion = Calendar.getInstance();
		Calendar cFechaImpresion = Calendar.getInstance();
		Calendar cFechaDesde = Calendar.getInstance();
		Calendar cFechaHasta = Calendar.getInstance();
		cFechaHasta.add(Calendar.YEAR, 1);
		String prima = "";
		String gastos = "";
		String iva = "";
		String totalPagar = "";

		String producto = request.getParameter("productoSelecc");
		String correo = request.getParameter("correo");
		String documentoIdentidad = request.getParameter("documentoIdentidad");

		//
		// Linea 1:11001|CALLE 100 20 45|08002201|080|01|
		String codigoCiudadCirculacion = request.getParameter("ciudad");
		String direccion = "---";
		String codigoFasecolda = request.getParameter("version");
		//
		// Linea 2: 07|10|BYI493|NEGRO NACARAO|2215141121|

		String modeloPrueba = (request.getParameter("anio"));

		System.out.println(modeloPrueba);
		int modeloPrueba2 = Integer.parseInt(modeloPrueba) % 100;
		System.out.println(modeloPrueba2);
		modeloPrueba = modeloPrueba2 + "";
		System.out.println(modeloPrueba);

		String modelo = (Integer.parseInt(request.getParameter("anio")) % 100) + "";

		String limiteRCE = request.getParameter("rce");
		String perdidaTotal = request.getParameter("perdidaTotal");
		/*
		 * if(producto.equalsIgnoreCase("11712")){ limiteRCE ="10";
		 * 
		 * perdidaTotal="0001"; }else if(producto.equalsIgnoreCase("11713")){
		 * limiteRCE ="100"; }else if(producto.equalsIgnoreCase("11714")){
		 * limiteRCE ="10"; }
		 */

		String placa = request.getParameter("placa").toUpperCase();
		String color = request.getParameter("color");
		String numeroMotor = request.getParameter("numeroMotor") + "";

		//
		// Linea 3: 231231541|NS321321|01|SI|NO|
		String numeroChasis = request.getParameter("numeroChasis") + "";
		String numerSerie = request.getParameter("numerSerie");
		String asistenciaViajes = "01";
		String asistenciaExtendida = request.getParameter("asistenciaExtendida");
		String vehiculoReemplazo = "NO";

		//
		// Linea 4: 001|01|01|01|43|
		String gastosTransporte = "001";
		String revisionTecnicomecanica = "01";
		String hurtoCartera = request.getParameter("hurtoCartera");
		String asistenciaJuridica = "01";
		int edad = ServletCotizacion.getEdad(ServletCotizacion.getCalendar(request.getParameter("fechaNacimiento")));

		//
		// Linea 5: M|01|NO|00|01|
		String genero = request.getParameter("genero");
		String ocupacion = "0" + request.getParameter("ocupacion");
		String mujerCooperativa = request.getParameter("mujerCooperativa");

		String fomarPago = "01";
		//
		// Linea 6: 8009011045|PRUEBAS TARIFA AUTOS|8009011045|PRUEBAS TARIFA
		// AUTOS|01/03/2014|01/03/2015|25000000|";
		String nitTomador = request.getParameter("documentoIdentidad");
		String nombreTomador = "NA";
		String nitAsegurado = request.getParameter("documentoIdentidad");
		String nombreAsegurado = "NA";
		String nitBeneficiario = request.getParameter("documentoIdentidad");
		String nombreBeneficiario = "NA";
		String fechaInicio = ServletCotizacion.getFecha(cFechaDesde);
		String fechaTerminacion = ServletCotizacion.getFecha(cFechaHasta);
		String valorAsegurado = request.getParameter("valor");

		String perdidaParcial = request.getParameter("perdidaParcial");

		String rotura = request.getParameter("rotura");

		String aniosBuenaExperiencia = "00";
		try {
			System.out.println("hola");
			aniosBuenaExperiencia = Servicios.getCodigoBuenaExperiencia("1", nitTomador, placa);
		} catch (Exception e1) {
			try {
				aniosBuenaExperiencia = Servicios.getCodigoBuenaExperiencia("1", nitTomador, "AAA111");
			} catch (Exception e) {
				e.printStackTrace();
			}
			e1.printStackTrace();
		}
		String clase = DAO.getClaseCodigo(codigoFasecolda);

		System.out.println("AÑOS BUENO EXPERIENCIA " + aniosBuenaExperiencia);
		String[] data = new String[100];
		for (int i = 0; i < 100; i++) {
			data[i] = "";
		}
		if (Double.parseDouble(valorAsegurado) < 150000000) {
			data = CotizadorMultiProducto.cotizar(codigoCiudadCirculacion, direccion, codigoFasecolda, modelo,
					limiteRCE, placa, color, numeroMotor, numeroChasis, numerSerie, asistenciaViajes,
					asistenciaExtendida, vehiculoReemplazo, gastosTransporte, revisionTecnicomecanica, hurtoCartera,
					asistenciaJuridica, edad, genero, ocupacion, mujerCooperativa, aniosBuenaExperiencia, fomarPago,
					nitTomador, nombreTomador, nitAsegurado, nombreAsegurado, nitBeneficiario, nombreBeneficiario,
					fechaInicio, fechaTerminacion, valorAsegurado, perdidaParcial, perdidaTotal, clase, producto,
					rotura);
		}
		String[] datos = data[0].split("\n");
		String coberura1 = "";
		String coberura2 = "";
		int i = 0;
		JSONObject jcotizacion = new JSONObject();
		jcotizacion.put("cantidadFilas", datos.length);
		JSONArray arreglo = new JSONArray();
		while (i < datos.length) {
			if (datos[i] != null && datos[i].startsWith("Total")) {
				// Total&1358284&20000&220525&1598810
				String[] dataVal = datos[i].split("&");
				System.out.println(dataVal);
				prima = dataVal[1];
				gastos = dataVal[2];
				iva = dataVal[3];
				totalPagar = dataVal[4];
				System.out.println(
						dataVal[0] + " - " + dataVal[1] + " - " + dataVal[2] + " - " + dataVal[3] + "- " + gastos);
			} else {
				String[] dataVal = datos[i].split("&");
				if (dataVal.length >= 5) {
					JSONObject jcobertura = new JSONObject();
					jcobertura.put("descripcion", dataVal[0]);
					jcobertura.put("valor1", dataVal[1]);
					jcobertura.put("valor2", dataVal[2]);
					jcobertura.put("valor3", dataVal[3]);
					jcobertura.put("valor4", dataVal[4]);
					arreglo.put(jcobertura);
				}
			}

			i++;
		}

		String noCotizacion = data[2];
		// double dgastos = Double.parseDouble( gastos );

		jcotizacion.put("noCotizacion", noCotizacion);

		//
		// Fecha Cotizacion
		jcotizacion.put("diaFechaCotizacion", cFechaCotizacion.get(Calendar.DAY_OF_MONTH));
		jcotizacion.put("mesFechaCotizacion", cFechaCotizacion.get(Calendar.MONTH) + 1);
		jcotizacion.put("anioFechaCotizacion", cFechaCotizacion.get(Calendar.YEAR));
		// Fecha Impresion
		jcotizacion.put("diaFechaImpresion", cFechaImpresion.get(Calendar.DAY_OF_MONTH));
		jcotizacion.put("mesFechaImpresion", cFechaImpresion.get(Calendar.MONTH) + 1);
		jcotizacion.put("anioFechaImpresion", cFechaImpresion.get(Calendar.YEAR));
		// Fecha Desde
		jcotizacion.put("diaFechaDesde", cFechaDesde.get(Calendar.DAY_OF_MONTH));
		jcotizacion.put("mesFechaDesde", cFechaDesde.get(Calendar.MONTH) + 1);
		jcotizacion.put("anioFechaDesde", cFechaDesde.get(Calendar.YEAR));
		// Fecha Desde
		jcotizacion.put("diaFechaHasta", cFechaHasta.get(Calendar.DAY_OF_MONTH));
		jcotizacion.put("mesFechaHasta", cFechaHasta.get(Calendar.MONTH) + 1);
		jcotizacion.put("anioFechaHasta", cFechaHasta.get(Calendar.YEAR));
		// Informacion General
		jcotizacion.put("noCotizacion", noCotizacion);
		jcotizacion.put("codigoProducto", producto);
		if (producto.contains("11701"))
			jcotizacion.put("producto", "Autoplus Full");
		else if (producto.contains("11713"))
			jcotizacion.put("producto", "Autoplus Alta Gama");
		else if (producto.contains("11714"))
			jcotizacion.put("producto", "Autoplus Mujer");

		jcotizacion.put("codigoAgencia", "NA");
		jcotizacion.put("agencia", "NA");
		// Datos Generales
		jcotizacion.put("tomador", "NA");
		jcotizacion.put("direccion", "NA");
		jcotizacion.put("asegurado", "NA");
		jcotizacion.put("beneficiario", "NA");
		jcotizacion.put("nit", documentoIdentidad);
		jcotizacion.put("correo", correo);

		jcotizacion.put("cobertura1", arreglo);
		jcotizacion.put("cobertura2", data[0].replaceAll("&", "#"));

		jcotizacion.put("fechaNacimientoTomador", request.getParameter("fechaNacimiento"));
		jcotizacion.put("generoTomador", genero);
		jcotizacion.put("ocupacion", ocupacion);
		jcotizacion.put("mujerCooperativista", mujerCooperativa);
		jcotizacion.put("placa_cotizacion", placa);
		jcotizacion.put("anio_cotizacion", modelo);
		jcotizacion.put("version_cotizacion", codigoFasecolda);
		jcotizacion.put("departamento_cotizacion", "--");
		jcotizacion.put("ciudad_cotizacion", codigoCiudadCirculacion);
		jcotizacion.put("asistenciaExt_cotizacion", asistenciaExtendida);
		jcotizacion.put("hurto_cotizacion", hurtoCartera);

		System.out.println(arreglo);

		long lValorAsegurado;
		long lPrima;
		long liva;
		long ltotal;
		long lgastos;
		try {
			lValorAsegurado = Long.parseLong(valorAsegurado);
			lPrima = Long.parseLong(prima);
			liva = Long.parseLong(iva);
			ltotal = Long.parseLong(totalPagar);
			lgastos = Long.parseLong(gastos);
		} catch (Exception e) {
			jcotizacion.put("noCotizacion",
					"Sin Tarifa, por favor dirijase a algunos de nuestros asesores o comuniquese al #324");
			jcotizacion.put("codigoProducto", "");
			lValorAsegurado = 0;
			lPrima = 0;
			liva = 0;
			ltotal = 0;
			lgastos = 0;
			e.printStackTrace();
		}

		String sValorAsegurado = NumberFormat.getInstance().format(lValorAsegurado);
		String sPrima = NumberFormat.getInstance().format(lPrima + lgastos);
		String sIva = NumberFormat.getInstance().format(liva);
		String sTotal = NumberFormat.getInstance().format(ltotal);
		String sGastos = "0";// NumberFormat.getInstance().format(lgastos);

		// Valores
		// jcotizacion.put("valorAsegurado", sValorAsegurado);
		// jcotizacion.put("deducible", sDeducible + "%");
		// jcotizacion.put("valorDeducible", sValorDeducible );
		// jcotizacion.put("color", color);
		// jcotizacion.put("placa", placa);
		// jcotizacion.put("noChasis", "4657985654");
		// jcotizacion.put("noMotor", "453453543GHJ786");
		// jcotizacion.put("noSerie", "32423432GYRT56HYTRY");
		//
		//
		// jcotizacion.put("asistenciaViajes", "SI");
		// jcotizacion.put("asistenciaExtendida", "SI");
		// jcotizacion.put("vehiculoReemplazo", "SI" );
		// jcotizacion.put("gastosTransporte", "1SMDLV * 30 dias");
		// jcotizacion.put("revisionTecnicomecanica", "SI");
		// jcotizacion.put("hurtoCartera", hurtoCartera );
		// jcotizacion.put("asistenciaJuridica", asistenciaJuridica);

		jcotizacion.put("primaNeta", sPrima);
		jcotizacion.put("gastos", sGastos);
		jcotizacion.put("iva", sIva);
		jcotizacion.put("totalPagar", sTotal);

		// Thread.sleep(3000);

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jcotizacion);
		out.flush();

	}

	public static Calendar getCalendar(String sfecha) {
		String[] dataFecha = sfecha.split("/");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dataFecha[0]));
		c.set(Calendar.MONTH, Integer.parseInt(dataFecha[1]) - 1);
		c.set(Calendar.YEAR, Integer.parseInt(dataFecha[2]));

		return c;
	}

	public static int getEdad(Calendar cfecha) {
		Calendar hoy = Calendar.getInstance();
		// calcular la diferencia en milisengundos

		long diff = hoy.getTimeInMillis() - cfecha.getTimeInMillis();
		System.out.println(hoy.getTime() + " *** " + cfecha.getTime());
		long diffAnios = diff / ((long) ((long) 365 * (long) 24 * (long) 60 * (long) 60 * (long) 1000));
		return (int) diffAnios;

	}

	public static void main(String[] args) {
		int edad = ServletCotizacion.getEdad(getCalendar("02/01/1983"));
		System.out.println(edad);
	}

	public static String getFecha(Calendar calendar) {
		String dia = calendar.get(Calendar.DAY_OF_MONTH) + "";
		if (dia.length() == 1) {
			dia = "0" + dia;
		}
		String mes = (calendar.get(Calendar.MONTH) + 1) + "";
		if (mes.length() == 1) {
			mes = "0" + mes;
		}
		String anio = calendar.get(Calendar.YEAR) + "";
		return dia + "/" + mes + "/" + anio;
	}
}