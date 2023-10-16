package modelo;

public class Reserva
{
private int tarifaDiaria; // varia dependiendo del dia y temporada
private boolean estadoTarjeta;
private String sedeEntrega;
private String sedeRecogida;
private String fechaRecogida;
private String fechaEntrega;
private String horaEntrega;
private String horaRecogida;
private Seguro[] lstSeguros;
private Cliente clienteRes;
public Reserva(int tarifaDiaria,boolean estadoTarjeta, String sedeEntrega, String sedeRecogida, String fechaRecogida, String horaRecogida,String fechaEntrega
		,String horaEntrega,Seguro[] lstSeguros, Cliente clienteRes){
	this.tarifaDiaria = tarifaDiaria;
	this.estadoTarjeta = estadoTarjeta;
	this.sedeEntrega = sedeEntrega;
	this.sedeRecogida = sedeRecogida;
	this.fechaRecogida = fechaRecogida;
	this.fechaEntrega = fechaEntrega;
	this.horaEntrega = horaEntrega;
	this.horaRecogida = horaRecogida;
	this.lstSeguros = lstSeguros;
	this.clienteRes = clienteRes;


	
}
public boolean getTarjeta()
{
	return this.estadoTarjeta;
}
public String getFechaEntrega()
{
	return this.fechaEntrega;
}
public String getFechaRecogida()
{
	return this.fechaRecogida;
}
public String getHoraaEntrega()
{
	return this.horaEntrega;
}public String gethoraRecogida()
{
	return this.horaRecogida;
}
public Seguro[] getLstSeguro()
{
	return this.lstSeguros;
}public String getSedeEntrega()
{
	return this.sedeEntrega;
}public String getSedeRecogida()
{
	return this.sedeRecogida;
}public Cliente getClienteRes()
{
	return this.clienteRes;
}
public int getTarifa() 
{
return this.tarifaDiaria;	
}
}
