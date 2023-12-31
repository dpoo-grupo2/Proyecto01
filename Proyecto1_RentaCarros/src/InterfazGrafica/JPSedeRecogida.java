package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPSedeRecogida extends JPanel {
	
	private JLabel lblRelleno;
	private JPClienteReserva cS;
	
    public JPSedeRecogida(MenuCliente vent) 
    {
    
        setLayout(new GridLayout(6, 1, 0, 18));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 100, 160));
        
        JLabel labelSelect = new JLabel("Seleccione la sede donde desea recoger el vehiculo:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 26));
        
		add(labelSelect);

		lblRelleno = new JLabel(" ");
        add(lblRelleno);
		
        
		JButton btnNorte = new JButton("Sede norte");
		btnNorte.setFont(new Font("Arial", Font.BOLD, 20));
		btnNorte.setBackground(new Color(32, 182, 182));
		btnNorte.setForeground(Color.WHITE);
		btnNorte.setBorder(new LineBorder(Color.BLACK, 2));
		btnNorte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	cS= new JPClienteReserva(vent, "sedeNorte");
            	vent.nuevoCentro(cS);
            	
            }
        });
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
            	cS= new JPClienteReserva(vent, "sedeCentro");
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
            	cS= new JPClienteReserva(vent, "sedeSur");
            	vent.nuevoCentro(cS);
            }
        });
        add(btnSur);
        
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
