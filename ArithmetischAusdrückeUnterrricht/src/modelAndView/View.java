package modelAndView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exception.CalculationException;
import parser.exception.ParserException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Von Window Builder generierte Klasse 
 * TODO: Konstruktor Code muss in weitere Methoden dekomponiert werden, siehe
 * Methoden getTextFieldInput(), getBtnEvaluateButton()  
 */
public class View extends JFrame {
	private Facade facade;
	
/*================= Generierter Code ============== */	
	private JPanel contentPane;
	private JTextField textField_Input;
	private JTextField textField_Value;
	private JTextField textField_Message;
	private JButton btnEvaluateButton;

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
		this.facade = new Facade();
		
		setTitle("Bearbeitung arithmetischer Ausdruecke");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAusdruck = new JLabel("Ausdruck");
		lblAusdruck.setBounds(5, 5, 414, 26);
		contentPane.add(lblAusdruck);

		contentPane.add(this.getTextField_Input()); // Dekomposition!!
		contentPane.add(this.getBtnEvaluateButton()); // "
		
		JLabel lblWert = new JLabel("Wert");
		lblWert.setBounds(5, 100, 92, 26);
		contentPane.add(lblWert);
		
		textField_Value = new JTextField();
		textField_Value.setEditable(false);
		textField_Value.setBounds(133, 94, 286, 32);
		contentPane.add(textField_Value);
		textField_Value.setColumns(10);
		
		textField_Message = new JTextField();
		textField_Message.setEditable(false);
		textField_Message.setBounds(5, 176, 414, 32);
		contentPane.add(textField_Message);
		textField_Message.setColumns(10);
	}
	
	private Component getBtnEvaluateButton() {
		if(this.btnEvaluateButton==null) {
			this.btnEvaluateButton = new JButton("Auswerten");
			btnEvaluateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Integer value = facade.evaluateExpression(textField_Input.getText());
						textField_Value.setText(value.toString());
						textField_Message.setText("Syntax OK");
					}catch(ParserException | CalculationException e) {
						textField_Value.setText("");
						textField_Message.setText(e.getMessage());
					}
				}
			});
			btnEvaluateButton.setBounds(5, 47, 288, 35);
			btnEvaluateButton.setToolTipText("Hier wertet man den eingegebenen Ausdruck aus!");
		}
		return this.btnEvaluateButton;
	}

	//========== Dekomposition !! =================== 	
	private JTextField getTextField_Input(){
		if(textField_Input==null) {
			textField_Input = new JTextField();
			textField_Input.setBounds(131, 2, 288, 32);
			textField_Input.setColumns(10);
			textField_Input.setToolTipText("Hier bitte Ausdruck eingeben!");
		}
		return this.textField_Input;
	}
}
