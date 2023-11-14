package modelo;

import java.util.HashMap;

public class InventarioVehiculo 
{	
	private HashMap<String,Vehiculo> vehiculos = new HashMap<String, Vehiculo>();
	
	public void addVehiculo(String placa,Vehiculo vehiculo){
		vehiculos.put(placa,vehiculo);
	}
	
	public HashMap<String,Vehiculo> getVehiculos(){
		return vehiculos;
	}
    public boolean existKey(String key) {
    	if (vehiculos.containsKey(key)) return true;
    	else return false;
    }
    
    public void eliminarVehiculo(String placa) 
    {
    	vehiculos.remove(placa);
    }
}