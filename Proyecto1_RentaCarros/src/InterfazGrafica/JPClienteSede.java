package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyPair;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JPClienteSede extends JPanel {

	private JLabel lblRelleno;
	private Date fechaRecogida;
	private Date fechaEntrega;
	private Date horaRecogida;
	private Date horaEntrega;
	private MenuCliente vent;
	private String sede;

    public JPClienteSede(MenuCliente vent, String sede) 
    {
    	this.sede = sede;
    	this.vent = vent;
        setLayout(new GridLayout(7, 1, 0, 14));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 80, 160));
        
        JLabel labelSelect = new JLabel("Seleccione la categoría del vehículo:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 24));
        
		add(labelSelect);

		lblRelleno = new JLabel(" ");
        add(lblRelleno);
		
        JPReservaRegistrada rR = new JPReservaRegistrada(vent);
        
		JButton btnPequeño = new JButton("Pequeño");
		btnPequeño.setFont(new Font("Arial", Font.BOLD, 20));
		btnPequeño.setBackground(new Color(32, 182, 182));
		btnPequeño.setForeground(Color.WHITE);
		btnPequeño.setBorder(new LineBorder(Color.BLACK, 2));
		btnPequeño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    vent.nuevoCentro(rR);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        add(btnPequeño);
        
        
        JButton btnSedan= new JButton("Sedan");
        btnSedan.setFont(new Font("Arial", Font.BOLD, 20));
        btnSedan.setBackground(new Color(32, 182, 182));
        btnSedan.setForeground(Color.WHITE);
        btnSedan.setBorder(new LineBorder(Color.BLACK, 2));
        btnSedan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    vent.nuevoCentro(rR);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        add(btnSedan);
        
        
        JButton btnSUV = new JButton("SUV");
        btnSUV.setFont(new Font("Arial", Font.BOLD, 20));
        btnSUV.setBackground(new Color(32, 182, 182));
        btnSUV.setForeground(Color.WHITE);
        btnSUV.setBorder(new LineBorder(Color.BLACK, 2));
        btnSUV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    vent.nuevoCentro(rR);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        add(btnSUV);
        
        
        JButton btnLujo = new JButton("Lujo");
        btnLujo.setFont(new Font("Arial", Font.BOLD, 20));
        btnLujo.setBackground(new Color(32, 182, 182));
        btnLujo.setForeground(Color.WHITE);
        btnLujo.setBorder(new LineBorder(Color.BLACK, 2));
        btnLujo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    vent.nuevoCentro(rR);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        add(btnLujo);
        
        
        
        JButton btnAtras = new JButton("Regresar");
        btnAtras.setFont(new Font("Arial", Font.BOLD, 20));
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setBackground(new Color(255, 144, 144));
        btnAtras.setBorder(new LineBorder(Color.BLACK, 2));
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	ArrayList<JPanel>lst = vent.getPanelLst();
            	JPanel panel = lst.get(lst.size()-1);
            	vent.delElement(lst.size()-1);
            	
            	vent.nuevoCentroReg(panel);
            }
        });
        add(btnAtras);
		
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