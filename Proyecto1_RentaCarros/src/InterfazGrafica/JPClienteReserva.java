package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPClienteReserva extends JPanel {

    public JPClienteReserva() 
    {
    	 
    	
        setLayout(new GridLayout(5, 1, 0, 18));
        setBackground(new Color(200, 4, 182));
        setBorder(new EmptyBorder(70, 160, 150, 160));
        
        JLabel labelSelect = new JLabel("Seleccione su sede:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 30));
        
		add(labelSelect);

		JButton btnReserva = new JButton("Reservar vehículo");
        btnReserva.setFont(new Font("Arial", Font.BOLD, 20));
        btnReserva.setBackground(new Color(32, 182, 182));
        btnReserva.setForeground(Color.WHITE);
        btnReserva.setBorder(new LineBorder(Color.BLACK, 2));
        btnReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	
            	
            }
        });
        add(btnReserva);
		
    }
}