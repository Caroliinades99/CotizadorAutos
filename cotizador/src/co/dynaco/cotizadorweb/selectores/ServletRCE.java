package co.dynaco.cotizadorweb.selectores;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONArray;

import co.dynaco.cotizador.dao.RCEDAO;
import co.dynaco.cotizador.vo.RCE;
import co.dynaco.cotizadorweb.util.ElementosToJSON;
import co.dynaco.cotizadorweb.util.ServletGenerico;

/**
 * Servlet implementation class ServletRCE
 */
public class ServletRCE extends ServletGenerico {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRCE() {
        super();
    }

    @Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<RCE> rces = RCEDAO.getRCES();
		JSONArray jrces = ElementosToJSON.rcesToJSON(rces);
		
		
		
		response.setContentType("application/json; charset=utf-8");      
		PrintWriter out = response.getWriter();
		out.print(jrces);
		out.flush();
	}

}
