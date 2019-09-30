package co.dynaco.cotizadorweb.selectores;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONArray;

import co.dynaco.cotizador.dao.OcupacionDAO;
import co.dynaco.cotizador.vo.Ocupacion;
import co.dynaco.cotizadorweb.util.ElementosToJSON;
import co.dynaco.cotizadorweb.util.ServletGenerico;

/**
 * Servlet implementation class ServletOcupaciones
 */
public class ServletOcupaciones extends ServletGenerico {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOcupaciones() {
        super();
    }

    @Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		List<Ocupacion> ocupaciones = OcupacionDAO.getOcupaciones();
		JSONArray jocupaciones = ElementosToJSON.ocupacionesToJSON(ocupaciones);
		response.setContentType("application/json; charset=utf-8");      
		PrintWriter out = response.getWriter();
		out.print(jocupaciones);
		out.flush();
		
	}
}
