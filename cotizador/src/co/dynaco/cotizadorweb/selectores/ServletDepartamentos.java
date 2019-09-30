package co.dynaco.cotizadorweb.selectores;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONArray;

import co.dynaco.cotizador.dao.DepartamentoDAO;
import co.dynaco.cotizador.vo.Departamento;
import co.dynaco.cotizadorweb.util.ElementosToJSON;
import co.dynaco.cotizadorweb.util.ServletGenerico;

/**
 * Servlet implementation class ServletDepartamentos
 */
public class ServletDepartamentos extends ServletGenerico {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDepartamentos() {
        super();
    }

	@Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Departamento> departamentos = DepartamentoDAO.getDepartamentos();
		JSONArray jdepartamentos = ElementosToJSON.departamentosToJSON(departamentos);
		
		response.setContentType("application/json; charset=utf-8");      
		PrintWriter out = response.getWriter();
		out.print(jdepartamentos);
		out.flush();
	}

}
