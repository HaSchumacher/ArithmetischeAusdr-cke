package View_and_Controller;

import java.awt.event.ActionEvent;

import javax.swing.tree.DefaultTreeModel;
import Expression.Expression;
import Parser.SymbolParserException;

public class Controller {
	private final String syntaxok = "Syntax OK";
	private View theView;
	private Facade facade;
	public Controller(View theView, Facade facade) {
		
		this.theView = theView;
		this.facade = facade;
		
		this.theView.getBtnEvaluateButton().addActionListener((e) -> this.onEvluationButtonPressed1(e));
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
			Expression expr = this.facade.createExpression(this.theView.getInput());
			DefaultTreeModel node_model = this.facade.createExpressionTree(expr);
			this.theView.setTree(node_model);
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
