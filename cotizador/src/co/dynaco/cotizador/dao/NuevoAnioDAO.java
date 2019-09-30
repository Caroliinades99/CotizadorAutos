package co.dynaco.cotizador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.dynaco.cotizador.vo.Anio;

public class NuevoAnioDAO {
	
	public static List<Anio> getAnioCodigo(String codigoFasecolda) throws Exception
	{
		List<Anio> anios = new ArrayList<Anio>();
		String sql = "SELECT * FROM osiris.s03107 WHERE codcla='01000030' and grupo='101' and clasif like ? ";
		Connection conn = OracleManager.getInstance().darConexion(sql);
		
		PreparedStatement stm = conn.prepareStatement(sql);
		stm.setString(1, codigoFasecolda+"%");
		ResultSet rs = stm.executeQuery();
		
		while(rs.next())
		{	
			Anio anio=NuevoAnioDAO.armarAnio(rs);
			if(anio!=null)
			anios.add(anio);
		}
		
		OracleManager.getInstance().desconectar(conn);
		return anios;
	}
	
	public static Anio armarAnio( ResultSet rs ) throws Exception
	{	
		String anio =rs.getString("clasif");
		anio=anio.substring(anio.length()-2, anio.length()); 
		int valorAnio=Integer.parseInt(anio);
		
		Calendar cal= Calendar.getInstance();
		int anio1=cal.get(Calendar.YEAR);
		
		int anio2=2000+valorAnio;
		if(valorAnio<22 && anio1-anio2<=14 && anio1-anio2>=-2 ){
			anio="20"+anio;
			
		int valor = rs.getInt("vasegmin");
			return new Anio(anio, valor+"");
		}else
			return null;
	}
	
	
	public static void main(String[] args) {
		String s= "16061087",sub;
		sub=s.substring(s.length()-2, s.length());
		System.out.println(sub);
	}
}
