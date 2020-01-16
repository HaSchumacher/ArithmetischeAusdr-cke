package Parser;

import java.util.List;

import Expression.Expression;
import Expression.Substraction;
import Expression.Summe;
import symbols.BracketClose;
import symbols.PlusOp;
import symbols.MinOp;
import symbols.Symbol;

public class ExprVisitor extends SymbolVisitor {
	
	public ExprVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
		}
	@Override
	public void handle(PlusOp plusop) throws SymbolParserException {
		super.skip();
		//super.setExpr(new Summe(super.getExpr(), new ExpressionParser().toExpression(super.getSymbols())));
		super.setExpr( new Summe(new ExpressionParser().toExpression(super.getSymbols()), super.getExpr()));
	}
	public void handle(MinOp subop) throws SymbolParserException {
		super.skip();
		super.setExpr(new Substraction(new ExpressionParser().toExpression(super.getSymbols()), super.getExpr()));
	}
	public void handle(BracketClose brc) throws SymbolParserException {
		if (FactorVisitor.bracketuse != 0) {}
		else throw new SymbolParserException("Found Close Bracket but expected an Open Bracket before");
	}
	
	

}
