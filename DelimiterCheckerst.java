/*
Description: This program checks whether delimiters are properly
matched using a stack and displays the operations performed.

Programmed by: Clive Andrei C. Urgel, BSIT, 48143, Data Structure and Algorithms
Last Modified: October 19, 2026
Version: 1.0
Acknowledgements: Java documentation and ChatGpt.
Prompt: Help me create and analyze this code, if there's an error correct it and 
explain to me why. Also the function of push, peek, pop, isEmpty, 
and an execution trace with explanation.
*/
    
import java.util.Scanner;
import java.util.Stack;

public class DelimiterCheckerst {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        boolean valid = true;
        String reason = "";

        System.out.print("Enter delimiter sequence: ");
        String sequence = input.nextLine();

        for (int i = 0; i < sequence.length(); i++) {

            char ch = sequence.charAt(i);

            // Check opening delimiters
            if (ch == '(' || ch == '[' || ch == '{') {

                stack.push(ch);

                System.out.println("\nRead: " + ch);
                System.out.println("Operation: PUSH " + ch);
                System.out.println("Stack: " + stack);

            }

            // Check closing delimiters
            else if (ch == ')' || ch == ']' || ch == '}') {

                System.out.println("\nRead: " + ch);

                // Check if stack is empty
                if (stack.isEmpty()) {

                    valid = false;
                    reason = "Closing delimiter has no matching opening delimiter.";

                    System.out.println("Operation: INVALID");
                    System.out.println("Stack: " + stack);
                    break;
                }

                // Examine the top element
                char top = stack.peek();

                System.out.println("Operation: PEEK " + top);

                // Check matching pairs
                if ((top == '(' && ch == ')') ||
                    (top == '[' && ch == ']') ||
                    (top == '{' && ch == '}')) {

                    stack.pop();

                    System.out.println("Operation: POP " + top);
                    System.out.println("Stack: " + stack);

                } else {

                    valid = false;
                    reason = "Mismatched delimiters: " + top
                            + " does not match " + ch;

                    System.out.println("Operation: INVALID");
                    System.out.println("Stack: " + stack);
                    break;
                }
            }
        }

        // Check remaining opening delimiters
        if (valid && !stack.isEmpty()) {

            valid = false;
            reason = "Unmatched opening delimiter remains.";
        }

        // Display final result
        System.out.println("\n-------------------------");

        if (valid) {
            System.out.println("Result: Valid");
        } else {
            System.out.println("Result: Invalid");
            System.out.println("Reason: " + reason);
        }

        System.out.println("-------------------------");

        input.close();
    }
}