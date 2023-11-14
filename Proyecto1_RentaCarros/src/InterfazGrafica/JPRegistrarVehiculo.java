package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Administrador;

public class JPRegistrarVehiculo extends JPanel {

	private JLabel lblRelleno;
	private JLabel lblRelleno2;
	private MenuAdminGnrl vent;
	private JTextField txtFModelo;
	private JTextField txtFSede;
	private JTextField txtFCapacidad;
	private JTextField txtFColor;
	private JTextField txtFAnio;
	private JTextField txtFTrans;
	private JTextField txtFCategoria;
	private JTextField txtFMarca;
	private JTextField txtFEstado;
	private JTextField txtFId;
	private JTextField txtFPlaca;
	private String modelo = "";
	private String sede = "";
	private String capacidad = "";
	private String color = "";
	private String anioFab="";
	private String transmicion = "";
	private String catVehiculo = "";
	private String marca = "";
	private String estadoVehiculo = "";
	private String idCat = "";
    private String placa = "";
    private Administrador admin;
    public JPRegistrarVehiculo(MenuAdminGnrl vent) 
    {
    	
    	this.vent = vent;
    	admin = vent.getUser();
    	
        setLayout(new GridLayout(6, 4, 10, 30));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 80, 60, 80));
        
        JLabel labelSelect = new JLabel("Adicione todos");
        labelSelect.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 25));
        add(labelSelect);
        
        JLabel labelSelect2 = new JLabel("los datos para el");
        labelSelect2.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect2.setFont(new Font("Arial", Font.BOLD, 25));
        add(labelSelect2);
        
        JLabel labelSelect3 = new JLabel("nuevo vehículo:");
        labelSelect3.setHorizontalAlignment(SwingConstants.LEFT);
        labelSelect3.setFont(new Font("Arial", Font.BOLD, 25));
        add(labelSelect3);
        

        txtFPlaca = addTextFieldWithHint("Placa");
        add(txtFPlaca);
       	txtFModelo = addTextFieldWithHint("Modelo");
        add(txtFModelo);
       	txtFSede = addTextFieldWithHint("Sede");
        add(txtFSede);
        txtFCapacidad= addTextFieldWithHint("Capacidad");
        add(txtFCapacidad);
        txtFColor = addTextFieldWithHint("Color");
        add(txtFColor);
        txtFAnio = addTextFieldWithHint("Año de fabricación");
        add(txtFAnio);
        txtFTrans = addTextFieldWithHint("Transmicion");
        add(txtFTrans);
        txtFCategoria = addTextFieldWithHint("Categoría vehiculo");
        add(txtFCategoria);
        txtFMarca = addTextFieldWithHint("Marca");
        add(txtFMarca);
        txtFEstado = addTextFieldWithHint("Estado vehículo");
        add(txtFEstado);
        txtFId = addTextFieldWithHint("ID Categoría");
        add(txtFId);
        
        JButton btnSalir = new JButton("Regresar");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 18));
        btnSalir.setBackground(new Color(255, 144, 144));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorder(new LineBorder(Color.BLACK, 2));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	 JPanel ante = vent.getPanelAnte();
            	 vent.nuevoCentro(ante);
            	
            }
        });
        
        JPVehiculoEditado vH = new JPVehiculoEditado(vent);
        
        JButton btnSiguiente = new JButton("Registrar");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 18));
        btnSiguiente.setBackground(new Color(32, 182, 182));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2));
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                placa = txtFPlaca.getText();
               	modelo = txtFModelo.getText();
               	sede = txtFSede.getText();
				capacidad = txtFCapacidad.getText();
				color = txtFColor.getText();
				anioFab=txtFAnio.getText();
				transmicion = txtFTrans.getText();
				catVehiculo = txtFCategoria.getText();
				marca = txtFMarca.getText();
				estadoVehiculo = txtFEstado.getText();
				idCat = txtFId.getText();
				System.out.println(placa);
				String error = "";
               if(revAll()){
            	   try {
            		   error = "Recuerde que el id categoria debe ser un numero entre 1 y 4";
               Integer.parseInt(idCat);
               if (Integer.parseInt(idCat) <1 || Integer.parseInt(idCat)>4) 
               {
            	   Integer.parseInt("tu");
               }
            	error = "Recuerde que la capacidad debe ser un numero entre 2 y 7";
            	Integer.parseInt(capacidad);
                if (Integer.parseInt(capacidad) <2 || Integer.parseInt(capacidad)>7) 
                {
             	   Integer.parseInt("tu");
                }
               error = "Recuerde que el año de fabricación debe ser un numero de 4 cifras como 2005";
           	Integer.parseInt(anioFab);
           	if (Integer.parseInt(anioFab)<1900) 
           	{
          	   Integer.parseInt("tu");

           	}
           	error = "Recuerde que el estado del vehiculo debe ser mantenimiento, disponible, limpieza o alquilado";
           	System.out.println(estadoVehiculo.equals("disponible"));
           	if (estadoVehiculo.equals("mantenimiento") || estadoVehiculo.equals("disponible")||estadoVehiculo.equals("limpieza")||estadoVehiculo.equals("alquilado"))
           	{
               	Integer.parseInt(anioFab);
               	System.out.println("pero entra  bobo");
           	}
           	else 
           	{
           		Integer.parseInt("tu");
           	}
           	error = "hubo un error, revis que los datos esten bien";
           		if (vent.containsKey(placa))Integer.parseInt(anioFab);
           		else 
           		{
           			error = "esa placa ya existe y no pueden haber 2 vehiculos con la misma placa";
           		}
           		
            	admin.registrarVehiculo(placa, color, marca, modelo,Integer.parseInt(anioFab), transmicion, sede, estadoVehiculo, Integer.parseInt(capacidad),
            			catVehiculo, Integer.parseInt(idCat));
            	vent.nuevoCentro(vH);
            	   }
               catch(Exception e1) 
               {
            	   errorMensaje(error);
               }}
            	else
            	{
            		System.out.println();
            	errorMensaje("Recuerde que debe poner todos los datos");
            	}
            	
            }
        });
        add(btnSalir);
        lblRelleno2 = new JLabel(" ");
        add(lblRelleno2);
        add(btnSiguiente);
        
    }
	private boolean revAll()
	{

	
	if (placa.equals("Placa") || modelo.equals("Modelo")||sede.equals("Sede")||capacidad.equals("Capacidad")||color.equals("Color")||
			anioFab.equals("Año de Fabricacin")||transmicion.equals("Transmicion") || catVehiculo.equals("Categoría Vehiculo")|| 
			marca.equals("Marca")|| estadoVehiculo.equals("Estado vehículo")||idCat.equals("ID Categoria"))
	{
		System.out.println("entra?");
	return false;
	}
	else
	{
		System.out.println("pero no llene todo xd");
		System.out.println(transmicion);
	return true;
	}
	}
	private void errorMensaje(String mensaje) 
    {
    	JOptionPane.showMessageDialog(this, mensaje, "CarRental", JOptionPane.ERROR_MESSAGE);
    }
    private JTextField addTextFieldWithHint(String hint) {
    	JTextField textField= new JTextField();
    	textField.setFont(new Font("Arial", Font.BOLD, 18));
    	textField.setForeground(Color.GRAY);
    	textField.setHorizontalAlignment(SwingConstants.CENTER);
    	textField.setBorder(new LineBorder(Color.BLACK, 2));
    	textField.setText(hint);
    	textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(hint)) {
                	textField.setText("");
                	textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                	textField.setForeground(Color.GRAY);
                	textField.setText(hint);
                }
            }
        });

        
        return textField;
    }
	
}
        