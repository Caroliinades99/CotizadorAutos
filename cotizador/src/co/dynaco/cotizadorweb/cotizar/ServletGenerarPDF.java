package co.dynaco.cotizadorweb.cotizar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dynaco.cotizador.dao.CiudadDAO;
import co.dynaco.cotizador.dao.DepartamentoDAO;
import co.dynaco.cotizador.dao.RCEDAO;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class ServletGenerarPDF
 */
public class ServletGenerarPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	 public static String DIRECTORIO_IMAGENES = "C:\\Users\\Irinna\\workspace\\CotizadorWEB_Tomcat6\\WebContent";
//    public static String DIRECTORIO_IMAGENES = "C:\\Program Files\\Apache Software Foundation\\Tomcat 6.0\\webapps\\imgTemp";
//	public static String DIRECTORIO_IMAGENES = "E:\\Apache Software Foundation\\Tomcat 6.0\\webapps\\imgTemp";

	// ESTA ES LA VERDADERA
	public static String DIRECTORIO_IMAGENES = "C:\\Program Files\\Apache software foundation\\apache-tomcat-7.0.85\\webapps\\imgTemp";
	private static String IMAGEN_PDF = "cotizador-011.png";
	private static String IMAGEN_PDF_2 = "cotizador-022.png";

//	public static String DIRECTORIO_IMAGENES = "F:\\Programs Files\\Apache Software Foundation\\apache-tomcat-7.0.85_cotizador\\webapps\\cotizador\\";
//	private static String IMAGEN_PDF = "cotizador-011.png";
//	private static String IMAGEN_PDF_2 = "cotizador-022.png";

	private static String IMAGEN_INFOGRAFIA = "infografia.png";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletGenerarPDF() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPedido(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesarPedido(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("123123");

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

			String codigoProducto = request.getParameter("codigoProducto");// codigoProducto
			String noCotizacion = request.getParameter("noCotizacion");
			String producto = request.getParameter("producto");
			String codigoAgencia = request.getParameter("codigoAgencia");
			String agencia = request.getParameter("agencia");

			String fechaNacimiento = request.getParameter("fechaNacimientoTomador_cotizacion");
			String direccion = request.getParameter("direccion");
			String genero = request.getParameter("generoTomador_cotizacion");
			String beneficiario = request.getParameter("beneficiario");
			String nit = request.getParameter("documento");
			String correo = request.getParameter("correo");

			String cobertura1 = request.getParameter("cobertura1_pdf");
			String cobertura2 = request.getParameter("cobertura2_pdf");

			String valorAsegurado = request.getParameter("valor_cotizacion");
			String prima = request.getParameter("primaNeta");
			String deducible = request.getParameter("deducible");
			String valorDeducible = request.getParameter("valorDeducible");
			String iva = request.getParameter("iva");
			String total = request.getParameter("totalPagar");
			String gastos = "0";// request.getParameter("gastos");

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
			System.out.println(vehiculoNuevo + " ****   ");
			String ciudad = request.getParameter("ciudad_cotizacion");
			String hurto = request.getParameter("hurto_cotizacion");
			String asistencia = request.getParameter("asistenciaExt_cotizacion");
			String rce = request.getParameter("limiteRCE_cotizacion");
			String departamento = request.getParameter("departamento_cotizacion");
			// String ciudad = request.getParameter("departamento_cotizacion");
			response.setContentType("application/pdf");

			OutputStream out = response.getOutputStream();

			noCotizacion = noCotizacion + " Producto " + codigoProducto + " " + producto;

			ServletGenerarPDF.getBytesPDF(out, noCotizacion, diaExpedicion, mesExpedicion, anioExpedicion, diaImpresion,
					mesImpresion, anioImpresion, diaDesde, mesDesde, anioDesde, diaHasta, mesHasta, anioHasta,
					direccion, valorAsegurado, beneficiario, nit, correo, cobertura2, prima, gastos, iva, total, nit,
					fechaNacimientoTomador, correo, generoTomador, ocupacionTomador, mujerCooperativista, modelo,
					valorAsegurado, placa, ciudad, hurto, asistencia, vehiculoNuevo, marca, version, anio, departamento,
					hurtoCartera, asistenciaJuridica, rce);

			out.flush();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getBytesPDF(OutputStream out, String noCotizacion, String diaExpedicion, String mesExpedicion,
			String anioExpedicion, String diaImpresion, String mesImpresion, String anioImpresion, String diaDesde,
			String mesDesde, String anioDesde, String diaHasta, String mesHasta, String anioHasta, String direccion,
			String asegurado, String beneficiario, String nit, String correo, String cobertura, String prima,
			String gastos, String iva, String total, String documentoTomador, String fechaNacimientoTomador,
			String correoTomador, String generoTomador, String ocupacionTomador, String mujerCooperativista,
			String modelo, String valorAuto, String placa, String ciudad, String hurto, String asistencia,
			String vehiculoNuevo, String marca, String version, String anio, String departamento, String hurtoCartera,
			String asistenciaExtendida, String limiteRCE) throws Exception {

		Document documento = new Document();

		PdfWriter.getInstance(documento, out).setInitialLeading(0);
		documento.setPageSize(PageSize.LETTER);
		documento.setMargins(0, 0, 0, 0);
		documento.open();

//		File arc = new File(DIRECTORIO_IMAGENES, IMAGEN_PDF);
		File arc = new File(DIRECTORIO_IMAGENES, IMAGEN_PDF);
		System.out.println(arc.getAbsolutePath());
		BufferedImage image = ImageIO.read(arc);
		System.out.println(arc.getAbsolutePath());
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setRenderingHints(rh);
		//
		// Numero
		g2.setFont(new Font("Trebuchet MS", Font.BOLD, 50));
		// Color Color = new Color();
		g2.setColor(new Color(43, 171, 67));
		g2.drawString(noCotizacion, 525, 400);
		//
		// Escribir fecha expediciï¿½n
		g2.setFont(new Font("Trebuchet MS", Font.PLAIN, 70));
		g2.setColor(Color.BLACK);
		g2.drawString(diaExpedicion + "", 160, 610);
		g2.drawString(mesExpedicion + "", 260, 610);
		g2.drawString(anioExpedicion + "", 360, 610);
		//
		// Escribir fecha impresiï¿½n
		g2.setFont(new Font("Trebuchet MS", Font.PLAIN, 70));
		g2.setColor(Color.BLACK);
		g2.drawString(diaImpresion + "", 1980, 610);
		g2.drawString(mesImpresion + "", 2080, 610);
		g2.drawString(anioImpresion + "", 2180, 610);
		//
		// Escribir fecha desde
		g2.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		g2.setColor(Color.BLACK);
		g2.drawString(diaDesde + "", 950, 570);
		g2.drawString(mesDesde + "", 1150, 570);
		g2.drawString(anioDesde + "", 1350, 570);
		//
		// Escribir fecha hasta
		g2.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		g2.setColor(Color.BLACK);
		g2.drawString(diaHasta + "", 950, 625);
		g2.drawString(mesHasta + "", 1150, 625);
		g2.drawString(anioHasta + "", 1350, 625);
		//
		// Escribir datos generales
//		g2.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
//		g2.setColor( Color.BLACK );
//		g2.drawString( "011701", 104 , 116);
//		g2.drawString( "NA", 92 , 130);
//		g2.drawString( "NA", 70 , 143);
//		g2.drawString( "NA", 85 , 153);

		//
		// Escribir datos asegurado
		g2.setFont(new Font("Trebuchet MS", Font.PLAIN, 40));
		g2.setColor(Color.BLACK);
//		g2.drawString( "NA", 80 , 236);
//		g2.drawString(direccion + "", 85 , 248);
//		g2.drawString(asegurado + "", 88 , 261);
//		g2.drawString(beneficiario + "", 95 , 274);
		g2.drawString(nit + "", 260, 780);
		g2.drawString(correo + "", 1410, 780);

//		g2.drawString(cobertura1.replaceAll("<br/>", "\n"), 40 , 345);
//		g2.drawString(cobertura2.replaceAll("<br/>", "\n"), 315, 345);
		if (cobertura != null) {
			String[] data = cobertura.split("\n");

			g2.setFont(new Font("Tahoma", Font.PLAIN, 40));
			g2.drawString("Nombre Cobertura", 180, 930);
			g2.drawString("Vr. Aseg/Moneda", 1850, 930);
//		g2.drawString("Prima", 1700, 930 );
//		g2.drawString("Vr. Deduc", 2220, 930 );
			g2.drawString("% Deduc", 2230, 930);
			g2.setFont(new Font("Arial Narrow", Font.PLAIN, 40));
			for (int i = 0; i < data.length; i++) {
				if (data[i] != null && !data[i].equals("") && !data[i].startsWith("Total")) {
					String[] fila = data[i].split("#");
					if (fila.length >= 5) {
						System.out.println(fila[0]);
						String descrpcion = fila[0].replaceAll("Ã¡", "á");
						descrpcion = descrpcion.replaceAll("Ã©", "é");
						descrpcion = descrpcion.replaceAll("Ã­", "í");
						descrpcion = descrpcion.replaceAll("Ã³", "ó");
						descrpcion = descrpcion.replaceAll("Ã±", "ñ");
						g2.drawString(descrpcion, 180, 1025 + (i * 50));
						g2.drawString(fila[1].trim(), 1850, 1025 + (i * 50));
						g2.drawString(fila[2].trim(), 2230, 1025 + (i * 50));
						g2.drawString(fila[3].trim(), 2230, 1025 + (i * 50));
						g2.drawString(fila[4].trim(), 2230, 1025 + (i * 50));
					}

				}

			}

		}
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Trebuchet MS", Font.PLAIN, 50));
		g2.drawString(prima + "", 150, 2650);

//		g2.drawString(gastos == null ? "0" : gastos, 800, 2650);
		g2.drawString(iva + "", 1500, 2650);
		g2.drawString(total + "", 2000, 2650);

		BufferedImage image_2 = ImageIO.read(new File(DIRECTORIO_IMAGENES, IMAGEN_PDF_2));

		//
		// Valores

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);
		byte[] arBytes = baos.toByteArray();
		Image foto = Image.getInstance(arBytes);
		foto.setAlignment(Chunk.ALIGN_BASELINE);
		foto.scaleAbsolute(610, 750);

		Graphics2D g2_2 = (Graphics2D) image_2.getGraphics();

		RenderingHints rh2 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2_2.setRenderingHints(rh2);

		g2_2.setColor(Color.BLACK);
		g2_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		g2_2.drawString(documentoTomador, 750, 810);
		if (fechaNacimientoTomador != null)
			g2_2.drawString(fechaNacimientoTomador, 1740, 810);
		g2_2.drawString(correoTomador + "", 320, 910);
		g2_2.drawString(generoTomador + "", 1500, 910);
		g2_2.drawString(ocupacionTomador + "", 400, 1010);
		g2_2.drawString(mujerCooperativista + "", 1870, 1010);

		g2_2.drawString(vehiculoNuevo + "", 500, 1430);
		g2_2.drawString(modelo + "", 1530, 1430);
		g2_2.drawString(placa + "", 300, 1530);
		g2_2.drawString(version + "", 1530, 1530);
		g2_2.drawString(marca + "", 300, 1630);
		g2_2.drawString(anio + "", 1480, 1630);
		g2_2.drawString(valorAuto + "", 300, 1740);

		if (departamento != null)
			g2_2.drawString(
					DepartamentoDAO.getDepartamentoByIdentificador(Integer.parseInt(departamento)).getNombre() + "",
					820, 2150);
		if (limiteRCE != null)
			g2_2.drawString(RCEDAO.getRCE(Integer.parseInt(limiteRCE)).getNombre(), 1630, 2150);
		if (ciudad != null)
			g2_2.drawString(CiudadDAO.getCiudadByIdentificador(Integer.parseInt(ciudad)).getNombre(), 660, 2260);
		g2_2.drawString(asistenciaExtendida + "", 1820, 2260);
		String sHurto = "SI";
		if (hurtoCartera != null)
			if (!hurtoCartera.equals("01")) {
				sHurto = "NO";
			}
		g2_2.drawString(sHurto + "", 470, 2370);

		ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		ImageIO.write(image_2, "png", baos2);
		byte[] arBytes2 = baos2.toByteArray();
		Image foto2 = Image.getInstance(arBytes2);
		foto2.setAlignment(Chunk.ALIGN_BASELINE);
		foto2.scaleAbsolute(610, 750);

		documento.add(foto);
		documento.newPage();
		documento.add(foto2);
		documento.newPage();
		/*
		 * Image foto3 = Image.getInstance((new File(DIRECTORIO_IMAGENES,
		 * IMAGEN_INFOGRAFIA).getAbsolutePath())); foto3.scaleAbsolute(610, 750);
		 * documento.add(foto3);
		 */

		documento.close();
	}

}