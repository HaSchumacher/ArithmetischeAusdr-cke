package modelandView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class View extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Eingabe;
	private JTextField Ausgabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setTitle("Bearbeiten Arithm..Ausdr\u00FCcke");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 534);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblAusdruck = new JLabel("Ausdruck");
		lblAusdruck.setBackground(Color.WHITE);
		contentPane.add(lblAusdruck);
		
		Eingabe = new JTextField();
		contentPane.add(Eingabe);
		Eingabe.setColumns(10);
		
		JButton Auswerten = new JButton("Auswerten");
		Auswerten.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(Auswerten);
		
		Ausgabe = new JTextField();
		Ausgabe.setText("Ausgabe");
		Ausgabe.setEditable(false);
		contentPane.add(Ausgabe);
		Ausgabe.setColumns(10);
	}

}
