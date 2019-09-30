package co.dynaco.cotizadorweb.selectorVehiculo;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONArray;

import co.dynaco.cotizador.dao.DAO;
import co.dynaco.cotizador.vo.Version;
import co.dynaco.cotizadorweb.util.ElementosToJSON;
import co.dynaco.cotizadorweb.util.ServletGenerico;

/**
 * Servlet implementation class ServletVersionesMarcaModelo
 */
public class ServletVersionesMarcaModelo extends ServletGenerico {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVersionesMarcaModelo() {
        super();
        // TODO Auto-generated constructor stub
    }


	@Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		List<Version> versiones = DAO.getVersionesCodigoFasecolda(marca, modelo);
		JSONArray jversiones = ElementosToJSON.versionesToJSON(versiones);
		
		response.setContentType("application/json; charset=utf-8");      
		PrintWriter out = response.getWriter();
		out.print(jversiones);
		out.flush();
	}

}
