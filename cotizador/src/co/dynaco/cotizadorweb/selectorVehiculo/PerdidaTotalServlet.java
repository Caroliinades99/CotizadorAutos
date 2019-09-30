package co.dynaco.cotizadorweb.selectorVehiculo;

import co.dynaco.cotizadorweb.util.ServletGenerico;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;

public class PerdidaTotalServlet extends ServletGenerico {
	private static final long serialVersionUID = 1L;

	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String marca = request.getParameter("marca");
		String prod = request.getParameter("plan");
		JSONArray jmodelos = new JSONArray();
		if (marca == null) {
			marca = "";
		}
		if (prod.equalsIgnoreCase("11701")) {
			if ((marca.trim().equalsIgnoreCase("KIA"))) {
				JSONObject jmodelo = new JSONObject();
				jmodelo.put("id", "002");
				jmodelo.put("nombre", "10% Minimo 1 SMMLV");
				jmodelos.put(jmodelo);
			} else {
				JSONObject jmodelo = new JSONObject();
				jmodelo.put("id", "001");
				jmodelo.put("nombre", "1 SMMLV");
				jmodelos.put(jmodelo);
				jmodelo = new JSONObject();
				jmodelo.put("id", "002");
				jmodelo.put("nombre", "10% Minimo 1 SMMLV");
				jmodelos.put(jmodelo);
			}
		} else if (prod.equalsIgnoreCase("11712")) {
			JSONObject jmodelo = new JSONObject();
			jmodelo.put("id", "0101");
			jmodelo.put("nombre", "10% Minimo 1 SMMLV");
			jmodelos.put(jmodelo);
		} else if (prod.equalsIgnoreCase("11713")) {
			JSONObject jmodelo = new JSONObject();
			jmodelo.put("id", "0000");
			jmodelo.put("nombre", "Franquicia");
			jmodelos.put(jmodelo);
			jmodelo = new JSONObject();
			jmodelo.put("id", "0001");
			jmodelo.put("nombre", "1SMML");
			jmodelos.put(jmodelo);
			jmodelo = new JSONObject();
			jmodelo.put("id", "0101");
			jmodelo.put("nombre", "10% Minimo 1 SMML");
			jmodelos.put(jmodelo);
			jmodelo = new JSONObject();
			jmodelo.put("id", "0204");
			jmodelo.put("nombre", "20% Minimo 4 SMML");
			jmodelos.put(jmodelo);
		} else if (prod.equalsIgnoreCase("11714")) {
			JSONObject jmodelo = new JSONObject();
			jmodelo.put("id", "0000");
			jmodelo.put("nombre", "Franquicia");
			jmodelos.put(jmodelo);
			jmodelo = new JSONObject();
			jmodelo.put("id", "0001");
			jmodelo.put("nombre", "1SMML");
			jmodelos.put(jmodelo);
			jmodelo = new JSONObject();
			jmodelo.put("id", "0101");
			jmodelo.put("nombre", "10% Minimo 1 SMMLV");
			jmodelos.put(jmodelo);
		}
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jmodelos);
		out.flush();
	}
}
