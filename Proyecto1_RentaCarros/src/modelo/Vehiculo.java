package modelo;

public class Vehiculo 
{
	private String placa;
	private String color;
	private String marca;
	private String modelo;
	private int anio;
	private String transimicion;
	private String gpsVehiuculo; // Esta es la sede (asi fue como lo pusimos en nuestros datos
	private String estadoActual; // Esto es en manetenimiento y eso
	private int capacidadPersonas;
	private String categoria;
	private int idCategoria;
	
	public Vehiculo(String placa,String color,String marca,String modelo, int anio, String transmicion, String gpsVehiculo, String estadoActual, int capacidadPersonas,
			String categoria,int idCategoria) 
 	{
		 this.placa = placa;
		 this.anio = anio;
		 this.color = color;
		 this.marca = marca;
		 this.modelo = modelo;
		 this.transimicion = transmicion;
		 this.gpsVehiuculo = gpsVehiculo;
		 this.estadoActual = estadoActual;
		 this.capacidadPersonas = capacidadPersonas;
		 this.categoria = categoria;
		 this.idCategoria = idCategoria;	
	}
	
	public String getEstado() 
	{
		return this.estadoActual;
	}
	
	public int getAnio() 
	{
		return this.anio;
	} 
	
	public int getCapacidad() 
	{
		return this.capacidadPersonas;
	} 
	
	public String getPlaca() 
	{
		return this.placa;
	} 
	
	public String getGps() 
	{
		return this.gpsVehiuculo;
	} 
	
	public int getIdCat() 
	{
		return this.idCategoria;
	}
	
	public String getCategoria() 
	{
		return this.categoria;
	} 
	
	public String getColor() 
	{
		return this.color;
	} 
	
	public String getTransmicion() 
	{
		return this.transimicion;
	} 
	
	public String getMarca() 
	{
		return this.marca;
	} 
	
	public String getModelo() 
	{
		return this.modelo;
	} 
	
	public String cambiarEstado(String nuevoEstado) 
	{//nose si toca poner otro atributo que sea "tipo de usuario" para asegurarnos que solo lo puedan mod los que lo tienen permitido
		estadoActual = nuevoEstado;
		return estadoActual;
	}
	public String toString() 
    {
    	
		return "PLACAAAAAAAAA "+placa+ " El estado"+estadoActual+" Categoria "+categoria +"idCat " +idCategoria;
    	
    }
}