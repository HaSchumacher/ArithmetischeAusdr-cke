package View_and_Controller;

import javax.swing.tree.DefaultMutableTreeNode;

import Expression.BracketExpression;
import Expression.Expression;
import basic.OpTable;
import basic.TextConstants;
import symbols.NaturalNumber;

public class TreeVisitor {
	private DefaultMutableTreeNode node;

	public DefaultMutableTreeNode buildtree(Expression expr) {
		expr.accept(this);
		return this.node;
	}

	public void handle(Expression expr) {
		
		DefaultMutableTreeNode Exprrep = new DefaultMutableTreeNode(expr.toString());
		DefaultMutableTreeNode content1 = new TreeVisitor().buildtree(expr.getcontent1());
		DefaultMutableTreeNode operator = new DefaultMutableTreeNode(OpTable.getStringRepresentation(expr.getop()));
		DefaultMutableTreeNode content2 = new TreeVisitor().buildtree(expr.getcontent2());
		
		this.node = Exprrep;
		this.node.add(content2);
		this.node.add(operator);
		this.node.add(content1);
	}
	
	public void handle(BracketExpression bracketExpression) {
		DefaultMutableTreeNode brexpr = new DefaultMutableTreeNode("Klammerausdruck");
		DefaultMutableTreeNode bracketExpr = new TreeVisitor().buildtree(bracketExpression.getExpr());
		
		this.node = brexpr;
		this.node.add(bracketExpr);
				
	}
	public void handle(NaturalNumber naturalNumber) {		
		DefaultMutableTreeNode number = new DefaultMutableTreeNode(naturalNumber);
		this.node = number;
	}

}
