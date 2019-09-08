package modelViewController;

import exception.CalculationException;
import expressions.Expression;
import parser.ExpressionParserInterface;
import parser.ExpressionParserProxy;
import parser.exception.ParserException;
import scanner.Scanner;
/**
 * Represents main use case of Arithmetic-Expression-Application
 */
public class Facade {
/**
 * Compiles the <userEnteredExpression> into syntax tree
 * Throws Exception, if syntax is incorrect
 */
	public Expression createExpression(String userEnteredExpression) throws ParserException{
		Scanner scanner = new Scanner();
		ExpressionParserInterface parser = new ExpressionParserProxy();
		return parser.toExpression(scanner.toSymbolSequence(userEnteredExpression));
	}
/**
 * Compiles the <userEnteredExpression> into syntax tree and evaluates
 * Throws Exception, if syntax is incorrect or evaluation failed
 */	
	public Integer evaluateExpression(String userEnteredExpression) throws ParserException, CalculationException{
		return this.createExpression(userEnteredExpression).evaluate();
	}
}




