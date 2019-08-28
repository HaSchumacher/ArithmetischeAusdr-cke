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
		this.symbols.remove(0);
	}
	
	public void handle(EndofInput endofInput) {
	}; // end the Input of Symbollist!
	public void handle(BracketClose bracketClose) {
	} //throws Exception { new Exception("klammer zu");};
	public void handle(BracketOpen bracketOpen) {
	}// throws Exception { new Exception("klammer auf");};
	public void handle(NaturalNumber naturalNumber) {
	}// throws Exception { new Exception("keine Zahl");};
	public void handle(ErrorToken errorToken) {
	}// throws Exception { new Exception("Fehler detected");};
	public void handle(MultOp multOp) {
	} //throws Exception { new Exception("Multi OP");};
	public void handle(PlusOp plusOp) {
	} //throws Exception { new Exception("Plus OP");};
	
	
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
	
