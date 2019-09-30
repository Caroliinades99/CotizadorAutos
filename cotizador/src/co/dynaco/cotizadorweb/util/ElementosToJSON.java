package co.dynaco.cotizadorweb.util;

import java.util.List;

import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;

import co.dynaco.cotizador.vo.Anio;
import co.dynaco.cotizador.vo.AniosExperiencia;
import co.dynaco.cotizador.vo.Ciudad;
import co.dynaco.cotizador.vo.Departamento;
import co.dynaco.cotizador.vo.Ocupacion;
import co.dynaco.cotizador.vo.RCE;
import co.dynaco.cotizador.vo.Version;

public class ElementosToJSON {
	// --------------------------------------------------
	// RCEs
	// --------------------------------------------------
	
	public static JSONArray aniosExperienciaToJSON(List<AniosExperiencia> aniosExperiencias) throws Exception
	{
		JSONArray janiosExperiencias = new JSONArray();
		
		for( int i = 0; i < aniosExperiencias.size();i++ )
		{
			AniosExperiencia aniosExperiencia = aniosExperiencias.get(i);
			JSONObject janiosExperiencia = new JSONObject();
			janiosExperiencia.put("identificador", aniosExperiencia.getIdentificador() );
			janiosExperiencia.put("nombre", aniosExperiencia.getNombre());
			janiosExperiencias.put(janiosExperiencia);
		}
		
		return janiosExperiencias;
	}
	// --------------------------------------------------
	// RCEs
	// --------------------------------------------------
	
	public static JSONArray rcesToJSON(List<RCE> rces) throws Exception
	{
		JSONArray jrces = new JSONArray();
		
		for( int i = 0; i < rces.size();i++ )
		{
			RCE rce = rces.get(i);
			JSONObject jciudad = new JSONObject();
			jciudad.put("identificador", rce.getIdentificador() );
			jciudad.put("nombre", rce.getNombre());
			jrces.put(jciudad);
		}
		
		return jrces;
	}
	// --------------------------------------------------
	// Ciudades
	// --------------------------------------------------
	
	public static JSONArray ciudadesToJSON(List<Ciudad> ciudades) throws Exception
	{
		JSONArray jciudades = new JSONArray();
		
		for( int i = 0; i < ciudades.size();i++ )
		{
			Ciudad ciudad = ciudades.get(i);
			JSONObject jciudad = new JSONObject();
			jciudad.put("identificador", ciudad.getIdentificador() );
			jciudad.put("nombre", ciudad.getNombre());
			jciudades.put(jciudad);
		}
		
		return jciudades;
	}
	// --------------------------------------------------
	// Departamentos
	// --------------------------------------------------
	
	public static JSONArray departamentosToJSON(List<Departamento> departamentos) throws Exception
	{
		JSONArray jdepartamentos = new JSONArray();
		
		for( int i = 0; i < departamentos.size();i++ )
		{
			Departamento departamento = departamentos.get(i);
			JSONObject jdepartamento = new JSONObject();
			jdepartamento.put("identificador", departamento.getIdentificador() );
			jdepartamento.put("nombre", departamento.getNombre());
			jdepartamentos.put(jdepartamento);
		}
		
		return jdepartamentos;
	}
	// --------------------------------------------------
	// Ocupacion
	// --------------------------------------------------
	
	public static JSONArray ocupacionesToJSON(List<Ocupacion> ocupaciones) throws Exception
	{
		JSONArray jocupaciones = new JSONArray();
		
		for( int i = 0; i < ocupaciones.size();i++ )
		{
			Ocupacion ocupacion = ocupaciones.get(i);
			JSONObject jocupacion = new JSONObject();
			jocupacion.put("identificador", ocupacion.getIndentificador() );
			jocupacion.put("nombre", ocupacion.getNombre());
			jocupaciones.put(jocupacion);
		}
		
		return jocupaciones;
	}
	// --------------------------------------------------
	// Veh�culos
	// --------------------------------------------------
	public static JSONArray aniosToJSON(List<Anio> anios) throws Exception
	{
		JSONArray janios = new JSONArray();
		
		for( int i = 0; i < anios.size();i++ )
		{
			Anio anio = anios.get(i);
			JSONObject janio = new JSONObject();
			janio.put("anio", anio.getAnio());
			janio.put("valor", anio.getValor());
			janios.put(janio);
		}
		
		return janios;
	}
	public static JSONArray versionesToJSON(List<Version> versiones) throws Exception
	{
		JSONArray jversiones = new JSONArray();
		
		for( int i = 0; i < versiones.size();i++ )
		{
			Version version = versiones.get(i);
			JSONObject jversion = new JSONObject();
			jversion.put("id", version.getCodigo());
			jversion.put("nombre", version.getNombre());
			jversiones.put(jversion);
		}
		
		return jversiones;
	}
	public static JSONArray marcasToJSON(List<String> marcas) throws Exception
	{
		JSONArray jmarcas = new JSONArray();
		
		for( int i = 0; i < marcas.size();i++ )
		{
			String marca = marcas.get(i);
			JSONObject jmarca = new JSONObject();
			jmarca.put("id", marca);
			jmarca.put("nombre", marca);
			jmarcas.put(jmarca);
		}
		
		return jmarcas;
	}
	public static JSONArray modelosToJSON(List<String> modelos) throws Exception
	{
		JSONArray jmodelos = new JSONArray();
		
		for( int i = 0; i < modelos.size();i++ )
		{
			String modelo = modelos.get(i);
			JSONObject jmodelo = new JSONObject();
			jmodelo.put("id", modelo);
			jmodelo.put("nombre", modelo);
			jmodelos.put(jmodelo);
		}
		
		return jmodelos;
	}
}
