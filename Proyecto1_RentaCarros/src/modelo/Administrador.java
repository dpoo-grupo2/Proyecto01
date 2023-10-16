package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Administrador 
{
private CategoriaVehiculo categoria;
private Vehiculo vehiculo;
public Vehiculo registrarVehiculo(String placa,String color,String marca,String modelo, int anio, String transmicion, String gpsVehiculo, String estadoActual, int capacidadPersonas,
		String categoria,int idCategoria,HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> sedes) 
{
	vehiculo = new Vehiculo(placa,color,marca,modelo,anio,transmicion,gpsVehiculo,estadoActual,capacidadPersonas,categoria,idCategoria);
	addSede(vehiculo,sedes);
	return vehiculo;
}

private HashMap<Integer,CategoriaVehiculo> addVehiculoCat(HashMap<Integer,CategoriaVehiculo> categoria2, Vehiculo carro)
{
	ArrayList<Vehiculo> lstVehiculos = new ArrayList();
	if (!categoria2.containsKey(carro.getIdCat())) 
	{
		
		categoria = new CategoriaVehiculo(carro.getCategoria(), carro.getIdCat(),lstVehiculos , 0, 0, 0);
		categoria2.put(carro.getIdCat(), categoria);
	}
	CategoriaVehiculo cat = categoria2.get(carro.getIdCat());
	cat.añadirElemento(carro);
	return categoria2;
	
}

private HashMap<String,HashMap<Integer,CategoriaVehiculo>> addCategoriaDisponibilidad(HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad,Vehiculo vehiculo)
{
	if (!disponibilidad.containsKey(vehiculo.getEstado())) 
	{
		HashMap<Integer,CategoriaVehiculo> mapCat = new HashMap<Integer,CategoriaVehiculo>(); 
		disponibilidad.put(vehiculo.getEstado(),mapCat);
	}
	HashMap<Integer,CategoriaVehiculo> map2 = disponibilidad.get(vehiculo.getEstado());
	addVehiculoCat(map2,vehiculo);
	
	return disponibilidad;	
}

private HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> addSede(Vehiculo vehiculo,HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> sedes)
{
	
	if (!sedes.containsKey(vehiculo.getGps())) 
	{
		HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad = new HashMap<String,HashMap<Integer,CategoriaVehiculo>>();
		sedes.put(vehiculo.getGps(),disponibilidad);
	}
	HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad2 = sedes.get(vehiculo.getGps());
	addCategoriaDisponibilidad(disponibilidad2,vehiculo);
	
	return sedes;
	
}
}
