import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "push" -> {
                    int value = Integer.parseInt(input[1]);
                    if (stack.isEmpty()) {
                        stack.push(value);
                    } else if (value > stack.peek()) {
                        stack.push(value);
                    } else {
                        stack.push(stack.peek());
                        stack.add(value);
                    }
                }
                case "pop" -> stack.pop();
                case "max" -> System.out.println(stack.peek());
                default -> System.out.println("There's been an error");
            }
        }
        sc.close();
    }
}