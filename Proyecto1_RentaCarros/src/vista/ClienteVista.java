package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Cliente;
import vista.Login;

public class ClienteVista {
	private int opcion;
	private boolean centinela;
	private boolean centinela1;
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
	            
	            System.out.println("\nEn cual sede desea generar su reserva:\n");
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

	            if (sedeOption == 1) 
	            {
	                System.out.println("\nHa seleccionado la Sede Norte para su reserva.");
	                
	                categoriaParaAlquilar();
	            } 
	            
	            else if (sedeOption == 2) 
	            {
	                System.out.println("\nHa seleccionado la Sede Centro para su reserva.");
	                categoriaParaAlquilar();
	            } 
	            
	            else if (sedeOption == 3) 
	            {
	                System.out.println("\nHa seleccionado la Sede Sur para su reserva.");
	                categoriaParaAlquilar();
	            } 
	            
	            else 
	            {
	                System.out.println("Opción de sede no válida.");	                
	            }
	            
	            System.out.println("\nReserva registrada exitosamente en el sistema...");
	            System.exit(0);
	            
	           	                 
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
	
	public void categoriaParaAlquilar() 
	{
				
		centinela1 = true;
	    while (centinela1) {
	        
	        System.out.println("\nQue categoria de vehiculo desea alquilar:");
	        System.out.println("1. Pequenio");
            System.out.println("2. Sedan");
            System.out.println("3. SUV");
            System.out.println("4. Lujo");
	        try {
	            opcion = Integer.parseInt(input("Ingrese su opción "));
	        } catch (Exception e) {
	            System.out.println("Recuerde que debe ingresar un número entre 1 y 4");
	        }

	        if (opcion == 1) 
	        {
	        	System.exit(0);
	        }
	        
	        else if (opcion == 2) 
	        {
	        	System.exit(0);
	        }
	        
	        else if (opcion == 3) 
	        {
	        	System.exit(0);
	        }
	        
	        else if (opcion == 4) 
	        {
	        	System.exit(0);
	        }
	        
	        else 
            {
                System.out.println("Opción de sede no válida.");	                
            }
	    }
	}
}
