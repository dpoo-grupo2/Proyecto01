package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Cliente;

public class JPClienteReserva extends JPanel {
	
	private String sedeRecogida;
	private JLabel lblRelleno;
	private JPClienteSede cS;

	private JComboBox<String> comboBoxEntrega;
	private JComboBox<String> comboBoxRecogida;
	
<<<<<<< HEAD
    public JPClienteReserva(MenuCliente vent, String sedeR) 
=======
	private String[] comboBoxOptions = {"sedeNorte","sedeSur","sedeEste"};
    public JPClienteReserva(MenuCliente vent,Cliente cliente) 
>>>>>>> branch 'main' of https://github.com/dpoo-grupo2/Proyecto01.git
    {
    	sedeRecogida = sedeR;
        setLayout(new GridLayout(6, 1, 0, 18));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 100, 160));
        
        JLabel labelSelect = new JLabel("Seleccione la sede donde desea entregar el vehiculo:");
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
<<<<<<< HEAD
            	cS= new JPClienteSede(vent,sedeRecogida,"sedeNorte");
=======
                String sedeEntrega = (String) comboBoxEntrega.getSelectedItem();
                String sedeRecogida = (String) comboBoxRecogida.getSelectedItem();
                if(sedeEntrega.isEmpty() || sedeRecogida.isEmpty()) 
                {
                	vent.errorMensaje("Es necesario que elija una sede de entrega y recogida del vehiculo");;
                }
                else {
            	cS = new JPClienteSede(vent,sedeEntrega,sedeRecogida,cliente);
>>>>>>> branch 'main' of https://github.com/dpoo-grupo2/Proyecto01.git
            	vent.nuevoCentro(cS);
                }
            }
        });
<<<<<<< HEAD
        add(btnNorte);
        
        
        JButton btnCentro= new JButton("Sede centro");
        btnCentro.setFont(new Font("Arial", Font.BOLD, 20));
        btnCentro.setBackground(new Color(32, 182, 182));
        btnCentro.setForeground(Color.WHITE);
        btnCentro.setBorder(new LineBorder(Color.BLACK, 2));
        btnCentro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	cS= new JPClienteSede(vent,sedeRecogida,"sedeNorte");
            	vent.nuevoCentro(cS);
            }
        });
        add(btnCentro);
        
        
        JButton btnSur = new JButton("Sede sur");
        btnSur.setFont(new Font("Arial", Font.BOLD, 20));
        btnSur.setBackground(new Color(32, 182, 182));
        btnSur.setForeground(Color.WHITE);
        btnSur.setBorder(new LineBorder(Color.BLACK, 2));
        btnSur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	cS= new JPClienteSede(vent,sedeRecogida,"sedeNorte");
            	vent.nuevoCentro(cS);
            }
        });
        add(btnSur);
=======
        add(btnSiguiente);
>>>>>>> branch 'main' of https://github.com/dpoo-grupo2/Proyecto01.git
        
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