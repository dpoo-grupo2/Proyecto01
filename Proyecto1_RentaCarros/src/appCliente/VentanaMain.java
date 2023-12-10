package appCliente;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import controlador.CargaDatos;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Seguro;
import modelo.Usuario;
import InterfazGrafica.VentanaSignUp;
import vista.EmpleadoVista;


public class VentanaMain extends JFrame 
{
	
	
	private CargaDatos cargaDatos = new CargaDatos();
	private HashMap<String,Usuario> usuarios;
	private HashMap<String,Cliente> clientes;
	
    public VentanaMain() 
    {
        setSize(1050, 650);
        setTitle("CarRental");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
        CargarDatos();
        
        
        JPanel panelNorte = new JPanel();
        panelNorte.setBackground(new Color(152, 182, 182));
        add(panelNorte, BorderLayout.NORTH);
        JLabel labelTitulo = new JLabel("CAR RENTAL");
        labelTitulo.setForeground(Color.BLACK);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        panelNorte.add(labelTitulo);
        panelNorte.setBorder(new MatteBorder(0, 0, 6, 0, Color.BLACK));

        
        
        JPanel panelCentro = new JPanel(new GridLayout(5, 1, 20,35));
        panelCentro.setBackground(new Color(200, 182, 182));
        add(panelCentro, BorderLayout.CENTER);
        JLabel labelIniciarSesion = new JLabel("¡Bienvenido Cliente!");
        labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.setBorder(new EmptyBorder(70, 160, 70, 160));
        labelIniciarSesion.setFont(new Font("Arial", Font.BOLD, 30));
        panelCentro.add(labelIniciarSesion);
        
              
        JTextField textFieldLogin = new JTextFieldWithHint("Login");
        textFieldLogin.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldLogin.setFont(new Font("Arial", Font.PLAIN, 20));
        textFieldLogin.setForeground(Color.GRAY);
        textFieldLogin.setBorder(new LineBorder(Color.BLACK,2));
        panelCentro.add(textFieldLogin);
        
        

        JTextField textFieldContraseña = new JTextFieldWithHint("Password");
        textFieldContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldContraseña.setFont(new Font("Arial", Font.PLAIN, 20));
        textFieldContraseña.setForeground(Color.GRAY);
        textFieldContraseña.setBorder(new LineBorder(Color.BLACK,2));
        panelCentro.add(textFieldContraseña);
        
        
        
        JButton btnLogin = new JButton("Autenticar usuario");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
        btnLogin.setBackground(new Color(32, 182, 182));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBorder(new LineBorder(Color.BLACK, 2));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	boolean loginExitoso = false;
            	String login = textFieldLogin.getText();
                String contraseña = textFieldContraseña.getText();

                if (usuarios.containsKey(login)) {
    	            Usuario clsUsuario = usuarios.get(login);

    	            if (contraseña.equals(clsUsuario.getPassword())) {
    	                loginExitoso = true;
    	                
    	                if (clsUsuario.getTipoUsuario().equals("Cliente")) {
    	                    
    	                	MenuAppCliente menuAppCliente = new MenuAppCliente();
    	                	menuAppCliente.setLocationRelativeTo(null);
    	                	menuAppCliente.setVisible(true);
    	    	            dispose();
    	                }
    	                else {
    	                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta. Vuelve a intentar.");
    	                }
    	            }
    	        }

 
                else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta. Vuelve a intentar.");
                }
            	
            	
            }
        });
        panelCentro.add(btnLogin);

        JButton btnSignUp = new JButton("Crear usuario");
        btnSignUp.setFont(new Font("Arial", Font.BOLD, 20));
        btnSignUp.setBackground(new Color(120, 220, 120));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBorder(new LineBorder(Color.BLACK, 2));
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
	            VentanaSignUp ventanaSignUp = new VentanaSignUp();
	            ventanaSignUp.setLocationRelativeTo(null);
	            ventanaSignUp.setVisible(true);
	            dispose();
            	
            }
        });
        panelCentro.add(btnSignUp);
        
        
        
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
        ImageIcon imagen2 = new ImageIcon("Proyecto1_RentaCarros/data/CarroCliente (1).png");
        JLabel labelImagen2 = new JLabel(imagen2);
        panelOeste.add(labelImagen2);
        panelOeste.setPreferredSize(new Dimension(130, 10));
        labelImagen2.setPreferredSize(new Dimension());
        labelImagen2.setAlignmentY(BOTTOM_ALIGNMENT);
        panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.Y_AXIS));
        panelOeste.setLayout(new BoxLayout(panelOeste, BoxLayout.X_AXIS));

    }

    
    public static void main(String[] args) 
    {
    	VentanaMain ventana = new VentanaMain();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
        
    }
    
    
    public void CargarDatos(){
		HashMap<String, Usuario> usuarios = cargaDatos.getUsuarios();
		HashMap<String,Cliente> clientes = cargaDatos.getClientes();
		this.usuarios = usuarios;		
		this.clientes = clientes;
		
	}
    
    class JTextFieldWithHint extends JTextField implements FocusListener {
        private final String hint;
        private boolean showingHint;

        public JTextFieldWithHint(final String hint) {
            super(hint);
            this.hint = hint;
            this.showingHint = true;
            super.addFocusListener(this);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText("");
                super.setForeground(Color.BLACK);
                showingHint = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText(hint);
                super.setForeground(Color.GRAY);
                showingHint = true;
            }
        }

        @Override
        public String getText() {
            return showingHint ? "" : super.getText();
        }
    }


}