package modelo;

public class MedioPago 
{
	private String tipo;
	private long numero;
	private String fechaVencimiento;  
	
	public MedioPago(String tipo, long numero, String fechaVencimiento) 
	{
        this.tipo = tipo;
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
    }
	
	public String getTipo() {
        return tipo;
    }
	
	public long getNumero() {
        return numero;
    }
	
	public String getFechaVencimiento() {
        return fechaVencimiento;
    }
}
