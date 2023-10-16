package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import modelo.Usuario;

public class CargaDatos {
	
	private static List<Usuario> usuarios; 
	
	public static void cargarInformacionVehiculos(String string) 
	{
    	cargarVehiculos(new File(string));
    }

    private static void cargarVehiculos(File archivoVehiculos) {

        try (BufferedReader br = new BufferedReader(new FileReader(archivoVehiculos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 11) {
                    String placa = partes[0].trim();
                    String color = partes[1].trim();
                    String marca = partes[2].trim();
                    String modelo = partes[3].trim();
                    String anio = partes[4].trim();
                    String transmision = partes[5].trim();
                    String gpsVehiculo = partes[6].trim();
                    String estadoActual = partes[7].trim();
                    String capacidadPersonas = partes[8].trim();
                    String categoria = partes[9].trim();
                    String idCategoria = partes[10].trim();
                    try {
                        
                        System.out.println(placa+", "+color+", "+marca+", "+modelo+", "+anio+", "+transmision+", "+gpsVehiculo+", "+estadoActual+", "+capacidadPersonas+", "+categoria+", "+idCategoria);
                    } catch (NumberFormatException e) {
                        System.out.println("Error");
                    }
                } 
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void cargarInformacionUsuarios(String string) {
    	cargarUsuarios(new File (string));
    }

	private static void cargarUsuarios(File archivoUsuarios) {
		try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String usuario = partes[0].trim();
                    String contraseña = partes[1].trim();
                    String nombreCompleto  = partes[2].trim();
                    String tipoUsuario = partes[3].trim();
                    Usuario clsUsuario = new Usuario(usuario,contraseña,nombreCompleto,tipoUsuario);
                    usuarios.add(clsUsuario);
                    try {
                    	System.out.println(usuario +", "+contraseña+", "+nombreCompleto+", "+tipoUsuario);
                    } catch (NumberFormatException e) {
                        System.out.println("Error");
                    }
                } 
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}



}
