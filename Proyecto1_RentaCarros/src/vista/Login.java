package vista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controlador.CargaDatos;

public class Login {
	public static void main(String[] args)
    {
    	CargaDatos.cargarInformacionVehiculos("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
    	}
	
	public void inicioSesion() {
		System.out.println("-----------------Bienvenido a Car Rental-----------------");
    	System.out.println("1. Iniciar sesion");
    	System.out.println("2. Registrarse");
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
}
