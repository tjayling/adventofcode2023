package code.day1;

import java.util.List;
import code.utils.FileReader;

public class Part1 {
  private static final FileReader fileReader = new FileReader();
  private static final List<String> inputs = fileReader.readFile("/Users/aylint1/IdeaProjects/me/advent of code 23/src/resources/day1/input.txt");
  public static void run() {

    int result = 0;

    for (String input : inputs) {
      Character firstDigit = null;
      Character lastDigit = null;

      for (Character c : input.toCharArray()) {
        if (Character.isDigit(c)) {
          firstDigit = firstDigit == null ? c : firstDigit;
          lastDigit = c;
        }
      }

      System.out.println("Input: " + input);
      System.out.println("First digit: " + firstDigit);
      System.out.println("Last digit: " + lastDigit);

      String stringNum = String.valueOf(firstDigit) + lastDigit;
      result += Integer.parseInt(stringNum);
    }
    System.out.println("\nResult: " + result);
  }
}
