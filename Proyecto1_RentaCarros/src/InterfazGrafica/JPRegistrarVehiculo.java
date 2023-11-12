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
	
    public JPRegistrarVehiculo() 
    {
    	 
    	
        setLayout(new GridLayout(4, 3, 10, 30));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 60, 160));
        
        JLabel labelSelect = new JLabel("Adicione todos los datos del vehículo:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 24));

        add(labelSelect);

        addTextFieldWithHint("Matrícula");
        addTextFieldWithHint("Modelo");
        addTextFieldWithHint("Sede");
        addTextFieldWithHint("Capacidad");
        addTextFieldWithHint("Color");
        addTextFieldWithHint("Año de fabricación");
        addTextFieldWithHint("Transmisión");
        addTextFieldWithHint("Categoría vehpiculo");
        addTextFieldWithHint("Marca");
        addTextFieldWithHint("Estado vehículo");
        addTextFieldWithHint("ID Categoría");
       
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 20));
        btnSalir.setBackground(new Color(32, 182, 182));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorder(new LineBorder(Color.BLACK, 2));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	 
            	
            }
        });
        
        
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 20));
        btnSiguiente.setBackground(new Color(32, 182, 182));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2));
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	
            	
            }
        });
        add(btnSiguiente);
        add(btnSalir);
        
    }

    private void addTextFieldWithHint(String hint) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setForeground(Color.GRAY);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
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

        add(textField);
    }
		        
    
}