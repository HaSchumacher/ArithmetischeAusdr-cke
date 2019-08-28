package scanner;

import basic.BrTable;

/**
 * erstellt ein KlammerSymbol aus der Hash-Map, welche in Basic br.table liegt.
 * 
 **/
public class BracketState extends State{
	public BracketState(Scanner Scanboy) {
		super(Scanboy);
	}
	public static boolean hasmapcontent(Character c) {
		return BrTable.hasmapcontent(c);
	}
	@Override
	public void scan(Character c) {
		super.myScanner.skip();
		super.myScanner.addSymbol(BrTable.getSymbol(c));
		super.setInitialState(myScanner);
		
	}
	
}
