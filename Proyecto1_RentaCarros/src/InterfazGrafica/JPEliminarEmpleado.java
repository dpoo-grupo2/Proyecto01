package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPEliminarEmpleado extends JPanel {

	private JLabel lblRelleno;
	private JLabel lblRelleno2;
	
    public JPEliminarEmpleado(MenuAdminSede vent) 
    {
    	 
    	
        setLayout(new GridLayout(6, 1, 0, 13));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 100, 160));
        
        JLabel labelLogin = new JLabel("Ingrese el login del usuario que desea eliminar:");
        labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
        labelLogin.setFont(new Font("Arial", Font.BOLD, 20));

        add(labelLogin);

        lblRelleno2 = new JLabel(" ");
        add(lblRelleno2);
        
        addTextFieldWithHint("Login empleado");
        
        lblRelleno = new JLabel(" ");
        add(lblRelleno);
        
        JPEmpleadoGestionado eG = new JPEmpleadoGestionado(vent);
        
        JButton btnSalir = new JButton("Regresar");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 19));
        btnSalir.setBackground(new Color(255, 144, 144));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorder(new LineBorder(Color.BLACK, 2));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	
            	
            }
        });
        
        
        JButton btnSiguiente = new JButton("Eliminar");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 19));
        btnSiguiente.setBackground(new Color(32, 182, 182));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2));
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	vent.nuevoCentro(eG); 
            	
            }
        });
        add(btnSiguiente);
        add(btnSalir);
        
    }

    private void addTextFieldWithHint(String hint) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setForeground(Color.GRAY);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setText(hint);
        textField.setBorder(new LineBorder(Color.BLACK, 2));
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

        add(textField);
    }
		        
    
}