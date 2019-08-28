package Parser;

import java.util.List;

import Expression.Expression;
import symbols.BracketClose;
import symbols.BracketOpen;
import symbols.NaturalNumber;
import symbols.Symbol;

public class FactorVisitor extends SymbolVisitor {
	
	public FactorVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
	}
	
	@Override
	public void handle(NaturalNumber number) {
		super.skip();
		super.setExpr(number);
	}
	@Override
	public
	void handle (BracketOpen bro) {
		super.skip();
		super.setExpr(new ExpressionParser().toExpression(super.getSymbols()));
		this.checkofBracketclose();
		}

	private void checkofBracketclose() {
		if (super.getSymbols().get(0) instanceof BracketClose)  
			super.skip();
		}
		
	}
	


