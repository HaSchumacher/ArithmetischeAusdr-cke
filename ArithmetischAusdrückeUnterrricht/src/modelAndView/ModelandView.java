package modelAndView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Parser.SymbolParserException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import java.awt.Color;
/**
 * Von Window Builder generierte Klasse 
 * TODO: Konstruktor Code muss in weitere Methoden dekomponiert werden, siehe
 * Methoden getTextFieldInput(), getBtnEvaluateButton()  
 */
public class ModelandView extends JFrame {
	private Facade facade;
	
/*================= Generierter Code ============== */	
	private JPanel contentPane;
	private JTextField textField_Input;
	private JTextField textField_Value;
	private JTextField textField_Message;
	private JButton btnEvaluateButton;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModelandView frame = new ModelandView();
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
	public ModelandView() {
		this.facade = new Facade();
		
		setTitle("Bearbeitung arithmetischer Ausdruecke");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 844, 418);
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
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBlockIncrement(0);
		scrollBar.setBackground(Color.GREEN);
		scrollBar.setBounds(793, 13, 21, 308);
		contentPane.add(scrollBar);
		
		tree = new JTree();
		tree.setToolTipText("Scrollbar for Tree?");
		tree.setSelectionRows(new int[] {1});
		tree.setSelectionRow(2);
		tree.setBounds(431, 10, 383, 311);
		contentPane.add(tree);
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
					}catch(SymbolParserException e) {
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
	public JTree getTree() {
		return tree;
	}
}
