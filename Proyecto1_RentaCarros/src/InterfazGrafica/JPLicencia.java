package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPLicencia extends JPanel{
private JTextField txtFieldNumero;
private JTextField txtFieldPais;
private JTextField txtFieldVenci;
	public JPLicencia(VentanaSignUp vent) 
	{
		setLayout(new GridLayout(1,3));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 150, 160));
        txtFieldNumero= new JTextField("numero licencia");
        txtFieldNumero.setHorizontalAlignment(SwingConstants.CENTER);
        txtFieldNumero.setFont(new Font("Arial", Font.BOLD, 20));
        txtFieldNumero.setBorder(new LineBorder(Color.BLACK,2));
        add(txtFieldNumero);
        
        txtFieldPais = new JTextField("pais de expedicion");
        txtFieldPais.setHorizontalAlignment(SwingConstants.CENTER);
        txtFieldPais.setFont(new Font("Arial", Font.BOLD, 20));
        txtFieldPais.setBorder(new LineBorder(Color.BLACK,2));
        add(txtFieldPais);
        
        txtFieldVenci= new JTextField("pais de expedicion");
        txtFieldVenci.setHorizontalAlignment(SwingConstants.CENTER);
        txtFieldVenci.setFont(new Font("Arial", Font.BOLD, 20));
        txtFieldVenci.setBorder(new LineBorder(Color.BLACK,2));
        add(txtFieldVenci);
        
        
		
	}
}
