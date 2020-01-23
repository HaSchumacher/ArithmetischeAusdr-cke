package View_and_Controller;

import java.awt.event.ActionEvent;

import javax.swing.tree.DefaultMutableTreeNode;
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
		this.theView.disableEvalButton();
		
	}
		
	public void onEvluationButtonPressed(ActionEvent arg0) {
		try {
			this.theView.setValue(this.facade.evaluateExpression(this.theView.getInput()).toString());
			this.theView.setMessage(arg0.getActionCommand() + ": " + this.syntaxok);
			this.facade.setState(new uncheckedState());
		} catch(SymbolParserException e) {
			this.facade.excnotify(e);
			this.facade.setState(new uncheckedState());
			
		}
	}
		
	public void onCheckSyntaxButtonPressed() {
		try {
			this.facade.setUserEnteredExpression(this.theView.getInput());
			Expression expr = this.facade.createExpression(this.theView.getInput());
			DefaultTreeModel node_model = this.facade.createExpressionTree(expr);
			this.theView.setTree(node_model);
			this.theView.setMessage(this.syntaxok);
			this.facade.setState(new checkedState());
			
		} catch (SymbolParserException e) {
			this.facade.setState(new uncheckedState());
			this.facade.excnotify(e);
		}
	}

	private void errorHandling(Exception exception) {
		this.theView.setValue("");
		this.theView.setMessage(exception.getMessage());
		this.facade.setState(new uncheckedState());
	}

	@Override
	public void update() {
		this.theView.setInput(this.facade.getUserEnteredExpression());
		this.theView.setTree(this.facade.createExpressionTree(this.facade.getExpr()));
		this.theView.setMessage(syntaxok);
		this.facade.setState(new checkedState());
		this.updateeval();
		
	}

	public void update(Integer a) {
		this.update();
		this.theView.setValue(this.facade.getEvaluatetexpr().toString());
		this.facade.setState(new uncheckedState());
		this.updateeval();
		
	}

	@Override
	public void update(Exception e) {
		this.updateeval();
		this.theView.setInput(this.facade.getUserEnteredExpression());
		this.errorHandling(e);			
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Expression");
		DefaultTreeModel tree = new DefaultTreeModel(root);
		this.theView.setTree(tree);
	}

	public void updateeval() {
		if ( this.facade.getState().checked()) {
			this.theView.enableEvalButton();
		}
		else {
			this.theView.disableEvalButton();
		}
	}
}
