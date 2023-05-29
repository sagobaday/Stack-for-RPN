public interface Stack {
	
	// Pushes an item onto the top of this stack.
	default void push(Object o) {
	}

	// Removes the object at the top of this stack and returns that object as the value of this function.
	default void pop() throws StackUnderflowException {
	}

	// Look at the object at the top of this stack without removing it from the stack.
	default Object top() {
		return null;
	}

	// Tests if this stack is empty.
	default boolean isEmpty() {
		return false;
	}
    // knows what's on top without removing it
	// empties the stack
	default void empty() {
	}
	
	// read what is inside the nodes of the stack and then print the info inside as a string
	String toString();
}