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
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private Calculadora calc;
	private JLabel lblResultado; 

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
		calc = new Calculadora();
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
					calc.getPath();
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
				lblResultado.setText("Resultado: " + calc.getResult());
			}
		});
		btnMostrarResultado.setBounds(138, 138, 151, 29);
		panel.add(btnMostrarResultado);
		
		lblResultado = new JLabel("Resultado: ");
		lblResultado.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblResultado.setBounds(23, 212, 407, 48);
		panel.add(lblResultado);
		frame.setBounds(100, 100, 451, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
