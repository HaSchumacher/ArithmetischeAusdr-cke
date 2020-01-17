package View_and_Controller;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JScrollPane;

/**
 * Von Window Builder generierte Klasse 
 */
public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Input;
	private JTextField textField_Value;
	private JTextField textField_Message;
	private JButton btnEvaluateButton;
	private JButton btnCheckSyntax;
	private JScrollPane scrollPane;
	private JTree tree;
	/**
	 * Create the frame.
	 */
	public View() {
		this.initialize();
		this.getTheContentPane();
		getTheContentPane().add(getScrollPane());
		this.contentPane.add(this.getTextField_Input());
		this.contentPane.add(this.getTextField_Value());
		this.contentPane.add(this.getTextField_Message());
		this.contentPane.add(this.getBtnEvaluateButton());
		this.contentPane.add(this.getBtnCheckSyntaxButton());
	}
	
	private void initialize() {
		this.setTitle("Expression Workbench");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setBounds(300, 300, 800, 350);		
	}
	
// ============== Evaluate und CheckSyntax Button ============================
// ========= Sichtbar für andere Klassen im Paket ============
	JButton getBtnEvaluateButton() {
		if(this.btnEvaluateButton==null) {
			this.btnEvaluateButton = new JButton("Evaluate");
			this.btnEvaluateButton.setBounds(12, 150, 407, 47);
			this.btnEvaluateButton.setToolTipText("Hier wertet man den eingegebenen Ausdruck aus!");
		}
		return this.btnEvaluateButton;
	}
	
	JButton getBtnCheckSyntaxButton() {
		if(this.btnCheckSyntax == null) {
			this.btnCheckSyntax = new JButton("Check Syntax");
			this.btnCheckSyntax.setBounds(12, 90, 407, 47);
			this.contentPane.add(btnCheckSyntax);
		}
		return this.btnCheckSyntax;
	}

// ============== Field Access Methods ======================================	
	String getInput() {
		return this.textField_Input.getText();
	}
	
	void setInput(String update) {
		this.textField_Input.setText(update);
	}
	void setValue(String s) {
		this.textField_Value.setText(s);
	}
	void setMessage(String s) {
		this.textField_Message.setText(s);
	}
	public JTree getTree() {
		return tree;
	}
	
// ===================== More private UI Elements =======================
	private JPanel getTheContentPane() {
		if(this.contentPane == null) {
			this.contentPane = new JPanel();
			this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			this.setContentPane(contentPane);
			this.contentPane.setLayout(null);
			
			JLabel lblExpression = new JLabel("Expression");
			lblExpression.setBounds(12, 33, 73, 32);
			this.contentPane.add(lblExpression);
			
			JLabel lblValue = new JLabel("Value");
			lblValue.setBounds(12, 219, 37, 26);
			this.contentPane.add(lblValue);
		}
		return this.contentPane;
	}
	
	private JTextField getTextField_Input() {
		if(this.textField_Input==null) {
			this.textField_Input = new JTextField();
			this.textField_Input.setBounds(93, 33, 326, 32);
			this.textField_Input.setColumns(10);
			this.textField_Input.setToolTipText("Hier bitte Ausdruck eingeben!");
		}
		return this.textField_Input;
	}
	
	private JTextField getTextField_Value() {
		if(this.textField_Value==null) {
			this.textField_Value = new JTextField();
			this.textField_Value.setEditable(false);
			this.textField_Value.setBounds(93, 216, 326, 32);
			this.textField_Value.setColumns(10);
		}
		return this.textField_Value;
	}
	
	private JTextField getTextField_Message() {
		if(this.textField_Message==null) {
			this.textField_Message = new JTextField();
			this.textField_Message.setEditable(false);
			this.textField_Message.setBounds(12, 258, 758, 32);
			this.textField_Message.setColumns(10);
		}
		return this.textField_Message;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
			scrollPane.setBounds(440, 33, 330, 213);
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression");
			this.tree = new JTree(root);
			this.scrollPane.setViewportView(tree);
			
		}
		return scrollPane;
		}


	public void setTree(DefaultTreeModel tree_model) {
		this.tree.setModel(tree_model);
		this.scrollPane.setViewportView(tree);
	}

	
}
