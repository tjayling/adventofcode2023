package code.main;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
  private static final List<String> days = List.of("quit", "1.1", "2.1", "2.2", "7.1", "8.1");
  private static final String daysString;
  private static final Scanner scanner = new Scanner(System.in);

  static {
    StringBuilder sb = new StringBuilder();
    for (String day : days) {
      sb.append("\n- ").append(day);
    }
    daysString = sb.toString();
  }

  public static void main(String[] args) {
    String day = getDay(args);
    while (!Objects.equals(day, "Q")) {
      switch (day) {
        case "1.1" -> code.day1.Part1.run();
        case "2.1" -> code.day2.Part1.run();
        case "2.2" -> code.day2.Part2.run();
        case "7.1" -> code.day7.Part1.run();
        case "8.1" -> code.day8.Part1.run();
        case "quit" -> quit();
        default -> throw new IllegalArgumentException("Invalid day");
      }

      day = getDayFromInput();
    }
  }

  private static String getDay(String[] args) {
    if (getDayFromArgs(args) != null) {
      return getDayFromArgs(args);
    }
    return getDayFromInput();
  }

  private static String getDayFromArgs(String[] args) {
    if (args.length == 0 || !days.contains(args[0])) {
      System.out.println("Could not parse day from args: " + Arrays.toString(args) + ". ");
      return null;
    }
    return args[0];
  }

  private static String getDayFromInput() {
    String input = null;

    while (input == null || !days.contains(input)) {
      System.out.println("-----------------------------------------------------\nOptions: " + daysString + "\nAwaiting input:");
      input = scanner.nextLine();
    }

    return input;
  }

  private static void quit() {
    scanner.close();
    System.out.println("Quitting...");
    System.exit(0);
  }
}
