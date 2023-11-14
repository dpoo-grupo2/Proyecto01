package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPRegistrarSeguro extends JPanel {

	private JLabel lblRelleno;
	
    public JPRegistrarSeguro(MenuAdminGnrl vent) 
    {
    	 
    	setLayout(new GridLayout(6, 1, 0, 16));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 90, 160));
        
        JLabel labelSelect = new JLabel("Llene los datos correspondientes al seguro:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 22));

        add(labelSelect);

        lblRelleno = new JLabel(" ");
        add(lblRelleno); 
        
        addTextFieldWithHint("Nombre seguro");
        addTextFieldWithHint("Valor seguro");
          
        JPSeguroEditado sH = new JPSeguroEditado(vent);
        
        JButton btnSalir = new JButton("Regresar");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 18));
        btnSalir.setBackground(new Color(255, 144, 144));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorder(new LineBorder(Color.BLACK, 2));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	JPanel ante = vent.getPanelAnte();
           	 	vent.nuevoCentro(ante);
            	
            }
        });
        
        
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 18));
        btnSiguiente.setBackground(new Color(32, 182, 182));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2));
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	vent.nuevoCentro(sH);
            	
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