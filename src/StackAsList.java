public class StackAsList implements Stack {
	LinkedList list = new LinkedList();
	
    @Override
    public void push(Object o) {
    	list.add(o);
    }

    @Override
    public Object pop() throws StackUnderflowException {
    	if (!isEmpty()) {
    		list.removeLast();
    	}
    	else
    		throw new StackUnderflowException();
		return null;
	}

    @Override
    public Object top() {
        return list.getLast();
    }
    
    @Override
    public boolean isEmpty() {
    	return (list.getLast() == null);
    }

    @Override
    public void empty() {
    	list.clear();
    }

	@Override
	public Object peek() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException("Stack is empty");
		}
		return list.getLast();
	}


	@Override
    public String toString() {
    	if (list.toArray() != null) {
    		Object[] listArray = list.toArray();
        	String str = "";
        	
        	for (int i = 0; i < listArray.length; i++) {
        		if (i == listArray.length  - 1)
        			str += listArray[i];
        		else
        			str += listArray[i] + ", ";
        	}
        	
        	return str;
    	} else
    		return "Stack is empty.";
    }
}
