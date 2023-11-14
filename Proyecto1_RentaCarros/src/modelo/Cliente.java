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
	private LicenciaConduccion licencia;
	private MedioPago medioPago;
	private ArrayList<Reserva> lstReservas = new ArrayList<Reserva>();
	private CargaDatos carga = new CargaDatos();
	private HashMap<String,Sede> sedes = carga.getSedes();


	public Cliente(String login, String password, String nombreCompleto, int edad,String cedula,String fechaNacimiento, String correoElectronico, LicenciaConduccion licencia, MedioPago medioPago)
	{
		super(login, password, nombreCompleto,"Empleado");
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
	public Reserva crearReserva(boolean estadoTarjeta, String sedeEntrega, String sedeRecogida, Date fechaRecogida, String horaRecogida, Date fechaEntrega,String horaEntrega,Cliente cliente,ArrayList<Seguro> lstSeguro,int valorReserva,ArrayList<ConductorAdicional> lstConductores,int dias, String idReserva,Vehiculo vehiculo) 
	{
		System.out.println("esta dentro de cliente");
		Reserva reserva = new Reserva(estadoTarjeta, sedeEntrega, sedeRecogida, fechaRecogida, horaRecogida, fechaEntrega, horaEntrega, lstSeguro, cliente,valorReserva,dias,idReserva, vehiculo,lstConductores);
		añadirReserva(reserva);
		carga.sobreEscribirReserva(reserva);
		carga.addLstReserva(reserva);
		return reserva;
	}
	public void añadirReserva(Reserva reserva) 
	{
		lstReservas.add(reserva);
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

