package Parser;

import java.util.List;
import Expression.Summe;

import Expression.Expression;
import Expression.Subtrahend;
import symbols.BracketClose;
import symbols.DivOp;
import symbols.MinOp;
import symbols.MultOp;
import symbols.PlusOp;
import symbols.Symbol;

public class MinuendVisitor extends SymbolVisitor {

	public MinuendVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
		// TODO Auto-generated constructor stub
	}
	public void handle(PlusOp plusop) throws SymbolParserException {
		super.skip();
		super.setExpr(new Summe((Subtrahend) super.getExpr(), new MinuendParser().toExpression(super.getSymbols())));
	}
	public void handle(MinOp minop) throws SymbolParserException {
		
	}
	public void handle(MultOp mop) throws SymbolParserException {
		
	}
	public void handle(DivOp divop) throws SymbolParserException {
	
	}
	public void handle (BracketClose brc)throws SymbolParserException {
		if (FactorVisitor.bracketuse == 0 ) throw new SymbolParserException("Brackte Close is missing");
	}

}
