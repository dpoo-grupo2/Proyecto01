package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import controlador.CargaDatos;

public class Login {
	public static void main(String[] args)
    {
    	//CargaDatos.cargarInformacionVehiculos("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
    	Login login = new Login();
    	login.ejecutarAplicacion();
    	}
	
	public void ejecutarAplicacion()
	{
		System.out.println("-----------------Bienvenido a Car Rental-----------------");
    	System.out.println("1. Iniciar sesion");
    	System.out.println("2. Registrarse");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarIniciarSesion();
				else if (opcion_seleccionada == 2 )//&& usuarios != null)
					ejecutarRegistrarCliente();
				/***else if (usuarios == null)
				{
					System.out.println("No se pudo cargar la base de datos de los usuarios.");
				}***/
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	private void ejecutarIniciarSesion() {
		String usuario = input("Ingrese su usuario: ");
		String contraseña = input("Ingrese su contraseña: ");
	}

	public void ejecutarRegistrarCliente() {
		
		String nombre = input("Ingrese su nombre completo: ");
		int edad = Integer.parseInt(input("Ingrese su edad: "));
		String cedula = input("Ingrese  su cedula: ");
		String fechaNacimiento = input("Ingrese  su fecha de nacimiento (DD/MM/AA): ");
		String correo = input("Ingrese  su correo: ");
		String usuario = input("Ingrese el usuario que desea: ");
		String contraseña = input("Ingrese  su contraseña: ");
		
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
