package vista;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import controlador.CargaDatos;
import modelo.Administrador;
import modelo.CategoriaVehiculo;
import modelo.Vehiculo;
import vista.Login;


public class AdministradorGeneral {
	private int opcion;
	private boolean centinela;
	private Administrador admin = new Administrador();

	
	
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
				ejecutarRegistrarCarro();
				System.out.println("\nCarro registrado correctamente...\n");
				menu(usuario);
	            
			}
			
			else if(2 == opcion) 
			{{try {
				eliminarVehiculo(admin.eliminarVehiculo(sedes, "sedeCentro", "ABC123", "alquilado", 1));
				System.out.println("\nCarro eliminado correctamente...\n");
			}
			catch(Exception e) 
			{
			System.out.println("esa informacion ed vehiculo esta mal");	
			}
			}
				menu(usuario);
			}
			
			else if(3 == opcion) 
			{
				menu(usuario);
			}
			
			else if (4 == opcion) 
			{
				menu(usuario);
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
	

//	private void eliminarVehiculo (Vehiculo vehiculo)
//	{
//		try (BufferedReader reader = new BufferedReader (new FileReader ("Proyecto1_RentaCarros/data/PruebaCarros")))
//		{
//			String line;
//			String input = "";
//			while ((line = reader.readLine()) != null) {
//				String[] carInfo = line. split (", ");
//				if (vehiculo.getPlaca().equals(carInfo[0])) {
//				}else {
//					input += line+" \n";
//				}
//			}
//			FileOutputStream fileOut = new FileOutputStream ("Proyecto1_RentaCarros/data/PruebaCarros");
//				fileOut.write(input. getBytes ());
//				fileOut.close();
//	
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//	
	public static  void eliminarVehiculo(Vehiculo vehiculo){        
        
		File lstVehiculos = new File ("Proyecto1_RentaCarros/data/PruebaCarros.txt");
		
        String nomTemp="temp.txt";
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
                lstVehiculos.delete();
                archivoTemp.renameTo(lstVehiculos);
                br.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
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
}
