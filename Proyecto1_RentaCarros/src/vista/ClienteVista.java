package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Cliente;

public class ClienteVista {
	private int opcion;
	private boolean centinela;
	private Cliente cliente;
	public String input(String mensaje)
	{
	    try
	    {
	        System.out.print(mensaje + ": ");
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        return reader.readLine();
	    }
	    catch (IOException e)
	    {
	        System.out.println("Error leyendo de la consola");
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public void menu(String usuario) 
	{
		centinela = true;
		while (centinela) {
			
		
		System.out.println("Bienvenido Administrador "+usuario);
		System.out.println("1- Reservar vehículo");
		System.out.println("2- Salir");
		try {
		opcion = Integer.parseInt(input("Ingrese su opcion: "));
		}
		catch(Exception e)
		{
			System.out.println("Recuerde que debe ingresar un numero entre 1 y 4");
		}
		if (1 == opcion) 
		{
			
		}
		else if(2 == opcion) {
			
		}

			
		else 
		{
			System.out.println("Esa no es una opcion");
		}
		
		
		
		
		}
	}
	
	
}
