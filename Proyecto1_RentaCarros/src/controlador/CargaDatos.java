package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CargaDatos {

	
	public void cargarInformacionVehiculos(File archivoVehiculos) 
	{
    	
    	cargarVehiculos(new File("data/ListaVehiculos.txt"));
    }

    private void cargarVehiculos(File archivoVehiculos) {

        try (BufferedReader br = new BufferedReader(new FileReader(archivoVehiculos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 10) {
                    String placa = partes[0].trim();
                    String color = partes[1].trim();
                    String marca = partes[2].trim();
                    String modelo = partes[3].trim();
                    String transmision = partes[4].trim();
                    String gpsVehiculo = partes[5].trim();
                    String estadoActual = partes[6].trim();
                    String capacidadPersonas = partes[7].trim();
                    String categoria = partes[8].trim();
                    String idCategoria = partes[9].trim();
                    try {
                        
                        System.out.println(placa+color+marca+modelo+transmision+gpsVehiculo+estadoActual+capacidadPersonas+categoria+idCategoria);
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
