package scanner;

import symbols.NaturalNumber;


/**
 * Digit Processing 
 * bleibt solange im DigitState bis dieser verlassen wird.
 * erst beim verlassen wird ein NaturalNumber Symbol erstellt. 
 * neue Zahlen werden im Scanzustand hinzugefügt.
 */
public class DigitState extends State {
    private Integer collectedDigits;
	public DigitState(Scanner myScanner){
		super(myScanner);
		this.collectedDigits = 0;
		}
		
	public void scan(Character c) {
		if(Character.isDigit(c)) {
		this.collectedDigits = 10*this.collectedDigits + Integer.parseInt(c.toString());
		myScanner.skip();
		} else {
			this.onTermination();
			super.setInitialState(myScanner);
		}
		
	}

	@Override
	public void onTermination() {
		myScanner.addSymbol(new NaturalNumber(collectedDigits));
	}
}
