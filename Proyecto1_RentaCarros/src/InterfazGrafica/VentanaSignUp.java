package InterfazGrafica;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import controlador.CargaDatos;

public class VentanaSignUp extends JFrame 
{
	
	private JPanel panelCentro; 
	private JButton btnAtras;
	private JButton btnSignUp;
	
	
	private String user = "";
	private String name = "";
	private String fecha ="";
	private String correo = "";
	private String edad = "";
	private String password = "";
	private String cedula = "";
	
	private String numeroLicencia = "";
	private String paisExp = "";
	private String venciLicencia = "";
	
	private String medioPago = "";
	private String numeroTarjeta= "";
	private String venciTarjeta = "";
	
	
	private String panelActual = "cliente";
	
	private JTextField textFieldNombre;
	private JTextField textFieldCorreo;
	private JTextField textFieldEdad;
	private JTextField textFieldContraseña;
	private JTextField textFieldUsuario;
	private JTextField textFieldFecha ;
	private JTextField textFieldCedula ;
	private JPLicencia panelLic;
	private JPTarjeta panelTarjeta;
	private CargaDatos carga = new CargaDatos();
	
    public VentanaSignUp() 
    {
        setSize(1050, 650);
        setTitle("CarRental");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        panelTarjeta = new JPTarjeta(this);
        
        JPanel panelNorte = new JPanel();
        panelNorte.setBackground(new Color(152, 182, 182));
        add(panelNorte, BorderLayout.NORTH);
        JLabel labelTitulo = new JLabel("CAR RENTAL");
        labelTitulo.setForeground(Color.BLACK);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        panelNorte.add(labelTitulo);
        panelNorte.setBorder(new MatteBorder(0, 0, 6, 0, Color.BLACK));

        
        

        panelCentro = new JPanel(new GridLayout(4, 1, 40, 30));


        panelCentro.setBackground(new Color(200, 182, 182));
        add(panelCentro, BorderLayout.CENTER);
        panelCentro.setBorder(new EmptyBorder(110, 60, 110, 60));
        
        JPanel p = new JPanel(new GridLayout(1, 2, 40, 30));
        p.setBackground(new Color(200, 182, 182));
        textFieldNombre = new JTextFieldWithHint("Nombre completo");
        textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldNombre.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldNombre.setForeground(Color.GRAY);
        textFieldNombre.setBorder(new LineBorder(Color.BLACK,2));
        
        p.add(textFieldNombre);
        textFieldCorreo = new JTextFieldWithHint("Correo electrónico");
        textFieldCorreo.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldCorreo.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldCorreo.setForeground(Color.GRAY);
        textFieldCorreo.setBorder(new LineBorder(Color.BLACK,2));
        p.add(textFieldCorreo);
        panelCentro.add(p);
        
        p = new JPanel(new GridLayout(1, 2, 40, 30));
        p.setBackground(new Color(200, 182, 182));
        
        textFieldEdad = new JTextFieldWithHint("Edad");
        textFieldEdad.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldEdad.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldEdad.setForeground(Color.GRAY);
        textFieldEdad.setBorder(new LineBorder(Color.BLACK,2));
        p.add(textFieldEdad);
        
        textFieldCedula = new JTextFieldWithHint("Cedula");
        textFieldCedula.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldCedula.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldCedula.setForeground(Color.GRAY);
        textFieldCedula.setBorder(new LineBorder(Color.BLACK,2));
        
        p.add(textFieldCedula);
        panelCentro.add(p);
        
        
        p = new JPanel(new GridLayout(1, 2, 40, 30));
        p.setBackground(new Color(200, 182, 182));
        
        textFieldFecha = new JTextFieldWithHint("Fecha de nacimiento");
        textFieldFecha.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldFecha.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldFecha.setForeground(Color.GRAY);
        textFieldFecha.setBorder(new LineBorder(Color.BLACK,2));
        p.add(textFieldFecha);
        

        
        textFieldUsuario = new JTextFieldWithHint("Usuario que desea");
        textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldUsuario.setForeground(Color.GRAY);
        textFieldUsuario.setBorder(new LineBorder(Color.BLACK,2));
        p.add(textFieldUsuario);
        panelCentro.add(p);

        
        textFieldContraseña = new JTextFieldWithHint("Contraseña");
        textFieldContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldContraseña.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldContraseña.setForeground(Color.GRAY);
        textFieldContraseña.setBorder(new LineBorder(Color.BLACK,2));
        
        panelCentro.add(textFieldContraseña);
        
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
        
       
        
        JPanel panelOeste = new JPanel(new GridLayout(2,1, 0,410));
        add(panelOeste, BorderLayout.WEST);
        panelOeste.setBackground(new Color(200, 182, 182));
        panelOeste.setBorder(new EmptyBorder(20, 10, 20, 0));

         
        
        btnAtras = new JButton(" Menú principal ");
        btnAtras.setFont(new Font("Arial", Font.BOLD, 18));
        btnAtras.setBackground(new Color(32, 182, 182));
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setBorder(new LineBorder(Color.BLACK, 2));
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	VentanaLogin VentanaLogin = new VentanaLogin();
            	VentanaLogin.setLocationRelativeTo(null);
            	VentanaLogin.setVisible(true);
            	dispose(); 
                
            	
            }
        });
        panelOeste.add(btnAtras);
        
        
        btnSignUp = new JButton("   Siguiente   ");
        btnSignUp.setFont(new Font("Arial", Font.BOLD, 18));
        btnSignUp.setBackground(new Color(32, 182, 182));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBorder(new LineBorder(Color.BLACK, 2));
        btnSignUp.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	
         if (panelActual.equals("cliente"))
         {
        	 nextCliente();
         }
         else if (panelActual.equals("licencia")) 
         {
          
        	 panelLic.next();
         }
         else 
         {
        	 
        	 panelTarjeta.next();
        	 }
            	}
            	
            }
        );
        
        panelOeste.add(btnSignUp);
              
}
    public void añadirUser() 
    {
    	carga.sobreEscribirUsuarios(user, password, name, "Cliente");
    	carga.sobreEscribirClientes(name,edad,cedula,fecha,correo,user,password,
				numeroLicencia,paisExp,venciLicencia,medioPago,numeroTarjeta,venciTarjeta);
    	
    	
    }
    
    public void mensaje()
	{
		JOptionPane.showMessageDialog(this, "¡Haz sido correctamente registrado!", "CarRental", JOptionPane.INFORMATION_MESSAGE);
	}
    public void errorMensaje(String mensaje) 
    {
    	JOptionPane.showMessageDialog(this, mensaje, "CarRental", JOptionPane.ERROR_MESSAGE);
    }
    private boolean revAll(String user,String name,String fecha,String correo,String edad,String contra,String cedula) 
    {
    	if (user.equals("")||name.equals("")||fecha.equals("")|| correo.equals("")|| edad.equals("") ||contra.equals("") || cedula.equals("")) {
        	return false;
        	}
    	else {
    		return true;
    	}
    }
    public void remPCentro() 
    {
    	panelCentro.setVisible(false);
    }
    private void toLicencia(String user,String name,String fecha,String correo,String edad,String contra) 
    {
  			panelCentro.setVisible(false);
  			
    		panelLic = new JPLicencia(this,panelTarjeta);
    		panelCentro = panelLic;
    		add(panelCentro,BorderLayout.CENTER);
    		panelCentro.setVisible(true);
    		panelActual = "licencia";
  			
    		
    }
    private void toTarjeta(String user,String name,String fecha,String correo,String edad,String contra,String num,String pais,String venci) 
    {
    	
    }
    public void addPCentro() 
    {
    	add(panelCentro,BorderLayout.CENTER);
    	panelCentro.setVisible(true); 
    	}
    
    public void nextCliente() 
    {   	
    user = textFieldUsuario.getText();
	name = textFieldNombre.getText();
	fecha =textFieldFecha.getText();
	correo = textFieldCorreo.getText();
	edad = textFieldEdad.getText();
	password = textFieldContraseña.getText();
	cedula = textFieldCedula.getText();
	panelActual = "cliente";
	if (!revAll(user,name,fecha,correo,edad,password,cedula)) 
	{
		errorMensaje("Debes registrar todos los espacios con tu información");
	}
	else {
		try {
			int edadInt = Integer.parseInt(edad);
	        
	        if (edadInt > 17) {
	            toLicencia(user, name, fecha, correo, edad, password);
	        } else {
	            errorMensaje("Debes ser mayor de edad (18) para crear una cuenta");
	        }
	    } catch (NumberFormatException e) {
	        errorMensaje("La edad debe ser un número válido");
	    }
	}
    }
    
	public JPanel setPanelCentro(JPanel pCentro) 
	{
		panelCentro = pCentro;
		return panelCentro;
				}
	public void setTarjetaValues(String medio,String num,String venci) 
	{
		panelActual = "tarjeta";
		this.medioPago = medio;
		numeroTarjeta= num;
		venciTarjeta = venci;
	}
public void setLicenciaValues(String numL,String pais,String venc) 
{
panelActual = "Tarjeta";
this.numeroLicencia = numL;
this.paisExp =pais;
this.venciLicencia = venc;
}
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