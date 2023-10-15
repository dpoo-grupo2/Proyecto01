package modelo;

public class Cliente 
{
private String edad; // pq edad str?? y no int
private String cedula;
private String correoElectronico;
private String fechaNacimiento;

Cliente(String edad,String cedula, String correoElectronico,String fechaNacimiento) // falta implementar usuario
{
	this.edad = edad;
	this.cedula = cedula;
	this.correoElectronico = correoElectronico;
	this.fechaNacimiento = fechaNacimiento;
}

public String getEdad() {
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