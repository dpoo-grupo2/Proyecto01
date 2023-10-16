package modelo;

public class Cliente extends Usuario
{
	private Integer edad; 
	private String cedula;
	private String correoElectronico;
	private String fechaNacimiento;

	public Cliente(String login, String password, String nombreCompleto,Integer edad,String cedula, String correoElectronico,String fechaNacimiento) // falta implementar usuario
	{
		super(login, password, nombreCompleto);
		this.edad = edad;
		this.cedula = cedula;
		this.correoElectronico = correoElectronico;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Integer getEdad() 
	{
		return this.edad;
	}
	public String getCedula()
	{
		return this.cedula;
	}
	public String getCorreo() 
	{
		return this.correoElectronico;
	}
	public String getFechaNacimiento() 
	{
		return this.fechaNacimiento;	
	}

}