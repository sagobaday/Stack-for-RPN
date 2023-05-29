public class Postfix {

	static int precedence(Character ch) {

		return switch (ch) {
			case '+', '-' -> 1;
			case '*', '/' -> 2;
			case '^' -> 3;
			default -> -1;
		};
	}
	public double evaluate (String pfx) throws StackUnderflowException {
		pfx = pfx.replaceAll("\\s", "");
		char[] pfxArray = pfx.toCharArray();
		Stack pfxStack = new StackAsList();
		//Stack operators = new StackAsList();
		Stack operands = new StackAsList();

		for (int i = pfxArray.length - 1; i >= 0; i--)
			pfxStack.push(pfxArray[i]);

		double firstOperand;
		double secondOperand;

		while (pfxStack.top() != null) {
			switch ((char) pfxStack.top()) {
				case '+', '-', '*', '/', '^' -> {
					char operator = (char) pfxStack.top();
					pfxStack.pop();
					secondOperand = (double) operands.top();
					operands.pop();
					firstOperand = (double) operands.top();
					operands.pop();

					switch (operator) {
						case '+' -> operands.push(firstOperand + secondOperand);
						case '-' -> operands.push(firstOperand - secondOperand);
						case '*' -> operands.push(firstOperand * secondOperand);
						case '/' -> operands.push(firstOperand / secondOperand);
						case '^' -> operands.push(Math.pow(firstOperand, secondOperand));
					}
				}
				case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
					operands.push((double) Character.getNumericValue((char) pfxStack.top()));
					pfxStack.pop();
				}
				default -> {
					System.out.println("Warning: Unsupported character skipped: " + pfxStack.top());
					pfxStack.pop();
				}
			}
		}

		return (double) operands.top();

	}

	public String infixToPostfix(String ifx) throws IllegalArgumentException, StackUnderflowException {
		if (ifx == null || ifx.isEmpty()) {
			return ifx;
		}

		ifx = ifx.replaceAll("\\s", "");
		char[] ifxArray = ifx.toCharArray();
		StringBuilder pfxExpression = new StringBuilder();
		Stack operatorStack = new StackAsList ();

		for (char ch : ifxArray) {
			if (Character.isDigit(ch)) {
				// Append operands directly to the postfix expression
				pfxExpression.append(ch);
			} else if (isOperator(ch)) {
				// Pop operators with higher precedence from the stack and append them to the postfix expression
				while (!operatorStack.isEmpty() && precedence(ch) <= precedence((Character) operatorStack.peek())) {
					pfxExpression.append(operatorStack.pop());
				}
				// Push the current operator onto the stack
				operatorStack.push(ch);
			} else if (ch == '(') {
				// Push opening parenthesis onto the stack
				operatorStack.push(ch);
			} else if (ch == ')') {
				// Pop operators from the stack and append them to the postfix expression until a matching opening parenthesis is found
				while (!operatorStack.isEmpty() && !operatorStack.peek().equals('(')) {
					pfxExpression.append(operatorStack.pop());
				}

				if (operatorStack.isEmpty() || !operatorStack.peek().equals('(')) {
					throw new IllegalArgumentException("Invalid infix expression: Unbalanced parentheses");
				}

				// Pop the matching opening parenthesis from the stack
				operatorStack.pop();
			} else {
				throw new IllegalArgumentException("Invalid infix expression: Invalid character '" + ch + "'");
			}
		}

		// Pop any remaining operators from the stack and append them to the postfix expression
		while (!operatorStack.isEmpty()) {
			char operator = (char) operatorStack.pop();

			if (operator == '(') {
				throw new IllegalArgumentException("Invalid infix expression: Unbalanced parentheses");
			}

			pfxExpression.append(operator);
		}

		return pfxExpression.toString();
	}



	private boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}
}