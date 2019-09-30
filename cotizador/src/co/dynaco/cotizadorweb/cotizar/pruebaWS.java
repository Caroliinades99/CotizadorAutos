package co.dynaco.cotizadorweb.cotizar;

import coop.equidad.gacelaplus.cexper.servicio.Servicios;

public class pruebaWS {
	public static void main(String[] args) {
		try {
			Servicios.getCodigoBuenaExperiencia("1", "80112014", "BMV326" );
			
			//ok("1", "1026250666", "DBN009" );// ("1", "7704799", "KLX121" ); Error por numero negativo
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
