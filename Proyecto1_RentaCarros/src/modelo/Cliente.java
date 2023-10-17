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
	public Reserva crearReserva(boolean estadoTarjeta, String sedeEntrega, String sedeRecogida, Date fechaRecogida, String horaRecogida, Date fechaEntrega,String horaEntrega,Cliente cliente,ArrayList<Seguro> lstSeguro,int valorReserva,ArrayList<ConductorAdicional> lstConductores,ArrayList<Reserva> lstReserva,int dias, int idReserva,Vehiculo vehiculo) 
	{
		reserva = new Reserva(estadoTarjeta, sedeEntrega, sedeRecogida, fechaRecogida, horaRecogida, fechaEntrega, horaEntrega, lstSeguro, cliente,valorReserva,lstConductores,dias,idReserva, vehiculo);
		añadirReserva(lstReserva);
		
		return reserva;
	}
	public void añadirReserva(ArrayList<Reserva> lstReserva) 
	{
	lstReserva.add(reserva);
	//sobreEscribirReserva();
	}
	public int calcularValor(ArrayList<Seguro> lstSeguros,ArrayList<ConductorAdicional> lstConductores,int tarifaDiaria,int tarifaConductor) 
	{
		int valorFinal = 0;
		int nDias = reserva.getDias();//
		valorFinal +=tarifaDiaria*nDias;
		valorFinal += tarifaConductor*lstConductores.size();
		for (int i = 0; i < lstSeguros.size(); i++) {
			Seguro seguro = lstSeguros.get(i);
			valorFinal += seguro.getValorSeguro();
		}
		return valorFinal;
		
	}
	private void sobreEscribirReserva(boolean estadoTarjeta,String sedeEntrega,String sedeRecogida,String fechaRecogida,String horaRecogida,
			String fechaEntrega,String horaEntrega,String lstSeguro,String usuario,int valorReserva,String lstConductores,int dias,int idReserva) {
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        String data = "\n"+Boolean.toString(estadoTarjeta)+","+sedeEntrega+","+sedeRecogida+","+fechaRecogida+","+horaRecogida+","+fechaEntrega+","+
	        horaEntrega+","+lstSeguro+","+usuario+","+Integer.toString(valorReserva)+","+lstConductores+","+Integer.toString(dias)+","+Integer.toBinaryString(idReserva);
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
	public Vehiculo verDisponiblidad(String sede,String categoria,Date fechaEntrega,Date fechaRecogida) 
	{
		ArrayList<String> lstPlacas = new ArrayList<String>();
		try 
		{
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
			boolean Estado = false;
			for (int i = 0; i < objCategoria.getLst().size(); i++) {
				if (!lstPlacas.contains(objCategoria.getLst().get(i).getPlaca())) 
				{
					Estado = true;
					break;
				}
				
			}
			
		}
		catch(Exception e)
		{}
		return null;
		
	}
	private boolean fechaEnRango(Date fechaEntregaF,Date fechaRecibidoF,Date fechaRevisar) 
	{
		
        
        if (fechaRevisar.after(fechaEntregaF) && fechaRevisar.before(fechaRecibidoF)) {
            return true;
        } else {
            return false;
        }
	}}

