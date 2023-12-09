package code.day7;

import code.utils.FileReader;
import java.util.List;

public class Part1 {
  private static final FileReader fileReader = new FileReader();
  private static final List<String> inputs = fileReader.readFile("/Users/aylint1/IdeaProjects/me/advent of code 23/src/resources/day7/input.txt");
  private static final List<Character> cards = List.of( 'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2');

  public static void run() {
    for (String input : inputs) {
      System.out.println(input);
    }
  }
}