package basic;

import java.util.HashMap;
import java.util.Map;

import symbols.BracketClose;
import symbols.BracketOpen;
import symbols.Symbol;

public class BrTable implements SymbolTable {
	/**Die Bracket(Klammer) Tabelle kennt eine Hash-Map, die die Klammern,
	 * welche der Scanner erkennt, enth�hlt und die Entsprechenden Symbole bereith�lt. **/
	private static final Map<Character, Symbol> brTable = new HashMap<Character, Symbol>(){
		private static final long serialVersionUID = 1L;
	{
		put('(', BracketOpen.getInstance());
		put(')', BracketClose.getInstance());
	}};
	private BrTable() {
		
	}
	public static boolean hasmapcontent(Character c) {
		return BrTable.brTable.containsKey(c);	
	}

	public static Symbol getSymbol(Character key) {
		return brTable.get(key);
		}
	}
