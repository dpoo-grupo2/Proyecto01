package modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import controlador.CargaDatos;

public class Cliente extends Usuario
{
	private Integer edad; 
	private String cedula;
	private String correoElectronico;
	private String fechaNacimiento;
	private Reserva reserva;
	private LicenciaConduccion licencia;
	private MedioPago medioPago;
	private ArrayList<Reserva> lstReservas = new ArrayList<Reserva>();
	private CargaDatos carga = new CargaDatos();
	private HashMap<String,Sede> sedes = carga.getSedes();


	public Cliente(String login, String password, String nombreCompleto, String tipoUsuario, int edad,String cedula,String fechaNacimiento, String correoElectronico, LicenciaConduccion licencia, MedioPago medioPago)
	{
		super(login, password, nombreCompleto,tipoUsuario);
		this.edad = edad;
		this.cedula = cedula;
		this.correoElectronico = correoElectronico;
		this.fechaNacimiento = fechaNacimiento;
		this.licencia = licencia;
		this.medioPago = medioPago;
	}
	
	public Integer getEdad() 
	{
		return this.edad;
	}
	public String getCedula()
	{
		return this.cedula;
	}
	public String getCorreo() 
	{
		return this.correoElectronico;
	}
	public String getFechaNacimiento() 
	{
		return this.fechaNacimiento;	
	}
	public Reserva crearReserva(boolean estadoTarjeta, String sedeEntrega, String sedeRecogida, Date fechaRecogida, String horaRecogida, Date fechaEntrega,String horaEntrega,Cliente cliente,ArrayList<Seguro> lstSeguro,int valorReserva,ArrayList<ConductorAdicional> lstConductores,int dias, int idReserva,Vehiculo vehiculo) 
	{
		System.out.println("esta dentro de cliente");
		reserva = new Reserva(estadoTarjeta, sedeEntrega, sedeRecogida, fechaRecogida, horaRecogida, fechaEntrega, horaEntrega, lstSeguro, cliente,valorReserva,dias,idReserva, vehiculo);
		añadirReserva(lstReservas);
		sobreEscribirReserva(reserva);
		System.out.println("SE SUPONE QUE YA SE ESTA AGREGANDO");
		return reserva;
	}
	public void añadirReserva(ArrayList<Reserva> lstReserva) 
	{
	lstReserva.add(reserva);
//	sobreEscribirReserva(reserva));
	}
	public int calcularValor(ArrayList<Seguro> lstSeguros,ArrayList<ConductorAdicional> lstConductores,int tarifaDiaria,int tarifaConductor) 
	{
		int valorFinal = 0;
		long nDias = reserva.getDias();//
		valorFinal +=tarifaDiaria*nDias;
		valorFinal += tarifaConductor*lstConductores.size();
		for (int i = 0; i < lstSeguros.size(); i++) {
			Seguro seguro = lstSeguros.get(i);
			valorFinal += seguro.getValorSeguro();
		}
		return valorFinal;
		
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
	public Vehiculo verDisponibilidad(String sede,int categoria,Date fechaEntrega,Date fechaRecogida) 
	{
		try {
		
		ArrayList<String> lstPlacas = new ArrayList<String>();
			
			for (int i = 0; i < carga.getLstReserva().size(); i++) {
				Reserva res = carga.getLstReserva().get(i);
				
				if (fechaEnRango(fechaEntrega,fechaRecogida,res.getFechaRecogida()) && fechaEnRango(fechaEntrega,fechaRecogida,res.getFechaRecogida())) 
				{
					Vehiculo vel = res.getvehiculo();
					String placa = vel.getPlaca();
					lstPlacas.add(placa);
				}
			}
			
			Sede objSede = sedes.get(sede);
			HashMap<String,HashMap<Integer,CategoriaVehiculo>> mapDisponibilidad = objSede.getMapEstadoVehiculo();
			HashMap<Integer,CategoriaVehiculo> mapCategoria= mapDisponibilidad .get("disponible");
			
			CategoriaVehiculo objCategoria = mapCategoria.get(categoria);
			
			Vehiculo veh = new Vehiculo(sede, sede, sede, sede, categoria, sede, sede, sede, categoria, sede, categoria);
			boolean Estado = false;
			for (int i = 0; i < objCategoria.getLst().size(); i++) {
				if (!lstPlacas.contains(objCategoria.getLst().get(i).getPlaca())) 
				{
					veh = objCategoria.getLst().get(i);
					Estado = true;
					
					break;
				}
				
			}
			if (Estado)
			{
				
				return veh;
			}
			mapCategoria= mapDisponibilidad .get("alquilado");
			objCategoria = mapCategoria.get(categoria);
			for (int i = 0; i < objCategoria.getLst().size(); i++) {
				if (!lstPlacas.contains(objCategoria.getLst().get(i).getPlaca())) 
				{
					veh = objCategoria.getLst().get(i);
					Estado = true;
					break;
				}
				
			}
			
			if (Estado) 
			{
				return veh;
			}
			
			return null;
		}
		catch (Exception e) 
		{
			return null;
		}
		}
	
	private boolean fechaEnRango(Date fechaEntregaF,Date fechaRecibidoF,Date fechaRevisar) 
	{
		
        
        if (fechaRevisar.after(fechaEntregaF) && fechaRevisar.before(fechaRecibidoF)) {
            return true;
        } else {
            return false;
        }
	}}

