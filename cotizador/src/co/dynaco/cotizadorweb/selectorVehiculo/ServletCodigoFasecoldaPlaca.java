package co.dynaco.cotizadorweb.selectorVehiculo;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONObject;

import co.dynaco.cotizador.dao.DAO;
import co.dynaco.cotizadorweb.util.ServletGenerico;
import coop.equidad.gacelaplus.cexper.servicio.Servicios;

/**
 * Servlet implementation class ServletCodigoFasecoldaPlaca
 */
public class ServletCodigoFasecoldaPlaca extends ServletGenerico {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCodigoFasecoldaPlaca() {
        super();
    }

	@Override
	protected void procesarPedido(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String placa = request.getParameter("placa");
		String []data = Servicios.getCodigoFasecolda(placa);
//		System.out.println( data[0] + " - " + data[1] + " - " + data[2]);
		
		JSONObject objeto = new JSONObject();
		if( data != null )
		{
			objeto.put("respuesta", "exito");
			objeto.put("codigoFasecolda", data[0]);
			objeto.put("anio", data[1]);
			objeto.put("valorActual", data[2]);
			objeto.put("marca",  DAO.getMarcaCodigo(data[0]) );
			objeto.put("modelo",  DAO.getModeloCodigo(data[0]) );
			objeto.put("version",  DAO.getVersionCodigo(data[0]) );
		}else{
			objeto.put("respuesta", "no_exito");
		}
		
		
		response.setContentType("application/json; charset=utf-8");      
		PrintWriter out = response.getWriter();
		out.print(objeto);
		out.flush();
	}

}
