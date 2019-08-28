package scanner;

import java.util.ArrayList;
import java.util.List;

import symbols.Symbol; 
/**
 * The main entry point for lexical analysis of string expressions
 */
public class Scanner {
	private State state;				// State Pattern
	private String currentExpression;
	private List<Symbol> currentResult;	// Output (grows during scanning) 
	public Scanner() {
		this.currentExpression = basic.TextConstants.emptyString;
		this.currentResult = new ArrayList<Symbol>();
		this.state = new SelectionState(this);
	}
/**	
 * State pattern!
 */
	void setState(State selectionState){
		this.state = selectionState;
	}
/**
 * EFFECTS: Transformation of input string expr into sequence of symbols 
 */
	public List<Symbol> toSymbolSequence(String expr){
		this.currentExpression = expr;
		while(this.currentExpression.length()>0) { // Some character still to be scanned 
			this.state.scan(this.currentExpression.charAt(0));
		}
		this.state.onTermination();
		return currentResult; 
	}
	public List<Symbol> getList(){
		return this.currentResult;
	}
/**	
 * Reduces currentExpression by deleting first character, 
 * only if currentExpression is not empty
 */
	public void skip() {
		if(this.currentExpression.length()>0) 
			this.currentExpression = this.currentExpression.substring(1);
	}
	/**
	 * Operation to add a Symbol to currentResult
	 */
	public void addSymbol(Symbol symbol) {
		this.currentResult.add(symbol);
	}
}
