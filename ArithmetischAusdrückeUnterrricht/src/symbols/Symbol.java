package symbols;
import Parser.SymbolVisitor;
/**
 * From String Input extracted Symbols (e.g. Numbers, Operators, ...)
 */
public interface Symbol {
	public void accept (SymbolVisitor v);
}
