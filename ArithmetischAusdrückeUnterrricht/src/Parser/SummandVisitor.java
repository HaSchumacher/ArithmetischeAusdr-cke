package Parser;

import java.util.List;

import Expression.Expression;
import Expression.Produkt;
import symbols.BracketClose;
import symbols.MultOp;
import symbols.PlusOp;
import symbols.Symbol;

public class SummandVisitor extends SymbolVisitor {
	
	public SummandVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
		}

	public void handle(MultOp multop) throws SymbolParserException{
		super.skip();
		try {
			super.setExpr(new Produkt(super.getExpr(), new SummenParser().toExpression(super.getSymbols())));
		} catch (Exception e) {}
		
	}
	
	public void handle(PlusOp plusop) throws SymbolParserException{}
	@Override
	public void handle(BracketClose brc) throws SymbolParserException {}
	

}
