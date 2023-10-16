package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Usuario;

public class CargaDatos { 
	
	public void cargarInformacionVehiculos(String string) 
	{
    	cargarVehiculos(new File(string));
    }

    private void cargarVehiculos(File archivoVehiculos) {

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
    
    public Map<String, Usuario> cargarInformacionUsuarios(String string) {
    	return cargarUsuarios(new File (string));
    }

	private  Map<String, Usuario> cargarUsuarios(File archivoUsuarios) {
		Map<String,Usuario> usuarios = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String usuario = partes[0].trim();
                    String contraseña = partes[1].trim();
                    String nombreCompleto  = partes[2].trim();
                    String tipoUsuario = partes[3].trim();
                    Usuario clsUsuario = new Usuario(usuario,contraseña,nombreCompleto,tipoUsuario);
                    usuarios.put(usuario,clsUsuario);
                } 
            }
            System.out.println(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return usuarios;
	}



}
