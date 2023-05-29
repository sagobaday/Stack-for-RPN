import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter an infix expression: ");
		String infixExpression = scanner.nextLine();

		// Create an instance of the Postfix class
		Postfix postfix = new Postfix();

		try {
			// Convert infix expression to postfix
			String postfixExpression = postfix.infixToPostfix(infixExpression);
			System.out.println("Postfix Expression: " + postfixExpression);

			// Evaluate the postfix expression
			double result = postfix.evaluate(postfixExpression);
			System.out.println("Evaluation Result: " + result);
		} catch (IllegalArgumentException | StackUnderflowException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
