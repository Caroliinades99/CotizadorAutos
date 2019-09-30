package co.dynaco.cotizadorweb.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletImagenCaptcha
 */
public class ServletImagenCaptcha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletImagenCaptcha() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cantidadCaracteres = ((int) (Math.random() * 765765757))%8;
		if(cantidadCaracteres < 6){
			cantidadCaracteres = 5;
		}
		
		BufferedImage bi = new BufferedImage( 600, 150, BufferedImage.TYPE_INT_RGB );
		Graphics2D g = (Graphics2D)bi.getGraphics();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 600, 150);
		Font font = new Font("Arial", Font.PLAIN, 50);
		g.setFont(font);
		String texto = "";
		g.setColor(Color.BLACK);
		for(int i = 0; i < cantidadCaracteres;i++)
		{
			int numero = ((int) (Math.random() * 576849))%25;
			int altura = ((int) (Math.random() * 576849))%80;
			char letra = (char) (65 + numero);
			texto = texto + letra;
			g.drawString(letra + "", 120 + (i*55), 60 + altura );
		}
		
		request.getSession().setAttribute("captcha", texto);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write( bi, "jpg", baos );
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		
		response.setContentType("image/jpeg");  
		response.setHeader("Content-Disposition","attachment;filename=\"captcha.jpg\"");  
		

		
//		byte[] arBytes = new byte[10*1048576]; 
//		bi.read(arBytes);  
        ServletOutputStream op = response.getOutputStream();  
        op.write(imageInByte);  
        op.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
