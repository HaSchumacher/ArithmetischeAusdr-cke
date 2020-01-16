package basic;

import java.util.HashMap;
import java.util.Map;

import symbols.DivOp;
import symbols.MultOp;
import symbols.PlusOp;
import symbols.Symbol;
import symbols.MinOp;

public class OpTable implements SymbolTable {
	/**Die Operator Tabelle kennt eine Hash-Map, die die Operationen,
	 * welche der Scanner erkennt, enthählt und die entsprechenden . **/
	private static final Map<Character, Symbol> opTable = new HashMap<Character, Symbol>(){
		private static final long serialVersionUID = 1;
	{
		put('+', PlusOp.getInstance());
		put('*', MultOp.getInstance());
		put('-', MinOp.getInstance());
		put('/', DivOp.getInstance());
		
	}
	
	};
	private static final Map<Symbol, String> stringOpTable = new HashMap<Symbol, String>(){
		private static final long serialVersionUID = 2;
		{
			put(PlusOp.getInstance(), TextConstants.Plusop);
			put(MultOp.getInstance(), TextConstants.Multop);
			put(MinOp.getInstance(), TextConstants.Minusop);
			put(DivOp.getInstance(), TextConstants.Divop);	
		}
	};
	
	private OpTable() {
		
	}
	public static boolean hasmapcontent(Character c) {
		return OpTable.opTable.containsKey(c);	
	}

	public static Symbol getSymbol(Character key) {
		return opTable.get(key);
		}
	public static String getStringRepresentation(Symbol s) {
		
		return stringOpTable.get(s);
			}
	};