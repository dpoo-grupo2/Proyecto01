package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPReservaRegistrada extends JPanel {

	private JLabel lblRelleno;
	
    public JPReservaRegistrada(MenuCliente vent) 
    {
    	 
        setLayout(new GridLayout(3, 1, 0, 30));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(100, 160, 140, 160));
        
        JLabel label = new JLabel("<html>¡Tu reserva a quedado/<br>exitosamente registrada!</html>");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        
		add(label);

		lblRelleno = new JLabel(" ");
        add(lblRelleno);
        
        
        JButton btnMenu = new JButton("Menú principal");
        btnMenu.setFont(new Font("Arial", Font.BOLD, 20));
        btnMenu.setBackground(new Color(32, 182, 182));
        btnMenu.setForeground(Color.WHITE);
        btnMenu.setBorder(new LineBorder(Color.BLACK, 2));
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {

            	
            }
        });
        add(btnMenu);
		
    }
    
    
}