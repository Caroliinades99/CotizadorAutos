package co.dynaco.cotizador.vo;

import co.dynaco.cotizador.dao.OracleManager;
import java.sql.CallableStatement;
import java.sql.Connection;

public class Cotizador {
	public Cotizador() {
	}

	public static void main(String[] args) {
		try {
			cotizar("11001", "CALLE 100 20 45", "08002201", "07", "10", "BYI493", "NEGRO NACARAO", "2215141121",
					"231231541", "NS321321", "01", "SI", "NO", "001", "01", "01", "01", 43, "M", "01", "NO", "00", "01",
					"8009011045", "PRUEBAS TARIFA AUTOS", "8009011045", "PRUEBAS TARIFA AUTOS", "", "", "01/03/2014",
					"01/03/2015", "25000000", "001", "001", "08");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String[] cotizar(String codigoCiudadCirculacion, String direccion, String codigoFasecolda,
			String modelo, String limiteRCE, String placa, String color, String numeroMotor, String numeroChasis,
			String numerSerie, String asistenciaViajes, String asistenciaExtendida, String vehiculoReemplazo,
			String gastosTransporte, String revisionTecnicomecanica, String hurtoCartera, String asistenciaJuridica,
			int edad, String genero, String ocupacion, String mujerCooperativa, String aniosBuenaExperiencia,
			String fomarPago, String nitTomador, String nombreTomador, String nitAsegurado, String nombreAsegurado,
			String nitBeneficiario, String nombreBeneficiario, String fechaInicio, String fechaTerminacion,
			String valorAsegurado, String perdidaParcial, String perdidaTotal, String clase) throws Exception {
		
		String[] dataSalida = new String[3];
		String datosEntrada = getDatosIniciales(codigoCiudadCirculacion, direccion, codigoFasecolda, modelo, limiteRCE,
				placa, color, numeroMotor, numeroChasis, numerSerie, asistenciaViajes, asistenciaExtendida,
				vehiculoReemplazo, gastosTransporte, revisionTecnicomecanica, hurtoCartera, asistenciaJuridica, edad,
				genero, ocupacion, mujerCooperativa, aniosBuenaExperiencia, fomarPago, nitTomador, nombreTomador,
				nitAsegurado, nombreAsegurado, nitBeneficiario, nombreBeneficiario, fechaInicio, fechaTerminacion,
				valorAsegurado, perdidaParcial, perdidaTotal, clase);
		String sql = "{CALL Osiris.tarifavehiculos(700, ?, ?, ?, ?, 0)}";

		Connection conn = OracleManager.getInstance().darConexion(sql);

		CallableStatement stm = conn.prepareCall(sql);
		stm.setString(1, datosEntrada);
		stm.registerOutParameter(2, -1);
		stm.registerOutParameter(3, 4);
		stm.registerOutParameter(4, 12);

		stm.executeQuery();

		dataSalida[0] = stm.getString(2);
		dataSalida[1] = stm.getString(3);
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
		String datosEntrada = codigoCiudadCirculacion + "|";
		datosEntrada = datosEntrada + direccion + "|";
		datosEntrada = datosEntrada + codigoFasecolda + "|";
		datosEntrada = datosEntrada + codigoFasecolda.substring(0, 3) + "|";
		datosEntrada = datosEntrada + getTipoVehiculo(clase) + "|";

		datosEntrada = datosEntrada + modelo + "|";
		datosEntrada = datosEntrada + limiteRCE + "|";
		datosEntrada = datosEntrada + placa + "|";
		datosEntrada = datosEntrada + color + "|";
		datosEntrada = datosEntrada + numeroMotor + "|";

		datosEntrada = datosEntrada + numeroChasis + "|";
		datosEntrada = datosEntrada + numerSerie + "|";
		datosEntrada = datosEntrada + asistenciaViajes + "|";
		datosEntrada = datosEntrada + asistenciaExtendida + "|";
		datosEntrada = datosEntrada + vehiculoReemplazo + "|";

		datosEntrada = datosEntrada + gastosTransporte + "|";
		datosEntrada = datosEntrada + revisionTecnicomecanica + "|";
		datosEntrada = datosEntrada + hurtoCartera + "|";
		datosEntrada = datosEntrada + asistenciaJuridica + "|";
		datosEntrada = datosEntrada + edad + "|";

		datosEntrada = datosEntrada + genero + "|";
		datosEntrada = datosEntrada + ocupacion + "|";
		datosEntrada = datosEntrada + mujerCooperativa + "|";
		datosEntrada = datosEntrada + aniosBuenaExperiencia + "|";
		datosEntrada = datosEntrada + fomarPago + "|";

		datosEntrada = datosEntrada + nitTomador + "|";
		datosEntrada = datosEntrada + nombreTomador + "|";
		datosEntrada = datosEntrada + nitAsegurado + "|";
		datosEntrada = datosEntrada + nombreAsegurado + "|";

		datosEntrada = datosEntrada + fechaInicio + "|";
		datosEntrada = datosEntrada + fechaTerminacion + "|";
		datosEntrada = datosEntrada + valorAsegurado + "|";
		datosEntrada = datosEntrada + perdidaTotal + "|";
		datosEntrada = datosEntrada + perdidaParcial + "|";
		System.out.println(datosEntrada);
		return datosEntrada;
	}

	public static String getTipoVehiculo(String tipo) {
		 String retorno = "01";
		    if (tipo.toUpperCase().startsWith("CAMIONETA".toUpperCase())) {
		      retorno = "06";
		    }
		    if (tipo.toUpperCase().startsWith("PICKUP DOBLE".toUpperCase())) {
		      retorno = "21";
		    }
		    if (tipo.toUpperCase().startsWith("PICKUP SEN".toUpperCase())) {
		      retorno = "20";
		    }
		    if (tipo.toUpperCase().startsWith("CAMPERO".toUpperCase())) {
		      retorno = "08";
		    }
		    return retorno;
		  }
}
