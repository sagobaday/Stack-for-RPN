public class StackAsList implements Stack {
	LinkedList list = new LinkedList();
	
    @Override
    public void push(Object e) {

    }

    @Override
    public void pop() {

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

    }
}
