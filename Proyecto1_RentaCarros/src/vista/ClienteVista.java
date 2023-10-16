package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Cliente;

public class ClienteVista {
	private int opcion;
	private boolean centinela;
	private Cliente cliente;
	
	public void ClienteVista(){
		
	}
	
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
	
	public void menu(String usuario) {
	    centinela = true;
	    while (centinela) {
	        System.out.println("\nBienvenido Cliente " + usuario + "\n");
	        System.out.println("1- Reservar vehículo");
	        System.out.println("2- Salir");

	        try {
	            opcion = Integer.parseInt(input("Ingrese su opción "));
	        } catch (Exception e) {
	            System.out.println("Recuerde que debe ingresar un número entre 1 y 2");
	        }

	        if (opcion == 1) {
	            
	            
	            System.out.println("\n¿En cual sede desea generar su reserva?");
	            System.out.println("1. Sede Norte");
	            System.out.println("2. Sede Centro");
	            System.out.println("3. Sede Sur");

	            int sedeOption;
	            try {
	                sedeOption = Integer.parseInt(input("Ingrese su opción para la sede "));
	            } catch (Exception e) {
	                System.out.println("Opción no válida.");
	                continue;  
	            }

	            if (sedeOption == 1) {
	                System.out.println("Ha seleccionado la Sede Norte para su reserva.");
	            } else if (sedeOption == 2) {
	                System.out.println("Ha seleccionado la Sede Centro para su reserva.");
	            } else if (sedeOption == 3) {
	                System.out.println("Ha seleccionado la Sede Sur para su reserva.");
	            } else {
	                System.out.println("Opción de sede no válida.");
	            }
	        } 
	        
	        else if (2 == opcion) {
	            System.out.println("\nSaliendo del sistema...");
	            System.exit(0);
	        } 
	        
	        else 
	        {
	            System.out.println("Esa no es una opción válida.");
	        }
	    }
	}	
}
