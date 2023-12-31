package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Vehiculo;

public class JPEliminarVehiculo extends JPanel {

	private JTextField txtFieldPlaca;
	
    public JPEliminarVehiculo(MenuAdminGnrl vent) 
    {
    	 
        setLayout(new GridLayout(3, 1, 16, 20));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 110, 60, 110));


        JLabel labelSelect = new JLabel("Adicione todos los datos del vehículo:");
        labelSelect.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 26));
       add(labelSelect);

       
        txtFieldPlaca =addTextFieldWithHint("Placa");
        add(txtFieldPlaca);
        
        
        JPanel p = new JPanel(new GridLayout(2,1,16, 20));
        p.setBackground(new Color(200, 182, 182));
        
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
            	if (vent.containsKey(txtFieldPlaca.getText())) 
            	{
                	vent.eliminarVehiculo(txtFieldPlaca.getText());
                	
                	vent.nuevoCentro(vH);
            	}
            	else 
            	{
            		errorMensaje("esa placa no existe, debe introducir una placa que funcione");
            	}

            	
            }
        });
        
        p.add(btnSalir);
        p.add(btnSiguiente);
        add(p);
    }
    private void errorMensaje(String mensaje) 
    {
    	JOptionPane.showMessageDialog(this, mensaje, "CarRental", JOptionPane.ERROR_MESSAGE);
    }
    private JTextField addTextFieldWithHint(String hint) {
    	JTextField textField= new JTextField();
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

        
        return textField;
    }

 public void elVehiculo(Vehiculo veh) 
 {
	 
 }
}