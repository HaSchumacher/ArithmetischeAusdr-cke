package Parser;

import java.util.List;

import Expression.Div;

import Expression.Expression;
import Expression.Produkt;
import symbols.BracketClose;
import symbols.DivOp;
import symbols.MinOp;
import symbols.MultOp;
import symbols.PlusOp;
import symbols.Symbol;

public class SummandVisitor extends SymbolVisitor {
	
	public SummandVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
		}

	public void handle(MultOp multop) throws SymbolParserException{
		super.skip();
		
			//super.setExpr(new Produkt(super.getExpr(), new SummenParser().toExpression(super.getSymbols())));
			super.setExpr(new Produkt(new SummenParser().toExpression(super.getSymbols()), super.getExpr()));
	}
	
	public void handle(DivOp div) throws SymbolParserException{
		super.skip();
		super.setExpr(new Div(new SummenParser().toExpression(super.getSymbols()), super.getExpr()));
		
	}
	public void handle(PlusOp plusop) throws SymbolParserException{}
	public void handle(MinOp minusop) throws SymbolParserException{}
	@Override
	public void handle(BracketClose brc) throws SymbolParserException {
		if (FactorVisitor.bracketuse != 0) {}
		else throw new SymbolParserException("Syntax wrong no open Bracket detected!");
	}
	

}
