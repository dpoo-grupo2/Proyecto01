package modelo;

public class Seguro 
{
    private String nombreSeguro;
    private int valorSeguro;

    public Seguro(String nombreSeguro, int valorSeguro) 
    {
    	this.nombreSeguro = nombreSeguro;
    	this.valorSeguro = valorSeguro;
    }
    
    public String getNombreSeguro() {
        return nombreSeguro;
    }
 
    public int getValorSeguro() {
        return valorSeguro;
    }
    
    
}