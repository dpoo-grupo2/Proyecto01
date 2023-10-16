package modelo;

public class LicenciaConduccion
{
	private int numero; 
    private String paisExpedicion;
    private String fechaVencimiento;
    private String imagenLicencia; // toca ver q hacemos con esto
   
    public LicenciaConduccion(int numero, String paisExpedicion, String fechaVencimiento, String imagenLicencia) 
    {
	    this.numero = numero;
	    this.paisExpedicion = paisExpedicion;
	    this.fechaVencimiento = fechaVencimiento;
	    this.imagenLicencia = imagenLicencia;
    }
   
    public int getNumero() 
    {
	    return this.numero;
    }
   
    public String paisExpedicion() 
    {
	    return this.paisExpedicion;
    }
   
    public String fechaVencimiento() 
    {
	    return this.fechaVencimiento;
    }
   
    public String imagenLicencia() 
    {
	    return this.imagenLicencia;
    }
}

