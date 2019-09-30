package co.dynaco.cotizadorweb.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;

/**
 * Servlet implementation class ServletTextoCaptcha
 */
public class ServletTextoCaptcha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTextoCaptcha() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			JSONObject obj = new JSONObject();
			obj.put("captcha", request.getSession().getAttribute("captcha") + "");
			
			
			response.setContentType("application/json; charset=utf-8");      
			PrintWriter out = response.getWriter();
			out.print(obj);
			out.flush();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
