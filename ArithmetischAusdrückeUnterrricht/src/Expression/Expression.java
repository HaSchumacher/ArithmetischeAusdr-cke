package Expression;

import Parser.SymbolParserException;
import View_and_Controller.TreeVisitor;
import symbols.Symbol;

public interface Expression {
	
	public void accept(TreeVisitor v );
	public Integer evaluate() throws SymbolParserException;
	public Expression getcontent1();
	public Expression getcontent2();
	public Symbol getop();
	
}
