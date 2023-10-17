package modelo;

public class LicenciaConduccion
{
	private int numero; 
    private String paisExpedicion;
    private String fechaVencimiento;
   
    public LicenciaConduccion(int numero, String paisExpedicion, String fechaVencimiento) 
    {
	    this.numero = numero;
	    this.paisExpedicion = paisExpedicion;
	    this.fechaVencimiento = fechaVencimiento;
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
  
}

