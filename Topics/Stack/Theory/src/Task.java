// You can experiment here, it won’t be checked

import java.util.Random;
import java.util.stream.Stream;

public class Task {
  public static void main(String[] args) {
    Stream.generate(PassGenerator::run).limit(5).forEach(System.out::println);
  }
}

class PassGenerator {

  public static String run() {
    String alphabet = "#abcdefghilkmnopqrstuvwxyz";
    String numbers = "0123456789";
    StringBuilder stringBuilder = new StringBuilder();
    Random random = new Random();
    for (int i = 4; i < 36; i++) {
      stringBuilder.append(alphabet.charAt(random.nextInt(alphabet.length())))
              .append(numbers.charAt(random.nextInt(numbers.length())));
    }
    return stringBuilder.toString();
  }
}