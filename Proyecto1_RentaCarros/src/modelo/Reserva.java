package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Reserva
{
	private boolean estadoTarjeta;
	private String sedeEntrega;
	private String sedeRecogida;
	private java.util.Date fechaRecogida;
	private java.util.Date fechaEntrega;
	private String horaEntrega;
	private String horaRecogida;
	private ArrayList<Seguro> lstSeguros;
	private Cliente clienteRes;
	private int valorReserva;
	private ArrayList<ConductorAdicional> lstConductores;
	private long dias;
	private int idReserva;
	private Vehiculo vehiculo;
	public Reserva(boolean estadoTarjeta, String sedeEntrega, String sedeRecogida, java.util.Date fechaRecogida2, String horaRecogida,java.util.Date fechaEntrega2
			,String horaEntrega,ArrayList<Seguro> lstSeguros, Cliente clienteRes,int valorReserva,long dias,int idReserva,Vehiculo vehiculo)
	{
		
		
		this.estadoTarjeta = estadoTarjeta;
		this.sedeEntrega = sedeEntrega;
		this.sedeRecogida = sedeRecogida;
		this.fechaRecogida = fechaRecogida2;
		this.fechaEntrega = fechaEntrega2;
		this.horaEntrega = horaEntrega;
		this.horaRecogida = horaRecogida;
		this.lstSeguros = lstSeguros;
		this.clienteRes = clienteRes;
		this.valorReserva = valorReserva;
		this.dias = dias;
		this.idReserva = idReserva;
		this.vehiculo = vehiculo;
	}
	
	public boolean getTarjeta()
	{
		return this.estadoTarjeta;
	}
	
	public java.util.Date getFechaEntrega()
	{
		return this.fechaEntrega;
	}
	
	public java.util.Date getFechaRecogida()
	{
		return this.fechaRecogida;
	}
	
	public String getHoraEntrega()
	{
		return this.horaEntrega;
	}
	
	public String getHoraRecogida()
	{
		return this.horaRecogida;
	}
	
	public ArrayList<Seguro> getLstSeguro()
	{
		return this.lstSeguros;
	}
	
	public String getSedeEntrega()
	{
		return this.sedeEntrega;
	}
	
	public String getSedeRecogida()
	{
		return this.sedeRecogida;
	}
	
	public Cliente getClienteRes()
	{
		return this.clienteRes;
	}
	
	public int getValor() 
	{
		return valorReserva;
		
	}
	public long getDias()
	{
		return dias;
		
	}
	public Vehiculo getvehiculo() 
	{
		return vehiculo;
		
	}
	public int getIdReserva() 
	{
		return idReserva;
		
	}
	public int modValor(int valorNuevo) 
	{
		valorReserva = valorNuevo;
		return valorReserva;
		
	}
	
	public ArrayList<ConductorAdicional> addConductores(ArrayList<ConductorAdicional> lstConductores){
		this.lstConductores = lstConductores;
		return lstConductores;
	}
	
	public ArrayList<ConductorAdicional> getConductores()
	{
		return lstConductores;
	}
	
	public ArrayList<Seguro> addSeguro(Seguro seguro)
	{
		lstSeguros.add(seguro);
		return lstSeguros;
		
	}
	public ArrayList<Seguro> delSeguro(int posEl)
	{
		lstSeguros.remove(posEl);
		return lstSeguros;	
	}
	public String toString() 
	{
		return Integer.toString(idReserva)+" a es una reserva";
		
	}
}
