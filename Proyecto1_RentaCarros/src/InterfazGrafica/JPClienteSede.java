package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPClienteSede extends JPanel {

	private JLabel lblRelleno;
	
    public JPClienteSede(MenuCliente vent) 
    {
    	 
        setLayout(new GridLayout(7, 1, 0, 14));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 80, 160));
        
        JLabel labelSelect = new JLabel("Seleccione la categoría del vehículo:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 24));
        
		add(labelSelect);

		lblRelleno = new JLabel(" ");
        add(lblRelleno);
		
//        JPClienteReserva cR = new JPClienteReserva(vent);
        
		JButton btnPequeño = new JButton("Pequeño");
		btnPequeño.setFont(new Font("Arial", Font.BOLD, 20));
		btnPequeño.setBackground(new Color(32, 182, 182));
		btnPequeño.setForeground(Color.WHITE);
		btnPequeño.setBorder(new LineBorder(Color.BLACK, 2));
		btnPequeño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	
            	
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
            	
            	
            }
        });
        add(btnLujo);
        
        
        
        JButton btnAtras = new JButton("Regresar");
        btnAtras.setFont(new Font("Arial", Font.BOLD, 20));
        btnAtras.setBackground(new Color(32, 182, 182));
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setBorder(new LineBorder(Color.BLACK, 2));
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
//            	vent.nuevoCentro(cR);
            	
            }
        });
        add(btnAtras);
		
    }
    
    
}