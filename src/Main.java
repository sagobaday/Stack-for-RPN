public class Main {
	public static void main(String args[]) throws StackUnderflowException {
		/*Stack stack = new StackAsList();
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.pop();
		
		System.out.println(stack);*/
		
		Postfix pfx = new Postfix();
		System.out.println(pfx.evaluate("1 2 3 * +"));
	}
}