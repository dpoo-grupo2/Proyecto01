package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Calendar;

import modelo.AdministradorLocal;
import modelo.CategoriaVehiculo;
import modelo.Cliente;
import modelo.ConductorAdicional;
import modelo.LicenciaConduccion;
import modelo.MedioPago;
import modelo.Reserva;
import modelo.Sede;
import modelo.Seguro;
import modelo.Usuario;
import modelo.Vehiculo;

public class CargaDatos { 
	private static HashMap<String,Sede> sedes = new HashMap<String,Sede>();
	private static HashMap<String,Usuario> usuarios = new HashMap<String,Usuario>();
	private static CategoriaVehiculo categoria;
	private static ArrayList<Seguro> lstSegurosGeneral = new ArrayList<Seguro>();
	private static ArrayList<Reserva> lstReservas = new ArrayList<Reserva>();
	private static HashMap<String, Cliente> lstCliente = new HashMap<String, Cliente>();
	private int idReserva = 0;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
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
    
    private static HashMap<String,HashMap<Integer,CategoriaVehiculo>> addCategoriaDisponibilidad(Sede objSede,Vehiculo vehiculo)
    {
    	HashMap<String,HashMap<Integer,CategoriaVehiculo>> mapEstadoVehiculo =objSede.getMapEstadoVehiculo();
    	if (!mapEstadoVehiculo.containsKey(vehiculo.getEstado())) 
    	{
    		HashMap<Integer,CategoriaVehiculo> mapCat = new HashMap<Integer,CategoriaVehiculo>(); 
    		mapEstadoVehiculo.put(vehiculo.getEstado(),mapCat);
    	}
    	HashMap<Integer,CategoriaVehiculo> map2 = mapEstadoVehiculo.get(vehiculo.getEstado());
    	addVehiculoCat(map2,vehiculo);
    	
		return mapEstadoVehiculo;	
    }
    
    private static HashMap<String,Sede> addSede(Vehiculo vehiculo)
    {
    	
    	Sede sede = new Sede(vehiculo.getGps(),"No hay dirección","No hay horario",null,null);
    	if (!sedes.containsKey(vehiculo.getGps())) 
    	{	
    		AdministradorLocal adminLocal = null;
    		HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad = new HashMap<String,HashMap<Integer,CategoriaVehiculo>>();
    		sede = new Sede(vehiculo.getGps(),"No hay dirección","No hay horario",adminLocal,disponibilidad);
    		
    		sedes.put(vehiculo.getGps(),sede);
    	}
    	Sede objSede = sedes.get(vehiculo.getGps());
    	addCategoriaDisponibilidad(objSede,vehiculo);
    	
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
                   
                    
                    LicenciaConduccion licencia = new LicenciaConduccion(numeroLicencia,pais,fechaVencimientoLicencia);
                                       
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
		this.lstCliente = clientes;
		return clientes;
	}
	
	public void sobreEscribirAdicional(String placa,String nombres, String telefono, String correoElectronico, String numeroLicencia,
			String paisExpedicion, String fechaVencimiento) {
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        String data = ("\n"+placa+","+nombres+","+telefono+","+correoElectronico+","+numeroLicencia+","+paisExpedicion+","+fechaVencimiento);
	        
	        File file = new File("Proyecto1_RentaCarros/data/ConductoresAdicionales.txt");
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
	
	public HashMap<String,Sede> getSedes()
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
	public Reserva getReserva(int id){
		for (Reserva i:lstReservas) 
		{		
		if (i.getIdReserva() == id) 
		{
			return i ;
		}
		}
		return null;
	}
public ArrayList<Seguro> settteLstSeguros(ArrayList<Seguro> lstNuevo)
{
	lstSegurosGeneral = lstNuevo;
	return lstSegurosGeneral; 
}

public Cliente obtenerUsuarioCliente(String usuario) 
{
	return lstCliente.get(usuario);
}
public Vehiculo getVehiculo(String sede,String estado,int idCategoria,String placa) 
{
	try {
	Sede objSede = sedes.get(sede);
	HashMap<String,HashMap<Integer,CategoriaVehiculo>> mapEstado =objSede.getMapEstadoVehiculo();
	HashMap<Integer,CategoriaVehiculo> mapCategoria = mapEstado.get(estado);
	CategoriaVehiculo objCategoria = mapCategoria.get(idCategoria);
	ArrayList<Vehiculo> lstVehiculos = objCategoria.getLst();
	for (int i = 0; i < lstVehiculos.size(); i++) {
		if (lstVehiculos.get(i).getPlaca().equals(placa)) 
		{
			return lstVehiculos.get(i);
		}
	}
	return null;
	}
	catch(Exception e) 
	{
	return null;	
	}
	}
public void CargarReservas(File archivoReservas ) 
{
	try (BufferedReader br = new BufferedReader(new FileReader(archivoReservas))) {
        String linea;

        while ((linea = br.readLine()) != null) 
        {
        	String[] partes = linea.split(",");

        	try {
        		idReserva=Integer.parseInt(partes[0]); 
            	boolean estadoTarjeta = Boolean.parseBoolean(partes[1]);
            	String sedeEntrega = partes[2];
            	String sedeRecogida = partes[3];
            	Date fechaRecogida = dateFormat.parse(partes[4]);
//            	HoraRecogida no como hacerlo y q paja mirar a estas horas
            	Date fechaEntrega = dateFormat.parse(partes[6]);
//            	HoraEntrega partes[7]
            	ArrayList<Seguro> lstSeguro = new ArrayList<Seguro>();
            	String nameCliente = partes[8];//falta obtener el obj cliente
            	int valorReserva = Integer.parseInt(partes[9]);
            	ArrayList<ConductorAdicional> lstConductores = new ArrayList<ConductorAdicional>();
            	int dias = Integer.parseInt(partes[11]);
//            	Reserva reserva = new Reserva();
        		
        	}
        	catch(Exception e)
        	{
        		continue;
        	}
        }
	}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
private void sobreEscribirReserva(Reserva reserva) {
	BufferedWriter bw = null;
    FileWriter fw = null;
    Cliente clienteRes = reserva.getClienteRes();
    //obteniendo valor de todas las varibales para escribirlas en el txt
    boolean estadoTarjeta = reserva.getTarjeta();
    String sedeEntrega = reserva.getSedeEntrega();
    String sedeRecogida = reserva.getSedeRecogida();
    Date fechaRecogida = reserva.getFechaRecogida();
    String horaRecogida = reserva.getHoraRecogida();
    Date fechaEntrega = reserva.getFechaEntrega();
    String horaEntrega = reserva.getHoraEntrega();
    ArrayList<Seguro> lstSeguro = reserva.getLstSeguro(); // toca ver como poner esto en el txt
    String usuario = clienteRes.getLogin();
    int valorReserva = reserva.getValor();
    ArrayList<ConductorAdicional> lstConductores = reserva.getConductores(); //toca ver como poner esto en el txt
    long dias = reserva.getDias();
    int idReserva = reserva.getIdReserva();
    try {
        String data = "\n"+Boolean.toString(estadoTarjeta)+","+sedeEntrega+","+sedeRecogida+","+fechaRecogida+","+horaRecogida+","+fechaEntrega+","+
        horaEntrega+","+"lstSeguro"+","+usuario+","+Integer.toString(valorReserva)+","+"lstConductores"+","+Long.toString(dias)+","+Integer.toBinaryString(idReserva);
        File file = new File("Proyecto1_RentaCarros/data/Reservas.txt");
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
}