package BinaryOperation;

import Expression.Expression;
import Parser.SymbolParserException;

public interface BinaryOperation {
	public Integer calculate ( Expression x1, Expression x2) throws SymbolParserException;
		
	}
