package Parser;

import java.util.List;

import Expression.BracketExpression;
import Expression.Expression;
import scanner.BracketState;
import symbols.BracketClose;
import symbols.BracketOpen;
import symbols.NaturalNumber;
import symbols.Symbol;

public class FactorVisitor extends SymbolVisitor {
	
	public FactorVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
	}
	
	@Override
	public void handle(NaturalNumber number) throws SymbolParserException{
		super.skip();
		super.setExpr(number);
	}
	@Override
	public
	void handle (BracketOpen bro) throws SymbolParserException{
		super.skip();
		super.setExpr(new BracketExpression(new ExpressionParser().toExpression(super.getSymbols())));
		this.checkofBracketclose();
		}

	private void checkofBracketclose() throws SymbolParserException{
		if (super.getSymbols().get(0) instanceof BracketClose)  
			super.skip();
		else throw new SymbolParserException("Syntax wrong");
		
	}
	}
	


