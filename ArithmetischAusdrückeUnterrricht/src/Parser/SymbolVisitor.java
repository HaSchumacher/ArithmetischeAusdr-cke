package Parser;

import java.util.List;

import Expression.Expression;
import symbols.BracketClose;
import symbols.BracketOpen;
import symbols.EndofInput;
import symbols.ErrorToken;
import symbols.MultOp;
import symbols.NaturalNumber;
import symbols.PlusOp;
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
	public void handle(BracketClose bracketClose) throws SymbolParserException{
	}
	public void handle(BracketOpen bracketOpen) throws SymbolParserException{
	}
	public void handle(NaturalNumber naturalNumber) throws SymbolParserException{
	}
	public void handle(ErrorToken errorToken) throws SymbolParserException{
	}
	public void handle(MultOp multOp) throws SymbolParserException {
	} //throws Exception { new Exception("Multi OP");};
	public void handle(PlusOp plusOp) throws SymbolParserException{
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
	
