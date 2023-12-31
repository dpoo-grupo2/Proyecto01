package InterfazGrafica;

import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import controlador.CargaDatos;
import modelo.Administrador;
import modelo.InventarioVehiculo;
import modelo.Sede;
import modelo.Seguro;
import modelo.Usuario;
import modelo.Vehiculo;

public class MenuAdminGnrl extends JFrame 
{
	private JLabel lblRelleno;
	private JPanel panelCentro;
	private CargaDatos carga;
	private JPanel panelAnte;
	private ArrayList<JPanel> lstPanel = new ArrayList<JPanel>();
	private HashMap<String,Sede> sedes = new HashMap<String,Sede>();
	private Administrador user;
	private InventarioVehiculo inv;
    public MenuAdminGnrl(Administrador user) 
    {
    	cargar();

    	this.user = user;
    	user.setInterfaz(this);
    	sedes = carga.getSedes();
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
        
        JLabel labelIniciarSesion = new JLabel("¡Bienvenido Adminsitrador general! ");
        labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        labelIniciarSesion.setFont(new Font("Arial", Font.BOLD, 25));
        panelCentro.add(labelIniciarSesion);
        lblRelleno = new JLabel(" ");
        panelCentro.add(lblRelleno);        
        
                  
        JButton btnGestionar = new JButton("Gestionar vehículos");
        btnGestionar.setFont(new Font("Arial", Font.BOLD, 20));
        btnGestionar.setBackground(new Color(32, 182, 182));
        btnGestionar.setForeground(Color.WHITE);
        btnGestionar.setBorder(new LineBorder(Color.BLACK, 2));
        btnGestionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	gestionarVehiculos();
            	                
            }
        });
        panelCentro.add(btnGestionar);

        JButton btnModificar = new JButton("Gestionar seguros");
        btnModificar.setFont(new Font("Arial", Font.BOLD, 20));
        btnModificar.setBackground(new Color(32, 182, 182));
        btnModificar.setForeground(Color.WHITE);
        btnModificar.setBorder(new LineBorder(Color.BLACK, 2));
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	panelAnte = panelCentro;
            	gestionarSeguros();
            	
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
    public boolean containsKey(String key) 
    {
    	return inv.existKey(key);
    }
    public ArrayList<Seguro> getLstSeguros()
    {

    	return carga.getLstSeguro();
    }
    public void eliminarSeguro(Seguro seg) 
    {
    	user.eliminarSeguro(seg.getNombreSeguro());
    }   
    public void gestionarVehiculos()
	{
    	JPEliminarVehiculo jPEliminarVehiculo = new JPEliminarVehiculo(this);
    	JPRegistrarVehiculo jPRegistrarVehiculo = new JPRegistrarVehiculo(this);
    	
            String[] opciones = {"Registrar vehículo", "Eliminar vehículo"};
            
            int seleccion = JOptionPane.showOptionDialog(null, "¿Qué acción desea realizar?", "CarRental", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            
            if (seleccion == 0) {
                System.out.println(" ");
                nuevoCentro(jPRegistrarVehiculo);
            } else if (seleccion == 1) {
                System.out.println(" ");
                add(jPEliminarVehiculo, BorderLayout.CENTER);
                nuevoCentro(jPEliminarVehiculo);
            }
	}
    public JPanel getPanelAnte() 
    {
    	return panelAnte;
    }

   

    public void añadirVeh(String placa,String modelo,String sede,int capacidad,String color,int anioFab,String transmicion,String catVehiculo,String marca,String estadoVehiculo,int idCat,Vehiculo veh) 

    {
    	carga.sobreEscribirVehiculo(placa, color, marca, modelo, sede, transmicion, catVehiculo, color, transmicion, catVehiculo, marca);
    	carga.addSede(veh);
    	inv.addVehiculo(placa, veh);

    }
    public void setLstSeguro(ArrayList<Seguro> lst) 
    {
    	carga.settteLstSeguros(lst);
    }
    
    
    public void gestionarSeguros()
	{
    	JPEliminarSeguro jPEliminarSeguro = new JPEliminarSeguro(this);
    	JPRegistrarSeguro jPRegistrarSeguro = new JPRegistrarSeguro(this);  	
    	
    	
        String[] opciones = {"Añadir seguro", "Eliminar seguro"};
            
        int seleccion = JOptionPane.showOptionDialog(null, "¿Qué acción desea realizar?", "CarRental", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            
            if (seleccion == 0) {
                System.out.println(" ");
                nuevoCentro(jPRegistrarSeguro);
                
            } else if (seleccion == 1) {
                System.out.println(" ");
                nuevoCentro(jPEliminarSeguro);
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
    public File eliminarSegurostxt(String name) 
    {
    return carga.eliminarSegurotxt(name);	
    }
    public void añadirSeguro(Seguro nSeguro) 
    {
    	carga.addSeguro(nSeguro);
    }
    public Administrador getUser() {
    	return user;
    }
    public void eliminarVehiculo(String placa) 
    {
    	Vehiculo veh = inv.getVehiculo(placa);
    	
    	File temp = carga.eliminarVehiculotxt(veh);
		File bd = new File("Proyecto1_RentaCarros/data/ListaVehiculos.txt");
		bd.delete();
		temp.renameTo(bd);
    }
    public void cargar() 
    {
    	carga =  new CargaDatos();
    	inv = carga.getInventario();
    }
}