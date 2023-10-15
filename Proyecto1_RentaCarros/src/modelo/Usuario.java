package modelo;
// toca ver q es usuario, q tipo de clase es si herencia
// o interface
public class Usuario
{
	private String login;
	private String password;
	private String nombreCompleto;
	
	public Usuario(String login, String password, String nombreCompleto) 
	{ 
		this.login = login;
		this.password = password;
		this.nombreCompleto = nombreCompleto;
	
	}
	
	public String getLogin() 
	{
		return login;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public String getNombreCompleto() 
	{
		return nombreCompleto;
	}
	
}