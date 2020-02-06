import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {

	private JFrame frame;
	//Se crea una pila
	private IStack<String> expresion; 
	//Se crea una calculadora
	private ICalculadora calculadora; 
	
	private JScrollPane scrollPane;
	private JTable tablaResultados;
	private ArrayList<String> respuestas;
	private String[] cadena = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		respuestas = new ArrayList<String>();
		
		expresion = new StackVector<String>();
		calculadora = new Calculadora();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_5568255706808");
		panel.setLayout(null);
		
		JButton btnElegirArchivo = new JButton("Elegir Archivo");
		btnElegirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadena = ArchivoTXT.leerTXT(ArchivoTXT.getPath());
					
					
					for (String j: cadena) {
						//calculadora.fillStack(j);
						//calculadora.doOperation();
						//respuestas.add(""+calculadora.getResult());
						
					}
					
					JOptionPane.showMessageDialog(null, "Se leyo el archivo con exito");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Hubo un error leyendo el archivo");
				}
				
			}
		});
		btnElegirArchivo.setBounds(146, 35, 131, 29);
		panel.add(btnElegirArchivo);
		
		JButton btnMostrarResultado = new JButton("Mostrar Resultado");
		btnMostrarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnCount(2);
				model.setColumnIdentifiers(new String[] {"Operacion","Resultado"});
				model.setRowCount(cadena.length);
				
				for (int i = 0;i<= cadena.length  -1;i++) {
					model.setValueAt(cadena[i], i, 0);
					model.setValueAt(respuestas.get(i), i, 1);
				}
				
				tablaResultados = new JTable(model);
				scrollPane.setViewportView(tablaResultados);
				
				
			}
		});
		btnMostrarResultado.setBounds(138, 138, 151, 29);
		panel.add(btnMostrarResultado);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 202, 394, 129);
		panel.add(scrollPane);
		
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(2);
		model.setColumnIdentifiers(new String[] {"Operacion","Resultado"});
		
		tablaResultados = new JTable(model);
		scrollPane.setViewportView(tablaResultados);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBounds(28, 174, 95, 16);
		panel.add(lblResultados);
		frame.setBounds(100, 100, 451, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
