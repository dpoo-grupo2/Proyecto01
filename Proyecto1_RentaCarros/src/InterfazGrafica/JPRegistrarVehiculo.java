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
	private JLabel lblRelleno2;
		
    public JPRegistrarVehiculo(MenuAdminGnrl vent) 
    {
    	 
    	
        setLayout(new GridLayout(6, 4, 10, 30));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 80, 60, 80));
        
        JLabel labelSelect = new JLabel("Adicione todos");
        labelSelect.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 25));
        add(labelSelect);
        
        JLabel labelSelect2 = new JLabel("los datos para el");
        labelSelect2.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect2.setFont(new Font("Arial", Font.BOLD, 25));
        add(labelSelect2);
        
        JLabel labelSelect3 = new JLabel("nuevo vehículo:");
        labelSelect3.setHorizontalAlignment(SwingConstants.LEFT);
        labelSelect3.setFont(new Font("Arial", Font.BOLD, 25));
        add(labelSelect3);
        
        
        

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
       
        lblRelleno = new JLabel(" ");
        add(lblRelleno);
        
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
        
        JButton btnSiguiente = new JButton("Registrar");
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
        lblRelleno2 = new JLabel(" ");
        add(lblRelleno2);
        add(btnSiguiente);
        
    }

    private void addTextFieldWithHint(String hint) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 18));
        textField.setForeground(Color.GRAY);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBorder(new LineBorder(Color.BLACK, 2));
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