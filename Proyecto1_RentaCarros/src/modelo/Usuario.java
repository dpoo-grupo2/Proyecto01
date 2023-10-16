package modelo;
// toca ver q es usuario, q tipo de clase es si herencia
// o interface
public class Usuario
{
	private String login;
	private String password;
	private String nombreCompleto;
	private String tipoUsuario;
	
	public Usuario(String login, String password, String nombreCompleto, String tipoUsuario) 
	{ 
		this.login = login;
		this.password = password;
		this.nombreCompleto = nombreCompleto;
		this.tipoUsuario = tipoUsuario;
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
	
	public String getTipoUsuario() {
		return tipoUsuario;
	}
}