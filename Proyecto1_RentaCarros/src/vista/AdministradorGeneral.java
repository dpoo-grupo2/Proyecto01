package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import controlador.CargaDatos;
import modelo.Administrador;
import modelo.CategoriaVehiculo;
import modelo.Vehiculo;

public class AdministradorGeneral {
	private int opcion;
	private boolean centinela;
	private Administrador admin = new Administrador();
	private Vehiculo culo;
	
	public CargaDatos carga = new CargaDatos();
	private HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> sedes = carga.getSedes();
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
			
			System.out.println("\nBienvenido Administrador general "+usuario+"\n");
			System.out.println("1- Registrar vehiculo");
			System.out.println("2- Quitar vehiculo");
			System.out.println("3- gestionar Seguros");
			System.out.println("4- Modificar informacion sede");
			System.out.println("5- Salir");
			try {
			opcion = Integer.parseInt(input("Ingrese su opcion "));
			}
			catch(Exception e)
			{
				System.out.println("Recuerde que debe ingresar un numero entre 1 y 4");
			}
			
			if (1 == opcion) 
			{
				culo =admin.registrarVehiculo("TU MAMA EN 4","rojo","Chevrolet","Spark",2020,"mecanico","sedeCentro","alquilado",4,"pequenio",1,sedes);
				System.out.println(culo.getPlaca());
			}
			
			else if(2 == opcion) 
			{
				
			}
			
			else if(3 == opcion) 
			{
				
			}
			
			else if (4 == opcion) 
			{
				
			}
			
			else if (5 == opcion) 
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
}
