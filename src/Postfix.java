public class Postfix {
    public double evaluate (String pfx) throws StackUnderflowException {
    	pfx = pfx.replaceAll("\\s", "");
    	char[] pfxArray = pfx.toCharArray();
    	Stack pfxStack = new StackAsList();
    	Stack operators = new StackAsList();
    	Stack operands = new StackAsList();
    	
    	for (int i = pfxArray.length - 1; i <= 0; i--)
    		pfxStack.push(pfxArray[i]);
    	
    	/*while (pfxStack.top() != null)
	    	switch ((char) pfxStack.top()) {
	    		case '+', '-', '*', '/', '^' -> {
	    			operators.push(pfxStack.top());
	    			pfxStack.pop();
	    		}
	    		case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
	    			operands.push(pfxStack.top());
	    			pfxStack.pop();
	    		}
	    	}*/
    	
    	while (pfxStack.top() != null)
	    	switch ((char) pfxStack.top()) {
	    		case '+', '-', '*', '/', '^' -> {
	    			operators.push(pfxStack.top());
	    			pfxStack.pop();
	    		}
	    		case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
	    			operands.push(pfxStack.top());
	    			pfxStack.pop();
	    		}
	    	}
    	
    	double firstOperand = Character.getNumericValue((char) operands.top());
    	operands.pop();
    	double secondOperand = Character.getNumericValue((char) operands.top());
    	operands.pop();
    	
    	while(!operators.isEmpty()) {
	    		switch ((char) operators.top()) {
	    		case '+' -> secondOperand = firstOperand + secondOperand;
	    		case '-' -> secondOperand = firstOperand - secondOperand;
	    		case '*' -> secondOperand = firstOperand * secondOperand;
	    		case '/' -> secondOperand = firstOperand / secondOperand;
	    		case '^' -> secondOperand = Math.pow(firstOperand, secondOperand);
	    	}
	    	
	    	operators.pop();
	    	
	    	if (!operands.isEmpty()) {
	    		firstOperand = Character.getNumericValue((char) operands.top());
		    	operands.pop();
	    	}
    	}
    	
    	return secondOperand;
    }
}