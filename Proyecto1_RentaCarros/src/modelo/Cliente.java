package modelo;

import java.util.ArrayList;
import java.util.HashMap;

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
//	private HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> sedes = carga.getSedes();
	
	private CargaDatos carga = new CargaDatos();
	private HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> sedes = carga.getSedes();


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
	public Reserva crearReserva(boolean estadoTarjeta, String sedeEntrega, String sedeRecogida, String fechaRecogida, String horaRecogida, String fechaEntrega,String horaEntrega,Cliente cliente,ArrayList<Seguro> lstSeguro,int valorReserva,ArrayList<ConductorAdicional> lstConductores,ArrayList<Reserva> lstReserva,int dias, int idReserva) 
	{
		reserva = new Reserva(estadoTarjeta, sedeEntrega, sedeRecogida, fechaRecogida, horaRecogida, fechaEntrega, horaEntrega, lstSeguro, cliente,valorReserva,lstConductores,dias,idReserva);
		añadirReserva(lstReserva);
		
		return reserva;
	}
	public void añadirReserva(ArrayList<Reserva> lstReserva) 
	{
	lstReserva.add(reserva);
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
//	public Vehiculo verDisponiblidad(String sede,String categoria,String fecha) 
//	{
//		try 
//		{
//			HashMap<String,HashMap<Integer,CategoriaVehiculo>> mapDisponibilidad = sedes.get(sede);
//			HashMap<Integer,CategoriaVehiculo> mapCategoria= mapDisponibilidad .get(categoria);
//		}
//		catch(Exception e)
//		{}
//		return null;
//		
//	}
	

}