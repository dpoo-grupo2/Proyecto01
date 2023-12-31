package InterfazGrafica;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import controlador.CargaDatos;
import modelo.InventarioVehiculo;
import modelo.Vehiculo;

public class MenuEmpleado extends JFrame 
{
	private JLabel lblRelleno;
	private JPanel panelCentro;
	private JPanel panelCentro2;
	private JPanel panelAnte;
	private ArrayList<JPanel> lstPanel = new ArrayList<JPanel>();
	private CargaDatos cargaDatos = new CargaDatos();
	
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
        panelAnte = panelCentro;
        add(panelCentro, BorderLayout.CENTER);
        
        panelCentro2 = panelCentro;
        
        JLabel labelIniciarSesion = new JLabel("¡Bienvenido Empleado!");
        labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        labelIniciarSesion.setFont(new Font("Arial", Font.BOLD, 30));
        panelCentro.add(labelIniciarSesion);
        lblRelleno = new JLabel(" ");
        panelCentro.add(lblRelleno);        
        
        
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
            	
            }
        });
        panelCentro.add(btnAgregar);

        
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
            	
            }
        });
        panelCentro.add(btnActualizar);
        
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
        ImageIcon imagen2 = new ImageIcon("Proyecto1_RentaCarros/data/Empleado (1).png");
        JLabel labelImagen2 = new JLabel(imagen2);
        panelOeste.add(labelImagen2);
        panelOeste.setPreferredSize(new Dimension(130, 10));
        labelImagen2.setPreferredSize(new Dimension());
        labelImagen2.setAlignmentY(BOTTOM_ALIGNMENT);
        panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.Y_AXIS));
        panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.X_AXIS));

    }
    
    public JPanel getPanelAnte() 
    {
    	return panelAnte;
    }
    
    public void agregarConductores() {
        JPRegistrarConductor jPRegistrarConductor = new JPRegistrarConductor(this);

        try {
            String id = JOptionPane.showInputDialog(this, "Digite el ID de la reserva a modificar: \n ", "CarRental", JOptionPane.INFORMATION_MESSAGE);

            if (id == null) {
                
                System.out.println("");
            } else if (id.equals("")) {
                JOptionPane.showMessageDialog(this, "El ID ingresado no coincide con ninguna reserva ", "CarRental", JOptionPane.ERROR_MESSAGE);
                agregarConductores();
            } else {
                nuevoCentro(jPRegistrarConductor);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public void actualizarEstado() {
  
        try {
            String id = JOptionPane.showInputDialog(this, "Digite la placa del vehículo a modificar: \n ", "CarRental", JOptionPane.INFORMATION_MESSAGE);

            if(id == null) {
            	JOptionPane.showMessageDialog(this, "Ha ocurrido un error, intente nuevamente", "CarRental", JOptionPane.ERROR_MESSAGE);
            }
            else if (id.equals("")) {
                JOptionPane.showMessageDialog(this, "La placa ingresada no coincide con ningún vehículo ", "CarRental", JOptionPane.ERROR_MESSAGE);
                agregarConductores();
            } else {
            	InventarioVehiculo inventario = cargaDatos.getInventario();
            	HashMap<String, Vehiculo> vehiculos = inventario.getVehiculos();
            	if (vehiculos.containsKey(id)) {
            		
            		Vehiculo vehiculo = vehiculos.get(id);
            		JPActualizarEstadoV jPActualizarEstadoV = new JPActualizarEstadoV(this, vehiculo);
            		nuevoCentro(jPActualizarEstadoV);
            	}
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    
    public void nuevoCentro(JPanel np) 
    {
    	lstPanel.add(panelCentro);
    	panelCentro.setVisible(false);
    	    	
        panelCentro = np;
        add(panelCentro, BorderLayout.CENTER);
        panelCentro.setVisible(true);
    }
    
    public JPanel getPanelCentro2()
    {
    	return panelCentro2;
    }
    
    public void setPanelCentro(JPanel gg)
    {
    	 panelCentro = gg;
    }
    
    public JPanel getPanelCentro()
    {
    	return panelCentro;
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