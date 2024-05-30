// You can experiment here, it won’t be checked

import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    Stream.generate(Math::random)
            .limit(10)
            .forEach(System.out::println);
  }
}
