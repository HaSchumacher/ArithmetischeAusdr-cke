package Parser;

import java.util.List;
import Expression.Differenz;

import Expression.Expression;
import Expression.Subtrahend;
import symbols.BracketClose;
import symbols.MinOp;
import symbols.PlusOp;
import symbols.Symbol;

public class ExprVisitor extends SymbolVisitor {
	
	public ExprVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
		}
	@Override
	public void handle(MinOp minop) throws SymbolParserException {
		super.skip();
		//super.setExpr(new Summe(super.getExpr(), new ExpressionParser().toExpression(super.getSymbols())));
		super.setExpr( new Differenz((Subtrahend) new ExpressionParser().toExpression(super.getSymbols()), super.getExpr()));
	}
	public void handle(PlusOp plusop) throws SymbolParserException {
		
	}
	public void handle (BracketClose brc) throws SymbolParserException{
		if (FactorVisitor.bracketuse == 0 ) throw new SymbolParserException("Brackte Close is missing");
	}
	
}
