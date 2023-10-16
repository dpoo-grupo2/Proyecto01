package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Cliente;
import vista.Login;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClienteVista {
	private int opcion;
	private boolean centinela;
	private boolean centinela1;
	private boolean centinela2;
	private boolean centinela3;
	private boolean centinela4;
	private boolean centinela5;
	private Cliente cliente;
	private String Sede;
	private String Categoria;
	private String FechaRecibido;
	private String FechaEntrega;
	private String HoraRecibido;
	private String HoraEntrega;
	
	public ClienteVista(){
		
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
	                Sede = "SedeNorte";
	                categoriaParaAlquilar();
	                System.out.println("\nReserva registrada exitosamente en el sistema...");
		            System.exit(0);
	            } 
	            
	            else if (sedeOption == 2) 
	            {
	                System.out.println("\nHa seleccionado la Sede Centro para su reserva.");
	                Sede = "SedeCentro";
	                categoriaParaAlquilar();
	                System.out.println("\nReserva registrada exitosamente en el sistema...");
		            System.exit(0);
	            } 
	            
	            else if (sedeOption == 3) 
	            {
	                System.out.println("\nHa seleccionado la Sede Sur para su reserva.");
	                Sede = "SedeSur";
	                categoriaParaAlquilar();
	                System.out.println("\nReserva registrada exitosamente en el sistema...");
		            System.exit(0);
	            } 
	            
	            else 
	            {
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
	            if (opcion == 1) 
		        {
		        	Categoria = "Pequenio";
		        	fechaRecogida();
		        	fechaEntrega();
		        	HoraRecogida();
		        	HoraEntrega();
		        }
		        
		        else if (opcion == 2) 
		        {
		        	Categoria = "Sedan";
		        	fechaRecogida();
		        	fechaEntrega();
		        	HoraRecogida();
		        	HoraEntrega();
		        }
		        
		        else if (opcion == 3) 
		        {
		        	Categoria = "SUV";
		        	fechaRecogida();
		        	fechaEntrega();
		        	HoraRecogida();
		        	HoraEntrega();
		        	
		        }
		        
		        else if (opcion == 4) 
		        {
		        	Categoria = "Lujo";
		        	fechaRecogida();
		        	fechaEntrega();
		        	HoraRecogida();
		        	HoraEntrega();
		        }
		        
		        else 
	            {
	                System.out.println("Opción de sede no válida.");	                
	            }
	            
	            
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Recuerde que debe ingresar un número entre 1 y 4");
	        }

	        
	    }
	}
	
	public void fechaRecogida() {
	    centinela2 = true;
	    while (centinela2) {
	        FechaRecibido = input("\nDigite la fecha en la cual va a recoger el vehículo (DD/MM/AA)");
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	        dateFormat.setLenient(false);  
	        try {
	            Date fecha = dateFormat.parse(FechaRecibido);
	            
	            if (FechaRecibido.equals(dateFormat.format(fecha))) {
	                System.out.println("Fecha ingresada correctamente en el formato DD/MM/AA.");
	                centinela2 = false; 
	                
	                
	            } else {
	                System.out.println("La fecha no es válida para el formato DD/MM/AA. Intente de nuevo.");
	            }
	        } catch (ParseException e) {
	            System.out.println("La fecha no está en el formato correcto (DD/MM/AA). Intente de nuevo.");
	        }
	    }
	}
	
	public void fechaEntrega() {
	    centinela3 = true;
	    while (centinela3) {
	        FechaEntrega = input("\nDigite la fecha en la cual va a entregar el vehículo (DD/MM/AA)");
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	        dateFormat.setLenient(false);  
	        try {
	            Date fecha = dateFormat.parse(FechaEntrega);
	            
	            if (FechaEntrega.equals(dateFormat.format(fecha))) {
	                System.out.println("Fecha ingresada correctamente en el formato DD/MM/AA.");
	                centinela3 = false; 
	                
	                
	            } else {
	                System.out.println("La fecha no es válida para el formato DD/MM/AA. Intente de nuevo.");
	            }
	        } catch (ParseException e) {
	            System.out.println("La fecha no está en el formato correcto (DD/MM/AA). Intente de nuevo.");
	        }
	    }
	}
	
	
	public void HoraRecogida() {
	    centinela4 = true;
	    while (centinela4) {
	        HoraRecibido = input("\nDigite la hora en la cual va a recoger el vehículo (HH:mm)");

	        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	        timeFormat.setLenient(false); 
	        try {
	            Date hora = timeFormat.parse(HoraRecibido);
	            
	            if (HoraRecibido.equals(timeFormat.format(hora))) {
	                System.out.println("Hora ingresada correctamente en el formato HH:mm.");
	                centinela4 = false;  
	            } else {
	                System.out.println("La hora no es válida para el formato HH:mm. Intente de nuevo.");
	            }
	        } catch (ParseException e) {
	            System.out.println("La hora no está en el formato correcto (HH:mm). Intente de nuevo.");
	        }
	    }
	}

	public void HoraEntrega() {
	    centinela5 = true;
	    while (centinela5) {
	        HoraEntrega = input("\nDigite la hora en la cual va a devolver el vehículo (HH:mm)");

	        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	        timeFormat.setLenient(false);  

	        try {
	            Date hora = timeFormat.parse(HoraEntrega);
	            
	            if (HoraEntrega.equals(timeFormat.format(hora))) {
	                System.out.println("Hora ingresada correctamente en el formato HH:mm.");
	                centinela5 = false;  
	            } else {
	                System.out.println("La hora no es válida para el formato HH:mm. Intente de nuevo.");
	            }
	        } catch (ParseException e) {
	            System.out.println("La hora no está en el formato correcto (HH:mm). Intente de nuevo.");
	        }
	    }
	}
	
	
	public void VerificarDisponibilidad()
	{
		
	}
	
	
}