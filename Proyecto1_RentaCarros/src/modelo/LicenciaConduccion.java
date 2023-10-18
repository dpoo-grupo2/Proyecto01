package modelo;

public class LicenciaConduccion
{
	private String numeroLicencia; 
    private String paisExpedicion;
    private String fechaVencimiento;
   
    public LicenciaConduccion(String numeroLicencia, String paisExpedicion, String fechaVencimiento) 
    {
	    this.numeroLicencia = numeroLicencia;
	    this.paisExpedicion = paisExpedicion;
	    this.fechaVencimiento = fechaVencimiento;
    }
   
    public String getNumero() 
    {
	    return this.numeroLicencia;
    }
   
    public String paisExpedicion() 
    {
	    return this.paisExpedicion;
    }
   
    public String fechaVencimiento() 
    {
	    return this.fechaVencimiento;
    }
  
}

