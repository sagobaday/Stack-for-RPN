public class Postfix {
	public double evaluate (String pfx) throws StackUnderflowException {
		pfx = pfx.replaceAll("\\s", "");
		char[] pfxArray = pfx.toCharArray();
		Stack pfxStack = new StackAsList();
		//Stack operators = new StackAsList();
		Stack operands = new StackAsList();

		for (int i = pfxArray.length - 1; i >= 0; i--)
			pfxStack.push(pfxArray[i]);
		
		double firstOperand = 0;
		double secondOperand = 0;

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
		
//		while(!operators.isEmpty()) {
//	    		switch ((char) operators.top()) {
//	    		case '+' -> secondOperand = firstOperand + secondOperand;
//	    		case '-' -> secondOperand = firstOperand - secondOperand;
//	    		case '*' -> secondOperand = firstOperand * secondOperand;
//	    		case '/' -> secondOperand = firstOperand / secondOperand;
//	    		case '^' -> secondOperand = Math.pow(firstOperand, secondOperand);
//	    	}
//
//	    	operators.pop();
//
//	    	if (!operands.isEmpty()) {
//	    		firstOperand = Character.getNumericValue((char) operands.top());
//		    	operands.pop();
//	    	}
//    	}
//		
//		while (pfxStack.top() != null)
//    	switch ((char) pfxStack.top()) {
//    		case '+', '-', '*', '/', '^' -> {
//    			operators.push(pfxStack.top());
//    			pfxStack.pop();
//    		}
//    		case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
//    			operands.push(pfxStack.top());
//    			pfxStack.pop();
//    		}
//    	}
	}
}