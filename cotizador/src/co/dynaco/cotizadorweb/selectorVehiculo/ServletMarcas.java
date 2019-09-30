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
 * Servlet implementation class ServletMarcas
 */
public class ServletMarcas extends ServletGenerico {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMarcas() {
        super();
    }

    @Override
   	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception 
   	{
   		List<String> marcas = DAO.getMarcas();
   		JSONArray jmarcas = ElementosToJSON.marcasToJSON(marcas);
   		response.setContentType("application/json; charset=utf-8");      
   		PrintWriter out = response.getWriter();
   		out.print(jmarcas);
   		out.flush();
   		
   	}

}
