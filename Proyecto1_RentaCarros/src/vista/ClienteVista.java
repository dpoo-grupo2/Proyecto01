package vista;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Cliente;
import vista.Login;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.ConductorAdicional; 
import modelo.LicenciaConduccion;
import modelo.Reserva;
import modelo.Seguro;
import modelo.Usuario;
import modelo.Vehiculo;
import controlador.CargaDatos;

public class ClienteVista {
	private int opcion;
	private boolean centinela;
	private boolean centinela1;
	private boolean centinela2;
	private boolean centinela3;
	private boolean centinela4;
	private boolean centinela5;
	private boolean centinela6;
	private Cliente cliente = new Cliente(null, null, null, null, 0, null, null, null, null, null);
	private String sede;
	private String categoria;
	private String FechaRecibido;
	private String FechaEntrega;
	private String HoraRecibido;
	private String HoraEntrega;
	private CargaDatos cargaDatos = new CargaDatos();
	
	private Date FechaRecibido1;
	private Date FechaEntrega1;
	
	private boolean esNullVeh = false;
	
	public ClienteVista(){
		
	}
	
	public String input(String mensaje)
	{
	    try
	    {
	        System.out.print(mensaje + ": ");
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        return reader.readLine();
	    }
	    catch (IOException e)
	    {
	        System.out.println("Error leyendo de la consola");
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public void menu(String usuario) {
	    centinela = true;
	    cliente = (Cliente) cargaDatos.obtenerUsuarioCliente(usuario);
	    System.out.println(cliente.getNombreCompleto());
	    
	    while (centinela) {
	        System.out.println("\nBienvenido Cliente " + usuario + "\n");
	        System.out.println("1- Reservar vehículo");
	        System.out.println("2- Salir");

	        try {
	            opcion = Integer.parseInt(input("Ingrese su opción "));
	        } catch (Exception e) {
	            System.out.println("Recuerde que debe ingresar un número entre 1 y 2");
	        }

	        if (opcion == 1) {
	            
	            System.out.println("\nEn cual sede desea generar su reserva:\n");
	            System.out.println("1. Sede Norte");
	            System.out.println("2. Sede Centro");
	            System.out.println("3. Sede Sur");

	            int sedeOption;
	            try {
	                sedeOption = Integer.parseInt(input("Ingrese su opción para la sede "));
	            } catch (Exception e) {
	                System.out.println("Opción no válida.");
	                continue;  
	            }

	            if (sedeOption == 1) 
	            {
	                System.out.println("\nHa seleccionado la Sede Norte para su reserva.");
	                sede = "sedeNorte";
	                categoriaParaAlquilar(usuario);
	                System.out.println("\nReserva registrada exitosamente en el sistema...");
		            System.exit(0);
	            } 
	            
	            else if (sedeOption == 2) 
	            {
	                System.out.println("\nHa seleccionado la Sede Centro para su reserva.");
	                sede = "sedeCentro";
	                categoriaParaAlquilar(usuario);
	                
	                System.out.println("\nReserva registrada exitosamente en el sistema...");
		            System.exit(0);
	            } 
	            
	            else if (sedeOption == 3) 
	            {
	                System.out.println("\nHa seleccionado la Sede Sur para su reserva.");
	                sede = "sedeSur";
	                categoriaParaAlquilar(usuario);
	                System.out.println("\nReserva registrada exitosamente en el sistema...");
		            System.exit(0);
	            } 
	            
	            else 
	            {
	                System.out.println("Opción de sede no válida.");	                
	            }
	            
	           	                 
	        } 
	        
	        else if (2 == opcion) {
	            System.out.println("\nSaliendo del sistema...");
	            System.exit(0);
	        } 
	        
	        else 
	        {
	            System.out.println("Esa no es una opción válida.");
	        }
	    }
	}
	
	public void categoriaParaAlquilar(String usuario) 
	{
		int idCategoria = 0;
		Date horaEntrega = null;
		Date horaRecogida =null; 
		centinela = true;
	    while (centinela) {
	        
	        System.out.println("\nQue categoria de vehiculo desea alquilar:");
	        System.out.println("1. Pequenio");
            System.out.println("2. Sedan");
            System.out.println("3. SUV");
            System.out.println("4. Lujo");
            System.out.println("5- Menu Principal");
            System.out.println("5- salir");
	        try {
	            opcion = Integer.parseInt(input("Ingrese su opción "));
	            if (opcion == 1) 
		        {
		        	categoria = "Pequenio";
		        	idCategoria = opcion;
		        	Date fechaRecogida1 = fechaRecogida();
		        	Date fechaEntrega1 = fechaEntrega();
		        	Vehiculo valDispo =VerDisponibilidad(sede, idCategoria, fechaRecogida1, fechaEntrega1);
		        	if (valDispo == null) 
		        	{
		        		esNullVeh = true;
		        		valDispo.getPlaca();
		        	}
		        	esNullVeh = false;
		        	horaRecogida = HoraRecogida();
		        	horaEntrega = HoraEntrega();
		        	
		        	centinela = false;
		        }
		        
		        else if (opcion == 2) 
		        {
		        	categoria = "Sedan";
		        	idCategoria = opcion;
		        	Date fechaRecogida1 = fechaRecogida();
		        	Date fechaEntrega1 = fechaEntrega();
		        	Vehiculo valDispo =VerDisponibilidad(sede, idCategoria, fechaRecogida1, fechaEntrega1);
		        	if (valDispo == null) 
		        	{
		        		esNullVeh = true;
		        		valDispo.getPlaca();
		        	}
		        	esNullVeh = false;
		        	horaEntrega = HoraRecogida();
		        	horaEntrega = HoraEntrega();
		        	centinela = false;
		        }
		        
		        else if (opcion == 3) 
		        {
		        	categoria = "SUV";
		        	idCategoria = opcion;
		        	Date fechaRecogida1 = fechaRecogida();
		        	Date fechaEntrega1 = fechaEntrega();
		        	Vehiculo valDispo =VerDisponibilidad(sede, idCategoria, fechaRecogida1, fechaEntrega1);
		        	if (valDispo == null) 
		        	{
		        		esNullVeh = true;
		        		valDispo.getPlaca();
		        	}
		        	esNullVeh = false;
		        	HoraRecogida();
		        	HoraEntrega();
		        	centinela = false;
		        }
		        
		        else if (opcion == 4) 
		        {
		        	categoria = "Lujo";
		        	idCategoria = opcion;
		        	Date fechaRecogida1 = fechaRecogida();
		        	Date fechaEntrega1 = fechaEntrega();
		        	Vehiculo valDispo =VerDisponibilidad(sede, idCategoria, fechaRecogida1, fechaEntrega1);
		        	if (valDispo == null) 
		        	{
		        		esNullVeh = true;
		        		valDispo.getPlaca();
		        		
		        	}
		        	esNullVeh = false;
		        	HoraRecogida();
		        	HoraEntrega();
		        	seleccionarSeguros();
		        	centinela = false;
		        }
		        else if (opcion == 5) 
		        {
		        	System.out.println("Volviendo al menu principal...");
		        	menu(usuario);
		        }
		        else if (opcion == 6) 
		        {
		        	System.out.println("Saliendo de al aplicacion");
		        	System.exit(0);
		        }
		        else 
	            {

	                System.out.println("Opción de sede no válida.");	                
	            }
	            
	            
	        } 
	        catch (Exception e) 
	        {
	        	if (esNullVeh) 
	        	{
	        		System.out.println("No hay vehiculos disponibles en esa sede, de esa categoria para esa fecha");	
	        	}
	        	
	            System.out.println("Recuerde que debe ingresar un número entre 1 y 4");
	            menu(usuario);
	        }

	        
	    }
	    //generarReserva(false,sede);
	}
	private ArrayList<Seguro> seleccionarSeguros() {
		ArrayList<Seguro> lstSeguros = cargaDatos.getLstSeguro();
		ArrayList<Seguro> lstSeleccionados = new ArrayList<Seguro>();
		centinela = true;
		int e = 0;
		while(centinela) {
		System.out.println();
		System.out.println("Los seguros disponibles son:");
		for (int i = 0; i < lstSeguros.size(); i++) {
			Seguro el = lstSeguros.get(i);
			System.out.println((i+1)+") "+el);	
			e = i+1;
		}
		System.out.println((e+1)+") Elminiar un Seguro");
		System.out.println((e+2)+") Ninguno");
		System.out.println("");
		System.out.println("Ingrese el numero del seguro que desea adquirir (si desea adquirir mas luego se le volvera a preguntar)");
		int segr = Integer.parseInt(input("-> "));
		if (segr <= lstSeguros.size() && segr >0) 
		{
			lstSeleccionados.add(lstSeguros.get(segr-1));
			System.out.println("El seguro "+lstSeguros.get(segr)+ " fue añadido con exito");
		}
		else if(segr == e+1)
				{
			for (int i = 0; i < lstSeguros.size(); i++) {
				Seguro el = lstSeguros.get(i);
				System.out.println((i+1)+") "+el);	
				e = i+1;
			}
			System.out.println((e+1)+") Ninguno");
			System.out.println("Ingrese el numero de seguro el cual desea eliminar:");
			int opcion = Integer.parseInt(input("-> "));
			if (segr <= lstSeguros.size() && segr >0) 
			{
				lstSeleccionados.remove(lstSeleccionados.get(segr-1));
				System.out.println("El seguro "+lstSeguros.get(segr-1)+ " fue añadido con exito");
			}
				}
		else if (segr ==e+2) 
		{
			System.out.println("continuando proceso generar reserva...");
			return lstSeguros;
		}
		}
		return lstSeleccionados;
		
	}
	public long CalcularDias(Date fechaf,Date fechai) 
	{
		// Convierte las fechas en objetos Calendar
		        Calendar cal1 = Calendar.getInstance();
		        cal1.setTime(fechai);

		        Calendar cal2 = Calendar.getInstance();
		        cal2.setTime(fechaf);

		        // Calcula la diferencia en milisegundos
		        long diferenciaEnMilisegundos = cal2.getTimeInMillis() - cal1.getTimeInMillis();

		        // Convierte la diferencia en días
		        long diferenciaEnDias = diferenciaEnMilisegundos / (24 * 60 * 60 * 1000);

		        return diferenciaEnDias;
		    
	} 
	public Reserva generarReserva(boolean estadoTarjeta, String sedeEntrega, String sedeRecogida, java.util.Date fechaRecogida2, String horaRecogida,java.util.Date fechaEntrega2
			,String horaEntrega,ArrayList<Seguro> lstSeguros, Cliente clienteRes,int valorReserva,int dias,int idReserva,Vehiculo vehiculo) 
	{
		return null;
		
	}
	
	public Date fechaRecogida() {
	    centinela2 = true;
	    while (centinela2) {
	        FechaRecibido = input("\nDigite la fecha en la cual va a recoger el vehículo (DD/MM/AA)");
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	        dateFormat.setLenient(false);  
	        try {
	            Date fecha = dateFormat.parse(FechaRecibido);
	            
	            if (FechaRecibido.equals(dateFormat.format(fecha))) {
	                System.out.println("Fecha ingresada correctamente en el formato DD/MM/AA.");
	                centinela2 = false; 
	                return fecha;
	                
	            } else {
	                System.out.println("La fecha no es válida para el formato DD/MM/AA. Intente de nuevo.");
	            }
	        } catch (ParseException e) {
	            System.out.println("La fecha no está en el formato correcto (DD/MM/AA). Intente de nuevo.");
	        }
	    }
		return null;
	}
	
	public Date fechaEntrega() {
	    centinela3 = true;
	    while (centinela3) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
	        dateFormat.setLenient(false);

	        try {
	            
	            Date fechaRecogidaDate = dateFormat.parse(FechaRecibido);

	            
	            FechaEntrega = input("\nDigite la fecha en la cual va a entregar el vehículo (DD/MM/AA)");

	            Date fechaEntregaDate = dateFormat.parse(FechaEntrega);

	            if (fechaEntregaDate.after(fechaRecogidaDate)) {
	                System.out.println("Fecha de entrega válida.");
	                centinela3 = false;
	                return fechaEntregaDate;
	                
	            } else {
	                System.out.println("La fecha de entrega debe ser posterior a la fecha de recogida. Intente de nuevo.");
	            }
	        } catch (ParseException e) {
	            System.out.println("La fecha no está en el formato correcto (DD/MM/AA). Intente de nuevo.");
	        }
	    }
		return null;
	}
	
	public Vehiculo VerDisponibilidad(String sede, int categoria, Date fechaRecogida, Date fechaEntrega) 
	{
		
		return cliente.verDisponibilidad(sede, categoria, fechaRecogida, fechaEntrega);
		
	}
	
	public Date HoraRecogida() {
	    centinela4 = true;
	    Date hora = null;
	    while (centinela4) {
	        HoraRecibido = input("\nDigite la hora en la cual va a recoger el vehículo (HH:mm)");

	        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	        timeFormat.setLenient(false); 
	        try {
	            hora = timeFormat.parse(HoraRecibido);
	            
	            if (HoraRecibido.equals(timeFormat.format(hora))) {
	                System.out.println("Hora ingresada correctamente en el formato HH:mm.");
	                centinela4 = false;  
	            } else {
	                System.out.println("La hora no es válida para el formato HH:mm. Intente de nuevo.");
	            }
	        } catch (ParseException e) {
	            System.out.println("La hora no está en el formato correcto (HH:mm). Intente de nuevo.");
	        }
	    }
	    return hora;
	}

	public Date HoraEntrega() {
	    centinela5 = true;
	    Date hora =null;
	    while (centinela5) {
	        HoraEntrega = input("\nDigite la hora en la cual va a devolver el vehículo (HH:mm)");

	        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	        timeFormat.setLenient(false);  

	        try {
	            hora = timeFormat.parse(HoraEntrega);
	            
	            if (HoraEntrega.equals(timeFormat.format(hora))) {
	                System.out.println("Hora ingresada correctamente en el formato HH:mm.");
	                centinela5 = false;  
	            } else {
	                System.out.println("La hora no es válida para el formato HH:mm. Intente de nuevo.");
	            }
	        } catch (ParseException e) {
	            System.out.println("La hora no está en el formato correcto (HH:mm). Intente de nuevo.");
	        }
	    }
		return hora;
	}
}
