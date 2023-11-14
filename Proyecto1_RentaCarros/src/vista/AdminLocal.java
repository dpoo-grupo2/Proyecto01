package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import controlador.CargaDatos;
import modelo.AdministradorLocal;
import modelo.Usuario;
import modelo.Vehiculo;

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
				String login = input("Ingrese el login del usuario que desea eliminar: ");
				File temp = eliminarEmpleado(login);
				File bd = new File("Proyecto1_RentaCarros/data/Usuarios.txt");
				bd.delete();
				temp.renameTo(bd);
			}
			
			else if (3 == opcion) 
			{
				File temp = modificarVehiculo();
				File bd = new File("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
				bd.delete();
				temp.renameTo(bd);
			}
							
			else if (4 == opcion) 
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
	
	
	private File eliminarEmpleado(String login) {
		Usuario usuario = CargaDatos.getUsuario(login);
		File usuarios = CargaDatos.eliminarUsuario(usuario);	
		return usuarios;
	}

	private void ejecutarRegistrarEmpleado() {
		
		String login = input("\nIngrese el login que quiere ");
		String password = input("Ingrese  la contraseña que va a usar ");
		String nombreCompleto = input("Ingrese su nombre completo ");
		
		sobreEscribirUsuarios(login, password, nombreCompleto, "Empleado");
		
	}
	
	private void sobreEscribirUsuarios(String login, String password, String nombre, String tipo) {
		CargaDatos.sobreEscribirUsuarios(login, password, nombre, tipo);
	}
	
	private File modificarVehiculo(){
		String sede = input("Ingrese la sede donde se encuentra el vehiculo: ");
		String estado = input("Ingrese el estado actual del vehiculo: ");
		int categoria = Integer.parseInt(input("Ingrese el ID de la categoria del vehiculo: "));
		String placa = input("Ingrese la placa del vehiculo a modificar: ");
		
		Vehiculo vehiculo = CargaDatos.getVehiculo(sede,estado,categoria,placa);
		
		File vehiculos = sobreEscribirVehiculos(vehiculo);
		
		return vehiculos;
	}
	
	private File sobreEscribirVehiculos(Vehiculo vehiculo){
		
		String placa = vehiculo.getPlaca();
		String color = vehiculo.getColor();
		String marca = vehiculo.getMarca();
		String modelo = vehiculo.getModelo();
		String anio = Integer.toString(vehiculo.getAnio());
		String transmision = vehiculo.getTransmicion();
		String gps = input("Ingrese la nueva sede del vehiculo: ");
		String estado = vehiculo.getEstado();
		String capacidad = Integer.toString(vehiculo.getCapacidad());
		String categoria = vehiculo.getCategoria();
		String idCategoria =Integer.toString(vehiculo.getIdCat());
		
		File vehiculos = CargaDatos.eliminarVehiculotxt(vehiculo);
		//CargaDatos.sobreEscribirVehiculo(placa, color, marca, modelo, anio, transmision, gps, estado, capacidad, categoria, idCategoria);
		
		return vehiculos; 
	}
}
