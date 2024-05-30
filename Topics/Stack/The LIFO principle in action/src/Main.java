import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>(sc.nextInt());
        while (sc.hasNext()) {
            stack.push(sc.nextInt());
        }
        stack.forEach(System.out::println);
    }
}