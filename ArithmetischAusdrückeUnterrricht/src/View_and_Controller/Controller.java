package View_and_Controller;

import java.awt.event.ActionEvent;

import javax.swing.tree.DefaultTreeModel;
import Expression.Expression;
import Parser.SymbolParserException;

public class Controller implements Observer {
	private final String syntaxok = "Syntax OK";
	private View theView;
	private Facade facade;
	public Controller(View theView, Facade facade) {
		
		this.theView = theView;
		this.facade = facade;
		
		this.theView.getBtnEvaluateButton().addActionListener((e) -> this.onEvluationButtonPressed(e));
		this.theView.getBtnCheckSyntaxButton().addActionListener((e) -> this.onCheckSyntaxButtonPressed());
		
	}
		
	public void onEvluationButtonPressed(ActionEvent arg0) {
		try {
			this.theView.setValue(this.facade.evaluateExpression(this.theView.getInput()).toString());
			this.theView.setMessage(arg0.getActionCommand() + ": " + this.syntaxok);
		} catch(SymbolParserException e) {
			this.facade.excnotify(e);
		}
	}
		
	public void onCheckSyntaxButtonPressed() {
		try {
			this.facade.setUserEnteredExpression(this.theView.getInput());
			Expression expr = this.facade.createExpression(this.theView.getInput());
			DefaultTreeModel node_model = this.facade.createExpressionTree(expr);
			this.theView.setTree(node_model);
			this.theView.setMessage(this.syntaxok);
		} catch (SymbolParserException e) {
			this.facade.excnotify(e);
		}
	}

	private void errorHandling(Exception exception) {
		this.theView.setValue("");
		this.theView.setMessage(exception.getMessage());
	}

	@Override
	public void update() {
		this.theView.setInput(this.facade.getUserEnteredExpression());
		this.theView.setTree(this.facade.createExpressionTree(this.facade.getExpr()));
		this.theView.setMessage(syntaxok);
	}

	public void update(Integer a) {
		this.update();
		this.theView.setValue(this.facade.getEvaluatetexpr().toString());
		
	}

	@Override
	public void update(Exception e) {
		this.theView.setInput(this.facade.getUserEnteredExpression());
		this.errorHandling(e);			
	}


}
