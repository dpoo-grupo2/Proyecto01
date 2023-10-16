package vista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

import controlador.CargaDatos;
import modelo.AdministradorLocal;
import modelo.Usuario;

public class Login {
	
	private CargaDatos cargaDatos = new CargaDatos();
	
	private Map<String,Usuario> usuarios;
	
	public static void main(String[] args)
    {
    	Login login = new Login();
    	login.CargarDatos();
    	login.ejecutarAplicacion();
    	}
	
	private void ejecutarAplicacion()
	{
		System.out.println("\n-----------------Bienvenido a Car Rental-----------------\n");
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
				else if (opcion_seleccionada == 2 && usuarios != null)
					ejecutarRegistrarCliente();
				else if (usuarios == null)
				{
					System.out.println("No se pudo cargar la base de datos de los usuarios.");
				}
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
	    boolean loginExitoso = false;

	    while (!loginExitoso) {
	        String usuario = input("\nIngrese su usuario ");
	        String contraseña = input("Ingrese su contraseña ");

	        if (usuarios.containsKey(usuario)) {
	            Usuario clsUsuario = usuarios.get(usuario);

	            if (contraseña.equals(clsUsuario.getPassword())) {
	                loginExitoso = true;

	                if (clsUsuario.getTipoUsuario().equals("AdministradorGeneral")) {
	                    AdministradorGeneral administradorGeneral = new AdministradorGeneral();
	                    administradorGeneral.menu(usuario);
	                } else if (clsUsuario.getTipoUsuario().equals("AdministradorLocal")) {
	                    AdminLocal administradorLocal = new AdminLocal();
	                    administradorLocal.menu(usuario);
	                } else if (clsUsuario.getTipoUsuario().equals("Empleado")) {
	                    EmpleadoVista empleado = new EmpleadoVista();
	                    empleado.menu(usuario);
	                } else if (clsUsuario.getTipoUsuario().equals("Cliente")) {
	                    ClienteVista cliente = new ClienteVista();
	                    cliente.menu(usuario);
	                }
	            }
	        }

	        if (!loginExitoso) {
	            System.out.println("\nUsuario o contraseña inválida, vuelva a intentarlo.");
	        }
	    }
	}


	private void ejecutarRegistrarCliente() {
		
		String nombre = input("Ingrese su nombre completo ");
		int edad = Integer.parseInt(input("Ingrese su edad "));
		String cedula = input("Ingrese  su cedula ");
		String fechaNacimiento = input("Ingrese  su fecha de nacimiento (DD/MM/AA) ");
		String correo = input("Ingrese  su correo ");
		String usuario = input("Ingrese el usuario que desea ");
		String contraseña = input("Ingrese  su contraseña ");
		
		String numeroLicencia = input("Ingrese  su numero de la licencia de conducion ");
		String paisExpedicion = input("Ingrese  el pais donde expidio su licencia ");
		String fechaVencimiendo = input("Ingrese  la fecha de vencimiento de su licencia ");
		
		sobreEscribirData(usuario,contraseña,nombre);
		System.out.println("\nHaz sido registrado exitosamente, por favor vuelve a iniciar la aplicación... ");
        System.exit(0);
	}
	
	private void sobreEscribirData(String usuario,String contraseña, String nombre) {
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        String data = "\n"+usuario+","+contraseña+","+nombre+",Cliente";
	        File file = new File("Proyecto1_RentaCarros/data/Usuarios.txt");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        fw = new FileWriter(file.getAbsoluteFile(), true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	        System.out.println("¡Información agregada!");
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

	private String input(String mensaje)
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
	
	private void CargarDatos(){
		cargaDatos.cargarInformacionVehiculos("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
		var usuarios = cargaDatos.cargarInformacionUsuarios("Proyecto1_RentaCarros/data/Usuarios.txt");
		this.usuarios = usuarios;
		
	}
}