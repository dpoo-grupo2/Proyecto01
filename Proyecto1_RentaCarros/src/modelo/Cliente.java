package modelo;

import java.util.ArrayList;

public class Cliente extends Usuario
{
	private Integer edad; 
	private String cedula;
	private String correoElectronico;
	private String fechaNacimiento;
	private Reserva reserva;

	public Cliente(String login, String password, String nombreCompleto, String tipoUsuario, int edad,String cedula, String correoElectronico,String fechaNacimiento) // falta implementar usuario
	{
		super(login, password, nombreCompleto,tipoUsuario);
		this.edad = edad;
		this.cedula = cedula;
		this.correoElectronico = correoElectronico;
		this.fechaNacimiento = fechaNacimiento;
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
	public Reserva crearReserva(boolean estadoTarjeta, String sedeEntrega, String sedeRecogida, String fechaRecogida, String horaRecogida, String fechaEntrega,String horaEntrega,Cliente cliente,ArrayList<Seguro> lstSeguro,int valorReserva,ArrayList<ConductorAdicional> lstConductores,ArrayList<Reserva> lstReserva,int dias) 
	{
		reserva = new Reserva(estadoTarjeta, sedeEntrega, sedeRecogida, fechaRecogida, horaRecogida, fechaEntrega, horaEntrega, lstSeguro, cliente,valorReserva,lstConductores,dias);
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

}