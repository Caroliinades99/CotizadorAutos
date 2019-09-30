package co.dynaco.cotizadorweb.selectores;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONArray;

import co.dynaco.cotizador.dao.DepartamentoDAO;
import co.dynaco.cotizador.vo.Ciudad;
import co.dynaco.cotizador.vo.Departamento;
import co.dynaco.cotizadorweb.util.ElementosToJSON;
import co.dynaco.cotizadorweb.util.ServletGenerico;

/**
 * Servlet implementation class ServletCiudadesDepartamento
 */
public class ServletCiudadesDepartamento extends ServletGenerico {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCiudadesDepartamento() {
        super();
    }

    @Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	int identificador = Integer.parseInt( request.getParameter("identificadorDepartamento") );
		Departamento departamento = DepartamentoDAO.getDepartamentoByIdentificador(identificador);
    	
    	List<Ciudad> ciudades = departamento.getCiudades();
		JSONArray jciudades = ElementosToJSON.ciudadesToJSON(ciudades);
		
		response.setContentType("application/json; charset=utf-8");      
		PrintWriter out = response.getWriter();
		out.print(jciudades);
		out.flush();
	}

}
