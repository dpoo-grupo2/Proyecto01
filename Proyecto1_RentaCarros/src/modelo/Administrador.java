package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import InterfazGrafica.MenuAdminGnrl;
import controlador.CargaDatos;

public class Administrador 
{
private CategoriaVehiculo categoria;
private Vehiculo vehiculo;
private ArrayList<Seguro> lstSeguro;
private MenuAdminGnrl interfaz;
public Vehiculo registrarVehiculo(String placa,String color,String marca,String modelo, int anio, String transmicion, String gpsVehiculo, String estadoActual, int capacidadPersonas,
		String categoria,int idCategoria) 
{
	vehiculo = new Vehiculo(placa,color,marca,modelo,anio,transmicion,gpsVehiculo,estadoActual,capacidadPersonas,categoria,idCategoria);
	System.out.println("el veh se crea bien");
	interfaz.añadirVeh(placa, modelo, gpsVehiculo,capacidadPersonas,color, anio, transmicion, categoria, marca, estadoActual, idCategoria,vehiculo);

	return vehiculo;
}

public Vehiculo eliminarVehiculo(HashMap<String,Sede> sedes,String sede,String placa,String disponibilidad,int idCategoria)
{
	try{
		Sede psede = sedes.get(sede);
		HashMap<String,HashMap<Integer,CategoriaVehiculo>> dispon = psede.getMapEstadoVehiculo();
		HashMap<Integer,CategoriaVehiculo> mapCategoria = dispon.get(disponibilidad);
		CategoriaVehiculo categoria = mapCategoria.get(idCategoria);
		ArrayList<Vehiculo> lstVehiculos = categoria.getLst();
		int pos = 0;
		for (int i = 0; i < lstVehiculos.size(); i++) {
			if (lstVehiculos.get(i).getPlaca().equals(placa))
			{
			pos = i;
			break;
			}
		}
		if (!lstVehiculos.get(pos).getPlaca().equals(placa))
		{
		return null;
		}
		else
		{
			Vehiculo vehiculo= lstVehiculos.get(pos);
			lstVehiculos.remove(pos);
			return vehiculo;
		}
	}
	catch(Exception e)
	{
		return null;
	}
}

public boolean añadirElementSeguros(Seguro nuevoSeguro)
{
try{
	interfaz.añadirSeguro(nuevoSeguro);
	return true;
	}
catch(Exception e)
{
return false;
}
}
public boolean eliminarSeguro(String nombreSeguro)
{
try{
int pos = lstSeguro.size()+1;
for (int i = 0; i < lstSeguro.size(); i++) {
	if (lstSeguro.get(i).getNombreSeguro().equals(nombreSeguro))
	{
	pos = i;
	break;
	}
	
}
lstSeguro.remove(pos);
interfaz.setLstSeguro(lstSeguro);

File temp = interfaz.eliminarSegurostxt(nombreSeguro);
File bd = new File("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
bd.delete();
temp.renameTo(bd);
return true;
}
catch(Exception e)
{
return false;
}

}
public Seguro modificarInfo(String nombreSeguro,String opcion,String nuevoValor)
{
Seguro obj = null;
for (int i = 0; i < lstSeguro.size(); i++) {
	if (lstSeguro.get(i).getNombreSeguro().equals(nombreSeguro))
	{
	obj = lstSeguro.get(i);
	}
}
if (opcion.equals("nombre"))
{
obj.modNombre(nuevoValor);
	return obj;
}
else if (opcion.equals("valor"))
{
obj.modValor(Integer.parseInt(nuevoValor));
return obj;
}
else
{
return null;
}


}
public void setLstSeguro(ArrayList<Seguro>lst) 
{
lstSeguro = lst;	
}
public void setInterfaz(MenuAdminGnrl interfaz ) {
	this.interfaz = interfaz;
}
}