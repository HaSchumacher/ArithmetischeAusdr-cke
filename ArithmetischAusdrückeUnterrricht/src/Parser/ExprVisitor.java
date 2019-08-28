package Parser;

import Expression.Summe;
import symbols.BracketOpen;
import symbols.NaturalNumber;
import symbols.PlusOp;

public class ExprVisitor extends SymbolVisitor {
	private ExpressionParser expressionparser;
	
	public ExprVisitor(ExpressionParser expressionParser) {
	super();
	this.expressionparser = expressionParser;
	}
	
	
	public void handle(NaturalNumber number) {
		expressionparser.skip();
		
		if (this.expressionparser.getList().isEmpty()) {
			super.setExpr(number);
			return;
		}
		if(this.expressionparser.getList().get(0) == PlusOp.getInstance()) {
			this.expressionparser.skip();
			super.setExpr(new Summe(new ExpressionParser().toExpression(this.expressionparser.getList()), number));}
		else {
			this.expressionparser.getList().add(0, number);
			super.setExpr(new SummenParser().toExpression(this.expressionparser.getList()));
		}
	}
	public void handle(BracketOpen bro) {
		super.setExpr(new SummenParser().toExpression(this.expressionparser.getList()));
	}
}
