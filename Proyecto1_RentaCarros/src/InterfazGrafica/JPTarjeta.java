package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPTarjeta extends JPanel{
	private JTextField txtFieldMedio;
	private JTextField txtFieldNumero;
	private JTextField txtFieldVenci;
	private VentanaSignUp vent;
	private String medio = "";
	private String num = "";
	private String venc = "";
public JPTarjeta(VentanaSignUp vent) 
{
	this.vent = vent;
	setLayout(new GridLayout(3,1,15,15));
    setBackground(new Color(200, 182, 182));
    setBorder(new EmptyBorder(140, 160, 140, 160));
    txtFieldMedio= new JTextFieldWithHint("Medio de pago (débito o crédito)");
    txtFieldMedio.setForeground(Color.GRAY);
    txtFieldMedio.setHorizontalAlignment(SwingConstants.CENTER);
    txtFieldMedio.setFont(new Font("Arial", Font.BOLD, 20));
    txtFieldMedio.setBorder(new LineBorder(Color.BLACK,2));
    add(txtFieldMedio);
    
    txtFieldNumero= new JTextFieldWithHint("Numero tarjeta");
    txtFieldNumero.setForeground(Color.GRAY);
    txtFieldNumero.setHorizontalAlignment(SwingConstants.CENTER);
    txtFieldNumero.setFont(new Font("Arial", Font.BOLD, 20));
    txtFieldNumero.setBorder(new LineBorder(Color.BLACK,2));
    add(txtFieldNumero);
    
    txtFieldVenci= new JTextFieldWithHint("Fecha de expedicion");
    txtFieldVenci.setForeground(Color.GRAY);
    txtFieldVenci.setHorizontalAlignment(SwingConstants.CENTER);
    txtFieldVenci.setFont(new Font("Arial", Font.BOLD, 20));
    txtFieldVenci.setBorder(new LineBorder(Color.BLACK,2));
    add(txtFieldVenci);
    
    
}
private boolean revAll() 
{
	medio = txtFieldMedio.getText();
	venc = txtFieldVenci.getText();
	num = txtFieldNumero.getText();
	if (num.equals("")||medio.equals("")||venc.equals("")) 
	{
		return false;
	}
	else 
	{
		return true;
	}
}
public void next()
{
	if (revAll()) 
	{
		vent.setTarjetaValues(medio,num, venc);
		vent.mensaje();
    	VentanaLogin VentanaLogin = new VentanaLogin();
    	VentanaLogin.setLocationRelativeTo(null);
    	VentanaLogin.setVisible(true);
    	vent.dispose();
    	}
	
else {
	vent.errorMensaje("Debe introducir todos los datos");
}
}
}

