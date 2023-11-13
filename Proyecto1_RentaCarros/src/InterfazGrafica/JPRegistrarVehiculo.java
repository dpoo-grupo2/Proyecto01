package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPRegistrarVehiculo extends JPanel {

	private JLabel lblRelleno;
	private JLabel lblRelleno2;
	private MenuAdminGnrl vent;
	private JTextField txtFMatricula;
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
	private String matricula = "";
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
    
    public JPRegistrarVehiculo(MenuAdminGnrl vent) 
    {
    	
    	this.vent = vent;
    	
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
        
                
        addTextFieldWithHint("Matrícula",txtFMatricula);
        addTextFieldWithHint("Modelo",txtFModelo);
        addTextFieldWithHint("Sede",txtFSede);
        addTextFieldWithHint("Capacidad",txtFCapacidad);
        addTextFieldWithHint("Color",txtFColor);
        addTextFieldWithHint("Año de fabricación",txtFAnio);
        addTextFieldWithHint("Transmisión",txtFTrans);
        addTextFieldWithHint("Categoría vehiculo",txtFCategoria);
        addTextFieldWithHint("Marca",txtFMarca);
        addTextFieldWithHint("Estado vehículo",txtFEstado);
        addTextFieldWithHint("ID Categoría",txtFId);
        addTextFieldWithHint("Placa",txtFPlaca);
        
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
                matricula = txtFMatricula.getText();
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
				placa = txtFPlaca.getText();
               if(revAll()){
               
//            	vent.añadirVeh(matricula,modelo,sede,capacidad,color,anioFab,transmicion,catVehiculo,marca,estadoVehiculo,idCat);
            	vent.nuevoCentro(vH);
            	}
            	else
            	{
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

	
	if (matricula.equals("") || modelo.equals("")||sede.equals("")||capacidad.equals("")||color.equals("")||anioFab.equals("")
	||transmicion.equals("") || catVehiculo.equals("")|| marca.equals("")|| estadoVehiculo.equals("")||idCat.equals(""))
	{
	return false;
	}
	else
	{
	return true;
	}
	}
	private void errorMensaje(String mensaje) 
    {
    	JOptionPane.showMessageDialog(this, mensaje, "CarRental", JOptionPane.ERROR_MESSAGE);
    }
    private void addTextFieldWithHint(String hint,JTextField textField) {
        JTextField txt= new JTextField();
        txt.setFont(new Font("Arial", Font.BOLD, 18));
        txt.setForeground(Color.GRAY);
        txt.setHorizontalAlignment(SwingConstants.CENTER);
        txt.setBorder(new LineBorder(Color.BLACK, 2));
        txt.setText(hint);
        txt.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txt.getText().equals(hint)) {
                    txt.setText("");
                    txt.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txt.getText().isEmpty()) {
                    txt.setForeground(Color.GRAY);
                    txt.setText(hint);
                }
            }
        });
		textField = txt;
        add(txt);
    }
	
    
    
}