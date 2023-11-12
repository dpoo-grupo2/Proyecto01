package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import controlador.CargaDatos;
import modelo.AdministradorLocal;

public class AdminLocal {
	private int opcion;
	private boolean centinela;
	private AdministradorLocal adminLocal;
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
			
			System.out.println("\nBienvenido Administrador local "+usuario+"\n");
			System.out.println("1- Agregar empleado");
			System.out.println("2- Eliminar empleado");
			System.out.println("2- Controlar inventario");
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
				ejecutarRegistrarEmpleado();
				System.out.println("\nUsuario registrado correctamente...\n");
				menu(usuario);
			}
			
			else if(2 == opcion) 
			{
				eliminarEmpleado();
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
	
	
	private void eliminarEmpleado() {
		// TODO Auto-generated method stub
		
	}

	private void ejecutarRegistrarEmpleado() {
		
		String login = input("\nIngrese el login que quiere ");
		String password = input("Ingrese  la contraseña que va a usar ");
		String nombreCompleto = input("Ingrese su nombre completo ");
		
		sobreEscribirData(login, password, nombreCompleto, "Empleado");
		
	}
	
	private void sobreEscribirData(String login, String password, String nombre, String tipo) {
		CargaDatos.sobreEscribirUsuarios(login, password, nombre, tipo);
	}
}
