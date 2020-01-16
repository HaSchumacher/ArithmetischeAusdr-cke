package Parser;

import java.util.List;

import Expression.Expression;
import symbols.BracketClose;
import symbols.BracketOpen;
import symbols.DivOp;
import symbols.EndofInput;
import symbols.ErrorToken;
import symbols.MultOp;
import symbols.NaturalNumber;
import symbols.PlusOp;
import symbols.MinOp;
import symbols.Symbol;

public abstract class SymbolVisitor {
	private Expression expr;
	private List<Symbol> symbols;
		
	public SymbolVisitor( Expression expr, List<Symbol> symbols) {
		super();
		this.expr = expr;
		this.symbols = symbols;
	}
	
		
	public void skip() {
		try {
			this.symbols.remove(0);
		} catch (IndexOutOfBoundsException e) {
		}
	}
		
	public void handle(EndofInput endofInput)throws SymbolParserException{
		return;} // Terminiert Auswertung durch Symbol! 
	
	public void handle(BracketOpen bro) throws SymbolParserException{
		throw new SymbolParserException("Found Bracket Expression without Expression inside");
	}
	public void handle(BracketClose bracketClose) throws SymbolParserException{
		if (FactorVisitor.bracketuse != 0 )
		{throw new SymbolParserException("Found a Bracket Expression without input but expected Expression inside");}
		else {
		throw new SymbolParserException("Found Bracket Close but expected Open Bracket before"); 
		}
	}
	public void handle(NaturalNumber naturalNumber) throws SymbolParserException{
		throw new SymbolParserException("Found Numbers without Operators");
		}
	public void handle(ErrorToken errorToken) throws SymbolParserException{
		throw new SymbolParserException("Scanner could not scan:" + errorToken.getErr());
		}
	public void handle(MultOp multOp) throws SymbolParserException {
		throw new SymbolParserException("Found Mult Operator but expected Number before Operator");
	}
	public void handle(PlusOp plusOp) throws SymbolParserException{
		throw new SymbolParserException("Found Plus Operator but expected Number before Operator");
		}
	public void handle(MinOp subtraction)throws SymbolParserException{
		throw new SymbolParserException("Found Min Operator but expected Number before Operator");
	}
	public void handle(DivOp division)throws SymbolParserException{
		throw new SymbolParserException("Found Div Operator but expected Number before Operator");
	}
	
	// Getter und Setter für Attribute des SymbolVisitors
	public Expression getExpr() {
		return expr;
	}
	public void setExpr(Expression expr) {
		this.expr = expr;
	}
	
	public List<Symbol> getSymbols() {
		return symbols;
	}
	public void setSymbols(List<Symbol> symbols) {
		this.symbols = symbols;
	}
}
	
