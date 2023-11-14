package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Empleado;
import modelo.Vehiculo;

public class JPActualizarEstadoV extends JPanel {

	private JLabel lblRelleno;
	private JTextField txtEstado;
	private Empleado empleado = new Empleado();
	
    public JPActualizarEstadoV(MenuEmpleado vent, Vehiculo vehiculo) 
    {
    	 
    	
        setLayout(new GridLayout(5, 1, 0, 24));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 100, 160));
        
        JLabel labelSelect = new JLabel("Digite el nuevo estado del carro:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 24));

        add(labelSelect);

        lblRelleno = new JLabel(" ");
        add(lblRelleno); 
        
        addtxtEstadoWithHint("Nuevo estado");
        
          
        
        JButton btnSalir = new JButton("Regresar");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 20));
        btnSalir.setBackground(new Color(255, 144, 144));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorder(new LineBorder(Color.BLACK, 2));
        btnSalir.addActionListener(new ActionListener() {
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
        
        JPEstadoCambiado eC = new JPEstadoCambiado(vent);
        
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 20));
        btnSiguiente.setBackground(new Color(32, 182, 182));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2));
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
	    		String estado = txtEstado.getText();
	    		vehiculo.cambiarEstado(estado);
	    		empleado.cambiarEstadoVehiculo(vehiculo, estado);
	    		vent.nuevoCentro(eC); 
            	
            }
        });
        add(btnSiguiente);
        add(btnSalir);
        
    }

    private void addtxtEstadoWithHint(String hint) {
    	txtEstado = new JTextField();
        txtEstado.setFont(new Font("Arial", Font.BOLD, 20));
        txtEstado.setForeground(Color.GRAY);
        txtEstado.setHorizontalAlignment(SwingConstants.CENTER);
        txtEstado.setText(hint);
        txtEstado.setBorder(new LineBorder(Color.BLACK, 2));
        txtEstado.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtEstado.getText().equals(hint)) {
                    txtEstado.setText("");
                    txtEstado.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtEstado.getText().isEmpty()) {
                    txtEstado.setForeground(Color.GRAY);
                    txtEstado.setText(hint);
                }
            }
        });

        add(txtEstado);
    }
    
    
    
}