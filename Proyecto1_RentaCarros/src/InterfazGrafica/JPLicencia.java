package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JPLicencia extends JPanel{
private JTextField txtFieldNumero;
private JTextField txtFieldPais;
private JTextField txtFieldVenci;
private VentanaSignUp vent;
private String num = "";
private String pais = "";
private String venc = "";
private JPanel nextPanel;
	public JPLicencia(VentanaSignUp vent,JPanel nextPanel) 
	{
		this.vent = vent;
		this.nextPanel = nextPanel;
		setLayout(new GridLayout(1,3));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 150, 160));
        txtFieldNumero= new JTextFieldWithHint("numero licencia");
        txtFieldNumero.setHorizontalAlignment(SwingConstants.CENTER);
        txtFieldNumero.setFont(new Font("Arial", Font.BOLD, 20));
        txtFieldNumero.setBorder(new LineBorder(Color.BLACK,2));
        add(txtFieldNumero);
        
        txtFieldPais = new JTextFieldWithHint("pais de expedicion");
        txtFieldPais.setHorizontalAlignment(SwingConstants.CENTER);
        txtFieldPais.setFont(new Font("Arial", Font.BOLD, 20));
        txtFieldPais.setBorder(new LineBorder(Color.BLACK,2));
        add(txtFieldPais);
        
        txtFieldVenci= new JTextFieldWithHint("pais de expedicion");
        txtFieldVenci.setHorizontalAlignment(SwingConstants.CENTER);
        txtFieldVenci.setFont(new Font("Arial", Font.BOLD, 20));
        txtFieldVenci.setBorder(new LineBorder(Color.BLACK,2));
        add(txtFieldVenci);
        
        
		
	}
	private boolean revAll() 
	{
		num = txtFieldNumero.getText();
		pais = txtFieldPais.getText();
		venc = txtFieldVenci.getText();
		if (num.equals("")||pais.equals("")||venc.equals("")) 
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
			System.out.println("empieza a cambiar el panel");
			vent.remPCentro();
			vent.setLicenciaValues(num, pais, venc);
			vent.setPanelCentro(nextPanel);
			vent.addPCentro();
		}
		else 
		{
			vent.errorMensaje("Debe introducir todos los datos");
		}
	}
	
}
