package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPClienteReserva extends JPanel {

	private JLabel lblRelleno;
    public JPClienteReserva(MenuCliente vent) 
    {
    	 
    	
        setLayout(new GridLayout(5, 1, 0, 18));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 150, 160));
        
        JLabel labelSelect = new JLabel("Seleccione la sede para resevar:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 26));
        
		add(labelSelect);

		lblRelleno = new JLabel(" ");
        add(lblRelleno);
		
        final JPClienteSede jPClienteSede = new JPClienteSede();
        JPClienteSede cS = new JPClienteSede();
		JButton btnNorte = new JButton("Sede norte");
		btnNorte.setFont(new Font("Arial", Font.BOLD, 20));
		btnNorte.setBackground(new Color(32, 182, 182));
		btnNorte.setForeground(Color.WHITE);
		btnNorte.setBorder(new LineBorder(Color.BLACK, 2));
		btnNorte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	vent.nuevoCentro(cS);
            	
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
            	setVisible(false);
                add(jPClienteSede, BorderLayout.CENTER);
                setVisible(true);
                revalidate();
                repaint();
            	
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
            	remove(JPClienteReserva.this);
                add(jPClienteSede, BorderLayout.CENTER);
                revalidate();
                repaint();
            	
            }
        });
        add(btnSur);
        
		        
    }
}