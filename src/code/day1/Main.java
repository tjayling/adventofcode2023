package code.day1;

import java.util.List;
import code.utils.FileReader;

public class Main {
  public static void main(String[] args) {
    FileReader fileReader = new FileReader();
    List<String> inputs = fileReader.readFile("/Users/aylint1/IdeaProjects/me/advent of code 23/src/resources/day1/input.txt");

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

      String stringNum = String.valueOf(firstDigit) + lastDigit;
      result += Integer.parseInt(stringNum);
    }
    System.out.println("\n\nResult: " + result);
  }
}
