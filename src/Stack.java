public interface Stack {
	public default void push(Object e) {
	}

	public default void pop() {
	}

	public default Object top() {
		return null;
	}

	public default boolean isEmpty() {
		return false;
	}
	
	public default void empty() {
	}
}