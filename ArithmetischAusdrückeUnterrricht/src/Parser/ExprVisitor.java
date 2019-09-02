package Parser;

import java.util.List;

import Expression.Expression;
import Expression.Substraction;
import Expression.Summe;
import symbols.BracketClose;
import symbols.PlusOp;
import symbols.Subtraction;
import symbols.Symbol;

public class ExprVisitor extends SymbolVisitor {
	
	public ExprVisitor(Expression expr, List<Symbol> symbols) {
		super(expr, symbols);
		}
	@Override
	public void handle(PlusOp plusop) throws SymbolParserException {
		super.skip();
		super.setExpr(new Summe(super.getExpr(), new ExpressionParser().toExpression(super.getSymbols())));
	}
	public void handle(Subtraction subop) throws SymbolParserException {
		super.skip();
		super.setExpr(new Substraction(super.getExpr(), new ExpressionParser().toExpression(super.getSymbols())));
	}
	public void handle(BracketClose brc) throws SymbolParserException {}
	
	}
