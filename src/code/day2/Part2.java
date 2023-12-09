package code.day2;

import code.utils.FileReader;
import java.util.List;

public class Part2 {
  private static final FileReader fileReader = new FileReader();
  private static final List<String> inputs = fileReader.readFile("/Users/aylint1/IdeaProjects/me/advent of code 23/src/resources/day2/input.txt");

  public static void run() {
    System.out.println("Result: " + getPower());
  }

  private static int getPower() {
    int result = 0;
    for (String game : inputs) {
      result += getGamePower(game);

      System.out.println(game);
      System.out.println("Power: " + getGamePower(game));
    }

    return result;
  }

  private static int getGamePower(String game) {
    String[] rounds = game.split(": ")[1].split("; ");

    int redMax = 1;
    int greenMax = 1;
    int blueMax = 1;

    for (String round : rounds) {
      for (String cube : round.split(", ")) {
        int value = Integer.parseInt(cube.split(" ")[0]);
        String colour = cube.split(" ")[1];
        switch (colour) {
          case ("red") -> redMax = Math.max(value, redMax);
          case ("green") -> greenMax = Math.max(value, greenMax);
          case ("blue") -> blueMax = Math.max(value, blueMax);
        }
      }
    }

    return redMax * greenMax * blueMax;
  }
}
