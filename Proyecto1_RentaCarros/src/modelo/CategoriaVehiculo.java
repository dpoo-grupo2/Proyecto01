package modelo;

import java.util.ArrayList;


public class CategoriaVehiculo {
private String nombreCategoria;
private int idCategoria;
private ArrayList<Vehiculo> lstVehiculos ;

public CategoriaVehiculo(String nombreCategoria,int idCategoria, ArrayList<Vehiculo> lstVehiculos) 
{
	this.nombreCategoria = nombreCategoria;
	this.idCategoria = idCategoria;
	this.lstVehiculos = lstVehiculos;
}
public String getNombre() 
{
	return this.nombreCategoria;
}
public int getId()
{
	return this.idCategoria;
}
public ArrayList<Vehiculo> getLst() 
{
	return this.lstVehiculos;
}
public ArrayList<Vehiculo> añadirElemento(Vehiculo vehiculoAñadir) 
{
	lstVehiculos.add(vehiculoAñadir);
	return lstVehiculos;
}
public ArrayList<Vehiculo> eliminarElemento(int posElemento) 
{
	lstVehiculos.remove(posElemento);
	return lstVehiculos;

}
}