package co.dynaco.cotizadorweb.selectorVehiculo;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONArray;

import co.dynaco.cotizador.dao.DAO;
import co.dynaco.cotizadorweb.util.ElementosToJSON;
import co.dynaco.cotizadorweb.util.ServletGenerico;

/**
 * Servlet implementation class ServletModelosMarca
 */
public class ServletModelosMarca extends ServletGenerico {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletModelosMarca() {
		super();
	}

	@Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String marca = request.getParameter("marca");
		List<String> modelos = DAO.getModeloByMarca(marca);
		JSONArray jmodelos = ElementosToJSON.modelosToJSON(modelos);

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jmodelos);
		out.flush();
	}

}
