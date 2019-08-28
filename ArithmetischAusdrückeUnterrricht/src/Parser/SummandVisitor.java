package Parser;

import java.util.List;

import Expression.Expression;
import Expression.Produkt;
import symbols.BracketOpen;
import symbols.MultOp;
import symbols.NaturalNumber;
import symbols.Symbol;

public class SummandVisitor extends SymbolVisitor {
	
	public SummandVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
		}

	public void handle(MultOp multop) {
		super.skip();
		super.setExpr(new Produkt 
				(super.getExpr(), new SummenParser().toExpression(super.getSymbols())));
		
	}
	
	@Override
	public void handle(NaturalNumber number) {
	super.setExpr(new FactorParser().toExpression(super.getSymbols()));}

	@Override
	public void handle(BracketOpen bro) {
		super.setExpr(new FactorParser().toExpression(super.getSymbols()));}
	

}
