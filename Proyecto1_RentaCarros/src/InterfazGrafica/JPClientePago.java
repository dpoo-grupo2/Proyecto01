package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Reserva;

public class JPClientePago extends JPanel{
private String numero;
private String nombre;
private String tipo;
private MenuCliente vent;

private JLabel lblBienv;

private JTextField txtNumero;
private JTextField txtNombre;

private boolean estado;

private JButton btnNext;
private JPReservaRegistrada rR;  
public JPClientePago(MenuCliente vent,String tipo,Reserva res) 
{
	this.vent = vent;
	this.tipo = tipo;
	rR = new JPReservaRegistrada(vent); 
	setLayout(new GridLayout(3, 1, 0, 30));
    setBackground(new Color(200, 182, 182));
    setBorder(new EmptyBorder(100, 160, 140, 160));
    
    JPanel p = new JPanel(new GridLayout(1,2,16,20));
    p.setBackground(new Color(200, 182, 182));
    lblBienv = new JLabel("Introduzca la siguiente informaion para proceder su pago");
    lblBienv.setHorizontalAlignment(SwingConstants.CENTER);
    lblBienv.setFont(new Font("Arial", Font.BOLD, 26));
    add(lblBienv);
    txtNumero = aTextFieldWithHint("ingrese su numero telefonico:");
    p.add(txtNumero);
    txtNombre = aTextFieldWithHint("ingrese su nombre");
    p.add(txtNombre);
    add(p);
    
    btnNext = new JButton("Siguiente");
    btnNext.setFont(new Font("Arial", Font.BOLD, 20));
    btnNext.setForeground(Color.WHITE);
    btnNext.setBackground(new Color(255, 144, 144));
    btnNext.setBorder(new LineBorder(Color.BLACK, 2));
    btnNext.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
        	estado = true;
        	String number = txtNumero.getText();
        	System.out.println("AAAAA");
        	if(number.length()>10 || number.length() <10) 
        	{
        		errorMensaje("el numero debe ser de 10 digitos");
        	}
        	else 
        	{
        		for(int i = 0;i<number.length();i++) 
        		{
        			if(!Character.isDigit(number.charAt(i))) 
        			{
        				System.out.println("entra");
                	estado = false;
        			errorMensaje("el numero telefonico solo debe contener numeros");	
        			break;
        			}
        		}

        		if (estado) {
        		mensaje("el pago se efectuo de manera correcta");
        		vent.nuevoCentro(rR);
        		}
        		
        		}
        		
        }
    });
    add(btnNext);
}

private JTextField aTextFieldWithHint(String hint) {
    JTextField textField = new JTextField();
    textField.setFont(new Font("Arial", Font.BOLD, 16));
    textField.setForeground(Color.GRAY);
    textField.setHorizontalAlignment(SwingConstants.CENTER);
    textField.setBorder(new LineBorder(Color.BLACK, 2));
    textField.setText(hint);
    textField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            if (textField.getText().equals(hint)) {
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (textField.getText().isEmpty()) {
                textField.setForeground(Color.GRAY);
                textField.setText(hint);
            }
        }
    });

    return textField;
}
private void errorMensaje(String mensaje) 
{
	JOptionPane.showMessageDialog(this, mensaje, "CarRental", JOptionPane.ERROR_MESSAGE);
}
private void mensaje(String mensaje) 
{
	
	JOptionPane.showMessageDialog(this, mensaje, "CarRental", JOptionPane.INFORMATION_MESSAGE);}
}

