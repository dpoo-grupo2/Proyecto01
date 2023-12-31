package InterfazGrafica;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MenuAdminSede extends JFrame 
{
	private JLabel lblRelleno;
	private JPanel panelCentro;
	private JPanel panelAnte;
	private ArrayList<JPanel> lstPanel = new ArrayList<JPanel>();
	
    public MenuAdminSede() 
    {
    	
        setSize(1050, 650);
        setTitle("CarRental");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

                
        JPanel panelNorte = new JPanel();
        panelNorte.setBackground(new Color(152, 182, 182));
        add(panelNorte, BorderLayout.NORTH);
        JLabel labelTitulo = new JLabel("CAR RENTAL");
        labelTitulo.setForeground(Color.BLACK);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        panelNorte.add(labelTitulo);
        panelNorte.setBorder(new MatteBorder(0, 0, 6, 0, Color.BLACK));

        
        
        panelCentro = new JPanel(new GridLayout(5, 1, 0, 18));
        panelCentro.setBackground(new Color(200, 182, 182));
        panelCentro.setBorder(new EmptyBorder(70, 160, 150, 160));
        panelAnte = panelCentro;
        add(panelCentro, BorderLayout.CENTER);
        
        JLabel labelIniciarSesion = new JLabel("¡Bienvenido Adminsitrador local! ");
        labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        labelIniciarSesion.setFont(new Font("Arial", Font.BOLD, 25));
        panelCentro.add(labelIniciarSesion);
        lblRelleno = new JLabel(" ");
        panelCentro.add(lblRelleno);        
        
        JPAgregarEmpleado jPAgregarEmpleado = new JPAgregarEmpleado(this);
        JPEliminarEmpleado jPEliminarEmpleado = new JPEliminarEmpleado(this);
        
        JButton btnReserva = new JButton("Crear empleado");
        btnReserva.setFont(new Font("Arial", Font.BOLD, 20));
        btnReserva.setBackground(new Color(32, 182, 182));
        btnReserva.setForeground(Color.WHITE);
        btnReserva.setBorder(new LineBorder(Color.BLACK, 2));
        btnReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	nuevoCentro(jPAgregarEmpleado);
            	
            }
        });
        panelCentro.add(btnReserva);

        JButton btnModificar = new JButton("Eliminar empleado");
        btnModificar.setFont(new Font("Arial", Font.BOLD, 20));
        btnModificar.setBackground(new Color(32, 182, 182));
        btnModificar.setForeground(Color.WHITE);
        btnModificar.setBorder(new LineBorder(Color.BLACK, 2));
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	nuevoCentro(jPEliminarEmpleado);
            	
            }
        });
        
                    
        panelCentro.add(btnModificar);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 20));
        btnSalir.setBackground(new Color(255, 144, 144));
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setBorder(new LineBorder(Color.BLACK, 2));
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	VentanaLogin VentanaLogin = new VentanaLogin();
            	VentanaLogin.setLocationRelativeTo(null);
            	VentanaLogin.setVisible(true);
                dispose(); 
            	
            }
        });
        panelCentro.add(btnSalir);
        
        
        JPanel panelEste = new JPanel();
        add(panelEste, BorderLayout.EAST);
        panelEste.setBackground(new Color(200, 182, 182));
        ImageIcon imagen = new ImageIcon("Proyecto1_RentaCarros/data/Logo.png");
        JLabel labelImagen = new JLabel(imagen);
        panelEste.add(labelImagen);
        panelEste.setPreferredSize(new Dimension(130, 10));
        labelImagen.setPreferredSize(new Dimension());
        labelImagen.setAlignmentY(BOTTOM_ALIGNMENT);
        panelEste.setLayout(new BoxLayout(panelEste, BoxLayout.Y_AXIS));
        panelEste.setLayout(new BoxLayout(panelEste, BoxLayout.X_AXIS));
        
        
        
        JPanel panelOeste = new JPanel();
        add(panelOeste, BorderLayout.WEST);
        panelOeste.setBackground(new Color(200, 182, 182));
        ImageIcon imagen2 = new ImageIcon("Proyecto1_RentaCarros/data/Admin.png");
        JLabel labelImagen2 = new JLabel(imagen2);
        panelOeste.add(labelImagen2);
        panelOeste.setPreferredSize(new Dimension(130, 10));
        labelImagen2.setPreferredSize(new Dimension());
        labelImagen2.setAlignmentY(BOTTOM_ALIGNMENT);
        panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.Y_AXIS));
        panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.X_AXIS));

    }  
    
    public void nuevoCentro(JPanel np) 
    {
    	lstPanel.add(panelCentro);
    	panelCentro.setVisible(false);
    	    	
        panelCentro = np;
        add(panelCentro, BorderLayout.CENTER);
        panelCentro.setVisible(true);
    }
    
    public JPanel getPanelAnte() 
    {
    	return panelAnte;
    }
    
    public void nuevoCentroReg(JPanel np) 
    {
    	panelCentro.setVisible(false);

        panelCentro = np;
        add(panelCentro, BorderLayout.CENTER);
        panelCentro.setVisible(true);
    }
    
    
    public ArrayList<JPanel> getPanelLst()
    {
    	return lstPanel;
    }
    
    public void reiniciarLstPanel() 
    {
    	lstPanel = new ArrayList<JPanel>();
    }
    
    public void delElement(int i) 
    {
    	lstPanel.remove(i);
    	
    }
    
}