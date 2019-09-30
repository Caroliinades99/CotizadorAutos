package co.dynaco.cotizadorweb.selectores;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONArray;

import co.dynaco.cotizador.dao.AniosExperienciaDAO;
import co.dynaco.cotizador.vo.AniosExperiencia;
import co.dynaco.cotizadorweb.util.ElementosToJSON;
import co.dynaco.cotizadorweb.util.ServletGenerico;

/**
 * Servlet implementation class ServletAniosExperiencia
 */
public class ServletAniosExperiencia extends ServletGenerico {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAniosExperiencia() {
        super();
    }

	@Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<AniosExperiencia> aniosExperiencias = AniosExperienciaDAO.getAniosExperiencia();
		JSONArray janiosExperiencia = ElementosToJSON.aniosExperienciaToJSON(aniosExperiencias);
		
		response.setContentType("application/json; charset=utf-8");      
		PrintWriter out = response.getWriter();
		out.print(janiosExperiencia);
		out.flush();
	}

}