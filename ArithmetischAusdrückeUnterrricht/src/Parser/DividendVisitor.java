package Parser;

import java.util.List;
import Expression.Produkt;

import Expression.Expression;
import Expression.Divident;
import symbols.BracketClose;
import symbols.DivOp;
import symbols.MinOp;
import symbols.MultOp;
import symbols.PlusOp;
import symbols.Symbol;

public class DividendVisitor extends SymbolVisitor {

	public DividendVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
	}
	
	public void handle(MultOp multop) throws SymbolParserException {
		super.skip();
		super.setExpr(new Produkt(super.getExpr(), (Divident) new DividendParser().toExpression(super.getSymbols())));
	}
	public void handle(PlusOp plusop)throws SymbolParserException {
		
	}
	public void handle(MinOp minop)throws SymbolParserException {
		
	}
	
	public void handle(DivOp divop)throws SymbolParserException {
	
	}
	public void handle(BracketClose brc) throws SymbolParserException {	
		if (FactorVisitor.bracketuse == 0 ) throw new SymbolParserException("Brackte Close is missing");}


}
