package Parser;

import java.util.List;

import Expression.Expression;
import symbols.Symbol;

public abstract class SymbolParser {
	private List<Symbol> symbolList;
	
		
	public Expression toExpression(List<Symbol> symbolList) {
	return null;
}
	public void skip() {
		/*löscht das erste Symbol aus der Liste*/
		try {
			symbolList.remove(0);
		} catch (IndexOutOfBoundsException exception)
		{return;}
		}
	public List<Symbol> getList() {
		return this.symbolList;
	}
	public List<Symbol> setList(List<Symbol> symbols) {
		return this.symbolList = symbols;
	}

}
