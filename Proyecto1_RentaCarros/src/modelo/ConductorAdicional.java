package modelo;

public class ConductorAdicional
{
	private String nombres;
	private String telefono;
	private String correoElectronico;
	 
	public ConductorAdicional(String nombres, String telefono, String correoElectronico) 
	{
	       this.nombres = nombres;
	       this.telefono = telefono;
	       this.correoElectronico = correoElectronico;
	}
	 
	public String getNombres() 
	{
	       return nombres;
	}
	
	public String getTelefono() 
	{
	       return telefono;
	}
	
	public String getCorreoElectronico() 
	{
	       return correoElectronico;
	}
}