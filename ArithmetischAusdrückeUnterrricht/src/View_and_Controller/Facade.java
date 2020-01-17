package View_and_Controller;

import javax.swing.tree.DefaultTreeModel;

import Expression.Expression;
import Parser.ExpressionParserProxy;
import Parser.SymbolParser;
import Parser.SymbolParserException;
import scanner.Scanner;
/**
 * Represents main use case of Arithmetic-Expression-Application
 */
public class Facade extends Observable{
/**
 * Compiles the <userEnteredExpression> into syntax tree
 * Throws Exception, if syntax is incorrect
 */
	private String userEnteredExpression;
	private Expression expr;
	private Integer evaluatetexpr;
	public Expression getExpr() {
		return expr;
	}

	public void setExpr(Expression expr) {
		this.expr = expr;
	}
	public Facade () {
		setUserEnteredExpression("");
		setEvaluatetexpr(0);
	}
	public Expression createExpression(String userEnteredExpression) throws SymbolParserException{
		Scanner scanner = new Scanner();
		SymbolParser parser = new ExpressionParserProxy();
		this.setUserEnteredExpression(userEnteredExpression);
		this.expr = parser.toExpression(scanner.toSymbolSequence(userEnteredExpression));
		this.notifyObservers();
		return this.expr;
	}
/**
 * Compiles the <userEnteredExpression> into syntax tree and evaluates
 * Throws Exception, if syntax is incorrect or evaluation failed
 */	
	public Integer evaluateExpression(String userEnteredExpression) throws SymbolParserException {
		setEvaluatetexpr(this.expr.evaluate());
		notifyevalObservers(0);
		return this.getEvaluatetexpr();
	}
		
	public DefaultTreeModel createExpressionTree( Expression expr) {
		return new DefaultTreeModel(new TreeVisitor().buildtree(expr)); 
		}
	public String getUserEnteredExpression() {
		return userEnteredExpression;
	}
	public void setUserEnteredExpression(String userEnteredExpression) {
		this.userEnteredExpression = userEnteredExpression;
	}

	public Integer getEvaluatetexpr() {
		return evaluatetexpr;
	}

	public void setEvaluatetexpr(Integer evaluatetexpr) {
		this.evaluatetexpr = evaluatetexpr;
	}
	
}
