package modelo;

import controlador.CargaDatos;

public class Empleado {

	private CargaDatos carga = new CargaDatos();
	
	public void agregarConductorAdicional(String idReserva, String nombres,String telefono,String correoElectronico,String numeroLicencia,String paisExpedicion,String fechaVencimiento) {
		
		Reserva reserva = carga.getReserva(idReserva);
        carga.sobreEscribirConductorAdicional(idReserva, nombres,telefono,correoElectronico,numeroLicencia,paisExpedicion,fechaVencimiento);
        
        LicenciaConduccion licencia = new LicenciaConduccion(numeroLicencia, paisExpedicion, fechaVencimiento);

        ConductorAdicional conductorAdicional = new ConductorAdicional(nombres, telefono, correoElectronico, licencia);
        
        reserva.addConductor(conductorAdicional);
	}
	
	public void cambiarEstadoVehiculo(String sede, String estado, int idcategoria, String placa, String nEstado){
		
		Vehiculo vehiculo = carga.getVehiculo(sede, estado, idcategoria, placa);
		vehiculo.cambiarEstado(nEstado);
		carga.eliminarVehiculotxt(vehiculo);
		
		String color = vehiculo.getColor();
		String marca = vehiculo.getMarca();
		String modelo = vehiculo.getModelo();
		String anio = Integer.toString(vehiculo.getAnio());
		String transmision = vehiculo.getTransmicion();
		String gps = vehiculo.getGps();
		String vestado = vehiculo.getEstado();
		String capacidad = Integer.toString(vehiculo.getAnio());
		String categoria = vehiculo.getCategoria();
		String idCategoria = Integer.toString(idcategoria);
		
		carga.sobreEscribirVehiculo(placa,color,marca,modelo,anio,transmision,gps,nEstado,capacidad,categoria,idCategoria);
	}

}
