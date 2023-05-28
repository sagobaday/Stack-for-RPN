public class Main {
	public static void main(String args[]) throws Exception {
		Stack stack = new StackAsList();
		
		stack.push("1");
		stack.push("2");
		stack.push("3");
		//stack.empty();
		System.out.println(stack);
	}
}