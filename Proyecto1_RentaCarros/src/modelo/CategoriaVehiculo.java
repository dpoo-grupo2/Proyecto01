package modelo;

public class CategoriaVehiculo {
private String nombreCategoria;
private int idCategoria;
private Vehiculo[] lstVehiculos;

public CategoriaVehiculo(String nombreCategoria,int idCategoria, Vehiculo[] lstVehiculos) 
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
public Vehiculo[] getLst() 
{
	return this.lstVehiculos;
}
}