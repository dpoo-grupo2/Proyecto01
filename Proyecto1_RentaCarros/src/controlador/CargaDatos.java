package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.CategoriaVehiculo;
import modelo.Usuario;
import modelo.Vehiculo;

public class CargaDatos { 
	private static HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> sedes = new HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>>();
	private static CategoriaVehiculo categoria;
	
	
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
                    String transmicion = partes[5].trim();
                    String gpsVehiculo = partes[6].trim();
                    String estadoActual = partes[7].trim();
                    String capacidadPersonas = partes[8].trim();
                    String categoria = partes[9].trim();
                    String idCategoria = partes[10].trim();
                    try {
                        
                        System.out.println(placa+", "+color+", "+marca+", "+modelo+", "+anio+", "+transmicion+", "+gpsVehiculo+", "+estadoActual+", "+capacidadPersonas+", "+categoria+", "+idCategoria);
                        Vehiculo vel = new Vehiculo(placa, color, marca, modelo, Integer.parseInt(anio), transmicion, gpsVehiculo, estadoActual, Integer.parseInt(capacidadPersonas), categoria, Integer.parseInt(idCategoria));
                        addSede(vel);
                        System.out.println(sedes);
                    } catch (NumberFormatException e) {
                        System.out.println("Error");
                    }
                } 
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private static HashMap<Integer,CategoriaVehiculo> addVehiculoCat(HashMap<Integer,CategoriaVehiculo> categoria2, Vehiculo carro)
    {
    	ArrayList<Vehiculo> lstVehiculos = new ArrayList();
    	if (!categoria2.containsKey(carro.getIdCat())) 
    	{
    		
    		categoria = new CategoriaVehiculo(carro.getCategoria(), carro.getIdCat(),lstVehiculos , 0, 0, 0);
    		categoria2.put(carro.getIdCat(), categoria);
    	}
    	CategoriaVehiculo cat = categoria2.get(carro.getIdCat());
    	cat.añadirElemento(carro);
		return categoria2;
    	
    }
    
    private static HashMap<String,HashMap<Integer,CategoriaVehiculo>> addCategoriaDisponibilidad(HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad,Vehiculo vehiculo)
    {
    	if (!disponibilidad.containsKey(vehiculo.getEstado())) 
    	{
    		HashMap<Integer,CategoriaVehiculo> mapCat = new HashMap<Integer,CategoriaVehiculo>(); 
    		disponibilidad.put(vehiculo.getEstado(),mapCat);
    	}
    	HashMap<Integer,CategoriaVehiculo> map2 = disponibilidad.get(vehiculo.getEstado());
    	addVehiculoCat(map2,vehiculo);
    	
		return disponibilidad;	
    }
    
    private static HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> addSede(Vehiculo vehiculo)
    {
    	
    	if (!sedes.containsKey(vehiculo.getGps())) 
    	{
    		HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad = new HashMap<String,HashMap<Integer,CategoriaVehiculo>>();
    		sedes.put(vehiculo.getGps(),disponibilidad);
    	}
    	HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad2 = sedes.get(vehiculo.getGps());
    	addCategoriaDisponibilidad(disponibilidad2,vehiculo);
    	
		return sedes;
    	
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