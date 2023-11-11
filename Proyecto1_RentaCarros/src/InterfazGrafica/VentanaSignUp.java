package InterfazGrafica;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class VentanaSignUp extends JFrame 
{
	private JLabel lblRelleno;
	private JLabel lblRelleno2;
	private JLabel lblRelleno3;
	
    public VentanaSignUp() 
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

        
        
        JPanel panelCentro = new JPanel(new GridLayout(3, 2, 40, 30));
        panelCentro.setBackground(new Color(200, 182, 182));
        add(panelCentro, BorderLayout.CENTER);
        panelCentro.setBorder(new EmptyBorder(140, 60, 140, 60));
        
                            
        JTextField textFieldNombre = new JTextFieldWithHint("Nombre completo");
        textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldNombre.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldNombre.setBorder(new LineBorder(Color.BLACK,2));
        panelCentro.add(textFieldNombre);
        
        JTextField textFieldCorreo = new JTextFieldWithHint("Correo electrónico");
        textFieldCorreo.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldCorreo.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldCorreo.setBorder(new LineBorder(Color.BLACK,2));
        panelCentro.add(textFieldCorreo);
        
        JTextField textFieldEdad = new JTextFieldWithHint("Edad");
        textFieldEdad.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldEdad.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldEdad.setBorder(new LineBorder(Color.BLACK,2));
        panelCentro.add(textFieldEdad);
        
        JTextField textFieldUsuario = new JTextFieldWithHint("Usuario que desea");
        textFieldUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldUsuario.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldUsuario.setBorder(new LineBorder(Color.BLACK,2));
        panelCentro.add(textFieldUsuario);

        JTextField textFieldFecha = new JTextFieldWithHint("Fecha de nacimiento");
        textFieldFecha.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldFecha.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldFecha.setBorder(new LineBorder(Color.BLACK,2));
        panelCentro.add(textFieldFecha);
        
        JTextField textFieldContraseña = new JTextFieldWithHint("Contraseña");
        textFieldContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldContraseña.setFont(new Font("Arial", Font.BOLD, 20));
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

         
        
        JButton btnAtras = new JButton("Atrás");
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
        
        
        JButton btnSignUp = new JButton("   Sign up   ");
        btnSignUp.setFont(new Font("Arial", Font.BOLD, 18));
        btnSignUp.setBackground(new Color(32, 182, 182));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setBorder(new LineBorder(Color.BLACK, 2));
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	mensaje();
            	VentanaLogin VentanaLogin = new VentanaLogin();
            	VentanaLogin.setLocationRelativeTo(null);
            	VentanaLogin.setVisible(true);
                dispose();
            }
        });
        panelOeste.add(btnSignUp);
              
    }

    public void mensaje()
	{
		JOptionPane.showMessageDialog(this, "¡Haz sido correctamente registrado!", "CarRental", JOptionPane.INFORMATION_MESSAGE);
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
                showingHint = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (this.getText().isEmpty()) {
                super.setText(hint);
                showingHint = true;
            }
        }

        @Override
        public String getText() {
            return showingHint ? "" : super.getText();
        }
    }
}