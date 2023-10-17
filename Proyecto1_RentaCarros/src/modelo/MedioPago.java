package modelo;

public class MedioPago 
{
	private String tipo;
	private String numero;
	private String fechaVencimiento;  
	
	public MedioPago(String tipo, String numero, String fechaVencimiento) 
	{
        this.tipo = tipo;
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
    }
	
	public String getTipo() {
        return tipo;
    }
	
	public String getNumero() {
        return numero;
    }
	
	public String getFechaVencimiento() {
        return fechaVencimiento;
    }
}
