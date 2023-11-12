package InterfazGrafica;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MenuEmpleado extends JFrame 
{
	private JLabel lblRelleno;
	private JPanel panelCentro;
	
    public MenuEmpleado() 
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
        add(panelCentro, BorderLayout.CENTER);
        
        JLabel labelIniciarSesion = new JLabel("¡Bienvenido Empleado!");
        labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        labelIniciarSesion.setFont(new Font("Arial", Font.BOLD, 30));
        panelCentro.add(labelIniciarSesion);
        lblRelleno = new JLabel(" ");
        panelCentro.add(lblRelleno);        
        
        JPRegistrarConductor jPRegistrarConductor = new JPRegistrarConductor(this);  
        
        JButton btnAgregar = new JButton("Registrar conductores adicionales");
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 20));
        btnAgregar.setBackground(new Color(32, 182, 182));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setBorder(new LineBorder(Color.BLACK, 2));
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	agregarConductores();
            	nuevoCentro(jPRegistrarConductor);
            }
        });
        panelCentro.add(btnAgregar);

        JPActualizarEstadoV jPActualizarEstadoV = new JPActualizarEstadoV(this);
        
        JButton btnActualizar = new JButton("Actualizar estado vehículo");
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 20));
        btnActualizar.setBackground(new Color(32, 182, 182));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setBorder(new LineBorder(Color.BLACK, 2));
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	actualizarEstado();
            	nuevoCentro(jPActualizarEstadoV);
            }
        });
        panelCentro.add(btnActualizar);
        
        JButton btnSalir = new JButton("Salir");
        btnSalir.setFont(new Font("Arial", Font.BOLD, 20));
        btnSalir.setBackground(new Color(32, 182, 182));
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
        ImageIcon imagen2 = new ImageIcon("Proyecto1_RentaCarros/data/Empleado (1).png");
        JLabel labelImagen2 = new JLabel(imagen2);
        panelOeste.add(labelImagen2);
        panelOeste.setPreferredSize(new Dimension(130, 10));
        labelImagen2.setPreferredSize(new Dimension());
        labelImagen2.setAlignmentY(BOTTOM_ALIGNMENT);
        panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.Y_AXIS));
        panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.X_AXIS));

    }
    
    
    public void agregarConductores()
	{
    	JOptionPane.showInputDialog(this, "Digite el ID de la reserva del vehículo que alquiló: \n ", "CarRental", JOptionPane.INFORMATION_MESSAGE);
	}
    
    public void actualizarEstado()
	{
    	JOptionPane.showInputDialog(this, "Digite el ID de la reserva del vehículo que alquiló: \n ", "CarRental", JOptionPane.INFORMATION_MESSAGE);
	}
    
    public void nuevoCentro(JPanel np) 
    {
    	panelCentro.setVisible(false);
        panelCentro = np;
        add(panelCentro, BorderLayout.CENTER);
        panelCentro.setVisible(true);
    }
}