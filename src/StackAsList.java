public class StackAsList implements Stack {
	LinkedList list = new LinkedList();
	
    @Override
    public void push(Object o) {
    	list.add(o);
    }

    @Override
    public void pop() throws Exception {
    	if (!isEmpty()) {
    		list.removeLast();
    	}
    	else
    		throw new Exception();
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
}