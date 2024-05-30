import java.util.LinkedList;
import java.util.Queue;

class QueueUtils {
    public static int getLastNumber(Queue<Integer> target) {
        return new LinkedList<>(target).getLast();
    }
}