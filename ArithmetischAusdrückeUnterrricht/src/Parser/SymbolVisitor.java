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
	public void handle(BracketClose bracketClose) throws SymbolParserException{
		throw new SymbolParserException("Bracket Close in wrong place");}
	public void handle(BracketOpen bracketOpen) throws SymbolParserException{
		throw new SymbolParserException("Bracket Open in wrong place");
	}
	public void handle(NaturalNumber naturalNumber) throws SymbolParserException{
		throw new SymbolParserException("Number in wrong place");
		}
	public void handle(ErrorToken errorToken) throws SymbolParserException{
		throw new SymbolParserException("Scanner could not scan:" + errorToken.getErr());
		}
	public void handle(MultOp multOp) throws SymbolParserException {
		throw new SymbolParserException("Multiplikations Operator in wrong place");
	}
	public void handle(PlusOp plusOp) throws SymbolParserException{
		throw new SymbolParserException("Plus Operator in wrong place");
		}
	public void handle(MinOp subtraction)throws SymbolParserException{
		throw new SymbolParserException("Substraction Operator in wrong place");
	}
	public void handle(DivOp division)throws SymbolParserException{
		throw new SymbolParserException("Division Operator in wrong place");
	};
	
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
	
