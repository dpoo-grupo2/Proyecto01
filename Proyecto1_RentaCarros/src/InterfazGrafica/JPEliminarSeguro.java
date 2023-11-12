package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import controlador.CargaDatos;
import modelo.Seguro;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
 

public class JPEliminarSeguro extends JPanel implements ActionListener{

	private JLabel lblRelleno;
	private CargaDatos cargaDatos = new CargaDatos();
//	private ArrayList <String> comboBoxOptions = new ArrayList <String>();
//	private JComboBox<String> lblComboBox;
//	private ArrayList<Seguro> seguros = CargaDatos.getLstSeguro();  
	
    public JPEliminarSeguro(MenuAdminGnrl vent) 
    {
    	 
    	
        setLayout(new GridLayout(7, 1, 0, 16));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 60, 160));
        
        JLabel labelSelect = new JLabel("Seleccione que seguro desea eliminar");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 22));

        add(labelSelect);

        lblRelleno = new JLabel(" ");
        add(lblRelleno); 
        
//        lblComboBox = new JComboBox<>(comboBoxOptions);
//        lblComboBox.addActionListener(this);
//        add(lblComboBox);
        
          
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) 
    {
        VentanaLogin ventana = new VentanaLogin();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);}
		        
    
}