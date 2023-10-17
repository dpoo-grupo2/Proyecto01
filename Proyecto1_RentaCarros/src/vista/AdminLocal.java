package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

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
			System.out.println("1- Gestionar empleados");
			System.out.println("2- Crear empleados");
			System.out.println("3- Controlar inventario");
			System.out.println("4- Salir");
			
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
				
			}
			
			else if(2 == opcion) 
			{
				ejecutarRegistrarEmpleado();
				System.out.println("\nUsuario registrado correctamente...\n");
				menu(usuario);
			}
			else if(3 == opcion) 
			{
				
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
	
	
	private void ejecutarRegistrarEmpleado() {
		
		String login = input("\nIngrese el login que quiere ");
		String password = input("Ingrese  la contraseña que va a usar ");
		String nombreCompleto = input("Ingrese su nombre completo ");
		String tipo = input("Ingrese el tipo de usuario ");
		
		sobreEscribirData(login, password, nombreCompleto, tipo);
		
	}
	
	private void sobreEscribirData(String login, String password, String nombreCompleto, String tipo) {
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        String data = "\n"+login+","+password+","+nombreCompleto+","+tipo;
	        File file = new File("Proyecto1_RentaCarros/data/Usuarios.txt");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        fw = new FileWriter(file.getAbsoluteFile(), true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	        System.out.println("Información agregada!");
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (bw != null)
	                bw.close();
	            if (fw != null)
	                fw.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
}
