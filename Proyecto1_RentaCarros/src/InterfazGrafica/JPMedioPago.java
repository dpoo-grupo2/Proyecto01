package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Reserva;

public class JPMedioPago extends JPanel{
	private MenuCliente vent;
	
	private JLabel lblSelect;
	
	private JButton btnEfectivo;
	private JButton btnTarjeta;
	private JButton btnNequi;
	private JButton btnDaviPlata;
	private JButton btnNext;
	
	private JPClientePago pago;
	
	private JPReservaRegistrada rR;
public JPMedioPago(MenuCliente vent,Reserva res) 
{
	this.vent = vent;
	 setLayout(new GridLayout(4, 1, 0, 14)); 
     setBackground(new Color(200, 182, 182));
     setBorder(new EmptyBorder(70, 160, 70, 160));
     
     lblSelect = new JLabel("Seleccione el metodo de pago que desea");
     lblSelect.setHorizontalAlignment(SwingConstants.CENTER);
     lblSelect.setFont(new Font("Arial", Font.BOLD, 22));
     add(lblSelect);
     JPanel p = new JPanel(new GridLayout(2,1,16, 20));
     p.setBackground(new Color(200, 182, 182));
     
     btnEfectivo= new JButton("Efectivo");
     btnEfectivo.setFont(new Font("Arial", Font.BOLD, 18));
     btnEfectivo.setBackground(new Color(32, 182, 182));
     btnEfectivo.setForeground(Color.WHITE);
     btnEfectivo.setBorder(new LineBorder(Color.BLACK, 2));
     btnEfectivo.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) 
{
        	 rR = new JPReservaRegistrada(vent);   
        	 vent.nuevoCentro(rR);
         }
     });
     p.add(btnEfectivo);
     
     btnTarjeta = new JButton("Tarjeta del usuario");
     btnTarjeta.setFont(new Font("Arial", Font.BOLD, 18));
     btnTarjeta.setBackground(new Color(32, 182, 182));
     btnTarjeta.setForeground(Color.WHITE);
     btnTarjeta.setBorder(new LineBorder(Color.BLACK, 2));
     btnTarjeta.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
        	 rR = new JPReservaRegistrada(vent);   
        	 vent.nuevoCentro(rR);     
         }
     });
     p.add(btnTarjeta);
     add(p);
     JPanel j = new JPanel(new GridLayout(2,1,16,20));
     j.setBackground(new Color(200, 182, 182));
     
     btnNequi = new JButton("Nequi");
     btnNequi.setFont(new Font("Arial", Font.BOLD, 18));
     btnNequi.setBackground(new Color(32, 182, 182));
     btnNequi.setForeground(Color.WHITE);
     btnNequi.setBorder(new LineBorder(Color.BLACK, 2));
     btnNequi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
	            pago = new JPClientePago(vent,"nequi",null);
	            vent.nuevoCentro(pago);
         }
     });
     
     btnDaviPlata = new JButton("daviPlata");
     btnDaviPlata.setFont(new Font("Arial", Font.BOLD, 18));
     btnDaviPlata.setBackground(new Color(32, 182, 182));
     btnDaviPlata.setForeground(Color.WHITE);
     btnDaviPlata.setBorder(new LineBorder(Color.BLACK, 2));
     btnDaviPlata.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
        	 pago = new JPClientePago(vent,"daviPlata",null);
        	 vent.nuevoCentro(pago);
         }
     });
     j.add(btnNequi);
     j.add(btnDaviPlata);	
     add(j);
     
     btnNext = new JButton("regresar");
     btnNext.setFont(new Font("Arial", Font.BOLD, 18));
     btnNext.setBackground(new Color(255, 144, 144));
     btnNext.setForeground(Color.WHITE);
     btnNext.setBorder(new LineBorder(Color.BLACK, 2));
     btnNext.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) 
         {
        	 ArrayList<JPanel>lst = vent.getPanelLst();
         	JPanel panel = lst.get(lst.size()-1);
         	vent.delElement(lst.size()-1);
         	
         	vent.nuevoCentroReg(panel);
         }
     });
     add(btnNext);
}

}
