package modelo;

import java.util.ArrayList;

import controlador.CargaDatos;

public class Empleado {

	private Reserva reserva;
	private CargaDatos carga;
	
	public void agregarConductorAdicional(String nombres,String telefono,String correoElectronico,String numeroLicencia,String paisExpedicion,String fechaVencimiento) {
		ArrayList<ConductorAdicional> conductoresAdicionales = new ArrayList<>();
		
		Vehiculo vehiculo = reserva.getvehiculo();
        String placa = vehiculo.getPlaca();
        carga.sobreEscribirAdicional(placa, nombres,telefono,correoElectronico,numeroLicencia,paisExpedicion,fechaVencimiento);
        
        LicenciaConduccion licencia = new LicenciaConduccion(numeroLicencia, paisExpedicion, fechaVencimiento);

        ConductorAdicional conductorAdicional = new ConductorAdicional(nombres, telefono, correoElectronico, licencia);

        conductoresAdicionales.add(conductorAdicional);
        
        reserva.addConductores(conductoresAdicionales);
	}

}
