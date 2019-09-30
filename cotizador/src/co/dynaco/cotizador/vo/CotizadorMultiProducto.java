package co.dynaco.cotizador.vo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import co.dynaco.cotizador.dao.OracleManager;

public class CotizadorMultiProducto extends Cotizador {

	public static String[] cotizar(String codigoCiudadCirculacion, String direccion, String codigoFasecolda,
			String modelo, String limiteRCE, String placa, String color, String numeroMotor, String numeroChasis,
			String numerSerie, String asistenciaViajes, String asistenciaExtendida, String vehiculoReemplazo,
			String gastosTransporte, String revisionTecnicomecanica, String hurtoCartera, String asistenciaJuridica,
			int edad, String genero, String ocupacion, String mujerCooperativa, String aniosBuenaExperiencia,
			String fomarPago, String nitTomador, String nombreTomador, String nitAsegurado, String nombreAsegurado,
			String nitBeneficiario, String nombreBeneficiario, String fechaInicio, String fechaTerminacion,
			String valorAsegurado, String perdidaParcial, String perdidaTotal, String clase, String producto,
			String rotura) throws Exception {
		String[] dataSalida = new String[3];

		if (genero.equalsIgnoreCase("PJ"))
			edad = 0;

		String datosEntrada = Cotizador.getDatosIniciales(codigoCiudadCirculacion, direccion, codigoFasecolda, modelo,
				limiteRCE, placa, color, numeroMotor, numeroChasis, numerSerie, asistenciaViajes, asistenciaExtendida,
				vehiculoReemplazo, gastosTransporte, revisionTecnicomecanica, hurtoCartera, asistenciaJuridica, edad,
				genero, ocupacion, mujerCooperativa, aniosBuenaExperiencia, fomarPago, nitTomador, nombreTomador,
				nitAsegurado, nombreAsegurado, nitBeneficiario, nombreBeneficiario, fechaInicio, fechaTerminacion,
				valorAsegurado, perdidaParcial, perdidaTotal, clase);

		
		
		System.out.println("ROTURAAAAAAA " +rotura);
		datosEntrada = datosEntrada + "||||||||0" + producto + "|||||||||||||||||||||||||||||||" + rotura + "||||||";

		// al hacer esto, es adentro donde se totea
		String sql = "{CALL Osiris.tarifavehiculosmultiproducto(700, ?, ?, ?, ?, 0)}";
		// 1 2 3 4
		Connection conn = OracleManager.getInstance().darConexion(sql);

		CallableStatement stm = conn.prepareCall(sql);
		stm.setString(1, datosEntrada);
		stm.registerOutParameter(2, Types.LONGVARCHAR);
		stm.registerOutParameter(3, Types.INTEGER);
		stm.registerOutParameter(4, Types.VARCHAR);

		stm.executeQuery();

		dataSalida[0] = stm.getString(2);
		dataSalida[1] = stm.getInt(3) + "";
		dataSalida[2] = stm.getString(4);
		System.out.println(dataSalida[0]);
		System.out.println(dataSalida[1] + "////");
		System.out.println(dataSalida[2]);
		OracleManager.getInstance().desconectar(conn);

		return dataSalida;
	}

	public static String getDatosIniciales(String codigoCiudadCirculacion, String direccion, String codigoFasecolda,
			String modelo, String limiteRCE, String placa, String color, String numeroMotor, String numeroChasis,
			String numerSerie, String asistenciaViajes, String asistenciaExtendida, String vehiculoReemplazo,
			String gastosTransporte, String revisionTecnicomecanica, String hurtoCartera, String asistenciaJuridica,
			int edad, String genero, String ocupacion, String mujerCooperativa, String aniosBuenaExperiencia,
			String fomarPago, String nitTomador, String nombreTomador, String nitAsegurado, String nombreAsegurado,
			String nitBeneficiario, String nombreBeneficiario, String fechaInicio, String fechaTerminacion,
			String valorAsegurado, String perdidaParcial, String perdidaTotal, String clase) throws Exception {
		// String datosEntrada =
		// 11001|CALLE 100 20 45|08002201|080|01|
		// 07|10|BYI493|NEGRO NACARAO|2215141121|
		// 231231541|NS321321|01|SI|NO|
		// 001|01|01|01|43|
		// M|01|NO|00|01|
		// 8009011045|PRUEBAS TARIFA AUTOS|8009011045|PRUEBAS TARIFA
		// AUTOS|01/03/2014|01/03/2015|25000000|";
		// 1
		String datosEntrada = codigoCiudadCirculacion + "|";
		datosEntrada += direccion + "|";
		datosEntrada += codigoFasecolda + "|";
		datosEntrada += codigoFasecolda.substring(0, 3) + "|";
		datosEntrada += getTipoVehiculo(codigoFasecolda.substring(3, 5)) + "|";
		// 6
		datosEntrada += modelo + "|";
		datosEntrada += limiteRCE + "|";
		datosEntrada += placa + "|";
		datosEntrada += color + "|";
		datosEntrada += numeroMotor + "|";
		// 11
		datosEntrada += numeroChasis + "|";
		datosEntrada += numerSerie + "|";
		datosEntrada += asistenciaViajes + "|";
		datosEntrada += asistenciaExtendida + "|";
		datosEntrada += vehiculoReemplazo + "|";
		// 16
		datosEntrada += gastosTransporte + "|";
		datosEntrada += revisionTecnicomecanica + "|";
		datosEntrada += hurtoCartera + "|";
		datosEntrada += asistenciaJuridica + "|";
		datosEntrada += edad + "|";
		// 21
		// String genero, String ocupacion, String mujerCooperativa, int
		// aniosBuenaExperiencia, int fomarPago
		datosEntrada += genero + "|";
		datosEntrada += ocupacion + "|";
		datosEntrada += mujerCooperativa + "|";
		datosEntrada += aniosBuenaExperiencia + "|";
		datosEntrada += fomarPago + "|";
		// 26
		// String nitTomador, String nombreTomador, String nitAsegurado, String
		// nombreAsegurado, String nitBeneficiario,
		datosEntrada += nitTomador + "|";
		datosEntrada += nombreTomador + "|";
		datosEntrada += nitAsegurado + "|";
		datosEntrada += nombreAsegurado + "|";
		// datosEntrada += nitBeneficiario + "|";
		// 31
		// String nombreBeneficiario, String fechaInicio, String
		// fechaTerminacion, String valorAsegurado
		// datosEntrada += nombreBeneficiario + "|";
		datosEntrada += fechaInicio + "|";
		datosEntrada += fechaTerminacion + "|";
		datosEntrada += valorAsegurado + "|";
		datosEntrada += perdidaTotal + "|";
		datosEntrada += perdidaParcial + "|";
		System.out.println(datosEntrada);
		return datosEntrada;
	}

	public static String getTipoVehiculo(String tipo) {
		String retorno = "00";

		if (tipo.equalsIgnoreCase("01") || tipo.equalsIgnoreCase("02") || tipo.equalsIgnoreCase("06")
				|| tipo.equalsIgnoreCase("08") || tipo.equalsIgnoreCase("20") || tipo.equalsIgnoreCase("21"))
			retorno = tipo;
		return retorno;
	}

	public static void main(String[] args) {
		System.out.println("05806057".substring(3, 5));
		System.out.println("05806057".substring(3, 6));
	}

}
