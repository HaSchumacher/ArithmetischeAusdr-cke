package modelAndView;

import Expression.Expression;
import Parser.ExpressionParserProxy;
import Parser.SymbolParserException;
import scanner.Scanner;
/**
 * Represents main use case of Arithmetic-Expression-Application
 */
public class Facade {
/**
 * Compiles the <userEnteredExpression> into syntax tree
 * Throws Exception, if syntax is incorrect
 */
	public Expression createExpression(String userEnteredExpression) throws SymbolParserException{
		Scanner scanner = new Scanner();
		ExpressionParserProxy parser = new ExpressionParserProxy();
		return parser.toExpression(scanner.toSymbolSequence(userEnteredExpression));
	}
/**
 * Compiles the <userEnteredExpression> into syntax tree and evaluates
 * Throws Exception, if syntax is incorrect or evaluation failed
 */	
	public Integer evaluateExpression(String userEnteredExpression) throws SymbolParserException{
		return this.createExpression(userEnteredExpression).evaluate();
	}
}




