package Parser;

import Expression.Expression;
import symbols.BracketClose;
import symbols.BracketOpen;
import symbols.ErrorToken;
import symbols.MultOp;
import symbols.NaturalNumber;
import symbols.PlusOp;

public abstract class SymbolVisitor {
	private Expression expr;
	
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
	
	
}
