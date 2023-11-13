package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPEliminarVehiculo extends JPanel {

	private JLabel lblRelleno;

    public JPEliminarVehiculo(MenuAdminGnrl vent) 
    {
    	 
    	
        setLayout(new GridLayout(5, 1, 16, 20));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 110, 60, 110));
        
        JLabel labelSelect = new JLabel("Adicione todos los");
        labelSelect.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 26));
        add(labelSelect);

        JLabel labelSelect2 = new JLabel("datos del vehículo:");
        labelSelect2.setHorizontalAlignment(SwingConstants.LEFT);
        labelSelect2.setFont(new Font("Arial", Font.BOLD, 26));
        add(labelSelect2);
        
        addTextFieldWithHint("Sede ubicación");
        addTextFieldWithHint("Disponibilidad vehículo");
        addTextFieldWithHint("Matrícula");
        addTextFieldWithHint("Categoría vehpiculo");
        
        JButton btnSalir = new JButton("Regresar");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 18));
        btnSalir.setBackground(new Color(255, 144, 144));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorder(new LineBorder(Color.BLACK, 2));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	 
            	
            }
        });
        
        JPVehiculoEditado vH = new JPVehiculoEditado(vent);
        
        JButton btnSiguiente = new JButton("Eliminar");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 18));
        btnSiguiente.setBackground(new Color(32, 182, 182));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2));
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	vent.nuevoCentro(vH);
            	
            }
        });
        
        add(btnSalir);
        add(btnSiguiente);
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