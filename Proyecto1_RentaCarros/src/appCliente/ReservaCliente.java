package appCliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import InterfazGrafica.JPMedioPago;
import modelo.Cliente;

public class ReservaCliente extends JPanel{
	
	private String[] sedes = {"Seleccione una opcion","Sede Norte","Sede Centro", "Sede Sur"};
	private String[] tVehiculos = {"Seleccione una opcion","Pequeño","Sedan","SUV","Lujo","ATv","Moto","Bicicleta","Patineta"};
	private String[] mediosPago = {"Seleccione una opcion","Nequi","Daviplata","Efetivo","Tarjeta"};
	
	private JComboBox<String> sedeRecogida;
	private JComboBox<String> sedeEntrega;
	private JComboBox<String> vehiculos;
	private JComboBox<String> medios;
	
	private JLabel lblSedeR;
	private JLabel lblSedeE;
	private JLabel lblVehiculo;
	private JLabel lblMedioPago;
	
	private JButton btnFechas;
	private JButton btnHoras;
	private JButton btnSiguiente;
	private JButton btnSalir;
	
	private Date fechaRecogida;
	private Date fechaEntrega;
	private Date horaRecogida;
	private Date horaEntrega;
	
	private Cliente cliente;
	
	public ReservaCliente(MenuAppCliente vent) 
    {
    	 
        setLayout(new GridLayout(6, 2, 14, 24));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 100, 160));
        
        lblSedeR = new JLabel("Sede Recogida:");
        lblSedeR.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblSedeR);
        sedeRecogida = new JComboBox<>(sedes);
        sedeRecogida.setFont(new Font("Arial", Font.BOLD, 20));
		add(sedeRecogida);
        
        lblSedeE = new JLabel("Sede Entrega:");
        lblSedeE.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblSedeE);
        sedeEntrega = new JComboBox<>(sedes);
        sedeEntrega.setFont(new Font("Arial", Font.BOLD, 20));
        add(sedeEntrega);
        
        lblVehiculo = new JLabel("Tipo de Vehiculo:");
        lblVehiculo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblVehiculo);
        vehiculos = new JComboBox<>(tVehiculos);
        vehiculos.setFont(new Font("Arial", Font.BOLD, 20));
        add(vehiculos);
        
        lblMedioPago = new JLabel("Medio de Pago:");
        lblMedioPago.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblMedioPago);
        medios = new JComboBox<>(mediosPago);
        medios.setFont(new Font("Arial", Font.BOLD, 20));
        add(medios);
        
        btnFechas = new JButton("Ajustar Fechas");
        btnFechas.setFont(new Font("Arial", Font.BOLD, 20));
        btnFechas.setBackground(new Color(32, 182, 182));
		btnFechas.setForeground(Color.WHITE);
		btnFechas.setBorder(new LineBorder(Color.BLACK, 2));
        btnFechas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	fechaReserva();
                horaReserva();
            }
        });
        add(btnFechas);
        
        btnHoras = new JButton("Ajustar Horas");
        btnHoras.setFont(new Font("Arial", Font.BOLD, 20));
        btnHoras.setBackground(new Color(32, 182, 182));
		btnHoras.setForeground(Color.WHITE);
		btnHoras.setBorder(new LineBorder(Color.BLACK, 2));
        btnHoras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	fechaReserva();
                horaReserva();
            }
        });
        add(btnHoras);
        
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 20));
        btnSiguiente.setBackground(Color.GREEN);
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2));
		btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	String def = "Seleccione una opcion";
            	String sedeRe = (String) sedeRecogida.getSelectedItem();
            	String sedeEn = (String) sedeEntrega.getSelectedItem();
            	String vehiculo = (String) vehiculos.getSelectedItem();
            	String medio = (String) medios.getSelectedItem();
            	
            	if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null && !sedeRe.equals(def) && !sedeEn.equals(def) && !vehiculo.equals(def) && !medio.equals(def) ) {
                    setVisible(false);
                } else {         
                    JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                }
            }
        });
		add(btnSiguiente);
	
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.BOLD, 20));
		btnSalir.setBackground(Color.RED);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBorder(new LineBorder(Color.BLACK, 2));
		add(btnSalir);
    }
	
	public String[] fechaReserva()
    {
    	JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("Fecha de recogida (DD/MM/YYYY) : "));
        JTextField fechaRecogidaField = new JTextField();
        panel.add(fechaRecogidaField);

        panel.add(new JLabel("Fecha de entrega (DD/MM/YYYY) : "));
        JTextField fechaEntregaField = new JTextField();
        panel.add(fechaEntregaField);

        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Fechas de recogida y entrega", JOptionPane.OK_CANCEL_OPTION);

        
        if (opcion == JOptionPane.OK_OPTION) {
            
        	String fechaRecogidaStr = fechaRecogidaField.getText();
            String fechaEntregaStr = fechaEntregaField.getText();

        
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            try {
            	
                fechaRecogida = formatoFecha.parse(fechaRecogidaStr);
                fechaEntrega = formatoFecha.parse(fechaEntregaStr);
               
            } catch (ParseException e) 
            {
            	JOptionPane.showMessageDialog(null, "Error, debe llenar todos los campos y poner las fechas en formato (dd/MM/yyyy) ", "CarRental", JOptionPane.OK_CANCEL_OPTION);
            	fechaReserva();
            }
        } else {
        	
        }
        
        String fechaEntregaStr = null;
		String[] fechas = {fechaEntregaStr};
        return fechas;
    }
	
	public void horaReserva()
    {
    	JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("Hora de recogida (HH:mm):"));
        JTextField horaRecogidaField = new JTextField();
        panel.add(horaRecogidaField);

        panel.add(new JLabel("Hora de entrega (HH:mm):"));
        JTextField horaEntregaField = new JTextField();
        panel.add(horaEntregaField);

        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Horas de recogida y entrega", JOptionPane.OK_CANCEL_OPTION);

        
        if (opcion == JOptionPane.OK_OPTION) {
            
            String horaRecogidaStr = horaRecogidaField.getText();
            String horaEntregaStr = horaEntregaField.getText();

        
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
            try {
            	
                horaRecogida = formatoHora.parse(horaRecogidaStr);
                horaEntrega = formatoHora.parse(horaEntregaStr);

                                
            } catch (ParseException e) 
            {
            	JOptionPane.showMessageDialog(null, "Error, debe llenar todos los campos y poner las horas en formato (HH:MM)", "CarRental", JOptionPane.OK_CANCEL_OPTION);
            	horaReserva();
            }
        }else {
        	
        }
    
    }
	
}
