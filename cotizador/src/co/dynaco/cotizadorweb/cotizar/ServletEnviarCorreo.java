package co.dynaco.cotizadorweb.cotizar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dynaco.cotizadorweb.util.EnviarCorreo;

/**
 * Servlet implementation class ServletEnviarCorreo
 */
public class ServletEnviarCorreo extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEnviarCorreo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dentr00o");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dentr   o");
		try {
			File archivo = new File( new File(ServletGenerarPDF.DIRECTORIO_IMAGENES), "correo.html");
			BufferedReader reader = new BufferedReader(new FileReader(archivo));
			String mensaje = "";
			String line = null;
			while ((line = reader.readLine()) != null) {
			    // ...
				mensaje += line + "\n";
			}
			
			reader.close();
			
			String diaExpedicion = request.getParameter("diaExpedicion");
			String mesExpedicion = request.getParameter("mesExpedicion");
			String anioExpedicion = request.getParameter("anioExpedicion");
			String diaImpresion = request.getParameter("diaImpresion");
			String mesImpresion = request.getParameter("mesImpresion");
			String anioImpresion = request.getParameter("anioImpresion");
			String diaDesde = request.getParameter("diaDesde");
			String mesDesde = request.getParameter("mesDesde");
			String anioDesde = request.getParameter("anioDesde");
			String diaHasta = request.getParameter("diaHasta");
			String mesHasta = request.getParameter("mesHasta");
			String anioHasta = request.getParameter("anioHasta");
			
			String codigoProducto = request.getParameter("codigoProducto");
			String noCotizacion = request.getParameter("noCotizacion");
			String producto = request.getParameter("producto");
			String codigoAgencia = request.getParameter("codigoAgencia");
			String agencia = request.getParameter("agencia");
			
			
			String fechaNacimiento =  request.getParameter("fechaNacimientoTomador_cotizacion");
			String direccion =  request.getParameter("direccion");
			String genero =  request.getParameter("generoTomador_cotizacion");
			String beneficiario =  request.getParameter("beneficiario");
			String nit = request.getParameter("documento");
			String correo = request.getParameter("correo");
			
			
			String cobertura1 =  request.getParameter("cobertura1_pdf");
			String cobertura2 =  request.getParameter("cobertura2_pdf");
			
			
			
			String valorAsegurado = request.getParameter("valor_cotizacion");
			String prima = request.getParameter("primaNeta");
			String deducible = request.getParameter("deducible");
			String valorDeducible =request.getParameter("valorDeducible");
			String iva = request.getParameter("iva");
			String total = request.getParameter("totalPagar");
			String gastos = request.getParameter("gastos");
			
			String asistenciaJuridica = request.getParameter("asistenciaExt_cotizacion");
			String hurtoCartera = request.getParameter("hurto_cotizacion");
			
			String fechaNacimientoTomador = request.getParameter("fechaNacimientoTomador_cotizacion");
			String generoTomador = request.getParameter("generoTomador_cotizacion"); 
			String ocupacionTomador = request.getParameter("ocupacionTomador_cotizacion");
			String mujerCooperativista = request.getParameter("mujerCooperativista_cotizacion");
			
			String modeloAuto = request.getParameter("anio_cotizacion");
			String modelo = request.getParameter("modelo_cotizacion");
			String marca = request.getParameter("marca_cotizacion");
			String version = request.getParameter("version_cotizacion");
			String anio = request.getParameter("anio_cotizacion");
			String placa = request.getParameter("placa_cotizacion");
			String vehiculoNuevo = request.getParameter("vehiculoNuevo_cotizacion");
			System.out.println(vehiculoNuevo + " ****   " );
			String ciudad = request.getParameter("ciudad_cotizacion");
			String hurto = request.getParameter("hurto_cotizacion");
			String asistencia = request.getParameter("asistenciaExt_cotizacion");
			String rce = request.getParameter("limiteRCE_cotizacion");
			String departamento = request.getParameter("departamento_cotizacion");
			
			mensaje= mensaje.replaceAll("!!diaExpedicion", diaExpedicion);
			mensaje= mensaje.replaceAll("!!mesExpedicion", mesExpedicion);
			mensaje= mensaje.replaceAll("!!anioExpedicion", anioExpedicion);
			mensaje= mensaje.replaceAll("!!diaImpresion", diaImpresion);
			mensaje= mensaje.replaceAll("!!mesImpresion", mesImpresion);
			mensaje= mensaje.replaceAll("!!anioImpresion", anioImpresion);
			mensaje= mensaje.replaceAll("!!diaDesde", diaDesde);
			mensaje= mensaje.replaceAll("!!mesDesde", mesDesde);
			mensaje= mensaje.replaceAll("!!anioDesde", anioDesde);
			mensaje= mensaje.replaceAll("!!diaHasta", diaHasta);
			mensaje= mensaje.replaceAll("!!mesHasta", mesHasta);
			mensaje= mensaje.replaceAll("!!anioHasta", anioHasta);
			
			
			
			
			mensaje= mensaje.replaceAll("!!codigoProducto", codigoProducto);
			mensaje= mensaje.replaceAll("!!noCotizacion", noCotizacion);
			mensaje= mensaje.replaceAll("!!producto", producto);
			mensaje= mensaje.replaceAll("!!codigoAgencia", codigoAgencia);
			mensaje= mensaje.replaceAll("!!agencia", agencia);
			
			
			
			
			
			//mensaje= mensaje.replaceAll("!!tomador", tomador);
			mensaje= mensaje.replaceAll("!!direccion", direccion);
			//mensaje= mensaje.replaceAll("!!asegurado", asegurado);
			mensaje= mensaje.replaceAll("!!beneficiario", beneficiario);
			mensaje= mensaje.replaceAll("!!nit", nit);
			mensaje= mensaje.replaceAll("!!correo", correo);
			
			
			System.out.println("Dentro 2222");
			
//			mensaje= mensaje.replaceAll("!!cobertura1", cobertura1 + "");
			mensaje= mensaje.replaceAll("!!cobertura2", cobertura2 + "");
			
//			String valorAsegurado = request.getParameter("valorAsegurado");
			
			mensaje= mensaje.replaceAll("!!valorAsegurado", valorAsegurado);
			mensaje= mensaje.replaceAll("!!prima", prima);
			mensaje= mensaje.replaceAll("!!deducible", "");
			mensaje= mensaje.replaceAll("!!valorDeducible", valorDeducible);
			mensaje= mensaje.replaceAll("!!iva", iva);
			mensaje= mensaje.replaceAll("!!totalPagar", total);
			mensaje= mensaje.replaceAll("!!gastos", gastos);
			
			
			System.out.println(hurtoCartera + ": hurto");
			mensaje= mensaje.replaceAll("!!asistenciaJuridica", asistenciaJuridica);
			mensaje= mensaje.replaceAll("!!hurtoCartera", hurtoCartera);
			 
			
			
			String limiteRCE = request.getParameter("limiteRCE");
			
			
//			String departamento, String hurtoCartera, String asistenciaExtendida, String limiteRCE
			OutputStream archivoPDF = new FileOutputStream(new File(ServletGenerarPDF.DIRECTORIO_IMAGENES, noCotizacion + ".pdf"));
			
//			OutputStream archivoPDF = response.getOutputStream();
			noCotizacion=noCotizacion+" Producto "+codigoProducto+" "+producto;
			ServletGenerarPDF.getBytesPDF(archivoPDF, noCotizacion, diaExpedicion, mesExpedicion, anioExpedicion, diaImpresion, 
										mesImpresion, anioImpresion, diaDesde, mesDesde, anioDesde, diaHasta, mesHasta, 
										anioHasta, direccion, valorAsegurado, beneficiario, nit, correo, cobertura2, prima, gastos, iva, total,
										
										nit,  fechaNacimientoTomador,  correo,  generoTomador, 
										ocupacionTomador,  mujerCooperativista,
										//String modelo, String valorAuto, String placa, String ciudad
										modelo,valorAsegurado, placa,ciudad,"","", vehiculoNuevo, marca, version, modelo,
										departamento, hurtoCartera, asistenciaJuridica, limiteRCE);
//			String modelo, String valorAuto, String placa, String ciudad, String hurto, String asistencia, String vehiculoNuevo, String marca, String version, String anio
			
			
			archivoPDF.flush();
			archivoPDF.close();
			
			EnviarCorreo.enviarCorreo(correo, "Cot. Autoplus", mensaje, (new File(ServletGenerarPDF.DIRECTORIO_IMAGENES, noCotizacion + ".pdf").getAbsolutePath() ), noCotizacion );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
