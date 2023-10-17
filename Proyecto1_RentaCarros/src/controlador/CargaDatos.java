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
import modelo.Cliente;
import modelo.LicenciaConduccion;
import modelo.MedioPago;
import modelo.Reserva;
import modelo.Sede;
import modelo.Seguro;
import modelo.Usuario;
import modelo.Vehiculo;

public class CargaDatos { 
	private static HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> sedes = new HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>>();
	private static CategoriaVehiculo categoria;
	private static ArrayList<Sede> lstSedes;
	private static ArrayList<Seguro> lstSegurosGeneral = new ArrayList<Seguro>();
	private static ArrayList<Reserva> lstReservas = new ArrayList<Reserva>();
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
                        
                   
                        Vehiculo vel = new Vehiculo(placa, color, marca, modelo, Integer.parseInt(anio), transmicion, gpsVehiculo, estadoActual, Integer.parseInt(capacidadPersonas), categoria, Integer.parseInt(idCategoria));
                        addSede(vel);
                    } catch (NumberFormatException e) {

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
//    		sede = new Sede();
//    		lstSedes.add(sede);
    		sedes.put(vehiculo.getGps(),disponibilidad);
    	}
    	HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad2 = sedes.get(vehiculo.getGps());
    	addCategoriaDisponibilidad(disponibilidad2,vehiculo);
    	
		return sedes;
    	
    }
    
    
    public HashMap<String, Usuario> cargarInformacionUsuarios(String string) {
    	return cargarUsuarios(new File (string));
    }

	private  HashMap<String, Usuario> cargarUsuarios(File archivoUsuarios) {
		HashMap<String,Usuario> usuarios = new HashMap<>();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
		return usuarios;
	}
	
	 public HashMap<String, Cliente> cargarInformacionClientes(String string) {
	    	return cargarClientes(new File (string));
	    } 
	 
	private HashMap<String,Cliente> cargarClientes(File archivoClientes){
		HashMap<String,Cliente> clientes = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(archivoClientes))) {
            String linea;
            linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    String infoCliente = partes[0].trim();
                    String[] cliente = infoCliente.split(",");
                    String usuario = cliente[0].trim();
                    String contraseña= cliente[1].trim();
                    String nombreCompleto = cliente[2].trim();
                    String edad = cliente[3].trim();
                    String cedula = cliente[4].trim();
                    String fechaNacimiento = cliente[5].trim();
                    String correo = cliente[6].trim();
                    
                    String infoLicencia = partes[1].trim();
                    String[] info = infoLicencia.split(",");
                    String numeroLicencia = info[0].trim();
                    String pais = info[1].trim();
                    String fechaVencimientoLicencia = info[2].trim();
                   
                    int numLicencia = Integer.parseInt(numeroLicencia);
                    LicenciaConduccion licencia = new LicenciaConduccion(numLicencia,pais,fechaVencimientoLicencia);
                                       
                    String infoMedio  = partes[2].trim();
                    String[] infoTarget = infoMedio.split(",");
                    String tipo = infoTarget[0].trim();
                    String numero = infoTarget[1].trim();
                    String fechaVencimientoTarjeta = infoTarget[2].trim();
                    MedioPago medioPago = new MedioPago(tipo, numero, fechaVencimientoTarjeta);
                    
                    Cliente clsCliente = new Cliente(usuario,contraseña,nombreCompleto,"Cliente",Integer.parseInt(edad),cedula,fechaNacimiento,correo,licencia, medioPago);
                    clientes.put(usuario,clsCliente);
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return clientes;
	}
	public HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> getSedes()
	{
		return sedes;
		
	}
	public ArrayList<Seguro> getLstSeguro()
	{
		return lstSegurosGeneral;
		
	}
	public ArrayList<Reserva> getLstReserva()
	{
		return lstReservas;
		
	}
public ArrayList<Seguro> settteLstSeguros(ArrayList<Seguro> lstNuevo)
{
	lstSegurosGeneral = lstNuevo;
	return lstSegurosGeneral; 
}


}