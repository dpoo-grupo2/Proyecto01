package modelo;

import java.io.File;

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
	
	public void cambiarEstadoVehiculo(Vehiculo vehiculo,String nEstado){
		
		vehiculo.cambiarEstado(nEstado);
		File temp = carga.eliminarVehiculotxt(vehiculo);
		File bd = new File("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
		bd.delete();
		temp.renameTo(bd);
		
		String placa = vehiculo.getPlaca();
		String color = vehiculo.getColor();
		String marca = vehiculo.getMarca();
		String modelo = vehiculo.getModelo();
		String anio = Integer.toString(vehiculo.getAnio());
		String transmision = vehiculo.getTransmicion();
		String gps = vehiculo.getGps();
		String capacidad = Integer.toString(vehiculo.getAnio());
		String categoria = vehiculo.getCategoria();
		String idCategoria = Integer.toString(vehiculo.getIdCat());
		
		carga.sobreEscribirVehiculo(placa,color,marca,modelo,anio,transmision,gps,nEstado,capacidad,categoria,idCategoria);
	}

}
