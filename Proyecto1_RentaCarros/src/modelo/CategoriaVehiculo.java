package modelo;

import java.util.ArrayList;


public class CategoriaVehiculo 
{
	private String nombreCategoria;
	private int idCategoria;
	private ArrayList<Vehiculo> lstVehiculos ;
	private int valorConductorExtra;
	private int valorPorEntregaOtraSede;
	private int tarifaDiaria; // varia dependiendo del dia y temporada
		
	public CategoriaVehiculo(String nombreCategoria,int idCategoria, ArrayList<Vehiculo> lstVehiculos, int tarifaDiaria, int valorPorEntregaOtraSede, int valorConductorExtra) 
	{
		this.nombreCategoria = nombreCategoria;
		this.idCategoria = idCategoria;
		this.lstVehiculos = lstVehiculos;
		this.valorConductorExtra = valorConductorExtra;
		this.valorPorEntregaOtraSede = valorPorEntregaOtraSede;
		this.tarifaDiaria = tarifaDiaria;
	}
		
	public int getValorConductorExtra() 
	{
		return this.valorConductorExtra;
	}
	
	public int getValorPorEntregaOtraSede() 
	{
		return this.valorPorEntregaOtraSede;
	}
	
	public int getTarifaDiaria() 
	{
		return this.tarifaDiaria;
	}
		
	public String getNombreCategoria() 
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