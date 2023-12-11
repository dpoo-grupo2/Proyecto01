package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPClienteReserva extends JPanel {

	private JLabel lblRelleno;
	private JPClienteSede cS;

	private JComboBox<String> comboBoxEntrega;
	private JComboBox<String> comboBoxRecogida;
	
	private String[] comboBoxOptions = {"sede norte","sede sur","sede este"};
    public JPClienteReserva(MenuCliente vent) 
    {
    	 
        setLayout(new GridLayout(6, 1, 0, 18));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 100, 160));
        
        JLabel labelSelect = new JLabel("Seleccione la sede para resevar:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 26));
        
		add(labelSelect);

		lblRelleno = new JLabel(" ");
        add(lblRelleno);
        JPanel j = new JPanel(new GridLayout(1,2,16,20));
		j.setBackground(new Color(200, 182, 182));
		JLabel lbl1 = new JLabel("Sede entrega:");
        lbl1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl1.setFont(new Font("Arial", Font.BOLD, 26));
        
		JLabel lbl2 = new JLabel("Sede recogida:");
        lbl2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl2.setFont(new Font("Arial", Font.BOLD, 26));
        j.add(lbl1);
        j.add(lbl2);
        add(j);
		JPanel p = new JPanel(new GridLayout(1,2,16,20));
		p.setBackground(new Color(200, 182, 182));
		comboBoxEntrega = new JComboBox<>(comboBoxOptions);
		comboBoxEntrega.addActionListener(comboBoxEntrega);
		
		comboBoxRecogida = new JComboBox<>(comboBoxOptions);
		comboBoxRecogida.addActionListener(comboBoxRecogida);
		
		p.add(comboBoxEntrega);
		p.add(comboBoxRecogida);
		add(p);
        
		
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setFont(new Font("Arial", Font.BOLD, 20));
        btnSiguiente.setBackground(new Color(32, 182, 182));
        btnSiguiente.setForeground(Color.WHITE);
        btnSiguiente.setBorder(new LineBorder(Color.BLACK, 2));
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String sedeEntrega = (String) comboBoxEntrega.getSelectedItem();
                String sedeRecogida = (String) comboBoxRecogida.getSelectedItem();
                if(sedeEntrega.isEmpty() || sedeRecogida.isEmpty()) 
                {
                	vent.errorMensaje("Es necesario que elija una sede de entrega y recogida del vehiculo");;
                }
                else {
            	cS = new JPClienteSede(vent,sedeEntrega,sedeRecogida);
            	vent.nuevoCentro(cS);
                }
            }
        });
        add(btnSiguiente);
        
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegresar.setBackground(new Color(255, 144, 144));
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.setBorder(new LineBorder(Color.BLACK, 2));
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	ArrayList<JPanel>lst = vent.getPanelLst();
            	JPanel panel = lst.get(lst.size()-1);
            	vent.delElement(lst.size()-1);
            	
            	vent.nuevoCentroReg(panel);
            }
        });        
        add(btnRegresar);
    }
}