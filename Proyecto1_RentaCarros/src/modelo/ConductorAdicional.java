package modelo;

public class ConductorAdicional
{
	private String nombres;
	private String telefono;
	private String correoElectronico;
	private LicenciaConduccion licencia; 
	
	public ConductorAdicional(String nombres, String telefono, String correoElectronico, LicenciaConduccion licencia) 
	{
	       this.nombres = nombres;
	       this.telefono = telefono;
	       this.correoElectronico = correoElectronico;
	       this.licencia = licencia;
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
	
	public LicenciaConduccion getLicencia() {
		return licencia;
	}
}