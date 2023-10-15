package modelo;

public class Cliente 
{
private Integer edad; 
private String cedula;
private String correoElectronico;
private String fechaNacimiento;

Cliente(Integer edad,String cedula, String correoElectronico,String fechaNacimiento) // falta implementar usuario
{
	this.edad = edad;
	this.cedula = cedula;
	this.correoElectronico = correoElectronico;
	this.fechaNacimiento = fechaNacimiento;
}

public Integer getEdad() {
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
public String getFechaN() 
{
	return this.fechaNacimiento;	
}

}