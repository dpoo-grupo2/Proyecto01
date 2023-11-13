package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPClienteModificar extends JPanel {

    public JPClienteModificar(MenuCliente vent) 
    {
    	
        setLayout(new GridLayout(7, 1, 0, 14)); 
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 70, 160));

        JLabel labelSelect = new JLabel("¿Qué cambios desea hacerle a su reserva?");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 22));

        add(labelSelect);

        addTextFieldWithHint("Sede");
        addTextFieldWithHint("Fecha (DD/MM/AA)");
        addTextFieldWithHint("Categoria");
        addTextFieldWithHint("Hora");
        
        JButton btnSalir = new JButton("Regresar");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 20));
        btnSalir.setBackground(new Color(255, 144, 144));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorder(new LineBorder(Color.BLACK, 2));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	 
            	
            }
        });
        
        JPReservaRegistrada rR = new JPReservaRegistrada(vent);
        
        JButton btnModificar = new JButton("Modificar");
        btnModificar.setFont(new Font("Arial", Font.BOLD, 20));
        btnModificar.setBackground(new Color(32, 182, 182));
        btnModificar.setForeground(Color.WHITE);
        btnModificar.setBorder(new LineBorder(Color.BLACK, 2));
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	setVisible(false);
            	vent.nuevoCentro(rR); 
            	
            }
        });
        add(btnModificar);
        add(btnSalir);
        
        
    }

    private void addTextFieldWithHint(String hint) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 16));
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