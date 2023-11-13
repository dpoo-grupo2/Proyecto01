package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPRegistrarConductor extends JPanel {

	
    public JPRegistrarConductor(MenuEmpleado vent) 
    {
    	
        setLayout(new GridLayout(5, 1, 10, 20));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 100, 100, 100));
        
        JLabel labelSelect = new JLabel("Complete los datos del");
        labelSelect.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 22));

        add(labelSelect);

        JLabel labelSelect2 = new JLabel("conductor adicional:");
        labelSelect2.setHorizontalAlignment(SwingConstants.LEFT);
        labelSelect2.setFont(new Font("Arial", Font.BOLD, 22));

        add(labelSelect2);
        
        addTextFieldWithHint("Nombre");
        addTextFieldWithHint("No. de licencia");
        addTextFieldWithHint("Correo");
        addTextFieldWithHint("Fecha vencimiento");
        addTextFieldWithHint("Teléfono");
        addTextFieldWithHint("Pais licencia exp.");
         
                
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegresar.setBackground(new Color(255, 144, 144));
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBorder(new LineBorder(Color.BLACK, 2));
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	setVisible(false);
            	vent.setPanelCentro(vent.getPanelCentro2());
            	JPanel menu = vent.getPanelCentro();
            	vent.add(menu, BorderLayout.CENTER);
            	
            	menu.setVisible(true);
	            
            }
        });
        
        JPConductorAgregado cA = new JPConductorAgregado(vent);
        
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 18));
        btnSiguiente.setBackground(new Color(32, 182, 182));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2));
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	vent.nuevoCentro(cA); 
            	
            }
        });
        
        add(btnRegresar);
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