package modelo;

import java.util.*;

public class Sede 
{

	private String nombreSede;
	private String direccionSede;
	private String horarioAtencion;
	private AdministradorLocal adminL; 
	private HashMap<String,HashMap<Integer,CategoriaVehiculo>> mapEstadoVehiculo;//mapa de estados
	
	 public Sede(String nombreSede, String direccionSede, String horarioAtencion, AdministradorLocal adminL, HashMap<String,HashMap<Integer,CategoriaVehiculo>> mapEstadoVehiculo) 
	 {
	        this.nombreSede = nombreSede;
	        this.direccionSede = direccionSede;
	        this.horarioAtencion = horarioAtencion;
	        this.adminL = adminL;
	        this.mapEstadoVehiculo = mapEstadoVehiculo;
	        
	 }

	 public String getNombreSede() {
	        return nombreSede;
	    }

	    public String getDireccionSede() {
	        return direccionSede;
	    }

	    public String getHorarioAtencion() {
	        return horarioAtencion;
	    }

	    public AdministradorLocal getAdminL() {
	        return adminL;
	    }

	    public HashMap<String,HashMap<Integer,CategoriaVehiculo>> getMapEstadoVehiculo() {
	        return mapEstadoVehiculo;
	    }
}
