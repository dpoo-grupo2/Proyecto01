package appCliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Disponibilidad extends JPanel {

	private JLabel lblRelleno;
	
	
    public Disponibilidad(MenuAppCliente vent) 
    {
    	 
        setLayout(new GridLayout(6, 1, 0, 18));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 100, 160));
        
        JLabel labelSelect = new JLabel("Sobre que sede desea saber la disponibilidad:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 22));
        
		add(labelSelect);

		lblRelleno = new JLabel(" ");
        add(lblRelleno);
		
        
		JButton btnNorte = new JButton("Sede norte");
		btnNorte.setFont(new Font("Arial", Font.BOLD, 20));
		btnNorte.setBackground(new Color(32, 182, 182));
		btnNorte.setForeground(Color.WHITE);
		btnNorte.setBorder(new LineBorder(Color.BLACK, 2));
		btnNorte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	mostrarVentanaFecha("Sede Norte");
            	
            }
        });
        add(btnNorte);
        
        
        JButton btnCentro= new JButton("Sede centro");
        btnCentro.setFont(new Font("Arial", Font.BOLD, 20));
        btnCentro.setBackground(new Color(32, 182, 182));
        btnCentro.setForeground(Color.WHITE);
        btnCentro.setBorder(new LineBorder(Color.BLACK, 2));
        btnCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	mostrarVentanaFecha("Sede Centro");;
            }
        });
        add(btnCentro);
        
        
        JButton btnSur = new JButton("Sede sur");
        btnSur.setFont(new Font("Arial", Font.BOLD, 20));
        btnSur.setBackground(new Color(32, 182, 182));
        btnSur.setForeground(Color.WHITE);
        btnSur.setBorder(new LineBorder(Color.BLACK, 2));
        btnSur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	mostrarVentanaFecha("Sede Sur");
            }
        });
        add(btnSur);
        
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegresar.setBackground(new Color(255, 144, 144));
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBorder(new LineBorder(Color.BLACK, 2));
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	ArrayList<JPanel>lst = vent.getPanelLst();
            	JPanel panel = lst.get(lst.size()-1);
            	vent.delElement(lst.size()-1);
            	
            	vent.nuevoCentroReg(panel);
            }
        });        
        add(btnRegresar);
    }
    
    private void mostrarVentanaFecha(String sede) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            String fechaInicioStr = JOptionPane.showInputDialog(null, "Ingrese la fecha de inicio (dd/MM/yyyy):", "Rango de Fechas", JOptionPane.QUESTION_MESSAGE);
            String fechaFinStr = JOptionPane.showInputDialog(null, "Ingrese la fecha de fin (dd/MM/yyyy):", "Rango de Fechas", JOptionPane.QUESTION_MESSAGE);

            Date fechaInicio = dateFormat.parse(fechaInicioStr);
            Date fechaFin = dateFormat.parse(fechaFinStr);

            
            int cantidadDisponibles = VehiculosDisponibles(sede, fechaInicio, fechaFin);

            
            JOptionPane.showMessageDialog(null, "Cantidad de vehículos disponibles en " + sede + ": " + cantidadDisponibles, "Resultados", JOptionPane.INFORMATION_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato de fecha. Por favor, use el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int VehiculosDisponibles(String sede, Date fechaInicio, Date fechaFin) {
       
        return 7;
    }
    
}