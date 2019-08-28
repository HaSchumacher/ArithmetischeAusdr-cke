package Expression;

public class BracketExpression implements Faktor{
	private Expression expr;
	/**
	 *Ein Klammerausdruck umschlie�t eine Expression.
	 *Dabei muss jede ge�ffnete Klammer auch wieder geschlossen werden!  
	 **/

	@Override
	public Integer evaluate() {
		return this.evaluate();
	}	
	public String toString() {
		return "(" + expr.toString() + ")";
	}
}
