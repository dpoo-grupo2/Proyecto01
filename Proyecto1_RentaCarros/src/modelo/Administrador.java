package modelo;

import java.util.ArrayList;
import java.util.HashMap;

import controlador.CargaDatos;

public class Administrador 
{
private CategoriaVehiculo categoria;
private Vehiculo vehiculo;
private CargaDatos carga = new CargaDatos();
private ArrayList<Seguro> lstSeguroGrande = carga.getLstSeguro();

public Vehiculo registrarVehiculo(String placa,String color,String marca,String modelo, int anio, String transmicion, String gpsVehiculo, String estadoActual, int capacidadPersonas,
		String categoria,int idCategoria,HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> sedes) 
{
	vehiculo = new Vehiculo(placa,color,marca,modelo,anio,transmicion,gpsVehiculo,estadoActual,capacidadPersonas,categoria,idCategoria);
	addSede(vehiculo,sedes);
	return vehiculo;
}

private HashMap<Integer,CategoriaVehiculo> addVehiculoCat(HashMap<Integer,CategoriaVehiculo> categoria2, Vehiculo carro)
{
	ArrayList<Vehiculo> lstVehiculos = new ArrayList<Vehiculo>();
	if (!categoria2.containsKey(carro.getIdCat())) 
	{
		
		categoria = new CategoriaVehiculo(carro.getCategoria(), carro.getIdCat(),lstVehiculos , 0, 0, 0);
		categoria2.put(carro.getIdCat(), categoria);
	}
	CategoriaVehiculo cat = categoria2.get(carro.getIdCat());
	cat.añadirElemento(carro);
	return categoria2;
	
}

private HashMap<String,HashMap<Integer,CategoriaVehiculo>> addCategoriaDisponibilidad(HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad,Vehiculo vehiculo)
{
	if (!disponibilidad.containsKey(vehiculo.getEstado())) 
	{
		HashMap<Integer,CategoriaVehiculo> mapCat = new HashMap<Integer,CategoriaVehiculo>(); 
		disponibilidad.put(vehiculo.getEstado(),mapCat);
	}
	HashMap<Integer,CategoriaVehiculo> map2 = disponibilidad.get(vehiculo.getEstado());
	addVehiculoCat(map2,vehiculo);
	
	return disponibilidad;	
}

private HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> addSede(Vehiculo vehiculo,HashMap<String,HashMap<String,HashMap<Integer,CategoriaVehiculo>>> sedes)
{
	
	if (!sedes.containsKey(vehiculo.getGps())) 
	{
		HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad = new HashMap<String,HashMap<Integer,CategoriaVehiculo>>();
		sedes.put(vehiculo.getGps(),disponibilidad);
	}
	HashMap<String,HashMap<Integer,CategoriaVehiculo>> disponibilidad2 = sedes.get(vehiculo.getGps());
	addCategoriaDisponibilidad(disponibilidad2,vehiculo);
	
	return sedes;
	
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
	lstSeguroGrande.add(nuevoSeguro);
	carga.settteLstSeguros(lstSeguroGrande);
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
int pos = lstSeguroGrande.size()+1;
for (int i = 0; i < lstSeguroGrande.size(); i++) {
	if (lstSeguroGrande.get(i).getNombreSeguro().equals(nombreSeguro))
	{
	pos = i;
	break;
	}
	
}
lstSeguroGrande.remove(pos);
carga.settteLstSeguros(lstSeguroGrande);
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
for (int i = 0; i < lstSeguroGrande.size(); i++) {
	if (lstSeguroGrande.get(i).getNombreSeguro().equals(nombreSeguro))
	{
	obj = lstSeguroGrande.get(i);
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
}