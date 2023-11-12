package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controlador.CargaDatos;
import modelo.ConductorAdicional;
import modelo.Empleado;
import modelo.LicenciaConduccion;
import modelo.Vehiculo;
import modelo.Reserva;

public class EmpleadoVista {
	private int opcion;
	private boolean centinela;
	private Empleado empleado;
	private CargaDatos carga;
	private Reserva reserva;
	
	public void menu(String usuario) 
	{
		centinela = true;
		while (centinela) {
			
			System.out.println("\nBienvenido Empleado "+usuario+"\n");
			System.out.println("1- Registrar conductores adicionales a una reserva");
			System.out.println("2- Actualizar estado de los vehículos");
			System.out.println("3- Salir");
			
			try 
			{
				opcion = Integer.parseInt(input("Ingrese su opcion "));
			}
			catch(Exception e)
			{
				System.out.println("Recuerde que debe ingresar un numero entre 1 y 4");
			}
			
			if (1 == opcion) 
			{
				agregarConductorAdicional();
			}
			
			else if(2 == opcion) {
				actualizarEstadoVehiculo();
			}
			
			else if (3 == opcion) 
			{
				System.out.println("\nSaliendo del sistema...");
				System.exit(0);
			}
			
			else 
			{
				System.out.println("Esa no es una opcion");
			}
		}
	}	
	
	private void actualizarEstadoVehiculo() {
		String sede = input("Ingrese la sede donde se encuentra el vehiculo: ");
		String estado = input("Ingrese el estado actual del vehiculo: ");
		int categoria = Integer.parseInt(input("Ingrese el ID de la categoria del vehiculo: "));
		String placa = input("Ingrese la placa del vehiculo a modificar: ");
<<<<<<< HEAD
		String nEstado = input("Ingrese el nuevo estado del vehiculo");		
		empleado.cambiarEstadoVehiculo(sede,estado,categoria,placa,nEstado);  
=======
		String nEstado = input("Ingrese el nuevo estado del vehiculo");

		
		empleado.cambiarEstadoVehiculo(sede,estado,categoria,placa,nEstado); 

		Vehiculo vehiculo = carga.getVehiculo(sede, estado, categoria, placa);
		vehiculo.cambiarEstado(nEstado); 

>>>>>>> branch 'main' of https://github.com/dpoo-grupo2/Proyecto01.git
	}

	public void agregarConductorAdicional() {
		boolean centinela = true;

		while (centinela) {
		    System.out.println("\nDesea agregar un conductor adicional a su reserva?");
		    System.out.println("1. Sí");
		    System.out.println("2. No");

		    int opcionConductorAdicional;
		    try {
		        opcionConductorAdicional = Integer.parseInt(input("Ingrese su opción "));
		    } catch (Exception e) {
		        System.out.println("Opción no válida.");
		        return;
		    }

		    if (opcionConductorAdicional == 1) {

		        String idReserva = input("\nIngrese el id de la reserva a modificar: ");
		    	String nombres = input("Ingrese el nombre del conductor adicional: ");
		        String telefono = input("Ingrese el teléfono del conductor adicional: ");
		        String correoElectronico = input("Ingrese el correo electrónico del conductor adicional: ");
		        String numeroLicencia = input("Ingrese el número de licencia del conductor adicional: ");
		        String paisExpedicion = input("Ingrese el país de expedición de la licencia del conductor adicional: ");
		        String fechaVencimiento = input("Ingrese la fecha de vencimiento de la licencia del conductor adicional: ");
		        
		        empleado.agregarConductorAdicional(idReserva,nombres, telefono, correoElectronico, numeroLicencia, paisExpedicion, fechaVencimiento);
		        
		        System.out.println("\nConductor adicional agregado a la reserva.");
		    } else if (opcionConductorAdicional == 2) {
		        System.out.println("No se agregarán más conductores adicionales a la reserva.");
		        centinela = false;  
		    } else {
		        System.out.println("Opción no válida.");
		    }
		}
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
	
}
