package InterfazGrafica;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class VentanaLogin extends JFrame 
{
	private JLabel lblRelleno;
	private JLabel lblRelleno2;
	private JLabel lblRelleno3;
	
    public VentanaLogin() 
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

        
        
        JPanel panelCentro = new JPanel(new GridLayout(8, 1));
        panelCentro.setBackground(new Color(200, 182, 182));
        add(panelCentro, BorderLayout.CENTER);
        JLabel labelIniciarSesion = new JLabel("Iniciar Sesión");
        labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
        panelCentro.setBorder(new EmptyBorder(70, 220, 70, 220));
        labelIniciarSesion.setFont(new Font("Arial", Font.BOLD, 30));
        panelCentro.add(labelIniciarSesion);
        lblRelleno2 = new JLabel(" ");
        panelCentro.add(lblRelleno2);
              
        JTextField textFieldLogin = new JTextFieldWithHint("Login");
        textFieldLogin.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldLogin.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldLogin.setBorder(new LineBorder(Color.BLACK,2));
        panelCentro.add(textFieldLogin);
        
        lblRelleno = new JLabel(" ");
        panelCentro.add(lblRelleno);

        JTextField textFieldContraseña = new JTextFieldWithHint("Contraseña");
        textFieldContraseña.setHorizontalAlignment(SwingConstants.CENTER);
        textFieldContraseña.setFont(new Font("Arial", Font.BOLD, 20));
        textFieldContraseña.setBorder(new LineBorder(Color.BLACK,2));
        panelCentro.add(textFieldContraseña);
        
        lblRelleno3 = new JLabel(" ");
        panelCentro.add(lblRelleno3);
        
        JButton btnLogin = new JButton("Log In");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
        btnLogin.setBackground(new Color(32, 182, 182));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBorder(new LineBorder(Color.BLACK, 2));
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	MenuCliente MenuCliente = new MenuCliente();
            	MenuCliente.setLocationRelativeTo(null);
            	MenuCliente.setVisible(true);
                dispose();    
            	
            }
        });
        panelCentro.add(btnLogin);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Arial", Font.BOLD, 20));
        btnSignUp.setBackground(new Color(32, 182, 182));
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
        
        //lol
        
        JPanel panelOeste = new JPanel();
        add(panelOeste, BorderLayout.WEST);
        panelOeste.setBackground(new Color(200, 182, 182));
        panelOeste.setBorder(new EmptyBorder(70, 90, 20, 32));

    }

    
    public static void main(String[] args) 
    {
        VentanaLogin ventana = new VentanaLogin();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
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