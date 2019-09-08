package Parser;

import java.util.List;
import Expression.Division;
import Expression.Expression;
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

	public void handle(DivOp divop) throws SymbolParserException{
		super.skip();
		//super.setExpr(new Produkt(super.getExpr(), new SummenParser().toExpression(super.getSymbols())));
		super.setExpr(new Division(super.getExpr(), new SummenParser().toExpression(super.getSymbols())));
	}
	public void handle(MultOp multop) throws SymbolParserException{}
	
	public void handle(PlusOp plusop) throws SymbolParserException{}
	public void handle(MinOp minusop) throws SymbolParserException{}
	public void handle(BracketClose brc ) throws SymbolParserException{
		if (FactorVisitor.bracketuse == 0 ) throw new SymbolParserException("Brackte Close is missing");
	}
	
}
