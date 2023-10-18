package vista;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import controlador.CargaDatos;
import modelo.Administrador;
import modelo.CategoriaVehiculo;
import modelo.Sede;
import modelo.Seguro;
import modelo.Vehiculo;
import vista.Login;


public class AdministradorGeneral {
	private int opcion;
	private boolean centinela;
	private Administrador admin = new Administrador();

	
	
	public CargaDatos carga = new CargaDatos();
	private HashMap<String,Sede> sedes = carga.getSedes();
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
			System.out.println("3- Gestionar Seguros");
			System.out.println("4- Salir");
			try {
			opcion = Integer.parseInt(input("Ingrese su opcion "));
			}
			catch(Exception e)
			{
				System.out.println("Recuerde que debe ingresar un numero entre 1 y 4");
			}
			
			if (1 == opcion) 
			{
				ejecutarRegistrarCarro();
				System.out.println(sedes);
				System.out.println("\nCarro registrado correctamente...\n");
				menu(usuario);
	            
			}
			
			else if(2 == opcion) 
			{{try {
				String sede = input("Ingrese la sede en la que se encuentra el vehiculo: ");
				String placa = input("Ingrese la placa del vehiculo que desea eliminar: ");
				String dispo = input("Ingrese la disponibilidad del vehiculo: ");
				int cat = Integer.parseInt(input("Ingrese el ID de la categoria del vehiculo: "));
				
				File temp = eliminarVehiculo(admin.eliminarVehiculo(sedes, sede, placa, dispo, cat));
				File bd = new File("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
				bd.delete();
				temp.renameTo(bd);
				System.out.println("\nCarro eliminado correctamente...\n");
			}
			catch(Exception e) 
			{
			System.out.println("La informacion el vehiculo esta mal");	
			}
			}
				menu(usuario);
			}
			
			else if(3 == opcion) 
			{
				menuSeguro(usuario);
				menu(usuario);
			}
			
			else if (4 == opcion) 
			{
				System.out.println("\nSaliendo del sistema...");
				break;
			}
			
			else 
			{
				System.out.println("Esa no es una opcion");
			}
		}
	}
	private void menuSeguro(String usuario) 
	{	
		centinela = true;
	
	while (centinela) {
		System.out.println("");
		System.out.println("Menu de seguros");
		System.out.println("");
		System.out.println("1- Añadir seguro");
		System.out.println("2- Eliminar seguro");
		System.out.println("3- Modificar informacion seguro");
		System.out.println("4- Salir");
		try {
			opcion = Integer.parseInt(input("Ingrese su opcion "));
			}
			catch(Exception e)
			{
				System.out.println("Recuerde que debe ingresar un numero entre 1 y 4");
			}
			if (1 == opcion) 
			{
				String nombreSeguro = input("Ingrese el nombre del seguro que desea añadir: ");
				int valorSeguro = Integer.parseInt(input("Ingrese el valor del seguro que desea añadir: "));
	            Seguro objSeguro = new Seguro(nombreSeguro,valorSeguro);
	            boolean resultado = admin.añadirElementSeguros(objSeguro);
	            if (!resultado) 
	            {
	            	System.out.println("\nEl seguro no se pudo añadir con exito");

	            }
	            else {
	            	System.out.println("\nEl seguro fue agregado con exito...");
	            	sobreEscribirSeguros(nombreSeguro,valorSeguro);
		            centinela=false;
	            }
	            

			}
			else if (2 == opcion) 
			{
				String nombreSeguro = input("Ingrese el nombre del seguro que desea eliminar: ");
				boolean resultado = admin.eliminarSeguro(nombreSeguro);
				File temp = eliminarSeguro(nombreSeguro);
				File bd = new File("Proyecto1_RentaCarros/data/Seguros.txt");
				bd.delete();
				temp.renameTo(bd);
				if (!resultado)
				{
					System.out.println("\nEl seguro no pudo eliminarse con exito");
				}
				else
				{
					System.out.println("\nEl seguro se elimino con exito");
					centinela = false;
				}
			}
			else if(3 == opcion) 
			{
				centinela = true;
				while (centinela) {
				String nombreSeguro = input("Ingrese el nombre del seguro que desea modificar");
				System.out.println("Menu opciones a modificar");
				System.out.println("1- Nombre");
				System.out.println("2- Valor de seguro");
				try {
				int opcion = Integer.parseInt(input("->"));
				
				if (opcion == 1) 
				{
					String nombre = input("Ingrese el nombre por el cual desea modificar el seguro: ");
					Seguro res = admin.modificarInfo(nombreSeguro, "nombre", nombre);
					if (res == null) {
						System.out.println("El seguro no pudo ser modificado con exito");
					}
					else {
					System.out.println(res);
					System.out.println("El seguro fue modificado con exito");
					centinela = false;
				}}

					
				
				else if (opcion == 2)
				{
					int valor = Integer.parseInt(input("Ingrese el valor por el cual desea cambiar"));
					Seguro res =admin.modificarInfo(nombreSeguro, "valor", Integer.toString(valor));
						if (res == null) 
						{
							System.out.println("el seguro no pudo ser modificado.");
						}
						else {
						System.out.println(res);
						System.out.println("el seguro fue modificado con exito");
						centinela = false;
						}
				}
			
				
				else 
				{
					System.out.println("\nRecuerde que el valor debe ser 1 o 2");
					
				}
				
				
				}
				catch(Exception e) 
				{
					System.out.println("\nRecuerde que debe ser un numero");
				}
				}
	
			}
			else if (opcion == 4) 
			{
				centinela = false;
			}
			

	}
	}
	private void ejecutarRegistrarCarro() {
		
		String placa = input("\nIngrese la placa del vehiculo ");
		String color = input("Ingrese  el color del vehiculo ");
		String marca = input("Ingrese  la marcad del vehiculo ");
		String modelo = input("Ingrese el modelo del vehiculo ");
		int anio = Integer.parseInt(input("Ingrese el anio en el cual se fabrico el vehiculo "));
		String transmision = input("Ingrese la transmision del vehiculo ");
		String gpsVehiculo = input("Ingrese la sede en donde estara el vehiculo ");
		String estadoActual = input("Ingrese  el estado del vehiculo ");
		String capacidadPersonas = input("Ingrese la capacidad de personas que tiene el vehiculo ");
		String Categoria = input("Ingrese la categoria del vehiculo ");
		String idCategoria = input("Ingrese el ID de la categoria");
		
		sobreEscribirData(placa,color,marca,modelo,anio,transmision,gpsVehiculo,estadoActual,capacidadPersonas,Categoria,idCategoria);
		
	}
	
	private void sobreEscribirData(String placa,String color,String marca,String modelo,Integer anio,String transmision,
			String gpsVehiculo,String estadoActual,String capacidadPersonas, String Categoria,String idCategoria) {
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        String data = "\n"+placa+","+color+","+marca+","+modelo+","+anio+","+transmision+","+gpsVehiculo+","+
	    estadoActual+","+capacidadPersonas+","+Categoria+","+idCategoria;
	        File file = new File("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
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
	
	public File eliminarSeguro(String nombre) {
		
		File lstSeguros = new File ("Proyecto1_RentaCarros/data/Seguros.txt");
			
		String nomTemp="Proyecto1_RentaCarros/data/temp.txt";
		File archivoTemp=new File(nomTemp);
		try {
			if(lstSeguros.exists()){
				BufferedReader br = new BufferedReader(new FileReader(lstSeguros));
				String linea;
				while((linea=br .readLine())!=null) {
					String[] partes = linea.split(",");
					if (!nombre.equals(partes[0])) {
	                       escribirArchivo(archivoTemp, linea);
	                    }           
	                }
  	                br.close();
	            }else{
	                System.out.println("El archivo no Existe");
	            }
	        } catch (Exception ex) {
	             System.out.println(ex.getMessage());
	        }
	        return archivoTemp;
	}
	
	public static  File eliminarVehiculo(Vehiculo vehiculo){        

		File lstVehiculos = new File ("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
		
        String nomTemp="Proyecto1_RentaCarros/data/temp.txt";
        File archivoTemp=new File(nomTemp);
        String placa = vehiculo.getPlaca();
        try {
            if(lstVehiculos.exists()){
                BufferedReader br = new BufferedReader(new FileReader(lstVehiculos));
                String linea;
                while((linea=br .readLine())!=null) {
                	String[] partes = linea.split(",");
                	if (!placa.equals(partes[0])) {
                       escribirArchivo(archivoTemp, linea);
                    }           
                }
                br.close();
            }else{
                System.out.println("El archivo no Existe");
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
        return archivoTemp;
    }
	
	public static void escribirArchivo(File archivo,String info){
		  try {
		           if(!archivo.exists()){
		               archivo.createNewFile();
		           }
		          BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo,true), "utf-8"));
		          bw.write(info + "\r\n");
		          bw.close();
		       } catch (Exception ex) { 
		          System.out.println(ex.getMessage());
		       } 
	}
	
	private void sobreEscribirSeguros(String nombreSeguro,int valorSeguro) {
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        String data = "\n"+nombreSeguro+","+Integer.toString(valorSeguro);
	        File file = new File("Proyecto1_RentaCarros/data/Seguros.txt");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        fw = new FileWriter(file.getAbsoluteFile(), true);
	        bw = new BufferedWriter(fw);
	        bw.write(data);
	        System.out.println("\n¡Información agregada!");
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
