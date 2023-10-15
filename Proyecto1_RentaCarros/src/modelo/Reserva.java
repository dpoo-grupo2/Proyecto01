package modelo;

public class Reserva
{
private int tarifaDiaria; // varia dependiendo del dia y temporada
private boolean estadoTarjeta;
private String sedeEntrega;
private String sedeRecogida;
private String fechaRecogida;
private String horaRecogida;
private String fechaEntrega;
private String horaEntrega;
private Seguro[] lstSeguros;
private Cliente clienteRes;
public Reserva(int tarifaDiaria,boolean estadoTarjeta, String sedeEntrega, String sedeRecogida, String fechaRecogida, String horaRecogida,String fechaEntrega
		,String horaEntrega,Seguro[] lstSeguros, Cliente clienteRes){
	this.clienteRes = clienteRes;
	this.estadoTarjeta = estadoTarjeta;
	this.fechaEntrega = fechaEntrega;
	this.fechaRecogida = fechaRecogida;
	this.horaEntrega = horaEntrega;
	this.horaRecogida = horaRecogida;
	this.lstSeguros = lstSeguros;
	this.sedeEntrega = sedeEntrega;
	this.sedeRecogida = sedeRecogida;

	
}
}
