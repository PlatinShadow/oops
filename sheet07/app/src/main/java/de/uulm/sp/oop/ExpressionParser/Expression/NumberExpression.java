package de.uulm.sp.oop.ExpressionParser.Expression;

import de.uulm.sp.oop.ExpressionParser.Excpetions.NotANumberExpressionException;

public class NumberExpression extends Expression {
	private Number value;

	private NumberExpression(Number value) {
		super();
		this.value = value;
	}

	public static NumberExpression parse(String stringToParse) throws NotANumberExpressionException {
		Number value = null;

		try {
			if(stringToParse.contains(".")) {
				value = Double.parseDouble(stringToParse);
			} else {
				value = Integer.parseInt(stringToParse);
			}
		} catch (NumberFormatException ex) {
			throw new NotANumberExpressionException(stringToParse);
		}

		return new NumberExpression(value);
	}
	
	@Override
	public String toString() {
		return "NumberExpression [value=" + value + "]";
	}


}
