package View_and_Controller;

import java.awt.event.ActionEvent;

import Parser.SymbolParserException;

public class Controller {
	private final String syntaxok = "Syntax OK";
	private View theView;
	private Facade facade;
	public Controller(View theView, Facade facade) {
		
		this.theView = theView;
		this.facade = facade;
		
// Die folgenden zwei Zeilen 		
//		EvaluationListener eL = new EvaluationListener(this);
//		this.theView.getBtnEvaluateButton().addActionListener(eL);
// 		mit einer Klasse 
//		EvaluationListener implements ActionListener{
//			private Controller c;
// 			public EvaluationListener(Controller c){this.c = c;}		
//			public void actionPerformed(ActionEvent e){controller.onEvaluationButtonPressed(e)}
//		}
// haben die gleiche Wirkung wie 
		this.theView.getBtnEvaluateButton().addActionListener((e) -> this.onEvluationButtonPressed1(e));
		
// Analog:		
//		CheckSyntaxListener cSL = new CheckSyntaxListener(this);
//		this.theView.getBtnCheckSyntaxButton().addActionListener(cSL);
// 		mit entsprechender Klasse CheckSyntaxListener
		this.theView.getBtnCheckSyntaxButton().addActionListener((e) -> this.onCheckSyntaxButtonPressed());
	}
		
	public void onEvluationButtonPressed1(ActionEvent arg0) {
		try {
			this.theView.setValue(this.facade.evaluateExpression(this.theView.getInput()).toString());
			this.theView.setMessage(arg0.getActionCommand() + ": " + this.syntaxok);
		} catch(SymbolParserException e) {
			this.errorHandling(e);
		}
	}
		
	public void onCheckSyntaxButtonPressed() {
		try {
			this.facade.createExpression(this.theView.getInput());
			this.theView.setMessage(this.syntaxok);
		} catch (SymbolParserException e) {
			this.errorHandling(e);
		}
	}

	private void errorHandling(Exception exception) {
		this.theView.setValue("");
		this.theView.setMessage(exception.getMessage());
	}

	
	

}
