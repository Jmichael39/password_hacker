import java.util.Scanner;
import java.util.Stack;

class Main {
    static boolean isBalanced = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();

        if (string.isEmpty()) {
            System.out.println(isBalanced);
            System.exit(0);
        } else if (string.length() % 2 != 0) {
            System.out.println(isBalanced);
            System.exit(0);
        } else if (string.charAt(0) != '(' && string.charAt(0) != '[' && string.charAt(0) != '{') {
            System.out.println(isBalanced);
            System.exit(0);
        }

        isBalanced(string);
    }

    public static void isBalanced(String string){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            if (string.charAt(i) == '(' || string.charAt(i) == '[' || string.charAt(i) == '{') {
                stack.push(string.charAt(i));
            } else if (string.charAt(i) == ')' || string.charAt(i) == ']' || string.charAt(i) == '}') {
                if (!stack.isEmpty()) {
                    char topChar = stack.pop();
                    if (currentChar == ')' && topChar != '('
                            || currentChar == ']' && topChar != '['
                            || currentChar == '}' && topChar != '{') {
                        System.out.println(isBalanced);
                        System.exit(0);
                    }
                } else {
                    System.out.println(isBalanced);
                    System.exit(0);
                }
            }
        }

        if (stack.isEmpty()) {
            isBalanced = true;
            System.out.println(isBalanced);
        } else {
            System.out.println(isBalanced);
        }
    }
}