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
    public int modValor(int nuevoValor) 
    {
    	valorSeguro = nuevoValor;
		return valorSeguro;
    }
    public String modNombre(String nuevoNombre) 
    {
    	nombreSeguro=nuevoNombre;
		return nombreSeguro;
    	
    }
    public String toString() 
    {
    	
		return "Nombre seguro: "+nombreSeguro+", Valor seguro"+valorSeguro;
    	
    }
    
}