public interface Stack {

	// Pushes an item onto the top of this stack.
	public default void push(Object e) {
	}

	// Removes the object at the top of this stack and returns that object as the value of this function.
	public default void pop() {
	}

	// Looks at the object at the top of this stack without removing it from the stack.
	public default void peek() {
	}

	// Tests if this stack is empty.
	public default boolean empty() {
		return false;
	}

	// Returns the 1-based position where an object is on this stack.
	public default int search() {
		return 0;
	}
}