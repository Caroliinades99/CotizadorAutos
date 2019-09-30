package co.dynaco.cotizadorweb.util;

import java.io.File;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import uniandes.cupi2.mailer.EnvioException;
import coop.equidad.gacelaplus.cexper.servicio.PasarSSL;


public class EnviarCorreo {

	public static final String SMTP_HOST_NAME = "192.168.200.88";
	
	public static final String SMTP_AUTH_USER = "wilson.jaime@laequidadseguros.coop";
	public static final String SMTP_AUTH_PWD  = "MonaguillO1941";


	
	/**
     * Env�a un conjunto de archivos a un conjunto de destinatarios
     * @param archivos Archivos adjuntos en el archivo
     * @param destinatarios Destinatarios del correo con los archivos
     * @throws EnvioException En caso de ocurrir un error al enviar el mail
     */
    public static void enviarCorreo( String destinatario, String asunto, String mensaje, String datosArchivo, String numeroCotizacion) throws Exception
    {
    	Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.port", "25");
//		props.put("mail.smtps.socketFactory.port", "25");
//		props.put("mail.smtps.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "false");
		props.put("mail.debug", "true");
		props.put("mail.smtp.starttls.enable", "true");
		// I tried this by itself and also together with ssl.enable)
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.transport.protocol.", "smtp");
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(SMTP_AUTH_USER,SMTP_AUTH_PWD);
				}
			});
 
		try {
			
			Message message = new MimeMessage(session);
			Multipart multipart = new MimeMultipart("alternative");
			BodyPart part2 = new MimeBodyPart();
			part2.setContent(mensaje , "text/html");

			multipart.addBodyPart(part2);
			
			
			// Adjunto
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(new File(datosArchivo ));
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName( numeroCotizacion + ".pdf" );
			multipart.addBodyPart(messageBodyPart);
			
			
			message.setFrom(new InternetAddress(  "<autoplus@laequidadseguros.coop>" ));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(  destinatario ));
			message.setSubject(asunto);
			message.setContent(multipart);
			
			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
			    public X509Certificate[] getAcceptedIssuers(){return null;}
			    public void checkClientTrusted(X509Certificate[] certs, String authType){}
			    public void checkServerTrusted(X509Certificate[] certs, String authType){}
			}};

			// Install the all-trusting trust manager
			try {
			    SSLContext sc = SSLContext.getInstance("TLS");
			    sc.init(null, trustAllCerts, new SecureRandom());
			    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			} catch (Exception e) {
			    ;
			}
			PasarSSL.main();
			Transport trnsport;
			trnsport = session.getTransport("smtp");
			trnsport.connect();
			trnsport.sendMessage(message, message.getAllRecipients());
			trnsport.close();
			
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }

	public static class SMTPAuthenticator extends javax.mail.Authenticator {
	    public PasswordAuthentication getPasswordAuthentication() {
	       String username = SMTP_AUTH_USER;
	       String password = SMTP_AUTH_PWD;
	       return new PasswordAuthentication(username, password);
	    }
	}
}
