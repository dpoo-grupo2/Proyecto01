package InterfazGrafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyPair;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import modelo.Cliente;
import modelo.ConductorAdicional;
import modelo.Reserva;
import modelo.Seguro;
import modelo.Vehiculo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JPClienteSede extends JPanel {

	private JLabel lblRelleno;
	private Date fechaRecogida;
	private Date fechaEntrega;
	private Date horaRecogida;
	private Date horaEntrega;
	private MenuCliente vent;
	private String sedeEntrega;
	private String sedeRecogida;
	private int idCategoria;
	private JPReservaRegistrada rR; 
	private Vehiculo veh;
	private Cliente cliente;
    public JPClienteSede(MenuCliente vent, String sedeEntrega,String sedeRecogida,Cliente cliente) 
    {
    	this.sedeRecogida = sedeRecogida;
    	this.sedeEntrega = sedeEntrega;
    	this.cliente = cliente;
    	this.vent = vent;
    	
        setLayout(new GridLayout(7, 1, 0, 14));
        setBackground(new Color(200, 182, 182));
        setBorder(new EmptyBorder(70, 160, 80, 160));
        
        JLabel labelSelect = new JLabel("Seleccione la categoría del vehículo:");
        labelSelect.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelect.setFont(new Font("Arial", Font.BOLD, 24));
        
		add(labelSelect);

		lblRelleno = new JLabel(" ");
        add(lblRelleno);
		
        rR = new JPReservaRegistrada(vent);
        
        JPanel p1 = new JPanel(new GridLayout(1,2,16,20));
        p1.setBackground(new Color(200, 182, 182));
		JButton btnPequeño = new JButton("Pequeño");
		btnPequeño.setFont(new Font("Arial", Font.BOLD, 20));
		btnPequeño.setBackground(new Color(32, 182, 182));
		btnPequeño.setForeground(Color.WHITE);
		btnPequeño.setBorder(new LineBorder(Color.BLACK, 2));
		btnPequeño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	idCategoria = 1;
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                	veh = verDisponibilidad(sedeEntrega,idCategoria,fechaEntrega,fechaRecogida);
                	
                	if (veh==null) 
                	{
                		System.out.println(veh.getCapacidad());
                		vent.errorMensaje("en esas fechas no hay vehiculos disponibles");
                	}
                	else {
                    setVisible(false);
                    crearReserva();
                    JPMedioPago mp = new JPMedioPago(vent,null);
                    vent.nuevoCentro(mp);
                    }
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                         
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        p1.add(btnPequeño);
        
        JButton btnMoto= new JButton("Moto");
        btnMoto.setFont(new Font("Arial", Font.BOLD, 20));
        btnMoto.setBackground(new Color(32, 182, 182));
        btnMoto.setForeground(Color.WHITE);
        btnMoto.setBorder(new LineBorder(Color.BLACK, 2));
        btnMoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	idCategoria = 5;
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    JPMedioPago mp = new JPMedioPago(vent,null);
                    vent.nuevoCentro(mp);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        p1.add(btnMoto);
        add(p1);
        JPanel p2 = new JPanel(new GridLayout(1,2,16,20));
        p2.setBackground(new Color(200, 182, 182));
        
        JButton btnSedan= new JButton("Sedan");
        btnSedan.setFont(new Font("Arial", Font.BOLD, 20));
        btnSedan.setBackground(new Color(32, 182, 182));
        btnSedan.setForeground(Color.WHITE);
        btnSedan.setBorder(new LineBorder(Color.BLACK, 2));
        btnSedan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	idCategoria = 2;
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    
                    JPMedioPago mp = new JPMedioPago(vent,null);
                    vent.nuevoCentro(mp);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        p2.add(btnSedan);
        
        JButton btnAtv= new JButton("Atv");
        btnAtv.setFont(new Font("Arial", Font.BOLD, 20));
        btnAtv.setBackground(new Color(32, 182, 182));
        btnAtv.setForeground(Color.WHITE);
        btnAtv.setBorder(new LineBorder(Color.BLACK, 2));
        btnAtv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	idCategoria = 6;
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    JPMedioPago mp = new JPMedioPago(vent,null);
                    vent.nuevoCentro(mp);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        p2.add(btnAtv);
        
        add(p2);
        JPanel p3 = new JPanel(new GridLayout(1,2,16,20));
        p3.setBackground(new Color(200, 182, 182));
        
        JButton btnBici = new JButton("bicicleta");
        btnBici.setFont(new Font("Arial", Font.BOLD, 20));
        btnBici.setBackground(new Color(32, 182, 182));
        btnBici.setForeground(Color.WHITE);
        btnBici.setBorder(new LineBorder(Color.BLACK, 2));
        btnBici.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	idCategoria = 7;
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    JPMedioPago mp = new JPMedioPago(vent,null);
                    vent.nuevoCentro(mp);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });

        
        
        JButton btnLujo = new JButton("Lujo");
        btnLujo.setFont(new Font("Arial", Font.BOLD, 20));
        btnLujo.setBackground(new Color(32, 182, 182));
        btnLujo.setForeground(Color.WHITE);
        btnLujo.setBorder(new LineBorder(Color.BLACK, 2));
        btnLujo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	idCategoria = 4;
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    JPMedioPago mp = new JPMedioPago(vent,null);
                    vent.nuevoCentro(mp);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        p3.add(btnLujo);
        p3.add(btnBici);
        add(p3);
        
        JPanel p4 = new JPanel(new GridLayout(1,2,16,20));
        p4.setBackground(new Color(200, 182, 182));
        JButton btnSuv= new JButton("SUV");
        btnSuv.setFont(new Font("Arial", Font.BOLD, 20));
        btnSuv.setBackground(new Color(32, 182, 182));
        btnSuv.setForeground(Color.WHITE);
        btnSuv.setBorder(new LineBorder(Color.BLACK, 2));
        btnSuv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	idCategoria =3;
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    JPMedioPago mp = new JPMedioPago(vent,null);
                    vent.nuevoCentro(mp);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        p4.add(btnSuv);
        
        JButton btnPatineta= new JButton("Patineta");
        btnPatineta.setFont(new Font("Arial", Font.BOLD, 20));
        btnPatineta.setBackground(new Color(32, 182, 182));
        btnPatineta.setForeground(Color.WHITE);
        btnPatineta.setBorder(new LineBorder(Color.BLACK, 2));
        btnPatineta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	idCategoria = 8;
            	fechaReserva();
                horaReserva();
                if (fechaEntrega != null && fechaRecogida != null && horaRecogida != null && horaEntrega != null) {
                    setVisible(false);
                    JPMedioPago mp = new JPMedioPago(vent,null);
                    vent.nuevoCentro(mp);
                } else {
                    
                    if (fechaEntrega == null && fechaRecogida == null && horaRecogida == null && horaEntrega == null) {
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos para completar la reserva", "CarRental", JOptionPane.OK_CANCEL_OPTION);
                    }
                }
            }
        });
        p4.add(btnPatineta);
        add(p4);
        
        JButton btnAtras = new JButton("Regresar");
        btnAtras.setFont(new Font("Arial", Font.BOLD, 20));
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setBackground(new Color(255, 144, 144));
        btnAtras.setBorder(new LineBorder(Color.BLACK, 2));
        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	ArrayList<JPanel>lst = vent.getPanelLst();
            	JPanel panel = lst.get(lst.size()-1);
            	vent.delElement(lst.size()-1);
            	
            	vent.nuevoCentroReg(panel);
            }
        });
        add(btnAtras);
		
    }
    
    public String[] fechaReserva()
    {
    	JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("Fecha de recogida (DD/MM/YYYY) : "));
        JTextField fechaRecogidaField = new JTextField();
        panel.add(fechaRecogidaField);

        panel.add(new JLabel("Fecha de entrega (DD/MM/YYYY) : "));
        JTextField fechaEntregaField = new JTextField();
        panel.add(fechaEntregaField);

        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Fechas de recogida y entrega", JOptionPane.OK_CANCEL_OPTION);

        
        if (opcion == JOptionPane.OK_OPTION) {
            
        	String fechaRecogidaStr = fechaRecogidaField.getText();
            String fechaEntregaStr = fechaEntregaField.getText();

        
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            try {
            	
                fechaRecogida = formatoFecha.parse(fechaRecogidaStr);
                fechaEntrega = formatoFecha.parse(fechaEntregaStr);

                
                
            } catch (ParseException e) 
            {
            	JOptionPane.showMessageDialog(null, "Error, debe llenar todos los campos y poner las fechas en formato (dd/MM/yyyy) ", "CarRental", JOptionPane.OK_CANCEL_OPTION);
            	fechaReserva();
            }
        } else {
        	
        }
        
        String fechaEntregaStr = null;
		String[] fechas = {fechaEntregaStr};
        return fechas;
    }
    
    public void horaReserva()
    {
    	JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("Hora de recogida (HH:mm):"));
        JTextField horaRecogidaField = new JTextField();
        panel.add(horaRecogidaField);

        panel.add(new JLabel("Hora de entrega (HH:mm):"));
        JTextField horaEntregaField = new JTextField();
        panel.add(horaEntregaField);

        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Horas de recogida y entrega", JOptionPane.OK_CANCEL_OPTION);

        
        if (opcion == JOptionPane.OK_OPTION) {
            
            String horaRecogidaStr = horaRecogidaField.getText();
            String horaEntregaStr = horaEntregaField.getText();

        
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
            try {
            	
                horaRecogida = formatoHora.parse(horaRecogidaStr);
                horaEntrega = formatoHora.parse(horaEntregaStr);

                                
            } catch (ParseException e) 
            {
            	JOptionPane.showMessageDialog(null, "Error, debe llenar todos los campos y poner las horas en formato (HH:MM)", "CarRental", JOptionPane.OK_CANCEL_OPTION);
            	horaReserva();
            }
        }else {
        	
        }
    
    }
    private void crearReserva() 
    {
    	ArrayList<Seguro> lstSeguros = new ArrayList<Seguro>();
    	ArrayList<ConductorAdicional> lstConduct = new ArrayList<ConductorAdicional>();
    	SimpleDateFormat formatoFechaHora = new SimpleDateFormat("HH:mm");
    	String horaRecogidaStr = formatoFechaHora.format(horaRecogida);
    	String horaEntregaStr = formatoFechaHora.format(horaEntrega);
    	
    	int asam = Integer.parseInt(vent.getIdReservas()) + 1;
    	cliente.crearReserva(false, sedeEntrega, sedeRecogida, fechaRecogida, horaRecogidaStr, fechaEntrega, horaEntregaStr, cliente, lstSeguros, 0, lstConduct, 0, Integer.toString(asam), veh);
   
    }
    private Vehiculo verDisponibilidad(String sedeEntrega,int idCat,Date fechaEntrega,Date fechaRecogida) 
    {
    	return cliente.verDisponibilidad(sedeEntrega, idCategoria, fechaEntrega, fechaRecogida);
    }
    
    
}