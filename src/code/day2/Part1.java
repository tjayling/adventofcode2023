package code.day2;

import code.utils.FileReader;
import java.util.List;

public class Part1 {

  private final static FileReader fileReader = new FileReader();
  private final static List<String> inputs = fileReader.readFile("/Users/aylint1/IdeaProjects/me/advent of code 23/src/resources/day2/input.txt");
  private final static int maxRed = 12;
  private final static int maxGreen = 13;
  private final static int maxBlue = 14;

  public static void run() {

    int result = 0;

    for (String game : inputs) {
      if (isGameValid(game)) {
        int gameId = Integer.parseInt(game.split(":")[0].split(" ")[1]);
        System.out.println("Game is valid: " + game);
        System.out.println("Game ID is: " + gameId);
        result += gameId;
      } else {
        System.out.println("Game is invalid: " + game);
      }
    }

    System.out.println("Result: " + result);
  }

  private static boolean isGameValid(String game) {
    String[] rounds = game.split(": ")[1].split("; ");

    for (String round : rounds) {
      if (!isRoundValid(round)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isRoundValid(String round) {
    for (String cubes : round.split(", ")) {
      String value = cubes.split(" ")[0];
      String colour = cubes.split(" ")[1];
      if (!isDrawValid(value, colour)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isDrawValid(String value, String colour) {
    return switch (colour) {
      case "red" -> Integer.parseInt(value) <= maxRed;
      case "green" -> Integer.parseInt(value) <= maxGreen;
      case "blue" -> Integer.parseInt(value) <= maxBlue;
      default -> false;
    };
  }
}