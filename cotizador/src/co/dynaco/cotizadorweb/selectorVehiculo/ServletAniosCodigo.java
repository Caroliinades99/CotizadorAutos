package co.dynaco.cotizadorweb.selectorVehiculo;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONArray;

import co.dynaco.cotizador.dao.AnioDAO;
import co.dynaco.cotizador.dao.NuevoAnioDAO;
import co.dynaco.cotizador.vo.Anio;
import co.dynaco.cotizadorweb.util.ElementosToJSON;
import co.dynaco.cotizadorweb.util.ServletGenerico;

/**
 * Servlet implementation class ServletAniosCodigo
 */
public class ServletAniosCodigo extends ServletGenerico {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAniosCodigo() {
        super();
        
    } 


	@Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String codigoFasecolda = request.getParameter("codigoFasecolda");
		
		//aqui
		
		List<Anio> anios = new ArrayList<Anio>();
		List<Anio> aniosT = new ArrayList<Anio>();
		aniosT = NuevoAnioDAO.getAnioCodigo(codigoFasecolda);//AnioDAO.getAnioCodigo(codigoFasecolda);
		int anioActual=Calendar.getInstance().get(Calendar.YEAR);
		anioActual=anioActual-15;
		for(Anio a:aniosT){
			Integer i=new Integer(a.getAnio());
			if(i>=anioActual)
				anios.add(a);
		}
		
		JSONArray janios = ElementosToJSON.aniosToJSON(anios);
		
		response.setContentType("application/json; charset=utf-8");      
		PrintWriter out = response.getWriter();
		out.print(janios);
		out.flush();
	}

}
